import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vas.ClubContentJsonTask;

public class lld
  implements Runnable
{
  public lld(FriendProfileCardActivity paramFriendProfileCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ClubContentJsonTask.b(this.a.app);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lld.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */