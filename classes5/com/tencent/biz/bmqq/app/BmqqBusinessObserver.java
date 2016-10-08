package com.tencent.biz.bmqq.app;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.BmqqUserSimpleInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class BmqqBusinessObserver
  implements BusinessObserver
{
  public BmqqBusinessObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    a(paramBoolean, (BmqqUserSimpleInfo)paramObject);
  }
  
  protected void a(boolean paramBoolean, BmqqUserSimpleInfo paramBmqqUserSimpleInfo) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\bmqq\app\BmqqBusinessObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */