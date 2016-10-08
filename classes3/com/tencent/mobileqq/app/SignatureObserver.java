package com.tencent.mobileqq.app;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class SignatureObserver
  implements BusinessObserver
{
  public SignatureObserver()
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
    case 7: 
      b(paramBoolean, paramObject);
      return;
    case 5: 
      c(paramBoolean, paramObject);
      return;
    case 6: 
      a(paramBoolean, paramObject);
      return;
    }
    d(paramBoolean, paramObject);
  }
  
  protected void a(boolean paramBoolean, Object paramObject) {}
  
  protected void b(boolean paramBoolean, Object paramObject) {}
  
  protected void c(boolean paramBoolean, Object paramObject) {}
  
  protected void d(boolean paramBoolean, Object paramObject) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\SignatureObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */