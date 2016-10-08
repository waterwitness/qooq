import android.os.Bundle;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloaderGetCodeServer;
import eipc.EIPCResult;
import java.util.Map;

public class wwk
  extends ConfigObserver
{
  private wwk(DownloaderGetCodeServer paramDownloaderGetCodeServer)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    LogUtility.c("DownloaderWriteCodeIPC", "GetAuthCodeObserver onGetAuthCode isSuccess|" + paramBoolean + " code|" + paramString1 + " reqId|" + paramString2);
    if (paramString2 == null) {
      return;
    }
    Bundle localBundle = (Bundle)DownloaderGetCodeServer.a(this.a).get(paramString2);
    if (localBundle == null)
    {
      LogUtility.c("DownloaderWriteCodeIPC", "GetAuthCodeObserver reqId|" + paramString2 + "  but params context is null");
      return;
    }
    int i = localBundle.getInt("CallbackId");
    paramString2 = new Bundle();
    paramString2.putString("PackageName", localBundle.getString("PackageName"));
    paramString2.putInt("VersionCode", localBundle.getInt("VersionCode"));
    if (paramBoolean)
    {
      paramString2.putBoolean("IsSuccess", true);
      paramString2.putString("Code", paramString1);
    }
    for (;;)
    {
      LogUtility.c("DownloaderWriteCodeIPC", "GetAuthCodeObserver callbackId|" + i + " result|" + paramString2);
      DownloaderGetCodeServer.a(this.a).callbackResult(i, EIPCResult.createSuccessResult(paramString2));
      return;
      paramString2.putBoolean("IsSuccess", false);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wwk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */