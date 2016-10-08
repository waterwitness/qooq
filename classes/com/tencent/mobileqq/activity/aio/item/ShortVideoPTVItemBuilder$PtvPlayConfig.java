package com.tencent.mobileqq.activity.aio.item;

import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class ShortVideoPTVItemBuilder$PtvPlayConfig
{
  public static int a = 0;
  private static final String a = "ShortVideo.PtvPlayConfig";
  public static boolean a;
  public static int b;
  public static boolean b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_b_of_type_Boolean = true;
    jdField_a_of_type_Int = 15;
    jdField_b_of_type_Int = 20;
  }
  
  public static void a()
  {
    Object localObject;
    if (!jdField_a_of_type_Boolean)
    {
      localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.PtvConfig.name(), null);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideo.PtvPlayConfig", 2, "initConfig(), ptvConfig=" + (String)localObject);
      }
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label211;
      }
      localObject = ((String)localObject).split("\\|");
      if ((localObject != null) && (localObject.length >= 3) && (TextUtils.isEmpty(localObject[0]))) {}
    }
    try
    {
      jdField_b_of_type_Int = Integer.parseInt(localObject[0]);
      if (!TextUtils.isEmpty(localObject[1])) {
        jdField_b_of_type_Boolean = localObject[1].equals("1");
      }
      if (!TextUtils.isEmpty(localObject[2])) {}
      for (;;)
      {
        try
        {
          jdField_a_of_type_Int = Integer.parseInt(localObject[2]);
          jdField_a_of_type_Boolean = true;
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideo.PtvPlayConfig", 2, "initConfig(), sReadFromDPC=" + jdField_a_of_type_Boolean + ", sAutoPlayInAIO:" + jdField_b_of_type_Boolean + ", sRequestedFPS:" + jdField_a_of_type_Int + ",sPtvMaxTime:" + jdField_b_of_type_Int);
          }
          return;
        }
        catch (Exception localException1)
        {
          jdField_a_of_type_Int = 15;
          continue;
        }
        label211:
        jdField_b_of_type_Boolean = true;
        jdField_a_of_type_Int = 15;
      }
    }
    catch (Exception localException2)
    {
      for (;;) {}
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\item\ShortVideoPTVItemBuilder$PtvPlayConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */