import com.tencent.mobileqq.activity.AuthDevVerifyCodeActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class klt
  implements Runnable
{
  public klt(AuthDevVerifyCodeActivity paramAuthDevVerifyCodeActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      if ((AuthDevVerifyCodeActivity.a(this.a) == null) && (!this.a.isFinishing()))
      {
        AuthDevVerifyCodeActivity.a(this.a, new QQProgressDialog(this.a.getActivity(), this.a.getTitleBarHeight()));
        AuthDevVerifyCodeActivity.a(this.a).b(2131369268);
        AuthDevVerifyCodeActivity.a(this.a).d(true);
      }
      if ((AuthDevVerifyCodeActivity.a(this.a) != null) && (!AuthDevVerifyCodeActivity.a(this.a).isShowing())) {
        AuthDevVerifyCodeActivity.a(this.a).show();
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


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\klt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */