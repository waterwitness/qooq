package com.tencent.mobileqq.msf.core.net.b;

import com.tencent.qphone.base.util.QLog;

class l
  implements a.a
{
  l(j paramj) {}
  
  public void a(int paramInt1, int paramInt2, String paramString, Object paramObject)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.length() > 10) {
        str = paramString.substring(0, 10);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("WifiDetector", 2, "WIFI detect onEchoResult, taskId: " + paramInt1 + " result: " + paramInt2 + " actualContent: " + str);
    }
    paramInt2 = j.a(this.a, paramInt2);
    j.a(this.a, paramInt2, (String)paramObject);
    j.b(this.a, 1 << paramInt1);
    if (j.a(this.a) == 0) {
      this.a.d();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\core\net\b\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */