import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.javahooksdk.HookMethodCallback;
import com.tencent.mobileqq.javahooksdk.MethodHookParam;
import com.tencent.mobileqq.util.Utils;
import java.io.File;
import java.lang.reflect.Field;

public class swy
  implements HookMethodCallback
{
  private swy()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void afterHookedMethod(MethodHookParam paramMethodHookParam) {}
  
  public void beforeHookedMethod(MethodHookParam paramMethodHookParam)
  {
    if (paramMethodHookParam.throwable == null) {}
    for (;;)
    {
      return;
      try
      {
        Object localObject = paramMethodHookParam.thisObject.getClass().getDeclaredField("mFile");
        ((Field)localObject).setAccessible(true);
        localObject = (File)((Field)localObject).get(paramMethodHookParam.thisObject);
        if (localObject != null)
        {
          paramMethodHookParam.throwable = new RuntimeException(paramMethodHookParam.throwable.getMessage() + " -- File : " + ((File)localObject).getName() + " -- Size : " + ((File)localObject).length(), paramMethodHookParam.throwable);
          return;
        }
      }
      catch (NoSuchFieldException paramMethodHookParam)
      {
        Utils.a(paramMethodHookParam);
        return;
      }
      catch (IllegalArgumentException paramMethodHookParam)
      {
        Utils.a(paramMethodHookParam);
        return;
      }
      catch (IllegalAccessException paramMethodHookParam)
      {
        Utils.a(paramMethodHookParam);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\swy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */