import com.tencent.mobileqq.activity.AuthDevRenameActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class klm
  implements Runnable
{
  public klm(AuthDevRenameActivity paramAuthDevRenameActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      if ((AuthDevRenameActivity.a(this.a) == null) && (!this.a.isFinishing())) {
        AuthDevRenameActivity.a(this.a, new QQProgressDialog(this.a, this.a.getTitleBarHeight()));
      }
      if ((AuthDevRenameActivity.a(this.a) != null) && (!AuthDevRenameActivity.a(this.a).isShowing()))
      {
        AuthDevRenameActivity.a(this.a).a(this.a.getString(2131370766));
        AuthDevRenameActivity.a(this.a).show();
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


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\klm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */