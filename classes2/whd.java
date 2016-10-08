import android.net.Uri;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.AbsWebView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;

public class whd
  extends whh
{
  public whd(AbsWebView paramAbsWebView)
  {
    super(paramAbsWebView, null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "new shouldInterceptRequest");
    }
    return a(paramWebView, paramWebResourceRequest.getUrl().toString());
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\whd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */