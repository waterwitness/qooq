package com.tencent.qqlive.mediaplayer.api;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.qqlive.mediaplayer.sdkupdate.UpdateUtils;
import com.tencent.qqlive.mediaplayer.sdkupdate.UpdateUtils.LogType;
import com.tencent.qqlive.mediaplayer.sdkupdate.a;
import java.lang.reflect.Method;
import java.util.Map;

public class TVK_SDKMgr
{
  public static final boolean DOWNLOAD_PLUGIN_FOR_OTHER_APP = false;
  public static final int ERROR_FACTORY_NULL = 105;
  public static final int ERROR_INVALID_FILE = 103;
  public static final int ERROR_IO = 104;
  public static final int ERROR_NETWORK = 101;
  public static final int ERROR_OTHERS = 100;
  public static final int ERROR_SERVER_RESPONSE = 102;
  public static String SDK_Ver = "V4.1.000.1760";
  private static ClassLoader a = null;
  private static boolean b = false;
  private static Context c = null;
  private static boolean d = false;
  private static boolean e = false;
  private static boolean f = false;
  private static InstallListener g = null;
  private static String h = "";
  private static String i = "";
  private static boolean j = false;
  private static String k = null;
  private static boolean l = false;
  private static OnLogListener m = null;
  private static OnLogReportListener n = null;
  private static String o = "";
  private static String p = "";
  private static InstallListener q = new InstallListener()
  {
    public void onInstallProgress(float paramAnonymousFloat)
    {
      if (TVK_SDKMgr.c() != null) {
        TVK_SDKMgr.c().onInstallProgress(paramAnonymousFloat);
      }
    }
    
    public void onInstalledFailed(int paramAnonymousInt)
    {
      UpdateUtils.a(UpdateUtils.LogType.e, "", "MediaPlayerMgr", "onInstalledFailed, err: " + paramAnonymousInt);
      if (TVK_SDKMgr.c() != null)
      {
        TVK_SDKMgr.c().onInstalledFailed(paramAnonymousInt);
        TVK_SDKMgr.a(null);
      }
    }
    
    public void onInstalledSuccessed()
    {
      if (TVK_SDKMgr.a(TVK_SDKMgr.a()))
      {
        TVK_SDKMgr.b();
        if (TVK_SDKMgr.getProxyFactory() == null)
        {
          UpdateUtils.a(UpdateUtils.LogType.e, "", "MediaPlayerMgr", "loadDexFile succeed, but factory is null");
          if (TVK_SDKMgr.c() != null)
          {
            TVK_SDKMgr.c().onInstalledFailed(105);
            TVK_SDKMgr.a(null);
          }
        }
      }
      do
      {
        do
        {
          return;
          UpdateUtils.a(UpdateUtils.LogType.c, "", "MediaPlayerMgr", "onInstalledSuccessed... ");
        } while (TVK_SDKMgr.c() == null);
        TVK_SDKMgr.c().onInstalledSuccessed();
        TVK_SDKMgr.a(null);
        return;
        UpdateUtils.a(UpdateUtils.LogType.e, "", "MediaPlayerMgr", "loadDexFile failed");
      } while (TVK_SDKMgr.c() == null);
      TVK_SDKMgr.c().onInstalledFailed(100);
      TVK_SDKMgr.a(null);
    }
  };
  private static TVK_IProxyFactory r = null;
  
  /* Error */
  private static boolean b(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 67	com/tencent/qqlive/mediaplayer/api/TVK_SDKMgr:b	Z
    //   6: ifne +53 -> 59
    //   9: aload_0
    //   10: invokestatic 118	com/tencent/qqlive/mediaplayer/dex/Dexloader:a	(Landroid/content/Context;)Lcom/tencent/qqlive/mediaplayer/dex/Dexloader;
    //   13: getstatic 69	com/tencent/qqlive/mediaplayer/api/TVK_SDKMgr:c	Landroid/content/Context;
    //   16: invokestatic 123	com/tencent/qqlive/mediaplayer/sdkupdate/a:a	(Landroid/content/Context;)Lcom/tencent/qqlive/mediaplayer/sdkupdate/a;
    //   19: invokevirtual 126	com/tencent/qqlive/mediaplayer/sdkupdate/a:d	()Ljava/lang/String;
    //   22: getstatic 69	com/tencent/qqlive/mediaplayer/api/TVK_SDKMgr:c	Landroid/content/Context;
    //   25: invokestatic 123	com/tencent/qqlive/mediaplayer/sdkupdate/a:a	(Landroid/content/Context;)Lcom/tencent/qqlive/mediaplayer/sdkupdate/a;
    //   28: invokevirtual 128	com/tencent/qqlive/mediaplayer/sdkupdate/a:e	()Ljava/lang/String;
    //   31: invokevirtual 131	com/tencent/qqlive/mediaplayer/dex/Dexloader:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/ClassLoader;
    //   34: putstatic 65	com/tencent/qqlive/mediaplayer/api/TVK_SDKMgr:a	Ljava/lang/ClassLoader;
    //   37: getstatic 65	com/tencent/qqlive/mediaplayer/api/TVK_SDKMgr:a	Ljava/lang/ClassLoader;
    //   40: ifnull +28 -> 68
    //   43: iconst_1
    //   44: putstatic 67	com/tencent/qqlive/mediaplayer/api/TVK_SDKMgr:b	Z
    //   47: getstatic 136	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType:c	Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;
    //   50: ldc 79
    //   52: ldc -118
    //   54: ldc -116
    //   56: invokestatic 145	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils:a	(Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   59: getstatic 67	com/tencent/qqlive/mediaplayer/api/TVK_SDKMgr:b	Z
    //   62: istore_1
    //   63: ldc 2
    //   65: monitorexit
    //   66: iload_1
    //   67: ireturn
    //   68: getstatic 147	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType:e	Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;
    //   71: ldc 79
    //   73: ldc -118
    //   75: ldc -107
    //   77: invokestatic 145	com/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils:a	(Lcom/tencent/qqlive/mediaplayer/sdkupdate/UpdateUtils$LogType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   80: goto -21 -> 59
    //   83: astore_0
    //   84: ldc 2
    //   86: monitorexit
    //   87: aload_0
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	paramContext	Context
    //   62	5	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	59	83	finally
    //   59	63	83	finally
    //   68	80	83	finally
  }
  
  public static boolean checkSdkPluginMode()
  {
    for (;;)
    {
      try
      {
        Method localMethod = Class.forName("com.tencent.qqlive.mediaplayer.wrapper.MediaPlayerFactory").getMethod("getProxyFactoryInstance", new Class[0]);
        localMethod.setAccessible(true);
        if ((TVK_IProxyFactory)localMethod.invoke(null, new Object[0]) != null) {
          continue;
        }
        bool = true;
        d = bool;
      }
      catch (Throwable localThrowable)
      {
        boolean bool;
        d = true;
        continue;
      }
      return d;
      bool = false;
    }
  }
  
  public static int clearStorage(Context paramContext)
  {
    if (((!d) || (b)) && (r != null) && (r.getSdkMgrInstance() != null)) {
      return r.getSdkMgrInstance().cleanStorage(paramContext);
    }
    return -1;
  }
  
  private static void d()
  {
    if (d) {
      try
      {
        Method localMethod1 = a.loadClass("com.tencent.qqlive.mediaplayer.wrapper.MediaPlayerFactory").getMethod("getProxyFactoryInstance", new Class[0]);
        localMethod1.setAccessible(true);
        r = (TVK_IProxyFactory)localMethod1.invoke(null, new Object[0]);
        if (r == null) {
          UpdateUtils.a(UpdateUtils.LogType.e, "", "MediaPlayerMgr", "createProxyFactory, invoke get failed! ");
        }
        return;
      }
      catch (Throwable localThrowable1)
      {
        UpdateUtils.a(UpdateUtils.LogType.e, "", "MediaPlayerMgr", "createProxyFactory, exception failed! ");
        return;
      }
    }
    try
    {
      Method localMethod2 = Class.forName("com.tencent.qqlive.mediaplayer.wrapper.MediaPlayerFactory").getMethod("getProxyFactoryInstance", new Class[0]);
      localMethod2.setAccessible(true);
      r = (TVK_IProxyFactory)localMethod2.invoke(null, new Object[0]);
      return;
    }
    catch (Throwable localThrowable2)
    {
      UpdateUtils.a(UpdateUtils.LogType.e, "", "MediaPlayerMgr", "tvk reflect factory failed: " + localThrowable2.toString());
    }
  }
  
  public static void deInit()
  {
    if (((!d) || (b)) && (r != null) && (r.getSdkMgrInstance() != null)) {
      r.getSdkMgrInstance().deInit();
    }
  }
  
  private static void e()
  {
    if (f) {}
    do
    {
      return;
      f = true;
      d();
      if ((r != null) && (r.getSdkMgrInstance() != null)) {
        break;
      }
      UpdateUtils.a(UpdateUtils.LogType.e, "", "MediaPlayerMgr", "initSDK failed, cannot get instance");
      f = false;
      r = null;
    } while ((!d) || (a.a(c) == null));
    a.a(c).b();
    return;
    if (d)
    {
      String[] arrayOfString1 = r.getSdkMgrInstance().getSdkVersion().split("\\.");
      String[] arrayOfString2 = SDK_Ver.split("\\.");
      if ((arrayOfString2.length > 1) && (arrayOfString1.length > 1) && (arrayOfString2[0].equalsIgnoreCase(arrayOfString1[0])) && (arrayOfString2[1].equalsIgnoreCase(arrayOfString1[1]))) {}
      for (int i1 = 1;; i1 = 0)
      {
        if (i1 != 0) {
          break label210;
        }
        f = false;
        r = null;
        UpdateUtils.a(UpdateUtils.LogType.e, "", "MediaPlayerMgr", "initSDK failed, match sdk version failed");
        if ((!d) || (a.a(c) == null)) {
          break;
        }
        a.a(c).b();
        return;
        b = false;
        a = null;
      }
    }
    label210:
    if (!TextUtils.isEmpty(o)) {
      r.getSdkMgrInstance().setGuid(o);
    }
    if (!TextUtils.isEmpty(p)) {
      r.getSdkMgrInstance().setUpc(p);
    }
    if (j) {
      r.getSdkMgrInstance().useFileConfigBeforeInitSDK(c);
    }
    if (k != null) {
      r.getSdkMgrInstance().setHostConfigBeforeInitSDK(k);
    }
    r.getSdkMgrInstance().setDebugEnable(l);
    if (m != null) {
      r.getSdkMgrInstance().setOnLogListener(m);
    }
    if (n != null) {
      r.getSdkMgrInstance().setOnLogReportListener(n);
    }
    r.getSdkMgrInstance().initSdk(c, h, i);
    if ((d) && (a.a(c) != null))
    {
      r.getSdkMgrInstance().setExtraMapInfo("assetPath", a.a(c).d());
      a.a(c).b();
    }
    e = true;
  }
  
  public static String getAdChid()
  {
    if (((!d) || (b)) && (r != null) && (r.getSdkMgrInstance() != null)) {
      return r.getSdkMgrInstance().getAdChid();
    }
    return "";
  }
  
  public static String getHostConfig()
  {
    return k;
  }
  
  public static String getPlatform()
  {
    if (((!d) || (b)) && (r != null) && (r.getSdkMgrInstance() != null)) {
      return r.getSdkMgrInstance().getPlatform();
    }
    return "";
  }
  
  public static TVK_IProxyFactory getProxyFactory()
  {
    if ((r == null) && (!d)) {
      d();
    }
    return r;
  }
  
  public static String getSdkVersion()
  {
    if (((!d) || (b)) && (getProxyFactory() != null) && (getProxyFactory().getSdkMgrInstance() != null)) {
      return getProxyFactory().getSdkMgrInstance().getSdkVersion();
    }
    return SDK_Ver;
  }
  
  public static void initSdk(Context paramContext, String paramString1, String paramString2)
  {
    if (e) {
      return;
    }
    e = true;
    checkSdkPluginMode();
    c = paramContext.getApplicationContext();
    h = paramString1;
    i = paramString2;
    UpdateUtils.a(UpdateUtils.LogType.c, "", "MediaPlayerMgr", "initSdk... ver: " + SDK_Ver);
    if (!d)
    {
      e();
      return;
    }
    if ((a.a(c).c()) && (b(c)))
    {
      e();
      return;
    }
    a.a(c).a(q);
    a.a(c).a(true);
  }
  
  public static void initSdkWithGuid(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    o = paramString3;
    initSdk(paramContext, paramString1, paramString2);
  }
  
  public static void installPlugin(Context paramContext, InstallListener paramInstallListener)
    throws IllegalArgumentException
  {
    c = paramContext.getApplicationContext();
    g = paramInstallListener;
    if (g == null) {
      throw new IllegalArgumentException("Install listener can not be null");
    }
    if (getProxyFactory() != null) {
      if (g != null)
      {
        g.onInstalledSuccessed();
        g = null;
      }
    }
    label105:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (d) {
              break label105;
            }
            if (getProxyFactory() != null) {
              break;
            }
          } while (g == null);
          g.onInstalledFailed(105);
          g = null;
          return;
        } while (g == null);
        g.onInstalledSuccessed();
        g = null;
        return;
        if ((!a.a(c).c()) || (!b(c))) {
          break label190;
        }
        e();
        if (g != null) {
          g.onInstallProgress(1.0F);
        }
        if (getProxyFactory() != null) {
          break;
        }
      } while (g == null);
      g.onInstalledFailed(105);
      g = null;
      return;
    } while (g == null);
    g.onInstalledSuccessed();
    g = null;
    return;
    label190:
    a.a(c).a(q);
    a.a(c).a();
  }
  
  public static boolean isInstalled(Context paramContext)
  {
    if ((!e) || (!f)) {}
    while (getProxyFactory() == null) {
      return false;
    }
    return true;
  }
  
  public static void setDebugEnable(boolean paramBoolean)
  {
    l = paramBoolean;
    UpdateUtils.a(paramBoolean);
    if (((!d) || (b)) && (r != null) && (r.getSdkMgrInstance() != null)) {
      r.getSdkMgrInstance().setDebugEnable(paramBoolean);
    }
  }
  
  public static void setHostConfigBeforeInitSDK(String paramString)
  {
    k = paramString;
  }
  
  public static void setOnLogListener(OnLogListener paramOnLogListener)
  {
    m = paramOnLogListener;
    UpdateUtils.a(paramOnLogListener);
    if (((!d) || (b)) && (r != null) && (r.getSdkMgrInstance() != null)) {
      r.getSdkMgrInstance().setOnLogListener(paramOnLogListener);
    }
  }
  
  public static void setOnLogReportListener(OnLogReportListener paramOnLogReportListener)
  {
    n = paramOnLogReportListener;
    if (((!d) || (b)) && (r != null) && (r.getSdkMgrInstance() != null)) {
      r.getSdkMgrInstance().setOnLogReportListener(paramOnLogReportListener);
    }
  }
  
  public static void setPreloadMaxStorageSize(long paramLong)
  {
    if (((!d) || (b)) && (r != null) && (r.getSdkMgrInstance() != null)) {
      r.getSdkMgrInstance().setPreloadMaxStorageSize(c, paramLong);
    }
  }
  
  public static void setUpc(String paramString)
  {
    p = paramString;
    if (((!d) || (b)) && (r != null) && (r.getSdkMgrInstance() != null)) {
      r.getSdkMgrInstance().setUpc(paramString);
    }
  }
  
  public static void useFileConfigBeforeInitSDK(Context paramContext)
  {
    j = true;
  }
  
  public static abstract interface InstallListener
  {
    public abstract void onInstallProgress(float paramFloat);
    
    public abstract void onInstalledFailed(int paramInt);
    
    public abstract void onInstalledSuccessed();
  }
  
  public static abstract interface OnLogListener
  {
    public abstract int d(String paramString1, String paramString2);
    
    public abstract int e(String paramString1, String paramString2);
    
    public abstract int i(String paramString1, String paramString2);
    
    public abstract int v(String paramString1, String paramString2);
    
    public abstract int w(String paramString1, String paramString2);
  }
  
  public static abstract interface OnLogReportListener
  {
    public abstract void onLogReport(Map<String, String> paramMap);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\qqlive\mediaplayer\api\TVK_SDKMgr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */