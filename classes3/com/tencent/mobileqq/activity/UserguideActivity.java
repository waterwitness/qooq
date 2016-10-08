package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.welcomeguide.QQAVFunnyFaceInvest;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class UserguideActivity
  extends FragmentActivity
{
  public static final String a = "UserGuide";
  static boolean a = false;
  public static final String b = "k_from_login";
  boolean b;
  
  public UserguideActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = false;
  }
  
  public static boolean a(Activity paramActivity)
  {
    if ((AppSetting.j) || (Build.VERSION.SDK_INT < 14)) {
      return false;
    }
    boolean bool = paramActivity.getIntent().getBooleanExtra("k_from_login", false);
    a = false;
    Object localObject2;
    Object localObject1;
    HashMap localHashMap;
    if (!bool)
    {
      localObject2 = paramActivity.getSharedPreferences("UserGuide", 0);
      localObject1 = ((SharedPreferences)localObject2).getString("qq_version", null);
      if (!"2880".equals(localObject1))
      {
        localHashMap = new HashMap();
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label282;
        }
        localHashMap.put("userguide_update_type", "2");
      }
    }
    for (;;)
    {
      StatisticCollector.a(paramActivity).a(null, "userguide_update2", true, 0L, 0L, localHashMap, "", false);
      localObject2 = ((SharedPreferences)localObject2).edit();
      ((SharedPreferences.Editor)localObject2).putString("qq_version", "2880");
      ((SharedPreferences.Editor)localObject2).commit();
      if (QQAVFunnyFaceInvest.b()) {
        a = true;
      }
      QLog.e("UserGuide", 1, "showUserGuide" + a + ", " + (String)localObject1 + ", " + "2880");
      if (a) {
        try
        {
          localObject1 = paramActivity.getIntent();
          ((Intent)localObject1).setClass(paramActivity, QQAVFunnyFaceInvest.class);
          paramActivity.startActivity((Intent)localObject1);
          paramActivity.overridePendingTransition(0, 0);
          return true;
        }
        catch (Exception localException)
        {
          if (QLog.isDevelopLevel()) {
            localException.printStackTrace();
          }
        }
      }
      a = false;
      if (a) {
        try
        {
          Intent localIntent = paramActivity.getIntent();
          localIntent.setClass(paramActivity, UserguideActivity.class);
          paramActivity.startActivity(localIntent);
          paramActivity.overridePendingTransition(0, 0);
          return true;
        }
        catch (Exception paramActivity)
        {
          if (QLog.isDevelopLevel()) {
            paramActivity.printStackTrace();
          }
        }
      }
      a = false;
      return false;
      label282:
      localHashMap.put("userguide_update_type", "1");
    }
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    return a;
  }
  
  public void a()
  {
    Intent localIntent = getIntent();
    if ((getAppRuntime() != null) && (getAppRuntime().isLogin()))
    {
      localIntent.setClass(this, SplashActivity.class);
      localIntent.putExtra("tab_index", MainFragment.a);
    }
    for (;;)
    {
      localIntent.addFlags(67108864);
      startActivity(localIntent);
      return;
      localIntent.setClass(this, LoginActivity.class);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = false;
    super.doOnCreate(null);
    setContentView(null);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (QLog.isDevelopLevel()) {
      QLog.d("UserGuide", 4, "UserguideActivity.doOnDestroy()");
    }
    a = false;
    this.b = true;
    System.gc();
  }
  
  public void finish()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("UserGuide", 4, "UserguideActivity.finish()");
    }
    if (isFinishing()) {
      return;
    }
    a();
    a = false;
    super.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\UserguideActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */