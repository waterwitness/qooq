import android.graphics.Bitmap;
import android.view.View;
import android.widget.ProgressBar;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.jsbridge.JsBridge;
import com.tencent.mobileqq.richstatus.ActionUrlActivity;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.tencent.widget.ProtectedWebView;

public class uhi
  extends WebViewClient
{
  private uhi(ActionUrlActivity paramActionUrlActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    ActionUrlActivity.a(this.a).setVisibility(8);
    super.onPageFinished(paramWebView, paramString);
    this.a.a();
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    ActionUrlActivity.a(this.a).setVisibility(0);
    ActionUrlActivity.a(this.a).setVisibility(8);
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    ActionUrlActivity.a(this.a).clearView();
    ActionUrlActivity.a(this.a).setVisibility(8);
    ActionUrlActivity.a(this.a).setVisibility(0);
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    return ActionUrlActivity.a(this.a).a(paramWebView, paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\uhi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */