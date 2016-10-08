package com.tencent.mobileqq.startup.step;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.javahook.TimeoutExceptionHooker;
import com.tencent.mobileqq.javahooksdk.JavaHookBridge;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import utm;

public class InitHook
  extends Step
{
  private static final int jdField_a_of_type_Int = 90001;
  private static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private static boolean jdField_a_of_type_Boolean = false;
  private static final int b = 90002;
  private static final int c = 90003;
  
  private static void a(boolean paramBoolean, Throwable paramThrowable, int paramInt)
  {
    Object localObject1 = BaseApplicationImpl.a.getSharedPreferences("mobileQQ", 0);
    Object localObject2 = ((SharedPreferences)localObject1).getString("reportJavaHook", "");
    Object localObject3 = new Date();
    localObject3 = new SimpleDateFormat("yyyyMMdd").format((Date)localObject3);
    if (((String)localObject3).equals(localObject2)) {
      return;
    }
    localObject1 = ((SharedPreferences)localObject1).edit();
    ((SharedPreferences.Editor)localObject1).putString("reportJavaHook", (String)localObject3);
    if (Build.VERSION.SDK_INT > 8) {
      ((SharedPreferences.Editor)localObject1).apply();
    }
    while (paramBoolean)
    {
      StatisticCollector.a(BaseApplicationImpl.a()).a(null, "JavaHookSdkLoadSo", paramBoolean, 0L, 0L, null, "", true);
      return;
      ((SharedPreferences.Editor)localObject1).commit();
    }
    localObject1 = new HashMap();
    if (paramThrowable != null)
    {
      localObject2 = new StringWriter();
      paramThrowable.printStackTrace(new PrintWriter((Writer)localObject2));
      ((HashMap)localObject1).put("detail", localObject2.toString());
    }
    ((HashMap)localObject1).put("param_FailCode", Integer.toString(paramInt));
    StatisticCollector.a(BaseApplicationImpl.a()).a(null, "JavaHookSdkLoadSo", paramBoolean, 0L, 0L, (HashMap)localObject1, "", true);
  }
  
  private static void b()
  {
    for (;;)
    {
      try
      {
        if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(0, 1)) {
          if ((BaseApplicationImpl.i != 1) && (BaseApplicationImpl.i != 2))
          {
            int i = BaseApplicationImpl.i;
            if (i != 3) {
              continue;
            }
          }
        }
        try
        {
          boolean bool = JavaHookBridge.isSdkAvailable();
          if (bool) {
            continue;
          }
        }
        catch (Throwable localThrowable)
        {
          a(false, localThrowable, 90001);
          continue;
        }
        return;
      }
      finally {}
      TimeoutExceptionHooker.a();
    }
  }
  
  /* Error */
  private static void c()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 166	com/tencent/mobileqq/startup/step/InitHook:jdField_a_of_type_Boolean	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: iconst_1
    //   16: putstatic 166	com/tencent/mobileqq/startup/step/InitHook:jdField_a_of_type_Boolean	Z
    //   19: ldc -88
    //   21: invokestatic 173	com/tencent/mobileqq/app/DeviceProfileManager:b	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   24: getstatic 179	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:hook_switch	Lcom/tencent/mobileqq/app/DeviceProfileManager$DpcNames;
    //   27: invokevirtual 182	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:name	()Ljava/lang/String;
    //   30: ldc -72
    //   32: invokevirtual 186	com/tencent/mobileqq/app/DeviceProfileManager:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   35: invokevirtual 71	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   38: ifne +49 -> 87
    //   41: iconst_0
    //   42: aconst_null
    //   43: ldc 12
    //   45: invokestatic 160	com/tencent/mobileqq/startup/step/InitHook:a	(ZLjava/lang/Throwable;I)V
    //   48: goto -37 -> 11
    //   51: astore_0
    //   52: iconst_0
    //   53: aload_0
    //   54: ldc 7
    //   56: invokestatic 160	com/tencent/mobileqq/startup/step/InitHook:a	(ZLjava/lang/Throwable;I)V
    //   59: invokestatic 92	com/tencent/common/app/BaseApplicationImpl:a	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   62: invokestatic 97	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   65: aconst_null
    //   66: ldc -68
    //   68: iconst_1
    //   69: lconst_0
    //   70: lconst_0
    //   71: aconst_null
    //   72: ldc 45
    //   74: iconst_1
    //   75: invokevirtual 102	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   78: goto -67 -> 11
    //   81: astore_0
    //   82: ldc 2
    //   84: monitorexit
    //   85: aload_0
    //   86: athrow
    //   87: invokestatic 154	com/tencent/mobileqq/javahooksdk/JavaHookBridge:isSdkAvailable	()Z
    //   90: ifne +24 -> 114
    //   93: iconst_0
    //   94: aconst_null
    //   95: ldc 14
    //   97: invokestatic 160	com/tencent/mobileqq/startup/step/InitHook:a	(ZLjava/lang/Throwable;I)V
    //   100: goto -89 -> 11
    //   103: astore_0
    //   104: iconst_0
    //   105: aload_0
    //   106: ldc 7
    //   108: invokestatic 160	com/tencent/mobileqq/startup/step/InitHook:a	(ZLjava/lang/Throwable;I)V
    //   111: goto -52 -> 59
    //   114: invokestatic 191	com/tencent/mobileqq/javahook/BitmapOOMHooker:a	()V
    //   117: invokestatic 194	com/tencent/mobileqq/javahook/BadTokenHooker:a	()V
    //   120: getstatic 149	com/tencent/common/app/BaseApplicationImpl:i	I
    //   123: iconst_1
    //   124: if_icmpne +3 -> 127
    //   127: iconst_1
    //   128: aconst_null
    //   129: iconst_0
    //   130: invokestatic 160	com/tencent/mobileqq/startup/step/InitHook:a	(ZLjava/lang/Throwable;I)V
    //   133: goto -74 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   51	3	0	localException	Exception
    //   81	5	0	localObject	Object
    //   103	3	0	localError	Error
    //   6	2	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   19	48	51	java/lang/Exception
    //   87	100	51	java/lang/Exception
    //   114	127	51	java/lang/Exception
    //   127	133	51	java/lang/Exception
    //   3	7	81	finally
    //   15	19	81	finally
    //   19	48	81	finally
    //   52	59	81	finally
    //   59	78	81	finally
    //   87	100	81	finally
    //   104	111	81	finally
    //   114	127	81	finally
    //   127	133	81	finally
    //   19	48	103	java/lang/Error
    //   87	100	103	java/lang/Error
    //   114	127	103	java/lang/Error
    //   127	133	103	java/lang/Error
  }
  
  protected boolean a()
  {
    if (DeviceProfileManager.b().a() == 4) {
      c();
    }
    for (;;)
    {
      b();
      return true;
      DeviceProfileManager.a(new utm(null));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\startup\step\InitHook.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */