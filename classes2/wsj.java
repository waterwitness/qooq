import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.appcenter.QZoneAppWebViewActivity;
import com.tencent.open.base.LogUtility;
import com.tencent.smtt.sdk.WebView;

public class wsj
  implements View.OnClickListener
{
  public wsj(QZoneAppWebViewActivity paramQZoneAppWebViewActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    LogUtility.b("IphoneTitleBarActivity", "on RightButton click!");
    if (!TextUtils.isEmpty(QZoneAppWebViewActivity.a(this.a))) {
      this.a.a.loadUrl("javascript:JsBridge.callback(\"" + QZoneAppWebViewActivity.b(this.a) + "\");void(0);");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wsj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */