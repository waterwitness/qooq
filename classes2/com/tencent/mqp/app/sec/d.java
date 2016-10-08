package com.tencent.mqp.app.sec;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.MobileQQ;
import wpg;

public class d
{
  private static final String CMD_IE = "HunganSvc.Ie";
  public static final String CMD_PA = "MamonoSvc.Pa";
  public static final int TYPE_INIT = 1;
  public static final int TYPE_PUSH = 2;
  public static final int TYPE_QUERY = 3;
  public static final int TYPE_WORK = 4;
  private static Object[] ectx;
  private static byte[] edata;
  private static int etype;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    etype = -1;
    try
    {
      System.loadLibrary("hobi");
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
    }
  }
  
  public static void ManualLoad()
  {
    System.loadLibrary("hobi");
  }
  
  public static native void e(int paramInt, Object[] paramArrayOfObject, byte[] paramArrayOfByte);
  
  public static void e1(int paramInt, Object[] paramArrayOfObject, byte[] paramArrayOfByte)
  {
    ThreadManager.a(new wpg(paramInt, paramArrayOfObject, paramArrayOfByte), 8, null, false);
  }
  
  public static void s(ToServiceMsg paramToServiceMsg)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localQQAppInterface != null) {
      localQQAppInterface.a(paramToServiceMsg);
    }
  }
  
  public static void w()
  {
    try
    {
      e(4, null, null);
      return;
    }
    catch (Throwable localThrowable)
    {
      while (localThrowable == null) {}
      localThrowable.printStackTrace();
    }
  }
  
  public static Object[] x()
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    Object localObject1 = "";
    if (localBaseApplication != null) {
      localObject1 = Settings.Secure.getString(localBaseApplication.getContentResolver(), "android_id");
    }
    if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (Object localObject2 = "";; localObject2 = localObject1)
    {
      if (localBaseApplication != null)
      {
        localObject1 = (WifiManager)localBaseApplication.getSystemService("wifi");
        if (localObject1 != null)
        {
          localObject1 = ((WifiManager)localObject1).getConnectionInfo();
          if (localObject1 == null) {}
        }
      }
      for (localObject1 = ((WifiInfo)localObject1).getMacAddress();; localObject1 = null)
      {
        if (localObject1 == null) {
          localObject1 = "";
        }
        for (;;)
        {
          int i;
          if (AppNetConnInfo.isNetSupport()) {
            if (AppNetConnInfo.isWifiConn()) {
              i = 1;
            }
          }
          for (;;)
          {
            Object localObject3 = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
            if (localObject3 != null) {}
            for (localObject3 = ((QQAppInterface)localObject3).a();; localObject3 = "")
            {
              Object localObject5 = DeviceInfoUtil.a();
              Object localObject4 = localObject5;
              if (localObject5 == null) {
                localObject4 = "";
              }
              String str = DeviceInfoUtil.b();
              localObject5 = str;
              if (str == null) {
                localObject5 = "";
              }
              return new Object[] { localBaseApplication, d.class, Build.VERSION.RELEASE, Integer.valueOf(AppSetting.a), NetConnInfoCenter.GUID, ((String)localObject4).getBytes(), ((String)localObject2).getBytes(), Integer.valueOf(i), "mobileqq.service", localObject3, "req_pb_protocol_flag", ((String)localObject5).getBytes(), localObject1 };
              if (!AppNetConnInfo.isMobileConn()) {
                break label258;
              }
              i = AppNetConnInfo.getMobileInfo() + 2;
              break;
            }
            label258:
            i = 0;
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mqp\app\sec\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */