package com.tencent.mobileqq.troop.widget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class TroopUsageTimeReport
  extends BroadcastReceiver
{
  private static TroopUsageTimeReport jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopUsageTimeReport;
  public static final String a = "TroopUsageTimeReport-->AioUseTime";
  public static final String b = "TroopUsageTimeReport-->TroopUseTime";
  public static final String c = "android.intent.action.QUICKBOOT_POWEROFF";
  public static final String d = "homekey";
  public static final String e = "reason";
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private IntentFilter jdField_a_of_type_AndroidContentIntentFilter;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public boolean a;
  private long b;
  public boolean b;
  private long jdField_c_of_type_Long;
  private volatile boolean jdField_c_of_type_Boolean;
  private long d;
  private String f;
  
  private TroopUsageTimeReport()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidContentIntentFilter = new IntentFilter();
    this.jdField_a_of_type_AndroidContentIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    this.jdField_a_of_type_AndroidContentIntentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
    this.jdField_a_of_type_AndroidContentIntentFilter.addAction("android.intent.action.ACTION_SHUTDOWN");
    this.jdField_a_of_type_AndroidContentIntentFilter.addAction("android.intent.action.QUICKBOOT_POWEROFF");
  }
  
  public static TroopUsageTimeReport a()
  {
    if (jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopUsageTimeReport == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopUsageTimeReport == null) {
        jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopUsageTimeReport = new TroopUsageTimeReport();
      }
      return jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopUsageTimeReport;
    }
    finally {}
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getContext();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    if (this.jdField_a_of_type_AndroidContentContext != null) {
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this, this.jdField_a_of_type_AndroidContentIntentFilter);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (paramQQAppInterface != null) {
      this.f = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    }
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void b()
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_c_of_type_Long = System.currentTimeMillis();
      this.jdField_b_of_type_Boolean = true;
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("TroopUsageTimeReport-->AioUseTime", 2, "TroopUseTime仍在继续，无法开始");
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      long l = (this.jdField_b_of_type_Long - this.jdField_a_of_type_Long) / 1000L;
      int j = (int)l;
      int i = j;
      if (j <= 0) {
        i = 1;
      }
      SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
      if (localSessionInfo != null)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "time", "aio_time", 0, i, 0, localSessionInfo.a, "", "", "");
        if (QLog.isColorLevel()) {
          QLog.d("TroopUsageTimeReport-->AioUseTime", 2, "uin=" + this.f + ",mTroopUin=" + localSessionInfo.a + ",time=" + l + "s");
        }
      }
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void d()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.d = System.currentTimeMillis();
      long l = (this.d - this.jdField_c_of_type_Long) / 1000L;
      int j = (int)l;
      int i = j;
      if (j <= 0) {
        i = 1;
      }
      SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
      if (localSessionInfo != null)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "time", "grp_time", 0, i, 0, localSessionInfo.a, "", "", "");
        if (QLog.isColorLevel()) {
          QLog.d("TroopUsageTimeReport-->TroopUseTime", 2, "uin=" + this.f + ",mTroopUin=" + localSessionInfo.a + ",time=" + l + "s");
        }
      }
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  public void e()
  {
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = null;
    if (this.jdField_a_of_type_AndroidContentContext != null) {}
    try
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this);
      jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopUsageTimeReport = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (("android.intent.action.SCREEN_OFF".equals(paramContext)) || ("android.intent.action.ACTION_SHUTDOWN".equals(paramContext)) || ("android.intent.action.QUICKBOOT_POWEROFF".equals(paramContext)))
    {
      c();
      d();
    }
    do
    {
      do
      {
        return;
      } while (!"android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(paramContext));
      paramContext = paramIntent.getStringExtra("reason");
    } while ((paramContext == null) || (!paramContext.equals("homekey")));
    d();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\widget\TroopUsageTimeReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */