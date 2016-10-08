package com.tencent.mobileqq.qcall;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class LightalkSwitchObserver
  implements BusinessObserver
{
  public LightalkSwitchObserver()
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
      a(paramBoolean, ((Boolean)paramObject).booleanValue());
      return;
    }
    a(paramBoolean);
  }
  
  protected abstract void a(boolean paramBoolean);
  
  protected abstract void a(boolean paramBoolean1, boolean paramBoolean2);
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\qcall\LightalkSwitchObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */