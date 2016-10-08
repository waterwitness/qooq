package com.facebook.imagepipeline.animated.impl;

import android.app.ActivityManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import bolts.Continuation;
import bolts.Task;
import com.facebook.common.executors.SerialExecutorService;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.common.time.MonotonicClock;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableCachingBackend;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo.DisposalMethod;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableOptions;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.animated.base.DelegatingAnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.util.AnimatedDrawableUtil;
import fb.support.v4.util.SparseArrayCompat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;

public class AnimatedDrawableCachingBackendImpl
  extends DelegatingAnimatedDrawableBackend
  implements AnimatedDrawableCachingBackend
{
  private static final int PREFETCH_FRAMES = 3;
  private static final Class<?> TAG = AnimatedDrawableCachingBackendImpl.class;
  private static final AtomicInteger sTotalBitmaps = new AtomicInteger();
  private final ActivityManager mActivityManager;
  private final AnimatedDrawableBackend mAnimatedDrawableBackend;
  private final AnimatedDrawableOptions mAnimatedDrawableOptions;
  private final AnimatedDrawableUtil mAnimatedDrawableUtil;
  private final AnimatedImageCompositor mAnimatedImageCompositor;
  private final double mApproxKiloBytesToHoldAllFrames;
  @GuardedBy("this")
  private final WhatToKeepCachedArray mBitmapsToKeepCached;
  @GuardedBy("this")
  private final SparseArrayCompat<CloseableReference<Bitmap>> mCachedBitmaps;
  @GuardedBy("ui-thread")
  private int mCurrentFrameIndex;
  @GuardedBy("this")
  private final SparseArrayCompat<Task<Object>> mDecodesInFlight;
  private final SerialExecutorService mExecutorService;
  @GuardedBy("this")
  private final List<Bitmap> mFreeBitmaps;
  private final double mMaximumKiloBytes;
  private final MonotonicClock mMonotonicClock;
  private final ResourceReleaser<Bitmap> mResourceReleaserForBitmaps;
  
  public AnimatedDrawableCachingBackendImpl(SerialExecutorService paramSerialExecutorService, ActivityManager paramActivityManager, AnimatedDrawableUtil paramAnimatedDrawableUtil, MonotonicClock paramMonotonicClock, AnimatedDrawableBackend paramAnimatedDrawableBackend, AnimatedDrawableOptions paramAnimatedDrawableOptions)
  {
    super(paramAnimatedDrawableBackend);
    this.mExecutorService = paramSerialExecutorService;
    this.mActivityManager = paramActivityManager;
    this.mAnimatedDrawableUtil = paramAnimatedDrawableUtil;
    this.mMonotonicClock = paramMonotonicClock;
    this.mAnimatedDrawableBackend = paramAnimatedDrawableBackend;
    this.mAnimatedDrawableOptions = paramAnimatedDrawableOptions;
    if (paramAnimatedDrawableOptions.maximumBytes >= 0) {}
    for (int i = paramAnimatedDrawableOptions.maximumBytes / 1024;; i = getDefaultMaxBytes(paramActivityManager) / 1024)
    {
      this.mMaximumKiloBytes = i;
      this.mAnimatedImageCompositor = new AnimatedImageCompositor(paramAnimatedDrawableBackend, new AnimatedImageCompositor.Callback()
      {
        public CloseableReference<Bitmap> getCachedBitmap(int paramAnonymousInt)
        {
          return AnimatedDrawableCachingBackendImpl.this.getCachedOrPredecodedFrame(paramAnonymousInt);
        }
        
        public void onIntermediateResult(int paramAnonymousInt, Bitmap paramAnonymousBitmap)
        {
          AnimatedDrawableCachingBackendImpl.this.maybeCacheBitmapDuringRender(paramAnonymousInt, paramAnonymousBitmap);
        }
      });
      this.mResourceReleaserForBitmaps = new ResourceReleaser()
      {
        public void release(Bitmap paramAnonymousBitmap)
        {
          AnimatedDrawableCachingBackendImpl.this.releaseBitmapInternal(paramAnonymousBitmap);
        }
      };
      this.mFreeBitmaps = new ArrayList();
      this.mDecodesInFlight = new SparseArrayCompat(10);
      this.mCachedBitmaps = new SparseArrayCompat(10);
      this.mBitmapsToKeepCached = new WhatToKeepCachedArray(this.mAnimatedDrawableBackend.getFrameCount());
      this.mApproxKiloBytesToHoldAllFrames = (this.mAnimatedDrawableBackend.getRenderedWidth() * this.mAnimatedDrawableBackend.getRenderedHeight() / 1024 * this.mAnimatedDrawableBackend.getFrameCount() * 4);
      return;
    }
  }
  
  private void cancelFuturesOutsideOfRange(int paramInt1, int paramInt2)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        int j = this.mDecodesInFlight.size();
        if (i >= j) {
          return;
        }
        if (AnimatedDrawableUtil.isOutsideRange(paramInt1, paramInt2, this.mDecodesInFlight.keyAt(i)))
        {
          Task localTask = (Task)this.mDecodesInFlight.valueAt(i);
          this.mDecodesInFlight.removeAt(i);
        }
        else
        {
          i += 1;
        }
      }
      finally {}
    }
  }
  
  private void copyAndCacheBitmapDuringRendering(int paramInt, Bitmap paramBitmap)
  {
    CloseableReference localCloseableReference = obtainBitmapInternal();
    try
    {
      Canvas localCanvas = new Canvas((Bitmap)localCloseableReference.get());
      localCanvas.drawColor(0, PorterDuff.Mode.SRC);
      localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, null);
      maybeCacheRenderedBitmap(paramInt, localCloseableReference);
      return;
    }
    finally
    {
      localCloseableReference.close();
    }
  }
  
  private Bitmap createNewBitmap()
  {
    FLog.v(TAG, "Creating new bitmap");
    sTotalBitmaps.incrementAndGet();
    FLog.v(TAG, "Total bitmaps: %d", Integer.valueOf(sTotalBitmaps.get()));
    return Bitmap.createBitmap(this.mAnimatedDrawableBackend.getRenderedWidth(), this.mAnimatedDrawableBackend.getRenderedHeight(), Bitmap.Config.ARGB_8888);
  }
  
  private void doPrefetch(int paramInt1, int paramInt2)
  {
    int i = 0;
    for (;;)
    {
      if (i >= paramInt2) {
        return;
      }
      try
      {
        final int j = (paramInt1 + i) % this.mAnimatedDrawableBackend.getFrameCount();
        boolean bool = hasCachedOrPredecodedFrame(j);
        final Task localTask = (Task)this.mDecodesInFlight.get(j);
        if ((!bool) && (localTask == null))
        {
          localTask = Task.call(new Callable()
          {
            public Object call()
            {
              AnimatedDrawableCachingBackendImpl.this.runPrefetch(j);
              return null;
            }
          }, this.mExecutorService);
          this.mDecodesInFlight.put(j, localTask);
          localTask.continueWith(new Continuation()
          {
            public Object then(Task<Object> paramAnonymousTask)
              throws Exception
            {
              AnimatedDrawableCachingBackendImpl.this.onFutureFinished(localTask, j);
              return null;
            }
          });
        }
        i += 1;
      }
      finally {}
    }
  }
  
  private void dropBitmapsThatShouldNotBeCached()
  {
    int i = 0;
    for (;;)
    {
      try
      {
        int j = this.mCachedBitmaps.size();
        if (i >= j) {
          return;
        }
        j = this.mCachedBitmaps.keyAt(i);
        if (!this.mBitmapsToKeepCached.get(j))
        {
          CloseableReference localCloseableReference = (CloseableReference)this.mCachedBitmaps.valueAt(i);
          this.mCachedBitmaps.removeAt(i);
          localCloseableReference.close();
        }
        else
        {
          i += 1;
        }
      }
      finally {}
    }
  }
  
  /* Error */
  private CloseableReference<Bitmap> getBitmapForFrameInternal(int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: aload_0
    //   4: getfield 81	com/facebook/imagepipeline/animated/impl/AnimatedDrawableCachingBackendImpl:mMonotonicClock	Lcom/facebook/common/time/MonotonicClock;
    //   7: invokeinterface 298 1 0
    //   12: lstore 7
    //   14: iload 6
    //   16: istore 5
    //   18: aload_0
    //   19: monitorenter
    //   20: aload_0
    //   21: getfield 130	com/facebook/imagepipeline/animated/impl/AnimatedDrawableCachingBackendImpl:mBitmapsToKeepCached	Lcom/facebook/imagepipeline/animated/impl/WhatToKeepCachedArray;
    //   24: iload_1
    //   25: iconst_1
    //   26: invokevirtual 302	com/facebook/imagepipeline/animated/impl/WhatToKeepCachedArray:set	(IZ)V
    //   29: aload_0
    //   30: iload_1
    //   31: invokespecial 154	com/facebook/imagepipeline/animated/impl/AnimatedDrawableCachingBackendImpl:getCachedOrPredecodedFrame	(I)Lcom/facebook/common/references/CloseableReference;
    //   34: astore 4
    //   36: aload 4
    //   38: ifnull +76 -> 114
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_0
    //   44: getfield 81	com/facebook/imagepipeline/animated/impl/AnimatedDrawableCachingBackendImpl:mMonotonicClock	Lcom/facebook/common/time/MonotonicClock;
    //   47: invokeinterface 298 1 0
    //   52: lload 7
    //   54: lsub
    //   55: lstore 7
    //   57: lload 7
    //   59: ldc2_w 303
    //   62: lcmp
    //   63: ifle +30 -> 93
    //   66: iconst_0
    //   67: ifeq +29 -> 96
    //   70: ldc_w 306
    //   73: astore_3
    //   74: getstatic 61	com/facebook/imagepipeline/animated/impl/AnimatedDrawableCachingBackendImpl:TAG	Ljava/lang/Class;
    //   77: ldc_w 308
    //   80: iload_1
    //   81: invokestatic 251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   84: lload 7
    //   86: invokestatic 313	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   89: aload_3
    //   90: invokestatic 316	com/facebook/common/logging/FLog:v	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   93: aload 4
    //   95: areturn
    //   96: iconst_0
    //   97: ifeq +10 -> 107
    //   100: ldc_w 318
    //   103: astore_3
    //   104: goto -30 -> 74
    //   107: ldc_w 320
    //   110: astore_3
    //   111: goto -37 -> 74
    //   114: aload_0
    //   115: monitorexit
    //   116: iload_2
    //   117: ifeq +203 -> 320
    //   120: iconst_1
    //   121: istore 6
    //   123: iload 6
    //   125: istore 5
    //   127: aload_0
    //   128: invokespecial 194	com/facebook/imagepipeline/animated/impl/AnimatedDrawableCachingBackendImpl:obtainBitmapInternal	()Lcom/facebook/common/references/CloseableReference;
    //   131: astore_3
    //   132: aload_0
    //   133: getfield 102	com/facebook/imagepipeline/animated/impl/AnimatedDrawableCachingBackendImpl:mAnimatedImageCompositor	Lcom/facebook/imagepipeline/animated/impl/AnimatedImageCompositor;
    //   136: iload_1
    //   137: aload_3
    //   138: invokevirtual 202	com/facebook/common/references/CloseableReference:get	()Ljava/lang/Object;
    //   141: checkcast 204	android/graphics/Bitmap
    //   144: invokevirtual 323	com/facebook/imagepipeline/animated/impl/AnimatedImageCompositor:renderFrame	(ILandroid/graphics/Bitmap;)V
    //   147: aload_0
    //   148: iload_1
    //   149: aload_3
    //   150: invokespecial 225	com/facebook/imagepipeline/animated/impl/AnimatedDrawableCachingBackendImpl:maybeCacheRenderedBitmap	(ILcom/facebook/common/references/CloseableReference;)V
    //   153: aload_3
    //   154: invokevirtual 326	com/facebook/common/references/CloseableReference:clone	()Lcom/facebook/common/references/CloseableReference;
    //   157: astore 4
    //   159: iload 6
    //   161: istore 5
    //   163: aload_3
    //   164: invokevirtual 228	com/facebook/common/references/CloseableReference:close	()V
    //   167: aload_0
    //   168: getfield 81	com/facebook/imagepipeline/animated/impl/AnimatedDrawableCachingBackendImpl:mMonotonicClock	Lcom/facebook/common/time/MonotonicClock;
    //   171: invokeinterface 298 1 0
    //   176: lload 7
    //   178: lsub
    //   179: lstore 7
    //   181: lload 7
    //   183: ldc2_w 303
    //   186: lcmp
    //   187: ifle +30 -> 217
    //   190: iconst_1
    //   191: ifeq +94 -> 285
    //   194: ldc_w 306
    //   197: astore_3
    //   198: getstatic 61	com/facebook/imagepipeline/animated/impl/AnimatedDrawableCachingBackendImpl:TAG	Ljava/lang/Class;
    //   201: ldc_w 308
    //   204: iload_1
    //   205: invokestatic 251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   208: lload 7
    //   210: invokestatic 313	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   213: aload_3
    //   214: invokestatic 316	com/facebook/common/logging/FLog:v	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   217: aload 4
    //   219: areturn
    //   220: astore_3
    //   221: aload_0
    //   222: monitorexit
    //   223: iload 6
    //   225: istore 5
    //   227: aload_3
    //   228: athrow
    //   229: astore 4
    //   231: aload_0
    //   232: getfield 81	com/facebook/imagepipeline/animated/impl/AnimatedDrawableCachingBackendImpl:mMonotonicClock	Lcom/facebook/common/time/MonotonicClock;
    //   235: invokeinterface 298 1 0
    //   240: lload 7
    //   242: lsub
    //   243: lstore 7
    //   245: lload 7
    //   247: ldc2_w 303
    //   250: lcmp
    //   251: ifle +31 -> 282
    //   254: iload 5
    //   256: ifeq +134 -> 390
    //   259: ldc_w 306
    //   262: astore_3
    //   263: getstatic 61	com/facebook/imagepipeline/animated/impl/AnimatedDrawableCachingBackendImpl:TAG	Ljava/lang/Class;
    //   266: ldc_w 308
    //   269: iload_1
    //   270: invokestatic 251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   273: lload 7
    //   275: invokestatic 313	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   278: aload_3
    //   279: invokestatic 316	com/facebook/common/logging/FLog:v	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   282: aload 4
    //   284: athrow
    //   285: iconst_0
    //   286: ifeq +10 -> 296
    //   289: ldc_w 318
    //   292: astore_3
    //   293: goto -95 -> 198
    //   296: ldc_w 320
    //   299: astore_3
    //   300: goto -102 -> 198
    //   303: astore 4
    //   305: iload 6
    //   307: istore 5
    //   309: aload_3
    //   310: invokevirtual 228	com/facebook/common/references/CloseableReference:close	()V
    //   313: iload 6
    //   315: istore 5
    //   317: aload 4
    //   319: athrow
    //   320: aload_0
    //   321: getfield 81	com/facebook/imagepipeline/animated/impl/AnimatedDrawableCachingBackendImpl:mMonotonicClock	Lcom/facebook/common/time/MonotonicClock;
    //   324: invokeinterface 298 1 0
    //   329: lload 7
    //   331: lsub
    //   332: lstore 7
    //   334: lload 7
    //   336: ldc2_w 303
    //   339: lcmp
    //   340: ifle +30 -> 370
    //   343: iconst_0
    //   344: ifeq +28 -> 372
    //   347: ldc_w 306
    //   350: astore_3
    //   351: getstatic 61	com/facebook/imagepipeline/animated/impl/AnimatedDrawableCachingBackendImpl:TAG	Ljava/lang/Class;
    //   354: ldc_w 308
    //   357: iload_1
    //   358: invokestatic 251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   361: lload 7
    //   363: invokestatic 313	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   366: aload_3
    //   367: invokestatic 316	com/facebook/common/logging/FLog:v	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   370: aconst_null
    //   371: areturn
    //   372: iconst_1
    //   373: ifeq +10 -> 383
    //   376: ldc_w 318
    //   379: astore_3
    //   380: goto -29 -> 351
    //   383: ldc_w 320
    //   386: astore_3
    //   387: goto -36 -> 351
    //   390: iconst_0
    //   391: ifeq +10 -> 401
    //   394: ldc_w 318
    //   397: astore_3
    //   398: goto -135 -> 263
    //   401: ldc_w 320
    //   404: astore_3
    //   405: goto -142 -> 263
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	408	0	this	AnimatedDrawableCachingBackendImpl
    //   0	408	1	paramInt	int
    //   0	408	2	paramBoolean	boolean
    //   73	141	3	localObject1	Object
    //   220	8	3	localObject2	Object
    //   262	143	3	str	String
    //   34	184	4	localCloseableReference	CloseableReference
    //   229	54	4	localObject3	Object
    //   303	15	4	localObject4	Object
    //   16	300	5	i	int
    //   1	313	6	j	int
    //   12	350	7	l	long
    // Exception table:
    //   from	to	target	type
    //   20	36	220	finally
    //   41	43	220	finally
    //   114	116	220	finally
    //   221	223	220	finally
    //   18	20	229	finally
    //   127	132	229	finally
    //   163	167	229	finally
    //   227	229	229	finally
    //   309	313	229	finally
    //   317	320	229	finally
    //   132	159	303	finally
  }
  
  private CloseableReference<Bitmap> getCachedOrPredecodedFrame(int paramInt)
  {
    try
    {
      CloseableReference localCloseableReference2 = CloseableReference.cloneOrNull((CloseableReference)this.mCachedBitmaps.get(paramInt));
      CloseableReference localCloseableReference1 = localCloseableReference2;
      if (localCloseableReference2 == null) {
        localCloseableReference1 = this.mAnimatedDrawableBackend.getPreDecodedFrame(paramInt);
      }
      return localCloseableReference1;
    }
    finally {}
  }
  
  private static int getDefaultMaxBytes(ActivityManager paramActivityManager)
  {
    if (paramActivityManager.getMemoryClass() > 32) {
      return 5242880;
    }
    return 3145728;
  }
  
  /* Error */
  private boolean hasCachedOrPredecodedFrame(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 119	com/facebook/imagepipeline/animated/impl/AnimatedDrawableCachingBackendImpl:mCachedBitmaps	Lfb/support/v4/util/SparseArrayCompat;
    //   6: iload_1
    //   7: invokevirtual 271	fb/support/v4/util/SparseArrayCompat:get	(I)Ljava/lang/Object;
    //   10: ifnonnull +24 -> 34
    //   13: aload_0
    //   14: getfield 83	com/facebook/imagepipeline/animated/impl/AnimatedDrawableCachingBackendImpl:mAnimatedDrawableBackend	Lcom/facebook/imagepipeline/animated/base/AnimatedDrawableBackend;
    //   17: iload_1
    //   18: invokeinterface 346 2 0
    //   23: istore_3
    //   24: iload_3
    //   25: ifne +9 -> 34
    //   28: iconst_0
    //   29: istore_3
    //   30: aload_0
    //   31: monitorexit
    //   32: iload_3
    //   33: ireturn
    //   34: iconst_1
    //   35: istore_3
    //   36: goto -6 -> 30
    //   39: astore_2
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_2
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	AnimatedDrawableCachingBackendImpl
    //   0	44	1	paramInt	int
    //   39	4	2	localObject	Object
    //   23	13	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	24	39	finally
  }
  
  /* Error */
  private void maybeCacheBitmapDuringRender(int paramInt, Bitmap paramBitmap)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 130	com/facebook/imagepipeline/animated/impl/AnimatedDrawableCachingBackendImpl:mBitmapsToKeepCached	Lcom/facebook/imagepipeline/animated/impl/WhatToKeepCachedArray;
    //   8: iload_1
    //   9: invokevirtual 290	com/facebook/imagepipeline/animated/impl/WhatToKeepCachedArray:get	(I)Z
    //   12: ifeq +16 -> 28
    //   15: aload_0
    //   16: getfield 119	com/facebook/imagepipeline/animated/impl/AnimatedDrawableCachingBackendImpl:mCachedBitmaps	Lfb/support/v4/util/SparseArrayCompat;
    //   19: iload_1
    //   20: invokevirtual 271	fb/support/v4/util/SparseArrayCompat:get	(I)Ljava/lang/Object;
    //   23: ifnonnull +18 -> 41
    //   26: iconst_1
    //   27: istore_3
    //   28: aload_0
    //   29: monitorexit
    //   30: iload_3
    //   31: ifeq +9 -> 40
    //   34: aload_0
    //   35: iload_1
    //   36: aload_2
    //   37: invokespecial 348	com/facebook/imagepipeline/animated/impl/AnimatedDrawableCachingBackendImpl:copyAndCacheBitmapDuringRendering	(ILandroid/graphics/Bitmap;)V
    //   40: return
    //   41: iconst_0
    //   42: istore_3
    //   43: goto -15 -> 28
    //   46: astore_2
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_2
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	AnimatedDrawableCachingBackendImpl
    //   0	51	1	paramInt	int
    //   0	51	2	paramBitmap	Bitmap
    //   1	42	3	i	int
    // Exception table:
    //   from	to	target	type
    //   4	26	46	finally
    //   28	30	46	finally
    //   47	49	46	finally
  }
  
  /* Error */
  private void maybeCacheRenderedBitmap(int paramInt, CloseableReference<Bitmap> paramCloseableReference)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 130	com/facebook/imagepipeline/animated/impl/AnimatedDrawableCachingBackendImpl:mBitmapsToKeepCached	Lcom/facebook/imagepipeline/animated/impl/WhatToKeepCachedArray;
    //   6: iload_1
    //   7: invokevirtual 290	com/facebook/imagepipeline/animated/impl/WhatToKeepCachedArray:get	(I)Z
    //   10: istore 4
    //   12: iload 4
    //   14: ifne +6 -> 20
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: aload_0
    //   21: getfield 119	com/facebook/imagepipeline/animated/impl/AnimatedDrawableCachingBackendImpl:mCachedBitmaps	Lfb/support/v4/util/SparseArrayCompat;
    //   24: iload_1
    //   25: invokevirtual 351	fb/support/v4/util/SparseArrayCompat:indexOfKey	(I)I
    //   28: istore_3
    //   29: iload_3
    //   30: iflt +25 -> 55
    //   33: aload_0
    //   34: getfield 119	com/facebook/imagepipeline/animated/impl/AnimatedDrawableCachingBackendImpl:mCachedBitmaps	Lfb/support/v4/util/SparseArrayCompat;
    //   37: iload_3
    //   38: invokevirtual 184	fb/support/v4/util/SparseArrayCompat:valueAt	(I)Ljava/lang/Object;
    //   41: checkcast 198	com/facebook/common/references/CloseableReference
    //   44: invokevirtual 228	com/facebook/common/references/CloseableReference:close	()V
    //   47: aload_0
    //   48: getfield 119	com/facebook/imagepipeline/animated/impl/AnimatedDrawableCachingBackendImpl:mCachedBitmaps	Lfb/support/v4/util/SparseArrayCompat;
    //   51: iload_3
    //   52: invokevirtual 189	fb/support/v4/util/SparseArrayCompat:removeAt	(I)V
    //   55: aload_0
    //   56: getfield 119	com/facebook/imagepipeline/animated/impl/AnimatedDrawableCachingBackendImpl:mCachedBitmaps	Lfb/support/v4/util/SparseArrayCompat;
    //   59: iload_1
    //   60: aload_2
    //   61: invokevirtual 326	com/facebook/common/references/CloseableReference:clone	()Lcom/facebook/common/references/CloseableReference;
    //   64: invokevirtual 281	fb/support/v4/util/SparseArrayCompat:put	(ILjava/lang/Object;)V
    //   67: goto -50 -> 17
    //   70: astore_2
    //   71: aload_0
    //   72: monitorexit
    //   73: aload_2
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	AnimatedDrawableCachingBackendImpl
    //   0	75	1	paramInt	int
    //   0	75	2	paramCloseableReference	CloseableReference<Bitmap>
    //   28	24	3	i	int
    //   10	3	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	12	70	finally
    //   20	29	70	finally
    //   33	55	70	finally
    //   55	67	70	finally
  }
  
  private CloseableReference<Bitmap> obtainBitmapInternal()
  {
    for (;;)
    {
      try
      {
        long l1 = System.nanoTime();
        long l2 = l1 + TimeUnit.NANOSECONDS.convert(20L, TimeUnit.MILLISECONDS);
        if ((!this.mFreeBitmaps.isEmpty()) || (l1 >= l2))
        {
          if (this.mFreeBitmaps.isEmpty())
          {
            Bitmap localBitmap1 = createNewBitmap();
            return CloseableReference.of(localBitmap1, this.mResourceReleaserForBitmaps);
          }
        }
        else {
          try
          {
            TimeUnit.NANOSECONDS.timedWait(this, l2 - l1);
            l1 = System.nanoTime();
          }
          catch (InterruptedException localInterruptedException)
          {
            Thread.currentThread().interrupt();
            throw new RuntimeException(localInterruptedException);
          }
        }
        Bitmap localBitmap2 = (Bitmap)this.mFreeBitmaps.remove(this.mFreeBitmaps.size() - 1);
      }
      finally {}
    }
  }
  
  private void onFutureFinished(Task<?> paramTask, int paramInt)
  {
    try
    {
      int i = this.mDecodesInFlight.indexOfKey(paramInt);
      if ((i >= 0) && ((Task)this.mDecodesInFlight.valueAt(i) == paramTask))
      {
        this.mDecodesInFlight.removeAt(i);
        if (paramTask.getError() != null) {
          FLog.v(TAG, paramTask.getError(), "Failed to render frame %d", new Object[] { Integer.valueOf(paramInt) });
        }
      }
      return;
    }
    finally {}
  }
  
  private void runPrefetch(int paramInt)
  {
    try
    {
      if (!this.mBitmapsToKeepCached.get(paramInt)) {
        return;
      }
      if (hasCachedOrPredecodedFrame(paramInt)) {
        return;
      }
    }
    finally {}
    CloseableReference localCloseableReference1 = this.mAnimatedDrawableBackend.getPreDecodedFrame(paramInt);
    if (localCloseableReference1 != null) {}
    try
    {
      maybeCacheRenderedBitmap(paramInt, localCloseableReference1);
      CloseableReference.closeSafely(localCloseableReference1);
      return;
      localCloseableReference2 = obtainBitmapInternal();
    }
    finally
    {
      try
      {
        for (;;)
        {
          CloseableReference localCloseableReference2;
          this.mAnimatedImageCompositor.renderFrame(paramInt, (Bitmap)localCloseableReference2.get());
          maybeCacheRenderedBitmap(paramInt, localCloseableReference2);
          FLog.v(TAG, "Prefetch rendered frame %d", Integer.valueOf(paramInt));
          localCloseableReference2.close();
        }
      }
      finally
      {
        ((CloseableReference)localObject2).close();
      }
      localObject2 = finally;
      CloseableReference.closeSafely(localCloseableReference1);
    }
  }
  
  private void schedulePrefetches()
  {
    int m = 1;
    for (;;)
    {
      try
      {
        if (this.mAnimatedDrawableBackend.getFrameInfo(this.mCurrentFrameIndex).disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS)
        {
          i = 1;
          int k = this.mCurrentFrameIndex;
          if (i != 0)
          {
            j = 1;
            k = Math.max(0, k - j);
            if (!this.mAnimatedDrawableOptions.allowPrefetching) {
              continue;
            }
            j = 3;
            break label219;
            j = Math.max(j, i);
            i = (k + j) % this.mAnimatedDrawableBackend.getFrameCount();
            cancelFuturesOutsideOfRange(k, i);
            if (!shouldKeepAllFramesInMemory())
            {
              this.mBitmapsToKeepCached.setAll(true);
              this.mBitmapsToKeepCached.removeOutsideRange(k, i);
              i = k;
              break label229;
              dropBitmapsThatShouldNotBeCached();
            }
            if (!this.mAnimatedDrawableOptions.allowPrefetching) {
              break label204;
            }
            doPrefetch(k, j);
          }
        }
        else
        {
          i = 0;
          continue;
        }
        int j = 0;
        continue;
        j = 0;
      }
      finally {}
      int i = 0;
      continue;
      if (this.mCachedBitmaps.get(i) != null)
      {
        this.mBitmapsToKeepCached.set(i, true);
      }
      else
      {
        i -= 1;
        break label229;
        label204:
        cancelFuturesOutsideOfRange(this.mCurrentFrameIndex, this.mCurrentFrameIndex);
        continue;
        label219:
        if (i != 0)
        {
          i = m;
          continue;
          label229:
          if (i >= 0) {}
        }
      }
    }
  }
  
  private boolean shouldKeepAllFramesInMemory()
  {
    if (this.mAnimatedDrawableOptions.forceKeepAllFramesInMemory) {}
    while (this.mApproxKiloBytesToHoldAllFrames < this.mMaximumKiloBytes) {
      return true;
    }
    return false;
  }
  
  public void appendDebugOptionString(StringBuilder paramStringBuilder)
  {
    if (this.mAnimatedDrawableOptions.forceKeepAllFramesInMemory)
    {
      paramStringBuilder.append("Pinned To Memory");
      if ((shouldKeepAllFramesInMemory()) && (this.mAnimatedDrawableOptions.allowPrefetching)) {
        paramStringBuilder.append(" MT");
      }
      return;
    }
    if (this.mApproxKiloBytesToHoldAllFrames < this.mMaximumKiloBytes) {
      paramStringBuilder.append("within ");
    }
    for (;;)
    {
      this.mAnimatedDrawableUtil.appendMemoryString(paramStringBuilder, (int)this.mMaximumKiloBytes);
      break;
      paramStringBuilder.append("exceeds ");
    }
  }
  
  /* Error */
  public void dropCaches()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 130	com/facebook/imagepipeline/animated/impl/AnimatedDrawableCachingBackendImpl:mBitmapsToKeepCached	Lcom/facebook/imagepipeline/animated/impl/WhatToKeepCachedArray;
    //   6: iconst_0
    //   7: invokevirtual 464	com/facebook/imagepipeline/animated/impl/WhatToKeepCachedArray:setAll	(Z)V
    //   10: aload_0
    //   11: invokespecial 469	com/facebook/imagepipeline/animated/impl/AnimatedDrawableCachingBackendImpl:dropBitmapsThatShouldNotBeCached	()V
    //   14: aload_0
    //   15: getfield 110	com/facebook/imagepipeline/animated/impl/AnimatedDrawableCachingBackendImpl:mFreeBitmaps	Ljava/util/List;
    //   18: invokeinterface 499 1 0
    //   23: astore_1
    //   24: aload_1
    //   25: invokeinterface 504 1 0
    //   30: ifne +41 -> 71
    //   33: aload_0
    //   34: getfield 110	com/facebook/imagepipeline/animated/impl/AnimatedDrawableCachingBackendImpl:mFreeBitmaps	Ljava/util/List;
    //   37: invokeinterface 507 1 0
    //   42: aload_0
    //   43: getfield 83	com/facebook/imagepipeline/animated/impl/AnimatedDrawableCachingBackendImpl:mAnimatedDrawableBackend	Lcom/facebook/imagepipeline/animated/base/AnimatedDrawableBackend;
    //   46: invokeinterface 509 1 0
    //   51: getstatic 61	com/facebook/imagepipeline/animated/impl/AnimatedDrawableCachingBackendImpl:TAG	Ljava/lang/Class;
    //   54: ldc -13
    //   56: getstatic 68	com/facebook/imagepipeline/animated/impl/AnimatedDrawableCachingBackendImpl:sTotalBitmaps	Ljava/util/concurrent/atomic/AtomicInteger;
    //   59: invokevirtual 245	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   62: invokestatic 251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   65: invokestatic 254	com/facebook/common/logging/FLog:v	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;)V
    //   68: aload_0
    //   69: monitorexit
    //   70: return
    //   71: aload_1
    //   72: invokeinterface 512 1 0
    //   77: checkcast 204	android/graphics/Bitmap
    //   80: invokevirtual 515	android/graphics/Bitmap:recycle	()V
    //   83: getstatic 68	com/facebook/imagepipeline/animated/impl/AnimatedDrawableCachingBackendImpl:sTotalBitmaps	Ljava/util/concurrent/atomic/AtomicInteger;
    //   86: invokevirtual 518	java/util/concurrent/atomic/AtomicInteger:decrementAndGet	()I
    //   89: pop
    //   90: goto -66 -> 24
    //   93: astore_1
    //   94: aload_0
    //   95: monitorexit
    //   96: aload_1
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	this	AnimatedDrawableCachingBackendImpl
    //   23	49	1	localIterator	java.util.Iterator
    //   93	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	24	93	finally
    //   24	68	93	finally
    //   71	90	93	finally
  }
  
  protected void finalize()
    throws Throwable
  {
    try
    {
      super.finalize();
      if (this.mCachedBitmaps.size() > 0) {
        FLog.d(TAG, "Finalizing with rendered bitmaps");
      }
      sTotalBitmaps.addAndGet(-this.mFreeBitmaps.size());
      this.mFreeBitmaps.clear();
      return;
    }
    finally {}
  }
  
  public AnimatedDrawableCachingBackend forNewBounds(Rect paramRect)
  {
    paramRect = this.mAnimatedDrawableBackend.forNewBounds(paramRect);
    if (paramRect == this.mAnimatedDrawableBackend) {
      return this;
    }
    return new AnimatedDrawableCachingBackendImpl(this.mExecutorService, this.mActivityManager, this.mAnimatedDrawableUtil, this.mMonotonicClock, paramRect, this.mAnimatedDrawableOptions);
  }
  
  public CloseableReference<Bitmap> getBitmapForFrame(int paramInt)
  {
    this.mCurrentFrameIndex = paramInt;
    CloseableReference localCloseableReference = getBitmapForFrameInternal(paramInt, false);
    schedulePrefetches();
    return localCloseableReference;
  }
  
  @VisibleForTesting
  CloseableReference<Bitmap> getBitmapForFrameBlocking(int paramInt)
  {
    this.mCurrentFrameIndex = paramInt;
    CloseableReference localCloseableReference = getBitmapForFrameInternal(paramInt, true);
    schedulePrefetches();
    return localCloseableReference;
  }
  
  /* Error */
  @VisibleForTesting
  java.util.Map<Integer, Task<?>> getDecodesInFlight()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 553	java/util/HashMap
    //   5: dup
    //   6: invokespecial 554	java/util/HashMap:<init>	()V
    //   9: astore_1
    //   10: iconst_0
    //   11: istore_2
    //   12: aload_0
    //   13: getfield 117	com/facebook/imagepipeline/animated/impl/AnimatedDrawableCachingBackendImpl:mDecodesInFlight	Lfb/support/v4/util/SparseArrayCompat;
    //   16: invokevirtual 170	fb/support/v4/util/SparseArrayCompat:size	()I
    //   19: istore_3
    //   20: iload_2
    //   21: iload_3
    //   22: if_icmplt +7 -> 29
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_1
    //   28: areturn
    //   29: aload_1
    //   30: aload_0
    //   31: getfield 117	com/facebook/imagepipeline/animated/impl/AnimatedDrawableCachingBackendImpl:mDecodesInFlight	Lfb/support/v4/util/SparseArrayCompat;
    //   34: iload_2
    //   35: invokevirtual 174	fb/support/v4/util/SparseArrayCompat:keyAt	(I)I
    //   38: invokestatic 251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   41: aload_0
    //   42: getfield 117	com/facebook/imagepipeline/animated/impl/AnimatedDrawableCachingBackendImpl:mDecodesInFlight	Lfb/support/v4/util/SparseArrayCompat;
    //   45: iload_2
    //   46: invokevirtual 184	fb/support/v4/util/SparseArrayCompat:valueAt	(I)Ljava/lang/Object;
    //   49: checkcast 186	bolts/Task
    //   52: invokeinterface 559 3 0
    //   57: pop
    //   58: iload_2
    //   59: iconst_1
    //   60: iadd
    //   61: istore_2
    //   62: goto -50 -> 12
    //   65: astore_1
    //   66: aload_0
    //   67: monitorexit
    //   68: aload_1
    //   69: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	this	AnimatedDrawableCachingBackendImpl
    //   9	21	1	localHashMap	java.util.HashMap
    //   65	4	1	localObject	Object
    //   11	51	2	i	int
    //   19	4	3	j	int
    // Exception table:
    //   from	to	target	type
    //   2	10	65	finally
    //   12	20	65	finally
    //   29	58	65	finally
  }
  
  /* Error */
  @VisibleForTesting
  java.util.Set<Integer> getFramesCached()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 564	java/util/HashSet
    //   5: dup
    //   6: invokespecial 565	java/util/HashSet:<init>	()V
    //   9: astore_1
    //   10: iconst_0
    //   11: istore_2
    //   12: aload_0
    //   13: getfield 119	com/facebook/imagepipeline/animated/impl/AnimatedDrawableCachingBackendImpl:mCachedBitmaps	Lfb/support/v4/util/SparseArrayCompat;
    //   16: invokevirtual 170	fb/support/v4/util/SparseArrayCompat:size	()I
    //   19: istore_3
    //   20: iload_2
    //   21: iload_3
    //   22: if_icmplt +7 -> 29
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_1
    //   28: areturn
    //   29: aload_1
    //   30: aload_0
    //   31: getfield 119	com/facebook/imagepipeline/animated/impl/AnimatedDrawableCachingBackendImpl:mCachedBitmaps	Lfb/support/v4/util/SparseArrayCompat;
    //   34: iload_2
    //   35: invokevirtual 174	fb/support/v4/util/SparseArrayCompat:keyAt	(I)I
    //   38: invokestatic 251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   41: invokeinterface 571 2 0
    //   46: pop
    //   47: iload_2
    //   48: iconst_1
    //   49: iadd
    //   50: istore_2
    //   51: goto -39 -> 12
    //   54: astore_1
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_1
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	AnimatedDrawableCachingBackendImpl
    //   9	21	1	localHashSet	java.util.HashSet
    //   54	4	1	localObject	Object
    //   11	40	2	i	int
    //   19	4	3	j	int
    // Exception table:
    //   from	to	target	type
    //   2	10	54	finally
    //   12	20	54	finally
    //   29	47	54	finally
  }
  
  /* Error */
  public int getMemoryUsage()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 110	com/facebook/imagepipeline/animated/impl/AnimatedDrawableCachingBackendImpl:mFreeBitmaps	Ljava/util/List;
    //   8: invokeinterface 499 1 0
    //   13: astore_1
    //   14: aload_1
    //   15: invokeinterface 504 1 0
    //   20: ifne +32 -> 52
    //   23: iconst_0
    //   24: istore 4
    //   26: iload 4
    //   28: aload_0
    //   29: getfield 119	com/facebook/imagepipeline/animated/impl/AnimatedDrawableCachingBackendImpl:mCachedBitmaps	Lfb/support/v4/util/SparseArrayCompat;
    //   32: invokevirtual 170	fb/support/v4/util/SparseArrayCompat:size	()I
    //   35: if_icmplt +41 -> 76
    //   38: aload_0
    //   39: monitorexit
    //   40: iload_3
    //   41: aload_0
    //   42: getfield 83	com/facebook/imagepipeline/animated/impl/AnimatedDrawableCachingBackendImpl:mAnimatedDrawableBackend	Lcom/facebook/imagepipeline/animated/base/AnimatedDrawableBackend;
    //   45: invokeinterface 575 1 0
    //   50: iadd
    //   51: ireturn
    //   52: aload_1
    //   53: invokeinterface 512 1 0
    //   58: checkcast 204	android/graphics/Bitmap
    //   61: astore_2
    //   62: iload_3
    //   63: aload_0
    //   64: getfield 79	com/facebook/imagepipeline/animated/impl/AnimatedDrawableCachingBackendImpl:mAnimatedDrawableUtil	Lcom/facebook/imagepipeline/animated/util/AnimatedDrawableUtil;
    //   67: aload_2
    //   68: invokevirtual 579	com/facebook/imagepipeline/animated/util/AnimatedDrawableUtil:getSizeOfBitmap	(Landroid/graphics/Bitmap;)I
    //   71: iadd
    //   72: istore_3
    //   73: goto -59 -> 14
    //   76: aload_0
    //   77: getfield 119	com/facebook/imagepipeline/animated/impl/AnimatedDrawableCachingBackendImpl:mCachedBitmaps	Lfb/support/v4/util/SparseArrayCompat;
    //   80: iload 4
    //   82: invokevirtual 184	fb/support/v4/util/SparseArrayCompat:valueAt	(I)Ljava/lang/Object;
    //   85: checkcast 198	com/facebook/common/references/CloseableReference
    //   88: astore_1
    //   89: iload_3
    //   90: aload_0
    //   91: getfield 79	com/facebook/imagepipeline/animated/impl/AnimatedDrawableCachingBackendImpl:mAnimatedDrawableUtil	Lcom/facebook/imagepipeline/animated/util/AnimatedDrawableUtil;
    //   94: aload_1
    //   95: invokevirtual 202	com/facebook/common/references/CloseableReference:get	()Ljava/lang/Object;
    //   98: checkcast 204	android/graphics/Bitmap
    //   101: invokevirtual 579	com/facebook/imagepipeline/animated/util/AnimatedDrawableUtil:getSizeOfBitmap	(Landroid/graphics/Bitmap;)I
    //   104: iadd
    //   105: istore_3
    //   106: iload 4
    //   108: iconst_1
    //   109: iadd
    //   110: istore 4
    //   112: goto -86 -> 26
    //   115: astore_1
    //   116: aload_0
    //   117: monitorexit
    //   118: aload_1
    //   119: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	this	AnimatedDrawableCachingBackendImpl
    //   13	82	1	localObject1	Object
    //   115	4	1	localObject2	Object
    //   61	7	2	localBitmap	Bitmap
    //   1	105	3	i	int
    //   24	87	4	j	int
    // Exception table:
    //   from	to	target	type
    //   4	14	115	finally
    //   14	23	115	finally
    //   26	40	115	finally
    //   52	73	115	finally
    //   76	106	115	finally
    //   116	118	115	finally
  }
  
  public CloseableReference<Bitmap> getPreviewBitmap()
  {
    return getAnimatedImageResult().getPreviewBitmap();
  }
  
  void releaseBitmapInternal(Bitmap paramBitmap)
  {
    try
    {
      this.mFreeBitmaps.add(paramBitmap);
      return;
    }
    finally
    {
      paramBitmap = finally;
      throw paramBitmap;
    }
  }
  
  public void renderFrame(int paramInt, Canvas paramCanvas)
  {
    throw new IllegalStateException();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\animated\impl\AnimatedDrawableCachingBackendImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */