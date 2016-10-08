import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.utils.ContactUtils;
import mqq.os.MqqHandler;

public class kyl
  extends MqqHandler
{
  public kyl(ChatSettingActivity paramChatSettingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 18: 
    case 16711681: 
      do
      {
        do
        {
          return;
          paramMessage = (String)paramMessage.obj;
          ChatSettingActivity.a(this.a, paramMessage);
          return;
        } while (ChatSettingActivity.a(this.a) != 0);
        paramMessage = (String)paramMessage.obj;
      } while ((ChatSettingActivity.a(this.a) == null) || (paramMessage == null) || (!ChatSettingActivity.a(this.a).equals(paramMessage)));
      this.a.finish();
      return;
    case 32: 
      if (ChatSettingActivity.a(this.a) != 1001) {
        if (ChatSettingActivity.a(this.a) == 1006)
        {
          if (TextUtils.isEmpty(ChatSettingActivity.b(this.a))) {
            ChatSettingActivity.a(this.a, false);
          }
        }
        else
        {
          paramMessage = (ShieldMsgManger)this.a.app.getManager(15);
          if ((paramMessage != null) && (!TextUtils.isEmpty(ChatSettingActivity.c(this.a)))) {
            ChatSettingActivity.b(this.a, paramMessage.a(ChatSettingActivity.c(this.a)));
          }
        }
      }
      for (;;)
      {
        ChatSettingActivity.b(this.a);
        return;
        paramMessage = ContactUtils.f(this.a.app, ChatSettingActivity.b(this.a));
        if (TextUtils.isEmpty(paramMessage))
        {
          ChatSettingActivity.a(this.a, false);
          break;
        }
        ChatSettingActivity.a(this.a, true);
        ChatSettingActivity.a(this.a, paramMessage);
        break;
        paramMessage = (FriendsManager)this.a.app.getManager(50);
        if (paramMessage != null)
        {
          paramMessage = paramMessage.c(ChatSettingActivity.c(this.a));
          if ((paramMessage != null) && (paramMessage.groupid == 64534)) {
            ChatSettingActivity.b(this.a, true);
          } else {
            ChatSettingActivity.b(this.a, false);
          }
        }
      }
    }
    ChatSettingActivity.c(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kyl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */