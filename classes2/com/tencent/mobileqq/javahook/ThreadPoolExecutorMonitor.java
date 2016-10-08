package com.tencent.mobileqq.javahook;

import android.os.Build.VERSION;
import com.tencent.mobileqq.app.Job;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.javahooksdk.JavaHookBridge;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import sxe;
import sxf;
import sxg;
import sxh;

public class ThreadPoolExecutorMonitor
{
  public static final String a = "ThreadPoolExecutorMonitor";
  private static Map jdField_a_of_type_JavaUtilMap = new WeakHashMap();
  private static Set jdField_a_of_type_JavaUtilSet;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaUtilSet = new HashSet();
  }
  
  public static void a() {}
  
  private static String b(Runnable paramRunnable)
  {
    if ((paramRunnable instanceof FutureTask)) {}
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT < 17) {
          continue;
        }
        localObject1 = FutureTask.class.getDeclaredField("callable");
        ((Field)localObject1).setAccessible(true);
        localObject2 = (Callable)((Field)localObject1).get(paramRunnable);
        if (localObject2 == null) {
          break label174;
        }
        Class localClass = Class.forName("java.util.concurrent.Executors$RunnableAdapter");
        localObject1 = localObject2;
        if (localClass.isInstance(localObject2))
        {
          localObject1 = localClass.getDeclaredField("task");
          ((Field)localObject1).setAccessible(true);
          localObject1 = (Runnable)((Field)localObject1).get(localObject2);
        }
      }
      catch (Exception localException)
      {
        Object localObject1;
        localRunnable = null;
        continue;
      }
      if (localObject1 == null)
      {
        return paramRunnable.getClass().getName();
        if (Build.VERSION.SDK_INT < 15) {
          break label179;
        }
        localObject1 = FutureTask.class.getDeclaredField("sync");
        ((Field)localObject1).setAccessible(true);
        localObject1 = ((Field)localObject1).get(paramRunnable);
        localObject2 = Class.forName("java.util.concurrent.FutureTask$Sync").getDeclaredField("callable");
        ((Field)localObject2).setAccessible(true);
        localObject2 = (Callable)((Field)localObject2).get(localObject1);
        continue;
        if ((paramRunnable instanceof Job))
        {
          localRunnable = ((Job)paramRunnable).a;
          continue;
        }
      }
      else
      {
        paramRunnable = localRunnable;
        continue;
      }
      label174:
      Runnable localRunnable = null;
      continue;
      label179:
      Object localObject2 = null;
    }
  }
  
  private static void b()
  {
    try
    {
      JavaHookBridge.findAndHookConstructor(ThreadPoolExecutor.class, new Object[] { Integer.TYPE, Integer.TYPE, Long.TYPE, TimeUnit.class, BlockingQueue.class, ThreadFactory.class, RejectedExecutionHandler.class, new sxe() });
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException) {}
  }
  
  private static void b(Class paramClass)
  {
    c(paramClass);
    d(paramClass);
    e(paramClass);
  }
  
  private static void b(Runnable paramRunnable, ThreadPoolExecutorMonitor.ThreadPoolExecutorMonitorResult paramThreadPoolExecutorMonitorResult)
  {
    if (QLog.isColorLevel())
    {
      paramRunnable = new StringBuilder();
      paramRunnable.append("ThreadPoolExecutor Log : ");
      paramRunnable.append("runnable class = ").append(paramThreadPoolExecutorMonitorResult.jdField_a_of_type_JavaLangString).append(" ; ");
      paramRunnable.append("thread name = ").append(paramThreadPoolExecutorMonitorResult.jdField_b_of_type_JavaLangString).append(" ; ");
      paramRunnable.append("wait time = ").append(paramThreadPoolExecutorMonitorResult.jdField_b_of_type_Long - paramThreadPoolExecutorMonitorResult.jdField_a_of_type_Long).append(" ; ");
      paramRunnable.append("run() cost time = ").append(paramThreadPoolExecutorMonitorResult.c - paramThreadPoolExecutorMonitorResult.jdField_b_of_type_Long).append(" ; ");
      QLog.d("ThreadPoolExecutorMonitor", 2, paramRunnable.toString());
    }
  }
  
  private static void c(Class paramClass)
  {
    try
    {
      JavaHookBridge.findAndHookMethod(paramClass, "execute", new Object[] { Runnable.class, new sxf() });
      return;
    }
    catch (NoSuchMethodException paramClass) {}
  }
  
  private static void d(Class paramClass)
  {
    try
    {
      JavaHookBridge.findAndHookMethod(paramClass, "beforeExecute", new Object[] { Thread.class, Runnable.class, new sxg() });
      return;
    }
    catch (NoSuchMethodException paramClass) {}
  }
  
  private static void e(Class paramClass)
  {
    try
    {
      JavaHookBridge.findAndHookMethod(paramClass, "afterExecute", new Object[] { Runnable.class, Throwable.class, new sxh() });
      return;
    }
    catch (NoSuchMethodException paramClass) {}
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\javahook\ThreadPoolExecutorMonitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */