package com.tencent.component.network.downloader.common;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Environment;
import android.os.Parcel;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.component.network.module.common.a.f;
import com.tencent.component.network.module.common.a.j;
import com.tencent.component.network.utils.NetworkUtils;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a
{
  private static com.tencent.component.network.module.base.inter.Log a;
  
  public static Parcel a(byte[] paramArrayOfByte)
  {
    Parcel localParcel = Parcel.obtain();
    if (paramArrayOfByte == null) {
      return localParcel;
    }
    try
    {
      localParcel.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
      localParcel.setDataPosition(0);
      return localParcel;
    }
    catch (Exception paramArrayOfByte) {}
    return localParcel;
  }
  
  private static String a(int paramInt, float paramFloat)
  {
    for (;;)
    {
      if (paramFloat < 0.0F) {
        return "";
      }
      if (paramFloat < 1024.0F)
      {
        StringBuilder localStringBuilder = new StringBuilder(String.valueOf(String.format("%.2f", new Object[] { Float.valueOf(paramFloat) })));
        String str;
        if (paramInt == 0) {
          str = "byte";
        }
        for (;;)
        {
          return str;
          if (paramInt == 1) {
            str = "KB";
          } else if (paramInt == 2) {
            str = "MB";
          } else if (paramInt == 3) {
            str = "GB";
          } else if (paramInt == 4) {
            str = "TB";
          } else if (paramInt == 5) {
            str = "PB";
          } else {
            str = "";
          }
        }
      }
      paramInt += 1;
      paramFloat /= 1024.0F;
    }
  }
  
  public static String a(Context paramContext)
  {
    int i = Process.myPid();
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    if (paramContext == null) {
      return null;
    }
    try
    {
      paramContext = paramContext.getRunningAppProcesses();
      if ((paramContext != null) && (paramContext.size() > 0))
      {
        paramContext = paramContext.iterator();
        while (paramContext.hasNext())
        {
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
          if (localRunningAppProcessInfo.pid == i)
          {
            paramContext = localRunningAppProcessInfo.processName;
            return paramContext;
          }
        }
      }
    }
    catch (Throwable paramContext) {}
    return null;
  }
  
  public static void a(com.tencent.component.network.module.base.inter.Log paramLog)
  {
    a = paramLog;
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (a != null)
    {
      a.d(paramString1, paramString2, null);
      return;
    }
    android.util.Log.d(paramString1, paramString2, null);
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a != null)
    {
      a.w(paramString1, paramString2, paramThrowable);
      return;
    }
    android.util.Log.w(paramString1, paramString2, paramThrowable);
  }
  
  public static boolean a()
  {
    return 2 >= f();
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt > 0) && (paramInt <= 65535);
  }
  
  public static boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (NetworkUtils.isNetworkUrl(paramString));
  }
  
  public static boolean a(Pattern paramPattern, String paramString)
  {
    if ((paramPattern == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    try
    {
      boolean bool = paramPattern.matcher(paramString).matches();
      return bool;
    }
    catch (Exception paramPattern)
    {
      b("Utils", "", paramPattern);
    }
    return false;
  }
  
  public static InetAddress[] a(String paramString, long paramLong)
  {
    if (paramString == null)
    {
      paramString = "";
      if (b()) {
        b("DnsMain", "hostName:" + paramString + ",timeout:" + paramLong + "get better host for name:" + paramString);
      }
      if ((paramString != null) && (paramString.trim().length() > 0)) {
        break label205;
      }
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      Object localObject = paramString.trim();
      paramString = ((String)localObject).toLowerCase();
      int i;
      if (paramString.startsWith("http://"))
      {
        i = ((String)localObject).indexOf("/", 8);
        if (i > 7)
        {
          paramString = ((String)localObject).substring(7, i);
          break;
        }
        paramString = ((String)localObject).substring(7);
        break;
      }
      if (paramString.startsWith("https://"))
      {
        i = ((String)localObject).indexOf("/", 9);
        if (i > 8)
        {
          paramString = ((String)localObject).substring(8, i);
          break;
        }
        paramString = ((String)localObject).substring(8);
        break;
      }
      paramString = (String)localObject;
      if (((String)localObject).indexOf("/", 1) <= 1) {
        break;
      }
      paramString = ((String)localObject).substring(0, ((String)localObject).indexOf("/", 1));
      break;
      label205:
      String str = paramString.trim();
      try
      {
        localObject = new f("114.114.114.114").a(str, paramLong);
        if ((localObject != null) && (localObject.length > 0))
        {
          paramString = (String)localObject;
          if (!b()) {
            continue;
          }
          b("DnsMain", "get ip from Lookup: " + str + " --- " + localObject);
          return (InetAddress[])localObject;
        }
      }
      catch (UnknownHostException paramString)
      {
        b("DnsMain", "UnknownHostException cause[" + str + "][114.114.114.114]." + paramString.getMessage(), null);
        for (;;)
        {
          return null;
          b("DnsMain", "114 - Address == null ? WTF ?!", null);
        }
      }
      catch (j paramString)
      {
        for (;;)
        {
          b("DnsMain", "WireParseException cause[" + str + "][114.114.114.114]." + paramString.getMessage(), null);
        }
      }
      catch (SocketTimeoutException paramString)
      {
        for (;;)
        {
          b("DnsMain", "SocketTimeoutException cause[" + str + "][114.114.114.114]." + paramString.getMessage(), null);
        }
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          b("DnsMain", "IOException cause[" + str + "][114.114.114.114]." + paramString.getMessage(), null);
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          b("DnsMain", "Exception cause[" + str + "][114.114.114.114]." + paramString.getMessage(), null);
        }
      }
    }
  }
  
  public static String b(String paramString)
  {
    String str2 = null;
    String str1 = null;
    if (TextUtils.isEmpty(paramString)) {
      paramString = str1;
    }
    for (;;)
    {
      return paramString;
      str1 = str2;
      try
      {
        str2 = new URL(paramString).getAuthority();
        paramString = str2;
        str1 = str2;
        if (!TextUtils.isEmpty(str2))
        {
          str1 = str2;
          int i = str2.indexOf(":");
          paramString = str2;
          if (i >= 0)
          {
            paramString = str2;
            str1 = str2;
            if (i < str2.length())
            {
              str1 = str2;
              paramString = str2.substring(0, i);
              return paramString;
            }
          }
        }
      }
      catch (MalformedURLException paramString) {}
    }
    return str1;
  }
  
  public static void b(String paramString1, String paramString2)
  {
    if (a != null)
    {
      a.i(paramString1, paramString2, null);
      return;
    }
    android.util.Log.i(paramString1, paramString2, null);
  }
  
  public static void b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a != null)
    {
      a.e(paramString1, paramString2, paramThrowable);
      return;
    }
    android.util.Log.e(paramString1, paramString2, paramThrowable);
  }
  
  public static boolean b()
  {
    return 3 >= f();
  }
  
  public static String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = new URL(paramString).getAuthority();
      return paramString;
    }
    catch (MalformedURLException paramString) {}
    return null;
  }
  
  public static void c(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, null);
  }
  
  public static boolean c()
  {
    return Environment.getExternalStorageState().equals("mounted");
  }
  
  /* Error */
  public static int d(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 155	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: iconst_m1
    //   8: ireturn
    //   9: new 270	java/net/URL
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 271	java/net/URL:<init>	(Ljava/lang/String;)V
    //   17: invokevirtual 274	java/net/URL:getAuthority	()Ljava/lang/String;
    //   20: astore_0
    //   21: aload_0
    //   22: invokestatic 155	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   25: ifne -18 -> 7
    //   28: aload_0
    //   29: ldc_w 276
    //   32: invokevirtual 279	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   35: istore_1
    //   36: iload_1
    //   37: iflt -30 -> 7
    //   40: aload_0
    //   41: invokevirtual 207	java/lang/String:length	()I
    //   44: istore_2
    //   45: iload_1
    //   46: iload_2
    //   47: if_icmpge -40 -> 7
    //   50: aload_0
    //   51: iload_1
    //   52: iconst_1
    //   53: iadd
    //   54: invokevirtual 228	java/lang/String:substring	(I)Ljava/lang/String;
    //   57: invokestatic 308	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   60: invokevirtual 311	java/lang/Integer:intValue	()I
    //   63: istore_1
    //   64: iload_1
    //   65: ireturn
    //   66: astore_0
    //   67: iconst_m1
    //   68: ireturn
    //   69: astore_0
    //   70: iconst_m1
    //   71: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	paramString	String
    //   35	30	1	i	int
    //   44	4	2	j	int
    // Exception table:
    //   from	to	target	type
    //   9	36	66	java/net/MalformedURLException
    //   40	45	66	java/net/MalformedURLException
    //   50	64	66	java/net/MalformedURLException
    //   50	64	69	java/lang/Exception
  }
  
  public static String d()
  {
    if (!c()) {}
    StatFs localStatFs;
    for (long l = -1L; l >= 0L; l = localStatFs.getBlockCount() * l)
    {
      return a(0, (float)l);
      localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      l = localStatFs.getBlockSize();
    }
    return "无SD Card";
  }
  
  public static void d(String paramString1, String paramString2)
  {
    b(paramString1, paramString2, null);
  }
  
  public static int e(String paramString)
  {
    int i = 0;
    int k = 0;
    if (paramString == null) {
      return k;
    }
    int m = paramString.length();
    int j = 0;
    for (;;)
    {
      k = i;
      if (j >= m) {
        break;
      }
      k = i;
      if (':' == paramString.charAt(j)) {
        k = i + 1;
      }
      j += 1;
      i = k;
    }
  }
  
  public static String e()
  {
    if (!c()) {}
    StatFs localStatFs;
    for (long l = -1L; l >= 0L; l = localStatFs.getAvailableBlocks() * l)
    {
      return a(0, (float)l);
      localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      l = localStatFs.getBlockSize();
    }
    return "无SD Card";
  }
  
  public static boolean e(String paramString1, String paramString2)
  {
    if (paramString1 == paramString2) {
      return true;
    }
    if ((paramString1 == null) || (paramString2 == null)) {
      return false;
    }
    return paramString1.regionMatches(true, 0, paramString2, 0, paramString2.length());
  }
  
  private static int f()
  {
    if (a != null) {
      return a.getLogLevel();
    }
    return 1;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\component\network\downloader\common\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */