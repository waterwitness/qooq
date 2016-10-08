package com.tencent.image;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.widget.Toast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.video.decode.AVAudioParam;
import com.tencent.video.decode.AVDecodeFactory;
import com.tencent.video.decode.AVDecodeOption;
import com.tencent.video.decode.AVVideoParam;
import com.tencent.video.decode.AVideoException;
import com.tencent.video.decode.AbstractAVDecode;
import com.tencent.video.decode.ShortVideoSoLoad;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class NativeVideoImage
  extends AbstractVideoImage
{
  static final int DEFAULT_AUDIO_FORMAT = 65281;
  public static final Bitmap.Config DEFAULT_CONFIG;
  public static String TAG = "URLDrawable_" + NativeVideoImage.class.getSimpleName() + "_";
  static final String TAG_AUDIO = TAG + "_Audio";
  private static int TIME_BASE;
  static Handler sDecodeHander;
  static HandlerThread sDecodeThread;
  static boolean sLibLoaded = false;
  static Handler sReleaseHandler;
  protected static Handler sUIHandler;
  static boolean sVideoEngineAvaliable = true;
  static HandlerThread sWorkThread = new HandlerThread("Video-Release-Task");
  private int ID = -1;
  public boolean debug = true;
  private long drawTime = -1L;
  protected volatile AbstractAVDecode mAVDecode;
  protected DoAccumulativeRunnable mAccumulativeRunnable;
  private int mAudioFrameDuration = -1;
  private Object mAudioLock = new Object();
  private volatile boolean mAudioThreadFinish = true;
  AudioTrack mAudioTrack;
  private Bitmap mCompatibleBitmap = null;
  private AtomicInteger mCount = new AtomicInteger(0);
  protected Bitmap mCurFrameBitmap;
  protected Bitmap mCurFrameBitmapBuffer;
  protected Bitmap.Config mCurrentConfig = DEFAULT_CONFIG;
  private DataReport mDataReport;
  protected volatile boolean mDecodeNextFrameEnd = true;
  public float mDefaultRoundCorner = 0.0F;
  private boolean mEnableAntiAlias = false;
  private boolean mEnableFilter = false;
  protected Bitmap mFirstFrameBitmap;
  private Object mLock = new Object();
  AVDecodeOption mOption;
  volatile boolean mPlayAudioFrame = false;
  volatile boolean mPlayAudioOnceFinished = true;
  PlayAudioThread mPlayAudioThread;
  int mPlayRepeatCount = 0;
  int mReqHeight = 0;
  int mReqWidth = 0;
  boolean mResetFlag = false;
  private int mRotation;
  protected final String mSrcVideoFile;
  private float mTotalDeviation = 0.0F;
  private volatile boolean mVideoDecodeFinish = false;
  private int mVideoFrameDuration = -1;
  VideoDrawable.VideoDrawableParams mVideoParams;
  int mlastVideoFrameIndex = 0;
  private long refreshTime = -1L;
  int sImageIndex = 0;
  
  static
  {
    sWorkThread.start();
    sReleaseHandler = new Handler(sWorkThread.getLooper());
    sDecodeThread = new HandlerThread("Video-Decode-Thread");
    sDecodeThread.start();
    sDecodeHander = new Handler(sDecodeThread.getLooper());
    DEFAULT_CONFIG = Bitmap.Config.ARGB_8888;
    TIME_BASE = 12;
    sUIHandler = new Handler(Looper.getMainLooper());
  }
  
  public NativeVideoImage(File paramFile, boolean paramBoolean)
  {
    this(paramFile, paramBoolean, 0, 0, null);
  }
  
  public NativeVideoImage(File paramFile, boolean paramBoolean, int paramInt1, int paramInt2, Object paramObject)
  {
    this.mSrcVideoFile = paramFile.getAbsolutePath();
    this.ID = this.mSrcVideoFile.hashCode();
    if ((QLog.isColorLevel()) && (paramObject != null)) {
      QLog.d(TAG + this.ID, 2, "NativeVideoImage(): cacheFirstFrame=" + paramBoolean + ", maxWidth= " + paramInt1 + ", maxHeight= " + paramInt2 + ", videoParams= " + paramObject.toString());
    }
    if ((paramObject != null) && (VideoDrawable.VideoDrawableParams.class.isInstance(paramObject))) {
      this.mVideoParams = ((VideoDrawable.VideoDrawableParams)paramObject);
    }
    for (;;)
    {
      boolean bool = this.mVideoParams.mPlayAudioFrame;
      this.mPlayAudioFrame = bool;
      this.debug = bool;
      this.mDefaultRoundCorner = this.mVideoParams.mVideoRoundCorner;
      this.mEnableAntiAlias = this.mVideoParams.mEnableAntiAlias;
      this.mEnableFilter = this.mVideoParams.mEnableFilter;
      this.mOption = new AVDecodeOption();
      bool = loopEnable;
      if (this.mPlayAudioFrame) {
        bool = false;
      }
      this.mOption.cycle = bool;
      paramObject = this.mOption;
      if (!this.mPlayAudioFrame)
      {
        bool = true;
        ((AVDecodeOption)paramObject).ignore_audio = bool;
        this.mOption.only_keyframe = false;
        this.mOption.filename = this.mSrcVideoFile;
        this.mOption.audioFormat = 65281;
        this.mOption.wantedFps = this.mVideoParams.mRequestedFPS;
        this.mOption.mDecodeType = this.mVideoParams.mDecodeType;
        this.mOption.mVfPath = this.mVideoParams.mVfPath;
        this.mOption.mAfPath = this.mVideoParams.mAfPath;
        this.mOption.mTotalTime = this.mVideoParams.mTotalTime;
        this.mOption.mVideoFrames = this.mVideoParams.mVideoFrames;
      }
      try
      {
        this.mAVDecode = AVDecodeFactory.newDecodeUncatched(this.mOption);
        if ((this.mAVDecode == null) && (QLog.isColorLevel())) {
          QLog.e(TAG + this.ID, 2, "NativeVideoImage()[mAVDecode == null]....");
        }
        this.mRotation = this.mAVDecode.videoParam.rotation;
        int n = this.mAVDecode.videoParam.fps_den;
        int i1 = this.mAVDecode.videoParam.fps_num;
        float f3 = i1 * 1.0F / n;
        if (this.mAVDecode.audioParam.errcode == -106)
        {
          this.mPlayAudioFrame = false;
          if (QLog.isColorLevel()) {
            QLog.e(TAG + this.ID, 2, "NativeVideoImage() => VIDEO_NO_MEDIA_DATA_ERR, 不存在音频数据, mSrcVideoFile=" + this.mSrcVideoFile);
          }
        }
        paramFile = getFrameSize(paramFile);
        int m = paramFile.width();
        int k = paramFile.height();
        int j = k;
        int i = m;
        if (paramInt1 > 0)
        {
          j = k;
          i = m;
          if (paramInt2 > 0)
          {
            f1 = paramInt1 / m;
            f2 = paramInt2 / k;
            if (f1 >= f2) {
              break label1127;
            }
            j = k;
            i = m;
            if (f1 < 1.0F)
            {
              i = (int)(m * f1);
              j = (int)(k * f1);
            }
          }
        }
        this.mReqWidth = i;
        this.mReqHeight = j;
        if (QLog.isColorLevel())
        {
          paramFile = new StringBuilder();
          paramFile.append("videoParams[ frame_count:").append(this.mAVDecode.videoParam.frame_count);
          paramFile.append("\n mSrcVideoFile:").append(this.mSrcVideoFile);
          paramFile.append("\n duration:").append(this.mAVDecode.videoParam.duration);
          paramFile.append("\n fps_den:").append(n);
          paramFile.append("\n fps_num:").append(i1);
          paramFile.append("\n fps:").append(f3);
          paramFile.append("\n mReqWidth:").append(this.mReqWidth);
          paramFile.append("\n mReqHeight:").append(this.mReqHeight);
          paramFile.append("\n mRotation:").append(this.mRotation);
          QLog.d(TAG + this.ID, 2, " NativeVideoImage(): " + paramFile.toString());
        }
        init(paramBoolean);
        this.mDataReport = new DataReport();
        return;
        if (paramObject == null) {
          continue;
        }
        throw new RuntimeException(" NativeVideoImage(): videoParams is illegal, not VideoDrawableParams, " + paramObject.toString());
        bool = false;
      }
      catch (AVideoException paramObject)
      {
        for (;;)
        {
          float f1;
          float f2;
          ((AVideoException)paramObject).printStackTrace();
          if (QLog.isColorLevel())
          {
            QLog.e(TAG + this.ID, 2, "NativeVideoImage()[newDecodeUncatched]", (Throwable)paramObject);
            continue;
            label1127:
            f1 = f2;
          }
        }
      }
    }
  }
  
  static void loadLibrary(Context paramContext)
  {
    if (!sLibLoaded) {}
    for (;;)
    {
      try
      {
        int i = ShortVideoSoLoad.LoadExtractedShortVideoSo("AVCodec", paramContext);
        if (i != 0) {
          continue;
        }
        sVideoEngineAvaliable = true;
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "loadLibrary(): status=" + i);
        }
      }
      catch (Throwable paramContext)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e(TAG, 2, "System.loadLibrary(AVCodec) failed");
        paramContext.printStackTrace();
        continue;
      }
      sLibLoaded = true;
      return;
      if (QLog.isColorLevel()) {
        QLog.e(TAG, 2, "loadLibrary() failure....");
      }
    }
  }
  
  /* Error */
  protected void applyNextFrame()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 496	java/lang/System:currentTimeMillis	()J
    //   5: lstore 4
    //   7: new 498	android/graphics/Canvas
    //   10: dup
    //   11: aload_0
    //   12: getfield 500	com/tencent/image/NativeVideoImage:mCurFrameBitmap	Landroid/graphics/Bitmap;
    //   15: invokespecial 503	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   18: astore_1
    //   19: aload_0
    //   20: getfield 500	com/tencent/image/NativeVideoImage:mCurFrameBitmap	Landroid/graphics/Bitmap;
    //   23: iconst_0
    //   24: invokevirtual 508	android/graphics/Bitmap:eraseColor	(I)V
    //   27: new 510	android/graphics/Paint
    //   30: dup
    //   31: invokespecial 511	android/graphics/Paint:<init>	()V
    //   34: astore_2
    //   35: aload_0
    //   36: getfield 198	com/tencent/image/NativeVideoImage:mDefaultRoundCorner	F
    //   39: fconst_0
    //   40: fcmpl
    //   41: ifle +66 -> 107
    //   44: aload_2
    //   45: iconst_1
    //   46: invokevirtual 514	android/graphics/Paint:setAntiAlias	(Z)V
    //   49: aload_2
    //   50: iconst_1
    //   51: invokevirtual 517	android/graphics/Paint:setFilterBitmap	(Z)V
    //   54: aload_1
    //   55: new 519	android/graphics/RectF
    //   58: dup
    //   59: fconst_0
    //   60: fconst_0
    //   61: aload_0
    //   62: getfield 500	com/tencent/image/NativeVideoImage:mCurFrameBitmap	Landroid/graphics/Bitmap;
    //   65: invokevirtual 522	android/graphics/Bitmap:getWidth	()I
    //   68: i2f
    //   69: aload_0
    //   70: getfield 500	com/tencent/image/NativeVideoImage:mCurFrameBitmap	Landroid/graphics/Bitmap;
    //   73: invokevirtual 525	android/graphics/Bitmap:getHeight	()I
    //   76: i2f
    //   77: invokespecial 528	android/graphics/RectF:<init>	(FFFF)V
    //   80: aload_0
    //   81: getfield 198	com/tencent/image/NativeVideoImage:mDefaultRoundCorner	F
    //   84: aload_0
    //   85: getfield 198	com/tencent/image/NativeVideoImage:mDefaultRoundCorner	F
    //   88: aload_2
    //   89: invokevirtual 532	android/graphics/Canvas:drawRoundRect	(Landroid/graphics/RectF;FFLandroid/graphics/Paint;)V
    //   92: aload_2
    //   93: new 534	android/graphics/PorterDuffXfermode
    //   96: dup
    //   97: getstatic 540	android/graphics/PorterDuff$Mode:SRC_IN	Landroid/graphics/PorterDuff$Mode;
    //   100: invokespecial 543	android/graphics/PorterDuffXfermode:<init>	(Landroid/graphics/PorterDuff$Mode;)V
    //   103: invokevirtual 547	android/graphics/Paint:setXfermode	(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;
    //   106: pop
    //   107: aload_0
    //   108: getfield 373	com/tencent/image/NativeVideoImage:mRotation	I
    //   111: ifeq +170 -> 281
    //   114: new 549	android/graphics/Matrix
    //   117: dup
    //   118: invokespecial 550	android/graphics/Matrix:<init>	()V
    //   121: astore_3
    //   122: aload_3
    //   123: aload_0
    //   124: getfield 373	com/tencent/image/NativeVideoImage:mRotation	I
    //   127: i2f
    //   128: aload_0
    //   129: getfield 552	com/tencent/image/NativeVideoImage:mCurFrameBitmapBuffer	Landroid/graphics/Bitmap;
    //   132: invokevirtual 522	android/graphics/Bitmap:getWidth	()I
    //   135: iconst_2
    //   136: idiv
    //   137: i2f
    //   138: aload_0
    //   139: getfield 552	com/tencent/image/NativeVideoImage:mCurFrameBitmapBuffer	Landroid/graphics/Bitmap;
    //   142: invokevirtual 525	android/graphics/Bitmap:getHeight	()I
    //   145: iconst_2
    //   146: idiv
    //   147: i2f
    //   148: invokevirtual 556	android/graphics/Matrix:postRotate	(FFF)Z
    //   151: pop
    //   152: aload_3
    //   153: aload_0
    //   154: getfield 500	com/tencent/image/NativeVideoImage:mCurFrameBitmap	Landroid/graphics/Bitmap;
    //   157: invokevirtual 522	android/graphics/Bitmap:getWidth	()I
    //   160: aload_0
    //   161: getfield 552	com/tencent/image/NativeVideoImage:mCurFrameBitmapBuffer	Landroid/graphics/Bitmap;
    //   164: invokevirtual 522	android/graphics/Bitmap:getWidth	()I
    //   167: isub
    //   168: i2f
    //   169: fconst_2
    //   170: fdiv
    //   171: aload_0
    //   172: getfield 500	com/tencent/image/NativeVideoImage:mCurFrameBitmap	Landroid/graphics/Bitmap;
    //   175: invokevirtual 525	android/graphics/Bitmap:getHeight	()I
    //   178: aload_0
    //   179: getfield 552	com/tencent/image/NativeVideoImage:mCurFrameBitmapBuffer	Landroid/graphics/Bitmap;
    //   182: invokevirtual 525	android/graphics/Bitmap:getHeight	()I
    //   185: isub
    //   186: i2f
    //   187: fconst_2
    //   188: fdiv
    //   189: invokevirtual 560	android/graphics/Matrix:postTranslate	(FF)Z
    //   192: pop
    //   193: aload_1
    //   194: aload_0
    //   195: getfield 552	com/tencent/image/NativeVideoImage:mCurFrameBitmapBuffer	Landroid/graphics/Bitmap;
    //   198: aload_3
    //   199: aload_2
    //   200: invokevirtual 564	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;Landroid/graphics/Paint;)V
    //   203: invokestatic 265	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   206: ifeq +72 -> 278
    //   209: aload_0
    //   210: getfield 186	com/tencent/image/NativeVideoImage:debug	Z
    //   213: ifeq +65 -> 278
    //   216: invokestatic 496	java/lang/System:currentTimeMillis	()J
    //   219: lstore 6
    //   221: new 101	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   228: getstatic 123	com/tencent/image/NativeVideoImage:TAG	Ljava/lang/String;
    //   231: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: aload_0
    //   235: getfield 212	com/tencent/image/NativeVideoImage:ID	I
    //   238: invokevirtual 268	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   241: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: iconst_2
    //   245: new 101	java/lang/StringBuilder
    //   248: dup
    //   249: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   252: ldc_w 566
    //   255: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: lload 6
    //   260: lload 4
    //   262: lsub
    //   263: invokevirtual 569	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   266: ldc_w 571
    //   269: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   275: invokestatic 284	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   278: aload_0
    //   279: monitorexit
    //   280: return
    //   281: aload_1
    //   282: aload_0
    //   283: getfield 552	com/tencent/image/NativeVideoImage:mCurFrameBitmapBuffer	Landroid/graphics/Bitmap;
    //   286: fconst_0
    //   287: fconst_0
    //   288: aload_2
    //   289: invokevirtual 574	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V
    //   292: goto -89 -> 203
    //   295: astore_1
    //   296: aload_0
    //   297: monitorexit
    //   298: aload_1
    //   299: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	300	0	this	NativeVideoImage
    //   18	264	1	localCanvas	Canvas
    //   295	4	1	localObject	Object
    //   34	255	2	localPaint	Paint
    //   121	78	3	localMatrix	android.graphics.Matrix
    //   5	256	4	l1	long
    //   219	40	6	l2	long
    // Exception table:
    //   from	to	target	type
    //   2	107	295	finally
    //   107	203	295	finally
    //   203	278	295	finally
    //   281	292	295	finally
  }
  
  public void disableGlobalPause()
  {
    synchronized (sPauseLock)
    {
      this.mSupportGlobalPause = false;
      sPauseLock.notifyAll();
      return;
    }
  }
  
  protected void doApplyNextFrame(int paramInt)
  {
    this.mDecodeNextFrameEnd = true;
    super.doApplyNextFrame(paramInt);
    if ((QLog.isColorLevel()) && (this.debug)) {
      QLog.d(TAG + this.ID, 2, "doApplyNextFrame: invalidateSelf, index:" + paramInt);
    }
    this.refreshTime = SystemClock.uptimeMillis();
  }
  
  protected void draw(Canvas paramCanvas, Rect paramRect, Paint paramPaint, boolean paramBoolean)
  {
    long l2 = System.currentTimeMillis();
    if (sUIHandler == null) {
      sUIHandler = new Handler();
    }
    if (this.mAccumulativeRunnable == null) {
      this.mAccumulativeRunnable = new DoAccumulativeRunnable();
    }
    if ((QLog.isColorLevel()) && (this.debug)) {
      QLog.d(TAG + this.ID, 2, "======>draw():start");
    }
    this.drawTime = SystemClock.uptimeMillis();
    if (paramPaint != null)
    {
      paramPaint.setAntiAlias(this.mEnableAntiAlias);
      paramPaint.setFilterBitmap(this.mEnableFilter);
    }
    if (this.mCurFrameBitmap != null) {
      paramCanvas.drawBitmap(this.mCurFrameBitmap, null, paramRect, paramPaint);
    }
    long l1 = SystemClock.uptimeMillis() - this.drawTime;
    if (!paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG + this.ID, 2, "draw(): No animation");
      }
      return;
    }
    if (this.mSupportGlobalPause) {
      if (!sPaused)
      {
        executeNewTask(l1);
        if ((this.mPlayAudioFrame) && (this.mOption != null) && (!this.mOption.ignore_audio)) {
          startPlayAudio();
        }
      }
    }
    for (;;)
    {
      l2 = System.currentTimeMillis() - l2;
      if ((!QLog.isColorLevel()) || ((!this.debug) && (l2 <= TIME_BASE))) {
        break;
      }
      QLog.d(TAG + this.ID, 2, "<======draw() end, cost: " + l2 + " ms, drawCost:" + l1);
      return;
      if (!this.mIsInPendingAction)
      {
        sPendingActions.add(new WeakReference(this));
        this.mIsInPendingAction = true;
        continue;
        executeNewTask(l1);
        if ((this.mPlayAudioFrame) && (this.mOption != null) && (!this.mOption.ignore_audio)) {
          startPlayAudio();
        }
      }
    }
  }
  
  protected void executeNewTask(long paramLong)
  {
    if (this.mDecodeNextFrameEnd)
    {
      this.mDecodeNextFrameEnd = false;
      this.mVideoDecodeFinish = false;
      l2 = 0L;
      l1 = l2;
      if (this.drawTime > this.refreshTime)
      {
        l1 = l2;
        if (this.refreshTime != -1L) {
          l1 = this.drawTime - this.refreshTime;
        }
      }
      if (this.mVideoFrameDuration < 0)
      {
        k = this.mAVDecode.videoParam.fps_den;
        m = this.mAVDecode.videoParam.fps_num;
        j = 0;
        if (m > 0)
        {
          this.mTotalDeviation = (k * 1000.0F / m);
          i = (int)this.mTotalDeviation;
          this.mTotalDeviation -= i;
          f = m * 1.0F / k;
          if (QLog.isColorLevel()) {
            QLog.d(TAG + this.ID, 1, "executeNewTask(), fps_den = " + k + ",fps_num = " + m + ",fpsDuration = " + i + ",fps = " + f + " ,mTotalDeviation=" + this.mTotalDeviation + " ,totalFrame=" + this.mAVDecode.videoParam.frame_count);
          }
          if (QLog.isColorLevel()) {
            QLog.d(TAG + this.ID, 1, "executeNewTask()[], mOption.wantedFps = " + this.mOption.wantedFps + " fps=" + f);
          }
          j = i;
          if (this.mOption.wantedFps != 0.0F)
          {
            j = i;
            if (this.mOption.wantedFps >= f / 2.0F)
            {
              j = i;
              if (this.mOption.wantedFps <= f)
              {
                this.mTotalDeviation = (1000.0F / this.mOption.wantedFps);
                i = (int)this.mTotalDeviation;
                this.mTotalDeviation -= i;
                j = i;
                if (QLog.isColorLevel())
                {
                  QLog.d(TAG + this.ID, 1, "executeNewTask(), mOption.wantedFps = " + this.mOption.wantedFps + ",fpsDuration = " + i + ",fps = " + f + ",mVideoParams.mRequestedFPS = " + this.mVideoParams.mRequestedFPS + " ,mTotalDeviation=" + this.mTotalDeviation);
                  j = i;
                }
              }
            }
          }
          if (j <= 0) {
            break label961;
          }
          this.mVideoFrameDuration = j;
          if (QLog.isColorLevel()) {
            QLog.e(TAG + this.ID, 1, "executeNewTask(),1 mVideoFrameDuration = " + this.mVideoFrameDuration);
          }
          if (1 == 0) {
            break label1166;
          }
          l2 = l1;
          if (l1 > 100L) {
            l2 = 100L;
          }
          l3 = paramLong + l2;
          l1 = l3;
          if (l3 >= this.mVideoFrameDuration)
          {
            if ((QLog.isColorLevel()) && (this.debug)) {
              QLog.e(TAG + this.ID, 1, "executeNewTask(), overhead:" + l3 + ", >= frameDuration" + " overhead=" + l3 + " mVideoFrameDuration=" + this.mVideoFrameDuration);
            }
            l1 = this.mVideoFrameDuration;
          }
          l3 = SystemClock.uptimeMillis() + this.mVideoFrameDuration - l1;
          l1 = l2;
          l2 = l3;
          sDecodeHander.post(new DecodeFrameJob(l2));
          if ((QLog.isColorLevel()) && (this.debug)) {
            QLog.d(TAG + this.ID, 2, "executeNewTask(), duration: " + this.mVideoFrameDuration + ", drawCost: " + paramLong + ",refreshCost:" + l1 + ",sync:" + true);
          }
        }
      }
    }
    label961:
    label1166:
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        long l2;
        long l1;
        int k;
        int m;
        int j;
        float f;
        long l3;
        return;
        int i = j;
        if (QLog.isColorLevel())
        {
          QLog.e(TAG + this.ID, 1, "executeNewTask(), error!!  mAVDecode.videoParam.fps_num = " + this.mAVDecode.videoParam.fps_num + ", srcFilePath = " + this.mSrcVideoFile);
          i = j;
          continue;
          if (this.mAVDecode.videoParam.duration > 0)
          {
            this.mVideoFrameDuration = this.mAVDecode.videoParam.duration;
            if (QLog.isColorLevel()) {
              QLog.e(TAG + this.ID, 1, "executeNewTask(),2 mVideoFrameDuration = " + this.mVideoFrameDuration);
            }
          }
          else
          {
            this.mVideoFrameDuration = 50;
            QLog.e(TAG, 1, "executeNewTask(), error... mVideoFrameDuration: " + this.mVideoFrameDuration + ", mAVDecode.videoParam.duration " + this.mAVDecode.videoParam.duration + ", fpsDuration: " + j);
            continue;
            if ((this.mAVDecode != null) && (this.mAVDecode.videoParam != null) && (this.mAVDecode.videoParam.duration > 0) && (this.mVideoFrameDuration != this.mAVDecode.videoParam.duration))
            {
              continue;
              l2 = SystemClock.uptimeMillis() + this.mVideoFrameDuration;
            }
          }
        }
      }
    }
    QLog.e(TAG + this.ID, 1, "executeNewTask(): mDecodeNextFrameEnd false");
  }
  
  protected void finalize()
    throws Throwable
  {
    if (sReleaseHandler != null) {
      sReleaseHandler.post(new ReleaseTask(this.mAVDecode));
    }
  }
  
  @TargetApi(12)
  public int getByteSize()
  {
    long l2 = 0L + Utils.getBitmapSize(this.mCurFrameBitmap) + Utils.getBitmapSize(this.mCurFrameBitmapBuffer) + Utils.getBitmapSize(this.mFirstFrameBitmap);
    long l1 = l2;
    if (this.mCompatibleBitmap != null) {
      l1 = l2 + Utils.getBitmapSize(this.mCompatibleBitmap);
    }
    return (int)l1;
  }
  
  Rect getFrameSize(File paramFile)
  {
    paramFile = new Rect();
    if (this.mAVDecode != null)
    {
      paramFile.set(0, 0, this.mAVDecode.videoParam.width, this.mAVDecode.videoParam.height);
      return paramFile;
    }
    paramFile.set(0, 0, 200, 200);
    return paramFile;
  }
  
  public int getHeight()
  {
    if (this.mCurFrameBitmap != null) {
      return this.mCurFrameBitmap.getHeight();
    }
    return 0;
  }
  
  /* Error */
  protected boolean getNextFrame()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 496	java/lang/System:currentTimeMillis	()J
    //   5: lstore 5
    //   7: aload_0
    //   8: getfield 355	com/tencent/image/NativeVideoImage:mAVDecode	Lcom/tencent/video/decode/AbstractAVDecode;
    //   11: astore_1
    //   12: aload_1
    //   13: getfield 366	com/tencent/video/decode/AbstractAVDecode:videoParam	Lcom/tencent/video/decode/AVVideoParam;
    //   16: getfield 721	com/tencent/video/decode/AVVideoParam:width	I
    //   19: istore_3
    //   20: aload_1
    //   21: getfield 366	com/tencent/video/decode/AbstractAVDecode:videoParam	Lcom/tencent/video/decode/AVVideoParam;
    //   24: getfield 723	com/tencent/video/decode/AVVideoParam:height	I
    //   27: istore 4
    //   29: invokestatic 496	java/lang/System:currentTimeMillis	()J
    //   32: lstore 7
    //   34: aload_0
    //   35: getfield 231	com/tencent/image/NativeVideoImage:mResetFlag	Z
    //   38: ifeq +389 -> 427
    //   41: aload_0
    //   42: iconst_0
    //   43: putfield 231	com/tencent/image/NativeVideoImage:mResetFlag	Z
    //   46: new 183	com/tencent/video/decode/AVideoException
    //   49: dup
    //   50: bipush -110
    //   52: iconst_m1
    //   53: ldc_w 732
    //   56: invokespecial 735	com/tencent/video/decode/AVideoException:<init>	(IILjava/lang/String;)V
    //   59: athrow
    //   60: astore_1
    //   61: invokestatic 265	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   64: ifeq +50 -> 114
    //   67: new 101	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   74: getstatic 123	com/tencent/image/NativeVideoImage:TAG	Ljava/lang/String;
    //   77: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: aload_0
    //   81: getfield 212	com/tencent/image/NativeVideoImage:ID	I
    //   84: invokevirtual 268	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   87: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: iconst_2
    //   91: new 101	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   98: ldc_w 737
    //   101: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: aload_1
    //   105: invokevirtual 740	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokestatic 284	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   114: aload_1
    //   115: getfield 743	com/tencent/video/decode/AVideoException:mErrCode	I
    //   118: bipush -110
    //   120: if_icmpne +716 -> 836
    //   123: aload_0
    //   124: iconst_1
    //   125: putfield 204	com/tencent/image/NativeVideoImage:mVideoDecodeFinish	Z
    //   128: invokestatic 265	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   131: ifeq +33 -> 164
    //   134: new 101	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   141: getstatic 123	com/tencent/image/NativeVideoImage:TAG	Ljava/lang/String;
    //   144: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: aload_0
    //   148: getfield 212	com/tencent/image/NativeVideoImage:ID	I
    //   151: invokevirtual 268	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   154: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: iconst_2
    //   158: ldc_w 745
    //   161: invokestatic 284	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   164: aload_0
    //   165: getfield 246	com/tencent/image/NativeVideoImage:mPlayAudioOnceFinished	Z
    //   168: ifne +46 -> 214
    //   171: aload_0
    //   172: iconst_1
    //   173: putfield 246	com/tencent/image/NativeVideoImage:mPlayAudioOnceFinished	Z
    //   176: aload_0
    //   177: getfield 292	com/tencent/image/NativeVideoImage:mVideoParams	Lcom/tencent/image/VideoDrawable$VideoDrawableParams;
    //   180: astore_1
    //   181: aload_0
    //   182: iconst_0
    //   183: putfield 240	com/tencent/image/NativeVideoImage:mPlayAudioFrame	Z
    //   186: aload_1
    //   187: iconst_0
    //   188: putfield 293	com/tencent/image/VideoDrawable$VideoDrawableParams:mPlayAudioFrame	Z
    //   191: aload_0
    //   192: getfield 303	com/tencent/image/NativeVideoImage:mOption	Lcom/tencent/video/decode/AVDecodeOption;
    //   195: iconst_1
    //   196: putfield 312	com/tencent/video/decode/AVDecodeOption:ignore_audio	Z
    //   199: getstatic 172	com/tencent/image/NativeVideoImage:sUIHandler	Landroid/os/Handler;
    //   202: new 8	com/tencent/image/NativeVideoImage$2
    //   205: dup
    //   206: aload_0
    //   207: invokespecial 748	com/tencent/image/NativeVideoImage$2:<init>	(Lcom/tencent/image/NativeVideoImage;)V
    //   210: invokevirtual 678	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   213: pop
    //   214: aload_0
    //   215: getfield 292	com/tencent/image/NativeVideoImage:mVideoParams	Lcom/tencent/image/VideoDrawable$VideoDrawableParams;
    //   218: getfield 293	com/tencent/image/VideoDrawable$VideoDrawableParams:mPlayAudioFrame	Z
    //   221: ifeq +569 -> 790
    //   224: aload_0
    //   225: getfield 217	com/tencent/image/NativeVideoImage:mLock	Ljava/lang/Object;
    //   228: astore_1
    //   229: aload_1
    //   230: monitorenter
    //   231: getstatic 150	com/tencent/image/NativeVideoImage:sReleaseHandler	Landroid/os/Handler;
    //   234: ifnull +21 -> 255
    //   237: getstatic 150	com/tencent/image/NativeVideoImage:sReleaseHandler	Landroid/os/Handler;
    //   240: new 24	com/tencent/image/NativeVideoImage$ReleaseTask
    //   243: dup
    //   244: aload_0
    //   245: getfield 355	com/tencent/image/NativeVideoImage:mAVDecode	Lcom/tencent/video/decode/AbstractAVDecode;
    //   248: invokespecial 704	com/tencent/image/NativeVideoImage$ReleaseTask:<init>	(Lcom/tencent/video/decode/AbstractAVDecode;)V
    //   251: invokevirtual 678	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   254: pop
    //   255: aload_0
    //   256: aload_0
    //   257: getfield 303	com/tencent/image/NativeVideoImage:mOption	Lcom/tencent/video/decode/AVDecodeOption;
    //   260: invokestatic 751	com/tencent/video/decode/AVDecodeFactory:newDecode	(Lcom/tencent/video/decode/AVDecodeOption;)Lcom/tencent/video/decode/AbstractAVDecode;
    //   263: putfield 355	com/tencent/image/NativeVideoImage:mAVDecode	Lcom/tencent/video/decode/AbstractAVDecode;
    //   266: aload_1
    //   267: monitorexit
    //   268: aload_0
    //   269: getfield 244	com/tencent/image/NativeVideoImage:mAudioLock	Ljava/lang/Object;
    //   272: astore_1
    //   273: aload_1
    //   274: monitorenter
    //   275: aload_0
    //   276: iconst_1
    //   277: putfield 204	com/tencent/image/NativeVideoImage:mVideoDecodeFinish	Z
    //   280: aload_0
    //   281: getfield 244	com/tencent/image/NativeVideoImage:mAudioLock	Ljava/lang/Object;
    //   284: invokevirtual 584	java/lang/Object:notifyAll	()V
    //   287: aload_1
    //   288: monitorexit
    //   289: aload_0
    //   290: aload_0
    //   291: getfield 225	com/tencent/image/NativeVideoImage:sImageIndex	I
    //   294: iconst_1
    //   295: iadd
    //   296: putfield 225	com/tencent/image/NativeVideoImage:sImageIndex	I
    //   299: iconst_1
    //   300: istore 9
    //   302: aload_0
    //   303: getfield 238	com/tencent/image/NativeVideoImage:mCount	Ljava/util/concurrent/atomic/AtomicInteger;
    //   306: iconst_1
    //   307: invokevirtual 755	java/util/concurrent/atomic/AtomicInteger:addAndGet	(I)I
    //   310: pop
    //   311: invokestatic 496	java/lang/System:currentTimeMillis	()J
    //   314: lload 5
    //   316: lsub
    //   317: lstore 5
    //   319: invokestatic 265	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   322: ifeq +100 -> 422
    //   325: aload_0
    //   326: getfield 186	com/tencent/image/NativeVideoImage:debug	Z
    //   329: ifne +18 -> 347
    //   332: lload 5
    //   334: getstatic 165	com/tencent/image/NativeVideoImage:TIME_BASE	I
    //   337: i2l
    //   338: lcmp
    //   339: ifgt +8 -> 347
    //   342: iload 9
    //   344: ifne +78 -> 422
    //   347: new 101	java/lang/StringBuilder
    //   350: dup
    //   351: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   354: getstatic 123	com/tencent/image/NativeVideoImage:TAG	Ljava/lang/String;
    //   357: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: aload_0
    //   361: getfield 212	com/tencent/image/NativeVideoImage:ID	I
    //   364: invokevirtual 268	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   367: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   370: iconst_2
    //   371: new 101	java/lang/StringBuilder
    //   374: dup
    //   375: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   378: ldc_w 757
    //   381: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: lload 5
    //   386: invokevirtual 569	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   389: ldc_w 759
    //   392: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: aload_0
    //   396: getfield 238	com/tencent/image/NativeVideoImage:mCount	Ljava/util/concurrent/atomic/AtomicInteger;
    //   399: invokevirtual 762	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   402: invokevirtual 268	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   405: ldc_w 764
    //   408: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: iload 9
    //   413: invokevirtual 273	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   416: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   419: invokestatic 284	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   422: aload_0
    //   423: monitorexit
    //   424: iload 9
    //   426: ireturn
    //   427: iload_3
    //   428: aload_0
    //   429: getfield 192	com/tencent/image/NativeVideoImage:mReqWidth	I
    //   432: if_icmpne +186 -> 618
    //   435: iload 4
    //   437: aload_0
    //   438: getfield 194	com/tencent/image/NativeVideoImage:mReqHeight	I
    //   441: if_icmpne +177 -> 618
    //   444: aload_1
    //   445: aload_0
    //   446: getfield 552	com/tencent/image/NativeVideoImage:mCurFrameBitmapBuffer	Landroid/graphics/Bitmap;
    //   449: invokevirtual 767	com/tencent/video/decode/AbstractAVDecode:seekToNextFrame	(Landroid/graphics/Bitmap;)V
    //   452: invokestatic 496	java/lang/System:currentTimeMillis	()J
    //   455: lload 7
    //   457: lsub
    //   458: lstore 7
    //   460: invokestatic 265	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   463: ifeq +73 -> 536
    //   466: aload_0
    //   467: getfield 186	com/tencent/image/NativeVideoImage:debug	Z
    //   470: ifne +12 -> 482
    //   473: lload 7
    //   475: ldc2_w 768
    //   478: lcmp
    //   479: ifle +57 -> 536
    //   482: new 101	java/lang/StringBuilder
    //   485: dup
    //   486: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   489: getstatic 123	com/tencent/image/NativeVideoImage:TAG	Ljava/lang/String;
    //   492: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: aload_0
    //   496: getfield 212	com/tencent/image/NativeVideoImage:ID	I
    //   499: invokevirtual 268	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   502: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   505: iconst_2
    //   506: new 101	java/lang/StringBuilder
    //   509: dup
    //   510: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   513: ldc_w 771
    //   516: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   519: lload 7
    //   521: invokevirtual 569	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   524: ldc_w 571
    //   527: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   533: invokestatic 284	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   536: aload_1
    //   537: getfield 366	com/tencent/video/decode/AbstractAVDecode:videoParam	Lcom/tencent/video/decode/AVVideoParam;
    //   540: getfield 774	com/tencent/video/decode/AVVideoParam:frame_index	I
    //   543: istore 4
    //   545: iload 4
    //   547: iconst_1
    //   548: if_icmpne +200 -> 748
    //   551: aload_0
    //   552: getfield 227	com/tencent/image/NativeVideoImage:mlastVideoFrameIndex	I
    //   555: iload 4
    //   557: if_icmple +191 -> 748
    //   560: aload_0
    //   561: aload_0
    //   562: getfield 229	com/tencent/image/NativeVideoImage:mPlayRepeatCount	I
    //   565: iconst_1
    //   566: iadd
    //   567: putfield 229	com/tencent/image/NativeVideoImage:mPlayRepeatCount	I
    //   570: aload_0
    //   571: getfield 777	com/tencent/image/NativeVideoImage:mListener	Ljava/util/ArrayList;
    //   574: astore_1
    //   575: aload_1
    //   576: monitorenter
    //   577: aload_0
    //   578: getfield 777	com/tencent/image/NativeVideoImage:mListener	Ljava/util/ArrayList;
    //   581: invokevirtual 780	java/util/ArrayList:size	()I
    //   584: iconst_1
    //   585: isub
    //   586: istore_3
    //   587: iload_3
    //   588: iflt +158 -> 746
    //   591: aload_0
    //   592: getfield 777	com/tencent/image/NativeVideoImage:mListener	Ljava/util/ArrayList;
    //   595: iload_3
    //   596: invokevirtual 783	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   599: checkcast 785	com/tencent/image/VideoDrawable$OnPlayRepeatListener
    //   602: aload_0
    //   603: getfield 229	com/tencent/image/NativeVideoImage:mPlayRepeatCount	I
    //   606: invokeinterface 788 2 0
    //   611: iload_3
    //   612: iconst_1
    //   613: isub
    //   614: istore_3
    //   615: goto -28 -> 587
    //   618: iload 4
    //   620: ifeq +7 -> 627
    //   623: iload_3
    //   624: ifne +19 -> 643
    //   627: getstatic 123	com/tencent/image/NativeVideoImage:TAG	Ljava/lang/String;
    //   630: iconst_2
    //   631: ldc_w 790
    //   634: invokestatic 360	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   637: iconst_0
    //   638: istore 9
    //   640: goto -218 -> 422
    //   643: aload_0
    //   644: getfield 188	com/tencent/image/NativeVideoImage:mCompatibleBitmap	Landroid/graphics/Bitmap;
    //   647: ifnonnull +17 -> 664
    //   650: aload_0
    //   651: iload_3
    //   652: iload 4
    //   654: aload_0
    //   655: getfield 190	com/tencent/image/NativeVideoImage:mCurrentConfig	Landroid/graphics/Bitmap$Config;
    //   658: invokestatic 794	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   661: putfield 188	com/tencent/image/NativeVideoImage:mCompatibleBitmap	Landroid/graphics/Bitmap;
    //   664: aload_1
    //   665: aload_0
    //   666: getfield 188	com/tencent/image/NativeVideoImage:mCompatibleBitmap	Landroid/graphics/Bitmap;
    //   669: invokevirtual 767	com/tencent/video/decode/AbstractAVDecode:seekToNextFrame	(Landroid/graphics/Bitmap;)V
    //   672: aload_0
    //   673: aload_0
    //   674: getfield 188	com/tencent/image/NativeVideoImage:mCompatibleBitmap	Landroid/graphics/Bitmap;
    //   677: aload_0
    //   678: getfield 192	com/tencent/image/NativeVideoImage:mReqWidth	I
    //   681: aload_0
    //   682: getfield 194	com/tencent/image/NativeVideoImage:mReqHeight	I
    //   685: iconst_1
    //   686: invokestatic 798	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   689: putfield 552	com/tencent/image/NativeVideoImage:mCurFrameBitmapBuffer	Landroid/graphics/Bitmap;
    //   692: goto -240 -> 452
    //   695: astore_1
    //   696: invokestatic 265	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   699: ifeq +10 -> 709
    //   702: aload_0
    //   703: ldc_w 799
    //   706: invokevirtual 802	com/tencent/image/NativeVideoImage:showOOM	(Ljava/lang/String;)V
    //   709: new 101	java/lang/StringBuilder
    //   712: dup
    //   713: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   716: getstatic 123	com/tencent/image/NativeVideoImage:TAG	Ljava/lang/String;
    //   719: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   722: aload_0
    //   723: getfield 212	com/tencent/image/NativeVideoImage:ID	I
    //   726: invokevirtual 268	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   729: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   732: iconst_1
    //   733: ldc_w 804
    //   736: aload_1
    //   737: invokestatic 453	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   740: iconst_0
    //   741: istore 9
    //   743: goto -441 -> 302
    //   746: aload_1
    //   747: monitorexit
    //   748: aload_0
    //   749: iload 4
    //   751: putfield 227	com/tencent/image/NativeVideoImage:mlastVideoFrameIndex	I
    //   754: aload_0
    //   755: aload_0
    //   756: getfield 225	com/tencent/image/NativeVideoImage:sImageIndex	I
    //   759: iconst_1
    //   760: iadd
    //   761: putfield 225	com/tencent/image/NativeVideoImage:sImageIndex	I
    //   764: iconst_1
    //   765: istore 9
    //   767: goto -465 -> 302
    //   770: astore_2
    //   771: aload_1
    //   772: monitorexit
    //   773: aload_2
    //   774: athrow
    //   775: astore_1
    //   776: aload_0
    //   777: monitorexit
    //   778: aload_1
    //   779: athrow
    //   780: astore_2
    //   781: aload_1
    //   782: monitorexit
    //   783: aload_2
    //   784: athrow
    //   785: astore_2
    //   786: aload_1
    //   787: monitorexit
    //   788: aload_2
    //   789: athrow
    //   790: getstatic 150	com/tencent/image/NativeVideoImage:sReleaseHandler	Landroid/os/Handler;
    //   793: ifnull +21 -> 814
    //   796: getstatic 150	com/tencent/image/NativeVideoImage:sReleaseHandler	Landroid/os/Handler;
    //   799: new 24	com/tencent/image/NativeVideoImage$ReleaseTask
    //   802: dup
    //   803: aload_0
    //   804: getfield 355	com/tencent/image/NativeVideoImage:mAVDecode	Lcom/tencent/video/decode/AbstractAVDecode;
    //   807: invokespecial 704	com/tencent/image/NativeVideoImage$ReleaseTask:<init>	(Lcom/tencent/video/decode/AbstractAVDecode;)V
    //   810: invokevirtual 678	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   813: pop
    //   814: aload_0
    //   815: getfield 303	com/tencent/image/NativeVideoImage:mOption	Lcom/tencent/video/decode/AVDecodeOption;
    //   818: iconst_1
    //   819: putfield 309	com/tencent/video/decode/AVDecodeOption:cycle	Z
    //   822: aload_0
    //   823: aload_0
    //   824: getfield 303	com/tencent/image/NativeVideoImage:mOption	Lcom/tencent/video/decode/AVDecodeOption;
    //   827: invokestatic 751	com/tencent/video/decode/AVDecodeFactory:newDecode	(Lcom/tencent/video/decode/AVDecodeOption;)Lcom/tencent/video/decode/AbstractAVDecode;
    //   830: putfield 355	com/tencent/image/NativeVideoImage:mAVDecode	Lcom/tencent/video/decode/AbstractAVDecode;
    //   833: goto -544 -> 289
    //   836: iconst_0
    //   837: istore 9
    //   839: goto -537 -> 302
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	842	0	this	NativeVideoImage
    //   11	10	1	localAbstractAVDecode	AbstractAVDecode
    //   60	55	1	localAVideoException	AVideoException
    //   695	77	1	localOutOfMemoryError	OutOfMemoryError
    //   775	12	1	localObject2	Object
    //   770	4	2	localObject3	Object
    //   780	4	2	localObject4	Object
    //   785	4	2	localObject5	Object
    //   19	633	3	i	int
    //   27	723	4	j	int
    //   5	380	5	l1	long
    //   32	488	7	l2	long
    //   300	538	9	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   29	60	60	com/tencent/video/decode/AVideoException
    //   427	452	60	com/tencent/video/decode/AVideoException
    //   452	473	60	com/tencent/video/decode/AVideoException
    //   482	536	60	com/tencent/video/decode/AVideoException
    //   536	545	60	com/tencent/video/decode/AVideoException
    //   551	577	60	com/tencent/video/decode/AVideoException
    //   627	637	60	com/tencent/video/decode/AVideoException
    //   643	664	60	com/tencent/video/decode/AVideoException
    //   664	692	60	com/tencent/video/decode/AVideoException
    //   748	764	60	com/tencent/video/decode/AVideoException
    //   773	775	60	com/tencent/video/decode/AVideoException
    //   7	29	695	java/lang/OutOfMemoryError
    //   29	60	695	java/lang/OutOfMemoryError
    //   61	114	695	java/lang/OutOfMemoryError
    //   114	164	695	java/lang/OutOfMemoryError
    //   164	214	695	java/lang/OutOfMemoryError
    //   214	231	695	java/lang/OutOfMemoryError
    //   268	275	695	java/lang/OutOfMemoryError
    //   289	299	695	java/lang/OutOfMemoryError
    //   427	452	695	java/lang/OutOfMemoryError
    //   452	473	695	java/lang/OutOfMemoryError
    //   482	536	695	java/lang/OutOfMemoryError
    //   536	545	695	java/lang/OutOfMemoryError
    //   551	577	695	java/lang/OutOfMemoryError
    //   627	637	695	java/lang/OutOfMemoryError
    //   643	664	695	java/lang/OutOfMemoryError
    //   664	692	695	java/lang/OutOfMemoryError
    //   748	764	695	java/lang/OutOfMemoryError
    //   773	775	695	java/lang/OutOfMemoryError
    //   783	785	695	java/lang/OutOfMemoryError
    //   788	790	695	java/lang/OutOfMemoryError
    //   790	814	695	java/lang/OutOfMemoryError
    //   814	833	695	java/lang/OutOfMemoryError
    //   577	587	770	finally
    //   591	611	770	finally
    //   746	748	770	finally
    //   771	773	770	finally
    //   2	7	775	finally
    //   7	29	775	finally
    //   29	60	775	finally
    //   61	114	775	finally
    //   114	164	775	finally
    //   164	214	775	finally
    //   214	231	775	finally
    //   268	275	775	finally
    //   289	299	775	finally
    //   302	342	775	finally
    //   347	422	775	finally
    //   427	452	775	finally
    //   452	473	775	finally
    //   482	536	775	finally
    //   536	545	775	finally
    //   551	577	775	finally
    //   627	637	775	finally
    //   643	664	775	finally
    //   664	692	775	finally
    //   696	709	775	finally
    //   709	740	775	finally
    //   748	764	775	finally
    //   773	775	775	finally
    //   783	785	775	finally
    //   788	790	775	finally
    //   790	814	775	finally
    //   814	833	775	finally
    //   231	255	780	finally
    //   255	268	780	finally
    //   781	783	780	finally
    //   275	289	785	finally
    //   786	788	785	finally
  }
  
  public int getWidth()
  {
    if (this.mCurFrameBitmap != null) {
      return this.mCurFrameBitmap.getWidth();
    }
    return 0;
  }
  
  void init(boolean paramBoolean)
  {
    boolean bool = false;
    if (sVideoEngineAvaliable) {}
    try
    {
      this.mCurFrameBitmapBuffer = Bitmap.createBitmap(this.mReqWidth, this.mReqHeight, this.mCurrentConfig);
    }
    catch (OutOfMemoryError localOutOfMemoryError3)
    {
      try
      {
        if ((this.mRotation != 0) && (this.mRotation != 180))
        {
          this.mCurFrameBitmap = Bitmap.createBitmap(this.mReqHeight, this.mReqWidth, this.mCurrentConfig);
          if (QLog.isColorLevel())
          {
            String str = TAG + this.ID;
            StringBuilder localStringBuilder = new StringBuilder().append("use mCurFrameBitmapBuffer: ");
            if (this.mCurFrameBitmapBuffer != null) {
              bool = true;
            }
            QLog.d(str, 2, bool);
          }
          getNextFrame();
          applyNextFrame();
          if (!paramBoolean) {}
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError3)
      {
        try
        {
          do
          {
            for (;;)
            {
              this.mFirstFrameBitmap = this.mCurFrameBitmap.copy(this.mCurFrameBitmap.getConfig(), false);
              return;
              localOutOfMemoryError1 = localOutOfMemoryError1;
              if (QLog.isColorLevel()) {
                showOOM("create mCurFrameBitmapBuffer");
              }
              if (this.mCurrentConfig == Bitmap.Config.ARGB_8888)
              {
                try
                {
                  this.mCurrentConfig = Bitmap.Config.RGB_565;
                  this.mCurFrameBitmapBuffer = Bitmap.createBitmap(this.mReqWidth, this.mReqHeight, this.mCurrentConfig);
                }
                catch (OutOfMemoryError localOutOfMemoryError2)
                {
                  if (QLog.isColorLevel()) {
                    showOOM("create mCurFrameBitmapBuffer");
                  }
                  URLDrawable.clearMemoryCache();
                  this.mCurFrameBitmapBuffer = Bitmap.createBitmap(this.mReqWidth, this.mReqHeight, this.mCurrentConfig);
                }
              }
              else
              {
                URLDrawable.clearMemoryCache();
                this.mCurFrameBitmapBuffer = Bitmap.createBitmap(this.mReqWidth, this.mReqHeight, this.mCurrentConfig);
                continue;
                this.mCurFrameBitmap = Bitmap.createBitmap(this.mReqWidth, this.mReqHeight, this.mCurrentConfig);
              }
            }
            localOutOfMemoryError3 = localOutOfMemoryError3;
          } while (!QLog.isColorLevel());
          showOOM("create mCurFrameBitmap");
        }
        catch (OutOfMemoryError localOutOfMemoryError4)
        {
          while (!QLog.isColorLevel()) {}
          showOOM("create mFirstFrameBitmap");
        }
      }
    }
  }
  
  void initAudioTrack()
  {
    if (this.mAVDecode.audioParam.channels <= 1) {}
    int m;
    for (int j = 2;; j = 3)
    {
      m = this.mAVDecode.audioParam.sample_rate;
      if (m > 0) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.e(TAG + this.ID, 2, "initAudioTrack(), sampleRateInHz=" + m + ", <= 0, return...");
      }
      return;
    }
    int k = AudioTrack.getMinBufferSize(m, j, 2);
    int i = k;
    if (k < 1024)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG + this.ID, 2, "initAudioTrack(), minBufSize=" + k + " < 1024, so mutiply 2");
      }
      k *= 2;
      i = k;
      if (k < 1024) {
        i = 1024;
      }
    }
    k = i * 2;
    if (QLog.isColorLevel()) {
      QLog.d(TAG + this.ID, 2, "initAudioTrack(): cost=channelConfig: " + j + ", sampleRateInHz: " + m + ", minBufSize: " + i + ", primePlaySize: " + k);
    }
    this.mAudioTrack = new AudioTrack(3, m, j, 2, k, 1);
  }
  
  public boolean isAudioPlaying()
  {
    return this.mPlayAudioFrame;
  }
  
  public void resetAndPlayAudioCircle()
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "resetAndPlayAudioOnce >>>");
    }
    this.mPlayAudioOnceFinished = false;
    Object localObject = this.mVideoParams;
    this.mPlayAudioFrame = true;
    ((VideoDrawable.VideoDrawableParams)localObject).mPlayAudioFrame = true;
    localObject = this.mOption;
    if (!this.mPlayAudioFrame) {
      bool = true;
    }
    ((AVDecodeOption)localObject).ignore_audio = bool;
    this.mOption.cycle = true;
    try
    {
      this.mAVDecode.resetVideoPlayer(this.mOption);
      reDraw();
      return;
    }
    catch (AVideoException localAVideoException)
    {
      for (;;)
      {
        QLog.e(TAG, 1, "AVideoException happens resetAndPlayAudioOnce...", localAVideoException);
      }
    }
  }
  
  public void resetAndPlayAudioOnce()
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "resetAndPlayAudioOnce >>>");
    }
    this.mPlayAudioOnceFinished = false;
    Object localObject = this.mVideoParams;
    this.mPlayAudioFrame = true;
    ((VideoDrawable.VideoDrawableParams)localObject).mPlayAudioFrame = true;
    localObject = this.mOption;
    boolean bool;
    if (!this.mPlayAudioFrame) {
      bool = true;
    }
    for (;;)
    {
      ((AVDecodeOption)localObject).ignore_audio = bool;
      this.mOption.cycle = false;
      try
      {
        this.mAVDecode.resetVideoPlayer(this.mOption);
        reDraw();
        return;
        bool = false;
      }
      catch (AVideoException localAVideoException)
      {
        for (;;)
        {
          QLog.e(TAG, 1, "AVideoException happens resetAndPlayAudioOnce...", localAVideoException);
        }
      }
    }
  }
  
  public void showOOM(final String paramString)
  {
    sUIHandler.post(new Runnable()
    {
      public void run()
      {
        Toast.makeText(BaseApplication.getContext(), "[NativeVideoImage]OOM:" + paramString, 0).show();
      }
    });
  }
  
  void startPlayAudio()
  {
    if ((this.mPlayAudioThread == null) || (this.mAudioThreadFinish))
    {
      this.mPlayAudioThread = new PlayAudioThread("AudioPlayThread");
      this.mPlayAudioThread.start();
      AudioUtils.requesetAudioFoucus();
    }
  }
  
  public void stopPlayAudio()
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG + this.ID, 2, "stopPlayAudio()");
    }
    this.mPlayAudioFrame = false;
  }
  
  class DecodeFrameJob
    implements Runnable
  {
    final long mNextFrameTime;
    
    public DecodeFrameJob(long paramLong)
    {
      this.mNextFrameTime = paramLong;
    }
    
    public void run()
    {
      if (NativeVideoImage.this.getNextFrame())
      {
        long l = SystemClock.uptimeMillis();
        NativeVideoImage.RefreshJob localRefreshJob = new NativeVideoImage.RefreshJob(NativeVideoImage.this, NativeVideoImage.this.mCount.get());
        if (l < this.mNextFrameTime)
        {
          NativeVideoImage.sUIHandler.postDelayed(localRefreshJob, this.mNextFrameTime - l);
          NativeVideoImage.this.mDataReport.onVideoFrameDroped(false, -1);
          if ((QLog.isColorLevel()) && (NativeVideoImage.this.debug)) {
            QLog.d(NativeVideoImage.TAG + NativeVideoImage.this.ID, 2, "after getFrame, now < mNextFrameTime, delay:" + (this.mNextFrameTime - l) + "ms, index=" + NativeVideoImage.this.mCount.get());
          }
        }
        do
        {
          return;
          NativeVideoImage.sUIHandler.post(localRefreshJob);
          NativeVideoImage.this.mDataReport.onVideoFrameDroped(true, (int)(l - this.mNextFrameTime));
        } while (!QLog.isColorLevel());
        QLog.w(NativeVideoImage.TAG + NativeVideoImage.this.ID, 2, "after getFrame, now > mNextFrameTime, delayedTime=" + (l - this.mNextFrameTime) + "ms, index=" + NativeVideoImage.this.mCount.get());
        return;
      }
      NativeVideoImage.this.mDecodeNextFrameEnd = true;
      QLog.e(NativeVideoImage.TAG + NativeVideoImage.this.ID, 1, "after getFrame, return false ");
    }
  }
  
  public static class DoAccumulativeRunnable
    extends ArgumentsRunnable<WeakReference<NativeVideoImage.WrappedRefreshImg>>
  {
    public int delay = 0;
    long lastRefreshTime = 0L;
    
    protected void run(List<WeakReference<NativeVideoImage.WrappedRefreshImg>> paramList)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (WeakReference)paramList.next();
        if (localObject != null)
        {
          localObject = (NativeVideoImage.WrappedRefreshImg)((WeakReference)localObject).get();
          if (localObject != null) {
            ((NativeVideoImage.WrappedRefreshImg)localObject).img.doApplyNextFrame(((NativeVideoImage.WrappedRefreshImg)localObject).refeshId);
          }
        }
      }
      this.lastRefreshTime = SystemClock.uptimeMillis();
    }
    
    protected void submit()
    {
      long l1 = SystemClock.uptimeMillis();
      if ((this.lastRefreshTime == 0L) || (l1 - this.lastRefreshTime >= this.delay))
      {
        run();
        this.lastRefreshTime = l1;
        return;
      }
      long l2 = this.delay;
      long l3 = this.lastRefreshTime;
      NativeVideoImage.sUIHandler.postDelayed(this, l2 - (l1 - l3));
    }
  }
  
  class PlayAudioThread
    extends Thread
  {
    public PlayAudioThread(String paramString)
    {
      setName(paramString + "-" + getId());
    }
    
    public void run()
    {
      for (;;)
      {
        try
        {
          NativeVideoImage.access$302(NativeVideoImage.this, false);
          if (NativeVideoImage.this.mAudioTrack == null) {
            NativeVideoImage.this.initAudioTrack();
          }
          if (NativeVideoImage.this.mAudioTrack == null)
          {
            if (QLog.isColorLevel()) {
              QLog.e(NativeVideoImage.TAG_AUDIO, 2, "PlayAudioThread id=" + getId() + "mAudioTrack == null, return.. ");
            }
            if (NativeVideoImage.this.mAudioTrack == null) {}
          }
        }
        catch (Exception localException1) {}finally
        {
          label368:
          label442:
          label572:
          label597:
          if (NativeVideoImage.this.mAudioTrack != null) {}
          try
          {
            NativeVideoImage.this.mAudioTrack.stop();
            if (NativeVideoImage.this.mAudioTrack == null) {
              continue;
            }
            NativeVideoImage.this.mAudioTrack.release();
            localObject3 = NativeVideoImage.this;
          }
          catch (IllegalStateException localIllegalStateException1)
          {
            QLog.e(NativeVideoImage.TAG_AUDIO, 1, "PlayAudioThread run ", localIllegalStateException1);
            if (NativeVideoImage.this.mAudioTrack == null) {
              continue;
            }
            NativeVideoImage.this.mAudioTrack.release();
            localNativeVideoImage1 = NativeVideoImage.this;
            continue;
          }
          finally
          {
            if (NativeVideoImage.this.mAudioTrack == null) {
              break label1159;
            }
            NativeVideoImage.this.mAudioTrack.release();
            NativeVideoImage.this.mAudioTrack = null;
          }
          ((NativeVideoImage)localObject3).mAudioTrack = null;
          AudioUtils.abandonAudioFoucus();
          NativeVideoImage.access$302(NativeVideoImage.this, true);
          if (QLog.isColorLevel()) {
            QLog.d(NativeVideoImage.TAG_AUDIO, 2, "PlayAudioThread run over");
          }
          throw ((Throwable)localObject12);
          i = 0;
          continue;
          NativeVideoImage.access$602(NativeVideoImage.this, i);
          continue;
          l1 = i;
          try
          {
            Thread.sleep(l1);
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
          }
          continue;
          label1016:
          synchronized (NativeVideoImage.this.mAudioLock)
          {
            if (!NativeVideoImage.this.mVideoDecodeFinish)
            {
              if (QLog.isColorLevel()) {
                QLog.e(NativeVideoImage.TAG_AUDIO, 2, "AudioDecode begin to wait....");
              }
              NativeVideoImage.this.mAudioLock.wait();
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.e(NativeVideoImage.TAG_AUDIO, 2, "AudioDecode finish wait....");
            }
          }
          continue;
        }
        label1159:
        label1299:
        try
        {
          NativeVideoImage.this.mAudioTrack.stop();
          if (NativeVideoImage.this.mAudioTrack == null) {
            continue;
          }
          NativeVideoImage.this.mAudioTrack.release();
          ??? = NativeVideoImage.this;
        }
        catch (IllegalStateException localIllegalStateException3)
        {
          QLog.e(NativeVideoImage.TAG_AUDIO, 1, "PlayAudioThread run ", localIllegalStateException3);
          if (NativeVideoImage.this.mAudioTrack == null) {
            continue;
          }
          NativeVideoImage.this.mAudioTrack.release();
          localNativeVideoImage3 = NativeVideoImage.this;
        }
        finally
        {
          if (NativeVideoImage.this.mAudioTrack == null) {
            break label1299;
          }
          NativeVideoImage.this.mAudioTrack.release();
          NativeVideoImage.this.mAudioTrack = null;
        }
      }
      ((NativeVideoImage)???).mAudioTrack = null;
      AudioUtils.abandonAudioFoucus();
      NativeVideoImage.access$302(NativeVideoImage.this, true);
      if (QLog.isColorLevel()) {}
      for (??? = NativeVideoImage.TAG_AUDIO;; ??? = NativeVideoImage.TAG_AUDIO)
      {
        QLog.d((String)???, 2, "PlayAudioThread run over");
        do
        {
          return;
          NativeVideoImage.this.mAudioTrack.play();
          do
          {
            try
            {
              synchronized (AbstractVideoImage.sPauseLock)
              {
                while (AbstractVideoImage.sPaused)
                {
                  boolean bool = NativeVideoImage.this.mSupportGlobalPause;
                  if (!bool) {
                    break;
                  }
                  try
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d(NativeVideoImage.TAG_AUDIO, 2, "PlayAudioThread id=" + getId() + "begin wait ===> ");
                    }
                    AudioUtils.abandonAudioFoucus();
                    AbstractVideoImage.sPauseLock.wait();
                    if (QLog.isColorLevel()) {
                      QLog.d(NativeVideoImage.TAG_AUDIO, 2, "PlayAudioThread id=" + getId() + " wait end <=== ");
                    }
                    AudioUtils.requesetAudioFoucus();
                  }
                  catch (Exception localException2) {}
                }
                if (NativeVideoImage.this.mPlayAudioFrame) {
                  break label597;
                }
                if (QLog.isColorLevel()) {
                  QLog.i(NativeVideoImage.TAG_AUDIO, 2, "mPlayAudioFrame is false, so quit audio decode... ");
                }
                if (NativeVideoImage.this.mAudioTrack != null) {}
                try
                {
                  NativeVideoImage.this.mAudioTrack.stop();
                  if (NativeVideoImage.this.mAudioTrack == null) {
                    break label368;
                  }
                  NativeVideoImage.this.mAudioTrack.release();
                  ??? = NativeVideoImage.this;
                }
                catch (IllegalStateException localIllegalStateException5)
                {
                  for (;;)
                  {
                    int i;
                    long l1;
                    AbstractAVDecode localAbstractAVDecode;
                    long l2;
                    long l3;
                    Object localObject3;
                    NativeVideoImage localNativeVideoImage1;
                    NativeVideoImage localNativeVideoImage2;
                    NativeVideoImage localNativeVideoImage3;
                    NativeVideoImage localNativeVideoImage4;
                    QLog.e(NativeVideoImage.TAG_AUDIO, 1, "PlayAudioThread run ", localIllegalStateException5);
                    if (NativeVideoImage.this.mAudioTrack != null)
                    {
                      NativeVideoImage.this.mAudioTrack.release();
                      NativeVideoImage localNativeVideoImage5 = NativeVideoImage.this;
                    }
                  }
                }
                finally
                {
                  if (NativeVideoImage.this.mAudioTrack == null) {
                    break label1439;
                  }
                  NativeVideoImage.this.mAudioTrack.release();
                  NativeVideoImage.this.mAudioTrack = null;
                }
                ((NativeVideoImage)???).mAudioTrack = null;
                AudioUtils.abandonAudioFoucus();
                NativeVideoImage.access$302(NativeVideoImage.this, true);
                if (!QLog.isColorLevel()) {
                  break;
                }
                ??? = NativeVideoImage.TAG_AUDIO;
              }
              if (i == -116) {
                break label442;
              }
            }
            catch (AVideoException localAVideoException)
            {
              if ((QLog.isColorLevel()) && (NativeVideoImage.this.debug)) {
                QLog.i(NativeVideoImage.TAG_AUDIO, 2, "seekToNextAudioFrame ", localAVideoException);
              }
              i = localAVideoException.mErrCode;
            }
          } while (i != -110);
          if (QLog.isColorLevel()) {
            QLog.d(NativeVideoImage.TAG_AUDIO, 2, "seekToNextAudioFrame, AudioDecode end...");
          }
          if (NativeVideoImage.this.mPlayAudioOnceFinished) {
            break label1016;
          }
          NativeVideoImage.this.mPlayAudioOnceFinished = true;
          ??? = NativeVideoImage.this.mVideoParams;
          NativeVideoImage.this.mPlayAudioFrame = false;
          ((VideoDrawable.VideoDrawableParams)???).mPlayAudioFrame = false;
          NativeVideoImage.this.mOption.ignore_audio = true;
          NativeVideoImage.sUIHandler.post(new Runnable()
          {
            public void run()
            {
              if (NativeVideoImage.this.mPlayOnceListener != null)
              {
                NativeVideoImage.this.mPlayOnceListener.onFinish();
                NativeVideoImage.this.mPlayOnceListener = null;
                if (QLog.isColorLevel()) {
                  QLog.e(NativeVideoImage.TAG_AUDIO, 2, "seekToNextAudioFrame, mPlayOnceListener.onFinish()");
                }
              }
            }
          });
          if (NativeVideoImage.this.mAudioTrack != null) {}
          try
          {
            NativeVideoImage.this.mAudioTrack.stop();
            if (NativeVideoImage.this.mAudioTrack == null) {
              break label572;
            }
            NativeVideoImage.this.mAudioTrack.release();
            ??? = NativeVideoImage.this;
          }
          catch (IllegalStateException localIllegalStateException4)
          {
            for (;;)
            {
              QLog.e(NativeVideoImage.TAG_AUDIO, 1, "PlayAudioThread run ", localIllegalStateException4);
              if (NativeVideoImage.this.mAudioTrack != null)
              {
                NativeVideoImage.this.mAudioTrack.release();
                localNativeVideoImage4 = NativeVideoImage.this;
              }
            }
          }
          finally
          {
            if (NativeVideoImage.this.mAudioTrack == null) {
              break label1369;
            }
            NativeVideoImage.this.mAudioTrack.release();
            NativeVideoImage.this.mAudioTrack = null;
          }
          ((NativeVideoImage)???).mAudioTrack = null;
          AudioUtils.abandonAudioFoucus();
          NativeVideoImage.access$302(NativeVideoImage.this, true);
        } while (!QLog.isColorLevel());
      }
      if (QLog.isColorLevel()) {
        QLog.i(NativeVideoImage.TAG_AUDIO, 2, "seekToNextAudioFrame: before <<<=== ");
      }
      l1 = System.currentTimeMillis();
    }
  }
  
  class RefreshJob
    implements Runnable
  {
    int refreshId;
    
    public RefreshJob(int paramInt)
    {
      this.refreshId = paramInt;
    }
    
    public void run()
    {
      if ((QLog.isColorLevel()) && (NativeVideoImage.this.debug)) {
        QLog.d(NativeVideoImage.TAG + NativeVideoImage.this.ID, 2, "RefreshJob.run(): refreshId:" + this.refreshId);
      }
      NativeVideoImage.WrappedRefreshImg localWrappedRefreshImg = new NativeVideoImage.WrappedRefreshImg();
      localWrappedRefreshImg.img = NativeVideoImage.this;
      localWrappedRefreshImg.refeshId = this.refreshId;
      NativeVideoImage.this.mAccumulativeRunnable.add(new WeakReference[] { new WeakReference(localWrappedRefreshImg) });
    }
  }
  
  static class ReleaseTask
    implements Runnable
  {
    AbstractAVDecode mDecoder;
    
    public ReleaseTask(AbstractAVDecode paramAbstractAVDecode)
    {
      this.mDecoder = paramAbstractAVDecode;
    }
    
    public void run()
    {
      if (this.mDecoder != null) {}
      try
      {
        this.mDecoder.close();
        this.mDecoder = null;
        if (QLog.isColorLevel()) {
          QLog.d(NativeVideoImage.TAG, 2, "..ReleaseTask close AVDecode..");
        }
        return;
      }
      catch (Throwable localThrowable) {}
    }
  }
  
  public static class WrappedRefreshImg
  {
    public AbstractVideoImage img;
    public int refeshId;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\image\NativeVideoImage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */