package com.facebook.imagepipeline.animated.factory;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendProvider;
import com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor;
import com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.Callback;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import java.util.ArrayList;
import java.util.List;

public class AnimatedImageFactory
{
  private final AnimatedDrawableBackendProvider mAnimatedDrawableBackendProvider;
  private final PlatformBitmapFactory mBitmapFactory;
  
  public AnimatedImageFactory(AnimatedDrawableBackendProvider paramAnimatedDrawableBackendProvider, PlatformBitmapFactory paramPlatformBitmapFactory)
  {
    this.mAnimatedDrawableBackendProvider = paramAnimatedDrawableBackendProvider;
    this.mBitmapFactory = paramPlatformBitmapFactory;
  }
  
  @SuppressLint({"NewApi"})
  private CloseableReference<Bitmap> createBitmap(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    paramConfig = this.mBitmapFactory.createBitmap(paramInt1, paramInt2, paramConfig);
    ((Bitmap)paramConfig.get()).eraseColor(0);
    if (Build.VERSION.SDK_INT >= 12) {
      ((Bitmap)paramConfig.get()).setHasAlpha(true);
    }
    return paramConfig;
  }
  
  private CloseableReference<Bitmap> createPreviewBitmap(AnimatedImage paramAnimatedImage, Bitmap.Config paramConfig, int paramInt)
  {
    paramConfig = createBitmap(paramAnimatedImage.getWidth(), paramAnimatedImage.getHeight(), paramConfig);
    paramAnimatedImage = AnimatedImageResult.forAnimatedImage(paramAnimatedImage);
    new AnimatedImageCompositor(this.mAnimatedDrawableBackendProvider.get(paramAnimatedImage, null), new AnimatedImageCompositor.Callback()
    {
      public CloseableReference<Bitmap> getCachedBitmap(int paramAnonymousInt)
      {
        return null;
      }
      
      public void onIntermediateResult(int paramAnonymousInt, Bitmap paramAnonymousBitmap) {}
    }).renderFrame(paramInt, (Bitmap)paramConfig.get());
    return paramConfig;
  }
  
  private List<CloseableReference<Bitmap>> decodeAllFrames(AnimatedImage paramAnimatedImage, Bitmap.Config paramConfig)
  {
    final ArrayList localArrayList = new ArrayList();
    paramAnimatedImage = AnimatedImageResult.forAnimatedImage(paramAnimatedImage);
    paramAnimatedImage = this.mAnimatedDrawableBackendProvider.get(paramAnimatedImage, null);
    AnimatedImageCompositor localAnimatedImageCompositor = new AnimatedImageCompositor(paramAnimatedImage, new AnimatedImageCompositor.Callback()
    {
      public CloseableReference<Bitmap> getCachedBitmap(int paramAnonymousInt)
      {
        return CloseableReference.cloneOrNull((CloseableReference)localArrayList.get(paramAnonymousInt));
      }
      
      public void onIntermediateResult(int paramAnonymousInt, Bitmap paramAnonymousBitmap) {}
    });
    int i = 0;
    for (;;)
    {
      if (i >= paramAnimatedImage.getFrameCount()) {
        return localArrayList;
      }
      CloseableReference localCloseableReference = createBitmap(paramAnimatedImage.getWidth(), paramAnimatedImage.getHeight(), paramConfig);
      localAnimatedImageCompositor.renderFrame(i, (Bitmap)localCloseableReference.get());
      localArrayList.add(localCloseableReference);
      i += 1;
    }
  }
  
  /* Error */
  private com.facebook.imagepipeline.image.CloseableAnimatedImage getCloseableImage(com.facebook.imagepipeline.common.ImageDecodeOptions paramImageDecodeOptions, AnimatedImage paramAnimatedImage, Bitmap.Config paramConfig)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 8
    //   9: aconst_null
    //   10: astore 4
    //   12: aload 9
    //   14: astore 5
    //   16: aload 8
    //   18: astore 6
    //   20: aload_1
    //   21: getfield 122	com/facebook/imagepipeline/common/ImageDecodeOptions:useLastFrameForPreview	Z
    //   24: ifeq +173 -> 197
    //   27: aload 9
    //   29: astore 5
    //   31: aload 8
    //   33: astore 6
    //   35: aload_2
    //   36: invokeinterface 123 1 0
    //   41: iconst_1
    //   42: isub
    //   43: istore 10
    //   45: aload 9
    //   47: astore 5
    //   49: aload 8
    //   51: astore 6
    //   53: aload_1
    //   54: getfield 125	com/facebook/imagepipeline/common/ImageDecodeOptions:decodeAllFrames	Z
    //   57: ifeq +44 -> 101
    //   60: aload 9
    //   62: astore 5
    //   64: aload 8
    //   66: astore 6
    //   68: aload_0
    //   69: aload_2
    //   70: aload_3
    //   71: invokespecial 127	com/facebook/imagepipeline/animated/factory/AnimatedImageFactory:decodeAllFrames	(Lcom/facebook/imagepipeline/animated/base/AnimatedImage;Landroid/graphics/Bitmap$Config;)Ljava/util/List;
    //   74: astore 7
    //   76: aload 7
    //   78: astore 5
    //   80: aload 8
    //   82: astore 6
    //   84: aload 7
    //   86: iload 10
    //   88: invokeinterface 130 2 0
    //   93: checkcast 33	com/facebook/common/references/CloseableReference
    //   96: invokestatic 134	com/facebook/common/references/CloseableReference:cloneOrNull	(Lcom/facebook/common/references/CloseableReference;)Lcom/facebook/common/references/CloseableReference;
    //   99: astore 4
    //   101: aload 4
    //   103: astore 8
    //   105: aload 7
    //   107: astore 5
    //   109: aload 4
    //   111: astore 6
    //   113: aload_1
    //   114: getfield 137	com/facebook/imagepipeline/common/ImageDecodeOptions:decodePreviewFrame	Z
    //   117: ifeq +30 -> 147
    //   120: aload 4
    //   122: astore 8
    //   124: aload 4
    //   126: ifnonnull +21 -> 147
    //   129: aload 7
    //   131: astore 5
    //   133: aload 4
    //   135: astore 6
    //   137: aload_0
    //   138: aload_2
    //   139: aload_3
    //   140: iload 10
    //   142: invokespecial 139	com/facebook/imagepipeline/animated/factory/AnimatedImageFactory:createPreviewBitmap	(Lcom/facebook/imagepipeline/animated/base/AnimatedImage;Landroid/graphics/Bitmap$Config;I)Lcom/facebook/common/references/CloseableReference;
    //   145: astore 8
    //   147: aload 7
    //   149: astore 5
    //   151: aload 8
    //   153: astore 6
    //   155: new 141	com/facebook/imagepipeline/image/CloseableAnimatedImage
    //   158: dup
    //   159: aload_2
    //   160: invokestatic 145	com/facebook/imagepipeline/animated/base/AnimatedImageResult:newBuilder	(Lcom/facebook/imagepipeline/animated/base/AnimatedImage;)Lcom/facebook/imagepipeline/animated/base/AnimatedImageResultBuilder;
    //   163: aload 8
    //   165: invokevirtual 151	com/facebook/imagepipeline/animated/base/AnimatedImageResultBuilder:setPreviewBitmap	(Lcom/facebook/common/references/CloseableReference;)Lcom/facebook/imagepipeline/animated/base/AnimatedImageResultBuilder;
    //   168: iload 10
    //   170: invokevirtual 155	com/facebook/imagepipeline/animated/base/AnimatedImageResultBuilder:setFrameForPreview	(I)Lcom/facebook/imagepipeline/animated/base/AnimatedImageResultBuilder;
    //   173: aload 7
    //   175: invokevirtual 159	com/facebook/imagepipeline/animated/base/AnimatedImageResultBuilder:setDecodedFrames	(Ljava/util/List;)Lcom/facebook/imagepipeline/animated/base/AnimatedImageResultBuilder;
    //   178: invokevirtual 163	com/facebook/imagepipeline/animated/base/AnimatedImageResultBuilder:build	()Lcom/facebook/imagepipeline/animated/base/AnimatedImageResult;
    //   181: invokespecial 166	com/facebook/imagepipeline/image/CloseableAnimatedImage:<init>	(Lcom/facebook/imagepipeline/animated/base/AnimatedImageResult;)V
    //   184: astore_1
    //   185: aload 8
    //   187: invokestatic 170	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   190: aload 7
    //   192: invokestatic 173	com/facebook/common/references/CloseableReference:closeSafely	(Ljava/lang/Iterable;)V
    //   195: aload_1
    //   196: areturn
    //   197: iconst_0
    //   198: istore 10
    //   200: goto -155 -> 45
    //   203: astore_1
    //   204: aload 6
    //   206: invokestatic 170	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   209: aload 5
    //   211: invokestatic 173	com/facebook/common/references/CloseableReference:closeSafely	(Ljava/lang/Iterable;)V
    //   214: aload_1
    //   215: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	216	0	this	AnimatedImageFactory
    //   0	216	1	paramImageDecodeOptions	com.facebook.imagepipeline.common.ImageDecodeOptions
    //   0	216	2	paramAnimatedImage	AnimatedImage
    //   0	216	3	paramConfig	Bitmap.Config
    //   10	124	4	localCloseableReference	CloseableReference
    //   14	196	5	localObject1	Object
    //   18	187	6	localObject2	Object
    //   4	187	7	localList	List
    //   7	179	8	localObject3	Object
    //   1	60	9	localObject4	Object
    //   43	156	10	i	int
    // Exception table:
    //   from	to	target	type
    //   20	27	203	finally
    //   35	45	203	finally
    //   53	60	203	finally
    //   68	76	203	finally
    //   84	101	203	finally
    //   113	120	203	finally
    //   137	147	203	finally
    //   155	185	203	finally
  }
  
  /* Error */
  public com.facebook.imagepipeline.image.CloseableImage decodeGif(com.facebook.imagepipeline.image.EncodedImage paramEncodedImage, com.facebook.imagepipeline.common.ImageDecodeOptions paramImageDecodeOptions, Bitmap.Config paramConfig)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 181	com/facebook/imagepipeline/image/EncodedImage:getByteBufferRef	()Lcom/facebook/common/references/CloseableReference;
    //   4: astore_1
    //   5: aload_1
    //   6: invokestatic 187	com/facebook/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   9: pop
    //   10: aload_2
    //   11: getfield 190	com/facebook/imagepipeline/common/ImageDecodeOptions:forceOldAnimationCode	Z
    //   14: ifeq +50 -> 64
    //   17: iconst_0
    //   18: istore 5
    //   20: iload 5
    //   22: invokestatic 193	com/facebook/common/internal/Preconditions:checkState	(Z)V
    //   25: aload_1
    //   26: invokevirtual 37	com/facebook/common/references/CloseableReference:get	()Ljava/lang/Object;
    //   29: checkcast 195	com/facebook/imagepipeline/memory/PooledByteBuffer
    //   32: astore 4
    //   34: aload_0
    //   35: aload_2
    //   36: aload 4
    //   38: invokeinterface 199 1 0
    //   43: aload 4
    //   45: invokeinterface 202 1 0
    //   50: invokestatic 208	com/facebook/imagepipeline/gif/GifImage:create	(JI)Lcom/facebook/imagepipeline/gif/GifImage;
    //   53: aload_3
    //   54: invokespecial 210	com/facebook/imagepipeline/animated/factory/AnimatedImageFactory:getCloseableImage	(Lcom/facebook/imagepipeline/common/ImageDecodeOptions;Lcom/facebook/imagepipeline/animated/base/AnimatedImage;Landroid/graphics/Bitmap$Config;)Lcom/facebook/imagepipeline/image/CloseableAnimatedImage;
    //   57: astore_2
    //   58: aload_1
    //   59: invokestatic 170	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   62: aload_2
    //   63: areturn
    //   64: iconst_1
    //   65: istore 5
    //   67: goto -47 -> 20
    //   70: astore_2
    //   71: aload_1
    //   72: invokestatic 170	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   75: aload_2
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	AnimatedImageFactory
    //   0	77	1	paramEncodedImage	com.facebook.imagepipeline.image.EncodedImage
    //   0	77	2	paramImageDecodeOptions	com.facebook.imagepipeline.common.ImageDecodeOptions
    //   0	77	3	paramConfig	Bitmap.Config
    //   32	12	4	localPooledByteBuffer	com.facebook.imagepipeline.memory.PooledByteBuffer
    //   18	48	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   10	17	70	finally
    //   20	58	70	finally
  }
  
  /* Error */
  public com.facebook.imagepipeline.image.CloseableImage decodeWebP(com.facebook.imagepipeline.image.EncodedImage paramEncodedImage, com.facebook.imagepipeline.common.ImageDecodeOptions paramImageDecodeOptions, Bitmap.Config paramConfig)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 181	com/facebook/imagepipeline/image/EncodedImage:getByteBufferRef	()Lcom/facebook/common/references/CloseableReference;
    //   4: astore_1
    //   5: aload_1
    //   6: invokestatic 187	com/facebook/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   9: pop
    //   10: aload_2
    //   11: getfield 190	com/facebook/imagepipeline/common/ImageDecodeOptions:forceOldAnimationCode	Z
    //   14: ifeq +50 -> 64
    //   17: iconst_0
    //   18: istore 5
    //   20: iload 5
    //   22: invokestatic 214	com/facebook/common/internal/Preconditions:checkArgument	(Z)V
    //   25: aload_1
    //   26: invokevirtual 37	com/facebook/common/references/CloseableReference:get	()Ljava/lang/Object;
    //   29: checkcast 195	com/facebook/imagepipeline/memory/PooledByteBuffer
    //   32: astore 4
    //   34: aload_0
    //   35: aload_2
    //   36: aload 4
    //   38: invokeinterface 199 1 0
    //   43: aload 4
    //   45: invokeinterface 202 1 0
    //   50: invokestatic 219	com/facebook/imagepipeline/webp/WebPImage:create	(JI)Lcom/facebook/imagepipeline/webp/WebPImage;
    //   53: aload_3
    //   54: invokespecial 210	com/facebook/imagepipeline/animated/factory/AnimatedImageFactory:getCloseableImage	(Lcom/facebook/imagepipeline/common/ImageDecodeOptions;Lcom/facebook/imagepipeline/animated/base/AnimatedImage;Landroid/graphics/Bitmap$Config;)Lcom/facebook/imagepipeline/image/CloseableAnimatedImage;
    //   57: astore_2
    //   58: aload_1
    //   59: invokestatic 170	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   62: aload_2
    //   63: areturn
    //   64: iconst_1
    //   65: istore 5
    //   67: goto -47 -> 20
    //   70: astore_2
    //   71: aload_1
    //   72: invokestatic 170	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   75: aload_2
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	AnimatedImageFactory
    //   0	77	1	paramEncodedImage	com.facebook.imagepipeline.image.EncodedImage
    //   0	77	2	paramImageDecodeOptions	com.facebook.imagepipeline.common.ImageDecodeOptions
    //   0	77	3	paramConfig	Bitmap.Config
    //   32	12	4	localPooledByteBuffer	com.facebook.imagepipeline.memory.PooledByteBuffer
    //   18	48	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   10	17	70	finally
    //   20	58	70	finally
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\animated\factory\AnimatedImageFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */