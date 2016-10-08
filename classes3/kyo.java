import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ShieldListObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import java.util.List;

public class kyo
  extends ShieldListObserver
{
  public kyo(ChatSettingActivity paramChatSettingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, List paramList)
  {
    if (!ChatSettingActivity.b(this.a)) {}
    do
    {
      return;
      ChatSettingActivity.c(this.a, false);
      ChatSettingActivity.d(this.a);
    } while (!paramBoolean);
    paramList = (ShieldMsgManger)this.a.app.getManager(15);
    if ((paramList != null) && (!TextUtils.isEmpty(ChatSettingActivity.c(this.a)))) {
      ChatSettingActivity.b(this.a, paramList.a(ChatSettingActivity.c(this.a)));
    }
    ChatSettingActivity.b(this.a);
  }
  
  protected void b(boolean paramBoolean, List paramList)
  {
    if (!ChatSettingActivity.b(this.a)) {
      return;
    }
    ChatSettingActivity.c(this.a, false);
    ChatSettingActivity.d(this.a);
    if (paramBoolean)
    {
      paramList = (ShieldMsgManger)this.a.app.getManager(15);
      if ((paramList != null) && (!TextUtils.isEmpty(ChatSettingActivity.c(this.a)))) {
        ChatSettingActivity.b(this.a, paramList.a(ChatSettingActivity.c(this.a)));
      }
      ChatSettingActivity.b(this.a);
      return;
    }
    ChatSettingActivity.a(this.a, 2131368704, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kyo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */