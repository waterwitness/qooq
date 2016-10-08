import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.recent.RecentCallHelper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class oxe
  implements View.OnClickListener
{
  public oxe(RecentCallHelper paramRecentCallHelper)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    RecentCallHelper.a(this.a).setVisibility(8);
    RecentCallHelper.a(this.a).a(RecentCallHelper.a(this.a));
    ReportController.b(null, "CliOper", "", "", "0X800510E", "0X800510E", 0, 0, "", "", "", "");
    ThreadManager.a(new oxf(this), 8, null, false);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\oxe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */