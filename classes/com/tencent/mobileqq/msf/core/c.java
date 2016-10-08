package com.tencent.mobileqq.msf.core;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.Environment;
import android.os.StatFs;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;

public class c
{
  static int a = -1;
  private static final String b = "MSF.C.CoreUtil";
  private static String c = Environment.getExternalStorageDirectory().getPath() + "/MSF/files";
  
  public static int a(byte[] paramArrayOfByte, int paramInt)
  {
    return paramArrayOfByte[(paramInt + 3)] & 0xFF | paramArrayOfByte[(paramInt + 2)] << 8 & 0xFF00 | paramArrayOfByte[(paramInt + 1)] << 16 & 0xFF0000 | paramArrayOfByte[(paramInt + 0)] << 24 & 0xFF000000;
  }
  
  public static File a(String paramString)
  {
    try
    {
      paramString = new File(paramString + "/load/");
      if (!paramString.exists()) {
        paramString.mkdirs();
      }
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static String a(Context paramContext)
  {
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        localObject2 = paramContext.getFilesDir();
        if (localObject2 != null) {
          continue;
        }
        paramContext = paramContext.getCacheDir();
        if (paramContext != null) {
          continue;
        }
        if (!QLog.isColorLevel()) {
          break label251;
        }
        QLog.w("MSF.C.CoreUtil", 2, "load cache dir is null");
        paramContext = null;
        if (paramContext != null) {
          continue;
        }
        localObject2 = c;
        File localFile = new File((String)localObject2);
        paramContext = (Context)localObject2;
        if (!localFile.exists())
        {
          localFile.mkdirs();
          paramContext = (Context)localObject2;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.CoreUtil", 2, "load save root dir is " + paramContext);
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject2;
        int i;
        paramContext = (Context)localObject1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("MSF.C.CoreUtil", 2, "getSaveRootPath error ", localThrowable);
        paramContext = (Context)localObject1;
        continue;
      }
      finally {}
      return paramContext;
      localObject2 = paramContext.getAbsolutePath();
      i = ((String)localObject2).lastIndexOf('/');
      paramContext = (Context)localObject2;
      if (i != -1)
      {
        paramContext = ((String)localObject2).substring(0, i);
        paramContext = paramContext + "/files/";
        continue;
        paramContext = ((File)localObject2).getAbsolutePath();
        continue;
        localObject2 = new File(paramContext);
        if (!((File)localObject2).exists()) {
          ((File)localObject2).mkdirs();
        }
        if ((!((File)localObject2).exists()) || (!((File)localObject2).canWrite()))
        {
          paramContext = c;
          new File(paramContext).mkdirs();
          continue;
          label251:
          paramContext = null;
        }
      }
    }
  }
  
  public static String a(InputStream paramInputStream)
    throws IOException
  {
    StringBuffer localStringBuffer = new StringBuffer();
    byte[] arrayOfByte = new byte[64];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      localStringBuffer.append(new String(arrayOfByte, 0, i));
    }
    return localStringBuffer.toString();
  }
  
  /* Error */
  public static void a(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: new 27	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokestatic 139	com/tencent/mobileqq/msf/core/c:h	(Landroid/content/Context;)Ljava/lang/String;
    //   8: invokespecial 56	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore_0
    //   12: aload_0
    //   13: invokevirtual 60	java/io/File:exists	()Z
    //   16: ifeq +8 -> 24
    //   19: aload_0
    //   20: invokevirtual 142	java/io/File:delete	()Z
    //   23: pop
    //   24: aload_0
    //   25: invokevirtual 145	java/io/File:createNewFile	()Z
    //   28: pop
    //   29: new 147	java/io/FileOutputStream
    //   32: dup
    //   33: aload_0
    //   34: invokespecial 150	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   37: astore_2
    //   38: aload_2
    //   39: astore_0
    //   40: aload_2
    //   41: iload_1
    //   42: invokestatic 153	com/tencent/mobileqq/msf/core/c:a	(I)[B
    //   45: invokevirtual 157	java/io/FileOutputStream:write	([B)V
    //   48: aload_2
    //   49: ifnull +7 -> 56
    //   52: aload_2
    //   53: invokevirtual 160	java/io/FileOutputStream:close	()V
    //   56: return
    //   57: astore_0
    //   58: aload_0
    //   59: invokevirtual 163	java/io/IOException:printStackTrace	()V
    //   62: return
    //   63: astore_3
    //   64: aconst_null
    //   65: astore_2
    //   66: aload_2
    //   67: astore_0
    //   68: aload_3
    //   69: invokevirtual 164	java/lang/Exception:printStackTrace	()V
    //   72: aload_2
    //   73: ifnull -17 -> 56
    //   76: aload_2
    //   77: invokevirtual 160	java/io/FileOutputStream:close	()V
    //   80: return
    //   81: astore_0
    //   82: aload_0
    //   83: invokevirtual 163	java/io/IOException:printStackTrace	()V
    //   86: return
    //   87: astore_2
    //   88: aconst_null
    //   89: astore_0
    //   90: aload_0
    //   91: ifnull +7 -> 98
    //   94: aload_0
    //   95: invokevirtual 160	java/io/FileOutputStream:close	()V
    //   98: aload_2
    //   99: athrow
    //   100: astore_0
    //   101: aload_0
    //   102: invokevirtual 163	java/io/IOException:printStackTrace	()V
    //   105: goto -7 -> 98
    //   108: astore_2
    //   109: goto -19 -> 90
    //   112: astore_3
    //   113: goto -47 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	paramContext	Context
    //   0	116	1	paramInt	int
    //   37	40	2	localFileOutputStream	java.io.FileOutputStream
    //   87	12	2	localObject1	Object
    //   108	1	2	localObject2	Object
    //   63	6	3	localException1	Exception
    //   112	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   52	56	57	java/io/IOException
    //   24	38	63	java/lang/Exception
    //   76	80	81	java/io/IOException
    //   24	38	87	finally
    //   94	98	100	java/io/IOException
    //   40	48	108	finally
    //   68	72	108	finally
    //   40	48	112	java/lang/Exception
  }
  
  private static void a(Context paramContext, String paramString, int paramInt, String[] paramArrayOfString)
    throws IOException
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.CoreUtil", 2, "MsfCore init ->realCopySoLib begin.");
    }
    String[] arrayOfString = paramContext.getAssets().list("lib/" + paramString);
    String str1 = d(paramContext);
    int k = arrayOfString.length;
    int i = 0;
    if (i < k)
    {
      String str2 = arrayOfString[i];
      int m = paramArrayOfString.length;
      int j = 0;
      for (;;)
      {
        if (j < m)
        {
          String str3 = paramArrayOfString[j];
          if (!str3.equals(str2)) {
            break label181;
          }
          if (!a("lib/" + paramString + "/" + str2, str1, paramContext))
          {
            if (MsfCore.soCopyFailList == null) {
              MsfCore.soCopyFailList = new StringBuilder();
            }
            MsfCore.soCopyFailList.append(str3).append("|");
            MsfCore.soCopyResultCode = 3;
          }
        }
        i += 1;
        break;
        label181:
        j += 1;
      }
    }
    a(paramContext, paramInt);
    j(paramContext);
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.CoreUtil", 2, "MsfCore init ->realCopySoLib end.");
    }
  }
  
  public static void a(Context paramContext, String paramString, boolean paramBoolean, int paramInt, String[] paramArrayOfString)
    throws IOException
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.CoreUtil", 2, "MsfCore init ->copySoLib begin " + paramBoolean);
    }
    if (paramBoolean) {
      a(paramContext, paramString, paramInt, paramArrayOfString);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.CoreUtil", 2, "MsfCore init ->copySoLib end.");
      }
      return;
      try
      {
        String[] arrayOfString1 = m(paramContext);
        String[] arrayOfString2 = l(paramContext);
        if ((arrayOfString1 == null) || (arrayOfString2 == null) || (!arrayOfString2[0].equals(arrayOfString1[0])) || (!arrayOfString2[1].equals(arrayOfString1[1]))) {
          a(paramContext, paramString, paramInt, paramArrayOfString);
        }
      }
      catch (Exception paramContext)
      {
        QLog.d("MSF.C.CoreUtil", 1, "check package jni id error " + paramContext);
        MsfCore.soCopyResultCode = 2;
        MsfCore.mException = paramContext;
      }
    }
  }
  
  public static boolean a()
  {
    System.out.println("bRet=" + false);
    return false;
  }
  
  public static boolean a(String paramString, Context paramContext)
  {
    boolean bool2;
    if (paramContext == null)
    {
      bool2 = false;
      return bool2;
    }
    File localFile2 = new File(d(paramContext) + "lib" + paramString + ".so");
    File localFile1 = localFile2;
    if (!localFile2.exists()) {
      localFile1 = new File(paramContext.getFilesDir().getParent() + "/lib/lib" + paramString + ".so");
    }
    if (localFile1.exists()) {}
    for (;;)
    {
      try
      {
        System.load(localFile1.getAbsolutePath());
        boolean bool1 = true;
        bool2 = bool1;
        if (bool1) {
          break;
        }
        bool1 = false;
      }
      catch (UnsatisfiedLinkError paramContext)
      {
        try
        {
          System.loadLibrary(paramString);
          return true;
        }
        catch (UnsatisfiedLinkError paramContext)
        {
          if (!QLog.isColorLevel()) {
            break label208;
          }
          QLog.d("MSF.C.CoreUtil", 2, "cannot load library " + paramString);
        }
        paramContext = paramContext;
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.CoreUtil", 2, "cannot load library " + localFile1.getAbsolutePath());
        }
      }
    }
    label208:
    return false;
  }
  
  /* Error */
  private static boolean a(String paramString1, String paramString2, Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: iconst_0
    //   4: istore 6
    //   6: ldc 2
    //   8: monitorenter
    //   9: aload_2
    //   10: ifnull +16 -> 26
    //   13: aload_0
    //   14: ifnull +12 -> 26
    //   17: aload_0
    //   18: ldc -1
    //   20: invokevirtual 272	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   23: ifne +13 -> 36
    //   26: iconst_4
    //   27: putstatic 201	com/tencent/mobileqq/msf/core/MsfCore:soCopyResultCode	I
    //   30: ldc 2
    //   32: monitorexit
    //   33: iload 6
    //   35: ireturn
    //   36: aload_1
    //   37: ifnull +15 -> 52
    //   40: aload_1
    //   41: astore_3
    //   42: aload_1
    //   43: invokevirtual 275	java/lang/String:trim	()Ljava/lang/String;
    //   46: invokevirtual 279	java/lang/String:length	()I
    //   49: ifne +26 -> 75
    //   52: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   55: ifeq +12 -> 67
    //   58: ldc 11
    //   60: iconst_2
    //   61: ldc_w 281
    //   64: invokestatic 284	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   67: aload_2
    //   68: invokevirtual 71	android/content/Context:getFilesDir	()Ljava/io/File;
    //   71: invokevirtual 93	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   74: astore_3
    //   75: new 27	java/io/File
    //   78: dup
    //   79: aload_3
    //   80: invokespecial 56	java/io/File:<init>	(Ljava/lang/String;)V
    //   83: invokevirtual 63	java/io/File:mkdirs	()Z
    //   86: pop
    //   87: aload_0
    //   88: bipush 47
    //   90: invokevirtual 99	java/lang/String:lastIndexOf	(I)I
    //   93: istore 5
    //   95: iload 5
    //   97: iflt +184 -> 281
    //   100: aload_0
    //   101: iload 5
    //   103: iconst_1
    //   104: iadd
    //   105: invokevirtual 287	java/lang/String:substring	(I)Ljava/lang/String;
    //   108: astore_1
    //   109: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   112: ifeq +29 -> 141
    //   115: ldc 11
    //   117: iconst_2
    //   118: new 16	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   125: ldc_w 289
    //   128: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: aload_0
    //   132: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokestatic 90	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   141: aload_2
    //   142: invokevirtual 171	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   145: aload_0
    //   146: invokevirtual 293	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   149: astore_0
    //   150: new 27	java/io/File
    //   153: dup
    //   154: new 16	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   161: aload_3
    //   162: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: ldc -69
    //   167: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: aload_1
    //   171: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: invokespecial 56	java/io/File:<init>	(Ljava/lang/String;)V
    //   180: astore_1
    //   181: aload_1
    //   182: invokevirtual 60	java/io/File:exists	()Z
    //   185: ifeq +8 -> 193
    //   188: aload_1
    //   189: invokevirtual 142	java/io/File:delete	()Z
    //   192: pop
    //   193: aload_1
    //   194: invokevirtual 145	java/io/File:createNewFile	()Z
    //   197: pop
    //   198: new 147	java/io/FileOutputStream
    //   201: dup
    //   202: aload_1
    //   203: invokespecial 150	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   206: astore_2
    //   207: sipush 4096
    //   210: newarray <illegal type>
    //   212: astore_1
    //   213: aload_0
    //   214: invokevirtual 296	java/io/InputStream:available	()I
    //   217: ifle +69 -> 286
    //   220: aload_0
    //   221: aload_1
    //   222: invokevirtual 125	java/io/InputStream:read	([B)I
    //   225: istore 5
    //   227: iload 5
    //   229: ifle +57 -> 286
    //   232: aload_2
    //   233: aload_1
    //   234: iconst_0
    //   235: iload 5
    //   237: invokevirtual 298	java/io/FileOutputStream:write	([BII)V
    //   240: goto -27 -> 213
    //   243: astore_3
    //   244: aload_0
    //   245: astore_1
    //   246: aload_3
    //   247: astore_0
    //   248: aload_2
    //   249: ifnull +7 -> 256
    //   252: aload_2
    //   253: invokevirtual 160	java/io/FileOutputStream:close	()V
    //   256: aload_1
    //   257: ifnull +7 -> 264
    //   260: aload_1
    //   261: invokevirtual 299	java/io/InputStream:close	()V
    //   264: iconst_5
    //   265: putstatic 201	com/tencent/mobileqq/msf/core/MsfCore:soCopyResultCode	I
    //   268: aload_0
    //   269: putstatic 235	com/tencent/mobileqq/msf/core/MsfCore:mException	Ljava/lang/Exception;
    //   272: goto -242 -> 30
    //   275: astore_0
    //   276: ldc 2
    //   278: monitorexit
    //   279: aload_0
    //   280: athrow
    //   281: aload_0
    //   282: astore_1
    //   283: goto -174 -> 109
    //   286: aload_2
    //   287: invokevirtual 160	java/io/FileOutputStream:close	()V
    //   290: aload_0
    //   291: invokevirtual 299	java/io/InputStream:close	()V
    //   294: iconst_1
    //   295: istore 6
    //   297: goto -267 -> 30
    //   300: astore_2
    //   301: goto -45 -> 256
    //   304: astore_1
    //   305: goto -41 -> 264
    //   308: astore_0
    //   309: aconst_null
    //   310: astore_1
    //   311: aload 4
    //   313: astore_2
    //   314: goto -66 -> 248
    //   317: astore_2
    //   318: aload_0
    //   319: astore_1
    //   320: aload_2
    //   321: astore_0
    //   322: aload 4
    //   324: astore_2
    //   325: goto -77 -> 248
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	328	0	paramString1	String
    //   0	328	1	paramString2	String
    //   0	328	2	paramContext	Context
    //   41	121	3	str	String
    //   243	4	3	localException	Exception
    //   1	322	4	localObject	Object
    //   93	143	5	i	int
    //   4	292	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   207	213	243	java/lang/Exception
    //   213	227	243	java/lang/Exception
    //   232	240	243	java/lang/Exception
    //   286	294	243	java/lang/Exception
    //   17	26	275	finally
    //   26	30	275	finally
    //   42	52	275	finally
    //   52	67	275	finally
    //   67	75	275	finally
    //   75	95	275	finally
    //   100	109	275	finally
    //   109	141	275	finally
    //   141	150	275	finally
    //   150	193	275	finally
    //   193	207	275	finally
    //   207	213	275	finally
    //   213	227	275	finally
    //   232	240	275	finally
    //   252	256	275	finally
    //   260	264	275	finally
    //   264	272	275	finally
    //   286	294	275	finally
    //   252	256	300	java/io/IOException
    //   260	264	304	java/io/IOException
    //   141	150	308	java/lang/Exception
    //   150	193	317	java/lang/Exception
    //   193	207	317	java/lang/Exception
  }
  
  public static byte[] a(int paramInt)
  {
    return new byte[] { (byte)(paramInt >>> 24 & 0xFF), (byte)(paramInt >>> 16 & 0xFF), (byte)(paramInt >>> 8 & 0xFF), (byte)(paramInt & 0xFF) };
  }
  
  public static File b(String paramString)
  {
    try
    {
      paramString = new File(paramString + "/cacheTemp/");
      if (!paramString.exists()) {
        paramString.mkdirs();
      }
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public static String b(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokevirtual 71	android/content/Context:getFilesDir	()Ljava/io/File;
    //   7: invokevirtual 93	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   10: astore_1
    //   11: aload_1
    //   12: ifnonnull +25 -> 37
    //   15: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   18: ifeq +12 -> 30
    //   21: ldc 11
    //   23: iconst_2
    //   24: ldc_w 303
    //   27: invokestatic 85	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   30: aconst_null
    //   31: astore_0
    //   32: ldc 2
    //   34: monitorexit
    //   35: aload_0
    //   36: areturn
    //   37: new 27	java/io/File
    //   40: dup
    //   41: aload_1
    //   42: invokespecial 56	java/io/File:<init>	(Ljava/lang/String;)V
    //   45: astore_2
    //   46: aload_1
    //   47: astore_0
    //   48: aload_2
    //   49: invokevirtual 60	java/io/File:exists	()Z
    //   52: ifne -20 -> 32
    //   55: aload_2
    //   56: invokevirtual 63	java/io/File:mkdirs	()Z
    //   59: pop
    //   60: aload_1
    //   61: astore_0
    //   62: goto -30 -> 32
    //   65: astore_0
    //   66: ldc 2
    //   68: monitorexit
    //   69: aload_0
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	paramContext	Context
    //   10	51	1	str	String
    //   45	11	2	localFile	File
    // Exception table:
    //   from	to	target	type
    //   3	11	65	finally
    //   15	30	65	finally
    //   37	46	65	finally
    //   48	60	65	finally
  }
  
  /* Error */
  static String c(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 308	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   6: astore_0
    //   7: aload_0
    //   8: ifnull +22 -> 30
    //   11: aload_0
    //   12: ldc_w 310
    //   15: invokevirtual 272	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   18: ifeq +12 -> 30
    //   21: ldc_w 310
    //   24: astore_0
    //   25: ldc 2
    //   27: monitorexit
    //   28: aload_0
    //   29: areturn
    //   30: aload_0
    //   31: ifnull +20 -> 51
    //   34: aload_0
    //   35: ldc_w 312
    //   38: invokevirtual 272	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   41: ifeq +10 -> 51
    //   44: ldc_w 314
    //   47: astore_0
    //   48: goto -23 -> 25
    //   51: ldc_w 316
    //   54: astore_0
    //   55: goto -30 -> 25
    //   58: astore_0
    //   59: ldc 2
    //   61: monitorexit
    //   62: aload_0
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	paramContext	Context
    // Exception table:
    //   from	to	target	type
    //   3	7	58	finally
    //   11	21	58	finally
    //   34	44	58	finally
  }
  
  public static String d(Context paramContext)
  {
    return paramContext.getFilesDir().getParent() + "/txlib/";
  }
  
  public static int e(Context paramContext)
  {
    PackageManager localPackageManager;
    if ((a == -1) && (paramContext != null)) {
      localPackageManager = paramContext.getPackageManager();
    }
    try
    {
      a = localPackageManager.getPackageInfo(paramContext.getPackageName(), 0).versionCode;
      return a;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  public static String f(Context paramContext)
  {
    Object localObject = "";
    if (paramContext != null) {
      localObject = paramContext.getPackageManager();
    }
    try
    {
      localObject = ((PackageManager)localObject).getPackageInfo(paramContext.getPackageName(), 0).versionName;
      return (String)localObject;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return "";
  }
  
  /* Error */
  public static int g(Context paramContext)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore 4
    //   3: new 27	java/io/File
    //   6: dup
    //   7: aload_0
    //   8: invokestatic 347	com/tencent/mobileqq/msf/core/c:i	(Landroid/content/Context;)Ljava/lang/String;
    //   11: invokespecial 56	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore_1
    //   15: aload_1
    //   16: invokevirtual 60	java/io/File:exists	()Z
    //   19: ifeq +8 -> 27
    //   22: aload_1
    //   23: invokevirtual 142	java/io/File:delete	()Z
    //   26: pop
    //   27: new 27	java/io/File
    //   30: dup
    //   31: aload_0
    //   32: invokestatic 139	com/tencent/mobileqq/msf/core/c:h	(Landroid/content/Context;)Ljava/lang/String;
    //   35: invokespecial 56	java/io/File:<init>	(Ljava/lang/String;)V
    //   38: astore_0
    //   39: iload 4
    //   41: istore 5
    //   43: aload_0
    //   44: invokevirtual 60	java/io/File:exists	()Z
    //   47: ifeq +61 -> 108
    //   50: new 349	java/io/FileInputStream
    //   53: dup
    //   54: aload_0
    //   55: invokespecial 350	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   58: astore_1
    //   59: iload 4
    //   61: istore_3
    //   62: aload_1
    //   63: astore_0
    //   64: aload_1
    //   65: invokevirtual 351	java/io/FileInputStream:available	()I
    //   68: iconst_4
    //   69: if_icmpne +25 -> 94
    //   72: aload_1
    //   73: astore_0
    //   74: iconst_4
    //   75: newarray <illegal type>
    //   77: astore_2
    //   78: aload_1
    //   79: astore_0
    //   80: aload_1
    //   81: aload_2
    //   82: invokevirtual 352	java/io/FileInputStream:read	([B)I
    //   85: pop
    //   86: aload_1
    //   87: astore_0
    //   88: aload_2
    //   89: iconst_0
    //   90: invokestatic 354	com/tencent/mobileqq/msf/core/c:a	([BI)I
    //   93: istore_3
    //   94: iload_3
    //   95: istore 5
    //   97: aload_1
    //   98: ifnull +10 -> 108
    //   101: aload_1
    //   102: invokevirtual 355	java/io/FileInputStream:close	()V
    //   105: iload_3
    //   106: istore 5
    //   108: iload 5
    //   110: ireturn
    //   111: astore_0
    //   112: aload_0
    //   113: invokevirtual 163	java/io/IOException:printStackTrace	()V
    //   116: iload_3
    //   117: ireturn
    //   118: astore_2
    //   119: aconst_null
    //   120: astore_1
    //   121: aload_1
    //   122: astore_0
    //   123: aload_2
    //   124: invokevirtual 164	java/lang/Exception:printStackTrace	()V
    //   127: iload 4
    //   129: istore 5
    //   131: aload_1
    //   132: ifnull -24 -> 108
    //   135: aload_1
    //   136: invokevirtual 355	java/io/FileInputStream:close	()V
    //   139: iconst_m1
    //   140: ireturn
    //   141: astore_0
    //   142: aload_0
    //   143: invokevirtual 163	java/io/IOException:printStackTrace	()V
    //   146: iconst_m1
    //   147: ireturn
    //   148: astore_1
    //   149: aconst_null
    //   150: astore_0
    //   151: aload_0
    //   152: ifnull +7 -> 159
    //   155: aload_0
    //   156: invokevirtual 355	java/io/FileInputStream:close	()V
    //   159: aload_1
    //   160: athrow
    //   161: astore_0
    //   162: aload_0
    //   163: invokevirtual 163	java/io/IOException:printStackTrace	()V
    //   166: goto -7 -> 159
    //   169: astore_1
    //   170: goto -19 -> 151
    //   173: astore_2
    //   174: goto -53 -> 121
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	paramContext	Context
    //   14	122	1	localObject1	Object
    //   148	12	1	localObject2	Object
    //   169	1	1	localObject3	Object
    //   77	12	2	arrayOfByte	byte[]
    //   118	6	2	localException1	Exception
    //   173	1	2	localException2	Exception
    //   61	56	3	i	int
    //   1	127	4	j	int
    //   41	89	5	k	int
    // Exception table:
    //   from	to	target	type
    //   101	105	111	java/io/IOException
    //   50	59	118	java/lang/Exception
    //   135	139	141	java/io/IOException
    //   50	59	148	finally
    //   155	159	161	java/io/IOException
    //   64	72	169	finally
    //   74	78	169	finally
    //   80	86	169	finally
    //   88	94	169	finally
    //   123	127	169	finally
    //   64	72	173	java/lang/Exception
    //   74	78	173	java/lang/Exception
    //   80	86	173	java/lang/Exception
    //   88	94	173	java/lang/Exception
  }
  
  public static String h(Context paramContext)
  {
    return paramContext.getFilesDir() + "/verFile";
  }
  
  public static String i(Context paramContext)
  {
    return paramContext.getFilesDir() + "/verFile2";
  }
  
  /* Error */
  public static void j(Context paramContext)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_1
    //   4: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +12 -> 19
    //   10: ldc 11
    //   12: iconst_2
    //   13: ldc_w 361
    //   16: invokestatic 90	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   19: aload_0
    //   20: invokevirtual 171	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   23: ldc_w 363
    //   26: invokevirtual 293	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   29: astore_3
    //   30: aload_3
    //   31: astore_1
    //   32: new 147	java/io/FileOutputStream
    //   35: dup
    //   36: new 16	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   43: aload_0
    //   44: invokevirtual 71	android/content/Context:getFilesDir	()Ljava/io/File;
    //   47: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   50: ldc_w 365
    //   53: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokespecial 366	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   62: astore_0
    //   63: sipush 128
    //   66: newarray <illegal type>
    //   68: astore_2
    //   69: aload_1
    //   70: aload_2
    //   71: invokevirtual 125	java/io/InputStream:read	([B)I
    //   74: istore 4
    //   76: iload 4
    //   78: ifle +32 -> 110
    //   81: aload_0
    //   82: aload_2
    //   83: iconst_0
    //   84: iload 4
    //   86: invokevirtual 369	java/io/OutputStream:write	([BII)V
    //   89: goto -20 -> 69
    //   92: astore_2
    //   93: aload_1
    //   94: ifnull +7 -> 101
    //   97: aload_1
    //   98: invokevirtual 299	java/io/InputStream:close	()V
    //   101: aload_0
    //   102: ifnull +7 -> 109
    //   105: aload_0
    //   106: invokevirtual 370	java/io/OutputStream:close	()V
    //   109: return
    //   110: aload_1
    //   111: ifnull +7 -> 118
    //   114: aload_1
    //   115: invokevirtual 299	java/io/InputStream:close	()V
    //   118: aload_0
    //   119: ifnull -10 -> 109
    //   122: aload_0
    //   123: invokevirtual 370	java/io/OutputStream:close	()V
    //   126: return
    //   127: astore_0
    //   128: aconst_null
    //   129: astore_1
    //   130: aload_1
    //   131: ifnull +7 -> 138
    //   134: aload_1
    //   135: invokevirtual 299	java/io/InputStream:close	()V
    //   138: aload_2
    //   139: ifnull +7 -> 146
    //   142: aload_2
    //   143: invokevirtual 370	java/io/OutputStream:close	()V
    //   146: aload_0
    //   147: athrow
    //   148: astore_0
    //   149: goto -19 -> 130
    //   152: astore_3
    //   153: aload_0
    //   154: astore_2
    //   155: aload_3
    //   156: astore_0
    //   157: goto -27 -> 130
    //   160: astore_0
    //   161: aconst_null
    //   162: astore_0
    //   163: goto -70 -> 93
    //   166: astore_0
    //   167: aconst_null
    //   168: astore_0
    //   169: goto -76 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	paramContext	Context
    //   3	132	1	localObject1	Object
    //   1	82	2	arrayOfByte	byte[]
    //   92	51	2	localException	Exception
    //   154	1	2	localContext	Context
    //   29	2	3	localInputStream	InputStream
    //   152	4	3	localObject2	Object
    //   74	11	4	i	int
    // Exception table:
    //   from	to	target	type
    //   63	69	92	java/lang/Exception
    //   69	76	92	java/lang/Exception
    //   81	89	92	java/lang/Exception
    //   19	30	127	finally
    //   32	63	148	finally
    //   63	69	152	finally
    //   69	76	152	finally
    //   81	89	152	finally
    //   19	30	160	java/lang/Exception
    //   32	63	166	java/lang/Exception
  }
  
  public static long k(Context paramContext)
  {
    try
    {
      paramContext = new StatFs(d(paramContext));
      long l = paramContext.getBlockSize();
      l = paramContext.getAvailableBlocks() * l / 1024L;
      return l;
    }
    catch (Exception paramContext) {}
    return 0L;
  }
  
  private static String[] l(Context paramContext)
  {
    int k = 0;
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "";
    arrayOfString[1] = "";
    for (;;)
    {
      try
      {
        paramContext = new FileInputStream(paramContext.getFilesDir() + "/jni.ini");
        if (paramContext == null) {}
      }
      catch (IOException paramContext)
      {
        int i;
        String str;
        int j;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("MSF.C.CoreUtil", 2, "get oldJniID FileNotFoundException " + paramContext.getMessage());
        paramContext.printStackTrace();
        continue;
        j += 1;
        continue;
      }
      try
      {
        paramContext = new BufferedReader(new InputStreamReader(paramContext));
        i = 0;
        str = paramContext.readLine();
        j = k;
        if (str != null)
        {
          j = k;
          if (i < 2)
          {
            arrayOfString[i] = str;
            i += 1;
            continue;
          }
        }
        if (j < arrayOfString.length)
        {
          if (arrayOfString[j] == null) {
            continue;
          }
          arrayOfString[j].trim();
          if (arrayOfString[j].length() <= 4) {
            continue;
          }
          arrayOfString[j] = arrayOfString[j].substring(4);
          continue;
        }
        paramContext.close();
      }
      catch (IOException paramContext)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("MSF.C.CoreUtil", 2, "get oldJniID IOException " + paramContext.getMessage());
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.CoreUtil", 2, "get old jni id = " + Arrays.toString(arrayOfString));
    }
    return arrayOfString;
  }
  
  private static String[] m(Context paramContext)
  {
    String[] arrayOfString = new String[2];
    for (;;)
    {
      Object localObject;
      int i;
      int j;
      try
      {
        localObject = paramContext.getAssets().open("jni.ini");
        paramContext = arrayOfString;
        if (localObject == null) {
          continue;
        }
        paramContext = new BufferedReader(new InputStreamReader((InputStream)localObject));
        i = 0;
        localObject = paramContext.readLine();
        if (localObject == null) {
          break label217;
        }
        j = 1;
      }
      catch (Exception paramContext)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("MSF.C.CoreUtil", 2, "read jni error " + paramContext);
        paramContext = new String[2];
        paramContext[0] = "0";
        paramContext[1] = "0";
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("MSF.C.CoreUtil", 2, "get new jni id = " + Arrays.toString(paramContext));
        return paramContext;
      }
      paramContext = arrayOfString;
      if (i < arrayOfString.length)
      {
        if (arrayOfString[i] != null)
        {
          arrayOfString[i].trim();
          if (arrayOfString[i].length() > 4) {
            arrayOfString[i] = arrayOfString[i].substring(4);
          }
        }
        i += 1;
      }
      else
      {
        label190:
        if (i < 2) {}
        for (int k = 1;; k = 0)
        {
          if ((k & j) == 0) {
            break label229;
          }
          arrayOfString[i] = localObject;
          i += 1;
          break;
          label217:
          j = 0;
          break label190;
        }
        label229:
        i = 0;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\core\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */