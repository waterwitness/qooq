package com.tencent.mobileqq.music;

import android.os.Build;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class Utils
{
  public static String[] a = { "samsung SM-N7508V", "samsung SM-N9002", "samsung SM-N9005", "samsung SM-N9006", "samsung SM-N9008", "samsung SM-N9009", "samsung SM-N9009V", "samsung SM-G3858", "samsung SM-G7108V", "samsung SM-G7108U", "samsung SM-G9008V", "samsung GT-I9308I", "samsung GT-I9508V", "samsung SM-G3588V", "samsung SM-T2558", "HTC T528w", "MI 3", "HTC 802t", "GT-I9100", "GT-I9300", "SCH-I939", "MX4", "HUAWEI C8813D" };
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static boolean a()
  {
    boolean bool2 = false;
    String str = Build.MODEL;
    String[] arrayOfString = a;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfString[i].contains(str)) {
          bool1 = true;
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "isPhoneInWhiteList ： phone = " + str + ", result=" + bool1);
        }
        return bool1;
      }
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\music\Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */