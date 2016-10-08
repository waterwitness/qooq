import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.util.BadgeUtils;

public class lyd
  implements CompoundButton.OnCheckedChangeListener
{
  public lyd(NotifyPushSettingActivity paramNotifyPushSettingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface;
    if (paramBoolean)
    {
      BadgeUtils.a();
      localQQAppInterface = this.a.app;
      if (!paramBoolean) {
        break label78;
      }
      paramCompoundButton = "0X8004BE7";
      label23:
      if (!paramBoolean) {
        break label84;
      }
    }
    label78:
    label84:
    for (String str = "0X8004BE7";; str = "0X8004BE6")
    {
      ReportController.b(localQQAppInterface, "CliOper", "", "", paramCompoundButton, str, 0, 1, "1", "", "", "");
      if (AppSetting.j) {
        NotifyPushSettingActivity.d(this.a).setContentDescription("桌面图标显示未读消息数开关按钮");
      }
      return;
      BadgeUtils.b();
      break;
      paramCompoundButton = "0X8004BE6";
      break label23;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lyd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */