import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.javahook.BitmapOOMHooker;
import com.tencent.mobileqq.javahooksdk.HookMethodCallback;
import com.tencent.mobileqq.javahooksdk.JavaHookBridge;
import com.tencent.mobileqq.javahooksdk.MethodHookParam;

public class swr
  implements HookMethodCallback
{
  private int a;
  
  public swr(int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramInt;
  }
  
  public void afterHookedMethod(MethodHookParam paramMethodHookParam)
  {
    if (paramMethodHookParam.throwable == null) {
      return;
    }
    Throwable localThrowable;
    if (paramMethodHookParam.throwable.getCause() != null) {
      localThrowable = paramMethodHookParam.throwable.getCause();
    }
    while ((localThrowable instanceof OutOfMemoryError))
    {
      BitmapOOMHooker.b();
      try
      {
        paramMethodHookParam.result = JavaHookBridge.invokeOriginMethod(paramMethodHookParam.method, paramMethodHookParam.thisObject, paramMethodHookParam.args);
        paramMethodHookParam.throwable = null;
        BitmapOOMHooker.a(true, this.a);
        return;
      }
      catch (Exception paramMethodHookParam)
      {
        BitmapOOMHooker.a(false, this.a);
        return;
        localThrowable = paramMethodHookParam.throwable;
      }
      catch (Error paramMethodHookParam)
      {
        BitmapOOMHooker.a(false, this.a);
      }
    }
  }
  
  public void beforeHookedMethod(MethodHookParam paramMethodHookParam) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\swr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */