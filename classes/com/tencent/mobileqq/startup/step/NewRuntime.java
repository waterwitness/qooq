package com.tencent.mobileqq.startup.step;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.dalvik.DalvikReplacer;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class NewRuntime
  extends Step
{
  private static final int jdField_a_of_type_Int = 16777216;
  public static long a = -1L;
  private static final boolean jdField_a_of_type_Boolean = true;
  
  protected boolean a()
  {
    b();
    if (BaseApplicationImpl.i == 1) {}
    for (;;)
    {
      try
      {
        if (new File(BaseApplicationImpl.getContext().getFilesDir(), "disableSmallLock").exists()) {
          continue;
        }
        bool = true;
        AppSetting.g = bool;
      }
      catch (Exception localException)
      {
        boolean bool;
        AppSetting.g = false;
        continue;
      }
      QLog.i("QQAppInterface", 1, "enableManagerSmallLock " + AppSetting.g);
      BaseApplicationImpl.a.doInit(false);
      if ((GuardManager.a == null) && ("com.tencent.mobileqq".equals(BaseApplicationImpl.processName))) {
        GuardManager.a = new GuardManager(BaseApplicationImpl.a, 0);
      }
      return true;
      bool = false;
    }
  }
  
  public boolean b()
  {
    if (DalvikReplacer.a(16777216))
    {
      a = 0L;
      try
      {
        long l = DalvikReplacer.a(BaseApplicationImpl.a, 16777216);
        if (QLog.isColorLevel()) {
          QLog.d("replaceDalvikMem", 2, "result=" + l);
        }
        a = l;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("replaceDalvikMem", 2, "exception:", localThrowable);
          }
        }
      }
      return false;
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\startup\step\NewRuntime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */