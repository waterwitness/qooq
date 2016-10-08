package com.tencent.mobileqq.app;

import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.Timer;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import mqq.os.MqqHandler;
import qha;
import qhb;
import qhc;
import qhd;
import qhe;
import qhf;

public class ThreadManager
{
  private static Handler jdField_a_of_type_AndroidOsHandler;
  private static HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  public static final String a = "TM.global";
  private static Timer jdField_a_of_type_JavaUtilTimer;
  private static Executor jdField_a_of_type_JavaUtilConcurrentExecutor = new ThreadPoolExecutor(5, 9, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue(256), new qhe());
  private static volatile MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  public static boolean a = false;
  private static HandlerThread jdField_b_of_type_AndroidOsHandlerThread;
  public static final String b = "AutoMonitor";
  private static volatile MqqHandler jdField_b_of_type_MqqOsMqqHandler;
  public static boolean b = false;
  private static HandlerThread jdField_c_of_type_AndroidOsHandlerThread;
  protected static final String c = "sp_reject_exception_report";
  private static volatile MqqHandler jdField_c_of_type_MqqOsMqqHandler;
  public static final boolean c = false;
  private static final String d = "ap_reject_exception_report";
  public static volatile boolean d;
  public static final boolean e = false;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    c();
    d();
  }
  
  public static HandlerThread a(String paramString, int paramInt)
  {
    if (ThreadOptimizer.a().c()) {
      paramInt = 19;
    }
    HandlerThread localHandlerThread = ThreadExcutor.a().a(paramString, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("TM.global", 2, localHandlerThread.getId() + "-" + paramString);
    }
    return localHandlerThread;
  }
  
  public static Looper a()
  {
    return a().getLooper();
  }
  
  public static String a()
  {
    return ThreadExcutor.a().a();
  }
  
  public static Thread a()
  {
    if (jdField_c_of_type_AndroidOsHandlerThread == null) {
      a();
    }
    return jdField_c_of_type_AndroidOsHandlerThread;
  }
  
  public static Thread a(Runnable paramRunnable, String paramString, int paramInt)
  {
    paramRunnable = ThreadExcutor.a().a(paramRunnable, paramString, paramInt);
    if (ThreadOptimizer.a().c()) {
      paramRunnable.setPriority(1);
    }
    if (QLog.isColorLevel()) {
      QLog.d("TM.global", 2, paramRunnable.getId() + "|" + paramString);
    }
    return paramRunnable;
  }
  
  public static Timer a()
  {
    if (jdField_a_of_type_JavaUtilTimer == null) {}
    try
    {
      jdField_a_of_type_JavaUtilTimer = new qhf("QQ_Timer");
      return jdField_a_of_type_JavaUtilTimer;
    }
    finally {}
  }
  
  public static Executor a()
  {
    return Executors.newSingleThreadExecutor(new qhd());
  }
  
  public static Executor a(ThreadPoolParams paramThreadPoolParams)
  {
    return ThreadExcutor.a().a(paramThreadPoolParams);
  }
  
  public static MqqHandler a()
  {
    if (jdField_c_of_type_MqqOsMqqHandler == null) {}
    try
    {
      if (jdField_c_of_type_MqqOsMqqHandler == null)
      {
        jdField_c_of_type_AndroidOsHandlerThread = a("QQ_FILE_RW", 0);
        jdField_c_of_type_AndroidOsHandlerThread.start();
        jdField_c_of_type_MqqOsMqqHandler = new qhb(jdField_c_of_type_AndroidOsHandlerThread.getLooper());
      }
      return jdField_c_of_type_MqqOsMqqHandler;
    }
    finally {}
  }
  
  public static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("TM.global", 2, "ThreadManager init");
    }
    ThreadExcutor.a();
  }
  
  public static void a(Runnable paramRunnable, int paramInt, ThreadExcutor.IThreadListener paramIThreadListener, boolean paramBoolean)
  {
    ThreadExcutor.a().a(paramInt, paramRunnable, paramIThreadListener, paramBoolean);
  }
  
  public static void a(Runnable paramRunnable, ThreadExcutor.IThreadListener paramIThreadListener, boolean paramBoolean)
  {
    ThreadExcutor.a().a(paramRunnable, paramIThreadListener, paramBoolean);
  }
  
  public static void a(Runnable paramRunnable, boolean paramBoolean)
  {
    b().post(paramRunnable);
  }
  
  public static boolean a(Runnable paramRunnable)
  {
    return ThreadExcutor.a().a(paramRunnable);
  }
  
  public static Looper b()
  {
    return b().getLooper();
  }
  
  public static Thread b()
  {
    if (jdField_b_of_type_AndroidOsHandlerThread == null) {
      b();
    }
    return jdField_b_of_type_AndroidOsHandlerThread;
  }
  
  public static Executor b()
  {
    return jdField_a_of_type_JavaUtilConcurrentExecutor;
  }
  
  public static MqqHandler b()
  {
    if (jdField_b_of_type_MqqOsMqqHandler == null) {}
    try
    {
      if (jdField_b_of_type_MqqOsMqqHandler == null)
      {
        jdField_b_of_type_AndroidOsHandlerThread = a("QQ_SUB", 0);
        jdField_b_of_type_AndroidOsHandlerThread.start();
        jdField_b_of_type_MqqOsMqqHandler = new qhc(jdField_b_of_type_AndroidOsHandlerThread.getLooper());
      }
      return jdField_b_of_type_MqqOsMqqHandler;
    }
    finally {}
  }
  
  public static void b()
  {
    ThreadExcutor.a().a();
  }
  
  public static void b(Runnable paramRunnable)
  {
    b().post(paramRunnable);
  }
  
  public static void b(Runnable paramRunnable, int paramInt, ThreadExcutor.IThreadListener paramIThreadListener, boolean paramBoolean)
  {
    ThreadExcutor.a().b(paramInt, paramRunnable, paramIThreadListener, paramBoolean);
  }
  
  public static Looper c()
  {
    if (jdField_a_of_type_AndroidOsHandler == null) {}
    try
    {
      jdField_a_of_type_AndroidOsHandlerThread = a("Recent_Handler", 0);
      jdField_a_of_type_AndroidOsHandlerThread.start();
      jdField_a_of_type_AndroidOsHandler = new Handler(jdField_a_of_type_AndroidOsHandlerThread.getLooper());
      return jdField_a_of_type_AndroidOsHandler.getLooper();
    }
    finally {}
  }
  
  public static Thread c()
  {
    if (jdField_a_of_type_AndroidOsHandlerThread == null) {
      c();
    }
    return jdField_a_of_type_AndroidOsHandlerThread;
  }
  
  public static MqqHandler c()
  {
    if (jdField_a_of_type_MqqOsMqqHandler == null) {}
    try
    {
      if (jdField_a_of_type_MqqOsMqqHandler == null) {
        jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), null, true);
      }
      return jdField_a_of_type_MqqOsMqqHandler;
    }
    finally {}
  }
  
  private static void c()
  {
    Runtime.getRuntime().addShutdownHook(new qha());
  }
  
  public static void c(Runnable paramRunnable)
  {
    a().post(paramRunnable);
  }
  
  private static void d()
  {
    Object localObject;
    if (Build.VERSION.SDK_INT >= 11) {
      localObject = AsyncTask.THREAD_POOL_EXECUTOR;
    }
    for (;;)
    {
      if ((localObject instanceof ThreadPoolExecutor)) {
        ((ThreadPoolExecutor)localObject).setRejectedExecutionHandler(new ThreadManager.ShowQueueAbortPolicy());
      }
      return;
      try
      {
        localObject = AsyncTask.class.getDeclaredField("sExecutor");
        ((Field)localObject).setAccessible(true);
        localObject = (Executor)((Field)localObject).get(null);
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TM.global", 2, localException.getMessage(), localException);
        }
        ThreadPoolExecutor localThreadPoolExecutor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue());
      }
    }
  }
  
  public static void d(Runnable paramRunnable)
  {
    a(paramRunnable, 5, null, false);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\ThreadManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */