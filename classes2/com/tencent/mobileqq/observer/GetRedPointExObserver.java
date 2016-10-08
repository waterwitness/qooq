package com.tencent.mobileqq.observer;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class GetRedPointExObserver
  implements BusinessObserver
{
  public GetRedPointExObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a() {}
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((105 == paramInt) && (paramBoolean)) {
      a();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\observer\GetRedPointExObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */