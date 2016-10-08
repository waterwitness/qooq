import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ocd
  extends BroadcastReceiver
{
  private ocd(PublicAccountChatPie paramPublicAccountChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS")) {
      PublicAccountChatPie.a(this.a, 1);
    }
    while (!paramContext.equals("android.intent.action.SCREEN_OFF")) {
      return;
    }
    PublicAccountChatPie.a(this.a, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ocd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */