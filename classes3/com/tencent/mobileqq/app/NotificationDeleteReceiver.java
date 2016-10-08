package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.QQBroadcastReceiver;

public class NotificationDeleteReceiver
  extends QQBroadcastReceiver
{
  public NotificationDeleteReceiver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(AppRuntime paramAppRuntime, Context paramContext, Intent paramIntent)
  {
    QLog.d("NotificationDeleteReceiver", 2, "NotificationDeleteReceiver");
    ReportController.b((QQAppInterface)paramAppRuntime, "CliOper", "", "", "0X80046A6", "0X80046A6", 0, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\NotificationDeleteReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */