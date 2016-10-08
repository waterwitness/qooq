package com.tencent.mobileqq.app;

import android.os.SystemClock;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

public class Job
  extends WeakReference
  implements Comparable, Runnable
{
  private static final String jdField_b_of_type_JavaLangString = "Job";
  public int a;
  public long a;
  public ThreadExcutor.IThreadListener a;
  public Runnable a;
  public String a;
  private boolean a;
  public int b;
  public long b;
  private boolean jdField_b_of_type_Boolean;
  public long c;
  private boolean c;
  public long d;
  private boolean d;
  public long e;
  public long f;
  
  public Job(Object paramObject, Runnable paramRunnable, boolean paramBoolean)
  {
    super(paramObject);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_c_of_type_Long = -1L;
    this.jdField_d_of_type_Long = -1L;
    this.jdField_c_of_type_Boolean = true;
    this.e = -1L;
    this.f = -1L;
    this.jdField_b_of_type_Int = -1;
    if (paramObject != null) {
      this.jdField_b_of_type_Boolean = true;
    }
    this.jdField_a_of_type_JavaLangRunnable = paramRunnable;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  Job(Object paramObject, String paramString, int paramInt, Runnable paramRunnable, ThreadExcutor.IThreadListener paramIThreadListener, boolean paramBoolean)
  {
    super(paramObject);
    this.jdField_c_of_type_Long = -1L;
    this.jdField_d_of_type_Long = -1L;
    this.jdField_c_of_type_Boolean = true;
    this.e = -1L;
    this.f = -1L;
    this.jdField_b_of_type_Int = -1;
    if (paramObject != null) {
      this.jdField_b_of_type_Boolean = true;
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangRunnable = paramRunnable;
    this.jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener = paramIThreadListener;
    this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int a(Job paramJob)
  {
    if (this.jdField_a_of_type_Int == paramJob.jdField_a_of_type_Int) {
      return 0;
    }
    if (this.jdField_a_of_type_Int > paramJob.jdField_a_of_type_Int) {
      return -1;
    }
    return 1;
  }
  
  public boolean a()
  {
    Object localObject;
    if (this.jdField_a_of_type_Boolean) {
      if (this.jdField_b_of_type_Boolean)
      {
        localObject = get();
        if (localObject == null) {}
      }
    }
    for (;;)
    {
      try
      {
        Field localField = this.jdField_a_of_type_JavaLangRunnable.getClass().getDeclaredField("this$0");
        localField.setAccessible(true);
        localField.set(this.jdField_a_of_type_JavaLangRunnable, localObject);
        this.jdField_c_of_type_Boolean = true;
        this.jdField_d_of_type_Boolean = true;
        return this.jdField_c_of_type_Boolean;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        this.jdField_c_of_type_Boolean = false;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Job", 2, this.jdField_a_of_type_JavaLangString + localNoSuchFieldException + "shouldRun is false");
        continue;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        this.jdField_c_of_type_Boolean = false;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Job", 2, this.jdField_a_of_type_JavaLangString + localIllegalArgumentException + "shouldRun is false");
        continue;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        this.jdField_c_of_type_Boolean = false;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Job", 2, this.jdField_a_of_type_JavaLangString + localIllegalAccessException + "shouldRun is false");
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Job", 2, this.jdField_a_of_type_JavaLangString + " never run, becuse outer object is retrieve already");
      }
      this.jdField_c_of_type_Boolean = false;
      continue;
      this.jdField_c_of_type_Boolean = true;
      continue;
      this.jdField_c_of_type_Boolean = true;
    }
  }
  
  public boolean b()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void clear() {}
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (Job)paramObject;
        if (this.jdField_a_of_type_JavaLangRunnable != null) {
          break;
        }
      } while (((Job)paramObject).jdField_a_of_type_JavaLangRunnable == null);
      return false;
    } while (this.jdField_a_of_type_JavaLangRunnable.equals(((Job)paramObject).jdField_a_of_type_JavaLangRunnable));
    return false;
  }
  
  public int hashCode()
  {
    if (this.jdField_a_of_type_JavaLangRunnable == null) {}
    for (int i = 0;; i = this.jdField_a_of_type_JavaLangRunnable.hashCode()) {
      return i + 31;
    }
  }
  
  public void run()
  {
    a();
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_d_of_type_Long = (SystemClock.uptimeMillis() - this.jdField_b_of_type_Long);
      if (this.jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener.b();
      }
      this.jdField_a_of_type_JavaLangRunnable.run();
      this.jdField_c_of_type_Long = (SystemClock.uptimeMillis() - this.jdField_b_of_type_Long);
      if (this.jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener.c();
      }
      if (((ThreadManager.jdField_b_of_type_Boolean) || (ThreadManager.jdField_a_of_type_Boolean)) && (QLog.isColorLevel())) {
        QLog.d("AutoMonitor", 4, "globalBgTask," + toString());
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("Job", 2, this.jdField_a_of_type_JavaLangString + " is recycled");
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(256);
    localStringBuilder.append(" cost=").append(this.jdField_c_of_type_Long).append(", ").append(this.jdField_a_of_type_JavaLangString).append("|pool-").append(this.jdField_b_of_type_Int).append("|t-id=").append(this.jdField_a_of_type_Long).append("|priority=").append(this.jdField_a_of_type_Int).append("|wait=").append(this.jdField_d_of_type_Long).append("|postCost=").append(this.f);
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\Job.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */