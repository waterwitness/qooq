import android.os.AsyncTask;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.javahook.AsyncTaskMonitor;
import com.tencent.mobileqq.javahook.AsyncTaskMonitor.AsyncTaskMonitorResult;
import com.tencent.mobileqq.javahooksdk.HookMethodCallback;
import com.tencent.mobileqq.javahooksdk.MethodHookParam;
import java.util.Map;

public final class swn
  implements HookMethodCallback
{
  public swn()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void afterHookedMethod(MethodHookParam paramMethodHookParam)
  {
    paramMethodHookParam = (AsyncTask)paramMethodHookParam.thisObject;
    AsyncTaskMonitor.AsyncTaskMonitorResult localAsyncTaskMonitorResult = (AsyncTaskMonitor.AsyncTaskMonitorResult)AsyncTaskMonitor.a().get(paramMethodHookParam);
    if (localAsyncTaskMonitorResult == null) {
      return;
    }
    localAsyncTaskMonitorResult.c = System.currentTimeMillis();
    AsyncTaskMonitor.a().remove(paramMethodHookParam);
    AsyncTaskMonitor.a(paramMethodHookParam, localAsyncTaskMonitorResult);
  }
  
  public void beforeHookedMethod(MethodHookParam paramMethodHookParam)
  {
    paramMethodHookParam = (AsyncTask)paramMethodHookParam.thisObject;
    paramMethodHookParam = (AsyncTaskMonitor.AsyncTaskMonitorResult)AsyncTaskMonitor.a().get(paramMethodHookParam);
    if (paramMethodHookParam == null) {
      return;
    }
    paramMethodHookParam.a = Thread.currentThread().getName();
    paramMethodHookParam.b = System.currentTimeMillis();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\swn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */