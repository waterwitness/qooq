package com.tencent.mobileqq.msf.core.push;

class h
  extends Thread
{
  h(f paramf) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 23	com/tencent/mobileqq/msf/core/a/a:B	()J
    //   3: lstore_3
    //   4: lload_3
    //   5: lconst_0
    //   6: lcmp
    //   7: ifle +7 -> 14
    //   10: lload_3
    //   11: invokestatic 27	java/lang/Thread:sleep	(J)V
    //   14: invokestatic 33	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:isNetSupport	()Z
    //   17: ifeq +25 -> 42
    //   20: aload_0
    //   21: getfield 10	com/tencent/mobileqq/msf/core/push/h:a	Lcom/tencent/mobileqq/msf/core/push/f;
    //   24: getfield 39	com/tencent/mobileqq/msf/core/push/f:w	Ljava/lang/Object;
    //   27: astore_1
    //   28: aload_1
    //   29: monitorenter
    //   30: aload_0
    //   31: getfield 10	com/tencent/mobileqq/msf/core/push/h:a	Lcom/tencent/mobileqq/msf/core/push/f;
    //   34: getfield 39	com/tencent/mobileqq/msf/core/push/f:w	Ljava/lang/Object;
    //   37: invokevirtual 44	java/lang/Object:notify	()V
    //   40: aload_1
    //   41: monitorexit
    //   42: return
    //   43: astore_1
    //   44: aload_1
    //   45: invokevirtual 47	java/lang/InterruptedException:printStackTrace	()V
    //   48: goto -34 -> 14
    //   51: astore_2
    //   52: aload_1
    //   53: monitorexit
    //   54: aload_2
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	h
    //   43	10	1	localInterruptedException	InterruptedException
    //   51	4	2	localObject2	Object
    //   3	8	3	l	long
    // Exception table:
    //   from	to	target	type
    //   0	4	43	java/lang/InterruptedException
    //   10	14	43	java/lang/InterruptedException
    //   30	42	51	finally
    //   52	54	51	finally
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\core\push\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */