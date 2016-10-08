import com.tencent.mobileqq.activity.LoginVerifyCodeActivity2;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class lul
  implements Runnable
{
  public lul(LoginVerifyCodeActivity2 paramLoginVerifyCodeActivity2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      if ((LoginVerifyCodeActivity2.a(this.a) != null) && (LoginVerifyCodeActivity2.a(this.a).isShowing()))
      {
        LoginVerifyCodeActivity2.a(this.a).dismiss();
        LoginVerifyCodeActivity2.a(this.a).cancel();
      }
      LoginVerifyCodeActivity2.a(this.a, null);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lul.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */