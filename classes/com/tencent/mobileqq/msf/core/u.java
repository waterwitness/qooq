package com.tencent.mobileqq.msf.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.hardware.SensorEventListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;

final class u
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.intent.action.ACTION_SHUTDOWN")) {}
    do
    {
      do
      {
        try
        {
          o.a(o.Q);
          return;
        }
        catch (Exception paramContext)
        {
          while (!QLog.isColorLevel()) {}
          QLog.e("health_manager", 2, "setTodayOffSet Exception:" + paramContext.toString());
          return;
        }
      } while (!paramIntent.getAction().equals("MSF_Action_Refresh_Steps"));
      QLog.i("health_manager", 1, "AlarmManager 23:59 action received:" + o.M);
    } while (!o.M);
    if ((o.K != null) && (o.L != null)) {}
    try
    {
      paramContext = o.K.getClass().getMethod("flush", new Class[] { SensorEventListener.class });
      paramContext.setAccessible(true);
      paramContext.invoke(o.K, new Object[] { o.L });
      if (o.H > o.X) {
        o.X = o.H;
      }
      o.a(false, null, null);
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("health_manager", 2, "Exception:" + paramContext.toString());
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\core\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */