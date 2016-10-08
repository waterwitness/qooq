import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.SharedPreUtils;
import mqq.os.MqqHandler;

class nxz
  implements Runnable
{
  nxz(nxy paramnxy)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Message localMessage = FriendChatPie.a(this.a.a).obtainMessage(42);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("showRedDot", false);
    localMessage.setData(localBundle);
    FriendChatPie.b(this.a.a).sendMessage(localMessage);
    SharedPreUtils.c(this.a.a.a.a()).edit().putBoolean("aio_jump_lightalk_red_dot", false).commit();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nxz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */