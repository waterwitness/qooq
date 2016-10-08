package com.tencent.device.devicemgr;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public class SmartDeviceObserver
  implements BusinessObserver
{
  public SmartDeviceObserver()
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
    a((ArrayList)paramObject);
  }
  
  protected void a(ArrayList paramArrayList) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\device\devicemgr\SmartDeviceObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */