import com.tencent.mobileqq.activity.LoginVerifyCodeActivity2;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class luk
  implements Runnable
{
  public luk(LoginVerifyCodeActivity2 paramLoginVerifyCodeActivity2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      if ((LoginVerifyCodeActivity2.a(this.a) == null) && (!this.a.isFinishing()))
      {
        LoginVerifyCodeActivity2.a(this.a, new QQProgressDialog(this.a.getActivity(), this.a.getTitleBarHeight()));
        LoginVerifyCodeActivity2.a(this.a).b(2131369268);
      }
      if ((LoginVerifyCodeActivity2.a(this.a) != null) && (!LoginVerifyCodeActivity2.a(this.a).isShowing())) {
        LoginVerifyCodeActivity2.a(this.a).show();
      }
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


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\luk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */