package com.tencent.mobileqq.app;

import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.pool.RecyclablePool;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.os.MqqHandler;
import mqq.os.MqqRegulatorCallback;
import qhg;
import qhh;

public class ThreadRegulator
  implements MqqRegulatorCallback
{
  public static final int a = 1;
  private static ThreadRegulator jdField_a_of_type_ComTencentMobileqqAppThreadRegulator;
  private static final String jdField_a_of_type_JavaLangString = "ThreadManager.Regulaotr";
  private static final boolean jdField_a_of_type_Boolean = false;
  public static final int b = 2;
  public static final int c = 3;
  private final RecyclablePool jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool;
  private volatile ThreadRegulator.CpuBusyness jdField_a_of_type_ComTencentMobileqqAppThreadRegulator$CpuBusyness;
  Runnable jdField_a_of_type_JavaLangRunnable;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  
  public ThreadRegulator()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool = new RecyclablePool(ThreadRegulator.CpuBusyness.class, 2);
    this.jdField_a_of_type_MqqOsMqqHandler = new qhg(this, ThreadManager.b());
    this.jdField_a_of_type_JavaLangRunnable = new qhh(this);
  }
  
  public static ThreadRegulator a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqAppThreadRegulator == null) {
        jdField_a_of_type_ComTencentMobileqqAppThreadRegulator = new ThreadRegulator();
      }
      ThreadRegulator localThreadRegulator = jdField_a_of_type_ComTencentMobileqqAppThreadRegulator;
      return localThreadRegulator;
    }
    finally {}
  }
  
  public void a()
  {
    MqqHandler.sRegulatorCallback = this;
    mqq.app.MainService.sRegulatorCallback = this;
  }
  
  public void a(int paramInt)
  {
    if (!ThreadOptimizer.a().a()) {}
    while (this.jdField_a_of_type_ComTencentMobileqqAppThreadRegulator$CpuBusyness != null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppThreadRegulator$CpuBusyness = ((ThreadRegulator.CpuBusyness)this.jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool.obtain(ThreadRegulator.CpuBusyness.class));
    this.jdField_a_of_type_ComTencentMobileqqAppThreadRegulator$CpuBusyness.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppThreadRegulator$CpuBusyness.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    ThreadExcutor.a().a(true);
  }
  
  public void a(int paramInt, long paramLong)
  {
    if (paramLong == 0L)
    {
      this.jdField_a_of_type_JavaLangRunnable.run();
      return;
    }
    BaseApplicationImpl.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, paramLong);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppThreadRegulator$CpuBusyness == null) {
      return;
    }
    while (this.jdField_a_of_type_ComTencentMobileqqAppThreadRegulator$CpuBusyness != null) {
      try
      {
        Thread.sleep(100L);
      }
      catch (InterruptedException localInterruptedException) {}
    }
  }
  
  public void b(int paramInt)
  {
    a(paramInt, 0L);
  }
  
  public void checkInRegulatorMsg()
  {
    b();
  }
  
  public boolean regulatorThread(Thread paramThread)
  {
    if ((paramThread == ThreadManager.a()) || (paramThread == ThreadManager.b())) {}
    do
    {
      do
      {
        return true;
        if (!"MSF-Receiver".equals(paramThread.getName())) {
          break;
        }
      } while (!ThreadOptimizer.a().b());
      paramThread.setPriority(1);
      return true;
    } while ("Rejected_Handler".equals(paramThread.getName()));
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\ThreadRegulator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */