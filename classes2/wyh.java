import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qidian.QidianProfileCardActivity;

public class wyh
  implements Runnable
{
  public wyh(QidianProfileCardActivity paramQidianProfileCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    FriendProfileCardActivity.a(this.a.app, this.a.a);
    FriendProfileCardActivity.a(this.a.a);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wyh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */