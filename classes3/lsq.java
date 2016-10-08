import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lsq
  implements Runnable
{
  public lsq(LoginActivity paramLoginActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    LoginActivity.a(this.a.app, this.a.app.getAccount());
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lsq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */