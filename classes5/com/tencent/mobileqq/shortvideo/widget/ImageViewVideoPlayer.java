package com.tencent.mobileqq.shortvideo.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.image.VideoDrawable;
import com.tencent.image.VideoDrawable.OnPlayRepeatListener;
import com.tencent.image.VideoDrawable.OnPlayerOneFrameListener;
import com.tencent.image.VideoDrawable.VideoDrawableParams;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Arrays;
import uta;
import utb;
import utc;

public class ImageViewVideoPlayer
  extends LinearLayout
  implements URLDrawableDownListener, VideoDrawable.OnPlayRepeatListener, VideoDrawable.OnPlayerOneFrameListener
{
  public static final int a = 1;
  private static ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(-14342358);
  private static final String jdField_a_of_type_JavaLangString = "ImageViewVideoPlayer";
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  static final int jdField_e_of_type_Int = 5;
  static final int g = -1;
  static final int h = -2;
  static final int i = -3;
  static final int j = -4;
  private static final int k = 3;
  public Bitmap a;
  public BitmapDrawable a;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  public URLImageView a;
  public VideoDrawable a;
  public ImageViewVideoPlayer.IMPlayerEndListener a;
  private PlayerProgressBar jdField_a_of_type_ComTencentMobileqqShortvideoWidgetPlayerProgressBar;
  public boolean a;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private boolean d = true;
  private boolean jdField_e_of_type_Boolean;
  public int f = 1;
  private int l;
  private int m;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ImageViewVideoPlayer(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public ImageViewVideoPlayer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(paramContext);
    super.addView(this.jdField_a_of_type_ComTencentImageURLImageView, localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetPlayerProgressBar = new PlayerProgressBar(paramContext);
    super.addView(this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetPlayerProgressBar, localLayoutParams);
    super.setVisibility(8);
    this.f = 1;
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentImageURLDrawable != null) {}
    try
    {
      Drawable localDrawable = this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable();
      if ((localDrawable != null) && ((localDrawable instanceof VideoDrawable)))
      {
        this.jdField_a_of_type_ComTencentImageVideoDrawable = ((VideoDrawable)this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable());
        boolean bool2 = this.jdField_a_of_type_ComTencentImageVideoDrawable.isAudioPlaying();
        if ((!CameraCompatibleList.d(CameraCompatibleList.jdField_c_of_type_JavaLangString)) && (!CameraCompatibleList.a(CameraCompatibleList.d))) {
          break label141;
        }
        bool1 = true;
        if (QLog.isColorLevel()) {
          QLog.i("ImageViewVideoPlayer", 2, "initPlayer: audioPlaying= " + bool2 + " black=" + bool1);
        }
        if (bool1) {
          this.jdField_a_of_type_ComTencentImageVideoDrawable.disableGlobalPause();
        }
      }
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ImageViewVideoPlayer", 2, "checkAndGetVideoDrawable mUrlDrawable==null", localNullPointerException);
        }
        Object localObject = null;
        continue;
        label141:
        boolean bool1 = false;
      }
    }
  }
  
  private void f()
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidGraphicsBitmap = a();
      b();
      d();
      getHandler().postAtFrontOfQueue(new utc(this));
    }
  }
  
  public int a(String paramString)
  {
    int n = -1;
    if (paramString == null) {
      n = -4;
    }
    File localFile;
    do
    {
      do
      {
        return n;
        localFile = new File(paramString);
        if ((localFile.exists()) && (localFile.isDirectory())) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ImageViewVideoPlayer", 2, "getVFileAndAFile(), videoDir not exist");
      return -1;
      paramString = localFile.list();
      if (paramString != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ImageViewVideoPlayer", 2, "getVFileAndAFile(), files = null");
    return -1;
    String str = localFile.getAbsolutePath() + File.separator;
    if (QLog.isColorLevel()) {
      QLog.d("ImageViewVideoPlayer", 2, "getVFileAndAFile(), sourceDirFile =" + localFile.getAbsolutePath() + ",files = " + Arrays.toString(paramString) + ",filse count = " + localFile.listFiles().length);
    }
    int i1 = paramString.length;
    n = 0;
    while (n < i1)
    {
      localFile = paramString[n];
      if (QLog.isColorLevel()) {
        QLog.d("ImageViewVideoPlayer", 2, "getVFileAndAFile(), current file = " + localFile);
      }
      if (localFile.endsWith(".af")) {
        this.jdField_c_of_type_JavaLangString = (str + localFile);
      }
      if ((localFile.endsWith(".vf")) && (FileUtils.a(str + localFile) > 0L)) {
        this.jdField_b_of_type_JavaLangString = (str + localFile);
      }
      n += 1;
    }
    if ((this.jdField_b_of_type_JavaLangString == null) || ("".equals(this.jdField_b_of_type_JavaLangString))) {
      return -3;
    }
    if ((this.jdField_c_of_type_JavaLangString == null) || ("".equals(this.jdField_c_of_type_JavaLangString))) {
      return -2;
    }
    this.e = false;
    if (FileUtils.a(this.jdField_c_of_type_JavaLangString) > 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImageViewVideoPlayer", 2, "getVFileAndAFile(), mNeedPlayAudio = " + this.e);
      }
      this.e = true;
    }
    return 0;
  }
  
  public Bitmap a()
  {
    if (this.jdField_a_of_type_ComTencentImageVideoDrawable != null) {
      return this.jdField_a_of_type_ComTencentImageVideoDrawable.getCurrentBitmap();
    }
    return null;
  }
  
  public String a()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public void a()
  {
    super.setVisibility(0);
    if (this.jdField_a_of_type_ComTencentImageURLImageView != null) {
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
    }
    this.f = 3;
  }
  
  public void a(int paramInt1, float paramFloat, boolean paramBoolean, int paramInt2)
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(paramInt1, (int)(paramInt1 * paramFloat));
    this.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams(localLayoutParams);
    this.d = paramBoolean;
    if (this.d)
    {
      localLayoutParams = new LinearLayout.LayoutParams(paramInt1, paramInt2);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetPlayerProgressBar.setLayoutParams(localLayoutParams);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetPlayerProgressBar.setVisibility(8);
  }
  
  public void a(int paramInt1, int paramInt2, float paramFloat, boolean paramBoolean, int paramInt3)
  {
    int n = (int)(paramInt1 * paramFloat);
    if (QLog.isColorLevel()) {
      QLog.i("ImageViewVideoPlayer", 2, "updateUISize width" + paramInt1 + "height" + n + "screenHeight=" + paramInt2);
    }
    if (n < paramInt2) {}
    for (;;)
    {
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(paramInt1, paramInt2);
      this.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams(localLayoutParams);
      this.d = paramBoolean;
      if (this.d)
      {
        localLayoutParams = new LinearLayout.LayoutParams(paramInt1, paramInt3);
        this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetPlayerProgressBar.setLayoutParams(localLayoutParams);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetPlayerProgressBar.setVisibility(8);
      return;
      paramInt2 = n;
    }
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams(localLayoutParams);
    this.d = paramBoolean;
    if (this.d)
    {
      localLayoutParams = new LinearLayout.LayoutParams(paramInt1, paramInt3);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetPlayerProgressBar.setLayoutParams(localLayoutParams);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetPlayerProgressBar.setVisibility(8);
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    if ((!this.jdField_a_of_type_Boolean) && (a(paramString) != 0)) {
      return false;
    }
    this.jdField_a_of_type_ComTencentImageVideoDrawable = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.l = (paramInt3 - 3);
    if (this.d)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetPlayerProgressBar.a = paramInt1;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetPlayerProgressBar.b = paramInt2;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetPlayerProgressBar.c = paramInt3;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetPlayerProgressBar.setCurrentProgress(0, false);
    }
    paramString = URLDrawable.URLDrawableOptions.obtain();
    paramString.mFailedDrawable = null;
    paramString.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    if (this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable != null) {
      paramString.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
    }
    VideoDrawable.VideoDrawableParams localVideoDrawableParams = new VideoDrawable.VideoDrawableParams();
    localVideoDrawableParams.mVideoRoundCorner = 0;
    localVideoDrawableParams.mRequestedFPS = -1;
    localVideoDrawableParams.mEnableAntiAlias = true;
    localVideoDrawableParams.mEnableFilter = true;
    localVideoDrawableParams.mPlayAudioFrame = this.e;
    localVideoDrawableParams.mPlayVideoFrame = true;
    localVideoDrawableParams.mDecodeType = 1;
    localVideoDrawableParams.mAfPath = this.jdField_c_of_type_JavaLangString;
    localVideoDrawableParams.mVfPath = this.jdField_b_of_type_JavaLangString;
    localVideoDrawableParams.mTotalTime = paramInt2;
    localVideoDrawableParams.mVideoFrames = paramInt3;
    paramString.mExtraInfo = localVideoDrawableParams;
    if (!this.jdField_c_of_type_Boolean) {
      paramString.mUseMemoryCache = false;
    }
    this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(new File(this.jdField_b_of_type_JavaLangString), paramString);
    this.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(this);
    e();
    if (this.jdField_a_of_type_ComTencentImageVideoDrawable != null)
    {
      this.jdField_a_of_type_ComTencentImageVideoDrawable.setOnPlayRepeatListener(this);
      this.jdField_a_of_type_ComTencentImageVideoDrawable.setOnPlayerOneFrameListener(this);
      if (!this.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentImageVideoDrawable.resetAndPlayAudioOnce();
      }
    }
    this.f = 2;
    this.jdField_b_of_type_Boolean = false;
    return true;
  }
  
  public boolean a(RMVideoStateMgr paramRMVideoStateMgr)
  {
    boolean bool = false;
    if (paramRMVideoStateMgr.a != null) {}
    for (int n = paramRMVideoStateMgr.a.getFrameIndex();; n = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImageViewVideoPlayer", 2, " checkVideoSourceValidate frameCount" + n);
      }
      if (n >= 5) {
        bool = true;
      }
      return bool;
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentImageURLDrawable != null) && (this.jdField_a_of_type_ComTencentImageVideoDrawable != null)) {
      this.jdField_a_of_type_ComTencentImageVideoDrawable.stopAudio();
    }
    Handler localHandler = super.getHandler();
    if (localHandler != null) {
      localHandler.postAtFrontOfQueue(new uta(this));
    }
    this.f = 4;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentImageVideoDrawable != null) {
      this.jdField_a_of_type_ComTencentImageVideoDrawable.resetPlay();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentImageVideoDrawable != null) {
      this.jdField_a_of_type_ComTencentImageVideoDrawable.enableGlobalPause();
    }
    this.jdField_a_of_type_ComTencentImageURLDrawable = null;
    this.l = 0;
    this.m = 0;
    this.f = 1;
  }
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    e();
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    e();
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    e();
    if (this.jdField_a_of_type_ComTencentImageVideoDrawable != null)
    {
      this.jdField_a_of_type_ComTencentImageVideoDrawable.setOnPlayRepeatListener(this);
      this.jdField_a_of_type_ComTencentImageVideoDrawable.setOnPlayerOneFrameListener(this);
    }
  }
  
  public void onPlayRepeat(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ImageViewVideoPlayer", 2, "onPlayRepeat: repeatTimes= " + paramInt);
    }
    if (!this.jdField_c_of_type_Boolean)
    {
      if (this.d) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetPlayerProgressBar.setCurrentProgress(this.m, true);
      }
      f();
      return;
    }
    this.m = 0;
    getHandler().postAtFrontOfQueue(new utb(this, paramInt));
  }
  
  public void oneFrameDrawed()
  {
    this.m += 1;
    if (this.m >= this.l) {}
    for (boolean bool = true;; bool = false)
    {
      if (this.d) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetPlayerProgressBar.setCurrentProgress(this.m, bool);
      }
      if ((bool) && (!this.jdField_c_of_type_Boolean)) {
        f();
      }
      return;
    }
  }
  
  public void setCyclePlay(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void setIMPlayerEndListener(ImageViewVideoPlayer.IMPlayerEndListener paramIMPlayerEndListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer$IMPlayerEndListener = paramIMPlayerEndListener;
  }
  
  public void setNeedPlayAudio(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\widget\ImageViewVideoPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */