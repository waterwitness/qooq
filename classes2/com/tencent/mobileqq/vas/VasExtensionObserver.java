package com.tencent.mobileqq.vas;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class VasExtensionObserver
  implements BusinessObserver
{
  public VasExtensionObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    case 4: 
    default: 
      return;
    case 1: 
      b(paramBoolean, paramObject);
      return;
    case 3: 
      e(paramBoolean, paramObject);
      return;
    case 5: 
      a(paramBoolean, paramObject);
      return;
    case 2: 
      f(paramBoolean, paramObject);
      return;
    case 6: 
      d(paramBoolean, paramObject);
      return;
    case 7: 
      c(paramBoolean, paramObject);
      return;
    case 8: 
      h(paramBoolean, paramObject);
      return;
    }
    g(paramBoolean, paramObject);
  }
  
  protected void a(boolean paramBoolean, Object paramObject) {}
  
  protected void b(boolean paramBoolean, Object paramObject) {}
  
  protected void c(boolean paramBoolean, Object paramObject) {}
  
  protected void d(boolean paramBoolean, Object paramObject) {}
  
  protected void e(boolean paramBoolean, Object paramObject) {}
  
  protected void f(boolean paramBoolean, Object paramObject) {}
  
  protected void g(boolean paramBoolean, Object paramObject) {}
  
  protected void h(boolean paramBoolean, Object paramObject) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vas\VasExtensionObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */