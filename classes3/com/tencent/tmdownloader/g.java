package com.tencent.tmdownloader;

import android.os.RemoteCallbackList;
import android.text.TextUtils;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistant.aidl.e;
import com.tencent.tmassistantbase.a.m;
import com.tencent.tmassistantbase.common.TMAssistantDownloadConst;
import com.tencent.tmdownloader.internal.a.a.c;
import com.tencent.tmdownloader.internal.a.f;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class g
  extends e
{
  protected g(TMAssistantDownloadService paramTMAssistantDownloadService) {}
  
  public int a()
  {
    m.c("TMAssistantDownloadSDKService", "returnValue: 1");
    return 1;
  }
  
  public int a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, Map paramMap)
  {
    m.c("TMAssistantDownloadSDKService", "enter");
    m.c("TMAssistantDownloadSDKService", "clientkey:" + paramString1 + ",url:" + paramString2 + ",manager:" + this.a.mServiceDownloadTaskManager + ",fileName:" + paramString4);
    String str;
    if (paramMap != null)
    {
      m.c("TMAssistantDownloadSDKService", "startDownloadTask params size : " + paramMap.size());
      if (paramMap.containsKey(TMAssistantDownloadConst.PARAM_SHOW_NOTIFICATION))
      {
        str = (String)paramMap.get(TMAssistantDownloadConst.PARAM_SHOW_NOTIFICATION);
        m.c("TMAssistantDownloadSDKService", "startDownloadTask showNotificationStr : " + str);
      }
    }
    for (;;)
    {
      if (this.a.mServiceDownloadTaskManager != null)
      {
        com.tencent.tmdownloader.internal.d.a.a().a(paramString1, paramString2);
        if ((paramMap != null) && (paramMap.containsKey(TMAssistantDownloadConst.PARAM_SHOW_NOTIFICATION)))
        {
          str = (String)paramMap.get(TMAssistantDownloadConst.PARAM_SHOW_NOTIFICATION);
          m.c("TMAssistantDownloadSDKService", "startDownloadTask showNotificationStr : " + str);
        }
        try
        {
          if ((!TextUtils.isEmpty(str)) && (Integer.valueOf(str).intValue() == TMAssistantDownloadConst.SHOW_NOTIFICATION_TRUE) && (this.a.mNotificationManager == null))
          {
            this.a.mNotificationManager = com.tencent.tmdownloader.internal.notification.a.a();
            this.a.mNotificationManager.b();
          }
          paramInt = this.a.mServiceDownloadTaskManager.a(paramString1, paramString2, paramInt, paramString3, paramString4, paramMap);
          m.c("TMAssistantDownloadSDKService", "returnValue: " + paramInt);
          m.c("TMAssistantDownloadSDKService", "exit");
          return paramInt;
          m.c("TMAssistantDownloadSDKService", "startDownloadTask params do not cotain notification");
          continue;
          m.c("TMAssistantDownloadSDKService", "startDownloadTask params null");
        }
        catch (Exception localException)
        {
          for (;;)
          {
            m.c("TMAssistantDownloadSDKService", "call startDownload showNotificationStr parse Exception: ", localException);
          }
        }
      }
    }
    m.c("TMAssistantDownloadSDKService", "returnValue: TMAssistantDownloadErrorCode.DownloadSDK_START_FAILED_PARAMETERS_INVALID");
    m.c("TMAssistantDownloadSDKService", "exit");
    return 3;
  }
  
  public TMAssistantDownloadTaskInfo a(String paramString1, String paramString2)
  {
    m.c("TMAssistantDownloadSDKService", "enter");
    if (this.a.mServiceDownloadTaskManager != null)
    {
      paramString1 = this.a.mServiceDownloadTaskManager.a(paramString1, paramString2);
      m.c("TMAssistantDownloadSDKService", "returnValue: " + paramString1);
      m.c("TMAssistantDownloadSDKService", "exit");
      return paramString1;
    }
    m.c("TMAssistantDownloadSDKService", "mServiceDownloadTaskManager is null");
    m.c("TMAssistantDownloadSDKService", "returnValue: null");
    m.c("TMAssistantDownloadSDKService", "exit");
    return null;
  }
  
  public List<TMAssistantDownloadTaskInfo> a(String paramString)
  {
    if (this.a.mServiceDownloadTaskManager != null)
    {
      paramString = this.a.mServiceDownloadTaskManager.b(paramString);
      m.c("TMAssistantDownloadSDKService", "jimluo service return " + paramString);
      return paramString;
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    m.c("TMAssistantDownloadSDKService", "enter");
    m.c("TMAssistantDownloadSDKService", "maxTaskNum: " + paramInt);
    f.a().a(paramInt);
    m.c("TMAssistantDownloadSDKService", "exit");
  }
  
  public void a(String paramString, com.tencent.tmassistant.aidl.a parama)
  {
    m.c("TMAssistantDownloadSDKService", "enter");
    m.c("TMAssistantDownloadSDKService", "clientKey:" + paramString);
    if ((paramString != null) && (parama != null))
    {
      this.a.mCallbacks.register(parama);
      m.c("TMAssistantDownloadSDKService", "register callback");
    }
    try
    {
      this.a.mCallbackHashMap.put(parama, paramString);
      m.c("TMAssistantDownloadSDKService", "exit");
      return;
    }
    finally {}
  }
  
  public void a(boolean paramBoolean)
  {
    m.c("TMAssistantDownloadSDKService", "enter");
    m.c("TMAssistantDownloadSDKService", "isTaskAutoResume: " + paramBoolean);
    f.a().a(paramBoolean);
    m.c("TMAssistantDownloadSDKService", "exit");
  }
  
  public void b(String paramString, com.tencent.tmassistant.aidl.a parama)
  {
    m.c("TMAssistantDownloadSDKService", "enter");
    m.c("TMAssistantDownloadSDKService", "clientKey:" + paramString);
    if ((paramString != null) && (parama != null))
    {
      this.a.mCallbacks.unregister(parama);
      m.c("TMAssistantDownloadSDKService", "unregister callback");
    }
    try
    {
      this.a.mCallbackHashMap.remove(parama);
      m.c("TMAssistantDownloadSDKService", "exit");
      return;
    }
    finally {}
  }
  
  public void b(String paramString1, String paramString2)
  {
    m.c("TMAssistantDownloadSDKService", "enter");
    m.c("TMAssistantDownloadSDKService", "clientkey:" + paramString1 + ",url:" + paramString2);
    try
    {
      if (this.a.mServiceDownloadTaskManager != null)
      {
        this.a.mServiceDownloadTaskManager.b(paramString1, paramString2);
        m.c("TMAssistantDownloadSDKService", "pauseDownload");
      }
      m.c("TMAssistantDownloadSDKService", "exit");
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        m.c("TMAssistantDownloadSDKService", "exception: ", paramString1);
        paramString1.printStackTrace();
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    m.c("TMAssistantDownloadSDKService", "enter");
    m.c("TMAssistantDownloadSDKService", "isDownloadWifiOnly: " + paramBoolean);
    f.a().b(paramBoolean);
    m.c("TMAssistantDownloadSDKService", "exit");
  }
  
  public boolean b()
  {
    m.c("TMAssistantDownloadSDKService", "enter");
    boolean bool = com.tencent.tmdownloader.internal.a.a.b().e().booleanValue();
    m.c("TMAssistantDownloadSDKService", "returnValue: " + bool);
    m.c("TMAssistantDownloadSDKService", "exit");
    return bool;
  }
  
  public void c()
  {
    if (TMAssistantDownloadService.access$100(this.a) == null)
    {
      m.c("TMAssistantDownloadSDKService", "Enter openLogListener ");
      TMAssistantDownloadService.access$102(this.a, new h(this));
      m.a(TMAssistantDownloadService.access$100(this.a));
    }
  }
  
  public void c(String paramString1, String paramString2)
  {
    m.c("TMAssistantDownloadSDKService", "enter");
    m.c("TMAssistantDownloadSDKService", "clientkey:" + paramString1 + ",url:" + paramString2);
    if (this.a.mServiceDownloadTaskManager != null)
    {
      this.a.mServiceDownloadTaskManager.c(paramString1, paramString2);
      m.c("TMAssistantDownloadSDKService", "cancelDownload");
    }
    m.c("TMAssistantDownloadSDKService", "exit");
  }
  
  public void d()
  {
    if (TMAssistantDownloadService.access$100(this.a) != null)
    {
      m.b(TMAssistantDownloadService.access$100(this.a));
      TMAssistantDownloadService.access$102(this.a, null);
    }
  }
  
  public void d(String paramString1, String paramString2)
  {
    m.c("TMAssistantDownloadSDKService", "deleteDownloadTask enter");
    m.c("TMAssistantDownloadSDKService", "clientkey:" + paramString1 + ",url:" + paramString2);
    if (this.a.mServiceDownloadTaskManager != null)
    {
      this.a.mServiceDownloadTaskManager.d(paramString1, paramString2);
      m.c("TMAssistantDownloadSDKService", "deleteDownloadTask");
    }
    m.c("TMAssistantDownloadSDKService", "deleteDownloadTask exit");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tmdownloader\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */