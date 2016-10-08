import android.os.Handler;
import android.os.Looper;
import com.dataline.util.DLRouterSessionInfoRequestTask;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.TimerTask;

public class cs
  extends TimerTask
{
  public cs(DLRouterSessionInfoRequestTask paramDLRouterSessionInfoRequestTask)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread()) {
      new Handler(localLooper).post(new ct(this));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */