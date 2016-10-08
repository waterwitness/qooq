package com.tencent.mobileqq.vipav;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class VipFunCallObserver
  implements BusinessObserver
{
  public VipFunCallObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vipav\VipFunCallObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */