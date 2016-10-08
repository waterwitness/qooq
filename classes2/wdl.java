import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.concurrent.ThreadFactory;

class wdl
  implements ThreadFactory
{
  wdl()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Thread newThread(Runnable paramRunnable)
  {
    wdk.a();
    paramRunnable = new Thread(paramRunnable, "InfiniteTaskThread_" + wdk.b());
    paramRunnable.setDaemon(true);
    return paramRunnable;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wdl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */