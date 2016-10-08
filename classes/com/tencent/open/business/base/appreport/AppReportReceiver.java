package com.tencent.open.business.base.appreport;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import wuk;

public class AppReportReceiver
  extends BroadcastReceiver
{
  public AppReportReceiver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    try
    {
      b();
      Process.killProcess(Process.myPid());
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void b()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.mobileqq.webprocess.report");
    BaseApplicationImpl.getContext().sendBroadcast(localIntent);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    ThreadManager.b(new wuk(this, paramIntent, paramContext));
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\open\business\base\appreport\AppReportReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */