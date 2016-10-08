package bolts;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class AndroidExecutors
{
  static final int CORE_POOL_SIZE = CPU_COUNT + 1;
  private static final int CPU_COUNT;
  private static final AndroidExecutors INSTANCE = new AndroidExecutors();
  static final long KEEP_ALIVE_TIME = 1L;
  static final int MAX_POOL_SIZE = CPU_COUNT * 2 + 1;
  private final Executor uiThread = new UIThreadExecutor(null);
  
  static
  {
    CPU_COUNT = Runtime.getRuntime().availableProcessors();
  }
  
  @SuppressLint({"NewApi"})
  public static void allowCoreThreadTimeout(ThreadPoolExecutor paramThreadPoolExecutor, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 9) {}
    try
    {
      ThreadPoolExecutor.class.getMethod("allowCoreThreadTimeOut", new Class[] { Boolean.TYPE }).invoke(paramThreadPoolExecutor, new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    catch (Exception paramThreadPoolExecutor)
    {
      paramThreadPoolExecutor.printStackTrace();
    }
  }
  
  public static ExecutorService newCachedThreadPool()
  {
    ThreadPoolExecutor localThreadPoolExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
    allowCoreThreadTimeout(localThreadPoolExecutor, true);
    return localThreadPoolExecutor;
  }
  
  public static ExecutorService newCachedThreadPool(ThreadFactory paramThreadFactory)
  {
    paramThreadFactory = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue(), paramThreadFactory);
    allowCoreThreadTimeout(paramThreadFactory, true);
    return paramThreadFactory;
  }
  
  public static Executor uiThread()
  {
    return INSTANCE.uiThread;
  }
  
  private static class UIThreadExecutor
    implements Executor
  {
    public void execute(Runnable paramRunnable)
    {
      new Handler(Looper.getMainLooper()).post(paramRunnable);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\bolts\AndroidExecutors.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */