package com.tencent.mobileqq.jsp;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class SmsApiPlugin$MyHandler
  extends Handler
{
  SmsApiPlugin a;
  
  protected SmsApiPlugin$MyHandler(SmsApiPlugin paramSmsApiPlugin)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramSmsApiPlugin;
  }
  
  protected void a()
  {
    this.a = null;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a == null) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      paramMessage = (String)paramMessage.obj;
      this.a.a(paramMessage);
      return;
    }
    this.a.a();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\jsp\SmsApiPlugin$MyHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */