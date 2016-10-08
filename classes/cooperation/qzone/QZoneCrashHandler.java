package cooperation.qzone;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.CrashHandler;
import mqq.app.MobileQQ;

public class QZoneCrashHandler
  extends CrashHandler
{
  public static String a;
  private static Thread.UncaughtExceptionHandler a;
  public static String b = "?";
  private static final String c = "QZ_setting";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public QZoneCrashHandler()
  {
    if (a == null) {
      a = Thread.getDefaultUncaughtExceptionHandler();
    }
  }
  
  public static String a()
  {
    Object localObject = BaseApplication.getContext().getSharedPreferences("QZ_setting", 0);
    String str = ((SharedPreferences)localObject).getString("key_last_crash_info", null);
    if (str != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).remove("key_last_crash_info");
      if (Build.VERSION.SDK_INT < 9) {
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
    else
    {
      return str;
    }
    ((SharedPreferences.Editor)localObject).apply();
    return str;
  }
  
  public static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = BaseApplication.getContext().getSharedPreferences("QZ_setting", 0).edit().putString("key_last_crash_info", paramString);
    if (Build.VERSION.SDK_INT < 9)
    {
      paramString.commit();
      return;
    }
    paramString.apply();
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 93	java/io/File
    //   6: dup
    //   7: getstatic 98	com/tencent/mobileqq/app/AppConstants:bn	Ljava/lang/String;
    //   10: invokespecial 100	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore_3
    //   14: aload_3
    //   15: invokevirtual 103	java/io/File:exists	()Z
    //   18: ifne +8 -> 26
    //   21: aload_3
    //   22: invokevirtual 106	java/io/File:mkdirs	()Z
    //   25: pop
    //   26: new 93	java/io/File
    //   29: dup
    //   30: new 108	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   37: getstatic 98	com/tencent/mobileqq/app/AppConstants:bn	Ljava/lang/String;
    //   40: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: ldc 115
    //   45: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokespecial 100	java/io/File:<init>	(Ljava/lang/String;)V
    //   54: astore_3
    //   55: aload_3
    //   56: invokevirtual 103	java/io/File:exists	()Z
    //   59: ifne +221 -> 280
    //   62: iconst_1
    //   63: istore 5
    //   65: new 120	java/io/FileWriter
    //   68: dup
    //   69: aload_3
    //   70: iconst_1
    //   71: invokespecial 123	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   74: astore_3
    //   75: iload 5
    //   77: ifeq +100 -> 177
    //   80: aload_3
    //   81: new 108	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   88: ldc 125
    //   90: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: getstatic 130	android/os/Build:MODEL	Ljava/lang/String;
    //   96: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: ldc -124
    //   101: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: getstatic 135	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   107: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokevirtual 138	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   116: aload_3
    //   117: ldc -116
    //   119: invokevirtual 138	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   122: new 142	android/text/format/Time
    //   125: dup
    //   126: invokespecial 143	android/text/format/Time:<init>	()V
    //   129: astore 4
    //   131: aload 4
    //   133: invokevirtual 146	android/text/format/Time:setToNow	()V
    //   136: aload_3
    //   137: new 108	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   144: aload 4
    //   146: ldc -108
    //   148: invokevirtual 152	android/text/format/Time:format	(Ljava/lang/String;)Ljava/lang/String;
    //   151: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: ldc -102
    //   156: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokevirtual 138	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   165: aload_3
    //   166: ldc -100
    //   168: invokevirtual 138	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   171: aload_3
    //   172: ldc -116
    //   174: invokevirtual 138	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   177: new 142	android/text/format/Time
    //   180: dup
    //   181: invokespecial 143	android/text/format/Time:<init>	()V
    //   184: astore 4
    //   186: aload 4
    //   188: invokevirtual 146	android/text/format/Time:setToNow	()V
    //   191: aload_3
    //   192: new 108	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   199: aload 4
    //   201: ldc -108
    //   203: invokevirtual 152	android/text/format/Time:format	(Ljava/lang/String;)Ljava/lang/String;
    //   206: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: ldc -102
    //   211: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokevirtual 138	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   220: aload_0
    //   221: ifnull +31 -> 252
    //   224: aload_3
    //   225: new 108	java/lang/StringBuilder
    //   228: dup
    //   229: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   232: ldc -98
    //   234: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: aload_0
    //   238: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: ldc -96
    //   243: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   249: invokevirtual 138	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   252: aload_3
    //   253: aload_1
    //   254: invokevirtual 138	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   257: aload_3
    //   258: ldc -116
    //   260: invokevirtual 138	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   263: aload_3
    //   264: invokevirtual 163	java/io/FileWriter:close	()V
    //   267: iconst_0
    //   268: ifeq +11 -> 279
    //   271: new 165	java/lang/NullPointerException
    //   274: dup
    //   275: invokespecial 166	java/lang/NullPointerException:<init>	()V
    //   278: athrow
    //   279: return
    //   280: iconst_0
    //   281: istore 5
    //   283: goto -218 -> 65
    //   286: astore_0
    //   287: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   290: ifeq -11 -> 279
    //   293: ldc -83
    //   295: iconst_1
    //   296: new 108	java/lang/StringBuilder
    //   299: dup
    //   300: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   303: ldc -81
    //   305: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: aload_0
    //   309: invokevirtual 178	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   312: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   318: invokestatic 182	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   321: return
    //   322: astore_1
    //   323: aload 4
    //   325: astore_0
    //   326: aload_1
    //   327: invokevirtual 185	java/lang/Exception:printStackTrace	()V
    //   330: aload_0
    //   331: ifnull -52 -> 279
    //   334: aload_0
    //   335: invokevirtual 163	java/io/FileWriter:close	()V
    //   338: return
    //   339: astore_0
    //   340: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   343: ifeq -64 -> 279
    //   346: ldc -83
    //   348: iconst_1
    //   349: new 108	java/lang/StringBuilder
    //   352: dup
    //   353: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   356: ldc -81
    //   358: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: aload_0
    //   362: invokevirtual 178	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   365: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   371: invokestatic 182	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   374: return
    //   375: astore_0
    //   376: aconst_null
    //   377: astore_1
    //   378: aload_1
    //   379: ifnull +7 -> 386
    //   382: aload_1
    //   383: invokevirtual 163	java/io/FileWriter:close	()V
    //   386: aload_0
    //   387: athrow
    //   388: astore_1
    //   389: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   392: ifeq -6 -> 386
    //   395: ldc -83
    //   397: iconst_1
    //   398: new 108	java/lang/StringBuilder
    //   401: dup
    //   402: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   405: ldc -81
    //   407: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: aload_1
    //   411: invokevirtual 178	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   414: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   420: invokestatic 182	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   423: goto -37 -> 386
    //   426: astore_0
    //   427: aload_3
    //   428: astore_1
    //   429: goto -51 -> 378
    //   432: astore_3
    //   433: aload_0
    //   434: astore_1
    //   435: aload_3
    //   436: astore_0
    //   437: goto -59 -> 378
    //   440: astore_1
    //   441: aload_3
    //   442: astore_0
    //   443: goto -117 -> 326
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	446	0	paramString1	String
    //   0	446	1	paramString2	String
    //   0	446	2	paramBoolean	boolean
    //   13	415	3	localObject1	Object
    //   432	10	3	localObject2	Object
    //   1	323	4	localTime	android.text.format.Time
    //   63	219	5	i	int
    // Exception table:
    //   from	to	target	type
    //   271	279	286	java/lang/Exception
    //   3	26	322	java/lang/Exception
    //   26	62	322	java/lang/Exception
    //   65	75	322	java/lang/Exception
    //   334	338	339	java/lang/Exception
    //   3	26	375	finally
    //   26	62	375	finally
    //   65	75	375	finally
    //   382	386	388	java/lang/Exception
    //   80	177	426	finally
    //   177	220	426	finally
    //   224	252	426	finally
    //   252	267	426	finally
    //   326	330	432	finally
    //   80	177	440	java/lang/Exception
    //   177	220	440	java/lang/Exception
    //   224	252	440	java/lang/Exception
    //   252	267	440	java/lang/Exception
  }
  
  void a() {}
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    super.uncaughtException(paramThread, paramThrowable);
    Object localObject = BaseApplicationImpl.a.getAllAccounts();
    if (localObject != null)
    {
      localObject = (SimpleAccount)((List)localObject).get(0);
      if (localObject == null) {
        break label114;
      }
    }
    label114:
    for (localObject = ((SimpleAccount)localObject).getUin();; localObject = "0")
    {
      long l = Long.valueOf((String)localObject).longValue();
      CrashGuard.a().a(paramThrowable, l);
      localObject = (MobileQQ)BaseApplication.getContext();
      String str = QLog.getStackTraceString(paramThrowable);
      QLog.e("crash", 1, str);
      a(str);
      a("crash", str, true);
      a.uncaughtException(paramThread, paramThrowable);
      ((MobileQQ)localObject).crashed();
      ((MobileQQ)localObject).otherProcessExit(false);
      return;
      localObject = null;
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\cooperation\qzone\QZoneCrashHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */