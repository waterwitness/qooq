import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class umf
  implements ThreadFactory
{
  private final AtomicInteger a;
  
  public umf()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new AtomicInteger(1);
  }
  
  public Thread newThread(Runnable paramRunnable)
  {
    return new Thread(paramRunnable, "SearchTask #" + this.a.getAndIncrement());
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\umf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */