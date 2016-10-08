package com.tencent.mobileqq.shortvideo.tools;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class QzoneBaseThread
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  
  public QzoneBaseThread(String paramString)
  {
    this(paramString, 19);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public QzoneBaseThread(String paramString, int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread(paramString, paramInt);
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
  }
  
  public void a(Runnable paramRunnable)
  {
    a(paramRunnable, 0L);
  }
  
  public void a(Runnable paramRunnable, long paramLong)
  {
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(paramRunnable, paramLong);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandlerThread.setDaemon(paramBoolean);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_AndroidOsHandlerThread.isAlive();
  }
  
  public void b(Runnable paramRunnable)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(paramRunnable);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_AndroidOsHandlerThread.getState() == Thread.State.TERMINATED;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\tools\QzoneBaseThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */