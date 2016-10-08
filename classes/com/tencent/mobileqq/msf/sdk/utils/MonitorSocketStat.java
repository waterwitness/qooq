package com.tencent.mobileqq.msf.sdk.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.msf.sdk.l;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class MonitorSocketStat
  extends Thread
{
  public static byte STATUS;
  public static l dataFlow = new l();
  public static boolean isScreenOff;
  private static Handler mMonitorSocketHandler;
  private static HandlerThread mMonitorSocketThread;
  private long lastgotStatusTime;
  private BroadcastReceiver mReceiver;
  private MsfServiceSdk msfSdk;
  private String processName;
  private boolean running = true;
  
  public MonitorSocketStat()
  {
    setName("MonitorSocketStat");
    this.mReceiver = new a(null);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.SCREEN_ON");
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    BaseApplication.getContext().registerReceiver(this.mReceiver, localIntentFilter);
    mMonitorSocketThread = new HandlerThread("CheckNetFlowStatus");
    mMonitorSocketThread.start();
    mMonitorSocketHandler = new Handler(mMonitorSocketThread.getLooper());
  }
  
  private void getnetFlowStatus()
  {
    runOnMonitorSocketThread(new c(this));
  }
  
  public static boolean runOnMonitorSocketThread(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return false;
    }
    if (mMonitorSocketHandler == null)
    {
      QLog.d("MSF.D.MonitorSocket", 2, "MonitorSocketHandler is null");
      mMonitorSocketThread = new HandlerThread("CheckNetFlowStatus1");
      mMonitorSocketThread.start();
      mMonitorSocketHandler = new Handler(mMonitorSocketThread.getLooper());
    }
    return mMonitorSocketHandler.post(paramRunnable);
  }
  
  public void run()
  {
    if (this.processName == null) {
      this.processName = MsfSdkUtils.getProcessName(BaseApplication.getContext());
    }
    boolean bool;
    try
    {
      if ((BaseApplication.getContext().getPackageName() + ":MSF").equals(this.processName))
      {
        for (;;)
        {
          bool = this.running;
          if (!bool) {
            break;
          }
          try
          {
            if (dataFlow == null) {
              dataFlow = new l();
            }
            a locala = (a)dataFlow.k();
            locala.a = this.processName;
            if (locala != null) {
              MsfService.getCore().getNetFlowStore().a(locala);
            }
            if ((dataFlow.size() <= 1) && (System.currentTimeMillis() - this.lastgotStatusTime >= 60000L))
            {
              getnetFlowStatus();
              this.lastgotStatusTime = System.currentTimeMillis();
            }
          }
          catch (Exception localException1)
          {
            QLog.d("MSF.D.MonitorSocket", 1, "" + localException1, localException1);
          }
        }
        return;
      }
    }
    catch (Exception localException2)
    {
      if (dataFlow != null) {
        dataFlow.clear();
      }
      QLog.d("MSF.D.MonitorSocket", 1, "" + localException2, localException2);
    }
    do
    {
      bool = this.running;
    } while (!bool);
    for (;;)
    {
      try
      {
        if (dataFlow == null) {
          dataFlow = new l();
        }
        Object localObject = (a)dataFlow.k();
        if (localObject != null)
        {
          if (this.msfSdk == null) {
            this.msfSdk = MsfServiceSdk.get();
          }
          if (this.msfSdk == null) {
            break label368;
          }
          localObject = this.msfSdk.getDataFlowMsg(this.processName, (a)localObject);
          this.msfSdk.sendMsg((ToServiceMsg)localObject);
        }
        if ((dataFlow.size() > 1) || (System.currentTimeMillis() - this.lastgotStatusTime < 60000L)) {
          break;
        }
        getnetFlowStatus();
        this.lastgotStatusTime = System.currentTimeMillis();
      }
      catch (Exception localException3)
      {
        QLog.d("MSF.D.MonitorSocket", 1, "" + localException3, localException3);
      }
      break;
      label368:
      dataFlow.i(localException3);
    }
  }
  
  public void setProcessName(String paramString)
  {
    this.processName = paramString;
  }
  
  private class a
    extends BroadcastReceiver
  {
    private String b;
    
    private a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      this.b = paramIntent.getAction();
      if ("android.intent.action.SCREEN_ON".equals(this.b))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.D.MonitorSocket", 2, "screenOn");
        }
        MonitorSocketStat.isScreenOff = false;
        MonitorSocketStat.this.getnetFlowStatus();
      }
      while (!"android.intent.action.SCREEN_OFF".equals(this.b)) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MSF.D.MonitorSocket", 2, "screenOff");
      }
      MonitorSocketStat.isScreenOff = true;
      MonitorSocketStat.this.getnetFlowStatus();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\sdk\utils\MonitorSocketStat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */