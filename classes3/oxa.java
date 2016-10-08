import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mobileqq.activity.recent.RecentCallHelper;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class oxa
  implements PopupWindow.OnDismissListener
{
  public oxa(RecentCallHelper paramRecentCallHelper)
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


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\oxa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */