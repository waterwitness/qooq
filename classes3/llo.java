import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class llo
  implements Runnable
{
  public llo(FriendProfileCardActivity paramFriendProfileCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    FriendProfileCardActivity.a(this.a.app, this.a.a);
    FriendProfileCardActivity.a(this.a.a);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\llo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */