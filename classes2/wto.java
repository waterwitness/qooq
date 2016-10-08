import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.applist.QZoneAppListActivity;
import com.tencent.open.base.LogUtility;

public class wto
  implements View.OnLongClickListener
{
  public wto(QZoneAppListActivity paramQZoneAppListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onLongClick(View paramView)
  {
    LogUtility.c("IphoneTitleBarActivity", "webView onLongClick");
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */