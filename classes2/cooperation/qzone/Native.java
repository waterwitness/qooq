package cooperation.qzone;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.DataUtils;
import cooperation.qzone.util.FileUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Native
{
  public static final int a = 0;
  private static Context jdField_a_of_type_AndroidContentContext;
  static final String jdField_a_of_type_JavaLangString = "lib/armeabi";
  private static final HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static final char[] jdField_a_of_type_ArrayOfChar = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  public static final int b = 1;
  static final String b = "lib/armeabi-v7a";
  public static final int c = 2;
  static final String c = "lib/x86";
  public static final int d = 3;
  static final String d = "lib/mips";
  private static final String e = "LibraryLoader";
  private static final String f = "qzlib";
  private static final String g = "lib/armeabi";
  private static final String h = "guarder";
  private static final String i = "http://14.17.34.200/sngapp/qzone/client/20140812163037_9933/qzone_so_for_5_0.zip";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a()
  {
    return a(Build.CPU_ABI);
  }
  
  public static int a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return 0;
      if (paramString.contains("x86")) {
        return 1;
      }
      if (paramString.contains("mips")) {
        return 2;
      }
    } while ((paramString.equalsIgnoreCase("armeabi")) || (!paramString.equalsIgnoreCase("armeabi-v7a")));
    return 3;
  }
  
  public static File a()
  {
    String str = b();
    return new File(str + File.separator + "qzlib");
  }
  
  private static String a()
  {
    try
    {
      String str = jdField_a_of_type_AndroidContentContext.getPackageManager().getPackageInfo(jdField_a_of_type_AndroidContentContext.getPackageName(), 0).versionName;
      return str;
    }
    catch (Exception localException) {}
    return String.valueOf(System.currentTimeMillis());
  }
  
  private static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return "lib/armeabi";
    case 1: 
      return "lib/x86";
    case 2: 
      return "lib/mips";
    }
    return "lib/armeabi-v7a";
  }
  
  private static String a(InputStream paramInputStream)
  {
    return a(paramInputStream, "MD5");
  }
  
  /* Error */
  public static String a(InputStream paramInputStream, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 173	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   4: astore_1
    //   5: sipush 1024
    //   8: newarray <illegal type>
    //   10: astore_2
    //   11: aload_0
    //   12: aload_2
    //   13: invokevirtual 179	java/io/InputStream:read	([B)I
    //   16: istore_3
    //   17: iload_3
    //   18: ifle +21 -> 39
    //   21: aload_1
    //   22: aload_2
    //   23: iconst_0
    //   24: iload_3
    //   25: invokevirtual 183	java/security/MessageDigest:update	([BII)V
    //   28: goto -17 -> 11
    //   31: astore_1
    //   32: aload_0
    //   33: invokestatic 188	cooperation/qzone/util/DataUtils:a	(Ljava/lang/Object;)Z
    //   36: pop
    //   37: aconst_null
    //   38: areturn
    //   39: aload_1
    //   40: invokevirtual 192	java/security/MessageDigest:digest	()[B
    //   43: invokestatic 195	cooperation/qzone/Native:a	([B)Ljava/lang/String;
    //   46: astore_1
    //   47: aload_0
    //   48: invokestatic 188	cooperation/qzone/util/DataUtils:a	(Ljava/lang/Object;)Z
    //   51: pop
    //   52: aload_1
    //   53: areturn
    //   54: astore_1
    //   55: aload_0
    //   56: invokestatic 188	cooperation/qzone/util/DataUtils:a	(Ljava/lang/Object;)Z
    //   59: pop
    //   60: aconst_null
    //   61: areturn
    //   62: astore_1
    //   63: aload_0
    //   64: invokestatic 188	cooperation/qzone/util/DataUtils:a	(Ljava/lang/Object;)Z
    //   67: pop
    //   68: aload_1
    //   69: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	paramInputStream	InputStream
    //   0	70	1	paramString	String
    //   10	13	2	arrayOfByte	byte[]
    //   16	9	3	j	int
    // Exception table:
    //   from	to	target	type
    //   0	11	31	java/io/IOException
    //   11	17	31	java/io/IOException
    //   21	28	31	java/io/IOException
    //   39	47	31	java/io/IOException
    //   0	11	54	java/security/NoSuchAlgorithmException
    //   11	17	54	java/security/NoSuchAlgorithmException
    //   21	28	54	java/security/NoSuchAlgorithmException
    //   39	47	54	java/security/NoSuchAlgorithmException
    //   0	11	62	finally
    //   11	17	62	finally
    //   21	28	62	finally
    //   39	47	62	finally
  }
  
  public static String a(String paramString)
  {
    if (!jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)) {
      return null;
    }
    return (String)jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public static String a(String paramString1, String paramString2)
  {
    paramString1 = b() + File.separator + paramString1;
    return paramString1 + File.separator + paramString2;
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return null;
    }
    char[] arrayOfChar = new char[paramArrayOfByte.length * 2];
    int j = 0;
    while (j < paramArrayOfByte.length)
    {
      int k = paramArrayOfByte[j];
      arrayOfChar[(j * 2 + 1)] = jdField_a_of_type_ArrayOfChar[(k & 0xF)];
      k = (byte)(k >>> 4);
      arrayOfChar[(j * 2)] = jdField_a_of_type_ArrayOfChar[(k & 0xF)];
      j += 1;
    }
    return new String(arrayOfChar);
  }
  
  private static List a(String paramString)
  {
    Object localObject;
    File localFile;
    boolean bool;
    if (a())
    {
      localObject = new File(Environment.getExternalStorageDirectory(), "Tencent" + File.separator + "wns");
      localFile = new File((File)localObject, "wns_network_lib.zip");
      if (localFile.exists()) {
        localFile.delete();
      }
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      QLog.w("LibraryLoader", 1, "Prepare to Download Native Libs From Network ... Url = http://14.17.34.200/sngapp/qzone/client/20140812163037_9933/qzone_so_for_5_0.zip");
      bool = QZoneHttpUtil.a(QZoneHttpUtil.a("http://14.17.34.200/sngapp/qzone/client/20140812163037_9933/qzone_so_for_5_0.zip", localFile));
      QLog.w("LibraryLoader", 1, "Download Native Libs => " + bool);
      if (bool) {
        break label139;
      }
      paramString = null;
    }
    label139:
    do
    {
      return paramString;
      localObject = jdField_a_of_type_AndroidContentContext.getCacheDir();
      break;
      QLog.w("LibraryLoader", 1, "Prepare to Install Native Libs ...");
      localObject = new HashSet();
      if (!TextUtils.isEmpty(paramString)) {
        ((Set)localObject).add(paramString);
      }
      localObject = FileUtils.a(localFile, a(), (Set)localObject);
      QLog.w("LibraryLoader", 1, "Install Native Libs => " + bool);
      paramString = (String)localObject;
    } while (!localFile.exists());
    localFile.delete();
    return (List)localObject;
  }
  
  private static void a(long paramLong, boolean paramBoolean, String paramString)
  {
    long l = System.currentTimeMillis();
    if ((!paramBoolean) || (l - paramLong <= 0L)) {
      return;
    }
    QLog.e("LibraryLoader", 1, "report force copy to mm " + paramString);
  }
  
  public static void a(File paramFile)
  {
    a(paramFile, false);
  }
  
  public static void a(File paramFile, boolean paramBoolean)
  {
    if ((paramFile == null) || (!paramFile.exists())) {}
    do
    {
      File[] arrayOfFile;
      do
      {
        return;
        if (paramFile.isFile())
        {
          paramFile.delete();
          return;
        }
        arrayOfFile = paramFile.listFiles();
      } while (arrayOfFile == null);
      int k = arrayOfFile.length;
      int j = 0;
      while (j < k)
      {
        a(arrayOfFile[j], paramBoolean);
        j += 1;
      }
    } while (paramBoolean);
    paramFile.delete();
  }
  
  private static void a(String paramString)
  {
    QLog.e("LibraryLoader", 1, "try to copy " + paramString);
    String str = c(paramString);
    try
    {
      a(paramString, str, a().getAbsolutePath());
      return;
    }
    catch (Throwable localThrowable)
    {
      throw new Native.NativeException("copy file:" + paramString + " failed!", localThrowable);
    }
  }
  
  private static void a(String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (paramVarArgs != null)
    {
      int k = paramVarArgs.length;
      int j = 0;
      while (j < k)
      {
        String str = paramVarArgs[j];
        a(str, paramString2 + File.separator + str, paramString3);
        a(paramString1, str, true);
        j += 1;
      }
    }
  }
  
  private static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = jdField_a_of_type_AndroidContentContext.getSharedPreferences("guarder", 0);
    paramString1 = c(paramString1, paramString2);
    localSharedPreferences.edit().putBoolean(paramString1, paramBoolean).commit();
  }
  
  public static void a(String paramString, String... paramVarArgs)
  {
    if (paramVarArgs != null)
    {
      int k = paramVarArgs.length;
      int j = 0;
      while (j < k)
      {
        String str = paramVarArgs[j];
        a(str);
        a(paramString, str, true);
        j += 1;
      }
    }
  }
  
  public static boolean a()
  {
    return "mounted".equals(Environment.getExternalStorageState());
  }
  
  public static boolean a(String paramString)
  {
    return a(paramString, "qzlib");
  }
  
  public static boolean a(String paramString, Context paramContext)
  {
    boolean bool3 = false;
    jdField_a_of_type_AndroidContentContext = paramContext;
    String str1 = "lib" + paramString + ".so";
    paramContext = new File(a(), str1);
    jdField_a_of_type_JavaUtilHashMap.put(paramString, null);
    for (;;)
    {
      boolean bool2;
      try
      {
        QLog.d("LibraryLoader", 1, "try to load library: " + paramString + " from system lib");
        System.loadLibrary(paramString);
        bool2 = true;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
      {
        QLog.e("LibraryLoader", 1, "cannot load library " + paramString + " from system lib", localUnsatisfiedLinkError2);
        l = System.currentTimeMillis();
        if ((paramContext.exists()) && (e(a(), str1))) {
          break label480;
        }
        if (b(str1)) {
          break label372;
        }
        localObject1 = a(str1);
        bool2 = bool3;
        if (localObject1 == null) {
          continue;
        }
        bool2 = bool3;
        if (((List)localObject1).isEmpty()) {
          continue;
        }
        localObject1 = ((List)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          continue;
        }
        localFile = (File)((Iterator)localObject1).next();
        a(a(), localFile.getName(), true);
        continue;
      }
      catch (Exception localException2)
      {
        QLog.e("LibraryLoader", 1, "cannot load library " + paramString + " from system lib", localException2);
        continue;
      }
      catch (Error localError2)
      {
        QLog.e("LibraryLoader", 1, "cannot load library " + paramString + " from system lib", localError2);
        continue;
        bool1 = false;
        if (!paramContext.exists()) {
          break label523;
        }
      }
      return bool2;
      try
      {
        Object localObject1;
        String str2 = paramContext.getAbsolutePath();
        QLog.d("LibraryLoader", 1, "try to load library: " + str2 + " from qzlib");
        System.load(str2);
        jdField_a_of_type_JavaUtilHashMap.put(paramString, str2);
        a(l, bool1, paramString);
        return true;
        label372:
        QLog.e("LibraryLoader", 1, str1 + " not exist,try to forceCopy!");
        try
        {
          a(a(), new String[] { str1 });
          bool1 = true;
        }
        catch (Native.NativeException localNativeException1)
        {
          QLog.e("LibraryLoader", 1, str1 + "forceCopy failed!", localNativeException1);
          bool1 = false;
        }
        catch (Exception localException3)
        {
          QLog.e("LibraryLoader", 1, str1 + "forceCopy failed!", localException3);
        }
        label480:
        bool1 = false;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError3)
      {
        File localFile;
        QLog.e("LibraryLoader", 1, "cannot load library " + paramContext.getAbsolutePath() + " from qzlib", localUnsatisfiedLinkError3);
        if (b(str1))
        {
          if (!paramContext.exists())
          {
            QLog.e("LibraryLoader", 1, "Copy Lib For NOT_EXIST");
            j = 1;
            if (j == 0) {
              try
              {
                Object localObject2 = a(str1);
                bool2 = bool3;
                if (((List)localObject2).isEmpty()) {
                  continue;
                }
                localObject2 = ((List)localObject2).iterator();
                while (((Iterator)localObject2).hasNext())
                {
                  localFile = (File)((Iterator)localObject2).next();
                  a(a(), localFile.getName(), true);
                }
                bool2 = bool1;
              }
              catch (Throwable localThrowable) {}
            }
            if (j != 0) {
              QLog.e("LibraryLoader", 1, str1 + " is something wrong,try to forceCopy again!");
            }
          }
          try
          {
            a(a(), new String[] { str1 });
            bool2 = true;
          }
          catch (Native.NativeException localNativeException2)
          {
            for (;;)
            {
              QLog.e("LibraryLoader", 1, str1 + "forceCopy failed again!", localNativeException2);
              bool2 = bool1;
            }
          }
          catch (Exception localException5)
          {
            for (;;)
            {
              QLog.e("LibraryLoader", 1, str1 + "forceCopy failed again!", localException5);
              bool2 = bool1;
            }
          }
          if (!paramContext.exists())
          {
            QLog.e("LibraryLoader", 1, str1 + "forceCopy done,but the sofile is not exist!");
            return false;
          }
        }
      }
      catch (Exception localException4)
      {
        for (;;)
        {
          QLog.e("LibraryLoader", 1, "cannot load library " + paramContext.getAbsolutePath() + " from qzlib", localException4);
        }
      }
      catch (Error localError3)
      {
        for (;;)
        {
          long l;
          boolean bool1;
          label523:
          int j;
          QLog.e("LibraryLoader", 1, "cannot load library " + paramContext.getAbsolutePath() + " from qzlib", localError3);
          continue;
          if (!d(str1))
          {
            QLog.e("LibraryLoader", 1, "Copy Lib For DIFF_LENGTHS");
            j = 1;
          }
          else
          {
            if (!c(str1))
            {
              QLog.e("LibraryLoader", 1, "Copy Lib For DEBUG_AND_MD5");
              j = 1;
              continue;
              try
              {
                str1 = paramContext.getAbsolutePath();
                QLog.e("LibraryLoader", 1, "try to load library: " + str1 + " from qzlib again!");
                System.load(str1);
                jdField_a_of_type_JavaUtilHashMap.put(paramString, str1);
                a(l, bool2, paramString);
                return true;
              }
              catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
              {
                QLog.e("LibraryLoader", 1, "cannot load library " + paramContext.getAbsolutePath() + " from qzlib again", localUnsatisfiedLinkError1);
                jdField_a_of_type_JavaUtilHashMap.put(paramString, null);
                return false;
              }
              catch (Exception localException1)
              {
                for (;;)
                {
                  QLog.e("LibraryLoader", 1, "cannot load library " + paramContext.getAbsolutePath() + " from qzlib again", localException1);
                }
              }
              catch (Error localError1)
              {
                for (;;)
                {
                  QLog.e("LibraryLoader", 1, "cannot load library " + paramContext.getAbsolutePath() + " from qzlib again", localError1);
                }
              }
            }
            j = 0;
          }
        }
      }
    }
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    jdField_a_of_type_JavaUtilHashMap.remove(paramString1);
    String str1 = b(paramString1, paramString2);
    if (e(str1))
    {
      jdField_a_of_type_JavaUtilHashMap.put(paramString1, str1);
      return true;
    }
    QLog.w("LibraryLoader", 1, "prepareLibForBuildAndLoad failed, try again, libNmae=" + paramString1 + ", destDir=" + paramString2);
    String str2 = "lib" + paramString1 + ".so";
    String str3 = d(paramString2);
    str3 = str3 + File.separator + str2;
    String str4 = c() + File.separator + str2;
    int j;
    if (d(str3, str4)) {
      if (c(str3, str4)) {
        j = 0;
      }
    }
    while (j != 0)
    {
      QLog.w("LibraryLoader", 1, "prepareLibForBuildAndLoad copy and load again");
      a(a(), str2, false);
      if (!TextUtils.isEmpty(str1)) {
        new File(str1).delete();
      }
      paramString2 = b(paramString1, paramString2);
      if (!e(paramString2)) {
        break label274;
      }
      jdField_a_of_type_JavaUtilHashMap.put(paramString1, paramString2);
      return true;
      j = 1;
      continue;
      j = 1;
    }
    if (e(str1))
    {
      jdField_a_of_type_JavaUtilHashMap.put(paramString1, str1);
      return true;
    }
    label274:
    return false;
  }
  
  private static boolean a(String paramString1, String paramString2, String paramString3)
  {
    localFileOutputStream = null;
    boolean bool = true;
    for (;;)
    {
      Context localContext;
      try
      {
        localContext = jdField_a_of_type_AndroidContentContext;
        if ((localContext == null) || (paramString2 == null))
        {
          bool = false;
          return bool;
        }
        if (paramString3 != null)
        {
          str = paramString3;
          if (paramString3.trim().length() != 0) {}
        }
        else
        {
          QLog.e("LibraryLoader", 1, "not define lib out path");
          str = localContext.getFilesDir().getAbsolutePath();
        }
        new File(str).mkdirs();
        QLog.d("LibraryLoader", 1, "copy lib:" + paramString2 + " to " + str);
      }
      finally {}
      try
      {
        paramString2 = localContext.getAssets().open(paramString2);
      }
      catch (Throwable paramString1)
      {
        label226:
        paramString2 = null;
        str = null;
        paramString3 = localFileOutputStream;
        continue;
      }
      try
      {
        paramString1 = new File(str, paramString1);
      }
      catch (Throwable paramString1)
      {
        localFileOutputStream = null;
        str = null;
        paramString3 = paramString2;
        paramString2 = localFileOutputStream;
        continue;
      }
      try
      {
        if (paramString1.exists()) {
          a(paramString1);
        }
        localFileOutputStream = new FileOutputStream(paramString1);
        try
        {
          paramString3 = new byte['က'];
          if (paramString2.available() <= 0) {
            break label226;
          }
          int j = paramString2.read(paramString3);
          if (j <= 0) {
            break label226;
          }
          localFileOutputStream.write(paramString3, 0, j);
          continue;
          DataUtils.a(paramString2);
        }
        catch (Throwable localThrowable1)
        {
          str = paramString1;
          paramString3 = paramString2;
          paramString2 = localFileOutputStream;
          paramString1 = localThrowable1;
        }
      }
      catch (Throwable localThrowable2)
      {
        localFileOutputStream = null;
        paramString3 = paramString2;
        str = paramString1;
        paramString1 = localThrowable2;
        paramString2 = localFileOutputStream;
        continue;
      }
      DataUtils.a(paramString3);
      a(str);
      throw paramString1;
      localFileOutputStream.close();
      paramString2.close();
    }
  }
  
  public static int b()
  {
    return a(Build.CPU_ABI2);
  }
  
  private static String b()
  {
    File localFile2 = jdField_a_of_type_AndroidContentContext.getFilesDir();
    File localFile1 = localFile2;
    if (localFile2 == null) {
      localFile1 = jdField_a_of_type_AndroidContentContext.getCacheDir();
    }
    if (localFile1 != null) {
      return localFile1.getParent();
    }
    return "/data/data/" + jdField_a_of_type_AndroidContentContext.getPackageName();
  }
  
  public static String b(String paramString)
  {
    return b(paramString, "qzlib");
  }
  
  public static String b(String paramString1, String paramString2)
  {
    try
    {
      String str1 = "lib" + paramString1 + ".so";
      String str2 = d(paramString2);
      File localFile = new File(str2, str1);
      String str3;
      if ((!localFile.exists()) || (!e(a(), str1)))
      {
        str3 = c();
        if (!b(str1, str3)) {
          break label106;
        }
        a(a(), str3, str2, new String[] { str1 });
      }
      while (localFile.exists())
      {
        return localFile.getAbsolutePath();
        label106:
        str3 = d();
        if (b(str1, str3)) {
          a(a(), str3, str2, new String[] { str1 });
        }
      }
      return null;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("LibraryLoader", 1, "prepareLibForBuild lib=" + paramString1 + ", destDir=" + paramString2 + "  failed", localThrowable);
    }
  }
  
  private static boolean b(String paramString)
  {
    return b(paramString, "lib/armeabi");
  }
  
  /* Error */
  private static boolean b(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: getstatic 126	cooperation/qzone/Native:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   5: invokevirtual 486	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   8: astore_2
    //   9: new 108	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   16: aload_1
    //   17: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: getstatic 116	java/io/File:separator	Ljava/lang/String;
    //   23: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_0
    //   27: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: astore_1
    //   34: aload_2
    //   35: aload_1
    //   36: invokevirtual 492	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   39: astore_1
    //   40: aload_1
    //   41: ifnull +13 -> 54
    //   44: aload_1
    //   45: ifnull +7 -> 52
    //   48: aload_1
    //   49: invokevirtual 511	java/io/InputStream:close	()V
    //   52: iload_3
    //   53: ireturn
    //   54: iconst_0
    //   55: istore_3
    //   56: goto -12 -> 44
    //   59: astore_1
    //   60: ldc 28
    //   62: iconst_1
    //   63: new 108	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   70: ldc_w 531
    //   73: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: aload_0
    //   77: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: aconst_null
    //   84: invokestatic 385	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   87: iconst_0
    //   88: ifeq +11 -> 99
    //   91: new 533	java/lang/NullPointerException
    //   94: dup
    //   95: invokespecial 534	java/lang/NullPointerException:<init>	()V
    //   98: athrow
    //   99: iconst_0
    //   100: ireturn
    //   101: astore_0
    //   102: iconst_0
    //   103: ifeq +11 -> 114
    //   106: new 533	java/lang/NullPointerException
    //   109: dup
    //   110: invokespecial 534	java/lang/NullPointerException:<init>	()V
    //   113: athrow
    //   114: aload_0
    //   115: athrow
    //   116: astore_0
    //   117: iload_3
    //   118: ireturn
    //   119: astore_0
    //   120: goto -21 -> 99
    //   123: astore_1
    //   124: goto -10 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	paramString1	String
    //   0	127	1	paramString2	String
    //   8	27	2	localAssetManager	AssetManager
    //   1	117	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   34	40	59	java/io/IOException
    //   34	40	101	finally
    //   60	87	101	finally
    //   48	52	116	java/io/IOException
    //   91	99	119	java/io/IOException
    //   106	114	123	java/io/IOException
  }
  
  private static String c()
  {
    return a(a());
  }
  
  private static String c(String paramString)
  {
    return "lib/armeabi" + File.separator + paramString;
  }
  
  private static String c(String paramString1, String paramString2)
  {
    return "check_" + paramString1 + "_" + paramString2;
  }
  
  private static boolean c(String paramString)
  {
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool1 = bool3;
    boolean bool2 = bool4;
    try
    {
      String str1 = a(jdField_a_of_type_AndroidContentContext.getAssets().open(c(paramString)));
      bool1 = bool3;
      bool2 = bool4;
      if (TextUtils.isEmpty(str1)) {
        return false;
      }
      bool1 = bool3;
      bool2 = bool4;
      String str2 = a(new FileInputStream(new File(a(), paramString)));
      bool1 = bool3;
      bool2 = bool4;
      bool3 = str1.equals(str2);
      bool1 = bool3;
      bool2 = bool3;
      String str3 = a() + File.separator + paramString;
      bool1 = bool3;
      bool2 = bool3;
      QLog.e("LibraryLoader", 1, c(paramString) + " md5 = " + str1 + "," + str3 + " md5 = " + str2);
      return bool3;
    }
    catch (FileNotFoundException paramString)
    {
      paramString.printStackTrace();
      return bool1;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
    return bool2;
  }
  
  private static boolean c(String paramString1, String paramString2)
  {
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool1 = bool3;
    boolean bool2 = bool4;
    try
    {
      String str1 = a(jdField_a_of_type_AndroidContentContext.getAssets().open(paramString2));
      bool1 = bool3;
      bool2 = bool4;
      if (TextUtils.isEmpty(str1)) {
        return false;
      }
      bool1 = bool3;
      bool2 = bool4;
      String str2 = a(new FileInputStream(new File(paramString1)));
      bool1 = bool3;
      bool2 = bool4;
      bool3 = str1.equals(str2);
      bool1 = bool3;
      bool2 = bool3;
      QLog.e("LibraryLoader", 1, paramString2 + " md5 = " + str1 + "," + paramString1 + " md5 = " + str2);
      return bool3;
    }
    catch (FileNotFoundException paramString1)
    {
      paramString1.printStackTrace();
      return bool1;
    }
    catch (IOException paramString1)
    {
      paramString1.printStackTrace();
    }
    return bool2;
  }
  
  private static String d()
  {
    return a(b());
  }
  
  private static String d(String paramString)
  {
    String str = b();
    return str + File.separator + paramString;
  }
  
  /* Error */
  private static boolean d(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: new 106	java/io/File
    //   6: dup
    //   7: new 106	java/io/File
    //   10: dup
    //   11: invokestatic 275	cooperation/qzone/Native:a	()Ljava/io/File;
    //   14: aload_0
    //   15: invokespecial 223	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   18: invokevirtual 307	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   21: invokespecial 122	java/io/File:<init>	(Ljava/lang/String;)V
    //   24: astore_1
    //   25: getstatic 126	cooperation/qzone/Native:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   28: invokevirtual 486	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   31: astore_2
    //   32: aload_0
    //   33: invokestatic 304	cooperation/qzone/Native:c	(Ljava/lang/String;)Ljava/lang/String;
    //   36: astore_0
    //   37: aload_2
    //   38: aload_0
    //   39: invokevirtual 566	android/content/res/AssetManager:openFd	(Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   42: astore_3
    //   43: aload_3
    //   44: ifnonnull +5 -> 49
    //   47: iconst_1
    //   48: ireturn
    //   49: ldc 28
    //   51: iconst_1
    //   52: new 108	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   59: aload_0
    //   60: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: ldc_w 568
    //   66: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: aload_3
    //   70: invokevirtual 573	android/content/res/AssetFileDescriptor:getLength	()J
    //   73: invokevirtual 576	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   76: ldc_w 556
    //   79: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload_1
    //   83: invokevirtual 552	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   86: ldc_w 568
    //   89: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: aload_1
    //   93: invokevirtual 578	java/io/File:length	()J
    //   96: invokevirtual 576	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   99: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokestatic 287	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   105: aload_1
    //   106: invokevirtual 578	java/io/File:length	()J
    //   109: lstore 5
    //   111: aload_3
    //   112: invokevirtual 573	android/content/res/AssetFileDescriptor:getLength	()J
    //   115: lstore 7
    //   117: lload 5
    //   119: lload 7
    //   121: lcmp
    //   122: ifne +161 -> 283
    //   125: iconst_1
    //   126: istore 9
    //   128: iload 9
    //   130: istore 10
    //   132: iload 4
    //   134: ifeq +155 -> 289
    //   137: iload 9
    //   139: istore 10
    //   141: aload_2
    //   142: aload_0
    //   143: invokevirtual 492	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   146: astore_2
    //   147: ldc 28
    //   149: iconst_1
    //   150: new 108	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   157: aload_0
    //   158: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: ldc_w 580
    //   164: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: aload_2
    //   168: invokevirtual 504	java/io/InputStream:available	()I
    //   171: invokevirtual 583	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   174: ldc_w 556
    //   177: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: aload_1
    //   181: invokevirtual 552	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   184: ldc_w 568
    //   187: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: aload_1
    //   191: invokevirtual 578	java/io/File:length	()J
    //   194: invokevirtual 576	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   197: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: invokestatic 287	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   203: aload_1
    //   204: invokevirtual 578	java/io/File:length	()J
    //   207: lstore 5
    //   209: aload_2
    //   210: invokevirtual 504	java/io/InputStream:available	()I
    //   213: istore 4
    //   215: lload 5
    //   217: iload 4
    //   219: i2l
    //   220: lcmp
    //   221: ifne +6 -> 227
    //   224: iconst_1
    //   225: istore 9
    //   227: iload 9
    //   229: istore 10
    //   231: aload_2
    //   232: invokevirtual 511	java/io/InputStream:close	()V
    //   235: iload 9
    //   237: istore 10
    //   239: goto +50 -> 289
    //   242: astore_0
    //   243: iload 9
    //   245: istore 10
    //   247: aload_2
    //   248: invokevirtual 511	java/io/InputStream:close	()V
    //   251: iload 9
    //   253: istore 10
    //   255: goto +34 -> 289
    //   258: astore_0
    //   259: iload 9
    //   261: istore 10
    //   263: aload_2
    //   264: invokevirtual 511	java/io/InputStream:close	()V
    //   267: iload 9
    //   269: istore 10
    //   271: aload_0
    //   272: athrow
    //   273: astore_0
    //   274: iconst_0
    //   275: istore 10
    //   277: goto +12 -> 289
    //   280: astore_0
    //   281: iconst_1
    //   282: ireturn
    //   283: iconst_0
    //   284: istore 9
    //   286: goto -158 -> 128
    //   289: iload 10
    //   291: ireturn
    //   292: astore_3
    //   293: iconst_0
    //   294: istore 9
    //   296: iconst_1
    //   297: istore 4
    //   299: goto -171 -> 128
    //   302: astore_0
    //   303: goto -14 -> 289
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	306	0	paramString	String
    //   24	180	1	localFile	File
    //   31	233	2	localObject	Object
    //   42	70	3	localAssetFileDescriptor	android.content.res.AssetFileDescriptor
    //   292	1	3	localIOException	IOException
    //   1	297	4	j	int
    //   109	107	5	l1	long
    //   115	5	7	l2	long
    //   126	169	9	bool1	boolean
    //   130	160	10	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   147	215	242	java/io/IOException
    //   147	215	258	finally
    //   37	43	273	java/lang/Exception
    //   49	117	273	java/lang/Exception
    //   37	43	280	java/io/FileNotFoundException
    //   49	117	280	java/io/FileNotFoundException
    //   37	43	292	java/io/IOException
    //   49	117	292	java/io/IOException
    //   141	147	302	java/lang/Exception
    //   231	235	302	java/lang/Exception
    //   247	251	302	java/lang/Exception
    //   263	267	302	java/lang/Exception
    //   271	273	302	java/lang/Exception
  }
  
  /* Error */
  private static boolean d(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_1
    //   4: istore 9
    //   6: new 106	java/io/File
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 122	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore_0
    //   15: aload_0
    //   16: invokevirtual 228	java/io/File:exists	()Z
    //   19: ifne +9 -> 28
    //   22: iconst_0
    //   23: istore 9
    //   25: iload 9
    //   27: ireturn
    //   28: getstatic 126	cooperation/qzone/Native:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   31: invokevirtual 486	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   34: astore_2
    //   35: aload_2
    //   36: aload_1
    //   37: invokevirtual 566	android/content/res/AssetManager:openFd	(Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   40: astore_3
    //   41: aload_3
    //   42: ifnull -17 -> 25
    //   45: ldc 28
    //   47: iconst_1
    //   48: new 108	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   55: aload_1
    //   56: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: ldc_w 568
    //   62: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: aload_3
    //   66: invokevirtual 573	android/content/res/AssetFileDescriptor:getLength	()J
    //   69: invokevirtual 576	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   72: ldc_w 556
    //   75: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: aload_0
    //   79: invokevirtual 552	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   82: ldc_w 568
    //   85: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: aload_0
    //   89: invokevirtual 578	java/io/File:length	()J
    //   92: invokevirtual 576	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   95: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokestatic 287	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   101: aload_0
    //   102: invokevirtual 578	java/io/File:length	()J
    //   105: lstore 5
    //   107: aload_3
    //   108: invokevirtual 573	android/content/res/AssetFileDescriptor:getLength	()J
    //   111: lstore 7
    //   113: lload 5
    //   115: lload 7
    //   117: lcmp
    //   118: ifne +161 -> 279
    //   121: iconst_1
    //   122: istore 9
    //   124: iload 9
    //   126: istore 10
    //   128: iload 4
    //   130: ifeq +155 -> 285
    //   133: iload 9
    //   135: istore 10
    //   137: aload_2
    //   138: aload_1
    //   139: invokevirtual 492	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   142: astore_2
    //   143: ldc 28
    //   145: iconst_1
    //   146: new 108	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   153: aload_1
    //   154: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: ldc_w 580
    //   160: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: aload_2
    //   164: invokevirtual 504	java/io/InputStream:available	()I
    //   167: invokevirtual 583	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   170: ldc_w 556
    //   173: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: aload_0
    //   177: invokevirtual 552	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   180: ldc_w 568
    //   183: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: aload_0
    //   187: invokevirtual 578	java/io/File:length	()J
    //   190: invokevirtual 576	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   193: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: invokestatic 287	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   199: aload_0
    //   200: invokevirtual 578	java/io/File:length	()J
    //   203: lstore 5
    //   205: aload_2
    //   206: invokevirtual 504	java/io/InputStream:available	()I
    //   209: istore 4
    //   211: lload 5
    //   213: iload 4
    //   215: i2l
    //   216: lcmp
    //   217: ifne +6 -> 223
    //   220: iconst_1
    //   221: istore 9
    //   223: iload 9
    //   225: istore 10
    //   227: aload_2
    //   228: invokevirtual 511	java/io/InputStream:close	()V
    //   231: iload 9
    //   233: istore 10
    //   235: goto +50 -> 285
    //   238: astore_0
    //   239: iload 9
    //   241: istore 10
    //   243: aload_2
    //   244: invokevirtual 511	java/io/InputStream:close	()V
    //   247: iload 9
    //   249: istore 10
    //   251: goto +34 -> 285
    //   254: astore_0
    //   255: iload 9
    //   257: istore 10
    //   259: aload_2
    //   260: invokevirtual 511	java/io/InputStream:close	()V
    //   263: iload 9
    //   265: istore 10
    //   267: aload_0
    //   268: athrow
    //   269: astore_0
    //   270: iconst_0
    //   271: istore 10
    //   273: goto +12 -> 285
    //   276: astore_0
    //   277: iconst_1
    //   278: ireturn
    //   279: iconst_0
    //   280: istore 9
    //   282: goto -158 -> 124
    //   285: iload 10
    //   287: ireturn
    //   288: astore_3
    //   289: iconst_0
    //   290: istore 9
    //   292: iconst_1
    //   293: istore 4
    //   295: goto -171 -> 124
    //   298: astore_0
    //   299: goto -14 -> 285
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	302	0	paramString1	String
    //   0	302	1	paramString2	String
    //   34	226	2	localObject	Object
    //   40	68	3	localAssetFileDescriptor	android.content.res.AssetFileDescriptor
    //   288	1	3	localIOException	IOException
    //   1	293	4	j	int
    //   105	107	5	l1	long
    //   111	5	7	l2	long
    //   4	287	9	bool1	boolean
    //   126	160	10	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   143	211	238	java/io/IOException
    //   143	211	254	finally
    //   35	41	269	java/lang/Exception
    //   45	113	269	java/lang/Exception
    //   35	41	276	java/io/FileNotFoundException
    //   45	113	276	java/io/FileNotFoundException
    //   35	41	288	java/io/IOException
    //   45	113	288	java/io/IOException
    //   137	143	298	java/lang/Exception
    //   227	231	298	java/lang/Exception
    //   243	247	298	java/lang/Exception
    //   259	263	298	java/lang/Exception
    //   267	269	298	java/lang/Exception
  }
  
  private static boolean e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      try
      {
        boolean bool = new File(paramString).exists();
        if (!bool) {
          continue;
        }
        try
        {
          QLog.d("LibraryLoader", 1, "try to load: " + paramString);
          System.load(paramString);
          return true;
        }
        catch (Throwable localThrowable1)
        {
          QLog.e("LibraryLoader", 1, "cannot load , libNmae=" + paramString, localThrowable1);
          return false;
        }
        return false;
      }
      catch (Throwable localThrowable2)
      {
        QLog.e("LibraryLoader", 1, "cannot load , libNmae=" + paramString, localThrowable2);
      }
    }
  }
  
  private static boolean e(String paramString1, String paramString2)
  {
    return jdField_a_of_type_AndroidContentContext.getSharedPreferences("guarder", 0).getBoolean(c(paramString1, paramString2), false);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\Native.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */