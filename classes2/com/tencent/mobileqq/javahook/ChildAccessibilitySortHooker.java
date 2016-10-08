package com.tencent.mobileqq.javahook;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.javahooksdk.JavaHookBridge;
import com.tencent.mobileqq.util.Utils;
import swu;

public class ChildAccessibilitySortHooker
{
  public static final String a = "ChildAccessibilitySortReporter";
  private static swu a = new swu(null);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a()
  {
    if (Build.VERSION.SDK_INT < 14) {
      return;
    }
    try
    {
      JavaHookBridge.findAndHookMethod(Class.forName("android.widget.FrameLayout"), "onInitializeAccessibilityNodeInfo", new Object[] { AccessibilityNodeInfo.class, a });
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      Utils.a(localNoSuchMethodException);
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Utils.a(localClassNotFoundException);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\javahook\ChildAccessibilitySortHooker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */