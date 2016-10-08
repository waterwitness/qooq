import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.biz.now.NowLiveManager;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class kkl
  implements CompoundButton.OnCheckedChangeListener
{
  public kkl(AssistantSettingActivity paramAssistantSettingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int j = 1;
    if (!paramCompoundButton.isPressed()) {
      return;
    }
    if (AppSetting.j) {
      this.a.l.setContentDescription("在底部标签栏展示通话功能");
    }
    MainFragment.a(paramBoolean, this.a.app.a().g);
    if (paramBoolean)
    {
      ReportController.b(this.a.app, "CliOper", "", "", "0X8004EDD", "0X8004EDD", 0, 0, "", "", "", "");
      label80:
      ((CardHandler)this.a.app.a(2)).b(paramBoolean, true);
      paramCompoundButton = new Integer[7];
      paramCompoundButton[0] = Integer.valueOf(1);
      if (!paramBoolean) {
        break label199;
      }
      i = 1;
      label118:
      paramCompoundButton[3] = Integer.valueOf(i);
      if (!paramBoolean) {
        break label204;
      }
    }
    label199:
    label204:
    for (int i = j;; i = 0)
    {
      paramCompoundButton[4] = Integer.valueOf(i);
      this.a.app.a(paramCompoundButton);
      if (!paramBoolean) {
        break;
      }
      this.a.m.setChecked(false);
      return;
      ReportController.b(this.a.app, "CliOper", "", "", "0X8004EDC", "0X8004EDC", 0, 0, "", "", "", "");
      break label80;
      i = 0;
      break label118;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kkl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */