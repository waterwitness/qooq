import android.content.pm.PackageItemInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.javahooksdk.HookMethodCallback;
import com.tencent.mobileqq.javahooksdk.MethodHookParam;
import com.tencent.mobileqq.util.Utils;
import java.lang.reflect.Field;

public final class swv
  implements HookMethodCallback
{
  public swv()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void afterHookedMethod(MethodHookParam paramMethodHookParam)
  {
    if (paramMethodHookParam.throwable == null) {}
    for (;;)
    {
      return;
      try
      {
        Object localObject = paramMethodHookParam.args[0].getClass().getDeclaredField("holder").get(paramMethodHookParam.args[0]);
        if (localObject != null)
        {
          localObject = localObject.getClass().getDeclaredField("info").get(localObject);
          if (localObject != null)
          {
            localObject = (String)PackageItemInfo.class.getDeclaredField("name").get(localObject);
            if (localObject != null)
            {
              paramMethodHookParam.throwable = new RuntimeException(paramMethodHookParam.throwable.getMessage() + " -- ContentProvider : " + (String)localObject, paramMethodHookParam.throwable);
              return;
            }
          }
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
  
  public void beforeHookedMethod(MethodHookParam paramMethodHookParam) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\swv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */