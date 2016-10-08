import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.biz.common.offline.util.OfflineDownloader;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmdownloader.ITMAssistantDownloadClientListener;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import java.util.HashMap;

public class hhh
  implements ITMAssistantDownloadClientListener
{
  public hhh(OfflineDownloader paramOfflineDownloader)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnDownloadSDKTaskProgressChanged(TMAssistantDownloadClient paramTMAssistantDownloadClient, String paramString, long paramLong1, long paramLong2)
  {
    if (paramTMAssistantDownloadClient == null) {}
    do
    {
      return;
      paramTMAssistantDownloadClient = (hhg)OfflineDownloader.a().get(paramString);
    } while ((paramTMAssistantDownloadClient == null) || (paramTMAssistantDownloadClient.a == null));
    int i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
    paramTMAssistantDownloadClient.a.a(i);
  }
  
  public void OnDownloadSDKTaskStateChanged(TMAssistantDownloadClient paramTMAssistantDownloadClient, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (paramTMAssistantDownloadClient == null) {
      OfflineDownloader.a(this.a, null, paramString1, null, -1, "client is null, " + paramString2);
    }
    do
    {
      return;
      paramString2 = (hhg)OfflineDownloader.a().get(paramString1);
      if ((paramString2 == null) || (paramString2.a == null))
      {
        OfflineDownloader.a(this.a, null, paramString1, null, -1, "download info is null or callback is null");
        return;
      }
      switch (paramInt1)
      {
      case 2: 
      case 3: 
      default: 
        return;
      case 4: 
        OfflineDownloader.a(this.a, paramTMAssistantDownloadClient, paramString2, paramString1);
        return;
      }
      OfflineDownloader.a(this.a, paramString2.a, paramString1, paramString2.c, paramInt2, "offline zip download fail");
      try
      {
        OfflineDownloader.a(this.a).cancelDownloadTask(paramString1);
        return;
      }
      catch (Exception paramTMAssistantDownloadClient) {}
    } while (!QLog.isDevelopLevel());
    QLog.d("OfflineDownload", 4, paramTMAssistantDownloadClient.toString());
  }
  
  public void OnDwonloadSDKServiceInvalid(TMAssistantDownloadClient paramTMAssistantDownloadClient) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hhh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */