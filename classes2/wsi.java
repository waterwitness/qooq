import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.appcenter.QZoneAppWebViewActivity;
import com.tencent.open.base.LogUtility;

public class wsi
  implements View.OnLongClickListener
{
  public wsi(QZoneAppWebViewActivity paramQZoneAppWebViewActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onLongClick(View paramView)
  {
    LogUtility.c(this.a.c, "webView onLongClick");
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wsi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */