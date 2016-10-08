import com.tencent.mobileqq.activity.VerifyPhoneNumActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class nap
  implements Runnable
{
  public nap(VerifyPhoneNumActivity paramVerifyPhoneNumActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      if ((VerifyPhoneNumActivity.a(this.a) == null) && (!this.a.isFinishing()))
      {
        VerifyPhoneNumActivity.a(this.a, new QQProgressDialog(this.a.getActivity(), this.a.getTitleBarHeight()));
        VerifyPhoneNumActivity.a(this.a).b(2131369268);
      }
      if ((VerifyPhoneNumActivity.a(this.a) != null) && (!VerifyPhoneNumActivity.a(this.a).isShowing())) {
        VerifyPhoneNumActivity.a(this.a).show();
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


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\nap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */