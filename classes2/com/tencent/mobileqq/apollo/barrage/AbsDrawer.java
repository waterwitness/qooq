package com.tencent.mobileqq.apollo.barrage;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.List;

public abstract class AbsDrawer
{
  protected final List a;
  
  public AbsDrawer()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new ArrayList();
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      this.a.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public boolean a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 21	com/tencent/mobileqq/apollo/barrage/AbsDrawer:a	Ljava/util/List;
    //   6: invokeinterface 32 1 0
    //   11: istore_2
    //   12: iload_2
    //   13: ifne +9 -> 22
    //   16: iconst_1
    //   17: istore_2
    //   18: aload_0
    //   19: monitorexit
    //   20: iload_2
    //   21: ireturn
    //   22: iconst_0
    //   23: istore_2
    //   24: goto -6 -> 18
    //   27: astore_1
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_1
    //   31: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	AbsDrawer
    //   27	4	1	localObject	Object
    //   11	13	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	12	27	finally
  }
  
  /* Error */
  public boolean a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 21	com/tencent/mobileqq/apollo/barrage/AbsDrawer:a	Ljava/util/List;
    //   6: invokeinterface 37 1 0
    //   11: astore_2
    //   12: aload_2
    //   13: invokeinterface 42 1 0
    //   18: ifeq +31 -> 49
    //   21: aload_2
    //   22: invokeinterface 46 1 0
    //   27: checkcast 48	com/tencent/mobileqq/apollo/barrage/Barrage
    //   30: getfield 51	com/tencent/mobileqq/apollo/barrage/Barrage:a	I
    //   33: iload_1
    //   34: if_icmpne -22 -> 12
    //   37: aload_2
    //   38: invokeinterface 54 1 0
    //   43: iconst_1
    //   44: istore_3
    //   45: aload_0
    //   46: monitorexit
    //   47: iload_3
    //   48: ireturn
    //   49: iconst_0
    //   50: istore_3
    //   51: goto -6 -> 45
    //   54: astore_2
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_2
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	AbsDrawer
    //   0	59	1	paramInt	int
    //   11	27	2	localIterator	java.util.Iterator
    //   54	4	2	localObject	Object
    //   44	7	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	12	54	finally
    //   12	43	54	finally
  }
  
  public boolean a(Barrage paramBarrage)
  {
    try
    {
      boolean bool = this.a.remove(paramBarrage);
      return bool;
    }
    finally
    {
      paramBarrage = finally;
      throw paramBarrage;
    }
  }
  
  public abstract boolean a(Object paramObject, float paramFloat);
  
  /* Error */
  public boolean a(List paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +27 -> 30
    //   6: aload_1
    //   7: invokeinterface 32 1 0
    //   12: ifne +18 -> 30
    //   15: aload_0
    //   16: getfield 21	com/tencent/mobileqq/apollo/barrage/AbsDrawer:a	Ljava/util/List;
    //   19: aload_1
    //   20: invokeinterface 64 2 0
    //   25: istore_2
    //   26: aload_0
    //   27: monitorexit
    //   28: iload_2
    //   29: ireturn
    //   30: iconst_0
    //   31: istore_2
    //   32: goto -6 -> 26
    //   35: astore_1
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_1
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	AbsDrawer
    //   0	40	1	paramList	List
    //   25	7	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   6	26	35	finally
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\apollo\barrage\AbsDrawer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */