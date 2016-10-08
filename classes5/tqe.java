import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class tqe
  extends ThreadPoolExecutor
{
  public tqe(int paramInt1, int paramInt2, long paramLong, TimeUnit paramTimeUnit, BlockingQueue paramBlockingQueue)
  {
    super(paramInt1, paramInt2, paramLong, paramTimeUnit, paramBlockingQueue);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Future submit(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      throw new NullPointerException();
    }
    paramRunnable = new tqf((tqg)paramRunnable);
    execute(paramRunnable);
    return paramRunnable;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tqe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */