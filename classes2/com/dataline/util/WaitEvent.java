package com.dataline.util;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class WaitEvent
{
  public static final long a = -1L;
  private boolean a;
  private boolean b;
  
  public WaitEvent(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramBoolean1;
    this.b = paramBoolean2;
  }
  
  public void a()
  {
    try
    {
      if (!this.a) {
        this.a = true;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public boolean a(long paramLong)
  {
    // Byte code:
    //   0: invokestatic 34	java/lang/System:currentTimeMillis	()J
    //   3: lstore 4
    //   5: aload_0
    //   6: getfield 22	com/dataline/util/WaitEvent:a	Z
    //   9: ifeq +28 -> 37
    //   12: aload_0
    //   13: monitorenter
    //   14: aload_0
    //   15: getfield 24	com/dataline/util/WaitEvent:b	Z
    //   18: ifeq +15 -> 33
    //   21: aload_0
    //   22: getfield 22	com/dataline/util/WaitEvent:a	Z
    //   25: ifeq +8 -> 33
    //   28: aload_0
    //   29: iconst_1
    //   30: putfield 22	com/dataline/util/WaitEvent:a	Z
    //   33: aload_0
    //   34: monitorexit
    //   35: iconst_1
    //   36: ireturn
    //   37: lconst_1
    //   38: invokestatic 40	java/lang/Thread:sleep	(J)V
    //   41: lload_1
    //   42: ldc2_w 7
    //   45: lcmp
    //   46: ifeq -41 -> 5
    //   49: invokestatic 34	java/lang/System:currentTimeMillis	()J
    //   52: lload 4
    //   54: lsub
    //   55: lload_1
    //   56: lcmp
    //   57: iflt -52 -> 5
    //   60: iconst_0
    //   61: ireturn
    //   62: astore_3
    //   63: aload_0
    //   64: monitorexit
    //   65: aload_3
    //   66: athrow
    //   67: astore_3
    //   68: goto -27 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	WaitEvent
    //   0	71	1	paramLong	long
    //   62	4	3	localObject	Object
    //   67	1	3	localInterruptedException	InterruptedException
    //   3	50	4	l	long
    // Exception table:
    //   from	to	target	type
    //   14	33	62	finally
    //   33	35	62	finally
    //   63	65	62	finally
    //   37	41	67	java/lang/InterruptedException
  }
  
  public void b()
  {
    try
    {
      if (this.a) {
        this.a = false;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\dataline\util\WaitEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */