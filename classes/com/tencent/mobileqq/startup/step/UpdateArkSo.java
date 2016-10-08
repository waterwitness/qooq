package com.tencent.mobileqq.startup.step;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class UpdateArkSo
  extends Step
{
  private static final String a = "ArkEngineExtract";
  private static final String c = "so_sp";
  private static final String d = "key_so_version_";
  private static final String e = "ark-armeabi-v7a";
  private static final String f = "png-armeabi-v7a";
  
  public static String a()
  {
    File localFile = BaseApplicationImpl.a.getFilesDir();
    if (localFile == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ArkEngineExtract", 2, "getFilesDir is null");
      }
      return "";
    }
    return localFile.getParent() + "/txlib/";
  }
  
  private static String a(String paramString)
  {
    return "lib" + paramString + ".so";
  }
  
  public static void a()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.a;
    b(localBaseApplicationImpl, "ark-armeabi-v7a");
    b(localBaseApplicationImpl, "png-armeabi-v7a");
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ArkEngineExtract", 2, "start LoadExtractedSo: " + paramString);
    }
    try
    {
      System.load(paramContext.getFilesDir().getParent() + "/txlib/" + a(paramString));
      return true;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      File localFile = new File(paramContext.getFilesDir().getParent() + "/txlib/" + a(paramString));
      if (localFile.exists()) {
        localFile.delete();
      }
      b(paramContext, paramString);
      try
      {
        System.load(paramContext.getFilesDir().getParent() + "/txlib/" + a(paramString));
        return true;
      }
      catch (UnsatisfiedLinkError paramContext) {}
    }
    return false;
  }
  
  public static boolean b(Context paramContext, String paramString)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    for (;;)
    {
      SharedPreferences localSharedPreferences;
      int i;
      try
      {
        localSharedPreferences = paramContext.getSharedPreferences("so_sp", 0);
        String str2;
        File localFile;
        long l1;
        try
        {
          i = Integer.valueOf("229354").intValue();
          String str1 = "key_so_version_" + paramString;
          j = localSharedPreferences.getInt(str1, -1);
          if (QLog.isColorLevel()) {
            QLog.i("ArkEngineExtract", 2, "libname: " + paramString + ", oldVer:" + j + ", revision:" + i);
          }
          str2 = a();
          boolean bool3 = TextUtils.isEmpty(str2);
          if (bool3)
          {
            bool2 = false;
            return bool2;
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          i = 0;
          continue;
          localFile = new File(str2 + a(paramString));
          if ((j == i) && (localFile.exists())) {
            continue;
          }
          l1 = SystemClock.uptimeMillis();
          localFile.delete();
          if (localFile.exists()) {
            break label392;
          }
        }
        int j = SoLoadUtil.a(paramContext, str2, "txlib", a(paramString));
        if (!localFile.exists()) {
          break label392;
        }
        if (j != 0)
        {
          localFile.delete();
          paramContext = "" + "copy asset so fail. file size not match";
          if (!QLog.isColorLevel()) {
            break label392;
          }
          QLog.d("ArkEngineExtract", 2, paramContext);
          bool1 = false;
          long l2 = SystemClock.uptimeMillis();
          bool2 = bool1;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("ArkEngineExtract", 2, "extract so " + paramString + " from assets, spend time: " + (l2 - l1));
          bool2 = bool1;
          continue;
        }
        if (i != 0) {
          break label369;
        }
      }
      finally {}
      localSharedPreferences.edit().putInt(localNumberFormatException, -1).commit();
      continue;
      label369:
      localSharedPreferences.edit().putInt(localNumberFormatException, i).commit();
      continue;
      label392:
      bool1 = false;
    }
  }
  
  protected boolean a()
  {
    a();
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\startup\step\UpdateArkSo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */