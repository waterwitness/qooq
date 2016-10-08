package com.tencent.mobileqq.app;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class AutomatorObserver
  implements BusinessObserver
{
  public static final int a = 0;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  public static final int e = 1;
  public static final int f = 2;
  public static final int g = 3;
  
  public AutomatorObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a() {}
  
  protected void a(int paramInt) {}
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return;
    case 0: 
      a(paramBoolean, paramObject);
      return;
    case 2: 
      b();
      return;
    case 3: 
      a(((Integer)paramObject).intValue());
      return;
    }
    a();
  }
  
  protected void a(boolean paramBoolean, Object paramObject) {}
  
  protected void b() {}
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\AutomatorObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */