package com.tencent.mobileqq.statistics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.os.MqqHandler;

public class ReportReceiver
  extends BroadcastReceiver
{
  public static final int a = 0;
  public static final String a = "com.tencent.mobileqq.action.REPORT";
  public static final int b = 1;
  public static final String b = "com.tencent.mobileqq.action.REPORT_RUNTIME";
  static final String c = "reporting_tag";
  static final String d = "reporting_detail";
  static final String e = "reporting_count";
  static final String f = "is_runtime";
  static final String g = "com.tencent.mobileqq.statistics.ReportReceiver";
  
  public ReportReceiver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (!"Success".equals(BaseApplicationImpl.sInjectResult)) {
      return;
    }
    ThreadManager.b().post(new ReportReceiver.ReportRunner(paramIntent));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\statistics\ReportReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */