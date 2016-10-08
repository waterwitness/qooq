import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class umg
  extends ThreadPoolExecutor
{
  public umg(int paramInt1, int paramInt2, long paramLong, TimeUnit paramTimeUnit, BlockingQueue paramBlockingQueue, ThreadFactory paramThreadFactory)
  {
    super(paramInt1, paramInt2, paramLong, paramTimeUnit, paramBlockingQueue, paramThreadFactory);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void afterExecute(Runnable paramRunnable, Throwable paramThrowable)
  {
    if ((paramRunnable instanceof FutureTask)) {}
    try
    {
      ((FutureTask)paramRunnable).get();
      return;
    }
    catch (ExecutionException paramRunnable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("GroupSearchEngine", 2, "Exception happened", paramRunnable);
      return;
    }
    catch (Error paramRunnable) {}catch (Exception paramRunnable) {}
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\umg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */