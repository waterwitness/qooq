import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.step.LoginWelcomeRequest;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeManager;

public class qjs
  implements Runnable
{
  public qjs(LoginWelcomeRequest paramLoginWelcomeRequest)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    LoginWelcomeManager.a(LoginWelcomeRequest.a(this.a).b).a();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qjs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */