package com.tencent.mobileqq.startup.step;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;

public class Step$QIPCConnectStep
{
  public static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIPCEnvironmentInit", 2, "tryConnect");
    }
    try
    {
      Method localMethod = BaseApplicationImpl.a.getClassLoader().loadClass("com.tencent.mobileqq.qipc.QIPCEnvironmentInit").getDeclaredMethod("initEnvironment", new Class[0]);
      localMethod.setAccessible(true);
      localMethod.invoke(null, new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("QIPCEnvironmentInit", 2, "tryConnect", localException);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\startup\step\Step$QIPCConnectStep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */