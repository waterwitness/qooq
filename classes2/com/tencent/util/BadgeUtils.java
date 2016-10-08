package com.tencent.util;

import android.app.Notification;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.push.BadgeUtilImpl;
import com.tencent.qphone.base.util.QLog;
import xrj;
import xrk;

public class BadgeUtils
{
  public static int a = 0;
  private static Handler jdField_a_of_type_AndroidOsHandler;
  private static BadgeUtils jdField_a_of_type_ComTencentUtilBadgeUtils;
  private static Runnable jdField_a_of_type_JavaLangRunnable = new xrk();
  private static final String jdField_a_of_type_JavaLangString = "BadgeUtils";
  public static boolean a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    jdField_a_of_type_Boolean = true;
    jdField_a_of_type_Int = -1;
  }
  
  public static int a()
  {
    String str = "";
    int i;
    if (jdField_a_of_type_Int != -1) {
      i = jdField_a_of_type_Int;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BadgeUtils", 2, "getLimitCount Limitcount" + i);
      }
      return i;
      try
      {
        Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.aio_config.name(), "-1|1=0,2=0,3=0,4=0,5=1|1|999");
        if (QLog.isColorLevel()) {
          QLog.d("BadgeUtils", 2, "LimitConfig:" + (String)localObject);
        }
        localObject = ((String)localObject).split("\\|");
        if (localObject.length > 3) {
          str = localObject[3];
        }
        jdField_a_of_type_Int = Integer.valueOf(str).intValue();
        i = jdField_a_of_type_Int;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BadgeUtils", 2, "getLimitCount e:" + localException.toString());
        }
        jdField_a_of_type_Int = 999;
        i = jdField_a_of_type_Int;
      }
    }
  }
  
  public static BadgeUtils a()
  {
    if (jdField_a_of_type_ComTencentUtilBadgeUtils == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentUtilBadgeUtils == null) {
        jdField_a_of_type_ComTencentUtilBadgeUtils = new BadgeUtils();
      }
      return jdField_a_of_type_ComTencentUtilBadgeUtils;
    }
    finally {}
  }
  
  public static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BadgeUtils", 2, "enableBadge mobileqq");
    }
    jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    BadgeUtilImpl.enableBadge(BaseApplicationImpl.a);
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    if ((!jdField_a_of_type_Boolean) && (paramInt > 0)) {}
    while (!a(paramContext)) {
      return;
    }
    int i = a();
    if (QLog.isColorLevel()) {
      QLog.d("BadgeUtils", 2, "setBadge limit: " + i + ", count: " + paramInt);
    }
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      BadgeUtilImpl.setLimitCount(i);
      BadgeUtilImpl.setBadge(paramContext, paramInt);
      return;
    }
    ThreadManager.b(new xrj(i, paramContext, paramInt));
  }
  
  public static void a(Context paramContext, int paramInt, Notification paramNotification)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BadgeUtils", 2, "setMIUI6Badge count: " + paramInt);
    }
    if (!CommonBadgeUtilImpl.isMIUI6()) {
      return;
    }
    BadgeUtilImpl.setLimitCount(a());
    BadgeUtilImpl.setMIUI6Badge(paramContext, paramInt, paramNotification);
  }
  
  public static boolean a(Context paramContext)
  {
    return BadgeUtilImpl.isSupportBadge(paramContext);
  }
  
  public static void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BadgeUtils", 2, "disableBadge mobileqq");
    }
    jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    BadgeUtilImpl.disableBadge(BaseApplicationImpl.a);
    jdField_a_of_type_AndroidOsHandler.postDelayed(jdField_a_of_type_JavaLangRunnable, 2000L);
  }
  
  public static void c()
  {
    jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\util\BadgeUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */