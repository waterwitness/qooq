import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.CountDownProgressBar;
import com.tencent.widget.CountDownProgressBar.OnCountDownLinstener;

public class xsv
  extends Handler
{
  public xsv(CountDownProgressBar paramCountDownProgressBar)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      CountDownProgressBar.a(this.a, CountDownProgressBar.a(this.a));
      CountDownProgressBar.a(this.a).sendEmptyMessageDelayed(1, CountDownProgressBar.a(this.a));
      return;
      CountDownProgressBar.a(this.a, CountDownProgressBar.a(this.a));
      if (CountDownProgressBar.a(this.a) <= (float)CountDownProgressBar.a(this.a)) {
        break;
      }
      CountDownProgressBar.a(this.a, (int)(CountDownProgressBar.a(this.a) / (float)CountDownProgressBar.a(this.a) * 360.0F));
      this.a.invalidate();
    } while (CountDownProgressBar.a(this.a) == null);
    CountDownProgressBar.a(this.a).a();
    return;
    CountDownProgressBar.a(this.a, (int)(CountDownProgressBar.a(this.a) / (float)CountDownProgressBar.a(this.a) * 360.0F));
    if (CountDownProgressBar.b(this.a) >= (float)CountDownProgressBar.b(this.a))
    {
      CountDownProgressBar.b(this.a, 0.0F);
      CountDownProgressBar.b(this.a, 1);
    }
    for (;;)
    {
      this.a.invalidate();
      CountDownProgressBar.a(this.a).sendEmptyMessageDelayed(1, CountDownProgressBar.a(this.a));
      return;
      CountDownProgressBar.c(this.a, CountDownProgressBar.a(this.a));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xsv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */