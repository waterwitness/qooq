import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.appcommon.CallBackEvent;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.WebViewDownloadListener;
import com.tencent.smtt.sdk.WebView;

public class wxo
  implements Runnable
{
  public wxo(WebViewDownloadListener paramWebViewDownloadListener, WebView paramWebView, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentSmttSdkWebView != null) && (this.jdField_a_of_type_JavaLangString != null) && (CallBackEvent.a().a())) {}
    try
    {
      this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl(this.jdField_a_of_type_JavaLangString);
      return;
    }
    catch (Exception localException)
    {
      LogUtility.a(WebViewDownloadListener.jdField_a_of_type_JavaLangString, "doJsCallBack >>> ", localException);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wxo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */