package com.tencent.mobileqq.troop.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class RadaScanView$WorkHandler
  extends Handler
{
  public RadaScanView$WorkHandler(RadaScanView paramRadaScanView, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    this.a.a();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\widget\RadaScanView$WorkHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */