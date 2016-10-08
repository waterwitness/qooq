package com.tencent.mobileqq.qcall;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class LightalkShieldObserver
  implements BusinessObserver
{
  public LightalkShieldObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      a(paramBoolean, ((Integer)paramObject).intValue());
      return;
    case 2: 
      b(paramBoolean, ((Integer)paramObject).intValue());
      return;
    case 3: 
      if (paramBoolean)
      {
        a(paramBoolean, ((Boolean)paramObject).booleanValue());
        return;
      }
      a(paramBoolean, false);
      return;
    }
    a(paramBoolean);
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void b(boolean paramBoolean, int paramInt) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\qcall\LightalkShieldObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */