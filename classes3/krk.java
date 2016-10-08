import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.Call;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class krk
  implements View.OnClickListener
{
  public krk(Call paramCall)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    ReportController.b(null, "CliOper", "", "", "0X800551F", "0X800551F", 0, 0, "", "", "", "");
    Call.a(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\krk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */