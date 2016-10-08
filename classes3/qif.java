import android.content.SharedPreferences;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendServlet;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class qif
  implements Runnable
{
  public qif(ActivateFriendsManager paramActivateFriendsManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    long l = ActivateFriendsManager.a(this.a).getLong("key_last_birth_msg_stamp", 0L);
    if (QLog.isColorLevel()) {
      QLog.d("ActivateFriends.Manager", 2, "local birth timestamp = " + l);
    }
    if (MessageCache.a() - l > 259200L)
    {
      ThreadManager.b().removeCallbacks(ActivateFriendsManager.a(this.a));
      this.a.d = ActivateFriendsManager.b(this.a);
      ActivateFriendServlet.a(ActivateFriendsManager.a(this.a), false);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qif.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */