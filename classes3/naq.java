import com.tencent.mobileqq.activity.VerifyPhoneNumActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class naq
  implements Runnable
{
  public naq(VerifyPhoneNumActivity paramVerifyPhoneNumActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      if ((VerifyPhoneNumActivity.a(this.a) != null) && (VerifyPhoneNumActivity.a(this.a).isShowing()))
      {
        VerifyPhoneNumActivity.a(this.a).dismiss();
        VerifyPhoneNumActivity.a(this.a).cancel();
      }
      VerifyPhoneNumActivity.a(this.a, null);
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


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\naq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */