package com.tencent.mobileqq.qipc;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.AppInterfaceFactory;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.ActivityLifecycle;
import com.tencent.qphone.base.util.QLog;
import cooperation.buscard.NFCActivityLifecycleCallback;
import eipc.EIPCClient;
import eipc.EIPCServer;
import java.util.ArrayList;
import mqq.app.MobileQQ;
import uak;

public class QIPCEnvironmentInit
{
  public static final NFCActivityLifecycleCallback sCallbac = new NFCActivityLifecycleCallback();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  static void initEnvironment()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIPCEnvironmentInit", 2, "initEnvironment");
    }
    try
    {
      if (TextUtils.equals(MobileQQ.processName, BaseApplicationImpl.a.getApplicationContext().getPackageName()))
      {
        QIPCServerHelper.getInstance().getServer().setModuleFactory(new uak());
        if (AppInterfaceFactory.a())
        {
          if (QLog.isColorLevel()) {
            QLog.d("QIPCEnvironmentInit", 2, "connectMainProc");
          }
          QIPCClientHelper.getInstance().getClient().connect(null);
        }
        if (QLog.isColorLevel()) {
          QLog.d("QIPCEnvironmentInit", 2, "registerNFCEventCallback");
        }
      }
    }
    catch (Exception localException1)
    {
      try
      {
        do
        {
          for (;;)
          {
            if ((!TextUtils.isEmpty(BaseApplicationImpl.processName)) && (!BaseApplicationImpl.processName.endsWith(":buscard"))) {
              ActivityLifecycle.registerNFCEventCallback(sCallbac);
            }
            return;
            QIPCClientHelper.getInstance().getClient().guardServerProcList.add(MobileQQ.sMobileQQ.getPackageName());
          }
          localException1 = localException1;
        } while (!QLog.isColorLevel());
        QLog.d("QIPCEnvironmentInit", 2, "initEnvironment", localException1);
      }
      catch (Exception localException2)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("QIPCEnvironmentInit", 2, "registerNFCEventCallback failed", localException2);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\qipc\QIPCEnvironmentInit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */