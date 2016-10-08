import android.util.Log;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.lyric.common.TimerTaskManager;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class szi
  extends ScheduledThreadPoolExecutor
{
  public szi(TimerTaskManager paramTimerTaskManager, int paramInt)
  {
    super(paramInt);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void afterExecute(Runnable paramRunnable, Throwable paramThrowable)
  {
    super.afterExecute(paramRunnable, paramThrowable);
    Throwable localThrowable1 = paramThrowable;
    if (paramThrowable == null)
    {
      localThrowable1 = paramThrowable;
      if (!(paramRunnable instanceof Future)) {}
    }
    try
    {
      paramRunnable = (Future)paramRunnable;
      localThrowable1 = paramThrowable;
      if (paramRunnable.isDone())
      {
        paramRunnable.get();
        localThrowable1 = paramThrowable;
      }
    }
    catch (CancellationException localCancellationException)
    {
      for (;;) {}
    }
    catch (ExecutionException paramRunnable)
    {
      for (;;)
      {
        localThrowable2 = paramRunnable.getCause();
      }
    }
    catch (InterruptedException paramRunnable)
    {
      for (;;)
      {
        Throwable localThrowable2 = paramThrowable;
      }
    }
    if (localThrowable1 != null) {
      Log.e("LyricTimerTaskManager", "Exception happen when execute task! : " + localThrowable1.toString());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\szi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */