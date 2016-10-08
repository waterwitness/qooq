package sm;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import com.tencent.securemodule.impl.AppInfo;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class as
{
  /* Error */
  public static AppInfo a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 18	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   4: astore_0
    //   5: aload_0
    //   6: aload_1
    //   7: bipush 64
    //   9: invokevirtual 24	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   12: astore_2
    //   13: new 26	com/tencent/securemodule/impl/AppInfo
    //   16: dup
    //   17: invokespecial 30	com/tencent/securemodule/impl/AppInfo:<init>	()V
    //   20: astore_0
    //   21: aload_0
    //   22: aload_1
    //   23: invokevirtual 34	com/tencent/securemodule/impl/AppInfo:setPkgName	(Ljava/lang/String;)V
    //   26: aload_0
    //   27: aload_2
    //   28: getfield 40	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   31: invokevirtual 43	com/tencent/securemodule/impl/AppInfo:setVersionName	(Ljava/lang/String;)V
    //   34: aload_0
    //   35: aload_2
    //   36: getfield 47	android/content/pm/PackageInfo:versionCode	I
    //   39: invokevirtual 51	com/tencent/securemodule/impl/AppInfo:setVersionCode	(I)V
    //   42: aload_2
    //   43: getfield 55	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   46: iconst_0
    //   47: aaload
    //   48: invokestatic 58	sm/as:a	(Landroid/content/pm/Signature;)Ljava/security/cert/Certificate;
    //   51: checkcast 60	java/security/cert/X509Certificate
    //   54: astore_1
    //   55: aload_1
    //   56: ifnull +17 -> 73
    //   59: aload_0
    //   60: aload_1
    //   61: invokevirtual 64	java/security/cert/X509Certificate:getEncoded	()[B
    //   64: invokestatic 70	sm/az:b	([B)[B
    //   67: invokestatic 73	sm/az:a	([B)Ljava/lang/String;
    //   70: invokevirtual 76	com/tencent/securemodule/impl/AppInfo:setCertMd5	(Ljava/lang/String;)V
    //   73: aload_0
    //   74: areturn
    //   75: astore_1
    //   76: aconst_null
    //   77: astore_0
    //   78: aload_1
    //   79: invokevirtual 79	android/content/pm/PackageManager$NameNotFoundException:printStackTrace	()V
    //   82: aload_0
    //   83: areturn
    //   84: astore_1
    //   85: aconst_null
    //   86: astore_0
    //   87: aload_1
    //   88: invokevirtual 80	java/security/cert/CertificateEncodingException:printStackTrace	()V
    //   91: aload_0
    //   92: areturn
    //   93: astore_1
    //   94: aconst_null
    //   95: astore_0
    //   96: aload_1
    //   97: invokevirtual 81	java/lang/Exception:printStackTrace	()V
    //   100: aload_0
    //   101: areturn
    //   102: astore_1
    //   103: goto -7 -> 96
    //   106: astore_1
    //   107: goto -20 -> 87
    //   110: astore_1
    //   111: goto -33 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	paramContext	Context
    //   0	114	1	paramString	String
    //   12	31	2	localPackageInfo	android.content.pm.PackageInfo
    // Exception table:
    //   from	to	target	type
    //   5	21	75	android/content/pm/PackageManager$NameNotFoundException
    //   5	21	84	java/security/cert/CertificateEncodingException
    //   5	21	93	java/lang/Exception
    //   21	55	102	java/lang/Exception
    //   59	73	102	java/lang/Exception
    //   21	55	106	java/security/cert/CertificateEncodingException
    //   59	73	106	java/security/cert/CertificateEncodingException
    //   21	55	110	android/content/pm/PackageManager$NameNotFoundException
    //   59	73	110	android/content/pm/PackageManager$NameNotFoundException
  }
  
  /* Error */
  public static String a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: new 87	java/util/zip/ZipFile
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 89	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   11: astore_1
    //   12: new 91	java/io/File
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 92	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: invokevirtual 96	java/io/File:exists	()Z
    //   23: istore 7
    //   25: iload 7
    //   27: ifne +46 -> 73
    //   30: iconst_0
    //   31: ifeq +11 -> 42
    //   34: new 98	java/lang/NullPointerException
    //   37: dup
    //   38: invokespecial 99	java/lang/NullPointerException:<init>	()V
    //   41: athrow
    //   42: aload 5
    //   44: astore_0
    //   45: aload_1
    //   46: ifnull +10 -> 56
    //   49: aload_1
    //   50: invokevirtual 102	java/util/zip/ZipFile:close	()V
    //   53: aload 5
    //   55: astore_0
    //   56: aload_0
    //   57: areturn
    //   58: astore_0
    //   59: aload_0
    //   60: invokevirtual 103	java/io/IOException:printStackTrace	()V
    //   63: goto -21 -> 42
    //   66: astore_0
    //   67: aload_0
    //   68: invokevirtual 103	java/io/IOException:printStackTrace	()V
    //   71: aconst_null
    //   72: areturn
    //   73: aload_1
    //   74: ldc 105
    //   76: invokevirtual 109	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   79: astore_0
    //   80: aload_0
    //   81: ifnull +157 -> 238
    //   84: new 111	java/io/BufferedReader
    //   87: dup
    //   88: new 113	java/io/InputStreamReader
    //   91: dup
    //   92: aload_1
    //   93: aload_0
    //   94: invokevirtual 117	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   97: invokespecial 120	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   100: invokespecial 123	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   103: astore_0
    //   104: aload_1
    //   105: astore_3
    //   106: aload_0
    //   107: astore_2
    //   108: aload_0
    //   109: invokevirtual 127	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   112: astore 4
    //   114: aload_0
    //   115: astore_2
    //   116: aload 4
    //   118: ifnull +122 -> 240
    //   121: aload_1
    //   122: astore_3
    //   123: aload_0
    //   124: astore_2
    //   125: aload 4
    //   127: ldc -127
    //   129: invokevirtual 135	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   132: ifeq -28 -> 104
    //   135: aload_1
    //   136: astore_3
    //   137: aload_0
    //   138: astore_2
    //   139: aload_0
    //   140: invokevirtual 127	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   143: astore 4
    //   145: aload 4
    //   147: ifnull -43 -> 104
    //   150: aload_1
    //   151: astore_3
    //   152: aload_0
    //   153: astore_2
    //   154: aload 4
    //   156: ldc -119
    //   158: invokevirtual 135	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   161: ifeq -57 -> 104
    //   164: aload_1
    //   165: astore_3
    //   166: aload_0
    //   167: astore_2
    //   168: aload 4
    //   170: ldc -117
    //   172: invokevirtual 143	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   175: istore 6
    //   177: iload 6
    //   179: ifle -75 -> 104
    //   182: aload_1
    //   183: astore_3
    //   184: aload_0
    //   185: astore_2
    //   186: aload 4
    //   188: iload 6
    //   190: iconst_1
    //   191: iadd
    //   192: invokevirtual 147	java/lang/String:substring	(I)Ljava/lang/String;
    //   195: invokevirtual 150	java/lang/String:trim	()Ljava/lang/String;
    //   198: astore 4
    //   200: aload 4
    //   202: astore_2
    //   203: aload_0
    //   204: ifnull +7 -> 211
    //   207: aload_0
    //   208: invokevirtual 151	java/io/BufferedReader:close	()V
    //   211: aload_2
    //   212: astore_0
    //   213: aload_1
    //   214: ifnull -158 -> 56
    //   217: aload_1
    //   218: invokevirtual 102	java/util/zip/ZipFile:close	()V
    //   221: aload_2
    //   222: areturn
    //   223: astore_0
    //   224: aload_0
    //   225: invokevirtual 103	java/io/IOException:printStackTrace	()V
    //   228: aload_2
    //   229: areturn
    //   230: astore_0
    //   231: aload_0
    //   232: invokevirtual 103	java/io/IOException:printStackTrace	()V
    //   235: goto -24 -> 211
    //   238: aconst_null
    //   239: astore_2
    //   240: aload_2
    //   241: ifnull +7 -> 248
    //   244: aload_2
    //   245: invokevirtual 151	java/io/BufferedReader:close	()V
    //   248: aload 5
    //   250: astore_0
    //   251: aload_1
    //   252: ifnull -196 -> 56
    //   255: aload_1
    //   256: invokevirtual 102	java/util/zip/ZipFile:close	()V
    //   259: aconst_null
    //   260: areturn
    //   261: astore_0
    //   262: aload_0
    //   263: invokevirtual 103	java/io/IOException:printStackTrace	()V
    //   266: aconst_null
    //   267: areturn
    //   268: astore_0
    //   269: aload_0
    //   270: invokevirtual 103	java/io/IOException:printStackTrace	()V
    //   273: goto -25 -> 248
    //   276: astore 4
    //   278: aconst_null
    //   279: astore_1
    //   280: aconst_null
    //   281: astore_0
    //   282: aload_1
    //   283: astore_3
    //   284: aload_0
    //   285: astore_2
    //   286: aload 4
    //   288: invokevirtual 103	java/io/IOException:printStackTrace	()V
    //   291: aload_0
    //   292: ifnull +7 -> 299
    //   295: aload_0
    //   296: invokevirtual 151	java/io/BufferedReader:close	()V
    //   299: aload 5
    //   301: astore_0
    //   302: aload_1
    //   303: ifnull -247 -> 56
    //   306: aload_1
    //   307: invokevirtual 102	java/util/zip/ZipFile:close	()V
    //   310: aconst_null
    //   311: areturn
    //   312: astore_0
    //   313: aload_0
    //   314: invokevirtual 103	java/io/IOException:printStackTrace	()V
    //   317: aconst_null
    //   318: areturn
    //   319: astore_0
    //   320: aload_0
    //   321: invokevirtual 103	java/io/IOException:printStackTrace	()V
    //   324: goto -25 -> 299
    //   327: astore_0
    //   328: aconst_null
    //   329: astore_1
    //   330: aconst_null
    //   331: astore_2
    //   332: aload_2
    //   333: ifnull +7 -> 340
    //   336: aload_2
    //   337: invokevirtual 151	java/io/BufferedReader:close	()V
    //   340: aload_1
    //   341: ifnull +7 -> 348
    //   344: aload_1
    //   345: invokevirtual 102	java/util/zip/ZipFile:close	()V
    //   348: aload_0
    //   349: athrow
    //   350: astore_2
    //   351: aload_2
    //   352: invokevirtual 103	java/io/IOException:printStackTrace	()V
    //   355: goto -15 -> 340
    //   358: astore_1
    //   359: aload_1
    //   360: invokevirtual 103	java/io/IOException:printStackTrace	()V
    //   363: goto -15 -> 348
    //   366: astore_0
    //   367: aconst_null
    //   368: astore_2
    //   369: goto -37 -> 332
    //   372: astore_0
    //   373: aload_3
    //   374: astore_1
    //   375: goto -43 -> 332
    //   378: astore 4
    //   380: aconst_null
    //   381: astore_0
    //   382: goto -100 -> 282
    //   385: astore 4
    //   387: goto -105 -> 282
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	390	0	paramString	String
    //   11	334	1	localZipFile1	java.util.zip.ZipFile
    //   358	2	1	localIOException1	IOException
    //   374	1	1	localObject1	Object
    //   107	230	2	localObject2	Object
    //   350	2	2	localIOException2	IOException
    //   368	1	2	localObject3	Object
    //   105	269	3	localZipFile2	java.util.zip.ZipFile
    //   112	89	4	str	String
    //   276	11	4	localIOException3	IOException
    //   378	1	4	localIOException4	IOException
    //   385	1	4	localIOException5	IOException
    //   1	299	5	localObject4	Object
    //   175	17	6	i	int
    //   23	3	7	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   34	42	58	java/io/IOException
    //   49	53	66	java/io/IOException
    //   217	221	223	java/io/IOException
    //   207	211	230	java/io/IOException
    //   255	259	261	java/io/IOException
    //   244	248	268	java/io/IOException
    //   3	12	276	java/io/IOException
    //   306	310	312	java/io/IOException
    //   295	299	319	java/io/IOException
    //   3	12	327	finally
    //   336	340	350	java/io/IOException
    //   344	348	358	java/io/IOException
    //   12	25	366	finally
    //   73	80	366	finally
    //   84	104	366	finally
    //   108	114	372	finally
    //   125	135	372	finally
    //   139	145	372	finally
    //   154	164	372	finally
    //   168	177	372	finally
    //   186	200	372	finally
    //   286	291	372	finally
    //   12	25	378	java/io/IOException
    //   73	80	378	java/io/IOException
    //   84	104	378	java/io/IOException
    //   108	114	385	java/io/IOException
    //   125	135	385	java/io/IOException
    //   139	145	385	java/io/IOException
    //   154	164	385	java/io/IOException
    //   168	177	385	java/io/IOException
    //   186	200	385	java/io/IOException
  }
  
  private static Certificate a(Signature paramSignature)
  {
    paramSignature = new ByteArrayInputStream(paramSignature.toByteArray());
    try
    {
      X509Certificate localX509Certificate = (X509Certificate)CertificateFactory.getInstance("X.509").generateCertificate(paramSignature);
      if (paramSignature != null) {}
      try
      {
        paramSignature.close();
        return localX509Certificate;
      }
      catch (IOException paramSignature)
      {
        paramSignature.printStackTrace();
        return localX509Certificate;
      }
      return null;
    }
    catch (CertificateException localCertificateException)
    {
      localCertificateException.printStackTrace();
      if (paramSignature != null) {
        try
        {
          paramSignature.close();
          return null;
        }
        catch (IOException paramSignature)
        {
          paramSignature.printStackTrace();
          return null;
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (paramSignature != null) {
        try
        {
          paramSignature.close();
          return null;
        }
        catch (IOException paramSignature)
        {
          paramSignature.printStackTrace();
          return null;
        }
      }
    }
    finally
    {
      if (paramSignature != null) {}
      try
      {
        paramSignature.close();
        throw ((Throwable)localObject);
      }
      catch (IOException paramSignature)
      {
        for (;;)
        {
          paramSignature.printStackTrace();
        }
      }
    }
  }
  
  public static List<AppInfo> a(Context paramContext, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    PackageManager localPackageManager = paramContext.getPackageManager();
    Iterator localIterator = localPackageManager.getInstalledApplications(0).iterator();
    while (localIterator.hasNext())
    {
      ApplicationInfo localApplicationInfo = (ApplicationInfo)localIterator.next();
      label60:
      AppInfo localAppInfo;
      if ((localApplicationInfo.flags & 0x1) != 0)
      {
        i = 1;
        if ((i != 0) && (!paramBoolean)) {
          break label191;
        }
        localAppInfo = a(paramContext, localApplicationInfo.packageName);
        if (localAppInfo == null) {
          continue;
        }
        localAppInfo.setSoftName(az.a(localPackageManager.getApplicationLabel(localApplicationInfo).toString()));
        if (i == 0) {
          break label193;
        }
      }
      label191:
      label193:
      for (int i = 1;; i = 0)
      {
        localAppInfo.setAppType(i);
        localAppInfo.setFileSize(new File(localApplicationInfo.sourceDir).length());
        localAppInfo.setApkPath(localApplicationInfo.sourceDir);
        localArrayList.add(localAppInfo);
        ax.a("CloudScan", "add app " + localApplicationInfo.packageName);
        break;
        i = 0;
        break label60;
        break;
      }
    }
    return localArrayList;
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool2 = false;
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      paramContext = localPackageManager.getApplicationInfo(paramContext.getPackageName(), 8192);
      boolean bool1 = bool2;
      if (paramContext != null)
      {
        int i = paramContext.flags;
        bool1 = bool2;
        if ((i & 0x1) != 0) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
      return false;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  public static String b(Context paramContext)
  {
    Object localObject = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    paramContext = new StringBuffer();
    int i;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      i = 0;
    }
    for (;;)
    {
      if (((Iterator)localObject).hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
        if (localRunningAppProcessInfo != null)
        {
          paramContext.append(localRunningAppProcessInfo.processName);
          paramContext.append(";");
          int j = i + 1;
          i = j;
          if (j <= 100) {}
        }
      }
      else
      {
        if (paramContext.length() > 0) {
          paramContext.deleteCharAt(paramContext.length() - 1);
        }
        return paramContext.toString();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\sm\as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */