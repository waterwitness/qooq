import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.util.CommonUtil;
import com.tencent.open.business.base.StaticAnalyz;
import com.tencent.open.business.base.appreport.AppReportReceiver;
import com.tencent.open.downloadnew.YybHandleUtil;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class wuk
  implements Runnable
{
  public wuk(AppReportReceiver paramAppReportReceiver, Intent paramIntent, Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      String str1 = this.jdField_a_of_type_AndroidContentIntent.getAction();
      if (str1 == null) {
        return;
      }
      Object localObject3;
      boolean bool;
      if (str1.equals("com.tencent.process.exit"))
      {
        Object localObject1 = this.jdField_a_of_type_AndroidContentIntent.getExtras();
        if (localObject1 == null) {
          return;
        }
        localObject3 = ((Bundle)localObject1).getStringArrayList("procNameList");
        if ((!CommonUtil.a(((Bundle)localObject1).getString("verify"), (ArrayList)localObject3)) || (!CommonUtil.a((ArrayList)localObject3, BaseApplicationImpl.a()))) {
          return;
        }
        localObject1 = ((ActivityManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("activity")).getRunningTasks(1);
        if ((localObject1 != null) && (((List)localObject1).size() >= 1))
        {
          localObject1 = ((ActivityManager.RunningTaskInfo)((List)localObject1).get(0)).topActivity.getClassName();
          if (QLog.isColorLevel()) {
            QLog.d("AppReportReceiver", 2, "runningActivity=" + (String)localObject1);
          }
          if ((localObject1 != null) && (((String)localObject1).length() > 0) && ((((String)localObject1).contains("com.pay")) || (((String)localObject1).contains("com.tenpay")))) {
            return;
          }
        }
        bool = BrowserAppInterface.a.get();
        if (bool) {
          return;
        }
      }
      Object localObject2;
      String str2;
      return;
    }
    catch (Throwable localThrowable)
    {
      try
      {
        if (MsfServiceSdk.get() != null)
        {
          MsfServiceSdk.get().unRegisterMsfService();
          MsfServiceSdk.get().unbindMsfService();
        }
        if (!this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("qq_mode_foreground", false))
        {
          this.jdField_a_of_type_ComTencentOpenBusinessBaseAppreportAppReportReceiver.a();
          return;
          localThrowable = localThrowable;
          if (QLog.isColorLevel())
          {
            QLog.d("crash", 2, "", localThrowable);
            return;
            bool = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("android.intent.extra.REPLACING", false);
            localObject2 = this.jdField_a_of_type_AndroidContentIntent.getDataString();
            if ((localObject2 != null) && (((String)localObject2).startsWith("package:")))
            {
              str2 = ((String)localObject2).substring(8);
              localObject3 = "";
              localObject2 = localObject3;
              if (BaseApplicationImpl.a() != null)
              {
                localObject2 = localObject3;
                if (BaseApplicationImpl.a().getFirstSimpleAccount() != null) {
                  localObject2 = BaseApplicationImpl.a().getFirstSimpleAccount().getUin();
                }
              }
              if ((str1.equals("android.intent.action.PACKAGE_ADDED")) && (!bool))
              {
                if (str2.equals("com.tencent.mobileqq"))
                {
                  if (!QLog.isColorLevel()) {
                    return;
                  }
                  QLog.d("AppReportReceiver", 2, "mobileqq ACTION_PACKAGE_ADDED");
                  return;
                }
                bool = str2.equals("com.tencent.android.qqdownloader");
                if (!bool) {}
              }
              try
              {
                StaticAnalyz.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), (String)localObject2);
                do
                {
                  do
                  {
                    localObject2 = new IntentFilter();
                    ((IntentFilter)localObject2).addAction("com.tencent.process.exit");
                    BaseApplicationImpl.a().registerReceiver(this.jdField_a_of_type_ComTencentOpenBusinessBaseAppreportAppReportReceiver, (IntentFilter)localObject2);
                    if ((!BaseApplicationImpl.c) || (!QLog.isColorLevel())) {
                      return;
                    }
                    QLog.d("isFirstLaunch", 2, "firstlaunch!");
                    return;
                    if ((!str1.equals("android.intent.action.PACKAGE_REMOVED")) || (bool)) {
                      break;
                    }
                  } while (!str2.equals("com.tencent.mobileqq"));
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.d("AppReportReceiver", 2, "mobileqq ACTION_PACKAGE_REMOVED");
                  return;
                  if ((!str1.equals("android.intent.action.PACKAGE_REPLACED")) || (!bool)) {
                    break;
                  }
                } while (!str2.equals("com.tencent.mobileqq"));
                if (QLog.isColorLevel()) {
                  QLog.d("AppReportReceiver", 2, "mobileqq ACTION_PACKAGE_REPLACED deleteYYBApkPackage");
                }
                YybHandleUtil.a();
                return;
              }
              catch (Exception localException1)
              {
                for (;;) {}
              }
            }
          }
        }
      }
      catch (Exception localException2)
      {
        for (;;) {}
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\wuk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */