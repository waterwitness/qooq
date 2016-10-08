package com.tencent.mobileqq.ptt;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.utils.BaseConstants.NetType;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public final class StreamParams
  implements BaseConstants.NetType
{
  private static final int jdField_a_of_type_Int = 800;
  private static final String jdField_a_of_type_JavaLangString = "StreamParams";
  private static boolean jdField_a_of_type_Boolean;
  private static int[] jdField_a_of_type_ArrayOfInt = new int[6];
  private static boolean b;
  private static boolean c;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    b = true;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    int i = 0;
    if ((paramQQAppInterface == null) || (paramInt1 == 0)) {}
    do
    {
      return 800;
      b(paramQQAppInterface, false);
      paramQQAppInterface = jdField_a_of_type_ArrayOfInt;
      paramInt1 = i;
      if (paramInt2 >= 0)
      {
        paramInt1 = i;
        if (paramInt2 < paramQQAppInterface.length) {
          paramInt1 = paramQQAppInterface[paramInt2];
        }
      }
    } while (paramInt1 == 0);
    return paramInt1;
  }
  
  private static String a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = BaseApplicationImpl.a.getSharedPreferences("RecordParams_" + paramQQAppInterface.a(), 0).getString("StreamCfg", null);
    if (QLog.isColorLevel()) {
      QLog.d("StreamParams", 2, "getSavedStreamCfg: " + paramQQAppInterface);
    }
    return paramQQAppInterface;
  }
  
  public static void a()
  {
    jdField_a_of_type_Boolean = false;
    b = true;
    c = false;
    jdField_a_of_type_ArrayOfInt = new int[6];
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    BaseApplicationImpl.a.getSharedPreferences("RecordParams_" + paramQQAppInterface.a(), 0).edit().putString("StreamCfg", paramString).commit();
    if (QLog.isColorLevel()) {
      QLog.d("StreamParams", 2, "saveStreamCfg: " + paramString);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if ((jdField_a_of_type_Boolean) && (!paramBoolean)) {
      return;
    }
    jdField_a_of_type_Boolean = true;
    for (;;)
    {
      try
      {
        paramQQAppInterface = a(paramQQAppInterface);
        if (QLog.isColorLevel()) {
          QLog.d("StreamParams", 2, "initSupportCfg :" + paramQQAppInterface);
        }
        if (paramQQAppInterface != null)
        {
          int i = paramQQAppInterface.length();
          if (i != 0) {
            continue;
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        continue;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("StreamParams", 2, "init params: " + b);
      return;
      paramQQAppInterface = paramQQAppInterface.split("\\|");
      if ((paramQQAppInterface != null) && (paramQQAppInterface.length >= 1)) {
        b = "1".equals(paramQQAppInterface[0]);
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface, false);
    return b;
  }
  
  private static String b(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = BaseApplicationImpl.a.getSharedPreferences("RecordParams_" + paramQQAppInterface.a(), 0).getString("StreamSliceCfg", null);
    if (QLog.isColorLevel()) {
      QLog.d("StreamParams", 2, "getSavedStreamSliceCfg: " + paramQQAppInterface);
    }
    return paramQQAppInterface;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    BaseApplicationImpl.a.getSharedPreferences("RecordParams_" + paramQQAppInterface.a(), 0).edit().putString("StreamSliceCfg", paramString).commit();
    if (QLog.isColorLevel()) {
      QLog.d("StreamParams", 2, "saveStreamSliceCfg: " + paramString);
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if ((c) && (!paramBoolean)) {}
    for (;;)
    {
      return;
      c = true;
      try
      {
        paramQQAppInterface = b(paramQQAppInterface);
        if (QLog.isColorLevel()) {
          QLog.d("StreamParams", 2, "initSliceCfg: " + paramQQAppInterface);
        }
        if (paramQQAppInterface == null) {
          continue;
        }
        paramQQAppInterface = paramQQAppInterface.split("\\|");
        int i = 0;
        while (i < paramQQAppInterface.length)
        {
          if (paramQQAppInterface[i].startsWith("1-"))
          {
            String[] arrayOfString = paramQQAppInterface[i].split("-");
            int j = Integer.parseInt(arrayOfString[1]);
            int k = Integer.parseInt(arrayOfString[2]);
            jdField_a_of_type_ArrayOfInt[j] = k;
          }
          i += 1;
        }
        return;
      }
      catch (Exception paramQQAppInterface) {}
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\ptt\StreamParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */