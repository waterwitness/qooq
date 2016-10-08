import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.ui.WebViewTitlerBar;

public class wju
  implements View.OnClickListener
{
  public wju(WebViewTitlerBar paramWebViewTitlerBar)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (WebViewTitlerBar.a(this.a) != null) {
      WebViewTitlerBar.a(this.a).a(this.a.a, new String[] { "" });
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wju.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */