import com.tencent.mobileqq.activity.AuthDevVerifyCodeActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class klu
  implements Runnable
{
  public klu(AuthDevVerifyCodeActivity paramAuthDevVerifyCodeActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      if ((AuthDevVerifyCodeActivity.a(this.a) != null) && (AuthDevVerifyCodeActivity.a(this.a).isShowing()))
      {
        AuthDevVerifyCodeActivity.a(this.a).dismiss();
        AuthDevVerifyCodeActivity.a(this.a).cancel();
      }
      AuthDevVerifyCodeActivity.a(this.a, null);
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


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\klu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */