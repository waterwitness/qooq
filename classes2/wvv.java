import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.ApkGetCodeListener;
import com.tencent.open.downloadnew.DownloadManager;

public class wvv
  implements ApkGetCodeListener
{
  public wvv(DownloadManager paramDownloadManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String paramString1, int paramInt, String paramString2, boolean paramBoolean, Bundle paramBundle)
  {
    LogUtility.c(DownloadManager.a, "receive get code finished pkgName|" + paramString1 + " versionCode|" + paramInt + " code|" + paramString2 + " extraData|" + paramBundle);
    paramBundle = new Bundle();
    paramBundle.putString("PackageName", paramString1);
    paramBundle.putString("Code", paramString2);
    paramBundle.putInt("VersionCode", paramInt);
    paramBundle.putBoolean("IsSuccess", paramBoolean);
    DownloadManager.a(this.a, paramBundle);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wvv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */