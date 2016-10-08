package com.tencent.mobileqq.earlydownload;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.app.AppRuntime;
import mqq.app.QQBroadcastReceiver;

public class EarlyDownloadReceiver
  extends QQBroadcastReceiver
{
  public EarlyDownloadReceiver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(AppRuntime paramAppRuntime, Context paramContext, Intent paramIntent)
  {
    if ((paramAppRuntime instanceof QQAppInterface))
    {
      paramAppRuntime = (QQAppInterface)paramAppRuntime;
      if (paramAppRuntime.isLogin()) {
        ((EarlyDownloadManager)paramAppRuntime.getManager(76)).a(paramIntent);
      }
    }
    else
    {
      return;
    }
    paramAppRuntime = new Intent(paramIntent.getAction().replace("req.", "resp."));
    paramAppRuntime.putExtra("strResName", paramIntent.getStringExtra("strResName"));
    paramAppRuntime.putExtra("strPkgName", paramIntent.getStringExtra("strPkgName"));
    paramAppRuntime.putExtra("reqResult", false);
    paramAppRuntime.putExtra("resultReason", "app is not login.");
    paramContext.sendBroadcast(paramAppRuntime);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\earlydownload\EarlyDownloadReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */