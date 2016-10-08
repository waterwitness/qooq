package com.tencent.open.downloadnew;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.base.LogUtility;
import com.tencent.tmassistantsdk.ITMAssistantCallBackListener;
import com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V2;
import mqq.os.MqqHandler;
import wxf;
import wxg;

public class MyAppApi$QQDownloadListener
  implements ITMAssistantCallBackListener
{
  protected MyAppApi$QQDownloadListener(MyAppApi paramMyAppApi)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnDownloadTaskProgressChanged(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, long paramLong1, long paramLong2)
  {
    LogUtility.b("MyAppApi", "OnDownloadTaskProgressChanged  receiveDataLen:" + paramLong1 + ",totalDataLen:" + paramLong2);
    int i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
    DownloadManager localDownloadManager = DownloadManager.a();
    DownloadInfo localDownloadInfo2 = localDownloadManager.a(paramTMAssistantCallYYBParamStruct.SNGAppId);
    DownloadInfo localDownloadInfo1 = localDownloadInfo2;
    if (localDownloadInfo2 == null)
    {
      localDownloadInfo1 = this.a.a(paramTMAssistantCallYYBParamStruct, null);
      localDownloadManager.e(localDownloadInfo1);
    }
    localDownloadInfo1.l = i;
    localDownloadInfo1.a(2);
    localDownloadManager.a(2, localDownloadInfo1);
    LogUtility.a("MyAppApi", "OnDownloadTaskProgressChanged info state=" + localDownloadInfo1.a() + " progress=" + localDownloadInfo1.l);
  }
  
  public void OnDownloadTaskStateChanged(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, int paramInt1, int paramInt2, String paramString)
  {
    this.a.b = true;
    LogUtility.b("MyAppApi", "OnDownloadTaskStateChanged");
    ThreadManager.b().post(new wxf(this, paramTMAssistantCallYYBParamStruct, paramInt1, paramInt2, paramString));
  }
  
  public void OnQQDownloaderInvalid()
  {
    LogUtility.b("MyAppApi", "应用宝挂了");
    ThreadManager.b().post(new wxg(this));
  }
  
  public void OnServiceFree()
  {
    LogUtility.b("MyAppApi", "OnServiceFree");
    try
    {
      ((TMAssistantCallYYB_V2)this.a.a).releaseIPCConnected();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\downloadnew\MyAppApi$QQDownloadListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */