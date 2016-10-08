package com.tencent.qqprotect.singleupdate;

import android.app.KeyguardManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Date;

public class QPCheckCanRestartThread
  extends Thread
{
  final int jdField_a_of_type_Int;
  KeyguardManager jdField_a_of_type_AndroidAppKeyguardManager;
  Date jdField_a_of_type_JavaUtilDate;
  boolean jdField_a_of_type_Boolean;
  Date b;
  
  public QPCheckCanRestartThread()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilDate = null;
    this.b = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidAppKeyguardManager = null;
    this.jdField_a_of_type_Int = 300;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidAppKeyguardManager != null) && (this.jdField_a_of_type_AndroidAppKeyguardManager.inKeyguardRestrictedInputMode());
  }
  
  public void run()
  {
    super.run();
    this.jdField_a_of_type_AndroidAppKeyguardManager = ((KeyguardManager)BaseApplication.getContext().getSystemService("keyguard"));
    if (this.jdField_a_of_type_AndroidAppKeyguardManager.inKeyguardRestrictedInputMode()) {
      if (this.jdField_a_of_type_JavaUtilDate == null) {
        this.jdField_a_of_type_JavaUtilDate = new Date();
      }
    }
    for (;;)
    {
      try
      {
        Thread.sleep(300L);
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
      break;
      this.b = new Date();
      if ((this.b.getTime() - this.jdField_a_of_type_JavaUtilDate.getTime()) / 1000L >= 300L)
      {
        this.jdField_a_of_type_Boolean = true;
        continue;
        this.jdField_a_of_type_JavaUtilDate = null;
        this.b = null;
        this.jdField_a_of_type_Boolean = false;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\qqprotect\singleupdate\QPCheckCanRestartThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */