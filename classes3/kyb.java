import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class kyb
  implements CompoundButton.OnCheckedChangeListener
{
  public kyb(ChatSettingActivity paramChatSettingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (ChatSettingActivity.a(this.a) == paramBoolean) {
      return;
    }
    if (paramBoolean) {
      ReportController.b(this.a.app, "CliOper", "", "", "0X80040EE", "0X80040EE", 0, 0, "2", "1", "", "");
    }
    for (;;)
    {
      ChatSettingActivity.a(this.a);
      return;
      ReportController.b(this.a.app, "CliOper", "", "", "0X80040EE", "0X80040EE", 0, 0, "2", "0", "", "");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kyb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */