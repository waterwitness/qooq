import java.util.concurrent.ThreadFactory;

public final class uub
  implements ThreadFactory
{
  public Thread newThread(Runnable paramRunnable)
  {
    return new Thread(paramRunnable, "RDM-Service");
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\uub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */