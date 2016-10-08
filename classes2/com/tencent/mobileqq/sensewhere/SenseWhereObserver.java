package com.tencent.mobileqq.sensewhere;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class SenseWhereObserver
  implements BusinessObserver
{
  public SenseWhereObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\sensewhere\SenseWhereObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */