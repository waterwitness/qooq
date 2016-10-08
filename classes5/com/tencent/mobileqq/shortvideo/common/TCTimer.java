package com.tencent.mobileqq.shortvideo.common;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.mediadevice.Lock;

public class TCTimer
  implements Handler.Callback
{
  public static final int a = 40;
  private static final int b = 1398036036;
  private Handler jdField_a_of_type_AndroidOsHandler;
  public HandlerThread a;
  private TCTimer.TCTimerCallback jdField_a_of_type_ComTencentMobileqqShortvideoCommonTCTimer$TCTimerCallback;
  private int c;
  private int d;
  private int e;
  
  public TCTimer(int paramInt1, int paramInt2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.c = (1000 / paramInt1);
    this.d = ((int)(paramInt2 / 1000.0F * paramInt1) + 1);
    this.e = 0;
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("shortvideo_Timer");
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
  }
  
  private boolean a(Message paramMessage)
  {
    if (Lock.a) {
      if (this.e < this.d) {
        break label85;
      }
    }
    label85:
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        this.e = this.d;
      }
      int i = this.e;
      int j = this.c;
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonTCTimer$TCTimerCallback != null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonTCTimer$TCTimerCallback.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonTCTimer$TCTimerCallback, bool, i * j, this.e);
      }
      this.e += 1;
      return true;
    }
  }
  
  public int a()
  {
    return this.c;
  }
  
  public int a(int paramInt)
  {
    return this.c * paramInt;
  }
  
  public void a()
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1398036036);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, this.c);
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void a(TCTimer.TCTimerCallback paramTCTimerCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonTCTimer$TCTimerCallback = paramTCTimerCallback;
  }
  
  public int b(int paramInt)
  {
    return paramInt / this.c;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread.quit();
  }
  
  public void b(int paramInt)
  {
    this.e = (paramInt / this.c);
  }
  
  public void c()
  {
    this.e = 0;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1398036036);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, this.c);
    }
    return a(paramMessage);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\common\TCTimer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */