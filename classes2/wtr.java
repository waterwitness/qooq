import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.applist.WebAppActivity;
import com.tencent.open.base.LogUtility;
import com.tencent.smtt.sdk.DownloadListener;

public class wtr
  implements DownloadListener
{
  public wtr(WebAppActivity paramWebAppActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    LogUtility.c("WebAppActivity", "url= " + paramString1);
    LogUtility.c("WebAppActivity", "minetype= " + paramString4);
    paramString1 = new Intent("android.intent.action.VIEW", Uri.parse(paramString1));
    try
    {
      this.a.startActivity(paramString1);
      return;
    }
    catch (Exception paramString1)
    {
      LogUtility.c("WebAppActivity", "no activity handle Intent.ACTION_VIEW ", paramString1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wtr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */