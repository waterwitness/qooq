import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.activity.TrafficStatActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class kkh
  implements View.OnClickListener
{
  public kkh(AssistantSettingActivity paramAssistantSettingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, TrafficStatActivity.class);
    this.a.startActivity(paramView);
    ReportController.b(this.a.app, "CliOper", "", "", "Setting_tab", "Clk_traffic_statistics", 0, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kkh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */