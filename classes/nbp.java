import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class nbp
  extends ActivateFriendsObserver
{
  public nbp(ActivateFriendActivity paramActivateFriendActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ActivateFriends.MainActivity", 2, "onReceiveBirthDayPushUpdate");
    }
    ActivateFriendActivity.b(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nbp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */