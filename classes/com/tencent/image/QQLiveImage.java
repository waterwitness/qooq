package com.tencent.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnInfoListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnPreAdListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnSeekCompleteListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoOutputFrameListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.OnLogListener;
import com.tencent.qqlive.mediaplayer.api.TVK_UserInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;

public class QQLiveImage
  implements TVK_IMediaPlayer.OnVideoOutputFrameListener, TVK_IMediaPlayer.OnInfoListener, TVK_IMediaPlayer.OnErrorListener, TVK_IMediaPlayer.OnPreAdListener, TVK_IMediaPlayer.OnSeekCompleteListener, TVK_IMediaPlayer.OnCompletionListener, TVK_IMediaPlayer.OnVideoPreparedListener
{
  static final int MSG_TYPE_REFRESH = 1;
  public static final long SD_CACHE_LIMIT = 209715200L;
  public static final String TAG = QQLiveImage.class.getSimpleName() + "_";
  public static final String TencentVideoSdkAppKey = "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==";
  private static AtomicBoolean mInstallProgress = new AtomicBoolean(false);
  public static boolean mIsDebugEnable;
  private static boolean mSDKInited = false;
  public static ArrayList<WeakReference<QQLiveImage>> sImageList;
  protected int ID = 0;
  private URLDrawable mCover;
  protected Bitmap mCoverBitmap;
  protected Bitmap mCurFrameBitmap;
  private int mDensity = 160;
  private Vector<WeakReference<QQLiveDrawable>> mDrawableList = new Vector();
  private QQLiveDrawable.ErrorInfo mErrorInfo = new QQLiveDrawable.ErrorInfo();
  int mFrameIndex = 0;
  protected Handler mHandler = new EventHandler(Looper.getMainLooper());
  Object mLock = new Object();
  protected QQLiveDrawable.OnStateListener mOnStateListener;
  public QQLiveDrawable.QQLiveDrawableParams mParams;
  private boolean mPaused = false;
  private int mPlayPostionWhenRecyle = -1;
  private TVK_PlayerVideoInfo mPlayerinfo = null;
  private boolean mPrepared = false;
  private boolean mReclyed = false;
  int mState = 0;
  private String mUrlStr;
  private TVK_UserInfo mUserinfo = null;
  private TVK_IMediaPlayer mVideoPlayer = null;
  private TVK_IProxyFactory mfactory = null;
  
  static
  {
    mIsDebugEnable = true;
  }
  
  public QQLiveImage(String paramString, Object paramObject)
  {
    this.mUrlStr = paramString;
    this.ID = paramString.hashCode();
    if (!paramString.startsWith("qqlive")) {
      throw new IllegalStateException("Wrong format url! str=" + paramString);
    }
    if ((paramObject != null) && ((paramObject instanceof QQLiveDrawable.QQLiveDrawableParams)))
    {
      this.mParams = ((QQLiveDrawable.QQLiveDrawableParams)paramObject);
      setOnStateListener(this.mParams.mListener);
    }
    initCover(this.mParams.mCoverUrl);
    if (QLog.isColorLevel()) {
      QLog.d(TAG + this.ID, 2, "QQLiveVideo(): url = " + paramString + ", mParams=" + this.mParams.toString());
    }
  }
  
  private void changeStateAndNotify(int paramInt, final Object paramObject)
  {
    if (paramInt != this.mState)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG + this.ID, 2, "changeStateAndNotify(): " + getStateStr(this.mState) + " ===> " + getStateStr(paramInt));
      }
      this.mState = paramInt;
      if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
        break label117;
      }
      if (this.mOnStateListener != null) {
        this.mOnStateListener.onStateChange(this.mState, paramObject);
      }
    }
    return;
    label117:
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        if (QQLiveImage.this.mOnStateListener != null) {
          QQLiveImage.this.mOnStateListener.onStateChange(QQLiveImage.this.mState, paramObject);
        }
      }
    });
  }
  
  static Context getApplicationContext()
  {
    return BaseApplication.getContext();
  }
  
  public static String getStateStr(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "STATE_UNKNOW";
    case 0: 
      return "STATE_IDLE";
    case 1: 
      return "STATE_PREPARED";
    case 2: 
      return "STATE_PLAYING";
    case 3: 
      return "STATE_BUFFERING";
    case 4: 
      return "STATE_PAUSE";
    }
    return "STATE_ERROR";
  }
  
  private void initCover(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      if (this.mCoverBitmap == null) {
        try
        {
          this.mCover = URLDrawable.getDrawable(paramString, this.mParams.mCoverLoadingDrawable, this.mParams.mCoverLoadingDrawable);
          if ((this.mCover.getStatus() == 1) && ((this.mCover.getCurrDrawable() instanceof RegionDrawable)))
          {
            this.mCoverBitmap = ((RegionDrawable)this.mCover.getCurrDrawable()).getBitmap();
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d(TAG + this.ID, 2, "initCover(): mCover is loaded: ");
          }
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.e(TAG + this.ID, 2, "initCover(): getDrawable Exception: imgUrl=" + paramString, localException);
          }
          this.mCover = null;
          return;
        }
      }
    }
    this.mCover.setURLDrawableListener(new URLDrawable.URLDrawableListener()
    {
      public void onLoadCanceled(URLDrawable paramAnonymousURLDrawable) {}
      
      public void onLoadFialed(URLDrawable paramAnonymousURLDrawable, Throwable paramAnonymousThrowable) {}
      
      public void onLoadProgressed(URLDrawable paramAnonymousURLDrawable, int paramAnonymousInt) {}
      
      public void onLoadSuccessed(URLDrawable paramAnonymousURLDrawable)
      {
        if ((paramAnonymousURLDrawable.getStatus() == 1) && ((paramAnonymousURLDrawable.getCurrDrawable() instanceof RegionDrawable)))
        {
          paramAnonymousURLDrawable = (RegionDrawable)paramAnonymousURLDrawable.getCurrDrawable();
          QQLiveImage.this.mCoverBitmap = paramAnonymousURLDrawable.getBitmap();
          QQLiveImage.this.invalidateSelf();
          if (QLog.isColorLevel()) {
            QLog.d(QQLiveImage.TAG + QQLiveImage.this.ID, 2, "initCover(): onLoadSuccessed(): ");
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d(QQLiveImage.TAG + QQLiveImage.this.ID, 2, "initCover(): onLoadSuccessed(): mCoverBitmap=" + QQLiveImage.this.mCoverBitmap);
        }
      }
    });
    this.mCover.startDownload();
  }
  
  public static void pauseAll()
  {
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "pauseAll() ");
    }
    if (sImageList != null)
    {
      int i = 0;
      while (i < sImageList.size())
      {
        Object localObject = (WeakReference)sImageList.get(i);
        if ((localObject != null) && (((WeakReference)localObject).get() != null))
        {
          localObject = (QQLiveImage)((WeakReference)localObject).get();
          ((QQLiveImage)localObject).pause();
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "pause player, index = " + i + ", ID = " + ((QQLiveImage)localObject).ID);
          }
        }
        i += 1;
      }
    }
  }
  
  public static void releaseAll()
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "releaseAll()......");
    }
    if (sImageList != null)
    {
      int i = 0;
      while (i < sImageList.size())
      {
        Object localObject = (WeakReference)sImageList.get(i);
        if ((localObject != null) && (((WeakReference)localObject).get() != null))
        {
          localObject = (QQLiveImage)((WeakReference)localObject).get();
          ((QQLiveImage)localObject).release();
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "release player, index = " + i + ", ID = " + ((QQLiveImage)localObject).ID);
          }
        }
        i += 1;
      }
      sImageList.clear();
      sImageList = null;
    }
  }
  
  public static int scaleFromDensity(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 == 0) || (paramInt2 == paramInt3)) {
      return paramInt1;
    }
    return (paramInt1 * paramInt3 + (paramInt2 >> 1)) / paramInt2;
  }
  
  public static void setDebugEnable(boolean paramBoolean)
  {
    mIsDebugEnable = paramBoolean;
  }
  
  /* Error */
  public void OnVideoOutputFrame(byte[] arg1, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 163	com/tencent/image/QQLiveImage:mPaused	Z
    //   4: ifeq +40 -> 44
    //   7: invokestatic 222	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10: ifeq +33 -> 43
    //   13: new 97	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   20: getstatic 117	com/tencent/image/QQLiveImage:TAG	Ljava/lang/String;
    //   23: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_0
    //   27: getfield 135	com/tencent/image/QQLiveImage:ID	I
    //   30: invokevirtual 225	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   33: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: iconst_2
    //   37: ldc_w 395
    //   40: invokestatic 397	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   43: return
    //   44: aload_1
    //   45: ifnull +199 -> 244
    //   48: invokestatic 403	java/lang/System:currentTimeMillis	()J
    //   51: pop2
    //   52: aload_1
    //   53: invokestatic 409	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   56: astore 6
    //   58: aload_0
    //   59: getfield 173	com/tencent/image/QQLiveImage:mLock	Ljava/lang/Object;
    //   62: astore_1
    //   63: aload_1
    //   64: monitorenter
    //   65: aload_0
    //   66: getfield 411	com/tencent/image/QQLiveImage:mCurFrameBitmap	Landroid/graphics/Bitmap;
    //   69: ifnonnull +78 -> 147
    //   72: aload_0
    //   73: iload_2
    //   74: iload_3
    //   75: getstatic 417	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   78: invokestatic 423	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   81: putfield 411	com/tencent/image/QQLiveImage:mCurFrameBitmap	Landroid/graphics/Bitmap;
    //   84: invokestatic 222	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   87: ifeq +60 -> 147
    //   90: new 97	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   97: getstatic 117	com/tencent/image/QQLiveImage:TAG	Ljava/lang/String;
    //   100: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: aload_0
    //   104: getfield 135	com/tencent/image/QQLiveImage:ID	I
    //   107: invokevirtual 225	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   110: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: iconst_2
    //   114: new 97	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   121: ldc_w 425
    //   124: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: iload_2
    //   128: invokevirtual 225	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   131: ldc_w 427
    //   134: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: iload_3
    //   138: invokevirtual 225	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   141: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: invokestatic 354	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   147: aload_0
    //   148: getfield 411	com/tencent/image/QQLiveImage:mCurFrameBitmap	Landroid/graphics/Bitmap;
    //   151: aload 6
    //   153: invokevirtual 431	android/graphics/Bitmap:copyPixelsFromBuffer	(Ljava/nio/Buffer;)V
    //   156: aload_1
    //   157: monitorexit
    //   158: aload_0
    //   159: aload_0
    //   160: getfield 171	com/tencent/image/QQLiveImage:mFrameIndex	I
    //   163: iconst_1
    //   164: iadd
    //   165: putfield 171	com/tencent/image/QQLiveImage:mFrameIndex	I
    //   168: invokestatic 403	java/lang/System:currentTimeMillis	()J
    //   171: pop2
    //   172: aload_0
    //   173: getfield 146	com/tencent/image/QQLiveImage:mHandler	Landroid/os/Handler;
    //   176: iconst_1
    //   177: invokevirtual 435	android/os/Handler:removeMessages	(I)V
    //   180: aload_0
    //   181: getfield 146	com/tencent/image/QQLiveImage:mHandler	Landroid/os/Handler;
    //   184: iconst_1
    //   185: invokevirtual 439	android/os/Handler:sendEmptyMessage	(I)Z
    //   188: pop
    //   189: aload_0
    //   190: iconst_2
    //   191: aconst_null
    //   192: invokespecial 441	com/tencent/image/QQLiveImage:changeStateAndNotify	(ILjava/lang/Object;)V
    //   195: return
    //   196: astore 6
    //   198: aload_1
    //   199: monitorexit
    //   200: aload 6
    //   202: athrow
    //   203: astore_1
    //   204: invokestatic 222	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   207: ifeq -39 -> 168
    //   210: new 97	java/lang/StringBuilder
    //   213: dup
    //   214: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   217: getstatic 117	com/tencent/image/QQLiveImage:TAG	Ljava/lang/String;
    //   220: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: aload_0
    //   224: getfield 135	com/tencent/image/QQLiveImage:ID	I
    //   227: invokevirtual 225	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   230: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: iconst_2
    //   234: ldc_w 443
    //   237: aload_1
    //   238: invokestatic 338	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   241: goto -73 -> 168
    //   244: invokestatic 222	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   247: ifeq -204 -> 43
    //   250: new 97	java/lang/StringBuilder
    //   253: dup
    //   254: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   257: getstatic 117	com/tencent/image/QQLiveImage:TAG	Ljava/lang/String;
    //   260: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: aload_0
    //   264: getfield 135	com/tencent/image/QQLiveImage:ID	I
    //   267: invokevirtual 225	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   270: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: iconst_2
    //   274: ldc_w 445
    //   277: invokestatic 397	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   280: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	281	0	this	QQLiveImage
    //   0	281	2	paramInt1	int
    //   0	281	3	paramInt2	int
    //   0	281	4	paramInt3	int
    //   0	281	5	paramInt4	int
    //   56	96	6	localByteBuffer	java.nio.ByteBuffer
    //   196	5	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   65	147	196	finally
    //   147	158	196	finally
    //   198	200	196	finally
    //   58	65	203	java/lang/Exception
    //   158	168	203	java/lang/Exception
    //   200	203	203	java/lang/Exception
  }
  
  public void attachDrawable(QQLiveDrawable paramQQLiveDrawable)
  {
    if (paramQQLiveDrawable != null) {
      synchronized (this.mDrawableList)
      {
        if (!this.mDrawableList.contains(paramQQLiveDrawable)) {
          this.mDrawableList.add(new WeakReference(paramQQLiveDrawable));
        }
        return;
      }
    }
  }
  
  public void detachDrawable(QQLiveDrawable paramQQLiveDrawable)
  {
    if (paramQQLiveDrawable != null)
    {
      localVector = this.mDrawableList;
      int i = 0;
      Object localObject;
      for (;;)
      {
        int j;
        try
        {
          if (i < this.mDrawableList.size())
          {
            localObject = (WeakReference)this.mDrawableList.get(i);
            if ((localObject == null) || (((WeakReference)localObject).get() == paramQQLiveDrawable))
            {
              localObject = this.mDrawableList;
              j = i - 1;
            }
          }
        }
        finally {}
        try
        {
          ((Vector)localObject).remove(i);
          i = j;
        }
        finally
        {
          continue;
          continue;
        }
        i += 1;
      }
      if (((WeakReference)localObject).get() == paramQQLiveDrawable)
      {
        paramQQLiveDrawable = this.mDrawableList;
        paramQQLiveDrawable.remove(i);
      }
    }
    else
    {
      return;
      return;
    }
  }
  
  protected void draw(Canvas paramCanvas, Rect paramRect, Paint paramPaint)
  {
    System.currentTimeMillis();
    if (this.mCurFrameBitmap != null) {}
    for (;;)
    {
      synchronized (this.mLock)
      {
        paramCanvas.drawBitmap(this.mCurFrameBitmap, null, paramRect, paramPaint);
        if ((this.mVideoPlayer == null) && (!this.mPaused)) {
          initAndStartPlayer(this.mParams.mStartPosi);
        }
        return;
      }
      if (this.mCoverBitmap != null)
      {
        paramCanvas.drawBitmap(this.mCoverBitmap, null, paramRect, paramPaint);
      }
      else if (this.mParams.mCoverLoadingDrawable != null)
      {
        if (!this.mParams.mCoverLoadingDrawable.getBounds().equals(paramRect)) {
          this.mParams.mCoverLoadingDrawable.setBounds(paramRect);
        }
        this.mParams.mCoverLoadingDrawable.draw(paramCanvas);
      }
    }
  }
  
  protected void finalize()
    throws Throwable
  {
    if (this.mVideoPlayer != null) {
      release();
    }
  }
  
  public int getByteSize()
  {
    return 0 + Utils.getBitmapSize(this.mCoverBitmap) + Utils.getBitmapSize(this.mCurFrameBitmap);
  }
  
  public long getCurrentPosition()
  {
    long l = -1L;
    if (this.mVideoPlayer != null) {
      l = this.mVideoPlayer.getCurrentPostion();
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG + this.ID, 2, "getCurrentPosition() curPosi = " + l);
    }
    return l;
  }
  
  public int getHeight()
  {
    if (this.mCurFrameBitmap != null) {
      return this.mCurFrameBitmap.getHeight();
    }
    return this.mParams.mPreviewHeight;
  }
  
  public int getScaledHeight(int paramInt)
  {
    return scaleFromDensity(getHeight(), this.mDensity, paramInt);
  }
  
  public int getScaledWidth(int paramInt)
  {
    return scaleFromDensity(getWidth(), this.mDensity, paramInt);
  }
  
  public int getWidth()
  {
    if (this.mCurFrameBitmap != null) {
      return this.mCurFrameBitmap.getWidth();
    }
    return this.mParams.mPreviewWidth;
  }
  
  protected void initAndStartPlayer(int paramInt)
  {
    if ((this.mPaused) && (QLog.isColorLevel())) {
      QLog.d(TAG + this.ID, 2, "initAndStartPlayer(): paused, just return");
    }
    if (sImageList == null) {
      sImageList = new ArrayList();
    }
    Object localObject1 = sImageList;
    int j = 0;
    int i = 0;
    for (;;)
    {
      int k;
      long l1;
      try
      {
        if (i < sImageList.size())
        {
          WeakReference localWeakReference = (WeakReference)sImageList.get(i);
          k = j;
          if (localWeakReference == null) {
            break label1055;
          }
          k = j;
          if (localWeakReference.get() != this) {
            break label1055;
          }
          k = 1;
          break label1055;
        }
        if (j == 0) {
          sImageList.add(new WeakReference(this));
        }
        l1 = System.currentTimeMillis();
        changeStateAndNotify(3, null);
        localObject1 = getApplicationContext();
        if (!mSDKInited)
        {
          TVK_SDKMgr.setDebugEnable(mIsDebugEnable);
          TVK_SDKMgr.initSdk((Context)localObject1, "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
          TVK_SDKMgr.setPreloadMaxStorageSize(209715200L);
          TVK_SDKMgr.setOnLogListener(new OnLogListener(null));
          mSDKInited = true;
        }
        if (!TVK_SDKMgr.isInstalled((Context)localObject1))
        {
          if (QLog.isColorLevel()) {
            QLog.e(TAG + this.ID, 2, "initAndStartPlayer(): TVK_SDKMgr not install, mInstallProgress = " + mInstallProgress);
          }
          if (!mInstallProgress.get()) {
            TVK_SDKMgr.installPlugin((Context)localObject1, new SDKInstallListener(null));
          }
          return;
        }
      }
      finally {}
      if (TextUtils.isEmpty(this.mParams.mDataSource))
      {
        if (QLog.isColorLevel()) {
          QLog.e(TAG + this.ID, 2, "initAndStartPlayer(): mParams.mDataSource == null, return null ");
        }
        changeStateAndNotify(5, null);
        return;
      }
      if (this.mParams.mDataSourceType == 2)
      {
        if (this.mParams.mDataSourceAdapter != null)
        {
          i = this.mParams.mDataSourceAdapter.getStaus();
          if (QLog.isColorLevel()) {
            QLog.d(TAG + this.ID, 2, "initAndStartPlayer(): DATA_SOURCE_TYPE_THIRD，status = " + i);
          }
          if (i == 0)
          {
            this.mParams.mDataSourceAdapter.requestPrepare(this.mParams.mDataSource, new AbsThirdDataSourceAdapter.OnPreparedCallback()
            {
              public void onPrepared(String paramAnonymousString)
              {
                if (QLog.isColorLevel()) {
                  QLog.d(QQLiveImage.TAG + QQLiveImage.this.ID, 2, "initAndStartPlayer(): DATA_SOURCE_TYPE_THIRD，onPrepared = " + paramAnonymousString);
                }
                QQLiveImage.this.initAndStartPlayer(QQLiveImage.this.mParams.mStartPosi);
              }
            });
            return;
          }
          if (i == 1) {
            continue;
          }
        }
      }
      else
      {
        this.mfactory = TVK_SDKMgr.getProxyFactory();
        this.mVideoPlayer = this.mfactory.createMediaPlayer((Context)localObject1, null);
        if (this.mVideoPlayer != null) {
          break label545;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e(TAG + this.ID, 2, "initAndStartPlayer(): mVideoPlayer == null, return null ");
        return;
      }
      throw new IllegalArgumentException("DATA_SOURCE_TYPE_THIRD, mParams.mDataSourceAdapter should not be null!");
      label545:
      this.mUserinfo = new TVK_UserInfo("", "");
      if (this.mParams.mDataSourceType == 0)
      {
        this.mPlayerinfo = new TVK_PlayerVideoInfo(8, this.mParams.mDataSource, "");
        label595:
        if (this.mParams.mPlayType == 1) {
          this.mPlayerinfo.setPlayType(1);
        }
        this.mPlayerinfo.setPlayMode("extern_video_output");
        localObject1 = new HashMap();
        ((Map)localObject1).put("shouq_bus_type", "bus_type_aio");
        this.mPlayerinfo.setReportInfoMap((Map)localObject1);
        this.mVideoPlayer.setOnVideoOutputFrameListener(this);
        this.mVideoPlayer.setOnInfoListener(this);
        this.mVideoPlayer.setOnPreAdListener(this);
        this.mVideoPlayer.setOnCompletionListener(this);
        this.mVideoPlayer.setOnVideoPreparedListener(this);
        this.mVideoPlayer.setOnErrorListener(this);
        this.mVideoPlayer.setOnSeekCompleteListener(this);
        this.mVideoPlayer.setLoopback(true);
        this.mVideoPlayer.setOutputMute(this.mParams.mMute);
      }
      try
      {
        if (this.mParams.mDataSourceType == 0) {
          this.mVideoPlayer.openMediaPlayer(getApplicationContext(), this.mUserinfo, this.mPlayerinfo, "sd", paramInt, 0L);
        }
        for (;;)
        {
          long l2 = System.currentTimeMillis();
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d(TAG + this.ID, 2, "initAndStartPlayer(): startPosi = " + paramInt + ", cost =" + (l2 - l1) + "ms");
          return;
          if ((this.mParams.mDataSourceType != 1) && (this.mParams.mDataSourceType != 2)) {
            break label595;
          }
          this.mPlayerinfo = new TVK_PlayerVideoInfo();
          break label595;
          if (this.mParams.mDataSourceType != 1) {
            break label988;
          }
          this.mVideoPlayer.openMediaPlayerByUrl(getApplicationContext(), this.mParams.mDataSource, paramInt, 0L, this.mPlayerinfo);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d(TAG + this.ID, 2, "initAndStartPlayer(): error happens in openMediaPlayerByUrl ", localException);
          }
          changeStateAndNotify(5, null);
          continue;
          label988:
          if ((this.mParams.mDataSourceType == 2) && (this.mParams.mDataSourceAdapter != null) && (this.mParams.mDataSourceAdapter.getStaus() == 2)) {
            this.mVideoPlayer.openMediaPlayerByUrl(getApplicationContext(), this.mParams.mDataSourceAdapter.getURL(), paramInt, 0L, this.mPlayerinfo);
          }
        }
      }
      label1055:
      i += 1;
      j = k;
    }
  }
  
  protected void invalidateSelf()
  {
    Vector localVector = this.mDrawableList;
    int i = 0;
    for (;;)
    {
      Object localObject1;
      int j;
      try
      {
        if (i < this.mDrawableList.size())
        {
          localObject1 = (WeakReference)this.mDrawableList.get(i);
          if ((localObject1 == null) || (((WeakReference)localObject1).get() == null))
          {
            localObject1 = this.mDrawableList;
            j = i - 1;
          }
        }
      }
      finally {}
      try
      {
        ((Vector)localObject1).remove(i);
        i = j;
        i += 1;
      }
      finally
      {
        for (;;) {}
      }
      ((QQLiveDrawable)((WeakReference)localObject1).get()).invalidateSelf();
    }
    return;
    throw ((Throwable)localObject2);
  }
  
  public boolean isPaused()
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG + this.ID, 2, "isPaused(): mPaused = " + this.mPaused);
    }
    return this.mPaused;
  }
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG + this.ID, 2, "[TVK_IMediaPlayer] onCompletion(): ");
    }
  }
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    this.mErrorInfo.model = paramInt1;
    this.mErrorInfo.what = paramInt2;
    this.mErrorInfo.extra = paramInt3;
    this.mErrorInfo.detailInfo = paramString;
    this.mErrorInfo.info = paramObject;
    if (QLog.isColorLevel()) {
      QLog.e(TAG + this.ID, 2, this.mErrorInfo.toString() + "\n" + this.mParams.toString());
    }
    if (this.mVideoPlayer != null)
    {
      Utils.executeAsyncTaskOnThreadPool(new ReleaseTask(this.mVideoPlayer, false), null);
      this.mVideoPlayer = null;
    }
    this.mPrepared = false;
    changeStateAndNotify(5, this.mErrorInfo);
    return false;
  }
  
  public boolean onInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d(TAG + this.ID, 2, "[TVK_IMediaPlayer] onInfo(): 视频开始缓冲==>");
      }
      changeStateAndNotify(3, null);
      continue;
      if (QLog.isColorLevel()) {
        QLog.d(TAG + this.ID, 2, "[TVK_IMediaPlayer] onInfo(): 视频缓冲结束<==");
      }
      changeStateAndNotify(2, null);
    }
  }
  
  public void onPreAdPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG + this.ID, 2, "[TVK_IMediaPlayer] onPreAdPrepared(): adDuration = " + paramLong);
    }
    this.mVideoPlayer.start();
  }
  
  public void onPreAdPreparing(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG + this.ID, 2, "[TVK_IMediaPlayer] onPreAdPreparing(): ");
    }
  }
  
  public void onSeekComplete(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (!this.mPaused)
    {
      if (this.mVideoPlayer != null) {
        this.mVideoPlayer.start();
      }
      if (QLog.isColorLevel()) {
        QLog.d(TAG + this.ID, 2, "[TVK_IMediaPlayer] onSeekComplete, start ");
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e(TAG + this.ID, 2, "[TVK_IMediaPlayer] onSeekComplete, paused, just return.");
  }
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (!this.mPaused)
    {
      if (this.mVideoPlayer != null) {
        this.mVideoPlayer.start();
      }
      int i = paramTVK_IMediaPlayer.getVideoWidth();
      int j = paramTVK_IMediaPlayer.getVideoHeight();
      if (QLog.isColorLevel()) {
        QLog.i(TAG + this.ID, 2, "[TVK_IMediaPlayer] onVideoPrepared(): width = " + i + ", height = " + j + ", mParams = " + this.mParams.toString());
      }
    }
    for (;;)
    {
      this.mPrepared = true;
      changeStateAndNotify(1, null);
      return;
      if (QLog.isColorLevel()) {
        QLog.e(TAG + this.ID, 2, "[TVK_IMediaPlayer] onVideoPrepared(): But paused, return. ");
      }
    }
  }
  
  public void pause()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    if (!this.mPaused)
    {
      if (this.mVideoPlayer == null) {
        break label176;
      }
      if (!this.mVideoPlayer.isPlaying()) {
        break label122;
      }
      localStringBuilder.append("step: mVideoPlayer.isPlaying, pause;");
      this.mVideoPlayer.pause();
    }
    for (;;)
    {
      this.mPaused = true;
      changeStateAndNotify(4, null);
      if (QLog.isColorLevel()) {
        QLog.d(TAG + this.ID, 2, "pause():  " + localStringBuilder.toString());
      }
      return;
      label122:
      if (this.mVideoPlayer.isPauseing())
      {
        localStringBuilder.append("step: mVideoPlayer.isPauseing, do nothing;");
      }
      else
      {
        localStringBuilder.append("step: player unknow status，prepared=" + this.mPrepared);
        continue;
        label176:
        localStringBuilder.append("step: player = null.");
        invalidateSelf();
      }
    }
  }
  
  public void recyleAndKeepPostion()
  {
    if (this.mVideoPlayer != null)
    {
      this.mReclyed = true;
      this.mPlayPostionWhenRecyle = ((int)this.mVideoPlayer.getCurrentPostion());
      Utils.executeAsyncTaskOnThreadPool(new ReleaseTask(this.mVideoPlayer, true), null);
      this.mVideoPlayer = null;
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "recyleAndKeepPostion()");
      }
    }
    this.mOnStateListener = null;
    if (this.mParams != null) {
      this.mParams.mListener = null;
    }
    this.mState = 0;
    this.mPaused = false;
    this.mPrepared = false;
  }
  
  protected void release()
  {
    long l1 = System.currentTimeMillis();
    if (this.mVideoPlayer != null)
    {
      Utils.executeAsyncTaskOnThreadPool(new ReleaseTask(this.mVideoPlayer, false), null);
      this.mVideoPlayer = null;
    }
    this.mCurFrameBitmap = null;
    this.mCover = null;
    this.mCoverBitmap = null;
    this.mOnStateListener = null;
    this.mParams.mListener = null;
    this.mState = 0;
    this.mFrameIndex = 0;
    this.mPaused = false;
    this.mPrepared = false;
    this.mParams = null;
    this.mReclyed = false;
    this.mPlayPostionWhenRecyle = -1;
    Object localObject = null;
    if (URLDrawable.sMemoryCache != null) {
      localObject = URLDrawable.sMemoryCache.remove(this.mUrlStr);
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d(TAG + this.ID, 2, "release()..., removeObj = " + localObject + ", cost = " + (l2 - l1));
    }
  }
  
  public void resume()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    if (this.mState != 5) {
      if (this.mVideoPlayer != null) {
        if (this.mVideoPlayer.isPlaying())
        {
          localStringBuilder.append("step: mVideoPlayer.isPlaying, do nothing;");
          this.mPaused = false;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG + this.ID, 2, "resume(): " + localStringBuilder.toString());
      }
      return;
      if (this.mVideoPlayer.isPauseing())
      {
        this.mVideoPlayer.start();
        localStringBuilder.append("step: mVideoPlayer.isPauseing, start;");
        break;
      }
      localStringBuilder.append("step: #player unknow status#").append(", playState=" + getStateStr(this.mState));
      if (this.mPrepared)
      {
        this.mVideoPlayer.start();
        localStringBuilder.append(" prepared. start;");
        break;
      }
      localStringBuilder.append(" not prepared. wait buffering;");
      changeStateAndNotify(3, null);
      break;
      localStringBuilder.append("step: player = null.");
      invalidateSelf();
      changeStateAndNotify(3, null);
      if ((!this.mReclyed) || (this.mPlayPostionWhenRecyle <= -1)) {
        break;
      }
      localStringBuilder.append("step: mReclyed, mPlayPostionWhenRecyle:").append(this.mPlayPostionWhenRecyle);
      this.mParams.mStartPosi = this.mPlayPostionWhenRecyle;
      this.mReclyed = false;
      this.mPlayPostionWhenRecyle = -1;
      break;
      changeStateAndNotify(5, null);
      localStringBuilder.append("step: STATE_ERROR, just notify");
    }
  }
  
  public void resumeFromPosi(int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("");
    if (this.mVideoPlayer != null) {
      if (this.mVideoPlayer.isPlaying())
      {
        localStringBuilder.append("step: mVideoPlayer.isPlaying, seekto");
        this.mVideoPlayer.seekTo(paramInt);
      }
    }
    for (;;)
    {
      this.mPaused = false;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(TAG + this.ID, 2, "resumeFromPosi(): " + localStringBuilder.toString() + ", position = " + paramInt);
      return;
      if (this.mVideoPlayer.isPauseing())
      {
        localStringBuilder.append("step: mVideoPlayer.isPauseing, seekto;");
        this.mVideoPlayer.seekTo(paramInt);
      }
      else
      {
        localStringBuilder.append("step: #player unknow status#").append(", playState=" + getStateStr(this.mState));
        if (this.mPrepared)
        {
          this.mVideoPlayer.seekTo(paramInt);
          localStringBuilder.append(" prepared. seekTo;");
        }
        else
        {
          localStringBuilder.append(" not prepared. reset, wait buffering;");
          invalidateSelf();
          this.mVideoPlayer = null;
          this.mPrepared = false;
          changeStateAndNotify(3, null);
          continue;
          localStringBuilder.append("step: player = null.");
          this.mPrepared = false;
          invalidateSelf();
          changeStateAndNotify(3, null);
        }
      }
    }
  }
  
  protected void setOnStateListener(QQLiveDrawable.OnStateListener paramOnStateListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG + this.ID, 2, "setOnStateListener(): mState = " + getStateStr(this.mState));
    }
    if (paramOnStateListener != null)
    {
      this.mOnStateListener = paramOnStateListener;
      if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
        this.mOnStateListener.onStateChange(this.mState, null);
      }
    }
    else
    {
      return;
    }
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        if (QQLiveImage.this.mOnStateListener != null) {
          QQLiveImage.this.mOnStateListener.onStateChange(QQLiveImage.this.mState, null);
        }
      }
    });
  }
  
  class EventHandler
    extends Handler
  {
    public EventHandler(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        return;
      }
      QQLiveImage.this.invalidateSelf();
    }
  }
  
  private static class OnLogListener
    implements TVK_SDKMgr.OnLogListener
  {
    public int d(String paramString1, String paramString2)
    {
      if (QLog.isColorLevel()) {
        QLog.d(paramString1, 2, paramString2);
      }
      return 0;
    }
    
    public int e(String paramString1, String paramString2)
    {
      if (QLog.isColorLevel()) {
        QLog.e(paramString1, 2, paramString2);
      }
      return 0;
    }
    
    public int i(String paramString1, String paramString2)
    {
      if (QLog.isColorLevel()) {
        QLog.i(paramString1, 2, paramString2);
      }
      return 0;
    }
    
    public int v(String paramString1, String paramString2)
    {
      if (QLog.isColorLevel()) {
        QLog.d(paramString1, 2, paramString2);
      }
      return 0;
    }
    
    public int w(String paramString1, String paramString2)
    {
      if (QLog.isColorLevel()) {
        QLog.w(paramString1, 2, paramString2);
      }
      return 0;
    }
  }
  
  class ReleaseTask
    extends AsyncTask<Void, Void, Void>
  {
    boolean keepPosition;
    TVK_IMediaPlayer videoPlayer;
    
    public ReleaseTask(TVK_IMediaPlayer paramTVK_IMediaPlayer, boolean paramBoolean)
    {
      this.videoPlayer = paramTVK_IMediaPlayer;
      this.keepPosition = paramBoolean;
    }
    
    protected Void doInBackground(Void... paramVarArgs)
    {
      if (this.videoPlayer != null)
      {
        if (this.keepPosition) {
          QQLiveImage.access$302(QQLiveImage.this, (int)this.videoPlayer.getCurrentPostion());
        }
        this.videoPlayer.stop();
        this.videoPlayer.release();
        this.videoPlayer = null;
        if (QLog.isColorLevel()) {
          QLog.w(QQLiveImage.TAG, 2, "ReleaseTask release TVK_IMediaPlayer");
        }
      }
      return null;
    }
  }
  
  private static class SDKInstallListener
    implements TVK_SDKMgr.InstallListener
  {
    public void onInstallProgress(float paramFloat)
    {
      QQLiveImage.mInstallProgress.set(false);
      if (QLog.isDevelopLevel()) {
        QLog.d(QQLiveImage.TAG, 4, "[SDKInstallListener] onInstallProgress(): v= " + paramFloat);
      }
    }
    
    public void onInstalledFailed(int paramInt)
    {
      QQLiveImage.mInstallProgress.set(false);
      if (QLog.isColorLevel()) {
        QLog.e(QQLiveImage.TAG, 2, "[SDKInstallListener] onInstalledFailed():");
      }
    }
    
    public void onInstalledSuccessed()
    {
      if (QLog.isColorLevel()) {
        QLog.d(QQLiveImage.TAG, 2, "[SDKInstallListener] onInstalledSuccessed():");
      }
      QQLiveImage.mInstallProgress.set(false);
      if (QQLiveImage.sImageList != null)
      {
        int i = 0;
        while (i < QQLiveImage.sImageList.size())
        {
          Object localObject = (WeakReference)QQLiveImage.sImageList.get(i);
          if ((localObject != null) && (((WeakReference)localObject).get() != null))
          {
            localObject = (QQLiveImage)((WeakReference)localObject).get();
            ((QQLiveImage)localObject).initAndStartPlayer(((QQLiveImage)localObject).mParams.mStartPosi);
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\image\QQLiveImage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */