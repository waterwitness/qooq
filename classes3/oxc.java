import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mobileqq.activity.recent.RecentCallHelper;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class oxc
  implements PopupWindow.OnDismissListener
{
  public oxc(RecentCallHelper paramRecentCallHelper)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss()
  {
    if ((!RecentCallHelper.b(this.a)) && (RecentCallHelper.a(this.a) != null)) {
      RecentCallHelper.a(this.a).postDelayed(RecentCallHelper.a(this.a), 1000L);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\oxc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */