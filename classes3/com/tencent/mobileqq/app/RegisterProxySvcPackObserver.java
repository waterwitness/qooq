package com.tencent.mobileqq.app;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class RegisterProxySvcPackObserver
  implements BusinessObserver
{
  public RegisterProxySvcPackObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(int paramInt1, int paramInt2) {}
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
    } while (paramObject == null);
    paramObject = (Object[])paramObject;
    a(((Integer)paramObject[0]).intValue(), ((Integer)paramObject[1]).intValue());
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\RegisterProxySvcPackObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */