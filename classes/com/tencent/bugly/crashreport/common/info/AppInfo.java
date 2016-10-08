package com.tencent.bugly.crashreport.common.info;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Bundle;
import android.os.Process;
import com.tencent.bugly.proguard.a;
import com.tencent.bugly.proguard.v;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.Principal;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppInfo
{
  private static ActivityManager a;
  
  static
  {
    "@buglyAllChannel@".split(",");
    "@buglyAllChannelPriority@".split(",");
  }
  
  /* Error */
  public static String a(int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: new 29	java/io/FileReader
    //   6: dup
    //   7: new 31	java/lang/StringBuilder
    //   10: dup
    //   11: ldc 33
    //   13: invokespecial 36	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   16: iload_0
    //   17: invokevirtual 40	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   20: ldc 42
    //   22: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokespecial 50	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   31: astore_2
    //   32: aload_2
    //   33: astore_1
    //   34: sipush 512
    //   37: newarray <illegal type>
    //   39: astore_3
    //   40: aload_2
    //   41: astore_1
    //   42: aload_2
    //   43: aload_3
    //   44: invokevirtual 54	java/io/FileReader:read	([C)I
    //   47: pop
    //   48: aload_2
    //   49: astore_1
    //   50: iload 4
    //   52: aload_3
    //   53: arraylength
    //   54: if_icmpge +19 -> 73
    //   57: aload_3
    //   58: iload 4
    //   60: caload
    //   61: ifeq +12 -> 73
    //   64: iload 4
    //   66: iconst_1
    //   67: iadd
    //   68: istore 4
    //   70: goto -22 -> 48
    //   73: aload_2
    //   74: astore_1
    //   75: new 14	java/lang/String
    //   78: dup
    //   79: aload_3
    //   80: invokespecial 57	java/lang/String:<init>	([C)V
    //   83: iconst_0
    //   84: iload 4
    //   86: invokevirtual 61	java/lang/String:substring	(II)Ljava/lang/String;
    //   89: astore_3
    //   90: aload_3
    //   91: astore_1
    //   92: aload_2
    //   93: invokevirtual 64	java/io/FileReader:close	()V
    //   96: aload_1
    //   97: areturn
    //   98: astore_3
    //   99: aconst_null
    //   100: astore_2
    //   101: aload_2
    //   102: astore_1
    //   103: aload_3
    //   104: invokestatic 69	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   107: ifne +9 -> 116
    //   110: aload_2
    //   111: astore_1
    //   112: aload_3
    //   113: invokevirtual 72	java/lang/Throwable:printStackTrace	()V
    //   116: iload_0
    //   117: invokestatic 75	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   120: astore_3
    //   121: aload_3
    //   122: astore_1
    //   123: aload_2
    //   124: ifnull -28 -> 96
    //   127: aload_2
    //   128: invokevirtual 64	java/io/FileReader:close	()V
    //   131: aload_3
    //   132: areturn
    //   133: astore_1
    //   134: aload_3
    //   135: areturn
    //   136: astore_2
    //   137: aconst_null
    //   138: astore_1
    //   139: aload_1
    //   140: ifnull +7 -> 147
    //   143: aload_1
    //   144: invokevirtual 64	java/io/FileReader:close	()V
    //   147: aload_2
    //   148: athrow
    //   149: astore_2
    //   150: aload_1
    //   151: areturn
    //   152: astore_1
    //   153: goto -6 -> 147
    //   156: astore_2
    //   157: goto -18 -> 139
    //   160: astore_3
    //   161: goto -60 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	paramInt	int
    //   33	90	1	localObject1	Object
    //   133	1	1	localThrowable1	Throwable
    //   138	13	1	str1	String
    //   152	1	1	localThrowable2	Throwable
    //   31	97	2	localFileReader	java.io.FileReader
    //   136	12	2	localObject2	Object
    //   149	1	2	localThrowable3	Throwable
    //   156	1	2	localObject3	Object
    //   39	52	3	localObject4	Object
    //   98	15	3	localThrowable4	Throwable
    //   120	15	3	str2	String
    //   160	1	3	localThrowable5	Throwable
    //   1	84	4	i	int
    // Exception table:
    //   from	to	target	type
    //   3	32	98	java/lang/Throwable
    //   127	131	133	java/lang/Throwable
    //   3	32	136	finally
    //   92	96	149	java/lang/Throwable
    //   143	147	152	java/lang/Throwable
    //   34	40	156	finally
    //   42	48	156	finally
    //   50	57	156	finally
    //   75	90	156	finally
    //   103	110	156	finally
    //   112	116	156	finally
    //   34	40	160	java/lang/Throwable
    //   42	48	160	java/lang/Throwable
    //   50	57	160	java/lang/Throwable
    //   75	90	160	java/lang/Throwable
  }
  
  public static String a(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    try
    {
      paramContext = paramContext.getPackageName();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      if (!v.a(paramContext)) {
        paramContext.printStackTrace();
      }
    }
    return "fail";
  }
  
  public static String a(PackageInfo paramPackageInfo)
  {
    if (paramPackageInfo == null) {
      return null;
    }
    try
    {
      paramPackageInfo = paramPackageInfo.versionName;
      return paramPackageInfo;
    }
    catch (Throwable paramPackageInfo)
    {
      if (!v.a(paramPackageInfo)) {
        paramPackageInfo.printStackTrace();
      }
    }
    return "fail";
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {}
    for (;;)
    {
      try
      {
        localObject1 = CertificateFactory.getInstance("X.509");
        if (localObject1 == null) {
          return null;
        }
        paramArrayOfByte = (X509Certificate)((CertificateFactory)localObject1).generateCertificate(new ByteArrayInputStream(paramArrayOfByte));
        if (paramArrayOfByte == null) {
          return null;
        }
        localStringBuilder.append("Issuer|");
        localObject1 = paramArrayOfByte.getIssuerDN();
        if (localObject1 == null) {
          continue;
        }
        localStringBuilder.append(((Principal)localObject1).toString());
        localStringBuilder.append("\n");
        localStringBuilder.append("SerialNumber|");
        localObject2 = paramArrayOfByte.getSerialNumber();
        if (localObject1 == null) {
          continue;
        }
        localStringBuilder.append(((BigInteger)localObject2).toString(16));
      }
      catch (CertificateException paramArrayOfByte)
      {
        Object localObject1;
        Object localObject2;
        if (v.a(paramArrayOfByte)) {
          continue;
        }
        paramArrayOfByte.printStackTrace();
        continue;
        localStringBuilder.append("unknown");
        continue;
      }
      catch (Throwable paramArrayOfByte)
      {
        if (v.a(paramArrayOfByte)) {
          continue;
        }
        paramArrayOfByte.printStackTrace();
        continue;
        localStringBuilder.append("unknown");
        continue;
        localStringBuilder.append("unknown");
        continue;
        localStringBuilder.append("unknown");
        continue;
        localStringBuilder.append("unknown");
        continue;
      }
      localStringBuilder.append("\n");
      localStringBuilder.append("NotBefore|");
      localObject2 = paramArrayOfByte.getNotBefore();
      if (localObject1 == null) {
        continue;
      }
      localStringBuilder.append(((Date)localObject2).toString());
      localStringBuilder.append("\n");
      localStringBuilder.append("NotAfter|");
      localObject2 = paramArrayOfByte.getNotAfter();
      if (localObject1 == null) {
        continue;
      }
      localStringBuilder.append(((Date)localObject2).toString());
      localStringBuilder.append("\n");
      localStringBuilder.append("SHA1|");
      localObject1 = a.b(MessageDigest.getInstance("SHA1").digest(paramArrayOfByte.getEncoded()));
      if ((localObject1 == null) || (((String)localObject1).length() <= 0)) {
        continue;
      }
      localStringBuilder.append(((String)localObject1).toString());
      localStringBuilder.append("\n");
      localStringBuilder.append("MD5|");
      paramArrayOfByte = a.b(MessageDigest.getInstance("MD5").digest(paramArrayOfByte.getEncoded()));
      if ((paramArrayOfByte == null) || (paramArrayOfByte.length() <= 0)) {
        continue;
      }
      localStringBuilder.append(paramArrayOfByte.toString());
      if (localStringBuilder.length() != 0) {
        break label376;
      }
      return "unknown";
      localStringBuilder.append("unknown");
    }
    label376:
    return localStringBuilder.toString();
  }
  
  public static List<String> a(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      return null;
    }
    try
    {
      paramMap = (String)paramMap.get("BUGLY_DISABLE");
      if ((paramMap != null) && (paramMap.length() != 0))
      {
        paramMap = paramMap.split(",");
        int i = 0;
        while (i < paramMap.length)
        {
          paramMap[i] = paramMap[i].trim();
          i += 1;
        }
        paramMap = Arrays.asList(paramMap);
        return paramMap;
      }
    }
    catch (Throwable paramMap)
    {
      if (!v.a(paramMap)) {
        paramMap.printStackTrace();
      }
      return null;
    }
    return null;
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null) || (paramString.trim().length() <= 0)) {}
    for (;;)
    {
      return false;
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 4096).requestedPermissions;
        if (paramContext != null)
        {
          int j = paramContext.length;
          int i = 0;
          while (i < j)
          {
            boolean bool = paramString.equals(paramContext[i]);
            if (bool) {
              return true;
            }
            i += 1;
          }
          if (v.a(paramContext)) {}
        }
      }
      catch (Throwable paramContext) {}
    }
    paramContext.printStackTrace();
    return false;
  }
  
  public static PackageInfo b(Context paramContext)
  {
    try
    {
      String str = a(paramContext);
      paramContext = paramContext.getPackageManager().getPackageInfo(str, 0);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      if (!v.a(paramContext)) {
        paramContext.printStackTrace();
      }
    }
    return null;
  }
  
  public static String b(PackageInfo paramPackageInfo)
  {
    if (paramPackageInfo == null) {
      return null;
    }
    try
    {
      paramPackageInfo = Integer.toString(paramPackageInfo.versionCode);
      return paramPackageInfo;
    }
    catch (Throwable paramPackageInfo)
    {
      if (!v.a(paramPackageInfo)) {
        paramPackageInfo.printStackTrace();
      }
    }
    return "fail";
  }
  
  public static String c(Context paramContext)
  {
    try
    {
      paramContext = a(Process.myPid());
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static Map<String, String> d(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
        if (paramContext.metaData == null) {
          break label216;
        }
        HashMap localHashMap = new HashMap();
        Object localObject = paramContext.metaData.get("BUGLY_DISABLE");
        if (localObject != null) {
          localHashMap.put("BUGLY_DISABLE", localObject.toString());
        }
        localObject = paramContext.metaData.get("BUGLY_APPID");
        if (localObject != null) {
          localHashMap.put("BUGLY_APPID", localObject.toString());
        }
        localObject = paramContext.metaData.get("BUGLY_APP_CHANNEL");
        if (localObject != null) {
          localHashMap.put("BUGLY_APP_CHANNEL", localObject.toString());
        }
        localObject = paramContext.metaData.get("BUGLY_APP_VERSION");
        if (localObject != null) {
          localHashMap.put("BUGLY_APP_VERSION", localObject.toString());
        }
        localObject = paramContext.metaData.get("BUGLY_ENABLE_DEBUG");
        if (localObject != null) {
          localHashMap.put("BUGLY_ENABLE_DEBUG", localObject.toString());
        }
        localObject = paramContext.metaData.get("com.tencent.rdm.uuid");
        paramContext = localHashMap;
        if (localObject != null)
        {
          localHashMap.put("com.tencent.rdm.uuid", localObject.toString());
          paramContext = localHashMap;
        }
        return paramContext;
      }
      catch (Throwable paramContext) {}
      if (v.a(paramContext)) {
        break;
      }
      paramContext.printStackTrace();
      return null;
      label216:
      paramContext = null;
    }
  }
  
  public static String e(Context paramContext)
  {
    Object localObject = a(paramContext);
    if (localObject == null) {}
    for (;;)
    {
      return null;
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo((String)localObject, 64);
        if (paramContext != null)
        {
          localObject = paramContext.signatures;
          if ((localObject != null) && (localObject.length != 0)) {
            return a(paramContext.signatures[0].toByteArray());
          }
        }
      }
      catch (PackageManager.NameNotFoundException paramContext) {}
    }
    return null;
  }
  
  public static boolean f(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    if (a == null) {
      a = (ActivityManager)paramContext.getSystemService("activity");
    }
    try
    {
      paramContext = new ActivityManager.MemoryInfo();
      a.getMemoryInfo(paramContext);
      if (paramContext.lowMemory)
      {
        v.c("Memory is low.", new Object[0]);
        return true;
      }
      return false;
    }
    catch (Throwable paramContext)
    {
      if (!v.a(paramContext)) {
        paramContext.printStackTrace();
      }
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\bugly\crashreport\common\info\AppInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */