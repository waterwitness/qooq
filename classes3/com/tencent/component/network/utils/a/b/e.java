package com.tencent.component.network.utils.a.b;

import java.util.concurrent.TimeUnit;

public abstract class e<T, C>
{
  private final String a;
  private final T b;
  private final C c;
  private final long d;
  private final long e;
  private long f;
  private long g;
  private volatile Object h;
  
  public e(String paramString, T paramT, C paramC, long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramT == null) {
      throw new IllegalArgumentException("Route may not be null");
    }
    if (paramC == null) {
      throw new IllegalArgumentException("Connection may not be null");
    }
    if (paramTimeUnit == null) {
      throw new IllegalArgumentException("Time unit may not be null");
    }
    this.a = paramString;
    this.b = paramT;
    this.c = paramC;
    this.d = System.currentTimeMillis();
    if (paramLong > 0L) {}
    for (this.e = (this.d + paramTimeUnit.toMillis(paramLong));; this.e = Long.MAX_VALUE)
    {
      this.g = this.e;
      return;
    }
  }
  
  public final void a(long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramTimeUnit == null) {
      try
      {
        throw new IllegalArgumentException("Time unit may not be null");
      }
      finally {}
    }
    this.f = System.currentTimeMillis();
    if (paramLong > 0L) {}
    for (paramLong = this.f + paramTimeUnit.toMillis(paramLong);; paramLong = Long.MAX_VALUE)
    {
      this.g = Math.min(paramLong, this.e);
      return;
    }
  }
  
  public final void a(Object paramObject)
  {
    this.h = paramObject;
  }
  
  /* Error */
  public boolean a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 58	com/tencent/component/network/utils/a/b/e:g	J
    //   6: lstore 4
    //   8: lload_1
    //   9: lload 4
    //   11: lcmp
    //   12: iflt +11 -> 23
    //   15: iconst_1
    //   16: istore 6
    //   18: aload_0
    //   19: monitorexit
    //   20: iload 6
    //   22: ireturn
    //   23: iconst_0
    //   24: istore 6
    //   26: goto -8 -> 18
    //   29: astore_3
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_3
    //   33: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	this	e
    //   0	34	1	paramLong	long
    //   29	4	3	localObject	Object
    //   6	4	4	l	long
    //   16	9	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	8	29	finally
  }
  
  public abstract boolean d();
  
  public abstract void e();
  
  public final T f()
  {
    return (T)this.b;
  }
  
  public final C g()
  {
    return (C)this.c;
  }
  
  public final Object h()
  {
    return this.h;
  }
  
  public final long i()
  {
    try
    {
      long l = this.f;
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[id:");
    localStringBuilder.append(this.a);
    localStringBuilder.append("][route:");
    localStringBuilder.append(this.b);
    localStringBuilder.append("][state:");
    localStringBuilder.append(this.h);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\component\network\utils\a\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */