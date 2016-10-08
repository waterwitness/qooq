import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.javahook.ThreadMonitor;
import com.tencent.mobileqq.javahook.ThreadMonitor.ThreadMonitorResult;
import com.tencent.mobileqq.javahooksdk.HookMethodCallback;
import com.tencent.mobileqq.javahooksdk.MethodHookParam;
import java.util.Map;

public final class sxd
  implements HookMethodCallback
{
  public sxd()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void afterHookedMethod(MethodHookParam paramMethodHookParam)
  {
    paramMethodHookParam = (Thread)paramMethodHookParam.thisObject;
    ThreadMonitor.ThreadMonitorResult localThreadMonitorResult = (ThreadMonitor.ThreadMonitorResult)ThreadMonitor.a().get(paramMethodHookParam);
    if (localThreadMonitorResult == null) {
      return;
    }
    localThreadMonitorResult.c = System.currentTimeMillis();
    ThreadMonitor.a(paramMethodHookParam, localThreadMonitorResult);
    ThreadMonitor.a().remove(paramMethodHookParam);
  }
  
  public void beforeHookedMethod(MethodHookParam paramMethodHookParam)
  {
    paramMethodHookParam = (Thread)paramMethodHookParam.thisObject;
    paramMethodHookParam = (ThreadMonitor.ThreadMonitorResult)ThreadMonitor.a().get(paramMethodHookParam);
    if (paramMethodHookParam == null) {
      return;
    }
    paramMethodHookParam.b = System.currentTimeMillis();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\sxd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */