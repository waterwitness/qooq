import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class kyc
  extends MessageObserver
{
  public kyc(ChatSettingActivity paramChatSettingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void b(boolean paramBoolean, String paramString)
  {
    if (!ChatSettingActivity.b(this.a)) {
      return;
    }
    ChatSettingActivity.c(this.a, false);
    ChatSettingActivity.d(this.a);
    if (paramBoolean)
    {
      if ((paramString != null) && (paramString.equals(ChatSettingActivity.c(this.a)))) {
        ChatSettingActivity.b(this.a, true);
      }
      ChatSettingActivity.b(this.a);
      return;
    }
    ChatSettingActivity.a(this.a, 2131368703, 1);
  }
  
  protected void c(boolean paramBoolean, String paramString)
  {
    if (!ChatSettingActivity.b(this.a)) {
      return;
    }
    ChatSettingActivity.c(this.a, false);
    ChatSettingActivity.d(this.a);
    if (paramBoolean)
    {
      if ((paramString != null) && (paramString.equals(ChatSettingActivity.c(this.a)))) {
        ChatSettingActivity.b(this.a, false);
      }
      ChatSettingActivity.b(this.a);
      return;
    }
    ChatSettingActivity.a(this.a, 2131368703, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kyc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */