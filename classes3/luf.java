import com.tencent.mobileqq.activity.LoginVerifyCodeActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class luf
  implements Runnable
{
  public luf(LoginVerifyCodeActivity paramLoginVerifyCodeActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      if ((LoginVerifyCodeActivity.a(this.a) != null) && (LoginVerifyCodeActivity.a(this.a).isShowing()))
      {
        LoginVerifyCodeActivity.a(this.a).dismiss();
        LoginVerifyCodeActivity.a(this.a).cancel();
      }
      LoginVerifyCodeActivity.a(this.a, null);
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


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\luf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */