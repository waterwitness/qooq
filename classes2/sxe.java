import android.os.AsyncTask;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.javahook.ThreadPoolExecutorMonitor;
import com.tencent.mobileqq.javahooksdk.HookMethodCallback;
import com.tencent.mobileqq.javahooksdk.MethodHookParam;
import java.util.Set;

public final class sxe
  implements HookMethodCallback
{
  public sxe()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void afterHookedMethod(MethodHookParam paramMethodHookParam)
  {
    if ((AsyncTask.THREAD_POOL_EXECUTOR.equals(paramMethodHookParam.thisObject)) || (AsyncTask.SERIAL_EXECUTOR.equals(paramMethodHookParam.thisObject))) {}
    do
    {
      return;
      paramMethodHookParam = paramMethodHookParam.thisObject.getClass();
    } while (ThreadPoolExecutorMonitor.a().contains(paramMethodHookParam));
    ThreadPoolExecutorMonitor.a().add(paramMethodHookParam);
    ThreadPoolExecutorMonitor.a(paramMethodHookParam);
  }
  
  public void beforeHookedMethod(MethodHookParam paramMethodHookParam) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\sxe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */