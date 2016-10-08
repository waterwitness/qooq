import android.view.textservice.SpellCheckerSession;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.javahook.SpellCheckerSessionHooker;
import com.tencent.mobileqq.javahooksdk.HookMethodCallback;
import com.tencent.mobileqq.javahooksdk.MethodHookParam;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

public final class swz
  implements HookMethodCallback
{
  public swz()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void afterHookedMethod(MethodHookParam paramMethodHookParam)
  {
    paramMethodHookParam = (SpellCheckerSession)paramMethodHookParam.thisObject;
    try
    {
      if (SpellCheckerSessionHooker.a == null)
      {
        SpellCheckerSessionHooker.a = SpellCheckerSession.class.getDeclaredField("mSpellCheckerSessionListener");
        SpellCheckerSessionHooker.a.setAccessible(true);
      }
      SpellCheckerSessionHooker.a.set(paramMethodHookParam, null);
      return;
    }
    catch (Throwable paramMethodHookParam)
    {
      QLog.e("SpellCheckerSessionHooker", 2, "close error", paramMethodHookParam);
    }
  }
  
  public void beforeHookedMethod(MethodHookParam paramMethodHookParam) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\swz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */