package com.tencent.mobileqq.javahook;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.javahooksdk.JavaHookBridge;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import sxc;
import sxd;

public class ThreadMonitor
{
  public static final String a = "ThreadMonitor";
  private static Map jdField_a_of_type_JavaUtilMap = new WeakHashMap();
  private static Set jdField_a_of_type_JavaUtilSet;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaUtilSet = new HashSet();
  }
  
  public static void a() {}
  
  private static void b()
  {
    try
    {
      JavaHookBridge.findAndHookMethod(Thread.class, "start", new Object[] { new sxc() });
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      localNoSuchMethodException.printStackTrace();
    }
  }
  
  private static void b(Class paramClass)
  {
    try
    {
      JavaHookBridge.findAndHookMethod(paramClass, "run", new Object[] { new sxd() });
      return;
    }
    catch (NoSuchMethodException paramClass)
    {
      paramClass.printStackTrace();
    }
  }
  
  private static void b(Thread paramThread, ThreadMonitor.ThreadMonitorResult paramThreadMonitorResult)
  {
    if (QLog.isColorLevel())
    {
      paramThread = new StringBuilder();
      paramThread.append("Thread Log : ");
      paramThread.append("runnable class = ").append(paramThreadMonitorResult.jdField_b_of_type_JavaLangString).append(" ; ");
      paramThread.append("thread name = ").append(paramThreadMonitorResult.jdField_a_of_type_JavaLangString).append(" ; ");
      paramThread.append("wait time = ").append(paramThreadMonitorResult.jdField_b_of_type_Long - paramThreadMonitorResult.jdField_a_of_type_Long).append(" ; ");
      paramThread.append("run() cost time = ").append(paramThreadMonitorResult.c - paramThreadMonitorResult.jdField_b_of_type_Long).append(" ; ");
      QLog.d("ThreadMonitor", 2, paramThread.toString());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\javahook\ThreadMonitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */