import android.net.Uri;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;

public class jgi
  extends jgr
{
  public jgi(AbsBaseWebViewActivity paramAbsBaseWebViewActivity)
  {
    super(paramAbsBaseWebViewActivity, null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewBase", 2, "new shouldInterceptRequest");
    }
    return a(paramWebView, paramWebResourceRequest.getUrl().toString());
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jgi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */