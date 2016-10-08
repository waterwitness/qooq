package com.tencent.arrange.op;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ArrangeObserver
  implements BusinessObserver
{
  public ArrangeObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\arrange\op\ArrangeObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */