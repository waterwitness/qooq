import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;

public class jgj
  extends jgr
{
  public jgj(AbsBaseWebViewActivity paramAbsBaseWebViewActivity)
  {
    super(paramAbsBaseWebViewActivity, null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewBase", 2, "old shouldInterceptRequest");
    }
    return a(paramWebView, paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jgj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */