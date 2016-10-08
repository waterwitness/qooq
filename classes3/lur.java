import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class lur
  implements Runnable
{
  public lur(MainFragment paramMainFragment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SpecialCare", 2, "getSpecialRecommendStat=" + FriendListHandler.ca);
    }
    if ((FriendListHandler.ca == 0) || (FriendListHandler.ca == 2) || (FriendListHandler.ca == 3)) {}
    do
    {
      do
      {
        return;
        if (!MainFragment.a(this.a)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("SpecialCare", 2, "hasSpecialCareFriend=" + MainFragment.a(this.a));
      return;
    } while (MainFragment.a(this.a) == null);
    List localList = ((FriendsManager)MainFragment.a(this.a).getManager(50)).b();
    if ((localList != null) && (localList.size() > 0))
    {
      MainFragment.b(this.a, true);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SpecialCare", 2, "hasSpecialCareFriend=" + MainFragment.a(this.a));
    }
    ((FriendListHandler)MainFragment.a(this.a).a(1)).a(0, 10, null, true, true);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lur.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */