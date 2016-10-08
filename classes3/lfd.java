import com.tencent.mobileqq.activity.DevlockPushActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class lfd
  implements Runnable
{
  public lfd(DevlockPushActivity paramDevlockPushActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      if ((DevlockPushActivity.a(this.a) != null) && (DevlockPushActivity.a(this.a).isShowing()))
      {
        DevlockPushActivity.a(this.a).dismiss();
        DevlockPushActivity.a(this.a).cancel();
      }
      DevlockPushActivity.a(this.a, null);
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


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lfd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */