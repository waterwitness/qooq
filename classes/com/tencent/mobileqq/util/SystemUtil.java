package com.tencent.mobileqq.util;

import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;
import java.lang.reflect.Method;

public class SystemUtil
{
  public static String a;
  static boolean a = false;
  public static final String b = "/data/data/com.tencent.mobileqq/files/";
  static boolean b = false;
  private static final String c = "ro.miui.ui.version.code";
  private static final String d = "ro.miui.ui.version.name";
  private static final String e = "ro.miui.internal.storage";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = "SystemUtil";
  }
  
  public static long a()
  {
    try
    {
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      long l = localStatFs.getBlockSize();
      l = localStatFs.getAvailableBlocks() * l / 1024L;
      return l;
    }
    catch (Exception localException) {}
    return 0L;
  }
  
  /* Error */
  public static String a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 69	java/io/BufferedReader
    //   5: dup
    //   6: new 71	java/io/InputStreamReader
    //   9: dup
    //   10: invokestatic 77	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   13: new 79	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   20: ldc 82
    //   22: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_0
    //   26: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokevirtual 93	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   35: invokevirtual 99	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   38: invokespecial 102	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   41: sipush 1024
    //   44: invokespecial 105	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   47: astore_1
    //   48: aload_1
    //   49: astore_0
    //   50: aload_1
    //   51: invokevirtual 108	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   54: astore_2
    //   55: aload_1
    //   56: astore_0
    //   57: aload_1
    //   58: invokevirtual 111	java/io/BufferedReader:close	()V
    //   61: aload_1
    //   62: ifnull +7 -> 69
    //   65: aload_1
    //   66: invokevirtual 111	java/io/BufferedReader:close	()V
    //   69: aload_2
    //   70: areturn
    //   71: astore_0
    //   72: getstatic 31	com/tencent/mobileqq/util/SystemUtil:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   75: iconst_2
    //   76: ldc 113
    //   78: aload_0
    //   79: invokestatic 118	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   82: aload_2
    //   83: areturn
    //   84: astore_2
    //   85: aconst_null
    //   86: astore_1
    //   87: aload_1
    //   88: astore_0
    //   89: getstatic 31	com/tencent/mobileqq/util/SystemUtil:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   92: iconst_2
    //   93: ldc 120
    //   95: aload_2
    //   96: invokestatic 118	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   99: aload_1
    //   100: ifnull +7 -> 107
    //   103: aload_1
    //   104: invokevirtual 111	java/io/BufferedReader:close	()V
    //   107: aconst_null
    //   108: areturn
    //   109: astore_0
    //   110: getstatic 31	com/tencent/mobileqq/util/SystemUtil:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   113: iconst_2
    //   114: ldc 113
    //   116: aload_0
    //   117: invokestatic 118	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   120: goto -13 -> 107
    //   123: astore_0
    //   124: aload_2
    //   125: astore_1
    //   126: aload_1
    //   127: ifnull +7 -> 134
    //   130: aload_1
    //   131: invokevirtual 111	java/io/BufferedReader:close	()V
    //   134: aload_0
    //   135: athrow
    //   136: astore_1
    //   137: getstatic 31	com/tencent/mobileqq/util/SystemUtil:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   140: iconst_2
    //   141: ldc 113
    //   143: aload_1
    //   144: invokestatic 118	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   147: goto -13 -> 134
    //   150: astore_2
    //   151: aload_0
    //   152: astore_1
    //   153: aload_2
    //   154: astore_0
    //   155: goto -29 -> 126
    //   158: astore_2
    //   159: goto -72 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	162	0	paramString	String
    //   47	84	1	localObject1	Object
    //   136	8	1	localIOException1	java.io.IOException
    //   152	1	1	str1	String
    //   1	82	2	str2	String
    //   84	41	2	localIOException2	java.io.IOException
    //   150	4	2	localObject2	Object
    //   158	1	2	localIOException3	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   65	69	71	java/io/IOException
    //   2	48	84	java/io/IOException
    //   103	107	109	java/io/IOException
    //   2	48	123	finally
    //   130	134	136	java/io/IOException
    //   50	55	150	finally
    //   57	61	150	finally
    //   89	99	150	finally
    //   50	55	158	java/io/IOException
    //   57	61	158	java/io/IOException
  }
  
  public static void a()
  {
    boolean bool2 = true;
    jdField_a_of_type_Boolean = true;
    boolean bool1 = bool2;
    if (TextUtils.isEmpty(a("ro.miui.ui.version.code")))
    {
      bool1 = bool2;
      if (TextUtils.isEmpty(a("ro.miui.ui.version.name"))) {
        if (TextUtils.isEmpty(a("ro.miui.internal.storage"))) {
          break label50;
        }
      }
    }
    label50:
    for (bool1 = bool2;; bool1 = false)
    {
      b = bool1;
      return;
    }
  }
  
  public static boolean a()
  {
    boolean bool1 = false;
    try
    {
      boolean bool2 = Environment.getExternalStorageState().equals("mounted");
      if (bool2) {
        bool1 = true;
      }
      return bool1;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static long b()
  {
    try
    {
      StatFs localStatFs = new StatFs("/data/data/com.tencent.mobileqq/files/");
      long l = localStatFs.getBlockSize();
      l = localStatFs.getAvailableBlocks() * l / 1024L;
      return l;
    }
    catch (Exception localException) {}
    return 0L;
  }
  
  public static boolean b()
  {
    if (jdField_a_of_type_Boolean) {
      return b;
    }
    a();
    return b;
  }
  
  public static boolean c()
  {
    boolean bool = false;
    try
    {
      Method localMethod = Build.class.getMethod("hasSmartBar", new Class[0]);
      if (localMethod != null) {
        bool = true;
      }
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\util\SystemUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */