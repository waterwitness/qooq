import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ProfileCardMessageProcessor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qmc
  implements Runnable
{
  public qmc(ProfileCardMessageProcessor paramProfileCardMessageProcessor)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.a.a.getAccount())) {
      ((FriendListHandler)this.a.a.a(1)).b(this.a.a.getAccount());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qmc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */