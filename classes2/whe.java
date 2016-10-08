import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.AbsWebView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;

public class whe
  extends whh
{
  public whe(AbsWebView paramAbsWebView)
  {
    super(paramAbsWebView, null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "old shouldInterceptRequest");
    }
    return a(paramWebView, paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\whe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */