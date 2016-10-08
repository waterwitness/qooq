package com.tencent.mobileqq.msf.service;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.os.IBinder;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.a.a;
import com.tencent.mobileqq.msf.core.c.m;
import com.tencent.mobileqq.msf.core.o;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.remote.IBaseService.Stub;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MsfService
  extends Service
{
  public static MsfCore core = new MsfCore();
  public static volatile boolean inited = false;
  static HashSet invalidUids = new HashSet();
  static e msfServiceReqHandler = new e();
  static f msfServiceRespHandler;
  static HashSet passedUids = new HashSet();
  public static volatile boolean sIsCreatedByAutoBoot = false;
  public static final String tag = "MSF.S.MsfService";
  private IBaseService.Stub binder = new d(this);
  
  public static MsfCore getCore()
  {
    return core;
  }
  
  public static boolean isSamePackage(Context paramContext, int paramInt, String paramString)
  {
    boolean bool2 = true;
    boolean bool1;
    if (invalidUids.contains(Integer.valueOf(paramInt)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.S.MsfService", 2, "found invalid uid call " + paramInt);
      }
      bool1 = false;
    }
    do
    {
      return bool1;
      bool1 = bool2;
    } while (passedUids.contains(Integer.valueOf(paramInt)));
    String[] arrayOfString = paramContext.getPackageManager().getPackagesForUid(paramInt);
    paramContext = paramContext.getPackageName();
    int j = arrayOfString.length;
    int i = 0;
    label93:
    if (i < j) {
      if (arrayOfString[i].equals(paramContext))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.S.MsfService", 2, "found accountSyncRequest from the same packeName application,");
        }
        passedUids.add(Integer.valueOf(paramInt));
      }
    }
    for (i = 0;; i = 1)
    {
      bool1 = bool2;
      if (i == 0) {
        break;
      }
      invalidUids.add(Integer.valueOf(paramInt));
      paramContext = "";
      Object localObject = paramContext;
      if (arrayOfString != null)
      {
        i = arrayOfString.length;
        paramInt = 0;
        for (;;)
        {
          localObject = paramContext;
          if (paramInt >= i) {
            break;
          }
          localObject = arrayOfString[paramInt];
          paramContext = paramContext + " " + (String)localObject + ";";
          paramInt += 1;
        }
        i += 1;
        break label93;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MSF.S.MsfService", 2, "found invalid uid call " + (String)localObject);
      }
      try
      {
        paramContext = new HashMap();
        paramContext.put("param_Reason", localObject);
        paramContext.put("method", paramString);
        core.getStatReporter().a("dim.Msf.invaildAppCall", true, 0L, 0L, paramContext, false, false);
        return false;
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MSF.S.MsfService", 2, "send invaild call error " + paramContext, paramContext);
          }
        }
      }
    }
  }
  
  /* Error */
  public static void serviceInit(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 9
    //   3: ldc 2
    //   5: monitorenter
    //   6: getstatic 163	com/tencent/mobileqq/msf/service/MsfService:inited	Z
    //   9: ifne +189 -> 198
    //   12: invokestatic 169	android/os/SystemClock:elapsedRealtime	()J
    //   15: lstore_3
    //   16: getstatic 32	com/tencent/mobileqq/msf/service/MsfService:core	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   19: aload_0
    //   20: iload_1
    //   21: invokevirtual 173	com/tencent/mobileqq/msf/core/MsfCore:init	(Landroid/content/Context;Z)Z
    //   24: pop
    //   25: invokestatic 169	android/os/SystemClock:elapsedRealtime	()J
    //   28: lstore 5
    //   30: ldc -81
    //   32: iconst_1
    //   33: new 77	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   40: ldc -79
    //   42: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: lload 5
    //   47: lload_3
    //   48: lsub
    //   49: invokevirtual 180	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   52: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   58: aload_0
    //   59: getstatic 32	com/tencent/mobileqq/msf/service/MsfService:core	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   62: invokestatic 185	com/tencent/mobileqq/msf/service/c:a	(Landroid/content/Context;Lcom/tencent/mobileqq/msf/core/MsfCore;)V
    //   65: new 187	com/tencent/mobileqq/msf/service/f
    //   68: dup
    //   69: getstatic 32	com/tencent/mobileqq/msf/service/MsfService:core	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   72: invokespecial 190	com/tencent/mobileqq/msf/service/f:<init>	(Lcom/tencent/mobileqq/msf/core/MsfCore;)V
    //   75: putstatic 192	com/tencent/mobileqq/msf/service/MsfService:msfServiceRespHandler	Lcom/tencent/mobileqq/msf/service/f;
    //   78: getstatic 192	com/tencent/mobileqq/msf/service/MsfService:msfServiceRespHandler	Lcom/tencent/mobileqq/msf/service/f;
    //   81: ldc -62
    //   83: invokevirtual 198	com/tencent/mobileqq/msf/service/f:setName	(Ljava/lang/String;)V
    //   86: getstatic 192	com/tencent/mobileqq/msf/service/MsfService:msfServiceRespHandler	Lcom/tencent/mobileqq/msf/service/f;
    //   89: invokevirtual 201	com/tencent/mobileqq/msf/service/f:start	()V
    //   92: iconst_1
    //   93: putstatic 163	com/tencent/mobileqq/msf/service/MsfService:inited	Z
    //   96: invokestatic 169	android/os/SystemClock:elapsedRealtime	()J
    //   99: lload_3
    //   100: lsub
    //   101: lstore 7
    //   103: ldc -81
    //   105: iconst_1
    //   106: new 77	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   113: ldc -53
    //   115: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: lload 7
    //   120: invokevirtual 180	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   123: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   129: new 128	java/util/HashMap
    //   132: dup
    //   133: invokespecial 129	java/util/HashMap:<init>	()V
    //   136: astore_0
    //   137: aload_0
    //   138: ldc -51
    //   140: new 77	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   147: ldc 122
    //   149: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: lload 5
    //   154: lload_3
    //   155: lsub
    //   156: invokevirtual 180	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   159: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokevirtual 206	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   165: pop
    //   166: getstatic 32	com/tencent/mobileqq/msf/service/MsfService:core	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   169: getfield 210	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/m;
    //   172: astore_2
    //   173: lload 7
    //   175: ldc2_w 211
    //   178: lcmp
    //   179: ifle +23 -> 202
    //   182: iload 9
    //   184: istore_1
    //   185: aload_2
    //   186: ldc -42
    //   188: iload_1
    //   189: lload 7
    //   191: lconst_0
    //   192: aload_0
    //   193: iconst_0
    //   194: iconst_0
    //   195: invokevirtual 151	com/tencent/mobileqq/msf/core/c/m:a	(Ljava/lang/String;ZJJLjava/util/Map;ZZ)V
    //   198: ldc 2
    //   200: monitorexit
    //   201: return
    //   202: iconst_1
    //   203: istore_1
    //   204: goto -19 -> 185
    //   207: astore_0
    //   208: ldc 2
    //   210: monitorexit
    //   211: aload_0
    //   212: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	paramContext	Context
    //   0	213	1	paramBoolean	boolean
    //   172	14	2	localm	m
    //   15	140	3	l1	long
    //   28	125	5	l2	long
    //   101	89	7	l3	long
    //   1	182	9	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   6	173	207	finally
    //   185	198	207	finally
  }
  
  private void startForegroundCompat()
  {
    try
    {
      if (Build.VERSION.SDK_INT < 18) {
        startForeground(9527, new Notification());
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private void stopForegroundCompat()
  {
    try
    {
      if (Build.VERSION.SDK_INT < 18) {
        stopForeground(true);
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public SharedPreferences getSharedPreferences(String paramString, int paramInt)
  {
    return SharedPreferencesProxyManager.getInstance().getProxy(paramString, paramInt);
  }
  
  protected void handleAccountSyncRequest(Context paramContext, ToServiceMsg paramToServiceMsg, int paramInt)
  {
    if (paramToServiceMsg == null) {
      if (QLog.isColorLevel()) {
        QLog.w("MSF.S.MsfService", 2, "handleAccountSyncRequest toServiceMsg null!");
      }
    }
    do
    {
      do
      {
        return;
      } while (!paramToServiceMsg.getServiceCmd().equals("cmd_sync_syncuser"));
      try
      {
        core.handleAccountSyncRequest(paramContext, paramToServiceMsg, paramInt);
        return;
      }
      catch (Exception paramContext) {}
    } while (!QLog.isColorLevel());
    QLog.d("MSF.S.MsfService", 2, "handleAccountSyncRequestReport error " + paramContext, paramContext);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    Object localObject = null;
    try
    {
      paramIntent = paramIntent.getStringExtra("to_SenderProcessName");
      QLog.d("MSF.S.MsfService", 1, "serivce onBind by :" + paramIntent);
      if (a.ai()) {
        a.a(false);
      }
      return this.binder;
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        paramIntent.printStackTrace();
        paramIntent = (Intent)localObject;
      }
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    QLog.d("MSF.S.MsfService", 1, "serivce onCreate");
    serviceInit(this, sIsCreatedByAutoBoot);
    if (QLog.isColorLevel()) {
      QLog.d("MSF.S.MsfService", 2, "serivce onCreate... autoBoot[" + sIsCreatedByAutoBoot + "]");
    }
    sIsCreatedByAutoBoot = false;
    startForegroundCompat();
  }
  
  public void onDestroy()
  {
    try
    {
      BaseApplication.getContext().unregisterReceiver(core.netConnICenter);
    }
    catch (Exception localException3)
    {
      try
      {
        BaseApplication.getContext().unregisterReceiver(core.getNetFlowStore());
      }
      catch (Exception localException3)
      {
        try
        {
          BaseApplication.getContext().unregisterReceiver(core.getStandyModeManager());
        }
        catch (Exception localException3)
        {
          try
          {
            for (;;)
            {
              o.a(o.P);
              stopForegroundCompat();
              super.onDestroy();
              return;
              localException1 = localException1;
              QLog.d("MSF.S.MsfService", 1, "unregisterReceiver failed. " + localException1, localException1);
              continue;
              localException2 = localException2;
              QLog.d("MSF.S.MsfService", 1, "unregisterReceiver failed. " + localException2, localException2);
              continue;
              localException3 = localException3;
              QLog.d("MSF.S.MsfService", 1, "unregisterReceiver failed. " + localException3, localException3);
            }
          }
          catch (Exception localException4)
          {
            for (;;)
            {
              QLog.d("MSF.S.MsfService", 1, "unregisterReceiver failed. " + localException4, localException4);
            }
          }
        }
      }
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    QLog.d("MSF.S.MsfService", 1, "serivce onStart");
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("to_SenderProcessName");
    if (QLog.isColorLevel()) {
      QLog.d("MSF.S.MsfService", 2, "serivce onUnbind by :" + str);
    }
    return super.onUnbind(paramIntent);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\service\MsfService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */