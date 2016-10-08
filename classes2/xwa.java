import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.wstt.SSCM.SSCMTimer;
import com.tencent.wstt.SSCM.SSCMTimer.SSCMTimerObserver;
import com.tencent.wstt.SSCM.Utils;
import java.util.TimerTask;

public class xwa
  extends TimerTask
{
  public xwa(SSCMTimer paramSSCMTimer)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    long l;
    int i;
    if (SSCMTimer.a(this.a))
    {
      l = Long.parseLong(Utils.a());
      if (l == -1L)
      {
        SSCMTimer.a(this.a, false);
        i = 0;
      }
    }
    for (;;)
    {
      if (i > 0) {
        SSCMTimer.a(this.a, 0);
      }
      do
      {
        do
        {
          return;
          i = (int)(l - SSCMTimer.a(this.a));
          SSCMTimer.a(this.a, l);
          break;
          SSCMTimer.b(this.a, SSCMTimer.a(this.a));
        } while (SSCMTimer.b(this.a) < 120000);
        SSCMTimer.c(this.a, 1);
        cancel();
      } while (SSCMTimer.a(this.a) == null);
      SSCMTimer.a(this.a).b(SSCMTimer.a(this.a));
      return;
      i = 0;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xwa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */