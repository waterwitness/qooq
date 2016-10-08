import android.os.AsyncTask;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.javahook.ThreadPoolExecutorMonitor;
import com.tencent.mobileqq.javahook.ThreadPoolExecutorMonitor.ThreadPoolExecutorMonitorResult;
import com.tencent.mobileqq.javahooksdk.HookMethodCallback;
import com.tencent.mobileqq.javahooksdk.MethodHookParam;
import java.util.Map;

public final class sxh
  implements HookMethodCallback
{
  public sxh()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void afterHookedMethod(MethodHookParam paramMethodHookParam) {}
  
  public void beforeHookedMethod(MethodHookParam paramMethodHookParam)
  {
    if ((AsyncTask.THREAD_POOL_EXECUTOR.equals(paramMethodHookParam.thisObject)) || (AsyncTask.SERIAL_EXECUTOR.equals(paramMethodHookParam.thisObject))) {}
    for (;;)
    {
      return;
      paramMethodHookParam = (Runnable)paramMethodHookParam.args[0];
      synchronized (ThreadPoolExecutorMonitor.a())
      {
        ThreadPoolExecutorMonitor.ThreadPoolExecutorMonitorResult localThreadPoolExecutorMonitorResult = (ThreadPoolExecutorMonitor.ThreadPoolExecutorMonitorResult)ThreadPoolExecutorMonitor.a().get(paramMethodHookParam);
        if (localThreadPoolExecutorMonitorResult == null) {
          continue;
        }
        localThreadPoolExecutorMonitorResult.c = System.currentTimeMillis();
        ThreadPoolExecutorMonitor.a(paramMethodHookParam, localThreadPoolExecutorMonitorResult);
        synchronized (ThreadPoolExecutorMonitor.a())
        {
          ThreadPoolExecutorMonitor.a().remove(paramMethodHookParam);
          return;
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\sxh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */