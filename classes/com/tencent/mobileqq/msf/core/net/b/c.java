package com.tencent.mobileqq.msf.core.net.b;

import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class c
{
  private static final String a = "NetworkToolsHelper";
  private static AtomicBoolean b = new AtomicBoolean(false);
  
  public static g.a a(String paramString)
  {
    if (b.compareAndSet(false, true))
    {
      paramString = new g(paramString, true).a();
      b.set(false);
      return paramString;
    }
    QLog.d("NetworkToolsHelper", 1, "Stop traceroute host: " + paramString + " by another task running");
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\core\net\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */