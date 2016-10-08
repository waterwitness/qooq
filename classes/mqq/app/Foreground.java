package mqq.app;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class Foreground
  implements Handler.Callback
{
  private static final int DELAY_BROADCAST = 100;
  private static final int MSG_BACK = 0;
  private static final int MSG_FORE = 1;
  public static final String TAG = "ApplicationLife";
  private static Context sContext;
  public static int sCountActivity;
  public static int sCountResume;
  private static Handler sHandler;
  private static String sProcessName;
  
  public static void init(Context paramContext, Looper paramLooper, String paramString)
  {
    if (sHandler == null) {
      try
      {
        if (sHandler == null)
        {
          sContext = paramContext;
          sProcessName = paramString;
          sHandler = new Handler(paramLooper, new Foreground());
        }
        return;
      }
      finally {}
    }
  }
  
  public static void onPause(AppRuntime paramAppRuntime)
  {
    int i = sCountResume - 1;
    sCountResume = i;
    if ((i <= 0) && (paramAppRuntime != null))
    {
      paramAppRuntime.isBackground_Pause = true;
      Iterator localIterator = paramAppRuntime.subRuntimeMap.values().iterator();
      while (localIterator.hasNext()) {
        ((AppRuntime)localIterator.next()).isBackground_Pause = paramAppRuntime.isBackground_Pause;
      }
    }
  }
  
  public static void onResume(AppRuntime paramAppRuntime)
  {
    int i = sCountResume + 1;
    sCountResume = i;
    if ((i > 0) && (paramAppRuntime != null))
    {
      paramAppRuntime.isBackground_Pause = false;
      Iterator localIterator = paramAppRuntime.subRuntimeMap.values().iterator();
      while (localIterator.hasNext()) {
        ((AppRuntime)localIterator.next()).isBackground_Pause = paramAppRuntime.isBackground_Pause;
      }
    }
  }
  
  public static void onStart(AppRuntime paramAppRuntime)
  {
    int i = sCountActivity + 1;
    sCountActivity = i;
    if (i == 1)
    {
      long l = SystemClock.uptimeMillis();
      paramAppRuntime = sHandler.obtainMessage(1, (int)(l >>> 32), (int)(0xFFFFFFFFFFFFFFFF & l), paramAppRuntime);
      sHandler.sendMessageDelayed(paramAppRuntime, 100L);
    }
  }
  
  public static void onStop(AppRuntime paramAppRuntime)
  {
    int i = sCountActivity - 1;
    sCountActivity = i;
    if (i == 0)
    {
      long l = SystemClock.uptimeMillis();
      paramAppRuntime = sHandler.obtainMessage(0, (int)(l >>> 32), (int)(0xFFFFFFFFFFFFFFFF & l), paramAppRuntime);
      sHandler.sendMessageDelayed(paramAppRuntime, 100L);
    }
  }
  
  public static void setReady()
  {
    if (sCountActivity > 0)
    {
      l = SystemClock.uptimeMillis();
      localMessage = sHandler.obtainMessage(1, (int)(l >>> 32), (int)(l & 0xFFFFFFFFFFFFFFFF), null);
      sHandler.sendMessageDelayed(localMessage, 100L);
      return;
    }
    long l = SystemClock.uptimeMillis();
    Message localMessage = sHandler.obtainMessage(0, (int)(l >>> 32), (int)(l & 0xFFFFFFFFFFFFFFFF), null);
    sHandler.sendMessageDelayed(localMessage, 100L);
  }
  
  public static void updateRuntimeState(AppRuntime paramAppRuntime)
  {
    boolean bool2 = true;
    if (paramAppRuntime != null)
    {
      if (sCountResume <= 0)
      {
        bool1 = true;
        paramAppRuntime.isBackground_Pause = bool1;
        if (sCountActivity > 0) {
          break label90;
        }
      }
      label90:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        paramAppRuntime.isBackground_Stop = bool1;
        Iterator localIterator = paramAppRuntime.subRuntimeMap.values().iterator();
        while (localIterator.hasNext())
        {
          AppRuntime localAppRuntime = (AppRuntime)localIterator.next();
          localAppRuntime.isBackground_Pause = paramAppRuntime.isBackground_Pause;
          localAppRuntime.isBackground_Stop = paramAppRuntime.isBackground_Stop;
        }
        bool1 = false;
        break;
      }
    }
  }
  
  /* Error */
  public boolean handleMessage(Message paramMessage)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 117	android/os/Message:obj	Ljava/lang/Object;
    //   4: checkcast 49	mqq/app/AppRuntime
    //   7: astore_2
    //   8: aload_1
    //   9: getfield 120	android/os/Message:arg1	I
    //   12: i2l
    //   13: bipush 32
    //   15: lshl
    //   16: aload_1
    //   17: getfield 123	android/os/Message:arg2	I
    //   20: i2l
    //   21: lor
    //   22: lstore_3
    //   23: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +66 -> 92
    //   29: ldc -126
    //   31: iconst_2
    //   32: new 132	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   39: aload_1
    //   40: getfield 136	android/os/Message:what	I
    //   43: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   46: ldc -114
    //   48: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: getstatic 37	mqq/app/Foreground:sProcessName	Ljava/lang/String;
    //   54: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: ldc -114
    //   59: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: lload_3
    //   63: invokevirtual 148	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   66: ldc -114
    //   68: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: getstatic 83	mqq/app/Foreground:sCountActivity	I
    //   74: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   77: ldc -106
    //   79: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload_2
    //   83: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   86: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: invokestatic 161	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   92: aload_1
    //   93: getfield 136	android/os/Message:what	I
    //   96: tableswitch	default:+24->120, 0:+112->208, 1:+26->122
    //   120: iconst_1
    //   121: ireturn
    //   122: getstatic 83	mqq/app/Foreground:sCountActivity	I
    //   125: ifle +83 -> 208
    //   128: aload_2
    //   129: ifnull +44 -> 173
    //   132: aload_2
    //   133: invokevirtual 164	mqq/app/AppRuntime:onRunningForeground	()V
    //   136: aload_2
    //   137: getfield 57	mqq/app/AppRuntime:subRuntimeMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   140: invokevirtual 63	java/util/concurrent/ConcurrentHashMap:values	()Ljava/util/Collection;
    //   143: invokeinterface 69 1 0
    //   148: astore_1
    //   149: aload_1
    //   150: invokeinterface 75 1 0
    //   155: ifeq +18 -> 173
    //   158: aload_1
    //   159: invokeinterface 79 1 0
    //   164: checkcast 49	mqq/app/AppRuntime
    //   167: invokevirtual 164	mqq/app/AppRuntime:onRunningForeground	()V
    //   170: goto -21 -> 149
    //   173: new 166	android/content/Intent
    //   176: dup
    //   177: ldc -88
    //   179: invokespecial 171	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   182: astore_1
    //   183: aload_1
    //   184: ldc -83
    //   186: getstatic 37	mqq/app/Foreground:sProcessName	Ljava/lang/String;
    //   189: invokevirtual 177	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   192: pop
    //   193: aload_1
    //   194: ldc -77
    //   196: lload_3
    //   197: invokevirtual 182	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   200: pop
    //   201: getstatic 35	mqq/app/Foreground:sContext	Landroid/content/Context;
    //   204: aload_1
    //   205: invokevirtual 188	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   208: getstatic 83	mqq/app/Foreground:sCountActivity	I
    //   211: ifne -91 -> 120
    //   214: aload_2
    //   215: ifnull +44 -> 259
    //   218: aload_2
    //   219: invokevirtual 191	mqq/app/AppRuntime:onRunningBackground	()V
    //   222: aload_2
    //   223: getfield 57	mqq/app/AppRuntime:subRuntimeMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   226: invokevirtual 63	java/util/concurrent/ConcurrentHashMap:values	()Ljava/util/Collection;
    //   229: invokeinterface 69 1 0
    //   234: astore_1
    //   235: aload_1
    //   236: invokeinterface 75 1 0
    //   241: ifeq +18 -> 259
    //   244: aload_1
    //   245: invokeinterface 79 1 0
    //   250: checkcast 49	mqq/app/AppRuntime
    //   253: invokevirtual 191	mqq/app/AppRuntime:onRunningBackground	()V
    //   256: goto -21 -> 235
    //   259: new 166	android/content/Intent
    //   262: dup
    //   263: ldc -63
    //   265: invokespecial 171	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   268: astore_1
    //   269: aload_1
    //   270: ldc -83
    //   272: getstatic 37	mqq/app/Foreground:sProcessName	Ljava/lang/String;
    //   275: invokevirtual 177	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   278: pop
    //   279: aload_1
    //   280: ldc -77
    //   282: lload_3
    //   283: invokevirtual 182	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   286: pop
    //   287: getstatic 35	mqq/app/Foreground:sContext	Landroid/content/Context;
    //   290: aload_1
    //   291: invokevirtual 188	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   294: goto -174 -> 120
    //   297: astore_1
    //   298: goto -178 -> 120
    //   301: astore_1
    //   302: goto -182 -> 120
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	305	0	this	Foreground
    //   0	305	1	paramMessage	Message
    //   7	216	2	localAppRuntime	AppRuntime
    //   22	261	3	l	long
    // Exception table:
    //   from	to	target	type
    //   259	269	297	java/lang/Exception
    //   269	294	301	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\mqq\app\Foreground.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */