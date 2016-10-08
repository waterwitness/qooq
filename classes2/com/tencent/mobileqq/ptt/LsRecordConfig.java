package com.tencent.mobileqq.ptt;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public abstract class LsRecordConfig
{
  public LsRecordConfig()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    BaseApplicationImpl.a.getSharedPreferences("LsRecord_" + paramQQAppInterface.a(), 0).edit().putBoolean("UserGuide", true).commit();
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "markUserGuideFlag");
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    boolean bool = false;
    if (!BaseApplicationImpl.a.getSharedPreferences("LsRecord_" + paramQQAppInterface.a(), 0).getBoolean("UserGuide", false)) {
      bool = true;
    }
    return bool;
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    long l = System.currentTimeMillis();
    BaseApplicationImpl.a.getSharedPreferences("LsRecord_" + paramQQAppInterface.a(), 0).edit().putLong("UserTips", l);
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "markUserTipsFlag:" + l);
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    boolean bool = false;
    if (Math.abs(System.currentTimeMillis() - BaseApplicationImpl.a.getSharedPreferences("LsRecord_" + paramQQAppInterface.a(), 0).getLong("UserTips", 0L)) >= 3600000L) {
      bool = true;
    }
    return bool;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\ptt\LsRecordConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */