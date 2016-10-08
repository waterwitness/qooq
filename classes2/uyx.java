import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.testassister.activity.ShareAppLogActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class uyx
  implements Runnable
{
  public uyx(ShareAppLogActivity paramShareAppLogActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      if ((ShareAppLogActivity.a(this.a) != null) && (ShareAppLogActivity.a(this.a).isShowing()) && (!this.a.isFinishing()))
      {
        ShareAppLogActivity.a(this.a).dismiss();
        ShareAppLogActivity.a(this.a).cancel();
      }
      ShareAppLogActivity.a(this.a, null);
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


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uyx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */