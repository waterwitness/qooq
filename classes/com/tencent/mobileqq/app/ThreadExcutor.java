package com.tencent.mobileqq.app;

import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import mqq.os.MqqHandler;
import qdh;
import qgs;
import qgt;
import qgu;
import qgv;
import qgw;
import qgx;
import qgy;
import qgz;
import qhi;

public class ThreadExcutor
{
  public static final int a = 5000;
  private static final ThreadExcutor jdField_a_of_type_ComTencentMobileqqAppThreadExcutor = new ThreadExcutor();
  private static volatile MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  public static boolean a = false;
  public static final int b = 15;
  public static int c = 0;
  public static int e = 0;
  private static final int f = 1;
  private static final int g = 2;
  private static final int h = 5;
  private LinkedBlockingQueue jdField_a_of_type_JavaUtilConcurrentLinkedBlockingQueue = new LinkedBlockingQueue();
  private qdh jdField_a_of_type_Qdh = new qdh("GlobalPool-L", 5);
  private qgw jdField_a_of_type_Qgw = new qgt(this);
  private qhi jdField_a_of_type_Qhi;
  private qdh jdField_b_of_type_Qdh = new qdh("GlobalPool-H", 2);
  private qhi jdField_b_of_type_Qhi;
  private qdh jdField_c_of_type_Qdh = new qdh("GlobalPool-Download", 2);
  private qhi jdField_c_of_type_Qhi;
  public int d;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_c_of_type_Int = 1000;
  }
  
  private ThreadExcutor()
  {
    ThreadManager.d = false;
    if (QLog.isColorLevel()) {
      QLog.i("TM.global", 2, "ThreadExcutor singleton construct");
    }
    b();
    a();
  }
  
  private Job a(int paramInt, Runnable paramRunnable, ThreadExcutor.IThreadListener paramIThreadListener, boolean paramBoolean)
  {
    Object localObject5 = null;
    Object localObject6 = null;
    Object localObject7 = null;
    localObject1 = null;
    Object localObject8 = paramRunnable.getClass();
    String str = ((Class)localObject8).getName();
    Object localObject3;
    if (paramBoolean)
    {
      localObject2 = localObject5;
      localObject3 = localObject6;
      localObject4 = localObject7;
    }
    try
    {
      localObject8 = ((Class)localObject8).getDeclaredField("this$0");
      localObject2 = localObject5;
      localObject3 = localObject6;
      localObject4 = localObject7;
      ((Field)localObject8).setAccessible(true);
      localObject2 = localObject5;
      localObject3 = localObject6;
      localObject4 = localObject7;
      localObject1 = ((Field)localObject8).get(paramRunnable);
      localObject2 = localObject1;
      localObject3 = localObject1;
      localObject4 = localObject1;
      ((Field)localObject8).set(paramRunnable, null);
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        if (!ThreadManager.b)
        {
          localObject1 = localObject2;
          if (!ThreadManager.a) {}
        }
        else
        {
          localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            QLog.d("TM.global", 2, "NoSuchFieldException", localNoSuchFieldException);
            localObject1 = localObject2;
          }
        }
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        if (!ThreadManager.b)
        {
          localObject1 = localNoSuchFieldException;
          if (!ThreadManager.a) {}
        }
        else
        {
          localObject1 = localNoSuchFieldException;
          if (QLog.isColorLevel())
          {
            QLog.d("TM.global", 2, "IllegalArgumentException", localIllegalArgumentException);
            localObject1 = localNoSuchFieldException;
          }
        }
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        if (!ThreadManager.b)
        {
          localObject1 = localObject4;
          if (!ThreadManager.a) {}
        }
        else
        {
          localObject1 = localObject4;
          if (QLog.isColorLevel())
          {
            QLog.d("TM.global", 2, "IllegalAccessException", localIllegalAccessException);
            localObject1 = localObject4;
          }
        }
      }
    }
    return new Job(localObject1, str, paramInt, paramRunnable, paramIThreadListener, paramBoolean);
  }
  
  private Job a(Runnable paramRunnable)
  {
    return a(0, paramRunnable, null, false);
  }
  
  public static ThreadExcutor a()
  {
    try
    {
      ThreadExcutor localThreadExcutor = jdField_a_of_type_ComTencentMobileqqAppThreadExcutor;
      return localThreadExcutor;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private MqqHandler a()
  {
    if (jdField_a_of_type_MqqOsMqqHandler == null)
    {
      HandlerThread localHandlerThread = a("QQ_DISPATCHER", 10);
      localHandlerThread.start();
      jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(localHandlerThread.getLooper());
      if (ThreadManager.a) {
        jdField_a_of_type_MqqOsMqqHandler.getLooper().setMessageLogging(new qgz(4, "QQ_DISPATCHER"));
      }
    }
    return jdField_a_of_type_MqqOsMqqHandler;
  }
  
  private boolean a(Job paramJob)
  {
    return this.jdField_b_of_type_Qhi.remove(paramJob);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Qhi == null)
    {
      this.jdField_a_of_type_Qhi = new qgy(new SynchronousQueue(true), this.jdField_a_of_type_Qdh);
      this.jdField_a_of_type_Qhi.a(this.jdField_a_of_type_JavaUtilConcurrentLinkedBlockingQueue, this.jdField_a_of_type_Qgw);
    }
    if (this.jdField_b_of_type_Qhi == null)
    {
      this.jdField_b_of_type_Qhi = new qgx(new LinkedBlockingQueue(15), this.jdField_b_of_type_Qdh);
      this.jdField_b_of_type_Qhi.a(this.jdField_a_of_type_JavaUtilConcurrentLinkedBlockingQueue, this.jdField_a_of_type_Qgw);
      if (Build.VERSION.SDK_INT > 8) {
        this.jdField_b_of_type_Qhi.allowCoreThreadTimeOut(true);
      }
    }
    if (this.jdField_c_of_type_Qhi == null)
    {
      this.jdField_c_of_type_Qhi = new qgs(new LinkedBlockingQueue(128), this.jdField_c_of_type_Qdh);
      this.jdField_c_of_type_Qhi.a(this.jdField_a_of_type_JavaUtilConcurrentLinkedBlockingQueue, this.jdField_a_of_type_Qgw);
      if (Build.VERSION.SDK_INT > 8) {
        this.jdField_c_of_type_Qhi.allowCoreThreadTimeOut(true);
      }
    }
  }
  
  private boolean b(Job paramJob)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentLinkedBlockingQueue.iterator();
    while (localIterator.hasNext())
    {
      Job localJob = (Job)((WeakReference)localIterator.next()).get();
      if ((localJob != null) && (localJob.equals(paramJob))) {
        return true;
      }
    }
    return false;
  }
  
  private boolean c(Job paramJob)
  {
    Iterator localIterator = this.jdField_b_of_type_Qhi.getQueue().iterator();
    long l = SystemClock.uptimeMillis();
    while (localIterator.hasNext())
    {
      Job localJob = (Job)localIterator.next();
      localJob.e = (l - localJob.b);
      if ((paramJob.jdField_a_of_type_Int <= localJob.jdField_a_of_type_Int) && (localJob.e >= 5000L))
      {
        if (this.jdField_a_of_type_Qgw != null) {
          this.jdField_a_of_type_Qgw.b(localJob);
        }
        int i = this.jdField_b_of_type_Qhi.getCorePoolSize() + 1;
        if (i < 256) {
          this.jdField_b_of_type_Qhi.setCorePoolSize(i);
        }
      }
    }
    return false;
  }
  
  public HandlerThread a(String paramString, int paramInt)
  {
    return new HandlerThread(paramString, paramInt);
  }
  
  String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\n").append(this.jdField_a_of_type_Qhi.toString());
    localStringBuilder.append("\n").append(this.jdField_b_of_type_Qhi.toString());
    localStringBuilder.append("\n").append(this.jdField_c_of_type_Qhi.toString());
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentLinkedBlockingQueue.iterator();
    while (localIterator.hasNext())
    {
      Job localJob = (Job)((WeakReference)localIterator.next()).get();
      if (localJob != null) {
        localStringBuilder.append("\nrunning job: " + localJob.toString());
      }
    }
    return localStringBuilder.toString();
  }
  
  Thread a(Runnable paramRunnable, String paramString, int paramInt)
  {
    paramRunnable = new Thread(paramRunnable, paramString);
    paramRunnable.setPriority(paramInt);
    return paramRunnable;
  }
  
  Executor a(ThreadPoolParams paramThreadPoolParams)
  {
    ThreadPoolParams localThreadPoolParams = paramThreadPoolParams;
    if (paramThreadPoolParams == null) {
      localThreadPoolParams = new ThreadPoolParams();
    }
    paramThreadPoolParams = new qdh(localThreadPoolParams.jdField_a_of_type_JavaLangString, localThreadPoolParams.jdField_a_of_type_Int);
    paramThreadPoolParams = new qhi(localThreadPoolParams.b, localThreadPoolParams.jdField_c_of_type_Int, localThreadPoolParams.d, localThreadPoolParams.jdField_a_of_type_JavaUtilConcurrentBlockingQueue, paramThreadPoolParams);
    paramThreadPoolParams.a(this.jdField_a_of_type_JavaUtilConcurrentLinkedBlockingQueue, this.jdField_a_of_type_Qgw);
    if (Build.VERSION.SDK_INT > 8) {
      paramThreadPoolParams.allowCoreThreadTimeOut(true);
    }
    return paramThreadPoolParams;
  }
  
  void a() {}
  
  void a(int paramInt, Runnable paramRunnable, ThreadExcutor.IThreadListener paramIThreadListener, boolean paramBoolean)
  {
    if (paramRunnable == null) {
      throw new IllegalArgumentException();
    }
    paramRunnable = new qgu(this, paramInt, paramRunnable, paramIThreadListener, paramBoolean);
    jdField_a_of_type_MqqOsMqqHandler.post(paramRunnable);
  }
  
  void a(Runnable paramRunnable, ThreadExcutor.IThreadListener paramIThreadListener, boolean paramBoolean)
  {
    a(10, paramRunnable, paramIThreadListener, paramBoolean);
  }
  
  void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_b_of_type_Qhi.setMaximumPoolSize(Math.max(this.jdField_b_of_type_Qhi.getActiveCount(), this.jdField_b_of_type_Qhi.getCorePoolSize()));
      this.jdField_c_of_type_Qhi.setMaximumPoolSize(Math.max(this.jdField_c_of_type_Qhi.getActiveCount(), this.jdField_c_of_type_Qhi.getCorePoolSize()));
      return;
    }
    this.jdField_b_of_type_Qhi.setMaximumPoolSize(this.jdField_b_of_type_Qhi.a());
    this.jdField_c_of_type_Qhi.setMaximumPoolSize(this.jdField_c_of_type_Qhi.a());
  }
  
  boolean a(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      try
      {
        throw new IllegalArgumentException();
      }
      catch (Exception paramRunnable)
      {
        QLog.d("TM.global", 2, "remove task error happen!");
      }
    }
    do
    {
      do
      {
        return false;
        paramRunnable = a(paramRunnable);
        if (!b(paramRunnable)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("TM.global", 2, "cannot do it!-remove -in running queue");
      return false;
      if (a(paramRunnable))
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("TM.global", 2, "remove in Blocking queue successfully.");
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TM.global", 2, "remove in Blocking queue error.");
    return false;
    return true;
  }
  
  void b(int paramInt, Runnable paramRunnable, ThreadExcutor.IThreadListener paramIThreadListener, boolean paramBoolean)
  {
    if (paramRunnable == null) {
      throw new IllegalArgumentException();
    }
    paramRunnable = new qgv(this, paramInt, paramRunnable, paramIThreadListener, paramBoolean);
    jdField_a_of_type_MqqOsMqqHandler.post(paramRunnable);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\ThreadExcutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */