import android.os.AsyncTask;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.javahook.ThreadPoolExecutorMonitor;
import com.tencent.mobileqq.javahook.ThreadPoolExecutorMonitor.ThreadPoolExecutorMonitorResult;
import com.tencent.mobileqq.javahooksdk.HookMethodCallback;
import com.tencent.mobileqq.javahooksdk.MethodHookParam;
import java.util.Map;

public final class sxg
  implements HookMethodCallback
{
  public sxg()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void afterHookedMethod(MethodHookParam paramMethodHookParam)
  {
    if ((AsyncTask.THREAD_POOL_EXECUTOR.equals(paramMethodHookParam.thisObject)) || (AsyncTask.SERIAL_EXECUTOR.equals(paramMethodHookParam.thisObject))) {}
    for (;;)
    {
      return;
      Object localObject = (Runnable)paramMethodHookParam.args[1];
      synchronized (ThreadPoolExecutorMonitor.a())
      {
        localObject = (ThreadPoolExecutorMonitor.ThreadPoolExecutorMonitorResult)ThreadPoolExecutorMonitor.a().get(localObject);
        if (localObject == null) {
          continue;
        }
        ((ThreadPoolExecutorMonitor.ThreadPoolExecutorMonitorResult)localObject).jdField_b_of_type_JavaLangString = ((Thread)paramMethodHookParam.args[0]).getName();
        ((ThreadPoolExecutorMonitor.ThreadPoolExecutorMonitorResult)localObject).jdField_b_of_type_Long = System.currentTimeMillis();
        return;
      }
    }
  }
  
  public void beforeHookedMethod(MethodHookParam paramMethodHookParam) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\sxg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */