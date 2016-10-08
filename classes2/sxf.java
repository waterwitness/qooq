import android.os.AsyncTask;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.javahook.ThreadPoolExecutorMonitor;
import com.tencent.mobileqq.javahook.ThreadPoolExecutorMonitor.ThreadPoolExecutorMonitorResult;
import com.tencent.mobileqq.javahooksdk.HookMethodCallback;
import com.tencent.mobileqq.javahooksdk.MethodHookParam;
import java.util.Map;

public final class sxf
  implements HookMethodCallback
{
  public sxf()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void afterHookedMethod(MethodHookParam paramMethodHookParam) {}
  
  public void beforeHookedMethod(MethodHookParam paramMethodHookParam)
  {
    if ((AsyncTask.THREAD_POOL_EXECUTOR.equals(paramMethodHookParam.thisObject)) || (AsyncTask.SERIAL_EXECUTOR.equals(paramMethodHookParam.thisObject))) {
      return;
    }
    paramMethodHookParam = (Runnable)paramMethodHookParam.args[0];
    synchronized (ThreadPoolExecutorMonitor.a())
    {
      if (ThreadPoolExecutorMonitor.a().containsKey(paramMethodHookParam)) {
        return;
      }
    }
    ThreadPoolExecutorMonitor.ThreadPoolExecutorMonitorResult localThreadPoolExecutorMonitorResult = new ThreadPoolExecutorMonitor.ThreadPoolExecutorMonitorResult();
    synchronized (ThreadPoolExecutorMonitor.a())
    {
      ThreadPoolExecutorMonitor.a().put(paramMethodHookParam, localThreadPoolExecutorMonitorResult);
      localThreadPoolExecutorMonitorResult.jdField_a_of_type_JavaLangString = ThreadPoolExecutorMonitor.a(paramMethodHookParam);
      localThreadPoolExecutorMonitorResult.jdField_a_of_type_Long = System.currentTimeMillis();
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\sxf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */