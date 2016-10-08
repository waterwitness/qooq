package com.tencent.tmdownloader;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.tmassistantbase.a.m;
import com.tencent.tmassistantbase.network.NetworkMonitorReceiver;
import com.tencent.tmdownloader.internal.a.a.c;
import com.tencent.tmdownloader.internal.a.d;
import com.tencent.tmdownloader.internal.downloadclient.MobileQQCloseServiceReceiver;
import com.tencent.tmdownloader.internal.notification.NotifyParam;
import java.util.HashMap;

public class TMAssistantDownloadService
  extends Service
  implements com.tencent.tmdownloader.internal.a.a.a
{
  private static final int MSG_HANDSHAKE_YYB = 1;
  private static final int MSG_INIT_YYBMG = 0;
  protected static final String TAG = "TMAssistantDownloadSDKService";
  protected final g downloadSDKServiceImpl = new g(this);
  protected final HashMap<com.tencent.tmassistant.aidl.a, String> mCallbackHashMap = new HashMap();
  protected final RemoteCallbackList<com.tencent.tmassistant.aidl.a> mCallbacks = new RemoteCallbackList();
  private Handler mHandler = new f(this);
  private com.tencent.tmassistantbase.a.g mLogListener = null;
  com.tencent.tmdownloader.internal.notification.a mNotificationManager = null;
  c mServiceDownloadTaskManager = null;
  private com.tencent.tmdownloader.internal.downloadclient.b yybManager = null;
  
  private boolean handlePush(NotifyParam paramNotifyParam)
  {
    switch (paramNotifyParam.notificationTypeId)
    {
    }
    for (;;)
    {
      return true;
      com.tencent.tmdownloader.internal.a.a.b().a(paramNotifyParam.url);
      continue;
      com.tencent.tmdownloader.internal.a.a.b().c(paramNotifyParam.url);
      continue;
      paramNotifyParam = com.tencent.tmdownloader.internal.a.a.b().f(paramNotifyParam.url);
      if (paramNotifyParam != null)
      {
        com.tencent.tmdownloader.internal.notification.f.a(com.tencent.tmdownloader.internal.d.b.b(paramNotifyParam.l));
        com.tencent.tmdownloader.internal.notification.a.a().b(String.valueOf(paramNotifyParam.t));
        continue;
        com.tencent.tmdownloader.internal.a.a.b().d(paramNotifyParam.url);
      }
    }
  }
  
  public void OnDownloadProgressChanged(String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    m.c("TMAssistantDownloadSDKService", "enter");
    m.c("TMAssistantDownloadSDKService", "clientKey:" + paramString1 + ",receivedLen:" + paramLong1 + ",url:" + paramString2 + "; totalLen: " + paramLong2);
    try
    {
      int j = this.mCallbacks.beginBroadcast();
      int i = 0;
      while (i < j)
      {
        try
        {
          com.tencent.tmassistant.aidl.a locala = (com.tencent.tmassistant.aidl.a)this.mCallbacks.getBroadcastItem(i);
          String str = (String)this.mCallbackHashMap.get(locala);
          if ((str != null) && (str.equals(paramString1) == true))
          {
            m.c("TMAssistantDownloadSDKService", "clientKey:" + paramString1 + ",receivedLen:" + paramLong1 + ",url:" + paramString2 + " serviceCallback: " + locala);
            locala.a(paramString1, paramString2, paramLong1, paramLong2);
          }
        }
        catch (RemoteException localRemoteException)
        {
          for (;;)
          {
            m.c("TMAssistantDownloadSDKService", "exception: ", localRemoteException);
          }
        }
        i += 1;
        continue;
        m.c("TMAssistantDownloadSDKService", "exit");
      }
    }
    catch (Throwable paramString1)
    {
      m.c("TMAssistantDownloadSDKService", "exception: ", paramString1);
    }
    for (;;)
    {
      return;
      this.mCallbacks.finishBroadcast();
    }
  }
  
  public void OnDownloadStateChanged(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    m.c("TMAssistantDownloadSDKService", "enter");
    m.c("TMAssistantDownloadSDKService", "clientKey:" + paramString1 + "; url: " + paramString2 + "; state:" + paramInt1 + "; errorCode: " + paramInt2 + "; errorMsg: " + paramString3);
    try
    {
      int j = this.mCallbacks.beginBroadcast();
      int i = 0;
      while (i < j)
      {
        try
        {
          com.tencent.tmassistant.aidl.a locala = (com.tencent.tmassistant.aidl.a)this.mCallbacks.getBroadcastItem(i);
          String str = (String)this.mCallbackHashMap.get(locala);
          if ((str != null) && (str.equals(paramString1) == true))
          {
            m.c("TMAssistantDownloadSDKService", "serviceCallback.OnDownloadSDKServiceTaskStateChanged");
            locala.a(paramString1, paramString2, paramInt1, paramInt2, paramString3);
          }
        }
        catch (RemoteException localRemoteException)
        {
          for (;;)
          {
            m.c("TMAssistantDownloadSDKService", "exception: ", localRemoteException);
          }
        }
        i += 1;
        continue;
        m.c("TMAssistantDownloadSDKService", "exit");
      }
    }
    catch (Throwable paramString1)
    {
      m.c("TMAssistantDownloadSDKService", "exception: ", paramString1);
    }
    for (;;)
    {
      return;
      this.mCallbacks.finishBroadcast();
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    m.c("TMAssistantDownloadSDKService", "enter");
    m.c("TMAssistantDownloadSDKService", "intent:" + paramIntent);
    m.c("TMAssistantDownloadSDKService", "returnValue: " + this.downloadSDKServiceImpl);
    m.c("TMAssistantDownloadSDKService", "exit");
    return this.downloadSDKServiceImpl;
  }
  
  public void onCreate()
  {
    m.c("TMAssistantDownloadSDKService", "enter");
    super.onCreate();
    com.tencent.tmassistantbase.a.f.a().a(this);
    NetworkMonitorReceiver.a().b();
    this.mServiceDownloadTaskManager = new c(com.tencent.tmdownloader.internal.d.a.a().c());
    this.mServiceDownloadTaskManager.a(this);
    this.mServiceDownloadTaskManager.a();
    com.tencent.tmdownloader.internal.a.a.b().c();
    com.tencent.tmdownloader.internal.b.a.a().b();
    new Thread(new e(this)).start();
    m.c("TMAssistantDownloadSDKService", "exit");
  }
  
  public void onDestroy()
  {
    m.c("TMAssistantDownloadSDKService", "enter");
    super.onDestroy();
    com.tencent.tmdownloader.internal.a.a.b().d();
    this.mServiceDownloadTaskManager.b();
    this.mServiceDownloadTaskManager.a(null);
    this.mServiceDownloadTaskManager = null;
    if (this.mNotificationManager != null)
    {
      this.mNotificationManager.c();
      this.mNotificationManager = null;
    }
    NetworkMonitorReceiver.a().c();
    com.tencent.tmassistantbase.a.f.a().c();
    SystemClock.sleep(300L);
    m.c("TMAssistantDownloadSDKService", "exit");
    MobileQQCloseServiceReceiver.a().d(this);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    m.c("TMAssistantDownloadSDKService", "onStartCommand......");
    if (paramIntent != null) {}
    for (;;)
    {
      try
      {
        localObject1 = paramIntent.getStringExtra("client_key");
      }
      catch (Exception localException1)
      {
        try
        {
          Object localObject1;
          localNotifyParam = (NotifyParam)paramIntent.getParcelableExtra("notifyParam");
          Object localObject3 = localObject1;
          if (localNotifyParam != null)
          {
            if (!TextUtils.isEmpty(localNotifyParam.url))
            {
              handlePush(localNotifyParam);
              localObject3 = localObject1;
            }
          }
          else
          {
            m.c("TMAssistantDownloadSDKService", "onStartCommand......clientKey : " + (String)localObject3);
            localObject1 = new Message();
            ((Message)localObject1).what = 0;
            ((Message)localObject1).obj = localObject3;
            this.mHandler.sendMessage((Message)localObject1);
            return super.onStartCommand(paramIntent, paramInt1, paramInt2);
            localException1 = localException1;
            localException1.printStackTrace();
            Object localObject2 = null;
            continue;
          }
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
          NotifyParam localNotifyParam = null;
          continue;
        }
      }
      return super.onStartCommand(paramIntent, paramInt1, paramInt2);
      Object localObject4 = null;
    }
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    m.c("TMAssistantDownloadSDKService", "enter");
    m.c("TMAssistantDownloadSDKService", "intent:" + paramIntent);
    boolean bool = super.onUnbind(paramIntent);
    m.c("TMAssistantDownloadSDKService", "returnValue: " + bool);
    m.c("TMAssistantDownloadSDKService", "exit");
    return bool;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tmdownloader\TMAssistantDownloadService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */