package com.tencent.mobileqq.app;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import java.util.HashMap;

public class DeviceAbilityCollector
{
  public static final String a = "DeviceAbilityCollector";
  private static final String b = "actDeviceAbility";
  private static final String c = "sp_device_ability";
  private static final String d = "device_ability_report_time";
  
  public DeviceAbilityCollector()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(Context paramContext)
  {
    boolean bool1 = false;
    Object localObject1 = paramContext.getSharedPreferences("sp_device_ability", 0);
    if (Math.abs(System.currentTimeMillis() - ((SharedPreferences)localObject1).getLong("device_ability_report_time", 0L)) < 86400000L) {
      return;
    }
    ((SharedPreferences)localObject1).edit().putLong("device_ability_report_time", System.currentTimeMillis()).commit();
    localObject1 = BluetoothAdapter.getDefaultAdapter();
    int i;
    if ((localObject1 != null) && (((BluetoothAdapter)localObject1).isEnabled())) {
      if (((BluetoothAdapter)localObject1).getScanMode() == 23)
      {
        i = 1;
        i += 2;
      }
    }
    for (;;)
    {
      int j;
      if (paramContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
        if (Build.VERSION.SDK_INT >= 21)
        {
          j = 1;
          label110:
          j += 2;
        }
      }
      for (;;)
      {
        localObject1 = (WifiManager)paramContext.getSystemService("wifi");
        Object localObject2;
        int k;
        if ((localObject1 != null) && (((WifiManager)localObject1).isWifiEnabled()))
        {
          localObject2 = ((WifiManager)localObject1).getConnectionInfo();
          if ((localObject2 != null) && (((WifiInfo)localObject2).getIpAddress() != 0))
          {
            k = 1;
            label156:
            k += 2;
          }
        }
        for (;;)
        {
          try
          {
            localObject2 = localObject1.getClass().getDeclaredMethod("isWifiApEnabled", new Class[0]);
            ((Method)localObject2).setAccessible(true);
            boolean bool2 = ((Boolean)((Method)localObject2).invoke(localObject1, new Object[0])).booleanValue();
            bool1 = bool2;
          }
          catch (Throwable localThrowable)
          {
            continue;
          }
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder(30);
            ((StringBuilder)localObject1).append("report:").append(i);
            ((StringBuilder)localObject1).append(", ").append(j);
            ((StringBuilder)localObject1).append(", ").append(k);
            ((StringBuilder)localObject1).append(", ").append(bool1);
            QLog.d("DeviceAbilityCollector", 2, ((StringBuilder)localObject1).toString());
          }
          localObject2 = new HashMap();
          ((HashMap)localObject2).put("btStatus", i + "");
          ((HashMap)localObject2).put("btAbility", j + "");
          ((HashMap)localObject2).put("wifiStatus", k + "");
          if (bool1)
          {
            localObject1 = "1";
            ((HashMap)localObject2).put("hsEnabled", localObject1);
            ((HashMap)localObject2).put("osVersion", Build.VERSION.SDK_INT + "");
            StatisticCollector.a(paramContext).a("", "actDeviceAbility", true, 0L, 0L, (HashMap)localObject2, "");
            return;
            i = 0;
            break;
            j = 0;
            break label110;
            k = 0;
            break label156;
          }
          localObject1 = "0";
          continue;
          k = 0;
        }
        j = 0;
      }
      i = 0;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\DeviceAbilityCollector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */