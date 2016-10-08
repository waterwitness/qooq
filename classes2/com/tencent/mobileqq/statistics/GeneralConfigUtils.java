package com.tencent.mobileqq.statistics;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class GeneralConfigUtils
{
  private static int jdField_a_of_type_Int = -1;
  public static String a;
  static boolean jdField_a_of_type_Boolean;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = "GeneralConfigUtils";
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2)) {
      jdField_a_of_type_Int = -1;
    }
    try
    {
      Integer localInteger = Integer.valueOf(paramString2);
      BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).edit().putInt(paramString1, localInteger.intValue()).commit();
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "parseConfig(): config = " + paramString2 + ", sPicThumb400Enable = " + paramString2);
      }
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "parseConfig(): e = " + paramString1);
        }
      }
    }
  }
  
  public static boolean a()
  {
    if (jdField_a_of_type_Int == -1) {
      if (BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).getInt("pic_thumb_400Enable", 0) == 1)
      {
        jdField_a_of_type_Boolean = true;
        jdField_a_of_type_Int = 1;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "GeneralConfigUtils thumb400Enable= " + jdField_a_of_type_Boolean + "thumbConfig=" + jdField_a_of_type_Int);
      }
      return jdField_a_of_type_Boolean;
      jdField_a_of_type_Boolean = false;
      jdField_a_of_type_Int = 0;
      continue;
      if (jdField_a_of_type_Int == 1) {
        jdField_a_of_type_Boolean = true;
      } else {
        jdField_a_of_type_Boolean = false;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\statistics\GeneralConfigUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */