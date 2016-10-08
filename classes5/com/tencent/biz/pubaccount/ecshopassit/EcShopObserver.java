package com.tencent.biz.pubaccount.ecshopassit;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class EcShopObserver
  implements BusinessObserver
{
  public EcShopObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      a(paramBoolean, paramObject);
      return;
    case 1: 
      b(paramBoolean, paramObject);
      return;
    case 2: 
      c(paramBoolean, paramObject);
      return;
    case 3: 
      g(paramBoolean, paramObject);
      return;
    case 4: 
      d(paramBoolean, paramObject);
      return;
    case 5: 
      e(paramBoolean, paramObject);
      return;
    }
    f(paramBoolean, paramObject);
  }
  
  protected void a(boolean paramBoolean, Object paramObject) {}
  
  protected void b(boolean paramBoolean, Object paramObject) {}
  
  protected void c(boolean paramBoolean, Object paramObject) {}
  
  protected void d(boolean paramBoolean, Object paramObject) {}
  
  protected void e(boolean paramBoolean, Object paramObject) {}
  
  protected void f(boolean paramBoolean, Object paramObject) {}
  
  protected void g(boolean paramBoolean, Object paramObject) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\ecshopassit\EcShopObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */