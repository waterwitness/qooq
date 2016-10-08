import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import cooperation.qzone.QZoneHelper.QZoneCoverConstants;
import cooperation.qzone.webviewplugin.personalize.QZoneCoverStoreJsPlugin;

public class ysb
  implements View.OnClickListener
{
  public ysb(QZoneCoverStoreJsPlugin paramQZoneCoverStoreJsPlugin)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if ((this.a.mRuntime.a() != null) && (this.a.mRuntime.a() != null))
    {
      paramView = QZoneHelper.QZoneCoverConstants.a("qzone", String.valueOf(1), this.a.mRuntime.a().getAccount(), this.a.mRuntime.a().getAccount());
      this.a.mRuntime.a().loadUrl(paramView);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ysb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */