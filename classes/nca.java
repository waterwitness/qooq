import com.tencent.mobileqq.activity.activateFriend.SendBirthdayWishesActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class nca
  implements Runnable
{
  public nca(SendBirthdayWishesActivity paramSendBirthdayWishesActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (!this.a.isFinishing())
    {
      this.a.setResult(-1);
      this.a.finish();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */