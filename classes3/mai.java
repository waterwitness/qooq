import com.tencent.mobileqq.activity.PreloadWebService;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

public class mai
  extends WebViewClient
{
  public mai(PreloadWebService paramPreloadWebService)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */