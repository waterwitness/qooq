package com.tencent.av.smallscreen;

import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.utils.TipsManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import gou;
import java.lang.ref.WeakReference;

public class SmallScreenVideoControlUI
  implements Animation.AnimationListener
{
  static final String c = "SmallScreenVideoControlUI";
  protected static final int e = 0;
  protected static final int f = 1;
  protected static final int g = 2;
  protected static final int h = 3;
  protected static final int i = 4;
  protected static final int j = 5;
  protected static final int k = 6;
  public Resources a;
  public TextView a;
  public VideoController a;
  public VideoAppInterface a;
  SmallScreenService jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService;
  public ControlUIObserver a;
  public TipsManager a;
  public WeakReference a;
  View[] jdField_a_of_type_ArrayOfAndroidViewView;
  protected TextView b;
  public boolean b;
  public boolean c;
  public String d;
  Runnable jdField_e_of_type_JavaLangRunnable;
  String jdField_e_of_type_JavaLangString;
  public int l;
  
  public SmallScreenVideoControlUI(VideoAppInterface paramVideoAppInterface, SmallScreenService paramSmallScreenService, ControlUIObserver paramControlUIObserver)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.l = 0;
    this.d = null;
    this.jdField_e_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_ArrayOfAndroidViewView = new View[2];
    this.jdField_e_of_type_JavaLangString = "DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService = paramSmallScreenService;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService);
    this.jdField_a_of_type_AndroidContentResResources = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.getResources();
    if (this.jdField_a_of_type_AndroidContentResResources == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SmallScreenVideoControlUI", 2, "mRes is null. exit video progress");
      }
      paramVideoAppInterface = paramSmallScreenService.getString(2131363272) + " 0x01";
      Toast.makeText(paramSmallScreenService.getApplicationContext(), paramVideoAppInterface, 0).show();
      paramSmallScreenService.stopSelf();
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SmallScreenVideoControlUI", 2, "mVideoController is null. exit video progress");
      }
      paramVideoAppInterface = this.jdField_a_of_type_AndroidContentResResources.getString(2131363272) + " 0x01";
      Toast.makeText(paramSmallScreenService.getApplicationContext(), paramVideoAppInterface, 0).show();
      paramSmallScreenService.stopSelf();
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiControlUIObserver = paramControlUIObserver;
  }
  
  public int a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(37, paramInt);
    }
    return 0;
  }
  
  public void a() {}
  
  protected void a(int paramInt) {}
  
  public void a(String paramString1, String paramString2) {}
  
  public void a(boolean paramBoolean)
  {
    this.l = 1;
    j();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenVideoControlUI", 2, "onPhoneCalling call start isSelf: " + paramBoolean1 + ",deviceName: " + this.jdField_a_of_type_ComTencentAvVideoController.a().r);
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
        this.jdField_a_of_type_ComTencentAvVideoController.a().w = this.jdField_a_of_type_ComTencentAvVideoController.a().r;
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("SmallScreenVideoControlUI", 2, "onPhoneCalling call end isSelf: " + paramBoolean1 + ",mAudioStateBeforePhoneCall: " + this.jdField_a_of_type_ComTencentAvVideoController.a().w);
  }
  
  public void b()
  {
    this.l = 2;
  }
  
  public void b(int paramInt)
  {
    if ((Build.VERSION.SDK_INT > 11) && ((this.jdField_a_of_type_ComTencentAvVideoController.a().f) || (this.jdField_a_of_type_ComTencentAvVideoController.a().g)) && (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)) {
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a.setRotation(360 - paramInt);
    }
  }
  
  public void b(boolean paramBoolean) {}
  
  public void c()
  {
    this.l = 6;
    v();
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    }
    this.jdField_a_of_type_AndroidContentResResources = null;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_ComTencentAvUtilsTipsManager = null;
    this.jdField_a_of_type_ArrayOfAndroidViewView = null;
    this.jdField_e_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_ComTencentAvUiControlUIObserver = null;
    this.jdField_b_of_type_AndroidWidgetTextView = null;
  }
  
  public void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoControlUI", 2, "onClose type = " + paramInt);
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().g()) || (this.jdField_a_of_type_ComTencentAvVideoController.f))
    {
      d(paramInt);
      v();
      return;
    }
    if ((paramInt == 25) || (paramInt == 56)) {
      d(paramInt);
    }
    w();
  }
  
  public void d() {}
  
  void d(int paramInt)
  {
    int m = 2131363559;
    int n = 2131363867;
    switch (paramInt)
    {
    default: 
      m = 2131363867;
    case 12: 
    case 43: 
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().l == 1011) {
        if (paramInt == 9) {
          paramInt = n;
        }
      }
      break;
    }
    for (;;)
    {
      a(paramInt);
      return;
      m = 2131363857;
      break;
      m = 2131363867;
      break;
      m = 2131363865;
      break;
      m = 2131363562;
      break;
      m = 2131363867;
      break;
      m = 2131363867;
      break;
      paramInt = 2131363854;
      if (this.jdField_a_of_type_ComTencentAvVideoController.f)
      {
        paramInt = 2131363874;
        continue;
        paramInt = m;
      }
    }
  }
  
  public void e() {}
  
  public void f()
  {
    this.l = 3;
  }
  
  protected void j()
  {
    TextView localTextView = (TextView)this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.a.findViewById(2131299090);
    this.jdField_b_of_type_AndroidWidgetTextView = localTextView;
    this.jdField_a_of_type_AndroidWidgetTextView = localTextView;
    this.jdField_a_of_type_ArrayOfAndroidViewView[0] = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.b.findViewById(2131299060);
    this.jdField_a_of_type_ArrayOfAndroidViewView[1] = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.a.findViewById(2131299060);
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.jdField_a_of_type_ArrayOfAndroidViewView != null)
    {
      int m = 0;
      while (m < this.jdField_a_of_type_ArrayOfAndroidViewView.length)
      {
        if (this.jdField_a_of_type_ArrayOfAndroidViewView[m] != null) {
          this.jdField_a_of_type_ArrayOfAndroidViewView[m].setVisibility(8);
        }
        m += 1;
      }
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void r()
  {
    this.l = 5;
    v();
  }
  
  public void s()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoControlUI", 2, "onPauseAudio");
    }
    if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(28, true);
    }
  }
  
  public void t()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoControlUI", 2, "onResumeAudio");
    }
    if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(28, false);
    }
  }
  
  public void u()
  {
    if (this.jdField_b_of_type_Boolean) {}
    while (((this.l < 2) || (this.l > 4)) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().f())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoControlUI", 2, "startTimer");
    }
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_e_of_type_JavaLangRunnable == null) {
      this.jdField_e_of_type_JavaLangRunnable = new gou(this);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_e_of_type_JavaLangRunnable, 0L);
  }
  
  public void v()
  {
    if (!this.jdField_b_of_type_Boolean) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenVideoControlUI", 2, "stopTimer");
      }
      this.jdField_b_of_type_Boolean = false;
    } while (this.jdField_e_of_type_JavaLangRunnable == null);
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
    }
    this.jdField_e_of_type_JavaLangRunnable = null;
  }
  
  public void w()
  {
    if (this.jdField_a_of_type_ArrayOfAndroidViewView != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenVideoControlUI", 2, "setScreenDarken");
      }
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      localAlphaAnimation.setDuration(100L);
      localAlphaAnimation.setRepeatMode(2);
      localAlphaAnimation.setRepeatCount(6);
      localAlphaAnimation.setFillAfter(true);
      localAlphaAnimation.setAnimationListener(this);
      int m = 0;
      while (m < this.jdField_a_of_type_ArrayOfAndroidViewView.length)
      {
        if (this.jdField_a_of_type_ArrayOfAndroidViewView[m] != null)
        {
          this.jdField_a_of_type_ArrayOfAndroidViewView[m].setVisibility(0);
          this.jdField_a_of_type_ArrayOfAndroidViewView[m].startAnimation(localAlphaAnimation);
        }
        m += 1;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\smallscreen\SmallScreenVideoControlUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */