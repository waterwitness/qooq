import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.os.MqqMessageQueue;
import mqq.util.AbstractUnifiedMonitor.ThreadMonitorCallback;

public final class pzn
  implements AbstractUnifiedMonitor.ThreadMonitorCallback
{
  public pzn()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onThreadMonitorEnd(int paramInt)
  {
    if (paramInt == 0)
    {
      Looper.getMainLooper().setMessageLogging(null);
      MqqMessageQueue.getSubMainThreadQueue().setMessageLogging(null);
    }
    do
    {
      return;
      if (paramInt == 4)
      {
        ThreadManager.b().setMessageLogging(null);
        return;
      }
      if (paramInt == 5)
      {
        ThreadManager.a().setMessageLogging(null);
        return;
      }
    } while (paramInt != 14);
    Looper.getMainLooper().setMessageLogging(null);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\pzn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */