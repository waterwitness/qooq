package com.tencent.mobileqq.ark;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import qrx;

public class DispatchTask
{
  private static final String jdField_a_of_type_JavaLangString = "ark.DispatchTask";
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private Handler b;
  
  private DispatchTask()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.a("ArkAppThread", 0);
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
  }
  
  public static DispatchTask a()
  {
    return qrx.a;
  }
  
  public void a(Runnable paramRunnable)
  {
    if ((paramRunnable == null) || (this.jdField_a_of_type_AndroidOsHandler == null)) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(paramRunnable);
  }
  
  public boolean a()
  {
    return this.b.getLooper() == Looper.myLooper();
  }
  
  public void b(Runnable paramRunnable)
  {
    if ((paramRunnable == null) || (this.jdField_a_of_type_AndroidOsHandler == null)) {
      return;
    }
    if (b())
    {
      paramRunnable.run();
      return;
    }
    new DispatchTask.BlockingRunnable(paramRunnable).a(this.jdField_a_of_type_AndroidOsHandler);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_AndroidOsHandlerThread.getLooper() == Looper.myLooper();
  }
  
  public void c(Runnable paramRunnable)
  {
    if ((paramRunnable == null) || (this.b == null)) {
      return;
    }
    this.b.post(paramRunnable);
  }
  
  public void d(Runnable paramRunnable)
  {
    if ((paramRunnable == null) || (this.b == null)) {
      return;
    }
    if (a())
    {
      paramRunnable.run();
      return;
    }
    new DispatchTask.BlockingRunnable(paramRunnable).a(this.b);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\ark\DispatchTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */