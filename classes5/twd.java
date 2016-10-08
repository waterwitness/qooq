import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.view.CircularProgressBar;

public class twd
  extends Handler
{
  public twd(CircularProgressBar paramCircularProgressBar)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    this.a.invalidate();
    if (CircularProgressBar.a(this.a))
    {
      CircularProgressBar.a(this.a, CircularProgressBar.a(this.a));
      if (CircularProgressBar.b(this.a) > 360) {
        CircularProgressBar.b(this.a, 0);
      }
      CircularProgressBar.a(this.a).sendEmptyMessageDelayed(0, CircularProgressBar.c(this.a));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\twd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */