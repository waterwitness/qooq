import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.automator.step.CheckFriendsLastLoginInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qis
  extends FriendListObserver
{
  private qis(CheckFriendsLastLoginInfo paramCheckFriendsLastLoginInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 0;
    if (!paramBoolean1) {
      this.a.a(6);
    }
    for (;;)
    {
      if (i != 0) {
        this.a.a(7);
      }
      return;
      if (paramBoolean2) {
        i = 1;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qis.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */