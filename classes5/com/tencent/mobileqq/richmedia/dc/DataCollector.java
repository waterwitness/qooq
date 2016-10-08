package com.tencent.mobileqq.richmedia.dc;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import ugx;

public class DataCollector
{
  private static HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  public static String a_;
  Handler jdField_a_of_type_AndroidOsHandler = new ugx(this, jdField_a_of_type_AndroidOsHandlerThread.getLooper());
  public boolean a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    a_ = "DataCollector";
    jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("Colloector-Tasker");
    jdField_a_of_type_AndroidOsHandlerThread.start();
  }
  
  public DataCollector(Context paramContext)
  {
    this.jdField_a_of_type_Boolean = true;
    a_ = getClass().getSimpleName();
  }
  
  static Looper a()
  {
    return jdField_a_of_type_AndroidOsHandlerThread.getLooper();
  }
  
  public Handler a()
  {
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public void a(Message paramMessage) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\richmedia\dc\DataCollector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */