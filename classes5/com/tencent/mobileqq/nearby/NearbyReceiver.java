package com.tencent.mobileqq.nearby;

import android.content.Context;
import android.content.Intent;
import android.os.ResultReceiver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.olympic.ScannerResultReceiver;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.QQBroadcastReceiver;

public class NearbyReceiver
  extends QQBroadcastReceiver
{
  protected static final String a = "NearbyReceiver";
  
  public NearbyReceiver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String getModuleId()
  {
    return "module_nearby";
  }
  
  public void onReceive(AppRuntime paramAppRuntime, Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      return;
      paramIntent.setExtrasClassLoader(ScannerResultReceiver.class.getClassLoader());
      if ((paramAppRuntime != null) && ((paramAppRuntime instanceof NearbyAppInterface)))
      {
        paramContext = (ResultReceiver)paramIntent.getParcelableExtra("resultreceiver_nearbyfakeactivity");
        if (paramContext != null) {
          paramContext.send(0, null);
        }
        int i = paramIntent.getIntExtra("nearby_preload_from", 0);
        NearbySPUtil.b(paramAppRuntime.getAccount());
        ((NearbyAppInterface)paramAppRuntime).a(1, i);
      }
    } while (!QLog.isColorLevel());
    QLog.d("NearbyReceiver", 2, "PRELOAD_NEARBY_PROCESS, " + paramAppRuntime);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\NearbyReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */