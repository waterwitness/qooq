package com.tencent.mobileqq.javahook;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.javahooksdk.JavaHookBridge;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import sws;

public class BlinkHooker
{
  static final int jdField_a_of_type_Int = 1;
  static Class jdField_a_of_type_JavaLangClass;
  public static Field a;
  static final int b = 2;
  public static Field b;
  static final int c = 3;
  
  public BlinkHooker()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a()
  {
    try
    {
      jdField_a_of_type_JavaLangClass = Class.forName("android.widget.Editor");
      b = jdField_a_of_type_JavaLangClass.getDeclaredField("mTextView");
      b.setAccessible(true);
      Class localClass = Class.forName("android.widget.Editor$Blink");
      jdField_a_of_type_JavaLangReflectField = localClass.getDeclaredField("this$0");
      jdField_a_of_type_JavaLangReflectField.setAccessible(true);
      JavaHookBridge.findAndHookMethod(localClass, "run", new Object[] { new sws(1) });
      JavaHookBridge.findAndHookMethod(localClass, "cancel", new Object[] { new sws(2) });
      JavaHookBridge.findAndHookMethod(localClass, "uncancel", new Object[] { new sws(3) });
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ClearableEditText", 2, "startHook error", localException);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\javahook\BlinkHooker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */