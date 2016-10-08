import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie;
import com.tencent.mobileqq.activity.aio.tips.GatherContactsTips;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class nxw
  implements Runnable
{
  public nxw(FriendChatPie paramFriendChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (FriendChatPie.a(this.a) != null)
    {
      FriendChatPie.a(this.a).b(1);
      FriendChatPie.a(this.a).b(2);
      FriendChatPie.a(this.a, null);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nxw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */