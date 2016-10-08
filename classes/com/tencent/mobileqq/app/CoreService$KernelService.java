package com.tencent.mobileqq.app;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.RemoteViews;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class CoreService$KernelService
  extends Service
{
  private static Notification a()
  {
    Notification localNotification = new Notification();
    localNotification.icon = 2130838592;
    localNotification.contentView = new RemoteViews(BaseApplicationImpl.a.getPackageName(), 2130903505);
    return localNotification;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("k_start_mode", 2);
    BaseApplicationImpl.a.onActivityCreate(this, localIntent);
    super.onCreate();
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager", 2, "TempService.onCreate");
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager", 2, "TempService.onDestroy");
    }
    try
    {
      super.stopForeground(true);
      super.onDestroy();
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if ((paramIntent != null) && (CoreService.jdField_a_of_type_ComTencentMobileqqAppCoreService != null)) {
      if (QLog.isColorLevel()) {
        QLog.d("GuardManager", 2, "onStartCommand:");
      }
    }
    try
    {
      CoreService.jdField_a_of_type_ComTencentMobileqqAppCoreService.startForeground(CoreService.jdField_a_of_type_Int, a());
      super.startForeground(CoreService.jdField_a_of_type_Int, a());
      CoreService.jdField_a_of_type_ComTencentMobileqqAppCoreService.stopForeground(true);
      return 2;
    }
    catch (Exception paramIntent)
    {
      QLog.d("GuardManager", 1, "", paramIntent);
    }
    return 2;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\CoreService$KernelService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */