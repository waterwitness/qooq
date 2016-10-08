import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.applist.WebAppActivity;
import com.tencent.open.base.StringAddition;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;

public class wtq
  extends WebChromeClient
{
  public wtq(WebAppActivity paramWebAppActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    if (this.a.o == 1) {
      this.a.b.setProgress(paramInt);
    }
  }
  
  public void onReceivedTitle(WebView paramWebView, String paramString)
  {
    super.onReceivedTitle(paramWebView, paramString);
    this.a.centerView.setText(StringAddition.a(paramString, 16, true, false));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wtq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */