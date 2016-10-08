package com.tencent.mobileqq.app.automator;

import android.os.Process;
import android.os.SystemClock;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.TraceUtils;

public class AsyncStep
  implements Runnable
{
  public static final int a = 2;
  protected static final long a = 30000L;
  protected static final String a = "QQInitHandler";
  public static final int b = 4;
  public static final int c = 5;
  public static final int d = 6;
  public static final int e = 7;
  public static final int f = 8;
  private static final int j = 1;
  private static final int k = 3;
  protected Automator a;
  protected IResultListener a;
  private Object a;
  protected long b;
  protected String b;
  protected volatile int g;
  protected int h;
  protected int i;
  
  public AsyncStep()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.g = 1;
    this.jdField_b_of_type_Long = 30000L;
    this.h = -1;
    this.jdField_a_of_type_JavaLangObject = new Object();
  }
  
  private boolean a()
  {
    for (;;)
    {
      int m;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        m = this.g;
        if (m != 2) {}
      }
      try
      {
        this.jdField_a_of_type_JavaLangObject.wait(this.jdField_b_of_type_Long);
        if (QLog.isColorLevel()) {
          QLog.d("QQInitHandler", 2, this.jdField_b_of_type_JavaLangString + " waitResult " + this.g + " " + this.i);
        }
        if (this.g == 3)
        {
          this.g = 2;
          continue;
          localObject2 = finally;
          throw ((Throwable)localObject2);
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
        }
        if (this.g == 2)
        {
          this.g = 5;
          Automator localAutomator = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator;
          localAutomator.e += 1;
        }
        if ((this.g == 6) || (this.g == 5))
        {
          m = this.i;
          this.i = (m - 1);
          if (m > 0)
          {
            this.g = 1;
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public int a()
  {
    if (QLog.isColorLevel()) {
      QLog.e("QQInitHandler", 2, this.jdField_b_of_type_JavaLangString + " AsyncStep.doStep()");
    }
    return 7;
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, this.jdField_b_of_type_JavaLangString + " setResult " + paramInt + ", when " + this.g);
    }
    if (paramInt == 6)
    {
      ??? = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator;
      ((Automator)???).e += 1;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((paramInt > this.g) && (paramInt != 4)) {
        this.g = paramInt;
      }
      this.jdField_a_of_type_JavaLangObject.notifyAll();
      return;
    }
  }
  
  public final void a(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder(64);
      ((StringBuilder)???).append(this.jdField_b_of_type_JavaLangString);
      ((StringBuilder)???).append(" updateTimeout ");
      ((StringBuilder)???).append(paramLong);
      ((StringBuilder)???).append(", when ");
      ((StringBuilder)???).append(this.g);
      QLog.d("QQInitHandler", 2, ((StringBuilder)???).toString());
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.g == 2) {
        this.g = 3;
      }
      this.jdField_b_of_type_Long = paramLong;
      this.jdField_a_of_type_JavaLangObject.notifyAll();
      return;
    }
  }
  
  public void b() {}
  
  public final void run()
  {
    long l;
    if (this.g == 1)
    {
      l = 0L;
      TraceUtils.a(4096L, this.jdField_b_of_type_JavaLangString, Process.myTid());
      if (QLog.isColorLevel())
      {
        l = SystemClock.uptimeMillis();
        QLog.d("QQInitHandler", 2, this.jdField_b_of_type_JavaLangString + " begin with " + this.g);
      }
    }
    try
    {
      a();
      do
      {
        a(a());
      } while (a());
      b();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQInitHandler", 1, "", localThrowable);
      a(8);
      return;
    }
    finally
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, this.jdField_b_of_type_JavaLangString + " cost: " + (SystemClock.uptimeMillis() - l));
      }
      TraceUtils.b(4096L, this.jdField_b_of_type_JavaLangString, Process.myTid());
      if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorIResultListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorIResultListener.a(this, this.g);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\automator\AsyncStep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */