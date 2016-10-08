package com.tencent.mobileqq.pluginsdk.exception;

import com.tencent.qphone.base.util.QLog;

final class a
  implements Runnable
{
  a(String paramString, Exception paramException) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.e(this.a, 2, "ExceptinTracker", this.b);
    }
    throw new IllegalArgumentException(this.b);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\pluginsdk\exception\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */