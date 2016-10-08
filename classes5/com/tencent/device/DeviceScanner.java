package com.tencent.device;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.widgets.ScannerView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.bind.DevicePluginDownloadActivity;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import cooperation.smartdevice.SmartDevicePluginLoader;
import cooperation.smartdevice.SmartDevicePluginProxyActivity;
import jot;
import jou;

public class DeviceScanner
{
  public static final int a = 16;
  public static final String a = "http://iot.qq.com/add";
  public static final int b = 1000000000;
  public static final String b = "http://qqapp.eprintsw.com";
  static final String c = "smartdevice::DeviceScanner";
  public static final String d = "pid";
  public static final String e = "sn";
  public static final String f = "token";
  public static final String g = "addtag";
  public static final String h = "ScanSmartDevice";
  public static final String i = "SMS";
  
  public DeviceScanner()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private static void a(Activity paramActivity, ScannerView paramScannerView, int paramInt1, int paramInt2)
  {
    if (paramActivity == null) {
      return;
    }
    paramActivity = DialogUtil.a(paramActivity, 230);
    paramActivity.setNegativeButton(2131367263, new jot(paramScannerView));
    paramActivity.setTitle(paramInt1);
    paramActivity.setMessage(paramInt2);
    paramActivity.show();
  }
  
  static void a(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("url", "http://qzs.qq.com/open/mobile/iot_qrcode_error/index.html");
    SmartDevicePluginLoader.a().a(paramActivity, paramQQAppInterface, paramQQAppInterface.getAccount(), localIntent, "com.tencent.device.activities.DeviceSquareActivity", 0, null, SmartDevicePluginProxyActivity.class);
  }
  
  public static boolean a(Activity paramActivity, ScannerView paramScannerView, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("smartdevice::DeviceScanner", 2, "device qrcode url:" + paramString);
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.a().a();
    jou localjou = new jou();
    try
    {
      localjou.a(paramString);
      int j;
      do
      {
        try
        {
          j = Integer.parseInt(localjou.a);
          if ((TextUtils.isEmpty(localjou.a)) || (TextUtils.isEmpty(localjou.b)) || ((!TextUtils.isEmpty(localjou.c)) && (localjou.c.length() != 32)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("smartdevice::DeviceScanner", 2, "device qrcode error pid:" + localjou.a + " sn:" + localjou.b + ",token:" + localjou.c);
            }
            SmartDeviceReport.a().jdField_a_of_type_Int = j;
            SmartDeviceReport.a().a(localQQAppInterface, "Usr_Analyze_URL", 3);
            SmartDeviceReport.a(localQQAppInterface, "Usr_QRCode_Result", 0, 0, j);
            if (paramActivity != null)
            {
              if (paramString.startsWith("http://iot.qq.com")) {
                a(paramActivity, paramScannerView, 2131362422, 2131362423);
              }
            }
            else {
              return false;
            }
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            j = 0;
          }
          if ((!TextUtils.isEmpty(localjou.c)) && (localjou.c.length() != 32))
          {
            a(paramActivity, paramScannerView, 2131362422, 2131362424);
            return false;
          }
          if (!SmartDevicePluginLoader.a().a(localQQAppInterface))
          {
            a(paramActivity, paramScannerView, 2131362422, 2131362423);
            return false;
          }
          a(paramActivity, localQQAppInterface);
          return false;
        }
        if (((TextUtils.isEmpty(localjou.a)) || ((localjou.a.length() == 10) && (TextUtils.isDigitsOnly(localjou.a)))) && ((TextUtils.isEmpty(localjou.b)) || (localjou.b.length() == 16))) {
          break;
        }
      } while (paramActivity == null);
      a(paramActivity, paramScannerView, 2131362422, 2131362423);
      return false;
      SmartDeviceReport.a().jdField_a_of_type_Int = j;
      SmartDeviceReport.a().b = localjou.b;
      if ("SMS".equals(localjou.d)) {
        SmartDeviceReport.a().a(localQQAppInterface, "Usr_Analyze_URL", 4);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("smartdevice::DeviceScanner", 2, "device qrcode pid:" + localjou.a + " sn:" + localjou.b);
        }
        if (SmartDevicePluginLoader.a().a(localQQAppInterface)) {
          break;
        }
        if (paramActivity != null)
        {
          paramScannerView = new Intent(paramActivity, DevicePluginDownloadActivity.class);
          paramScannerView.putExtra("DevicePID", localjou.a);
          paramScannerView.putExtra("DeviceSN", localjou.b);
          paramScannerView.putExtra("DeviceToken", localjou.c);
          paramActivity.startActivity(paramScannerView);
        }
        return true;
        if ((localjou.c != null) && (localjou.c.length() > 0)) {
          SmartDeviceReport.a().a(localQQAppInterface, "Usr_Analyze_URL", 2);
        } else {
          SmartDeviceReport.a().a(localQQAppInterface, "Usr_Analyze_URL", 1);
        }
      }
      paramScannerView = new Intent();
      paramScannerView.putExtra("DevicePID", localjou.a);
      paramScannerView.putExtra("DeviceSN", localjou.b);
      paramScannerView.putExtra("DeviceToken", localjou.c);
      paramScannerView.putExtra("DataReportSeq", SmartDeviceReport.a().jdField_a_of_type_Long);
    }
    catch (Exception localException2)
    {
      try
      {
        paramScannerView.putExtra("nickname", localQQAppInterface.b());
        paramScannerView.putExtra("bitmap", localQQAppInterface.a(localQQAppInterface.a(), (byte)2, false));
        SmartDevicePluginLoader.a().a(paramActivity, localQQAppInterface, localQQAppInterface.getAccount(), paramScannerView, "com.tencent.device.activities.DeviceScanActivity", -1, null, SmartDevicePluginProxyActivity.class);
        return true;
        localException2 = localException2;
      }
      catch (Exception paramString)
      {
        for (;;) {}
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\device\DeviceScanner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */