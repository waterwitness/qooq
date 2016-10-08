import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.data.CardProfile;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class nbd
  implements View.OnClickListener
{
  public nbd(VisitorsActivity paramVisitorsActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof nbe))
    {
      paramView = (nbe)paramView.getTag();
      ReportController.a(this.a.app, "CliOper", "", "", "0X8004447", "0X8004447", 0, 0, "", "", "", "");
      VisitorsActivity.b(this.a, (CardProfile)paramView.a);
    }
    while (!(paramView.getTag() instanceof nbf)) {
      return;
    }
    this.a.c();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\nbd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */