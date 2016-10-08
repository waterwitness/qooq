package com.sixgod.pluginsdk.log;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class SixGodReporter
{
  protected static final String APPID_QQ = "1000";
  protected static final String REPORT_ACTION = "com.tencent.SixGodSDK.Report.QQ.ACTION";
  protected static c mReportReceiver;
  public static String sDevInfo = "";
  protected static ISixGodReporter sReportImpl;
  
  /* Error */
  public static void init(ISixGodReporter paramISixGodReporter, Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 32	com/sixgod/pluginsdk/log/SixGodReporter:sReportImpl	Lcom/sixgod/pluginsdk/log/ISixGodReporter;
    //   6: ifnonnull +107 -> 113
    //   9: aload_0
    //   10: ifnull +103 -> 113
    //   13: aload_0
    //   14: putstatic 32	com/sixgod/pluginsdk/log/SixGodReporter:sReportImpl	Lcom/sixgod/pluginsdk/log/ISixGodReporter;
    //   17: new 34	com/sixgod/pluginsdk/log/c
    //   20: dup
    //   21: invokespecial 35	com/sixgod/pluginsdk/log/c:<init>	()V
    //   24: putstatic 37	com/sixgod/pluginsdk/log/SixGodReporter:mReportReceiver	Lcom/sixgod/pluginsdk/log/c;
    //   27: new 39	android/content/IntentFilter
    //   30: dup
    //   31: ldc 11
    //   33: invokespecial 42	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   36: astore_2
    //   37: aload_1
    //   38: getstatic 37	com/sixgod/pluginsdk/log/SixGodReporter:mReportReceiver	Lcom/sixgod/pluginsdk/log/c;
    //   41: aload_2
    //   42: invokevirtual 48	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   45: pop
    //   46: new 50	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   53: getstatic 56	android/os/Build:MODEL	Ljava/lang/String;
    //   56: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: ldc 62
    //   61: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: getstatic 68	android/os/Build$VERSION:SDK_INT	I
    //   67: invokevirtual 71	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   70: ldc 62
    //   72: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: aload_0
    //   76: invokeinterface 77 1 0
    //   81: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: putstatic 22	com/sixgod/pluginsdk/log/SixGodReporter:sDevInfo	Ljava/lang/String;
    //   90: ldc 82
    //   92: new 50	java/lang/StringBuilder
    //   95: dup
    //   96: ldc 84
    //   98: invokespecial 85	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   101: getstatic 22	com/sixgod/pluginsdk/log/SixGodReporter:sDevInfo	Ljava/lang/String;
    //   104: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokestatic 91	com/sixgod/pluginsdk/log/a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   113: ldc 2
    //   115: monitorexit
    //   116: return
    //   117: astore_1
    //   118: ldc 82
    //   120: new 50	java/lang/StringBuilder
    //   123: dup
    //   124: ldc 84
    //   126: invokespecial 85	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   129: aload_1
    //   130: invokevirtual 92	java/lang/Exception:toString	()Ljava/lang/String;
    //   133: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: invokestatic 95	com/sixgod/pluginsdk/log/a:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   142: goto -96 -> 46
    //   145: astore_0
    //   146: ldc 2
    //   148: monitorexit
    //   149: aload_0
    //   150: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	paramISixGodReporter	ISixGodReporter
    //   0	151	1	paramContext	Context
    //   36	6	2	localIntentFilter	android.content.IntentFilter
    // Exception table:
    //   from	to	target	type
    //   17	46	117	java/lang/Exception
    //   3	9	145	finally
    //   13	17	145	finally
    //   17	46	145	finally
    //   46	113	145	finally
    //   118	142	145	finally
  }
  
  private static void remoteReport(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    b localb = new b();
    localb.a = paramString1;
    localb.a = paramString1;
    localb.b = paramString2;
    localb.c = paramString3;
    localb.d = paramString4;
    localb.e = paramString5;
    localb.f = paramInt1;
    localb.g = paramInt2;
    localb.h = paramString6;
    localb.i = paramString7;
    localb.j = paramString8;
    localb.k = paramString9;
    new Intent("com.tencent.SixGodSDK.Report.QQ.ACTION").putExtra("report_info", localb);
  }
  
  public static void reportException(String paramString, Exception paramException)
  {
    if (paramException == null) {
      return;
    }
    try
    {
      paramException = Log.getStackTraceString(paramException);
      if (sReportImpl != null)
      {
        sReportImpl.report("P_CliOper", "Grp_qiqiqun", "", "SixGodSDK", paramString, 0, 0, "", "1000", sDevInfo, paramException);
        return;
      }
      remoteReport("P_CliOper", "Grp_qiqiqun", "", "SixGodSDK", paramString, 0, 0, "", "1000", sDevInfo, paramException);
      return;
    }
    catch (Exception paramString) {}
  }
  
  public static void reportInfo(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    try
    {
      if (sReportImpl != null) {
        sReportImpl.report("P_CliOper", "Grp_qiqiqun", "", "SixGodSDK", paramString1, paramInt1, paramInt2, paramString2, "1000", paramString4, paramString5);
      }
      for (;;)
      {
        a.a("SixGod_PluginSdk.report", "reportInfo:" + paramString1 + "," + paramInt1 + "," + paramInt2);
        return;
        remoteReport("P_CliOper", "Grp_qiqiqun", "", "SixGodSDK", paramString1, paramInt1, paramInt2, paramString2, "1000", paramString4, paramString5);
      }
      return;
    }
    catch (Exception paramString1)
    {
      a.b("SixGod_PluginSdk.report", "reportInfo:" + paramString1.toString());
    }
  }
  
  public static void unInit(Context paramContext)
  {
    try
    {
      sReportImpl = null;
      paramContext.unregisterReceiver(mReportReceiver);
      a.a("SixGod_PluginSdk.report", "SixGodReporter->unInit");
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        a.b("SixGod_PluginSdk.report", "SixGodReporter->unInit:" + paramContext.toString());
      }
    }
    finally {}
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\sixgod\pluginsdk\log\SixGodReporter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */