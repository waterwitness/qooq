import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.bless.BlessActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class ofh
  implements View.OnClickListener
{
  public ofh(BlessActivity paramBlessActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    ReportController.b(this.a.app, "CliOper", "", "", "0X800632F", "0X800632F", 0, 0, "", "", "", "");
    BlessActivity.a(this.a, true);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ofh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */