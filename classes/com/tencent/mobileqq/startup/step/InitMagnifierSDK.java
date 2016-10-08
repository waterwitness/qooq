package com.tencent.mobileqq.startup.step;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mfsdk.LeakInspector.LeakInspector.InspectUUID;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.memory.MemoryReporter;
import utn;

public class InitMagnifierSDK
  extends Step
{
  public static final String a = "LeakInspector";
  
  private static boolean b(LeakInspector.InspectUUID paramInspectUUID)
  {
    MemoryReporter.a().a(paramInspectUUID.a);
    if (!AppSetting.k) {}
    return false;
  }
  
  protected boolean a()
  {
    MagnifierSDK localMagnifierSDK = MagnifierSDK.a(ThreadManager.b(), 1, "V 6.5.5.2880");
    localMagnifierSDK.a(new utn());
    localMagnifierSDK.a(BaseApplicationImpl.a());
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\startup\step\InitMagnifierSDK.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */