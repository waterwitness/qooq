import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class pyd
  implements Runnable
{
  public pyd(FriendsManager paramFriendsManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    FriendsManager.a(this.a);
    ((FriendListHandler)FriendsManager.a(this.a).a(1)).a(103, true, null);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pyd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */