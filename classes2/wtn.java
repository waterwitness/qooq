import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.applist.QZoneAppListActivity;
import com.tencent.open.base.LogUtility;
import com.tencent.smtt.sdk.WebView;

public class wtn
  implements View.OnClickListener
{
  public wtn(QZoneAppListActivity paramQZoneAppListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    LogUtility.b("QZoneAppListActivity", "button onClick!!!");
    if (TextUtils.isEmpty(QZoneAppListActivity.a(this.a)))
    {
      this.a.a();
      QZoneAppListActivity.a(this.a);
      QZoneAppListActivity.a(this.a).sendEmptyMessage(3);
      return;
    }
    this.a.a.loadUrl("javascript:JsBridge.callback(\"" + QZoneAppListActivity.b(this.a) + "\");void(0);");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wtn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */