import com.tencent.mobileqq.activity.AuthDevRenameActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class kln
  implements Runnable
{
  public kln(AuthDevRenameActivity paramAuthDevRenameActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      if ((AuthDevRenameActivity.a(this.a) != null) && (AuthDevRenameActivity.a(this.a).isShowing()))
      {
        AuthDevRenameActivity.a(this.a).dismiss();
        AuthDevRenameActivity.a(this.a).cancel();
      }
      AuthDevRenameActivity.a(this.a, null);
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


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kln.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */