import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.ProfileCardInfo;

class llq
  implements Runnable
{
  llq(llp paramllp)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ((FriendsManager)this.a.a.app.getManager(50)).a(this.a.a.a.a);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\llq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */