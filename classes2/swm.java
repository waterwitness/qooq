import android.os.AsyncTask;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.javahook.AsyncTaskMonitor;
import com.tencent.mobileqq.javahook.AsyncTaskMonitor.AsyncTaskMonitorResult;
import com.tencent.mobileqq.javahooksdk.HookMethodCallback;
import com.tencent.mobileqq.javahooksdk.MethodHookParam;
import java.util.Map;
import java.util.Set;

public final class swm
  implements HookMethodCallback
{
  public swm()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void afterHookedMethod(MethodHookParam paramMethodHookParam) {}
  
  public void beforeHookedMethod(MethodHookParam paramMethodHookParam)
  {
    Object localObject = paramMethodHookParam.thisObject.getClass();
    if (AsyncTaskMonitor.a().contains(localObject)) {}
    do
    {
      return;
      if (!AsyncTaskMonitor.b().contains(localObject))
      {
        AsyncTaskMonitor.b().add(localObject);
        AsyncTaskMonitor.a((Class)localObject);
      }
      paramMethodHookParam = (AsyncTask)paramMethodHookParam.thisObject;
    } while (AsyncTaskMonitor.a().containsKey(paramMethodHookParam));
    localObject = new AsyncTaskMonitor.AsyncTaskMonitorResult();
    AsyncTaskMonitor.a().put(paramMethodHookParam, localObject);
    ((AsyncTaskMonitor.AsyncTaskMonitorResult)localObject).a = System.currentTimeMillis();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\swm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */