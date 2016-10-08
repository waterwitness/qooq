import android.view.View;
import com.tencent.mobileqq.activity.recent.RecentCallHelper;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class oxm
  implements Runnable
{
  public oxm(RecentCallHelper paramRecentCallHelper)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    View localView;
    if (RecentCallHelper.a(this.a) != null)
    {
      if (!RecentCallHelper.a(this.a)) {
        break label63;
      }
      localView = RecentCallHelper.a(this.a).findViewById(2131301489);
      if ((localView != null) && (this.a.a != null)) {
        RecentCallHelper.a(this.a, this.a.a, localView);
      }
    }
    label63:
    do
    {
      return;
      localView = RecentCallHelper.a(this.a).findViewById(2131301486);
    } while ((localView == null) || (this.a.a == null));
    RecentCallHelper.b(this.a, this.a.a, localView);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\oxm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */