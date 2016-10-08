package com.tencent.mobileqq.app;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class RedTouchObserver
  implements BusinessObserver
{
  public RedTouchObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return;
    }
    a(paramBoolean, paramObject);
  }
  
  public void a(boolean paramBoolean, Object paramObject) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\RedTouchObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */