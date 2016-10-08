package com.tencent.mobileqq.qipc;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class QIPCClientModuleCore
  extends QIPCModule
{
  public static final String ACTION_IS_MODULE_RUNNING = "isrun";
  public static final String NAME = "QIPCClientModuleCore";
  public static final String PARAM_KEY_MODULEID = "module_id";
  
  public QIPCClientModuleCore()
  {
    super("QIPCClientModuleCore");
  }
  
  public EIPCResult isModuleRunning(String paramString, Bundle paramBundle)
  {
    try
    {
      paramString = paramBundle.getString("module_id");
      bool = MobileQQ.sMobileQQ.waitAppRuntime(null).isModuleRunning(paramString);
      if (bool) {
        return EIPCResult.createSuccessResult(null);
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        boolean bool = false;
      }
    }
    return EIPCResult.createResult(-102, null);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.name, 2, "action = " + paramString + ", params = " + paramBundle);
    }
    if (TextUtils.equals(paramString, "isrun")) {
      return isModuleRunning(paramString, paramBundle);
    }
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\qipc\QIPCClientModuleCore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */