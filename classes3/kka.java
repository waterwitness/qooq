import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class kka
  implements CompoundButton.OnCheckedChangeListener
{
  public kka(AssistantSettingActivity paramAssistantSettingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton = this.a.app;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      ReportController.b(paramCompoundButton, "CliOper", "", "", "Setting_tab", "Download_new", 0, i, "", "", "", "");
      ConfigHandler.b(this.a.app, paramBoolean);
      if (!paramBoolean) {
        break;
      }
      UpgradeController.a().a();
      return;
    }
    UpgradeController.a().b();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kka.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */