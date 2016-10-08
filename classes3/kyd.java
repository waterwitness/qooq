import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.QQUtils;

public class kyd
  implements Runnable
{
  public kyd(ChatSettingActivity paramChatSettingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QQUtils.a(this.a.app, ChatSettingActivity.a(this.a), ChatSettingActivity.f(this.a), this.a.getTitleBarHeight(), this.a.a, 500, "0", ChatSettingActivity.a(this.a));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kyd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */