import com.tencent.mobileqq.activity.H5MagicPlayerActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

public class lom
  extends WebViewClient
{
  public lom(H5MagicPlayerActivity paramH5MagicPlayerActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if (this.a.a(paramString)) {}
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */