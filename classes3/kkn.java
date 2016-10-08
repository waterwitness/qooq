import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.settings.QQStoryBasicSettingsActivity;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class kkn
  implements View.OnClickListener
{
  public kkn(AssistantSettingActivity paramAssistantSettingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, QQStoryBasicSettingsActivity.class);
    this.a.startActivity(paramView);
    ReportController.b(null, "dc00899", "grp_story", "", "browse_friend_settings", "clk_set", 0, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kkn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */