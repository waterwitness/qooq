package com.tencent.common.app;

import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import mqq.app.AppRuntime;

public class ToolRuntimePeak
  extends ToolRuntimeBase
{
  public static final String a = ToolAppRuntime.class.getSimpleName();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public AppRuntime onGetSubRuntime(String paramString)
  {
    Object localObject = null;
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.a();
    if ("peak".equals(paramString)) {
      localObject = new PeakAppInterface(localBaseApplicationImpl, "peak");
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i(a, 2, "ToolRuntimePeak.onGetSubRuntime() moduleId " + paramString + " appInstance = " + localObject);
      }
      return (AppRuntime)localObject;
      if ("Photoplus.apk".equals(paramString)) {
        localObject = QZoneHelper.a(localBaseApplicationImpl);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\common\app\ToolRuntimePeak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */