import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.profile.ProfileCardInfo;

public class lkp
  implements Runnable
{
  public lkp(FriendProfileCardActivity paramFriendProfileCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.a.a.a == 0) {
      ((LocalRedTouchManager)this.a.app.getManager(159)).a(true);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lkp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */