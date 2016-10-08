import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.biz.now.NowLiveManager;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class kkc
  implements CompoundButton.OnCheckedChangeListener
{
  public kkc(AssistantSettingActivity paramAssistantSettingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int j = 1;
    if (!paramCompoundButton.isPressed()) {
      return;
    }
    if (paramBoolean)
    {
      paramCompoundButton = "open_storyset";
      label18:
      StoryReportor.a("dynamic_more", paramCompoundButton, 0, 0, new String[0]);
      paramCompoundButton = new Integer[5];
      paramCompoundButton[0] = Integer.valueOf(1);
      if (!paramBoolean) {
        break label121;
      }
    }
    label121:
    for (int i = 1;; i = 0)
    {
      paramCompoundButton[3] = Integer.valueOf(i);
      this.a.app.a().a(paramCompoundButton);
      paramCompoundButton = (QQStoryHandler)this.a.app.a(98);
      i = j;
      if (paramBoolean) {
        i = 2;
      }
      paramCompoundButton.a(i);
      if (!paramBoolean) {
        break;
      }
      this.a.l.setChecked(false);
      return;
      paramCompoundButton = "close_storyset";
      break label18;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kkc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */