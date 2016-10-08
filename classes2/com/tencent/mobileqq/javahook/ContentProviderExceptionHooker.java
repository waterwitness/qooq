package com.tencent.mobileqq.javahook;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.javahooksdk.JavaHookBridge;
import com.tencent.mobileqq.util.Utils;
import swv;

public class ContentProviderExceptionHooker
{
  public ContentProviderExceptionHooker()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a()
  {
    try
    {
      JavaHookBridge.findAndHookMethod(Class.forName("android.app.ActivityThread"), "completeRemoveProvider", new Object[] { Class.forName("android.app.ActivityThread$ProviderRefCount"), new swv() });
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Utils.a(localClassNotFoundException);
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      Utils.a(localNoSuchMethodException);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\javahook\ContentProviderExceptionHooker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */