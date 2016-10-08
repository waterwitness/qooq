import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.concurrent.ThreadFactory;

public final class quh
  implements ThreadFactory
{
  public quh()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Thread newThread(Runnable paramRunnable)
  {
    paramRunnable = new Thread("Bubble_Animation");
    if (paramRunnable.isDaemon()) {
      paramRunnable.setDaemon(false);
    }
    if (paramRunnable.getPriority() != 5) {
      paramRunnable.setPriority(5);
    }
    return paramRunnable;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\quh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */