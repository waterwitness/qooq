import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.jumplightalk.AIOJumpLightalkConfig;
import com.tencent.mobileqq.utils.SharedPreUtils;
import mqq.os.MqqHandler;

public class nya
  implements Runnable
{
  public nya(FriendChatPie paramFriendChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    FriendChatPie.a(this.a, AIOJumpLightalkConfig.a(this.a.a.a()));
    if (FriendChatPie.a(this.a) != null)
    {
      FriendChatPie.a(this.a, SharedPreUtils.c(this.a.a.a()).getBoolean("aio_jump_lightalk_red_dot", false));
      Message localMessage = FriendChatPie.c(this.a).obtainMessage(42);
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("showRedDot", FriendChatPie.a(this.a));
      localMessage.setData(localBundle);
      FriendChatPie.d(this.a).sendMessage(localMessage);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nya.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */