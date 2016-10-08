package com.tencent.mobileqq.activity.welcomeguide;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.hardware.Camera;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ProcessStats;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.app.AppRuntime;
import pmx;
import pmz;
import pna;
import pnj;
import pnk;
import pnl;
import pnt;
import pnu;
import pnv;
import pnw;
import pnx;

public class QQAVFunnyFaceInvest
  extends BaseActivity
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, View.OnClickListener
{
  public static String a;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Uri jdField_a_of_type_AndroidNetUri;
  public SurfaceHolder a;
  View jdField_a_of_type_AndroidViewView = null;
  public Button a;
  public ImageView a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  public VideoView a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  pnx jdField_a_of_type_Pnx;
  public boolean a;
  private final int jdField_b_of_type_Int = -1;
  public View b;
  public Button b;
  public ImageView b;
  private boolean jdField_b_of_type_Boolean;
  private final int jdField_c_of_type_Int = 0;
  public ImageView c;
  private boolean jdField_c_of_type_Boolean;
  private final int jdField_d_of_type_Int = 1;
  ImageView jdField_d_of_type_AndroidWidgetImageView = null;
  private final int e;
  public ImageView e;
  private final int f = 3;
  private final int g = 5;
  private final int h = 6;
  private final int i = 7;
  private int j = -1;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = "welcomguide_QQAVFunnyFace";
  }
  
  public QQAVFunnyFaceInvest()
  {
    this.jdField_a_of_type_AndroidWidgetVideoView = null;
    this.jdField_a_of_type_AndroidWidgetButton = null;
    this.jdField_a_of_type_AndroidViewSurfaceHolder = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_b_of_type_AndroidWidgetImageView = null;
    this.jdField_b_of_type_AndroidWidgetButton = null;
    this.jdField_c_of_type_AndroidWidgetImageView = null;
    this.jdField_e_of_type_AndroidWidgetImageView = null;
    this.jdField_e_of_type_Int = 2;
    this.jdField_b_of_type_AndroidViewView = null;
  }
  
  private int a()
  {
    if (ProcessStats.a() < 2) {
      return 300;
    }
    return 200;
  }
  
  private Animation a()
  {
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 1.52F, 1.0F, 1.52F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(1000L);
    localScaleAnimation.setRepeatCount(200);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(1000L);
    localAlphaAnimation.setRepeatCount(200);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.addAnimation(localAlphaAnimation);
    return localAnimationSet;
  }
  
  private Animation a(int paramInt)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(300.0F, 0.0F, 200.0F, 0.0F);
    localTranslateAnimation.setDuration(paramInt);
    localTranslateAnimation.setRepeatCount(0);
    localTranslateAnimation.setFillAfter(true);
    return localTranslateAnimation;
  }
  
  private Animation a(int paramInt1, int paramInt2)
  {
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.8F, 1.0F, 0.8F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setStartOffset(paramInt1);
    localScaleAnimation.setDuration(paramInt2);
    localScaleAnimation.setRepeatCount(0);
    localScaleAnimation.setFillAfter(true);
    return localScaleAnimation;
  }
  
  private AnimationSet a()
  {
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 1.32F, 1.0F, 1.32F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(1600L);
    localScaleAnimation.setRepeatCount(200);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(1600L);
    localAlphaAnimation.setRepeatCount(200);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.setFillAfter(false);
    return localAnimationSet;
  }
  
  private void a(int paramInt, Uri paramUri)
  {
    QLog.e(jdField_a_of_type_JavaLangString, 1, "Play!!! nPosition=" + paramInt + "; uri=" + paramUri);
    if (this.jdField_c_of_type_Boolean) {}
    do
    {
      return;
      try
      {
        if (this.jdField_a_of_type_AndroidWidgetVideoView == null)
        {
          this.jdField_a_of_type_AndroidWidgetVideoView = ((VideoView)findViewById(2131302601));
          this.jdField_a_of_type_AndroidWidgetVideoView.setBackgroundColor(Color.parseColor("#ffe8eaed"));
          this.jdField_a_of_type_AndroidWidgetVideoView.setOnCompletionListener(this);
          this.jdField_a_of_type_AndroidWidgetVideoView.setOnPreparedListener(this);
          this.jdField_a_of_type_AndroidWidgetVideoView.setOnErrorListener(this);
          this.jdField_a_of_type_AndroidWidgetVideoView.getHolder().addCallback(new pnw(this));
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "#play#");
        }
        if (paramInt <= 0) {
          break;
        }
        this.jdField_a_of_type_AndroidWidgetVideoView.seekTo(paramInt);
        this.jdField_a_of_type_Long = paramInt;
        return;
      }
      catch (Exception paramUri) {}
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "#play exception#", paramUri.toString() });
    return;
    this.jdField_a_of_type_AndroidWidgetVideoView.setVideoURI(paramUri);
    this.jdField_a_of_type_AndroidNetUri = paramUri;
  }
  
  private void a(View paramView)
  {
    if (paramView != null)
    {
      paramView.clearAnimation();
      paramView.invalidate();
      paramView.setVisibility(8);
    }
  }
  
  private void a(View paramView1, View paramView2)
  {
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_AndroidViewView = paramView1;
    paramView1 = new pmx(this, paramView1, paramView2);
    a(this.jdField_b_of_type_AndroidViewView, paramView1);
  }
  
  private void a(View paramView, Animation.AnimationListener paramAnimationListener)
  {
    AnimationSet localAnimationSet = a();
    localAnimationSet.setAnimationListener(paramAnimationListener);
    paramView.startAnimation(localAnimationSet);
  }
  
  public static boolean a()
  {
    boolean bool = false;
    try
    {
      Camera localCamera = Camera.open(0);
      localCamera.setDisplayOrientation(90);
      localCamera.release();
      bool = true;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "isCameraCanUse=" + bool);
    return bool;
  }
  
  private Animation b(int paramInt1, int paramInt2)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -20.0F);
    localTranslateAnimation.setStartOffset(paramInt1);
    localTranslateAnimation.setDuration(paramInt2);
    localTranslateAnimation.setRepeatCount(0);
    localTranslateAnimation.setFillAfter(true);
    return localTranslateAnimation;
  }
  
  private AnimationSet b()
  {
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(a(500, 500));
    localAnimationSet.addAnimation(a(800));
    localAnimationSet.addAnimation(d(900, 100));
    localAnimationSet.addAnimation(b(900, 100));
    localAnimationSet.addAnimation(c(1000, 600));
    localAnimationSet.setFillAfter(true);
    return localAnimationSet;
  }
  
  public static boolean b()
  {
    boolean bool2 = false;
    int k = Build.VERSION.SDK_INT;
    long l = VcSystemInfo.c();
    int m = VcSystemInfo.e();
    if ((k < 15) || (l / 1000L < 1200L) || (m < 2)) {}
    for (boolean bool1 = false;; bool1 = true)
    {
      if (c()) {
        bool1 = bool2;
      }
      for (;;)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "bRet=" + bool1 + ", nSdkVer=" + k + ", nCpuFreq=" + l + ", nCpuNumber=" + m + ",Build.MODEL=" + Build.MODEL);
        return bool1;
      }
    }
  }
  
  private Animation c(int paramInt1, int paramInt2)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setStartOffset(paramInt1);
    localAlphaAnimation.setDuration(paramInt2);
    localAlphaAnimation.setFillAfter(true);
    return localAlphaAnimation;
  }
  
  private static boolean c()
  {
    String[] arrayOfString = new String[68];
    arrayOfString[0] = "GT-I9100G";
    arrayOfString[1] = "Moto X Pro";
    arrayOfString[2] = "U707T";
    arrayOfString[3] = "GT-I8552";
    arrayOfString[4] = "SCH-I869";
    arrayOfString[5] = "vivo X1St";
    arrayOfString[6] = "vivo Y19t";
    arrayOfString[7] = "HUAWEI G610-U00";
    arrayOfString[8] = "Coolpad8295M";
    arrayOfString[9] = "GN708T";
    arrayOfString[10] = "HUAWEI G610-T00";
    arrayOfString[11] = "Coolpad 7296";
    arrayOfString[12] = "W9588";
    arrayOfString[13] = "E6T";
    arrayOfString[14] = "GN708W";
    arrayOfString[15] = "Coolpad 7270_W00";
    arrayOfString[16] = "X805";
    arrayOfString[17] = "Lenovo A670t";
    arrayOfString[18] = "SCH-W789";
    arrayOfString[19] = "W6500";
    arrayOfString[20] = "GN810";
    arrayOfString[21] = "vivo X1S";
    arrayOfString[22] = "DOOV D800";
    arrayOfString[23] = "K-Touch Kis 1";
    arrayOfString[24] = "Kis 1";
    arrayOfString[25] = "W8568";
    arrayOfString[26] = "GN878";
    arrayOfString[27] = "W800";
    arrayOfString[28] = "HUAWEI C8815";
    arrayOfString[29] = "HUAWEI C8813Q";
    arrayOfString[30] = "GT-I9082";
    arrayOfString[31] = "vivo Y20T";
    arrayOfString[32] = "HUAWEI G520-0000";
    arrayOfString[33] = "Coolpad 5890";
    arrayOfString[34] = "ZTE N909";
    arrayOfString[35] = "HUAWEI C8813DQ";
    arrayOfString[36] = "Lenovo A820e";
    arrayOfString[37] = "K-Touch S5";
    arrayOfString[38] = "HUAWEI G525-U00";
    arrayOfString[39] = "HUAWEI G730-C00";
    arrayOfString[40] = "ZTE N818";
    arrayOfString[41] = "HUAWEI G610-C00";
    arrayOfString[42] = "K-Touch S2";
    arrayOfString[43] = "GT-I8262D";
    arrayOfString[44] = "SCH-I739";
    arrayOfString[45] = "GT-I9108";
    arrayOfString[46] = "SCH-I879";
    arrayOfString[47] = "SCH-I829";
    arrayOfString[48] = "GT-I9128";
    arrayOfString[49] = "GT-I9105P";
    arrayOfString[50] = "GT-I9082i";
    arrayOfString[51] = "SM-G3819D";
    arrayOfString[52] = "E6mini";
    arrayOfString[53] = "ZTE U819";
    arrayOfString[54] = "HUAWEI G520-5000";
    arrayOfString[55] = "ZTE U956";
    arrayOfString[56] = "HUAWEI C8812";
    arrayOfString[57] = "ZTE V889D";
    arrayOfString[58] = "K-Touch W656";
    arrayOfString[59] = "Coolpad 7268";
    arrayOfString[60] = "GT-I9128E";
    arrayOfString[61] = "Coolpad 7232";
    arrayOfString[62] = "S5830i";
    arrayOfString[63] = "SM-G3508I";
    arrayOfString[64] = "GiONEE E3T";
    arrayOfString[65] = "Samsung SCH-I759";
    arrayOfString[66] = "GiONEE W800";
    arrayOfString[67] = "ZTE V970";
    String str = Build.MODEL;
    int m = arrayOfString.length;
    int k = 0;
    while (k < m)
    {
      if (str.equals(arrayOfString[k])) {
        return true;
      }
      k += 1;
    }
    return false;
  }
  
  private Animation d(int paramInt1, int paramInt2)
  {
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 1.05F, 1.0F, 1.05F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setStartOffset(paramInt1);
    localScaleAnimation.setDuration(paramInt2);
    localScaleAnimation.setRepeatCount(0);
    localScaleAnimation.setFillAfter(true);
    return localScaleAnimation;
  }
  
  private void d()
  {
    QLog.e(jdField_a_of_type_JavaLangString, 1, "onCreateUI");
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131299359));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131302614));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131302607));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131302603));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131302604));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131302605));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131302606));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131302602));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131302615);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    findViewById(2131299355).setOnClickListener(this);
    findViewById(2131299359).setOnClickListener(this);
    findViewById(2131301648).setOnClickListener(this);
    findViewById(2131302616).setOnClickListener(this);
  }
  
  private void e()
  {
    QLog.e(jdField_a_of_type_JavaLangString, 1, "StopViews");
    try
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "CleanControls try close mCameraView");
      if (this.jdField_a_of_type_Pnx != null)
      {
        this.jdField_a_of_type_Pnx.setZOrderOnTop(false);
        this.jdField_a_of_type_Pnx.a();
        this.jdField_a_of_type_Pnx = null;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          QLog.e(jdField_a_of_type_JavaLangString, 1, "CleanControls try close mVideoView");
          if (this.jdField_a_of_type_AndroidWidgetVideoView != null)
          {
            this.jdField_a_of_type_AndroidWidgetVideoView.setOnPreparedListener(null);
            this.jdField_a_of_type_AndroidWidgetVideoView.setOnCompletionListener(null);
            this.jdField_a_of_type_AndroidWidgetVideoView.setOnErrorListener(null);
            this.jdField_a_of_type_AndroidWidgetVideoView.stopPlayback();
            this.jdField_a_of_type_AndroidWidgetVideoView = null;
            QLog.e(jdField_a_of_type_JavaLangString, 1, "CleanControls finish stopPlayback");
          }
          return;
        }
        catch (Exception localException2)
        {
          QLog.e(jdField_a_of_type_JavaLangString, 1, "close mVideoView except!" + localException2.toString());
        }
        localException1 = localException1;
        QLog.e(jdField_a_of_type_JavaLangString, 1, "CleanControls close mCameraView except!" + localException1.toString());
      }
    }
  }
  
  private void f()
  {
    QLog.e(jdField_a_of_type_JavaLangString, 1, "CleanControls");
    e();
    a(this.jdField_a_of_type_AndroidWidgetButton);
    a(this.jdField_b_of_type_AndroidWidgetButton);
    View localView1 = findViewById(2131302612);
    View localView2 = findViewById(2131302613);
    a(localView1);
    a(localView2);
    a(this.jdField_a_of_type_AndroidWidgetImageView);
    a(this.jdField_b_of_type_AndroidWidgetImageView);
    a(this.jdField_c_of_type_AndroidWidgetImageView);
    a(this.jdField_d_of_type_AndroidWidgetImageView);
    a(this.jdField_a_of_type_AndroidViewView);
  }
  
  private void g()
  {
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "ShowSlide1HandMove");
    this.jdField_b_of_type_AndroidWidgetImageView.postDelayed(new pna(this), 2000L);
  }
  
  private void h()
  {
    QLog.e(jdField_a_of_type_JavaLangString, 1, "ShowSlide1");
    this.j = 0;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
    a(0, Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/" + 2131165188));
    View localView1 = findViewById(2131302612);
    View localView2 = findViewById(2131302613);
    localView1.setVisibility(0);
    localView2.setVisibility(0);
    a(localView1, localView2);
    localView1.postDelayed(new pnj(this), 3500L);
  }
  
  private void i()
  {
    QLog.e(jdField_a_of_type_JavaLangString, 1, "ShowSlide2VideoShow");
    Object localObject;
    if ((this.jdField_a_of_type_Pnx == null) && (this.j != 1))
    {
      this.j = 1;
      QLog.e(jdField_a_of_type_JavaLangString, 1, "ShowSlide2VideoShow enter");
      findViewById(2131302609).setVisibility(8);
      findViewById(2131302612).clearAnimation();
      findViewById(2131302612).invalidate();
      findViewById(2131302612).setVisibility(8);
      findViewById(2131302613).clearAnimation();
      findViewById(2131302613).invalidate();
      findViewById(2131302613).setVisibility(8);
      findViewById(2131302611).setVisibility(8);
      findViewById(2131302610).setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.clearAnimation();
      this.jdField_b_of_type_AndroidWidgetImageView.invalidate();
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      a(findViewById(2131302612));
      a(findViewById(2131302613));
      this.jdField_a_of_type_Pnx = new pnx(this, this);
      if ((a()) && (this.jdField_a_of_type_Pnx.a()))
      {
        localObject = (RelativeLayout)findViewById(2131299284);
        if (localObject == null) {
          break label334;
        }
        ((RelativeLayout)localObject).addView(this.jdField_a_of_type_Pnx, new LinearLayout.LayoutParams(-1, -1));
        this.jdField_a_of_type_Pnx.setZOrderOnTop(true);
      }
    }
    for (;;)
    {
      a(0, Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/" + 2131165186));
      this.j = 2;
      localObject = findViewById(2131301648);
      if (localObject == null) {
        break;
      }
      ((View)localObject).postDelayed(new pnk(this), 14000L);
      return;
      label334:
      QLog.e(jdField_a_of_type_JavaLangString, 1, "ShowSlide2VideoShow Unexcepted error occured");
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "ShowSlide2VideoShow Unexcepted error occured finish");
    finish();
  }
  
  private void j()
  {
    QLog.e(jdField_a_of_type_JavaLangString, 1, "ShowSlide4HandAction");
    AnimationSet localAnimationSet = b();
    localAnimationSet.setAnimationListener(new pnl(this));
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(localAnimationSet);
  }
  
  private void k()
  {
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "ShowSlide4EmoBlingBling");
    Animation localAnimation = a();
    localAnimation.setAnimationListener(new pnt(this));
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetImageView.startAnimation(localAnimation);
  }
  
  private void l()
  {
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "ShowSlide4EmoTip");
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(1000L);
    localAlphaAnimation.setRepeatCount(0);
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setAnimationListener(new pnu(this));
    this.jdField_e_of_type_AndroidWidgetImageView.startAnimation(localAlphaAnimation);
  }
  
  private void m()
  {
    QLog.e(jdField_a_of_type_JavaLangString, 1, "ShowSlide4UserSelectActionWithDely");
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    l();
    this.jdField_e_of_type_AndroidWidgetImageView.postDelayed(new pnv(this), 5000L);
  }
  
  private void n()
  {
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "ShowSlide4UserSelectVideo");
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(800L);
    localAlphaAnimation.setRepeatCount(0);
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setFillBefore(false);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(localAlphaAnimation);
    this.j = 3;
    m();
  }
  
  private void o()
  {
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "ShowSlide5Final");
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    ((Button)findViewById(2131299355)).setVisibility(8);
    ((RelativeLayout)findViewById(2131302609)).setVisibility(0);
    a(this.jdField_a_of_type_AndroidWidgetImageView);
    a(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    View localView = findViewById(2131301648);
    if (localView != null) {
      localView.setVisibility(4);
    }
    if (this.jdField_a_of_type_Pnx != null)
    {
      this.jdField_a_of_type_Pnx.setZOrderOnTop(false);
      this.jdField_a_of_type_Pnx.a();
      this.jdField_a_of_type_Pnx.setVisibility(8);
      this.jdField_a_of_type_Pnx = null;
    }
    a(0, Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/" + 2131165185));
    this.j = 6;
  }
  
  private void p()
  {
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "ShowSlide4ButtyFly");
    a(this.jdField_a_of_type_AndroidWidgetImageView);
    a(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    this.j = 5;
    a(0, Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/" + 2131165189));
  }
  
  protected void a()
  {
    QLog.e(jdField_a_of_type_JavaLangString, 1, "backToMainActivity");
    Intent localIntent = getIntent();
    AppRuntime localAppRuntime = BaseApplicationImpl.a().a();
    if ((localAppRuntime != null) && (localAppRuntime.isLogin()))
    {
      localIntent.setClass(this, SplashActivity.class);
      localIntent.putExtra("tab_index", MainFragment.jdField_a_of_type_Int);
    }
    for (;;)
    {
      localIntent.addFlags(67108864);
      startActivity(localIntent);
      super.overridePendingTransition(2130968592, 2130968593);
      return;
      localIntent.setClass(this, LoginActivity.class);
    }
  }
  
  void b()
  {
    if ((this.jdField_a_of_type_AndroidWidgetVideoView != null) && (this.jdField_a_of_type_AndroidWidgetVideoView.getCurrentPosition() > 0))
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidWidgetVideoView.pause();
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "#VideoViewPause# , mCurrentPosition = " + this.jdField_a_of_type_Int);
  }
  
  void c()
  {
    if ((this.jdField_a_of_type_AndroidWidgetVideoView != null) && (this.jdField_a_of_type_Int > 0)) {
      this.jdField_a_of_type_AndroidWidgetVideoView.start();
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "#VideoViewPause# , mCurrentPosition = " + this.jdField_a_of_type_Int);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    QLog.e(jdField_a_of_type_JavaLangString, 1, "doOnCreate");
    this.mActNeedImmersive = false;
    this.mNeedStatusTrans = false;
    super.doOnCreate(paramBundle);
    getWindow().setFlags(1024, 1024);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      getWindow().addFlags(67108864);
      getWindow().addFlags(134217728);
    }
    super.setContentView(2130904390);
    d();
    h();
    return true;
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    QLog.e(jdField_a_of_type_JavaLangString, 1, "doOnResume mInteruptted=" + this.jdField_b_of_type_Boolean);
    if (this.jdField_b_of_type_Boolean)
    {
      c();
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  public void finish()
  {
    this.jdField_c_of_type_Boolean = true;
    this.j = 7;
    QLog.e(jdField_a_of_type_JavaLangString, 1, "finish");
    if (QLog.isDevelopLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "QQAVFunnyFaceInvest.finish()");
    }
    if (isFinishing()) {
      return;
    }
    a();
    e();
    super.finish();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131299355: 
      ReportController.b(this.app, "CliOper", "", "", "0X8007180", "0X8007180", 0, 0, "", "", "", "");
      QLog.e(jdField_a_of_type_JavaLangString, 1, "av_video_ignore");
      finish();
      return;
    case 2131299359: 
      ReportController.b(this.app, "CliOper", "", "", "0X8007181", "0X8007181", 0, 0, "", "", "", "");
      QLog.e(jdField_a_of_type_JavaLangString, 1, "av_video_accept");
      i();
      return;
    case 2131301648: 
      ReportController.b(this.app, "CliOper", "", "", "0X8007182", "0X8007182", 0, 0, "", "", "", "");
      QLog.e(jdField_a_of_type_JavaLangString, 1, "user_guide_btn_cancel");
      finish();
      return;
    case 2131302603: 
      ReportController.b(this.app, "CliOper", "", "", "0X800717D", "0X800717D", 0, 0, "", "", "", "");
      QLog.e(jdField_a_of_type_JavaLangString, 1, "av_video_batty_fly");
      p();
      return;
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "user_guide_try_it_out");
    finish();
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    QLog.e(jdField_a_of_type_JavaLangString, 1, "onCompletion mCurrentStep=" + this.j);
    if (this.j == 5) {
      o();
    }
    while ((2 == this.j) || (3 == this.j) || (6 != this.j)) {
      return;
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "Step_END == mCurrentStep");
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    paramMediaPlayer = new AlphaAnimation(0.0F, 1.0F);
    paramMediaPlayer.setDuration(1000L);
    paramMediaPlayer.setRepeatCount(0);
    this.jdField_a_of_type_AndroidViewView.startAnimation(paramMediaPlayer);
  }
  
  protected void onDestroy()
  {
    QLog.e(jdField_a_of_type_JavaLangString, 1, "onDestroy");
    f();
    super.onDestroy();
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    QLog.e(jdField_a_of_type_JavaLangString, 1, "onError what=" + paramInt1 + " extra=" + paramInt2);
    finish();
    return true;
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    QLog.e(jdField_a_of_type_JavaLangString, 1, "onNewIntent");
    super.onNewIntent(paramIntent);
  }
  
  protected void onPause()
  {
    QLog.e(jdField_a_of_type_JavaLangString, 1, "on onPause");
    super.onPause();
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    QLog.e(jdField_a_of_type_JavaLangString, 1, "onPrepared");
    if (this.jdField_c_of_type_Boolean)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "Finish and return");
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetVideoView == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "Finish and enter return");
      return;
    }
    this.jdField_a_of_type_AndroidWidgetVideoView.start();
    if (this.jdField_a_of_type_Long > 0L)
    {
      this.jdField_a_of_type_AndroidWidgetVideoView.seekTo((int)this.jdField_a_of_type_Long);
      this.jdField_a_of_type_Long = 0L;
    }
    this.jdField_a_of_type_AndroidWidgetVideoView.postDelayed(new pmz(this), a());
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (this.jdField_a_of_type_AndroidWidgetVideoView != null)
    {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidWidgetVideoView.getCurrentPosition();
      if (this.jdField_a_of_type_Int > 0) {
        b();
      }
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "onSaveInstanceState: mCurrentPosition: " + this.jdField_a_of_type_Int);
  }
  
  public void onSeekComplete(MediaPlayer paramMediaPlayer) {}
  
  protected void onStop()
  {
    QLog.e(jdField_a_of_type_JavaLangString, 1, "on onStop");
    super.onStop();
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\welcomeguide\QQAVFunnyFaceInvest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */