import android.os.Handler;
import android.os.Looper;
import com.dataline.util.DLRouterSessionInfoRequestTask;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.TimerTask;

public class cq
  extends TimerTask
{
  public cq(DLRouterSessionInfoRequestTask paramDLRouterSessionInfoRequestTask, int paramInt, long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    new Handler(Looper.getMainLooper()).post(new cr(this));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */