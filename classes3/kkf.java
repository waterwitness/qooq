import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.olympic.activity.OlympicSettingActivity;

public class kkf
  implements View.OnClickListener
{
  public kkf(AssistantSettingActivity paramAssistantSettingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, OlympicSettingActivity.class);
    paramView.putExtra("fromWhere", 1);
    this.a.startActivity(paramView);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kkf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */