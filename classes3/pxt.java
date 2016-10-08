import com.tencent.mobileqq.app.FriendAnniverManager;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class pxt
  implements Runnable
{
  public pxt(FriendAnniverManager paramFriendAnniverManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ((FriendListHandler)FriendAnniverManager.a(this.a).a(1)).e();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pxt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */