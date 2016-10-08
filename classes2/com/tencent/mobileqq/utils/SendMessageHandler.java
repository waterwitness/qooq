package com.tencent.mobileqq.utils;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.MessageObserver.StatictisInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class SendMessageHandler
  extends Handler
{
  public static final int a = 0;
  public static final String a = "Q.msg.SendMessageHandler";
  private static ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private static final boolean jdField_a_of_type_Boolean = false;
  public static final int b = 1;
  public static final int c = 2;
  public long a;
  private List jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
  private long b;
  public final String b;
  public final String c = "msf";
  private int d;
  public final String d;
  private int e;
  private int f;
  private int g;
  private volatile int h;
  private volatile int i;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public SendMessageHandler()
  {
    super(Looper.getMainLooper());
    this.jdField_b_of_type_JavaLangString = "period";
    this.jdField_d_of_type_JavaLangString = "server";
    this.jdField_b_of_type_Long = System.currentTimeMillis();
  }
  
  public SendMessageHandler(Looper paramLooper)
  {
    super(paramLooper);
    this.jdField_b_of_type_JavaLangString = "period";
    this.jdField_d_of_type_JavaLangString = "server";
    this.jdField_b_of_type_Long = System.currentTimeMillis();
  }
  
  public static int a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return a(paramToServiceMsg, paramFromServiceMsg, null);
  }
  
  public static int a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, MessageObserver.StatictisInfo paramStatictisInfo)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return 0;
    }
    long l1 = paramToServiceMsg.extraData.getLong("msgSeq", -1L);
    long l2 = paramToServiceMsg.extraData.getLong("timeOut");
    long l3 = paramToServiceMsg.extraData.getInt("retryIndex", 0);
    int j = paramFromServiceMsg.getResultCode();
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.SendMessageHandler", 2, "proc response, seq:" + l1 + ",timeout:" + l2 + " retryIndex:" + l3 + " retCode:" + j);
    }
    SendMessageHandler localSendMessageHandler = (SendMessageHandler)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(l1));
    if (localSendMessageHandler == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.SendMessageHandler", 2, "no handler found");
      }
      return 0;
    }
    localSendMessageHandler.a((int)l3, j, 0L, MessageHandlerUtils.a(paramToServiceMsg, paramFromServiceMsg));
    if (j == 1000)
    {
      if (paramStatictisInfo != null) {
        paramStatictisInfo.jdField_d_of_type_Int = localSendMessageHandler.h;
      }
      localSendMessageHandler.a();
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(l1));
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.SendMessageHandler", 2, " handler removed , seq:" + l1);
      }
      return 1;
    }
    if (j == 2901)
    {
      l2 = localSendMessageHandler.a(System.currentTimeMillis());
      if (l2 < localSendMessageHandler.g)
      {
        l3 = localSendMessageHandler.f;
        localSendMessageHandler.getClass();
        if (localSendMessageHandler.a(0L, l3 - l2 - 5000L, "msf")) {
          return 0;
        }
      }
    }
    if (localSendMessageHandler.a())
    {
      if (paramStatictisInfo != null) {
        paramStatictisInfo.jdField_d_of_type_Int = localSendMessageHandler.h;
      }
      localSendMessageHandler.a();
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(l1));
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.SendMessageHandler", 2, " handler removed , seq:" + l1);
      }
      return 2;
    }
    return 0;
  }
  
  public static boolean a(long paramLong, SendMessageHandler.SendMessageRunnable[] paramArrayOfSendMessageRunnable, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramArrayOfSendMessageRunnable == null) || (paramArrayOfSendMessageRunnable.length == 0) || (paramInt2 == 0) || (paramInt1 == 0)) {
      return false;
    }
    SendMessageHandler localSendMessageHandler = new SendMessageHandler();
    int j = 0;
    while (j < paramArrayOfSendMessageRunnable.length)
    {
      localSendMessageHandler.a(paramArrayOfSendMessageRunnable[j]);
      j += 1;
    }
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong), localSendMessageHandler);
    localSendMessageHandler.jdField_a_of_type_Long = paramLong;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.SendMessageHandler", 2, "add handler, seq:" + paramLong);
    }
    localSendMessageHandler.e = paramInt1;
    localSendMessageHandler.f = paramInt2;
    localSendMessageHandler.jdField_d_of_type_Int = paramArrayOfSendMessageRunnable.length;
    localSendMessageHandler.g = paramInt4;
    localSendMessageHandler.jdField_b_of_type_Long = System.currentTimeMillis();
    paramInt4 = 0;
    if (paramInt4 < paramInt1)
    {
      if (paramInt4 == 0) {}
      for (paramLong = paramInt2;; paramLong = (paramInt1 - paramInt4) * paramInt2 / paramInt1 - paramInt4 * paramInt3)
      {
        long l = paramInt4 * paramInt2 / paramInt1;
        localSendMessageHandler.getClass();
        localSendMessageHandler.a(l, paramLong, "period");
        paramInt4 += 1;
        break;
      }
    }
    return true;
  }
  
  public long a(long paramLong)
  {
    try
    {
      long l = this.jdField_b_of_type_Long;
      return paramLong - l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void a()
  {
    try
    {
      removeCallbacksAndMessages(null);
      this.jdField_a_of_type_JavaUtilList.clear();
      this.h = 0;
      this.i = 0;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void a(SendMessageHandler.SendMessageRunnable paramSendMessageRunnable)
  {
    try
    {
      paramSendMessageRunnable.f = this.jdField_b_of_type_Long;
      this.jdField_a_of_type_JavaUtilList.add(paramSendMessageRunnable);
      return;
    }
    finally
    {
      paramSendMessageRunnable = finally;
      throw paramSendMessageRunnable;
    }
  }
  
  /* Error */
  public boolean a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: istore_2
    //   4: iload_2
    //   5: aload_0
    //   6: getfield 232	com/tencent/mobileqq/utils/SendMessageHandler:i	I
    //   9: if_icmpge +37 -> 46
    //   12: aload_0
    //   13: getfield 79	com/tencent/mobileqq/utils/SendMessageHandler:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   16: iload_2
    //   17: invokeinterface 243 2 0
    //   22: checkcast 234	com/tencent/mobileqq/utils/SendMessageHandler$SendMessageRunnable
    //   25: getfield 245	com/tencent/mobileqq/utils/SendMessageHandler$SendMessageRunnable:c	Z
    //   28: istore_3
    //   29: iload_3
    //   30: ifne +9 -> 39
    //   33: iconst_0
    //   34: istore_3
    //   35: aload_0
    //   36: monitorexit
    //   37: iload_3
    //   38: ireturn
    //   39: iload_2
    //   40: iconst_1
    //   41: iadd
    //   42: istore_2
    //   43: goto -39 -> 4
    //   46: iconst_1
    //   47: istore_3
    //   48: goto -13 -> 35
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	SendMessageHandler
    //   51	4	1	localObject	Object
    //   3	40	2	j	int
    //   28	20	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	29	51	finally
  }
  
  /* Error */
  public boolean a(int paramInt, long paramLong1, long paramLong2, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: aload_0
    //   4: getfield 82	com/tencent/mobileqq/utils/SendMessageHandler:h	I
    //   7: if_icmpge +140 -> 147
    //   10: aload_0
    //   11: getfield 79	com/tencent/mobileqq/utils/SendMessageHandler:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   14: iload_1
    //   15: invokeinterface 243 2 0
    //   20: checkcast 234	com/tencent/mobileqq/utils/SendMessageHandler$SendMessageRunnable
    //   23: astore 7
    //   25: aload 7
    //   27: invokestatic 66	java/lang/System:currentTimeMillis	()J
    //   30: putfield 247	com/tencent/mobileqq/utils/SendMessageHandler$SendMessageRunnable:h	J
    //   33: aload 7
    //   35: lload_2
    //   36: putfield 249	com/tencent/mobileqq/utils/SendMessageHandler$SendMessageRunnable:d	J
    //   39: aload 7
    //   41: lload 4
    //   43: putfield 251	com/tencent/mobileqq/utils/SendMessageHandler$SendMessageRunnable:e	J
    //   46: aload 7
    //   48: iconst_1
    //   49: putfield 245	com/tencent/mobileqq/utils/SendMessageHandler$SendMessageRunnable:c	Z
    //   52: aload 7
    //   54: aload 6
    //   56: putfield 254	com/tencent/mobileqq/utils/SendMessageHandler$SendMessageRunnable:a	[Ljava/lang/String;
    //   59: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   62: ifeq +77 -> 139
    //   65: ldc_w 256
    //   68: iconst_2
    //   69: new 127	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   76: ldc_w 258
    //   79: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload_0
    //   83: getfield 216	com/tencent/mobileqq/utils/SendMessageHandler:jdField_a_of_type_Long	J
    //   86: invokevirtual 137	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   89: ldc_w 260
    //   92: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: iload_1
    //   96: invokevirtual 146	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   99: ldc_w 262
    //   102: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: lload_2
    //   106: invokevirtual 137	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   109: ldc_w 264
    //   112: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: lload 4
    //   117: invokevirtual 137	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   120: ldc_w 266
    //   123: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: aload_0
    //   127: invokevirtual 267	com/tencent/mobileqq/utils/SendMessageHandler:toString	()Ljava/lang/String;
    //   130: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   139: iconst_1
    //   140: istore 8
    //   142: aload_0
    //   143: monitorexit
    //   144: iload 8
    //   146: ireturn
    //   147: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   150: ifeq +13 -> 163
    //   153: ldc_w 256
    //   156: iconst_2
    //   157: ldc_w 269
    //   160: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   163: iconst_0
    //   164: istore 8
    //   166: goto -24 -> 142
    //   169: astore 6
    //   171: aload_0
    //   172: monitorexit
    //   173: aload 6
    //   175: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	SendMessageHandler
    //   0	176	1	paramInt	int
    //   0	176	2	paramLong1	long
    //   0	176	4	paramLong2	long
    //   0	176	6	paramArrayOfString	String[]
    //   23	30	7	localSendMessageRunnable	SendMessageHandler.SendMessageRunnable
    //   140	25	8	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	139	169	finally
    //   147	163	169	finally
  }
  
  /* Error */
  public boolean a(long paramLong1, long paramLong2, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 232	com/tencent/mobileqq/utils/SendMessageHandler:i	I
    //   6: istore 6
    //   8: aload_0
    //   9: getfield 79	com/tencent/mobileqq/utils/SendMessageHandler:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   12: invokeinterface 274 1 0
    //   17: istore 7
    //   19: iload 6
    //   21: iload 7
    //   23: if_icmplt +11 -> 34
    //   26: iconst_0
    //   27: istore 8
    //   29: aload_0
    //   30: monitorexit
    //   31: iload 8
    //   33: ireturn
    //   34: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   37: ifeq +75 -> 112
    //   40: ldc 10
    //   42: iconst_2
    //   43: new 127	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   50: ldc_w 276
    //   53: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload_0
    //   57: getfield 216	com/tencent/mobileqq/utils/SendMessageHandler:jdField_a_of_type_Long	J
    //   60: invokevirtual 137	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   63: ldc_w 278
    //   66: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: lload_1
    //   70: invokevirtual 137	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   73: ldc -117
    //   75: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: lload_3
    //   79: invokevirtual 137	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   82: ldc_w 280
    //   85: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: aload_0
    //   89: getfield 232	com/tencent/mobileqq/utils/SendMessageHandler:i	I
    //   92: invokevirtual 146	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   95: ldc_w 282
    //   98: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: aload 5
    //   103: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   112: aload_0
    //   113: aload_0
    //   114: getfield 232	com/tencent/mobileqq/utils/SendMessageHandler:i	I
    //   117: iconst_1
    //   118: iadd
    //   119: putfield 232	com/tencent/mobileqq/utils/SendMessageHandler:i	I
    //   122: aload_0
    //   123: new 284	wdh
    //   126: dup
    //   127: aload_0
    //   128: lload_3
    //   129: aload 5
    //   131: invokespecial 287	wdh:<init>	(Lcom/tencent/mobileqq/utils/SendMessageHandler;JLjava/lang/String;)V
    //   134: lload_1
    //   135: invokevirtual 291	com/tencent/mobileqq/utils/SendMessageHandler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   138: pop
    //   139: iconst_1
    //   140: istore 8
    //   142: goto -113 -> 29
    //   145: astore 5
    //   147: aload_0
    //   148: monitorexit
    //   149: aload 5
    //   151: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	this	SendMessageHandler
    //   0	152	1	paramLong1	long
    //   0	152	3	paramLong2	long
    //   0	152	5	paramString	String
    //   6	18	6	j	int
    //   17	7	7	k	int
    //   27	114	8	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	19	145	finally
    //   34	112	145	finally
    //   112	139	145	finally
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    int k = this.h;
    if ((k > 0) && (this.jdField_a_of_type_JavaUtilList.size() >= k))
    {
      int j = 0;
      while (j < k) {
        try
        {
          localStringBuilder.append(((SendMessageHandler.SendMessageRunnable)this.jdField_a_of_type_JavaUtilList.get(j)).toString());
          if (j != k - 1) {
            localStringBuilder.append(",");
          }
          j += 1;
        }
        catch (Exception localException)
        {
          localStringBuilder.append(localException.getMessage());
        }
      }
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\utils\SendMessageHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */