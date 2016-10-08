package com.tencent.component.network.utils.a.b;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class a<T, C, E extends e<T, C>>
{
  private final Lock a;
  private final d<T, C> b;
  private final Map<T, g<T, C, E>> c;
  private final Set<E> d;
  private final LinkedList<E> e;
  private final LinkedList<f<E>> f;
  private final Map<T, Integer> g;
  private volatile boolean h;
  private volatile int i;
  private volatile int j;
  
  public a(d<T, C> paramd)
  {
    if (paramd == null) {
      throw new IllegalArgumentException("Connection factory may not null");
    }
    this.a = new ReentrantLock();
    this.b = paramd;
    this.c = new HashMap();
    this.d = new HashSet();
    this.e = new LinkedList();
    this.f = new LinkedList();
    this.g = new HashMap();
    this.i = 2;
    this.j = 20;
  }
  
  private E a(T paramT, Object paramObject, long paramLong, TimeUnit paramTimeUnit, f<E> paramf)
    throws IOException, InterruptedException, TimeoutException
  {
    g localg;
    Object localObject;
    label69:
    e locale;
    int k;
    label210:
    int n;
    int m;
    if (paramLong > 0L)
    {
      paramTimeUnit = new Date(System.currentTimeMillis() + paramTimeUnit.toMillis(paramLong));
      this.a.lock();
      try
      {
        localg = a(paramT);
        localObject = null;
      }
      finally
      {
        this.a.unlock();
      }
      throw new TimeoutException("Timeout waiting for connection");
      if (this.h) {
        throw new IllegalStateException("Connection pool shut down");
      }
      for (;;)
      {
        locale = localg.b(paramObject);
        if ((locale == null) || ((!locale.d()) && (!locale.a(System.currentTimeMillis())))) {
          break;
        }
        locale.e();
        this.e.remove(locale);
        localg.a(locale, false);
      }
      if (locale != null)
      {
        this.e.remove(locale);
        this.d.add(locale);
        this.a.unlock();
        return locale;
      }
      localObject = (Integer)this.g.get(paramT);
      if (localObject != null)
      {
        k = ((Integer)localObject).intValue();
        n = Math.max(0, localg.a() + 1 - k);
        if (n > 0)
        {
          m = 0;
          break label532;
        }
      }
    }
    for (;;)
    {
      label237:
      if (localg.a() < k)
      {
        k = this.d.size();
        k = Math.max(this.j - k, 0);
        if (k > 0)
        {
          if ((this.e.size() > k - 1) && (!this.e.isEmpty()))
          {
            paramT = (e)this.e.removeLast();
            paramT.e();
            a(paramT.f()).a(paramT);
          }
          paramT = localg.c(this.b.a());
          this.d.add(paramT);
          this.a.unlock();
          return paramT;
          k = this.i;
          break label210;
        }
      }
      label532:
      do
      {
        localObject = localg.b();
        if (localObject == null) {
          break label237;
        }
        ((e)localObject).e();
        this.e.remove(localObject);
        localg.a((e)localObject);
        m += 1;
        continue;
        try
        {
          localg.a(paramf);
          this.f.add(paramf);
          boolean bool = paramf.a(paramTimeUnit);
          localg.b(paramf);
          this.f.remove(paramf);
          localObject = locale;
          if (!bool)
          {
            localObject = locale;
            if (paramTimeUnit != null)
            {
              if (paramTimeUnit.getTime() <= System.currentTimeMillis()) {
                break;
              }
              localObject = locale;
            }
          }
        }
        finally
        {
          localg.b(paramf);
          this.f.remove(paramf);
        }
        if (localObject == null) {
          break label69;
        }
        break;
      } while (m < n);
    }
  }
  
  private g<T, C, E> a(T paramT)
  {
    g localg = (g)this.c.get(paramT);
    Object localObject = localg;
    if (localg == null)
    {
      localObject = new b(this, paramT, paramT);
      this.c.put(paramT, localObject);
    }
    return (g<T, C, E>)localObject;
  }
  
  private void a(g<T, C, E> paramg)
  {
    paramg = paramg.c();
    if (paramg != null) {
      this.f.remove(paramg);
    }
    for (;;)
    {
      if (paramg != null) {
        paramg.a();
      }
      return;
      paramg = (f)this.f.poll();
    }
  }
  
  protected abstract E a(T paramT, C paramC);
  
  public final void a()
    throws IOException
  {
    if (this.h) {
      return;
    }
    this.h = true;
    this.a.lock();
    for (;;)
    {
      try
      {
        Iterator localIterator = this.e.iterator();
        if (!localIterator.hasNext())
        {
          localIterator = this.d.iterator();
          if (!localIterator.hasNext())
          {
            localIterator = this.c.values().iterator();
            if (localIterator.hasNext()) {
              break label159;
            }
            this.c.clear();
            this.d.clear();
            this.e.clear();
          }
        }
        else
        {
          ((e)localIterator.next()).e();
          continue;
        }
        ((e)((Iterator)localObject).next()).e();
      }
      finally
      {
        this.a.unlock();
      }
      continue;
      label159:
      ((g)((Iterator)localObject).next()).d();
    }
  }
  
  public final void a(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("Max value may not be negative or zero");
    }
    this.a.lock();
    try
    {
      this.j = paramInt;
      return;
    }
    finally
    {
      this.a.unlock();
    }
  }
  
  public final void a(long paramLong, TimeUnit paramTimeUnit)
  {
    long l = 0L;
    if (paramTimeUnit == null) {
      throw new IllegalArgumentException("Time unit must not be null.");
    }
    paramLong = paramTimeUnit.toMillis(paramLong);
    if (paramLong < 0L)
    {
      paramLong = l;
      for (;;)
      {
        l = System.currentTimeMillis();
        this.a.lock();
        try
        {
          paramTimeUnit = this.e.iterator();
          for (;;)
          {
            boolean bool = paramTimeUnit.hasNext();
            if (!bool) {
              return;
            }
            e locale = (e)paramTimeUnit.next();
            if (locale.i() <= l - paramLong)
            {
              locale.e();
              g localg = a(locale.f());
              localg.a(locale);
              paramTimeUnit.remove();
              a(localg);
            }
          }
        }
        finally
        {
          this.a.unlock();
        }
      }
    }
  }
  
  /* Error */
  public final void a(E paramE, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 45	com/tencent/component/network/utils/a/b/a:a	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 106 1 0
    //   9: aload_0
    //   10: getfield 57	com/tencent/component/network/utils/a/b/a:d	Ljava/util/Set;
    //   13: aload_1
    //   14: invokeinterface 270 2 0
    //   19: ifeq +42 -> 61
    //   22: aload_0
    //   23: aload_1
    //   24: invokevirtual 182	com/tencent/component/network/utils/a/b/e:f	()Ljava/lang/Object;
    //   27: invokespecial 109	com/tencent/component/network/utils/a/b/a:a	(Ljava/lang/Object;)Lcom/tencent/component/network/utils/a/b/g;
    //   30: astore_3
    //   31: aload_3
    //   32: aload_1
    //   33: iload_2
    //   34: invokevirtual 144	com/tencent/component/network/utils/a/b/g:a	(Lcom/tencent/component/network/utils/a/b/e;Z)V
    //   37: iload_2
    //   38: ifeq +33 -> 71
    //   41: aload_0
    //   42: getfield 117	com/tencent/component/network/utils/a/b/a:h	Z
    //   45: ifne +26 -> 71
    //   48: aload_0
    //   49: getfield 62	com/tencent/component/network/utils/a/b/a:e	Ljava/util/LinkedList;
    //   52: aload_1
    //   53: invokevirtual 274	java/util/LinkedList:addFirst	(Ljava/lang/Object;)V
    //   56: aload_0
    //   57: aload_3
    //   58: invokespecial 269	com/tencent/component/network/utils/a/b/a:a	(Lcom/tencent/component/network/utils/a/b/g;)V
    //   61: aload_0
    //   62: getfield 45	com/tencent/component/network/utils/a/b/a:a	Ljava/util/concurrent/locks/Lock;
    //   65: invokeinterface 115 1 0
    //   70: return
    //   71: aload_1
    //   72: invokevirtual 137	com/tencent/component/network/utils/a/b/e:e	()V
    //   75: goto -19 -> 56
    //   78: astore_1
    //   79: aload_0
    //   80: getfield 45	com/tencent/component/network/utils/a/b/a:a	Ljava/util/concurrent/locks/Lock;
    //   83: invokeinterface 115 1 0
    //   88: aload_1
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	a
    //   0	90	1	paramE	E
    //   0	90	2	paramBoolean	boolean
    //   30	28	3	localg	g
    // Exception table:
    //   from	to	target	type
    //   9	37	78	finally
    //   41	56	78	finally
    //   56	61	78	finally
    //   71	75	78	finally
  }
  
  public final Future<E> b(T paramT, Object paramObject)
  {
    if (paramT == null) {
      throw new IllegalArgumentException("Route may not be null");
    }
    if (this.h) {
      throw new IllegalStateException("Connection pool shut down");
    }
    return new c(this, this.a, paramT, paramObject);
  }
  
  /* Error */
  public final void b()
  {
    // Byte code:
    //   0: invokestatic 92	java/lang/System:currentTimeMillis	()J
    //   3: lstore 4
    //   5: aload_0
    //   6: getfield 45	com/tencent/component/network/utils/a/b/a:a	Ljava/util/concurrent/locks/Lock;
    //   9: invokeinterface 106 1 0
    //   14: aload_0
    //   15: getfield 62	com/tencent/component/network/utils/a/b/a:e	Ljava/util/LinkedList;
    //   18: invokevirtual 234	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   21: astore_1
    //   22: aload_1
    //   23: invokeinterface 239 1 0
    //   28: istore 6
    //   30: iload 6
    //   32: ifne +13 -> 45
    //   35: aload_0
    //   36: getfield 45	com/tencent/component/network/utils/a/b/a:a	Ljava/util/concurrent/locks/Lock;
    //   39: invokeinterface 115 1 0
    //   44: return
    //   45: aload_1
    //   46: invokeinterface 255 1 0
    //   51: checkcast 129	com/tencent/component/network/utils/a/b/e
    //   54: astore_2
    //   55: aload_2
    //   56: lload 4
    //   58: invokevirtual 135	com/tencent/component/network/utils/a/b/e:a	(J)Z
    //   61: ifeq -39 -> 22
    //   64: aload_2
    //   65: invokevirtual 137	com/tencent/component/network/utils/a/b/e:e	()V
    //   68: aload_0
    //   69: aload_2
    //   70: invokevirtual 182	com/tencent/component/network/utils/a/b/e:f	()Ljava/lang/Object;
    //   73: invokespecial 109	com/tencent/component/network/utils/a/b/a:a	(Ljava/lang/Object;)Lcom/tencent/component/network/utils/a/b/g;
    //   76: astore_3
    //   77: aload_3
    //   78: aload_2
    //   79: invokevirtual 185	com/tencent/component/network/utils/a/b/g:a	(Lcom/tencent/component/network/utils/a/b/e;)Z
    //   82: pop
    //   83: aload_1
    //   84: invokeinterface 267 1 0
    //   89: aload_0
    //   90: aload_3
    //   91: invokespecial 269	com/tencent/component/network/utils/a/b/a:a	(Lcom/tencent/component/network/utils/a/b/g;)V
    //   94: goto -72 -> 22
    //   97: astore_1
    //   98: aload_0
    //   99: getfield 45	com/tencent/component/network/utils/a/b/a:a	Ljava/util/concurrent/locks/Lock;
    //   102: invokeinterface 115 1 0
    //   107: aload_1
    //   108: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	this	a
    //   21	63	1	localIterator	Iterator
    //   97	11	1	localObject	Object
    //   54	25	2	locale	e
    //   76	15	3	localg	g
    //   3	54	4	l	long
    //   28	3	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   14	22	97	finally
    //   22	30	97	finally
    //   45	94	97	finally
  }
  
  public final void b(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("Max value may not be negative or zero");
    }
    this.a.lock();
    try
    {
      this.i = paramInt;
      return;
    }
    finally
    {
      this.a.unlock();
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[leased: ");
    localStringBuilder.append(this.d);
    localStringBuilder.append("][available: ");
    localStringBuilder.append(this.e);
    localStringBuilder.append("][pending: ");
    localStringBuilder.append(this.f);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\component\network\utils\a\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */