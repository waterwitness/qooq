import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class llw
  implements Runnable
{
  public llw(FriendProfileCardActivity paramFriendProfileCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ThreadManager.a(new llx(this), 5, null, true);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\llw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */