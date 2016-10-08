package com.tencent.mobileqq.shortvideo.hwcodec;

import android.os.Build.VERSION;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
import com.tencent.qphone.base.util.QLog;

public class HwEnvData
{
  public static final float a = 1.5F;
  public static int a = 1500;
  private static final String a = "HwEnvData";
  public static final boolean a = false;
  private static final int b = 18;
  public static boolean b;
  public static boolean c;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HwEnvData", 2, "[@] supportHardWareCodec:SDK_INT=" + Build.VERSION.SDK_INT + "dpcSupportHwCodec=" + b);
    }
    boolean bool = CameraCompatibleList.a(CameraCompatibleList.r);
    if (bool) {
      if (QLog.isColorLevel()) {
        QLog.d("HwEnvData", 2, "[@] supportHardWareCodec:black=" + bool);
      }
    }
    while (Build.VERSION.SDK_INT < 18) {
      return false;
    }
    return b;
  }
  
  public static boolean b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HwEnvData", 2, "[@] supportRecordAndEncode:SDK_INT=" + Build.VERSION.SDK_INT + "dpcSupportPre_SendEncode=" + c + "dpcSupportHwCodec=" + b);
    }
    if (Build.VERSION.SDK_INT < 18) {}
    do
    {
      boolean bool;
      do
      {
        do
        {
          return false;
          bool = CameraCompatibleList.e(CameraCompatibleList.o);
          if (!bool) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("HwEnvData", 2, "[@] supportRecordAndEncode:black=" + bool);
        return false;
        bool = CameraCompatibleList.a(CameraCompatibleList.r);
        if (!bool) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("HwEnvData", 2, "[@] supportRecordAndEncode:black=" + bool + " hardware Black");
      return false;
    } while ((!c) || (!b));
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\hwcodec\HwEnvData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */