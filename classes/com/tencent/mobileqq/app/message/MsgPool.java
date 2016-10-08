package com.tencent.mobileqq.app.message;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class MsgPool
{
  private static final String a = "null";
  private static ConcurrentHashMap d = new ConcurrentHashMap();
  protected ConcurrentHashMap a = new ConcurrentHashMap();
  private ConcurrentHashMap b = new ConcurrentHashMap();
  private ConcurrentHashMap c = new ConcurrentHashMap();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static MsgPool a(String arg0)
  {
    String str = ???;
    if (??? == null)
    {
      ??? = "null";
      str = ???;
      if (QLog.isColorLevel())
      {
        QLog.e("MsgPool", 2, "getPoolInstance curUin is null");
        str = ???;
      }
    }
    if (!d.containsKey(str)) {}
    synchronized (d)
    {
      if (!d.containsKey(str)) {
        d.put(str, new MsgPool());
      }
      return (MsgPool)d.get(str);
    }
  }
  
  public static void a(String paramString)
  {
    String str = paramString;
    if (paramString == null)
    {
      paramString = "null";
      str = paramString;
      if (QLog.isColorLevel())
      {
        QLog.e("MsgPool", 2, "getPoolInstance curUin is null");
        str = paramString;
      }
    }
    if (d.containsKey(str)) {
      d.remove(str);
    }
  }
  
  public Object a(String arg1, int paramInt)
  {
    String str = MsgProxyUtils.a(???, paramInt);
    if (!this.a.containsKey(str)) {}
    synchronized (this.a)
    {
      if (!this.a.containsKey(str)) {
        this.a.put(str, new Object());
      }
      return this.a.get(str);
    }
  }
  
  public ConcurrentHashMap a()
  {
    return this.b;
  }
  
  public ConcurrentHashMap b()
  {
    return this.c;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\message\MsgPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */