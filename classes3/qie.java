import com.tencent.mobileqq.app.activateFriends.ActivateFriendServlet;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class qie
  implements Runnable
{
  public qie(ActivateFriendsManager paramActivateFriendsManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ActivateFriends.Manager", 2, "checkRunnable | lastCheckTime = " + ActivateFriendsManager.a(this.a) + " | timeInterval = " + Math.abs(System.currentTimeMillis() - ActivateFriendsManager.a(this.a)) + " | checkInterval = " + ActivateFriendsManager.b(this.a));
    }
    if (Math.abs(System.currentTimeMillis() - ActivateFriendsManager.a(this.a)) <= ActivateFriendsManager.b(this.a)) {
      return;
    }
    ActivateFriendServlet.a(ActivateFriendsManager.a(this.a));
    this.a.d = ActivateFriendsManager.a(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */