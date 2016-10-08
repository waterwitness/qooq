package com.tencent.av.smallscreen;

import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import gnw;
import gnx;
import gny;
import mqq.app.AppService;

public class BaseSmallScreenService
  extends AppService
  implements SmallScreenRelativeLayout.FloatListener
{
  static final String jdField_a_of_type_JavaLangString = "BaseSmallScreenService";
  int jdField_a_of_type_Int;
  Handler jdField_a_of_type_AndroidOsHandler;
  PhoneStateListener jdField_a_of_type_AndroidTelephonyPhoneStateListener;
  TelephonyManager jdField_a_of_type_AndroidTelephonyTelephonyManager;
  SmallScreenRelativeLayout jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout;
  SmallScreenToast jdField_a_of_type_ComTencentAvSmallscreenSmallScreenToast;
  Runnable jdField_a_of_type_JavaLangRunnable;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  public SmallScreenRelativeLayout b;
  SmallScreenToast jdField_b_of_type_ComTencentAvSmallscreenSmallScreenToast;
  Runnable jdField_b_of_type_JavaLangRunnable;
  public boolean b;
  int c;
  public boolean c;
  int d;
  public boolean d;
  int e;
  public boolean e;
  int f;
  int g;
  
  public BaseSmallScreenService()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_e_of_type_Int = 0;
    this.f = 7;
    this.g = 0;
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout = null;
    this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout = null;
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenToast = null;
    this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenToast = null;
    this.jdField_a_of_type_JavaLangRunnable = null;
    this.jdField_b_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_AndroidTelephonyTelephonyManager = null;
    this.jdField_a_of_type_AndroidTelephonyPhoneStateListener = new gnw(this);
  }
  
  public int a(SmallScreenRelativeLayout paramSmallScreenRelativeLayout)
  {
    if (paramSmallScreenRelativeLayout == this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout) {}
    for (paramSmallScreenRelativeLayout = this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenToast;; paramSmallScreenRelativeLayout = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenToast) {
      return paramSmallScreenRelativeLayout.a().x;
    }
  }
  
  public Handler a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  Animation a()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(1750L);
    localAlphaAnimation.setRepeatMode(2);
    localAlphaAnimation.setRepeatCount(-1);
    localAlphaAnimation.setInterpolator(new SmallScreenInterpolator());
    return localAlphaAnimation;
  }
  
  void a()
  {
    if (!this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenToast.a()) {}
  }
  
  public void a(int paramInt, String paramString) {}
  
  public void a(SmallScreenRelativeLayout paramSmallScreenRelativeLayout) {}
  
  public void a(SmallScreenRelativeLayout paramSmallScreenRelativeLayout, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramSmallScreenRelativeLayout == this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout) {}
    for (paramSmallScreenRelativeLayout = this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenToast;; paramSmallScreenRelativeLayout = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenToast)
    {
      WindowManager.LayoutParams localLayoutParams = paramSmallScreenRelativeLayout.a();
      localLayoutParams.x = paramInt1;
      localLayoutParams.y = paramInt2;
      localLayoutParams.width = (paramInt3 - paramInt1);
      localLayoutParams.height = (paramInt4 - paramInt2);
      paramSmallScreenRelativeLayout.c();
      return;
    }
  }
  
  public boolean a(SmallScreenRelativeLayout paramSmallScreenRelativeLayout)
  {
    return true;
  }
  
  public int b(SmallScreenRelativeLayout paramSmallScreenRelativeLayout)
  {
    if (paramSmallScreenRelativeLayout == this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout) {}
    for (paramSmallScreenRelativeLayout = this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenToast;; paramSmallScreenRelativeLayout = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenToast) {
      return paramSmallScreenRelativeLayout.a().y;
    }
  }
  
  void b()
  {
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenToast.a();
  }
  
  public int c(SmallScreenRelativeLayout paramSmallScreenRelativeLayout)
  {
    if (paramSmallScreenRelativeLayout == this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout) {}
    for (paramSmallScreenRelativeLayout = this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenToast;; paramSmallScreenRelativeLayout = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenToast) {
      return paramSmallScreenRelativeLayout.a().width;
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseSmallScreenService", 2, "WL_DEBUG onIsLockChanged mIsLock = " + this.jdField_c_of_type_Boolean);
    }
    f();
  }
  
  public int d(SmallScreenRelativeLayout paramSmallScreenRelativeLayout)
  {
    if (paramSmallScreenRelativeLayout == this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout) {}
    for (paramSmallScreenRelativeLayout = this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenToast;; paramSmallScreenRelativeLayout = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenToast) {
      return paramSmallScreenRelativeLayout.a().height;
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseSmallScreenService", 2, "WL_DEBUG onHasSmartBarChanged mHasSmartBar = " + this.jdField_b_of_type_Boolean);
    }
    if (this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout != null) {
      this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.a();
    }
  }
  
  public void e() {}
  
  void f() {}
  
  public void g() {}
  
  public void onCreate()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseSmallScreenService", 2, "WL_DEBUG onCreate start");
    }
    super.onCreate();
    this.jdField_d_of_type_Boolean = false;
    try
    {
      LayoutInflater localLayoutInflater = (LayoutInflater)getSystemService("layout_inflater");
      if (localLayoutInflater == null)
      {
        stopSelf();
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("BaseSmallScreenService", 2, "WL_DEBUG onCreate e = " + localException);
        }
        Object localObject1 = null;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      do
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("BaseSmallScreenService", 2, "WL_DEBUG onCreate e = " + localOutOfMemoryError);
          }
          localObject2 = null;
        }
        this.jdField_a_of_type_AndroidTelephonyTelephonyManager = ((TelephonyManager)getSystemService("phone"));
        this.jdField_a_of_type_AndroidTelephonyTelephonyManager.listen(this.jdField_a_of_type_AndroidTelephonyPhoneStateListener, 32);
        this.jdField_a_of_type_Int = getResources().getDimensionPixelSize(2131494073);
        this.jdField_b_of_type_Int = getResources().getDimensionPixelSize(2131494074);
        this.jdField_c_of_type_Int = getResources().getDimensionPixelSize(2131494082);
        this.jdField_d_of_type_Int = getResources().getDimensionPixelSize(2131494083);
        this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout = ((SmallScreenRelativeLayout)((LayoutInflater)localObject2).inflate(2130903610, null));
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout = ((SmallScreenRelativeLayout)((LayoutInflater)localObject2).inflate(2130903611, null));
        this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.b();
        this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setFloatListener(this);
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setFloatListener(this);
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setTitleHeight(getResources().getDimensionPixelSize(2131492908) * 5 / 2);
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.findViewById(2131299424).startAnimation(a());
        this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenToast = new SmallScreenToast(this, this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout);
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenToast = new SmallScreenToast(this, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout);
        Object localObject2 = this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenToast.a();
        ((WindowManager.LayoutParams)localObject2).flags = 136;
        ((WindowManager.LayoutParams)localObject2).type = 2002;
        this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setIsRotateSize(true);
        this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setSize(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
        localObject2 = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenToast.a();
        ((WindowManager.LayoutParams)localObject2).flags = 136;
        ((WindowManager.LayoutParams)localObject2).type = 2002;
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setSize(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
        localObject2 = new IntentFilter();
        ((IntentFilter)localObject2).addAction("android.intent.action.NEW_OUTGOING_CALL");
        ((IntentFilter)localObject2).addAction("tencent.video.q2v.ACTION_SELECT_MEMBER_ACTIVITY_IS_RESUME_CHANGED");
        this.jdField_b_of_type_Boolean = SmallScreenUtils.a();
        this.jdField_e_of_type_Boolean = SmallScreenUtils.c(((AppInterface)this.app).a());
        this.jdField_c_of_type_Boolean = SmallScreenUtils.b(((AppInterface)this.app).a());
        if (this.jdField_a_of_type_JavaLangRunnable == null) {
          this.jdField_a_of_type_JavaLangRunnable = new gnx(this);
        }
        a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 400L);
        if (this.jdField_b_of_type_JavaLangRunnable == null) {
          this.jdField_b_of_type_JavaLangRunnable = new gny(this);
        }
        a().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 1000L);
      } while (!QLog.isColorLevel());
      QLog.d("BaseSmallScreenService", 2, "WL_DEBUG onCreate end");
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseSmallScreenService", 2, "WL_DEBUG onDestroy start");
    }
    super.onDestroy();
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidTelephonyTelephonyManager.listen(this.jdField_a_of_type_AndroidTelephonyPhoneStateListener, 0);
    this.jdField_a_of_type_AndroidTelephonyTelephonyManager = null;
    if (this.jdField_b_of_type_JavaLangRunnable != null) {
      a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    }
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    this.jdField_a_of_type_AndroidTelephonyPhoneStateListener = null;
    this.jdField_a_of_type_JavaLangRunnable = null;
    this.jdField_b_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenToast.b();
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.c();
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenToast = null;
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout = null;
    if (QLog.isColorLevel()) {
      QLog.d("BaseSmallScreenService", 2, "WL_DEBUG onDestroy end");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\smallscreen\BaseSmallScreenService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */