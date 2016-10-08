import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.BaseApplication;

public class kjz
  implements CompoundButton.OnCheckedChangeListener
{
  public kjz(AssistantSettingActivity paramAssistantSettingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (AppSetting.j) {
      this.a.b.setContentDescription("加入寻找丢失儿童项目");
    }
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      SettingCloneUtil.writeValueForInt(BaseApplication.getContext(), this.a.app.a(), null, "qqsetting_antilost_key", i);
      AssistantSettingActivity.a(this.a, paramBoolean);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kjz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */