package com.tencent.tmdownloader.internal.downloadclient;

import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantbase.a.m;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.SubScribeSDKDownloadTaskByViaRequest;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.SyncSDKDownloadTaskRequest;
import com.tencent.tmdownloader.d;
import java.util.ArrayList;
import java.util.List;

class e
  implements com.tencent.tmdownloader.a
{
  e(b paramb) {}
  
  public void a()
  {
    if (b.b(this.a) != null)
    {
      b.b(this.a).a();
      b.a(this.a, null);
    }
  }
  
  public void a(TMAssistantDownloadTaskInfo paramTMAssistantDownloadTaskInfo)
  {
    m.c(b.b(), "onSyncSDKDownloadInfo......");
    if (paramTMAssistantDownloadTaskInfo == null) {}
    for (;;)
    {
      return;
      SyncSDKDownloadTaskRequest localSyncSDKDownloadTaskRequest = new SyncSDKDownloadTaskRequest();
      localSyncSDKDownloadTaskRequest.data = com.tencent.tmassistantsdk.internal.openSDK.param.a.a(paramTMAssistantDownloadTaskInfo);
      paramTMAssistantDownloadTaskInfo = b.a(localSyncSDKDownloadTaskRequest, "");
      if ((paramTMAssistantDownloadTaskInfo != null) && (paramTMAssistantDownloadTaskInfo.length > 0)) {
        try
        {
          if (b.a(this.a) != null)
          {
            b.a(this.a).b(paramTMAssistantDownloadTaskInfo);
            return;
          }
        }
        catch (Throwable paramTMAssistantDownloadTaskInfo)
        {
          paramTMAssistantDownloadTaskInfo.printStackTrace();
        }
      }
    }
  }
  
  public void a(List<String> paramList, List<TMAssistantDownloadTaskInfo> paramList1)
  {
    SubScribeSDKDownloadTaskByViaRequest localSubScribeSDKDownloadTaskByViaRequest = new SubScribeSDKDownloadTaskByViaRequest();
    localSubScribeSDKDownloadTaskByViaRequest.viaList = ((ArrayList)paramList);
    localSubScribeSDKDownloadTaskByViaRequest.data = ((ArrayList)com.tencent.tmassistantsdk.internal.openSDK.param.a.a(paramList1));
    paramList = b.a(localSubScribeSDKDownloadTaskByViaRequest, "");
    if ((paramList != null) && (paramList.length > 0)) {}
    try
    {
      if (b.a(this.a) != null) {
        b.a(this.a).b(paramList);
      }
      return;
    }
    catch (Throwable paramList)
    {
      paramList.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tmdownloader\internal\downloadclient\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */