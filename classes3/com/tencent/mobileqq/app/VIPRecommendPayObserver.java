package com.tencent.mobileqq.app;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class VIPRecommendPayObserver
  implements BusinessObserver
{
  public VIPRecommendPayObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\VIPRecommendPayObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */