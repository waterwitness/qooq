import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richstatus.ActionUrlActivity;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;

public class uhh
  extends WebChromeClient
{
  private uhh(ActionUrlActivity paramActionUrlActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    super.onProgressChanged(paramWebView, paramInt);
  }
  
  public void onReceivedTitle(WebView paramWebView, String paramString)
  {
    this.a.setTitle(paramString);
    this.a.a();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\uhh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */