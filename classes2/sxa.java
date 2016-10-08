import android.view.textservice.SpellCheckerSession;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.javahook.SpellCheckerSessionHooker;
import com.tencent.mobileqq.javahooksdk.JavaHookBridge;
import com.tencent.mobileqq.javahooksdk.MethodHookParam;
import com.tencent.mobileqq.javahooksdk.ReplaceMethodCallback;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

public final class sxa
  implements ReplaceMethodCallback
{
  public sxa()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void replaceMethod(MethodHookParam paramMethodHookParam)
  {
    SpellCheckerSession localSpellCheckerSession = (SpellCheckerSession)paramMethodHookParam.thisObject;
    try
    {
      if (SpellCheckerSessionHooker.a == null)
      {
        SpellCheckerSessionHooker.a = SpellCheckerSession.class.getDeclaredField("mSpellCheckerSessionListener");
        SpellCheckerSessionHooker.a.setAccessible(true);
      }
      if (SpellCheckerSessionHooker.a.get(localSpellCheckerSession) != null) {
        JavaHookBridge.invokeOriginMethod(paramMethodHookParam.method, paramMethodHookParam.thisObject, paramMethodHookParam.args);
      }
      return;
    }
    catch (Throwable paramMethodHookParam)
    {
      QLog.e("SpellCheckerSessionHooker", 2, "handleOnGetSuggestionsMultiple error", paramMethodHookParam);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\sxa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */