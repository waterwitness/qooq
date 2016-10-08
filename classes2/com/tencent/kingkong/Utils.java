package com.tencent.kingkong;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.Signature;
import android.os.Build.VERSION;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class Utils
{
  private static final String a = "KingKongUtils";
  
  public Utils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String a(int paramInt)
  {
    SecureRandom localSecureRandom = new SecureRandom();
    byte[] arrayOfByte = new byte[paramInt];
    localSecureRandom.nextBytes(arrayOfByte);
    return Base64.encodeToString(arrayOfByte, 0);
  }
  
  public static String a(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    int i = Process.myPid();
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
    while (paramContext.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      if (localRunningAppProcessInfo.pid == i) {
        return localRunningAppProcessInfo.processName;
      }
    }
    Common.Log.a("KingKongUtils", "Unable to get current process name!");
    return "";
  }
  
  public static String a(InputStream paramInputStream)
  {
    MessageDigest localMessageDigest;
    try
    {
      BufferedInputStream localBufferedInputStream = new BufferedInputStream(paramInputStream);
      localMessageDigest = MessageDigest.getInstance("SHA1");
      localMessageDigest.reset();
      byte[] arrayOfByte = new byte[' '];
      for (;;)
      {
        int i = localBufferedInputStream.read(arrayOfByte);
        if (i <= 0) {
          break;
        }
        localMessageDigest.update(arrayOfByte, 0, i);
      }
      localBufferedInputStream.close();
    }
    catch (Throwable paramInputStream)
    {
      return "";
    }
    paramInputStream.close();
    paramInputStream = Base64.encodeToString(localMessageDigest.digest(), 2).trim();
    return paramInputStream;
  }
  
  /* Error */
  public static String a(String paramString)
  {
    // Byte code:
    //   0: new 136	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 139	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: invokevirtual 142	java/io/File:exists	()Z
    //   11: ifne +35 -> 46
    //   14: ldc 8
    //   16: new 144	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   23: ldc -109
    //   25: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: aload_0
    //   29: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: ldc -103
    //   34: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokestatic 88	com/tencent/kingkong/Common$Log:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: ldc 36
    //   45: areturn
    //   46: new 144	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   53: astore_3
    //   54: aconst_null
    //   55: astore_2
    //   56: new 158	java/io/BufferedReader
    //   59: dup
    //   60: new 160	java/io/InputStreamReader
    //   63: dup
    //   64: new 162	java/io/FileInputStream
    //   67: dup
    //   68: aload_0
    //   69: invokespecial 163	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   72: invokespecial 164	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   75: invokespecial 167	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   78: astore_1
    //   79: aload_1
    //   80: astore_0
    //   81: aload_1
    //   82: invokevirtual 170	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   85: astore_2
    //   86: aload_2
    //   87: ifnull +34 -> 121
    //   90: aload_1
    //   91: astore_0
    //   92: aload_3
    //   93: aload_2
    //   94: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: pop
    //   98: goto -19 -> 79
    //   101: astore_2
    //   102: aload_1
    //   103: astore_0
    //   104: aload_2
    //   105: invokevirtual 173	java/io/IOException:printStackTrace	()V
    //   108: aload_1
    //   109: ifnull +7 -> 116
    //   112: aload_1
    //   113: invokevirtual 174	java/io/BufferedReader:close	()V
    //   116: aload_3
    //   117: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: areturn
    //   121: aload_1
    //   122: ifnull -6 -> 116
    //   125: aload_1
    //   126: invokevirtual 174	java/io/BufferedReader:close	()V
    //   129: goto -13 -> 116
    //   132: astore_0
    //   133: goto -17 -> 116
    //   136: astore_0
    //   137: aload_2
    //   138: astore_1
    //   139: aload_1
    //   140: ifnull +7 -> 147
    //   143: aload_1
    //   144: invokevirtual 174	java/io/BufferedReader:close	()V
    //   147: aload_0
    //   148: athrow
    //   149: astore_0
    //   150: goto -34 -> 116
    //   153: astore_1
    //   154: goto -7 -> 147
    //   157: astore_2
    //   158: aload_0
    //   159: astore_1
    //   160: aload_2
    //   161: astore_0
    //   162: goto -23 -> 139
    //   165: astore_2
    //   166: aconst_null
    //   167: astore_1
    //   168: goto -66 -> 102
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	paramString	String
    //   78	66	1	localObject1	Object
    //   153	1	1	localIOException1	IOException
    //   159	9	1	str1	String
    //   55	39	2	str2	String
    //   101	37	2	localIOException2	IOException
    //   157	4	2	localObject2	Object
    //   165	1	2	localIOException3	IOException
    //   53	64	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   81	86	101	java/io/IOException
    //   92	98	101	java/io/IOException
    //   125	129	132	java/io/IOException
    //   56	79	136	finally
    //   112	116	149	java/io/IOException
    //   143	147	153	java/io/IOException
    //   81	86	157	finally
    //   92	98	157	finally
    //   104	108	157	finally
    //   56	79	165	java/io/IOException
  }
  
  public static String a(String paramString1, String paramString2)
  {
    JarFile localJarFile = new JarFile(paramString1);
    paramString1 = localJarFile.entries();
    JarEntry localJarEntry;
    do
    {
      if (!paramString1.hasMoreElements()) {
        break;
      }
      localJarEntry = (JarEntry)paramString1.nextElement();
    } while ((localJarEntry.isDirectory()) || (!localJarEntry.getName().equals(paramString2)));
    for (paramString1 = a(localJarFile.getInputStream(localJarEntry));; paramString1 = "")
    {
      localJarFile.close();
      return paramString1;
    }
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA1");
      localMessageDigest.reset();
      localMessageDigest.update(paramArrayOfByte, 0, paramArrayOfByte.length);
      paramArrayOfByte = Base64.encodeToString(localMessageDigest.digest(), 2);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      Common.Log.a("Lynn", "Unable to calculate SHA1");
    }
    return "";
  }
  
  public static StringBuilder a()
  {
    return new StringBuilder();
  }
  
  public static void a(Context paramContext)
  {
    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("SHARED_PREFERENCE_KINGKONG_PATCH", 0).edit();
    localEditor.clear();
    localEditor.commit();
    a(new File(paramContext.getFilesDir().getAbsolutePath() + Common.C + "kingkong" + Common.C + "download"));
    a(new File(paramContext.getFilesDir().getAbsolutePath() + Common.C + "kingkong" + Common.C + "patches"));
  }
  
  /* Error */
  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 5
    //   9: iconst_0
    //   10: istore 9
    //   12: new 260	java/io/FileOutputStream
    //   15: dup
    //   16: aload_2
    //   17: invokespecial 261	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   20: astore_2
    //   21: aload_2
    //   22: astore_3
    //   23: aload 6
    //   25: astore 4
    //   27: new 93	java/io/BufferedInputStream
    //   30: dup
    //   31: aload_0
    //   32: invokevirtual 265	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   35: aload_1
    //   36: invokevirtual 271	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   39: invokespecial 96	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   42: astore_0
    //   43: sipush 8192
    //   46: newarray <illegal type>
    //   48: astore_1
    //   49: aload_0
    //   50: aload_1
    //   51: invokevirtual 111	java/io/BufferedInputStream:read	([B)I
    //   54: istore 7
    //   56: iload 7
    //   58: iconst_m1
    //   59: if_icmpeq +60 -> 119
    //   62: aload_2
    //   63: aload_1
    //   64: iconst_0
    //   65: iload 7
    //   67: invokevirtual 276	java/io/OutputStream:write	([BII)V
    //   70: goto -21 -> 49
    //   73: astore_3
    //   74: aload_0
    //   75: astore_1
    //   76: aload_3
    //   77: astore_0
    //   78: aload_2
    //   79: astore_3
    //   80: aload_1
    //   81: astore 4
    //   83: ldc 8
    //   85: aload_0
    //   86: invokevirtual 279	java/io/IOException:getMessage	()Ljava/lang/String;
    //   89: invokestatic 88	com/tencent/kingkong/Common$Log:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: aload_1
    //   93: ifnull +7 -> 100
    //   96: aload_1
    //   97: invokevirtual 118	java/io/BufferedInputStream:close	()V
    //   100: iload 9
    //   102: istore 8
    //   104: aload_2
    //   105: ifnull +11 -> 116
    //   108: aload_2
    //   109: invokevirtual 280	java/io/OutputStream:close	()V
    //   112: iload 9
    //   114: istore 8
    //   116: iload 8
    //   118: ireturn
    //   119: iconst_1
    //   120: istore 8
    //   122: aload_0
    //   123: ifnull +7 -> 130
    //   126: aload_0
    //   127: invokevirtual 118	java/io/BufferedInputStream:close	()V
    //   130: aload_2
    //   131: ifnull -15 -> 116
    //   134: aload_2
    //   135: invokevirtual 280	java/io/OutputStream:close	()V
    //   138: iconst_1
    //   139: ireturn
    //   140: astore_0
    //   141: iconst_1
    //   142: ireturn
    //   143: astore_0
    //   144: aconst_null
    //   145: astore_2
    //   146: aload 4
    //   148: ifnull +8 -> 156
    //   151: aload 4
    //   153: invokevirtual 118	java/io/BufferedInputStream:close	()V
    //   156: aload_2
    //   157: ifnull +7 -> 164
    //   160: aload_2
    //   161: invokevirtual 280	java/io/OutputStream:close	()V
    //   164: aload_0
    //   165: athrow
    //   166: astore_0
    //   167: goto -37 -> 130
    //   170: astore_0
    //   171: goto -71 -> 100
    //   174: astore_0
    //   175: iconst_0
    //   176: ireturn
    //   177: astore_1
    //   178: goto -22 -> 156
    //   181: astore_1
    //   182: goto -18 -> 164
    //   185: astore_0
    //   186: aload_3
    //   187: astore_2
    //   188: goto -42 -> 146
    //   191: astore_1
    //   192: aload_0
    //   193: astore 4
    //   195: aload_1
    //   196: astore_0
    //   197: goto -51 -> 146
    //   200: astore_0
    //   201: aconst_null
    //   202: astore_2
    //   203: aload 5
    //   205: astore_1
    //   206: goto -128 -> 78
    //   209: astore_0
    //   210: aload 5
    //   212: astore_1
    //   213: goto -135 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	216	0	paramContext	Context
    //   0	216	1	paramString1	String
    //   0	216	2	paramString2	String
    //   22	1	3	str1	String
    //   73	4	3	localIOException	IOException
    //   79	108	3	str2	String
    //   1	193	4	localObject1	Object
    //   7	204	5	localObject2	Object
    //   4	20	6	localObject3	Object
    //   54	12	7	i	int
    //   102	19	8	bool1	boolean
    //   10	103	9	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   43	49	73	java/io/IOException
    //   49	56	73	java/io/IOException
    //   62	70	73	java/io/IOException
    //   134	138	140	java/io/IOException
    //   12	21	143	finally
    //   126	130	166	java/io/IOException
    //   96	100	170	java/io/IOException
    //   108	112	174	java/io/IOException
    //   151	156	177	java/io/IOException
    //   160	164	181	java/io/IOException
    //   27	43	185	finally
    //   83	92	185	finally
    //   43	49	191	finally
    //   49	56	191	finally
    //   62	70	191	finally
    //   12	21	200	java/io/IOException
    //   27	43	209	java/io/IOException
  }
  
  public static boolean a(File paramFile)
  {
    if (!paramFile.exists()) {}
    while (!paramFile.isDirectory()) {
      return false;
    }
    paramFile = paramFile.listFiles();
    int i = 0;
    for (;;)
    {
      if (i >= paramFile.length) {
        break label61;
      }
      File localFile = paramFile[i];
      if (((localFile.isDirectory()) && (!a(localFile))) || (!localFile.delete())) {
        break;
      }
      i += 1;
    }
    label61:
    return true;
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    paramString = paramString.split(",");
    int j = Build.VERSION.SDK_INT;
    int k = paramString.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < k)
      {
        if (String.valueOf(j).equals(paramString[i].trim())) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    try
    {
      JarFile localJarFile = new JarFile(paramString1);
      Enumeration localEnumeration = localJarFile.entries();
      while (localEnumeration.hasMoreElements())
      {
        Object localObject = (JarEntry)localEnumeration.nextElement();
        if ((!((JarEntry)localObject).isDirectory()) && (!((JarEntry)localObject).getName().startsWith("META-INF/")))
        {
          localObject = a(localJarFile, (JarEntry)localObject);
          if (localObject == null) {
            return false;
          }
          if (localObject.length != 1) {
            return false;
          }
          if (!new Signature(localObject[0].getEncoded()).equals(new Signature(paramString2)))
          {
            Common.Log.a("KingKongUtils", "Signature mismatch in : " + paramString1);
            return false;
          }
        }
      }
    }
    catch (IOException paramString1)
    {
      Common.Log.a("KingKongUtils", "Check file signature failed : " + paramString1);
      return false;
    }
    catch (CertificateEncodingException paramString1)
    {
      Common.Log.a("KingKongUtils", "Check file signature failed : " + paramString1);
      return false;
    }
    Common.Log.a("KingKongUtils", "Check file signatures OK : " + paramString1);
    return true;
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    return a(paramString1, paramString2, paramString3, false, "");
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return a(paramString1, paramString2, paramString3, true, paramString4);
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if (paramString3.startsWith("META-INF/"))
    {
      Common.Log.a("KingKongUtils", "Reload file with unexpected name : " + paramString3);
      return false;
    }
    if (!paramBoolean) {
      try
      {
        if (a(paramString2, paramString3, paramString1))
        {
          Common.Log.a("KingKongUtils", "Current file changed, reload OK : " + paramString1 + ", " + paramString2);
          return true;
        }
        Common.Log.a("KingKongUtils", "Current file changed and unable to be reloaded : " + paramString1 + ", " + paramString2);
        return false;
      }
      catch (Exception paramString2)
      {
        Common.Log.a("KingKongUtils", "Error occurred while reload file " + paramString1 + " : " + paramString2);
        return false;
      }
    }
    if (b(paramString1, paramString2))
    {
      Common.Log.a("KingKongUtils", "Current file changed, copy OK : " + paramString1);
      return true;
    }
    Common.Log.a("KingKongUtils", "Current file changed and unable to be repaired : " + paramString1);
    return false;
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4)
  {
    try
    {
      JarFile localJarFile = new JarFile(paramString1);
      Enumeration localEnumeration = localJarFile.entries();
      while (localEnumeration.hasMoreElements())
      {
        JarEntry localJarEntry = (JarEntry)localEnumeration.nextElement();
        if ((!localJarEntry.isDirectory()) && (localJarEntry.getName().equals(paramString2)))
        {
          if (paramBoolean)
          {
            Certificate[] arrayOfCertificate = a(localJarFile, localJarEntry);
            if ((arrayOfCertificate == null) || (arrayOfCertificate.length != 1)) {
              continue;
            }
            if (!new Signature(arrayOfCertificate[0].getEncoded()).equals(new Signature(paramString4)))
            {
              Common.Log.a("KingKongUtils", "Extract " + paramString2 + " from " + paramString1 + " failed : Signature mismatch!");
              return false;
            }
          }
          if (a(localJarFile, localJarEntry, paramString3))
          {
            Common.Log.a("KingKongUtils", "Extract " + paramString2 + " from " + paramString1 + " OK");
            return true;
          }
          Common.Log.a("KingKongUtils", "Extract " + paramString2 + " from " + paramString1 + " failed : Read error");
          return false;
        }
      }
      Common.Log.a("KingKongUtils", "Extract " + paramString2 + " from " + paramString1 + " failed : No such file in Apk");
      return false;
    }
    catch (Exception paramString3)
    {
      Common.Log.a("KingKongUtils", "Extract " + paramString2 + " from " + paramString1 + " failed : Exception " + paramString3);
    }
    return false;
  }
  
  private static boolean a(JarFile paramJarFile, JarEntry paramJarEntry, String paramString)
  {
    try
    {
      byte[] arrayOfByte = new byte[' '];
      paramJarFile = new BufferedInputStream(paramJarFile.getInputStream(paramJarEntry));
      paramJarEntry = new FileOutputStream(paramString, false);
      for (;;)
      {
        int i = paramJarFile.read(arrayOfByte, 0, arrayOfByte.length);
        if (i == -1) {
          break;
        }
        paramJarEntry.write(arrayOfByte, 0, i);
      }
      paramJarFile.close();
      paramJarEntry.close();
      return true;
    }
    catch (RuntimeException paramJarFile)
    {
      return false;
    }
    catch (IOException paramJarFile) {}
    return false;
  }
  
  private static Certificate[] a(JarFile paramJarFile, JarEntry paramJarEntry)
  {
    Object localObject = null;
    try
    {
      byte[] arrayOfByte = new byte[' '];
      paramJarFile = new BufferedInputStream(paramJarFile.getInputStream(paramJarEntry));
      while (paramJarFile.read(arrayOfByte, 0, arrayOfByte.length) != -1) {}
      paramJarFile.close();
      paramJarFile = (JarFile)localObject;
      if (paramJarEntry != null) {
        paramJarFile = paramJarEntry.getCertificates();
      }
      return paramJarFile;
    }
    catch (RuntimeException paramJarFile)
    {
      return null;
    }
    catch (IOException paramJarFile) {}
    return null;
  }
  
  public static String b(Context paramContext)
  {
    if (paramContext == null) {
      paramContext = "";
    }
    for (;;)
    {
      return paramContext;
      try
      {
        paramContext = paramContext.getPackageName();
        boolean bool = TextUtils.isEmpty(paramContext);
        if (bool) {
          return "";
        }
      }
      catch (Exception paramContext) {}
    }
    return "";
  }
  
  public static String b(String paramString)
  {
    Object localObject = new File(paramString);
    if (!((File)localObject).exists())
    {
      Common.Log.a("KingKongUtils", "file " + paramString + " does not exist.");
      return "";
    }
    paramString = new byte[Long.valueOf(((File)localObject).length()).intValue()];
    try
    {
      localObject = new FileInputStream((File)localObject);
      ((FileInputStream)localObject).read(paramString);
      ((FileInputStream)localObject).close();
      return new String(paramString);
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    Object localObject = new File(paramString1);
    if (((File)localObject).exists()) {
      ((File)localObject).delete();
    }
    try
    {
      localObject = new FileOutputStream(paramString1, false);
      FileInputStream localFileInputStream = new FileInputStream(paramString2);
      byte[] arrayOfByte = new byte[' '];
      for (;;)
      {
        int i = localFileInputStream.read(arrayOfByte);
        if (i <= 0)
        {
          ((FileOutputStream)localObject).close();
          localFileInputStream.close();
          Common.Log.a("KingKongUtils", "Copy file " + paramString2 + " to " + paramString1 + " OK");
          return true;
        }
        ((FileOutputStream)localObject).write(arrayOfByte, 0, i);
      }
      return false;
    }
    catch (IOException localIOException)
    {
      Common.Log.a("KingKongUtils", "Copy file " + paramString2 + " to " + paramString1 + " failed:" + localIOException);
      localIOException.printStackTrace();
    }
  }
  
  public static String c(String paramString)
  {
    try
    {
      paramString = a(new FileInputStream(paramString));
      return paramString;
    }
    catch (FileNotFoundException paramString) {}
    return "";
  }
  
  /* Error */
  public static boolean c(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: new 432	java/net/URL
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 433	java/net/URL:<init>	(Ljava/lang/String;)V
    //   14: invokevirtual 437	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   17: checkcast 439	java/net/HttpURLConnection
    //   20: astore_2
    //   21: aload_2
    //   22: invokevirtual 442	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   25: astore_3
    //   26: new 260	java/io/FileOutputStream
    //   29: dup
    //   30: aload_1
    //   31: iconst_0
    //   32: invokespecial 385	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   35: astore 4
    //   37: aload_2
    //   38: sipush 300
    //   41: invokevirtual 446	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   44: aload_2
    //   45: sipush 300
    //   48: invokevirtual 449	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   51: aload_2
    //   52: invokevirtual 452	java/net/HttpURLConnection:connect	()V
    //   55: sipush 1024
    //   58: newarray <illegal type>
    //   60: astore 5
    //   62: aload_3
    //   63: aload 5
    //   65: invokevirtual 453	java/io/InputStream:read	([B)I
    //   68: istore 7
    //   70: iload 7
    //   72: ifgt +66 -> 138
    //   75: ldc 8
    //   77: new 144	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   84: ldc_w 455
    //   87: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload_0
    //   91: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: ldc_w 350
    //   97: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: aload_1
    //   101: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: invokestatic 88	com/tencent/kingkong/Common$Log:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: aload_3
    //   111: ifnull +7 -> 118
    //   114: aload_3
    //   115: invokevirtual 121	java/io/InputStream:close	()V
    //   118: aload 4
    //   120: ifnull +8 -> 128
    //   123: aload 4
    //   125: invokevirtual 390	java/io/FileOutputStream:close	()V
    //   128: aload_2
    //   129: ifnull +7 -> 136
    //   132: aload_2
    //   133: invokevirtual 458	java/net/HttpURLConnection:disconnect	()V
    //   136: iconst_1
    //   137: ireturn
    //   138: aload 4
    //   140: aload 5
    //   142: iconst_0
    //   143: iload 7
    //   145: invokevirtual 389	java/io/FileOutputStream:write	([BII)V
    //   148: goto -86 -> 62
    //   151: astore 6
    //   153: aload 4
    //   155: astore 5
    //   157: aload 6
    //   159: astore 4
    //   161: ldc 8
    //   163: new 144	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   170: ldc_w 460
    //   173: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: aload_0
    //   177: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: ldc_w 350
    //   183: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: aload_1
    //   187: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: ldc_w 356
    //   193: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: aload 4
    //   198: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   201: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokestatic 88	com/tencent/kingkong/Common$Log:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   207: aload_3
    //   208: ifnull +7 -> 215
    //   211: aload_3
    //   212: invokevirtual 121	java/io/InputStream:close	()V
    //   215: aload 5
    //   217: ifnull +8 -> 225
    //   220: aload 5
    //   222: invokevirtual 390	java/io/FileOutputStream:close	()V
    //   225: aload_2
    //   226: ifnull +7 -> 233
    //   229: aload_2
    //   230: invokevirtual 458	java/net/HttpURLConnection:disconnect	()V
    //   233: iconst_0
    //   234: ireturn
    //   235: astore_0
    //   236: aconst_null
    //   237: astore_2
    //   238: aconst_null
    //   239: astore_3
    //   240: aload 6
    //   242: astore 5
    //   244: aload_3
    //   245: ifnull +7 -> 252
    //   248: aload_3
    //   249: invokevirtual 121	java/io/InputStream:close	()V
    //   252: aload 5
    //   254: ifnull +8 -> 262
    //   257: aload 5
    //   259: invokevirtual 390	java/io/FileOutputStream:close	()V
    //   262: aload_2
    //   263: ifnull +7 -> 270
    //   266: aload_2
    //   267: invokevirtual 458	java/net/HttpURLConnection:disconnect	()V
    //   270: aload_0
    //   271: athrow
    //   272: astore_0
    //   273: goto -155 -> 118
    //   276: astore_0
    //   277: goto -149 -> 128
    //   280: astore_0
    //   281: goto -66 -> 215
    //   284: astore_0
    //   285: goto -60 -> 225
    //   288: astore_1
    //   289: goto -37 -> 252
    //   292: astore_1
    //   293: goto -31 -> 262
    //   296: astore_0
    //   297: aconst_null
    //   298: astore_3
    //   299: aload 6
    //   301: astore 5
    //   303: goto -59 -> 244
    //   306: astore_0
    //   307: aload 6
    //   309: astore 5
    //   311: goto -67 -> 244
    //   314: astore_0
    //   315: aload 4
    //   317: astore 5
    //   319: goto -75 -> 244
    //   322: astore_0
    //   323: goto -79 -> 244
    //   326: astore 4
    //   328: aconst_null
    //   329: astore_2
    //   330: aconst_null
    //   331: astore_3
    //   332: goto -171 -> 161
    //   335: astore 4
    //   337: aconst_null
    //   338: astore_3
    //   339: goto -178 -> 161
    //   342: astore 4
    //   344: goto -183 -> 161
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	347	0	paramString1	String
    //   0	347	1	paramString2	String
    //   20	310	2	localHttpURLConnection	java.net.HttpURLConnection
    //   25	314	3	localInputStream	InputStream
    //   35	281	4	localObject1	Object
    //   326	1	4	localThrowable1	Throwable
    //   335	1	4	localThrowable2	Throwable
    //   342	1	4	localThrowable3	Throwable
    //   4	314	5	localObject2	Object
    //   1	1	6	localObject3	Object
    //   151	157	6	localThrowable4	Throwable
    //   68	76	7	i	int
    // Exception table:
    //   from	to	target	type
    //   37	62	151	java/lang/Throwable
    //   62	70	151	java/lang/Throwable
    //   75	110	151	java/lang/Throwable
    //   138	148	151	java/lang/Throwable
    //   6	21	235	finally
    //   114	118	272	java/io/IOException
    //   123	128	276	java/io/IOException
    //   211	215	280	java/io/IOException
    //   220	225	284	java/io/IOException
    //   248	252	288	java/io/IOException
    //   257	262	292	java/io/IOException
    //   21	26	296	finally
    //   26	37	306	finally
    //   37	62	314	finally
    //   62	70	314	finally
    //   75	110	314	finally
    //   138	148	314	finally
    //   161	207	322	finally
    //   6	21	326	java/lang/Throwable
    //   21	26	335	java/lang/Throwable
    //   26	37	342	java/lang/Throwable
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\kingkong\Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */