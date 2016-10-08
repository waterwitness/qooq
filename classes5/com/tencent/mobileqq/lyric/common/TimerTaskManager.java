package com.tencent.mobileqq.lyric.common;

import android.util.Log;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import szi;
import szj;

public class TimerTaskManager
{
  private static final String jdField_a_of_type_JavaLangString = "LyricTimerTaskManager";
  private Map jdField_a_of_type_JavaUtilMap;
  private ScheduledThreadPoolExecutor jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor;
  
  public TimerTaskManager()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    b();
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor == null) {
      this.jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor = new szi(this, 1);
    }
  }
  
  private void c()
  {
    try
    {
      if ((this.jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor != null) && (this.jdField_a_of_type_JavaUtilMap.isEmpty()))
      {
        Log.i("LyricTimerTaskManager", "shutdown ScheduledThreadPoolExecutor");
        this.jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor.shutdown();
        this.jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void a()
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor != null)
        {
          Log.i("LyricTimerTaskManager", String.format("timer is running : %s; task count = %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.jdField_a_of_type_JavaUtilMap.size()) }));
          Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          Log.i("LyricTimerTaskManager", String.format("taskName : %s; task : %s", new Object[] { localEntry.getKey(), localEntry.getValue() }));
          continue;
        }
        bool = false;
      }
      finally {}
    }
  }
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 25	com/tencent/mobileqq/lyric/common/TimerTaskManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface 113 2 0
    //   12: checkcast 115	szj
    //   15: astore_2
    //   16: aload_2
    //   17: ifnull +128 -> 145
    //   20: ldc 8
    //   22: ldc 117
    //   24: iconst_1
    //   25: anewarray 4	java/lang/Object
    //   28: dup
    //   29: iconst_0
    //   30: aload_1
    //   31: aastore
    //   32: invokestatic 79	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   35: invokestatic 51	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   38: pop
    //   39: aload_2
    //   40: invokestatic 120	szj:a	(Lszj;)Ljava/util/concurrent/ScheduledFuture;
    //   43: ifnull +14 -> 57
    //   46: aload_2
    //   47: invokestatic 120	szj:a	(Lszj;)Ljava/util/concurrent/ScheduledFuture;
    //   50: iconst_1
    //   51: invokeinterface 126 2 0
    //   56: pop
    //   57: aload_0
    //   58: getfield 31	com/tencent/mobileqq/lyric/common/TimerTaskManager:jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor	Ljava/util/concurrent/ScheduledThreadPoolExecutor;
    //   61: aload_2
    //   62: invokestatic 129	szj:a	(Lszj;)Ljava/lang/Runnable;
    //   65: invokevirtual 133	java/util/concurrent/ScheduledThreadPoolExecutor:remove	(Ljava/lang/Runnable;)Z
    //   68: istore_3
    //   69: aload_0
    //   70: getfield 31	com/tencent/mobileqq/lyric/common/TimerTaskManager:jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor	Ljava/util/concurrent/ScheduledThreadPoolExecutor;
    //   73: invokevirtual 136	java/util/concurrent/ScheduledThreadPoolExecutor:purge	()V
    //   76: ldc 8
    //   78: new 138	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   85: ldc -115
    //   87: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: iload_3
    //   91: invokevirtual 148	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   94: ldc -106
    //   96: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: aload_0
    //   100: getfield 31	com/tencent/mobileqq/lyric/common/TimerTaskManager:jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor	Ljava/util/concurrent/ScheduledThreadPoolExecutor;
    //   103: invokevirtual 154	java/util/concurrent/ScheduledThreadPoolExecutor:toString	()Ljava/lang/String;
    //   106: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokestatic 158	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   115: pop
    //   116: aload_2
    //   117: invokestatic 161	szj:a	(Lszj;)Lcom/tencent/mobileqq/lyric/common/TimerTaskManager$TimerTaskRunnable;
    //   120: iconst_0
    //   121: invokestatic 166	com/tencent/mobileqq/lyric/common/TimerTaskManager$TimerTaskRunnable:a	(Lcom/tencent/mobileqq/lyric/common/TimerTaskManager$TimerTaskRunnable;Z)Z
    //   124: pop
    //   125: aload_2
    //   126: aconst_null
    //   127: invokestatic 169	szj:a	(Lszj;Lcom/tencent/mobileqq/lyric/common/TimerTaskManager$TimerTaskRunnable;)Lcom/tencent/mobileqq/lyric/common/TimerTaskManager$TimerTaskRunnable;
    //   130: pop
    //   131: aload_0
    //   132: getfield 25	com/tencent/mobileqq/lyric/common/TimerTaskManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   135: aload_1
    //   136: invokeinterface 171 2 0
    //   141: pop
    //   142: aload_0
    //   143: monitorexit
    //   144: return
    //   145: ldc 8
    //   147: ldc -83
    //   149: iconst_1
    //   150: anewarray 4	java/lang/Object
    //   153: dup
    //   154: iconst_0
    //   155: aload_1
    //   156: aastore
    //   157: invokestatic 79	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   160: invokestatic 51	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   163: pop
    //   164: goto -22 -> 142
    //   167: astore_1
    //   168: aload_0
    //   169: monitorexit
    //   170: aload_1
    //   171: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	this	TimerTaskManager
    //   0	172	1	paramString	String
    //   15	111	2	localszj	szj
    //   68	23	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	16	167	finally
    //   20	57	167	finally
    //   57	142	167	finally
    //   145	164	167	finally
  }
  
  public void a(String paramString, long paramLong1, long paramLong2, TimerTaskManager.TimerTaskRunnable paramTimerTaskRunnable)
  {
    try
    {
      Log.i("LyricTimerTaskManager", String.format("schedule begin [%s].", new Object[] { paramString }));
      if (paramString == null) {
        throw new IllegalArgumentException("taskName 参数不能为 null.");
      }
    }
    finally {}
    if ((paramLong1 < 0L) || (paramLong2 <= 0L)) {
      throw new IllegalArgumentException("delay 或者 period 不合法.");
    }
    if (paramTimerTaskRunnable == null) {
      throw new IllegalArgumentException("runnable 参数不能为 null.");
    }
    b();
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))
    {
      Log.i("LyricTimerTaskManager", String.format("schedule -> cancel duplication of name[%s].", new Object[] { paramString }));
      a(paramString);
    }
    Log.i("LyricTimerTaskManager", String.format("schedule -> create new Task [%s][period : %d].", new Object[] { paramString, Long.valueOf(paramLong2) }));
    paramTimerTaskRunnable = szj.a(paramTimerTaskRunnable);
    szj.a(paramTimerTaskRunnable, paramLong2);
    szj.a(paramTimerTaskRunnable, paramString);
    szj.a(paramTimerTaskRunnable, this.jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor.scheduleWithFixedDelay(szj.a(paramTimerTaskRunnable), paramLong1, paramLong2, TimeUnit.MILLISECONDS));
    this.jdField_a_of_type_JavaUtilMap.put(paramString, paramTimerTaskRunnable);
    Log.i("LyricTimerTaskManager", String.format("schedule end [%s].", new Object[] { paramString }));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\lyric\common\TimerTaskManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */