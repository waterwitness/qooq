package com.tencent.qphone.base.util;

import android.app.Application;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mobileqq.msf.sdk.utils.MonitorSocketImplFactory;
import com.tencent.mobileqq.msf.sdk.utils.MonitorSocketStat;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.Socket;
import java.net.SocketImplFactory;
import java.util.ArrayList;
import java.util.Properties;

public abstract class BaseApplication
  extends Application
{
  public static final String DATA_KEY_CHANNEL_ID = "channel_id";
  public static int appnewavmsgicon;
  public static int appnewmsgicon;
  static BaseApplication context;
  public static int defaultNotifSoundResourceId;
  public static int devlockQuickloginIcon;
  public static ArrayList exclusiveStreamList = new ArrayList();
  public static MonitorSocketStat monitor;
  public static int qqWifiConnecticon3;
  public static int qqWifiLayout;
  public static int qqWifiMissions;
  public static int qqWifiNoSignal;
  public static int qqWifiOperation;
  public static int qqWifiOperationTextViewId;
  public static int qqWifiRedTouchViewId;
  public static int qqWifiSettingViewId;
  public static int qqWifiSettings;
  public static int qqWifiStateIconViewId;
  public static int qqWifiStateTextSingleLine;
  public static int qqWifiStateTextViewId;
  public static int qqWifiTextDoubleLine;
  public static int qqWifiUserful;
  public static int qqlaunchicon;
  public static int qqwifinotifyconnectedicon;
  public static int qqwifinotifydivide;
  public static int qqwifinotifynoneicon;
  public static int qqwifinotifyusefulicon;
  
  public static final void addServerSocket(String paramString)
  {
    MonitorSocketImplFactory.addServerSocket(paramString);
  }
  
  public static BaseApplication getContext()
  {
    return context;
  }
  
  public static final void removeServerSocket(String paramString)
  {
    MonitorSocketImplFactory.removeServerSocket(paramString);
  }
  
  public abstract Object getAppData(String paramString);
  
  public void onCreate()
  {
    super.onCreate();
    context = this;
    monitor = new MonitorSocketStat();
    long l = System.currentTimeMillis();
    for (;;)
    {
      Object localObject1;
      try
      {
        File localFile = new File(context.getFilesDir().getAbsolutePath() + "/monitor_config.properties");
        if ((localFile == null) || (!localFile.exists()))
        {
          QLog.d("MSF.D.MonitorSocket", 1, "monitor_config not found, disable monitor socket");
          localObject6 = null;
          localFile = null;
          if (localFile != null) {
            break label303;
          }
          if (QLog.isColorLevel()) {
            QLog.d("MSF.D.MonitorSocket", 2, "phoneDisplays is null, close Monitor Socket");
          }
          if (QLog.isColorLevel()) {
            QLog.d("MSF.D.MonitorSocket", 2, "BaseApplication initialization used " + (System.currentTimeMillis() - l) + "ms");
          }
          return;
        }
      }
      catch (Exception localException1)
      {
        QLog.d("MSF.D.MonitorSocket", 1, "" + localException1);
        localObject1 = null;
        continue;
      }
      for (;;)
      {
        try
        {
          localObject3 = new FileInputStream((File)localObject1);
          localObject4 = new Properties();
          ((Properties)localObject4).load((InputStream)localObject3);
          localObject1 = ((Properties)localObject4).getProperty("model");
        }
        catch (Exception localException3)
        {
          try
          {
            localObject4 = ((Properties)localObject4).getProperty("display");
          }
          catch (Exception localException4)
          {
            for (;;)
            {
              Object localObject4;
              Object localObject5;
              localObject6 = null;
              localObject3 = localException2;
              localObject2 = localObject6;
            }
          }
          try
          {
            ((FileInputStream)localObject3).close();
            localObject3 = localObject1;
            localObject6 = localObject3;
            localObject1 = localObject4;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("MSF.D.MonitorSocket", 2, "phoneDisplays: " + (String)localObject4 + ", phoneModels: " + (String)localObject3);
            localObject6 = localObject3;
            localObject1 = localObject4;
          }
          catch (Exception localException6)
          {
            localObject3 = localObject2;
            localObject2 = localException4;
            Exception localException5 = localException6;
            break label273;
          }
          localException3 = localException3;
          localObject1 = null;
          localObject3 = null;
        }
        label273:
        QLog.d("MSF.D.MonitorSocket", 1, "" + localException3);
        localObject5 = localObject1;
      }
      label303:
      if ((Build.VERSION.SDK_INT >= 19) && ((Build.DISPLAY.toUpperCase().contains("KOT49H")) || (Build.DISPLAY.toUpperCase().contains("KTU84P"))))
      {
        QLog.d("MSF.D.MonitorSocket", 1, "Samsung above android 4.4 rom Donot Monitor Socket Netflow");
      }
      else if ((((String)localObject1).contains(Build.DISPLAY.toUpperCase())) || (((String)localObject6).contains(Build.MODEL.toUpperCase())))
      {
        QLog.d("MSF.D.MonitorSocket", 1, "Phone display|model in banlist, close Monitor Socket");
      }
      else
      {
        localObject1 = new MonitorSocketImplFactory();
        if (((MonitorSocketImplFactory)localObject1).getMsfSocketImpl(getContext()) == true) {
          try
          {
            Socket.setSocketImplFactory((SocketImplFactory)localObject1);
          }
          catch (Exception localException2)
          {
            QLog.d("MSF.D.MonitorSocket", 1, "set socketimpl factory failed.");
          }
        } else {
          QLog.d("MSF.D.MonitorSocket", 1, "get socketimpl failed.");
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\qphone\base\util\BaseApplication.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */