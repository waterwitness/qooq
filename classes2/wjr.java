import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.ui.WebViewBottomBar;
import com.tencent.mobileqq.webview.ui.WebViewBottomBar.OnBottomBarItemListener;

public class wjr
  implements AdapterView.OnItemClickListener
{
  public wjr(WebViewBottomBar paramWebViewBottomBar)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (WebViewBottomBar.a(this.a) == paramLong) {}
    do
    {
      return;
      WebViewBottomBar.a(this.a, (int)paramLong);
      WebViewBottomBar.a(this.a).notifyDataSetChanged();
    } while (WebViewBottomBar.a(this.a) == null);
    WebViewBottomBar.a(this.a).a((int)paramLong);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wjr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */