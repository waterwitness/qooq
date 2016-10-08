import com.tencent.mobileqq.activity.DevlockPushActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class lfc
  implements Runnable
{
  public lfc(DevlockPushActivity paramDevlockPushActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      if ((DevlockPushActivity.a(this.a) == null) && (!this.a.isFinishing()))
      {
        DevlockPushActivity.a(this.a, new QQProgressDialog(this.a, this.a.getTitleBarHeight()));
        DevlockPushActivity.a(this.a).b(2131369268);
      }
      if ((DevlockPushActivity.a(this.a) != null) && (!DevlockPushActivity.a(this.a).isShowing())) {
        DevlockPushActivity.a(this.a).show();
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


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lfc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */