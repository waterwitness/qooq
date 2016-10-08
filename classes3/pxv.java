import com.tencent.mobileqq.activity.contact.OnlineStatusIconHelper;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class pxv
  implements Runnable
{
  public pxv(FriendListHandler paramFriendListHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    OnlineStatusIconHelper.a();
    this.a.d();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pxv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */