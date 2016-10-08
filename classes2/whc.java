import android.os.Bundle;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.filemanager.app.UniformDownload;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.AbsWebView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.DownloadListener;

public class whc
  implements DownloadListener
{
  public whc(AbsWebView paramAbsWebView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "start UniformDownloadActivity");
    }
    String str = this.a.a.getUrl();
    Bundle localBundle = new Bundle();
    localBundle.putLong("_filesize", paramLong);
    localBundle.putString("param_user_agent", paramString2);
    localBundle.putString("param_content_des", paramString3);
    localBundle.putString("param_mime_type", paramString4);
    localBundle.putString("param_refer_url", str);
    UniformDownload.a(this.a.g, paramString1, localBundle);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\whc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */