package com.tencent.mobileqq.shortvideo;

import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class ShortVideoUtils$ShortVideoPlayConfig
{
  public static int a = 0;
  private static final String a = "ShortVideo.ShortVideoPlayConfig";
  public static boolean a;
  public static boolean b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    b = true;
    jdField_a_of_type_Int = 18;
  }
  
  public static void a()
  {
    Object localObject;
    if (!jdField_a_of_type_Boolean)
    {
      localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.ShortVideoPlayInAIO.name(), null);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideo.ShortVideoPlayConfig", 2, "initConfig(), videoPlayConfig=" + (String)localObject);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        if ((localObject != null) && (localObject.length >= 2))
        {
          if (!TextUtils.isEmpty(localObject[0])) {
            b = localObject[0].equals("1");
          }
          if (TextUtils.isEmpty(localObject[1])) {}
        }
      }
    }
    try
    {
      jdField_a_of_type_Int = Integer.parseInt(localObject[1]);
      jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideo.ShortVideoPlayConfig", 2, "initVideoPlayConfig(), sReadFromDPC=" + jdField_a_of_type_Boolean + ", sAutoPlayInAIO:" + b + ", sRequestedFPS:" + jdField_a_of_type_Int);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        jdField_a_of_type_Int = 18;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\ShortVideoUtils$ShortVideoPlayConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */