import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.InfiniteTaskThreadPool;
import java.util.concurrent.ThreadFactory;

public class vyt
  implements ThreadFactory
{
  public vyt()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Thread newThread(Runnable paramRunnable)
  {
    InfiniteTaskThreadPool.a();
    paramRunnable = new Thread(paramRunnable, "InfiniteTaskThread_" + InfiniteTaskThreadPool.b());
    paramRunnable.setDaemon(true);
    return paramRunnable;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vyt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */