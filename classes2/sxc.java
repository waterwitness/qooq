import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.javahook.ThreadMonitor;
import com.tencent.mobileqq.javahook.ThreadMonitor.ThreadMonitorResult;
import com.tencent.mobileqq.javahooksdk.HookMethodCallback;
import com.tencent.mobileqq.javahooksdk.MethodHookParam;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;

public final class sxc
  implements HookMethodCallback
{
  public sxc()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void afterHookedMethod(MethodHookParam paramMethodHookParam) {}
  
  public void beforeHookedMethod(MethodHookParam paramMethodHookParam)
  {
    Object localObject = paramMethodHookParam.thisObject.getClass();
    if (!ThreadMonitor.a().contains(localObject))
    {
      ThreadMonitor.a().add(localObject);
      ThreadMonitor.a((Class)localObject);
    }
    try
    {
      localObject = (Thread)paramMethodHookParam.thisObject;
      if (!ThreadMonitor.a().containsKey(localObject))
      {
        ThreadMonitor.ThreadMonitorResult localThreadMonitorResult = new ThreadMonitor.ThreadMonitorResult();
        ThreadMonitor.a().put(localObject, localThreadMonitorResult);
        paramMethodHookParam = Thread.class.getDeclaredField("target");
        paramMethodHookParam.setAccessible(true);
        Runnable localRunnable = (Runnable)paramMethodHookParam.get(localObject);
        paramMethodHookParam = localRunnable;
        if (localRunnable == null) {
          paramMethodHookParam = (MethodHookParam)localObject;
        }
        if (paramMethodHookParam.getClass().equals("java.util.concurrent.ThreadPoolExecutor$Worker"))
        {
          ThreadMonitor.a().remove(localObject);
          return;
        }
        localThreadMonitorResult.b = paramMethodHookParam.getClass().getName();
        localThreadMonitorResult.jdField_a_of_type_JavaLangString = ((Thread)localObject).getName();
        localThreadMonitorResult.jdField_a_of_type_Long = System.currentTimeMillis();
        return;
      }
    }
    catch (NoSuchFieldException paramMethodHookParam)
    {
      paramMethodHookParam.printStackTrace();
      return;
    }
    catch (IllegalArgumentException paramMethodHookParam)
    {
      paramMethodHookParam.printStackTrace();
      return;
    }
    catch (IllegalAccessException paramMethodHookParam)
    {
      paramMethodHookParam.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\sxc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */