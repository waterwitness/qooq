package com.tencent.tmassistantbase.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;

public class f
{
  protected static final String a = f.class.getSimpleName();
  protected static f b = null;
  protected static int e = 0;
  protected Context c;
  public String d = "";
  public final int f = 0;
  public final int g = 1;
  public final int h = 2;
  public final int i = 3;
  public final int j = 4;
  public final int k = 5;
  public final int l = 6;
  public HashMap<Integer, String> m = null;
  
  protected f()
  {
    this.m.put(Integer.valueOf(1), "ReportLog");
    this.m.put(Integer.valueOf(2), "GetSettings");
    this.m.put(Integer.valueOf(3), "GetAppUpdate");
    this.m.put(Integer.valueOf(4), "GetAuthorized");
    this.m.put(Integer.valueOf(5), "GetAppSimpleDetail");
    this.m.put(Integer.valueOf(6), "GetCallerSetting");
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 5: 
    case 7: 
    case 8: 
    default: 
      return 0;
    case 1: 
      return 2;
    case 6: 
      return 1;
    case 2: 
      return 3;
    case 4: 
      return 4;
    case 3: 
      return 5;
    }
    return 6;
  }
  
  public static f a()
  {
    try
    {
      if (b == null) {
        b = new f();
      }
      f localf = b;
      return localf;
    }
    finally {}
  }
  
  public static int b(int paramInt)
  {
    switch (paramInt)
    {
    case -1000: 
    case -26: 
    case -24: 
    default: 
      return 604;
    case 0: 
      return 0;
    case -1: 
      return 709;
    case -11: 
      return 708;
    case -12: 
      return 730;
    case -13: 
      return 703;
    case -15: 
      return 1;
    case -16: 
      return 731;
    case -21: 
      return 700;
    case -22: 
      return 732;
    case -23: 
      return 601;
    case -25: 
      return 602;
    case -27: 
      return 606;
    }
    return 701;
  }
  
  public static String b(Context paramContext)
  {
    if (paramContext != null) {
      return paramContext.getPackageName();
    }
    return "";
  }
  
  public static String b(String paramString)
  {
    int n = 0;
    Object localObject = "";
    if (!TextUtils.isEmpty(paramString)) {
      paramString = paramString.getBytes();
    }
    try
    {
      localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).reset();
      ((MessageDigest)localObject).update(paramString, 0, paramString.length);
      paramString = ((MessageDigest)localObject).digest();
      localObject = new StringBuffer();
      while (n < paramString.length)
      {
        ((StringBuffer)localObject).append(Integer.toHexString(paramString[n] & 0xFF));
        n += 1;
      }
      localObject = ((StringBuffer)localObject).toString();
      return (String)localObject;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public static int c(Context paramContext)
  {
    int n = 0;
    if (paramContext != null) {}
    try
    {
      n = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionCode;
      return n;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
    return 0;
  }
  
  public static ArrayList<String> c(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split(",");
      int n = 0;
      while (n < paramString.length)
      {
        CharSequence localCharSequence = paramString[n];
        if (!TextUtils.isEmpty(localCharSequence)) {
          localArrayList.add(localCharSequence);
        }
        n += 1;
      }
    }
    return localArrayList;
  }
  
  public static void d(String paramString)
  {
    Object localObject = new File(paramString);
    String str2 = ((File)localObject).getParent();
    String str1 = new File(str2).getParent();
    paramString = new File(str1).getParent();
    try
    {
      localObject = "chmod 777 " + ((File)localObject).getAbsolutePath();
      Runtime.getRuntime().exec((String)localObject);
      str2 = "chmod 777 " + str2;
      Runtime.getRuntime().exec(str2);
      str1 = "chmod 777 " + str1;
      Runtime.getRuntime().exec(str1);
      paramString = "chmod 777" + paramString;
      Runtime.getRuntime().exec(paramString);
      return;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static int i()
  {
    try
    {
      int n = e;
      e = n + 1;
      return n;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public static String n()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 221	com/tencent/tmassistantbase/a/f:a	()Lcom/tencent/tmassistantbase/a/f;
    //   6: invokevirtual 224	com/tencent/tmassistantbase/a/f:b	()Landroid/content/Context;
    //   9: astore_0
    //   10: aload_0
    //   11: ifnonnull +11 -> 22
    //   14: ldc 43
    //   16: astore_0
    //   17: ldc 2
    //   19: monitorexit
    //   20: aload_0
    //   21: areturn
    //   22: aload_0
    //   23: ldc -30
    //   25: invokevirtual 230	android/content/Context:checkCallingOrSelfPermission	(Ljava/lang/String;)I
    //   28: ifeq +16 -> 44
    //   31: ldc 43
    //   33: astore_0
    //   34: goto -17 -> 17
    //   37: astore_0
    //   38: ldc 43
    //   40: astore_0
    //   41: goto -24 -> 17
    //   44: aload_0
    //   45: ldc -24
    //   47: invokevirtual 236	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   50: checkcast 238	android/net/ConnectivityManager
    //   53: invokevirtual 242	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   56: astore_0
    //   57: aload_0
    //   58: ifnonnull +9 -> 67
    //   61: ldc 43
    //   63: astore_0
    //   64: goto -47 -> 17
    //   67: aload_0
    //   68: invokevirtual 247	android/net/NetworkInfo:getType	()I
    //   71: iconst_1
    //   72: if_icmpne +9 -> 81
    //   75: ldc -7
    //   77: astore_0
    //   78: goto -61 -> 17
    //   81: aload_0
    //   82: invokevirtual 252	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   85: astore_0
    //   86: aload_0
    //   87: ifnonnull +9 -> 96
    //   90: ldc 43
    //   92: astore_0
    //   93: goto -76 -> 17
    //   96: aload_0
    //   97: invokevirtual 255	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   100: astore_0
    //   101: getstatic 33	com/tencent/tmassistantbase/a/f:a	Ljava/lang/String;
    //   104: new 192	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   111: ldc_w 257
    //   114: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: aload_0
    //   118: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: invokestatic 262	com/tencent/tmassistantbase/a/m:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   127: goto -110 -> 17
    //   130: astore_0
    //   131: ldc 2
    //   133: monitorexit
    //   134: aload_0
    //   135: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   9	25	0	localObject1	Object
    //   37	1	0	localException	Exception
    //   40	78	0	localObject2	Object
    //   130	5	0	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   22	31	37	java/lang/Exception
    //   3	10	130	finally
    //   22	31	130	finally
    //   44	57	130	finally
    //   67	75	130	finally
    //   81	86	130	finally
    //   96	127	130	finally
  }
  
  public static boolean o()
  {
    Object localObject = a().b();
    if (localObject == null)
    {
      m.d(a, "GlobalUtil.getInstance().getContext() == null.");
      return false;
    }
    localObject = ((ConnectivityManager)((Context)localObject).getSystemService("connectivity")).getActiveNetworkInfo();
    if (localObject != null) {}
    for (boolean bool = ((NetworkInfo)localObject).isAvailable();; bool = false) {
      return bool;
    }
  }
  
  public void a(Context paramContext)
  {
    this.c = paramContext;
    this.d = new l(paramContext).a();
    m.a(paramContext);
  }
  
  public void a(String paramString)
  {
    if (this.c == null) {}
    SharedPreferences localSharedPreferences;
    do
    {
      do
      {
        return;
      } while (paramString == null);
      localSharedPreferences = this.c.getSharedPreferences("TMAssistantSDKSharedPreference", 0);
    } while (localSharedPreferences == null);
    localSharedPreferences.edit().putString("TMAssistantSDKPhoneGUID", paramString).commit();
  }
  
  public Context b()
  {
    return this.c;
  }
  
  public void c()
  {
    this.c = null;
    b = null;
  }
  
  public String d()
  {
    try
    {
      if (this.c == null) {
        return null;
      }
      String str = Settings.Secure.getString(b().getContentResolver(), "android_id");
      return str;
    }
    catch (Exception localException)
    {
      m.c(a, "getAndroidIdInPhone Exception:", localException);
    }
    return "";
  }
  
  public String e()
  {
    if (this.c == null) {
      return "";
    }
    SharedPreferences localSharedPreferences = this.c.getSharedPreferences("TMAssistantSDKSharedPreference", 0);
    if (localSharedPreferences != null) {
      return localSharedPreferences.getString("TMAssistantSDKPhoneGUID", "");
    }
    return "";
  }
  
  public String f()
  {
    try
    {
      if (this.c == null) {
        return null;
      }
      String str = ((TelephonyManager)b().getSystemService("phone")).getDeviceId();
      return str;
    }
    catch (Exception localException)
    {
      m.c(a, "getImei Exception:", localException);
    }
    return null;
  }
  
  public String g()
  {
    try
    {
      if (this.c == null) {
        return null;
      }
      String str = ((TelephonyManager)b().getSystemService("phone")).getSubscriberId();
      return str;
    }
    catch (Exception localException)
    {
      m.c(a, "getImsi Exception:", localException);
    }
    return null;
  }
  
  public String h()
  {
    if (this.c == null) {
      return null;
    }
    try
    {
      WifiInfo localWifiInfo = ((WifiManager)b().getSystemService("wifi")).getConnectionInfo();
      if (localWifiInfo != null) {
        return localWifiInfo.getMacAddress();
      }
      return "";
    }
    catch (Exception localException)
    {
      m.c(a, "getMacAddress Exception:", localException);
    }
    return "";
  }
  
  public boolean j()
  {
    return "wifi".equals(n());
  }
  
  public int k()
  {
    if (this.c == null) {
      m.c("SelfUpdateSDK", "context == null");
    }
    for (;;)
    {
      return 0;
      m.c("SelfUpdateSDK", "getQQDownloaderAPILevel");
      try
      {
        ApplicationInfo localApplicationInfo = this.c.getPackageManager().getApplicationInfo("com.tencent.android.qqdownloader", 128);
        m.c("SelfUpdateSDK", "appInfo:" + localApplicationInfo);
        if ((localApplicationInfo != null) && (localApplicationInfo.metaData != null))
        {
          int n = localApplicationInfo.metaData.getInt("com.tencent.android.qqdownloader.sdk.apilevel");
          m.c("SelfUpdateSDK", "apiLevel:" + n);
          return n;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return 0;
  }
  
  public int l()
  {
    if (this.c == null) {
      m.c("SelfUpdateSDK", "context == null");
    }
    for (;;)
    {
      return 0;
      m.c("SelfUpdateSDK", "getQQDownloaderConnectLevel");
      try
      {
        ApplicationInfo localApplicationInfo = this.c.getPackageManager().getApplicationInfo("com.tencent.android.qqdownloader", 128);
        m.c("SelfUpdateSDK", "appInfo:" + localApplicationInfo);
        if ((localApplicationInfo != null) && (localApplicationInfo.metaData != null))
        {
          int n = localApplicationInfo.metaData.getInt("com.tencent.android.qqdownloader.sdk.connectlevel");
          m.c("SelfUpdateSDK", "apiLevel:" + n);
          return n;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return 0;
  }
  
  public int m()
  {
    if (this.c == null) {}
    for (;;)
    {
      return 0;
      try
      {
        Object localObject = this.c.getPackageManager();
        if (localObject != null)
        {
          localObject = ((PackageManager)localObject).getPackageInfo("com.tencent.android.qqdownloader", 0);
          if (localObject != null)
          {
            int n = ((PackageInfo)localObject).versionCode;
            return n;
          }
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        localNameNotFoundException.printStackTrace();
      }
    }
    return 0;
  }
  
  public SharedPreferences p()
  {
    if (a().b() == null)
    {
      m.d(a, "GlobalUtil.getInstance().getContext() == null.");
      return null;
    }
    return a().b().getSharedPreferences("TMAssistantSDKSharedPreference", 0);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tmassistantbase\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */