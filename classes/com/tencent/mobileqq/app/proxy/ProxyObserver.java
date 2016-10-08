package com.tencent.mobileqq.app.proxy;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ProxyObserver
{
  public static final int a = -1;
  public static final int b = 1000;
  public static final int c = 1001;
  public static final int d = 2000;
  public static final int e = 2001;
  
  public ProxyObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1000: 
      a();
      return;
    }
    b();
  }
  
  public void b() {}
  
  public void c() {}
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\proxy\ProxyObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */