package com.hiar.sdk.utils;

import android.content.Context;
import android.os.Environment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;
import java.io.PrintStream;

public class FilePath
{
  public static String a;
  public static String b;
  public static String c;
  public static String d;
  public static final String e = Environment.getExternalStorageDirectory().getAbsolutePath();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String a()
  {
    return b;
  }
  
  public static void a(Context paramContext)
  {
    if ("mounted".equals(Environment.getExternalStorageState())) {}
    for (paramContext = Environment.getExternalStorageDirectory().getPath() + File.separator + "tencent" + File.separator;; paramContext = paramContext.getFilesDir().getAbsolutePath() + File.separator + "tencent" + File.separator)
    {
      a = paramContext + "reco";
      b = a + File.separator;
      c = paramContext + "arnative";
      d = c + File.separator;
      System.out.println("FilePath initPaths - appname_reco_ = " + b);
      System.out.println("FilePath initPaths - appname_arnative_ = " + d);
      return;
    }
  }
  
  public static boolean a(String paramString)
  {
    if (paramString == null) {}
    File localFile;
    do
    {
      return false;
      localFile = new File(paramString);
    } while ((paramString.endsWith(e)) || (!localFile.exists()));
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\hiar\sdk\utils\FilePath.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */