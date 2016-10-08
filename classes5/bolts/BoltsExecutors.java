package bolts;

import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

final class BoltsExecutors
{
  private static final BoltsExecutors INSTANCE = new BoltsExecutors();
  private final ExecutorService background;
  private final Executor immediate;
  
  private BoltsExecutors()
  {
    if (!isAndroidRuntime()) {}
    for (ExecutorService localExecutorService = Executors.newCachedThreadPool();; localExecutorService = AndroidExecutors.newCachedThreadPool())
    {
      this.background = localExecutorService;
      this.immediate = new ImmediateExecutor(null);
      return;
    }
  }
  
  public static ExecutorService background()
  {
    return INSTANCE.background;
  }
  
  static Executor immediate()
  {
    return INSTANCE.immediate;
  }
  
  private static boolean isAndroidRuntime()
  {
    String str = System.getProperty("java.runtime.name");
    if (str == null) {
      return false;
    }
    return str.toLowerCase(Locale.US).contains("android");
  }
  
  private static class ImmediateExecutor
    implements Executor
  {
    private static final int MAX_DEPTH = 15;
    private ThreadLocal<Integer> executionDepth = new ThreadLocal();
    
    private int decrementDepth()
    {
      Integer localInteger2 = (Integer)this.executionDepth.get();
      Integer localInteger1 = localInteger2;
      if (localInteger2 == null) {
        localInteger1 = Integer.valueOf(0);
      }
      int i = localInteger1.intValue() - 1;
      if (i == 0)
      {
        this.executionDepth.remove();
        return i;
      }
      this.executionDepth.set(Integer.valueOf(i));
      return i;
    }
    
    private int incrementDepth()
    {
      Integer localInteger2 = (Integer)this.executionDepth.get();
      Integer localInteger1 = localInteger2;
      if (localInteger2 == null) {
        localInteger1 = Integer.valueOf(0);
      }
      int i = localInteger1.intValue() + 1;
      this.executionDepth.set(Integer.valueOf(i));
      return i;
    }
    
    public void execute(Runnable paramRunnable)
    {
      if (incrementDepth() <= 15) {}
      for (;;)
      {
        try
        {
          paramRunnable.run();
          return;
        }
        finally
        {
          decrementDepth();
        }
        BoltsExecutors.background().execute(paramRunnable);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\bolts\BoltsExecutors.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */