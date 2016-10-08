import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.HongbaoShowerActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class los
  implements View.OnClickListener
{
  public los(HongbaoShowerActivity paramHongbaoShowerActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (System.currentTimeMillis() - this.a.a < 2000L) {
      return;
    }
    this.a.finish();
    this.a.overridePendingTransition(0, 0);
    QQAppInterface localQQAppInterface = this.a.app;
    if (HongbaoShowerActivity.a(this.a) == 0) {}
    for (paramView = "1";; paramView = "2")
    {
      ReportController.b(localQQAppInterface, "CliOper", "", "", "0X80060A4", "0X80060A4", 0, 0, paramView, "", "", "");
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\los.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */