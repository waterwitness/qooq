package com.tencent.mobileqq.ark;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ArkSoLoader
{
  public static final String a = "ArkConfig_ArkSoLoader";
  public static boolean a;
  
  public ArkSoLoader()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String a()
  {
    File localFile = BaseApplicationImpl.a.getFilesDir();
    if (localFile == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ArkConfig_ArkSoLoader", 2, "getFilesDir is null");
      }
      return "";
    }
    return localFile.getParent() + "/ark";
  }
  
  public static boolean a(String paramString)
  {
    return new File(a() + "/lib" + paramString + ".so").exists();
  }
  
  public static boolean b(String paramString)
  {
    String str = a() + "/lib" + paramString + ".so";
    if (paramString == null) {}
    do
    {
      return false;
      if (new File(str).exists()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ArkConfig_ArkSoLoader", 2, "loadArkSo failed: " + str);
    return false;
    try
    {
      System.load(str);
      QLog.d("ArkConfig_ArkSoLoader", 2, "loadArkSo succ: " + str);
      return true;
    }
    catch (Throwable paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkConfig_ArkSoLoader", 2, QLog.getStackTraceString(paramString));
      }
      QLog.d("ArkConfig_ArkSoLoader", 1, "loadArkSo failed: " + str);
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\ark\ArkSoLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */