import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qih
  implements Runnable
{
  public qih(ActivateFriendsManager paramActivateFriendsManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ActivateFriendsManager.a(this.a).notifyObservers(ActivateFriendsObserver.class, 115, true, null);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qih.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */