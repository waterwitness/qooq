package com.tencent.mobileqq.app;

import MQQ.VipUserInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class VipInfoObserver
  implements BusinessObserver
{
  public VipInfoObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipInfoObserver", 2, "onUpdate-isSuccess:" + paramBoolean);
    }
    if (paramInt == VipInfoHandler.a)
    {
      int i = -1;
      paramInt = i;
      if (paramBoolean)
      {
        paramObject = (VipUserInfo)paramObject;
        paramInt = i;
        if (paramObject != null) {
          paramInt = ((VipUserInfo)paramObject).iGrowthValue;
        }
      }
      a(paramBoolean, paramInt);
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\VipInfoObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */