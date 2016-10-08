package com.tencent.bugly;

import android.content.Context;
import android.util.Log;
import com.tencent.bugly.proguard.v;

public class Bugly
{
  public static final String SDK_IS_DEV = "false";
  private static boolean a;
  public static Context applicationContext = null;
  private static String[] b = { "BuglyCrashModule", "BuglyRqdModule", "BuglyBetaModule" };
  private static String[] c = { "BuglyRqdModule", "BuglyCrashModule", "BuglyBetaModule" };
  public static boolean enable = true;
  public static Boolean isDev;
  
  /* Error */
  public static String getAppChannel()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_0
    //   2: ldc 2
    //   4: monitorenter
    //   5: invokestatic 47	com/tencent/bugly/crashreport/common/info/a:a	()Lcom/tencent/bugly/crashreport/common/info/a;
    //   8: astore_1
    //   9: aload_1
    //   10: ifnonnull +8 -> 18
    //   13: ldc 2
    //   15: monitorexit
    //   16: aload_0
    //   17: areturn
    //   18: aload_1
    //   19: getfield 50	com/tencent/bugly/crashreport/common/info/a:m	Ljava/lang/String;
    //   22: invokestatic 56	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   25: ifeq +61 -> 86
    //   28: invokestatic 61	com/tencent/bugly/proguard/n:a	()Lcom/tencent/bugly/proguard/n;
    //   31: astore_0
    //   32: aload_0
    //   33: ifnonnull +11 -> 44
    //   36: aload_1
    //   37: getfield 50	com/tencent/bugly/crashreport/common/info/a:m	Ljava/lang/String;
    //   40: astore_0
    //   41: goto -28 -> 13
    //   44: aload_0
    //   45: sipush 556
    //   48: aconst_null
    //   49: iconst_1
    //   50: invokevirtual 64	com/tencent/bugly/proguard/n:a	(ILcom/tencent/bugly/proguard/m;Z)Ljava/util/Map;
    //   53: astore_0
    //   54: aload_0
    //   55: ifnull +31 -> 86
    //   58: aload_0
    //   59: ldc 66
    //   61: invokeinterface 72 2 0
    //   66: checkcast 74	[B
    //   69: astore_0
    //   70: aload_0
    //   71: ifnull +15 -> 86
    //   74: new 26	java/lang/String
    //   77: dup
    //   78: aload_0
    //   79: invokespecial 77	java/lang/String:<init>	([B)V
    //   82: astore_0
    //   83: goto -70 -> 13
    //   86: aload_1
    //   87: getfield 50	com/tencent/bugly/crashreport/common/info/a:m	Ljava/lang/String;
    //   90: astore_0
    //   91: goto -78 -> 13
    //   94: astore_0
    //   95: ldc 2
    //   97: monitorexit
    //   98: aload_0
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   1	90	0	localObject1	Object
    //   94	5	0	localObject2	Object
    //   8	79	1	locala	com.tencent.bugly.crashreport.common.info.a
    // Exception table:
    //   from	to	target	type
    //   5	9	94	finally
    //   18	32	94	finally
    //   36	41	94	finally
    //   44	54	94	finally
    //   58	70	94	finally
    //   74	83	94	finally
    //   86	91	94	finally
  }
  
  public static void init(Context paramContext, String paramString, boolean paramBoolean)
  {
    init(paramContext, paramString, paramBoolean, null);
  }
  
  public static void init(Context paramContext, String paramString, boolean paramBoolean, BuglyStrategy paramBuglyStrategy)
  {
    for (;;)
    {
      try
      {
        boolean bool = a;
        if (bool) {
          return;
        }
        a = true;
        if (paramContext == null)
        {
          applicationContext = paramContext;
          if (paramContext != null) {
            break label68;
          }
          Log.e(v.b, "init arg 'context' should not be null!");
          continue;
        }
        localContext = paramContext.getApplicationContext();
      }
      finally {}
      Context localContext;
      if (localContext != null)
      {
        paramContext = localContext;
        continue;
        label68:
        if (isDev()) {
          b = c;
        }
        paramContext = b;
        int j = paramContext.length;
        int i = 0;
        for (;;)
        {
          if (i < j)
          {
            localContext = paramContext[i];
            try
            {
              if ((!localContext.equals("BuglyCrashModule")) && (!localContext.equals("BuglyBetaModule")) && (!localContext.equals("BuglyRqdModule"))) {
                localContext.equals("BuglyFeedbackModule");
              }
              i += 1;
            }
            catch (Throwable localThrowable)
            {
              for (;;)
              {
                v.b(localThrowable);
              }
            }
          }
        }
        b.a = enable;
        b.a(applicationContext, paramString, paramBoolean, paramBuglyStrategy);
      }
    }
  }
  
  public static boolean isDev()
  {
    if (isDev == null) {
      isDev = Boolean.valueOf(Boolean.parseBoolean("false".replace("@", "")));
    }
    return isDev.booleanValue();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\bugly\Bugly.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */