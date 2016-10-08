package com.tencent.mobileqq.app;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.activity.fling.FlingTrackerHandler;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.startup.step.InitSkin;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableActivityProcesser;
import com.tencent.theme.SkinnableActivityProcesser.Callback;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import mqq.app.BaseActivity;
import pue;
import puf;

public class BaseActivity2
  extends BaseActivity
  implements SkinnableActivityProcesser.Callback
{
  public static boolean K = true;
  private static final int jdField_a_of_type_Int = 2;
  public static BaseActivity2 a;
  private static ShakeListener jdField_a_of_type_ComTencentMobileqqAppShakeListener;
  private static boolean jdField_a_of_type_Boolean;
  protected static final String y;
  public boolean I = true;
  protected boolean J = true;
  public boolean L = true;
  protected int M;
  public boolean M;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private FlingHandler jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler;
  public ScreenShot a;
  SkinnableActivityProcesser jdField_a_of_type_ComTencentThemeSkinnableActivityProcesser;
  public SystemBarCompact a;
  private String jdField_a_of_type_JavaLangString = getClass().getSimpleName();
  protected String z;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    y = BaseActivity2.class.getSimpleName();
  }
  
  public BaseActivity2()
  {
    this.jdField_M_of_type_Boolean = true;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppScreenShot != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.a();
      this.jdField_a_of_type_ComTencentMobileqqAppScreenShot = null;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (jdField_a_of_type_ComTencentMobileqqAppShakeListener == null) {
        ThreadManager.a(new pue(this), 5, null, true);
      }
    }
    while (jdField_a_of_type_ComTencentMobileqqAppShakeListener == null) {
      return;
    }
    ((SensorManager)getSystemService("sensor")).unregisterListener(jdField_a_of_type_ComTencentMobileqqAppShakeListener);
    jdField_a_of_type_ComTencentMobileqqAppShakeListener = null;
  }
  
  private boolean a(Intent paramIntent)
  {
    String str = paramIntent.getAction();
    if ((!TextUtils.isEmpty(str)) && (str.equals("android.media.action.IMAGE_CAPTURE"))) {}
    do
    {
      do
      {
        do
        {
          return true;
        } while (((!TextUtils.isEmpty(str)) && (str.equals("android.intent.action.GET_CONTENT"))) || ((!TextUtils.isEmpty(str)) && (str.equals("android.intent.action.PICK"))));
        paramIntent = paramIntent.getComponent();
        if (paramIntent == null) {
          break;
        }
        str = paramIntent.getPackageName();
      } while ((!TextUtils.isEmpty(str)) && (str.equals("com.qzone")));
      paramIntent = paramIntent.getClassName();
    } while ((!TextUtils.isEmpty(paramIntent)) && (paramIntent.equals("com.tencent.mobileqq.activity.QQBrowserDelegationActivity")));
    return false;
  }
  
  protected void J()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(y, 4, "startUnlockActivity..." + this.jdField_a_of_type_JavaLangString);
    }
    startActivity(new Intent(this, GesturePWDUnlockActivity.class));
  }
  
  protected void K()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(y, 4, "checkUnlockForSpecial. flag=,AbsAppInter.visibleActCnt=?,stopflag" + this.jdField_M_of_type_Int);
    }
  }
  
  public View a(int paramInt)
  {
    return findViewById(paramInt);
  }
  
  public View a(View paramView, int paramInt)
  {
    return paramView.findViewById(paramInt);
  }
  
  public ViewGroup.LayoutParams a(View paramView)
  {
    return paramView.getLayoutParams();
  }
  
  protected boolean a()
  {
    return true;
  }
  
  protected boolean d()
  {
    return false;
  }
  
  public int f()
  {
    return getResources().getDimensionPixelSize(2131492908);
  }
  
  public void onBackPressed()
  {
    if (d()) {
      return;
    }
    try
    {
      super.onBackPressed();
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d(y, 2, "", localThrowable);
      }
      finish();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if ((a()) && (this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler.onConfigurationChanged(paramConfiguration);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.i(y, 2, "[" + hashCode() + "]" + this.jdField_a_of_type_JavaLangString + " process id =" + Process.myPid() + " onCreate task : " + getTaskId());
    }
    try
    {
      paramBundle = BaseApplicationImpl.a;
      if (Build.VERSION.SDK_INT <= 10) {
        break label347;
      }
      i = 4;
    }
    catch (IllegalStateException paramBundle)
    {
      try
      {
        for (;;)
        {
          registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
          if ((this.L) && (ImmersiveUtils.isSupporImmersive() == 1))
          {
            getWindow().addFlags(67108864);
            if (this.jdField_M_of_type_Boolean) {
              this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact = new SystemBarCompact(this, true, getResources().getColor(2131428295));
            }
          }
          return;
          int i = 0;
          continue;
          paramBundle = paramBundle;
          this.z = null;
          if (QLog.isColorLevel()) {
            QLog.e(y, 2, "Get lastLoginUin error", paramBundle);
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler = new FlingGestureHandler(this);
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e(y, 2, "registerReceiver error", paramBundle);
          }
        }
      }
    }
    this.z = paramBundle.getSharedPreferences("Last_Login", i).getString("uin", null);
    if ((this.z == null) && (QLog.isColorLevel())) {
      QLog.d(y, 1, "last uin is null.. has porblem?");
    }
    StatisticCollector.a(this).a(this);
    if (InitSkin.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentThemeSkinnableActivityProcesser = new SkinnableActivityProcesser(this, this);
    }
    paramBundle = getIntent().getExtras();
    if (paramBundle != null)
    {
      i = paramBundle.getInt("fling_action_key");
      if ((i != 0) && (a()))
      {
        if (1 == i) {
          this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler = new FlingTrackerHandler(this);
        }
      }
      else {
        this.J = paramBundle.getBoolean("PhotoConst.ALLOW_LOCK", true);
      }
    }
    else
    {
      if (!jdField_a_of_type_Boolean)
      {
        if (SettingCloneUtil.readValue(this, null, getString(2131367835), "qqsetting_screenshot_key", false)) {
          a(true);
        }
        jdField_a_of_type_Boolean = true;
      }
      paramBundle = new IntentFilter();
      paramBundle.addAction("android.intent.action.SCREEN_OFF");
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new puf(this, null);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.i(y, 2, "[" + hashCode() + "]" + this.jdField_a_of_type_JavaLangString + " process id =" + Process.myPid() + " onDestroy task : " + getTaskId());
    }
    jdField_a_of_type_ComTencentMobileqqAppBaseActivity2 = null;
    StatisticCollector.a(this).d(this);
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {}
    try
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      if (this.jdField_a_of_type_ComTencentThemeSkinnableActivityProcesser != null) {
        this.jdField_a_of_type_ComTencentThemeSkinnableActivityProcesser.destory();
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (QLog.isColorLevel()) {
      QLog.d(y, 2, "[" + hashCode() + "]" + this.jdField_a_of_type_JavaLangString + " onPause");
    }
    this.I = true;
    StatisticCollector.a(this).c(this);
    a();
  }
  
  public void onPostThemeChanged() {}
  
  public void onPreThemeChanged() {}
  
  public void onResume()
  {
    super.onResume();
    if (QLog.isColorLevel()) {
      QLog.d(y, 2, "[" + hashCode() + "]" + this.jdField_a_of_type_JavaLangString + " onResume ");
    }
    this.I = false;
    StatisticCollector.a(this).b(this);
    jdField_a_of_type_ComTencentMobileqqAppBaseActivity2 = this;
    int i;
    SharedPreferences.Editor localEditor;
    if (Build.VERSION.SDK_INT > 10)
    {
      i = 4;
      localEditor = getSharedPreferences("screen_shot", i).edit();
      localEditor.putString("currentactivity", getClass().getName());
      if (Build.VERSION.SDK_INT <= 8) {
        break label273;
      }
      localEditor.apply();
      label129:
      K = GesturePWDUtils.getAppForground(this);
      if (QLog.isDevelopLevel()) {
        QLog.d(y, 4, "onResume.mAppForground = " + K + ",mCanLock=" + this.J);
      }
      if ((K) || (!this.J) || (this.z == null) || (!GesturePWDUtils.getJumpLock(this, this.z))) {
        break label283;
      }
      J();
    }
    for (;;)
    {
      if (!K)
      {
        K = true;
        GesturePWDUtils.setAppForground(this, K);
      }
      this.jdField_M_of_type_Int = 0;
      this.J = true;
      if ((this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact != null) && (this.jdField_M_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.init();
      }
      return;
      i = 0;
      break;
      label273:
      localEditor.commit();
      break label129;
      label283:
      if ((!K) && (this.J)) {
        K();
      }
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (QLog.isColorLevel()) {
      QLog.d(y, 2, "[" + hashCode() + "]" + this.jdField_a_of_type_JavaLangString + " onStart");
    }
    if ((a()) && (this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler.onStart();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (QLog.isColorLevel()) {
      QLog.d(y, 2, "[" + hashCode() + "]" + this.jdField_a_of_type_JavaLangString + " onStop");
    }
    this.jdField_M_of_type_Int = 1;
    K = GesturePWDUtils.isAppOnForeground(this);
    if (!K) {
      GesturePWDUtils.setAppForground(this, K);
    }
    if (QLog.isColorLevel()) {
      QLog.d(y, 2, "zsw subaccount onStop stop get sub msg AbsAppInter.visibleActCnt = ?");
    }
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    this.jdField_M_of_type_Int = 2;
    if (a(paramIntent)) {
      this.J = false;
    }
    switch (2)
    {
    }
    try
    {
      super.startActivityForResult(paramIntent, paramInt);
      return;
    }
    catch (Exception paramIntent)
    {
      if (!QLog.isColorLevel()) {
        return;
      }
      QLog.d(y, 2, "startActivity failed with: ", paramIntent);
      return;
      paramIntent.putExtra("fling_action_key", 2);
      paramIntent.putExtra("fling_code_key", hashCode());
      super.startActivityForResult(paramIntent, paramInt);
    }
    super.startActivityForResult(paramIntent, paramInt);
    return;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\BaseActivity2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */