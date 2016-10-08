import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.ApkGetCodeListener;
import com.tencent.open.downloadnew.DownloaderGetCodeClient;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

public class wwi
  implements EIPCResultCallback
{
  public wwi(DownloaderGetCodeClient paramDownloaderGetCodeClient)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    LogUtility.c("DownloaderGetCodeClient", "EIPCResultCallback onCallback...");
    if (paramEIPCResult == null) {
      return;
    }
    paramEIPCResult = paramEIPCResult.data;
    if (paramEIPCResult == null)
    {
      LogUtility.c("DownloaderGetCodeClient", "EIPCResultCallback onCallback data is null...");
      return;
    }
    String str1 = paramEIPCResult.getString("PackageName");
    int i = paramEIPCResult.getInt("VersionCode");
    String str2 = paramEIPCResult.getString("Code");
    boolean bool = paramEIPCResult.getBoolean("IsSuccess");
    LogUtility.c("DownloaderGetCodeClient", "EIPCResultCallback onCallback pkgName|" + str1 + " versionCode|" + i + " isSuc|" + bool + " code|" + str2);
    if (DownloaderGetCodeClient.a(this.a) != null)
    {
      DownloaderGetCodeClient.a(this.a).a(str1, i, str2, bool, null);
      return;
    }
    LogUtility.c("DownloaderGetCodeClient", "EIPCResultCallback onCallback getCodeListener is null");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wwi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */