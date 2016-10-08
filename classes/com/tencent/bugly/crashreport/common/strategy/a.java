package com.tencent.bugly.crashreport.common.strategy;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.crashreport.biz.b;
import com.tencent.bugly.proguard.al;
import com.tencent.bugly.proguard.am;
import com.tencent.bugly.proguard.n;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.u;
import com.tencent.bugly.proguard.v;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a
{
  public static int a = 1000;
  public static long b;
  private static a c = null;
  private final List<com.tencent.bugly.a> d;
  private final u e;
  private final StrategyBean f;
  private StrategyBean g = null;
  private Context h;
  
  private a(Context paramContext, List<com.tencent.bugly.a> paramList)
  {
    this.h = paramContext;
    this.f = new StrategyBean();
    this.d = paramList;
    this.e = u.a();
    this.e.b(new Thread()
    {
      public final void run()
      {
        try
        {
          Object localObject2 = n.a().a(a.a, null, true);
          if (localObject2 != null)
          {
            localObject1 = (byte[])((Map)localObject2).get("key_imei");
            localObject2 = (byte[])((Map)localObject2).get("key_ip");
            if (localObject1 != null) {
              com.tencent.bugly.crashreport.common.info.a.a(a.a(a.this)).e(new String((byte[])localObject1));
            }
            if (localObject2 != null) {
              com.tencent.bugly.crashreport.common.info.a.a(a.a(a.this)).d(new String((byte[])localObject2));
            }
          }
          Object localObject1 = a.this;
          localObject1 = a.d();
          a.a(a.this, (StrategyBean)localObject1);
          a.this.a(a.b(a.this));
          return;
        }
        catch (Throwable localThrowable)
        {
          while (v.a(localThrowable)) {}
          localThrowable.printStackTrace();
        }
      }
    });
  }
  
  public static a a()
  {
    try
    {
      a locala = c;
      return locala;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static a a(Context paramContext, List<com.tencent.bugly.a> paramList)
  {
    try
    {
      if (c == null) {
        c = new a(paramContext, paramList);
      }
      paramContext = c;
      return paramContext;
    }
    finally {}
  }
  
  public static StrategyBean d()
  {
    Object localObject = n.a().a(2);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (p)((List)localObject).get(0);
      if (((p)localObject).g != null) {
        return (StrategyBean)com.tencent.bugly.proguard.a.a(((p)localObject).g, StrategyBean.CREATOR);
      }
    }
    return null;
  }
  
  protected final void a(StrategyBean paramStrategyBean)
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.bugly.a locala = (com.tencent.bugly.a)localIterator.next();
      try
      {
        v.c("[strategy] Notify %s", new Object[] { locala.getClass().getName() });
        locala.onServerStrategyChanged(paramStrategyBean);
      }
      catch (Throwable localThrowable) {}
      if (!v.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    b.a(paramStrategyBean);
  }
  
  public final void a(am paramam)
  {
    if (paramam == null) {}
    while ((this.g != null) && (paramam.h == this.g.o)) {
      return;
    }
    localStrategyBean = new StrategyBean();
    localStrategyBean.g = paramam.a;
    localStrategyBean.i = paramam.c;
    localStrategyBean.h = paramam.b;
    Object localObject = paramam.d;
    int i;
    if ((localObject != null) && (((String)localObject).trim().length() > 0))
    {
      i = 0;
      if (i == 0)
      {
        v.c("upload url changes to %s", new Object[] { paramam.d });
        localStrategyBean.q = paramam.d;
      }
      localObject = paramam.e;
      if ((localObject == null) || (((String)localObject).trim().length() <= 0)) {
        break label619;
      }
      i = 0;
      label133:
      if (i == 0)
      {
        v.c("exception upload url changes to %s", new Object[] { paramam.e });
        localStrategyBean.r = paramam.e;
      }
      if (paramam.f != null)
      {
        localObject = paramam.f.a;
        if ((localObject == null) || (((String)localObject).trim().length() <= 0)) {
          break label625;
        }
        i = 0;
        label195:
        if (i == 0) {
          localStrategyBean.t = paramam.f.a;
        }
      }
      if (paramam.h != 0L) {
        localStrategyBean.o = paramam.h;
      }
      if ((paramam.g != null) && (paramam.g.size() > 0))
      {
        localStrategyBean.u = paramam.g;
        localObject = (String)paramam.g.get("B11");
        if ((localObject == null) || (!((String)localObject).equals("1"))) {
          break label631;
        }
      }
    }
    label619:
    label625:
    label631:
    for (localStrategyBean.j = true;; localStrategyBean.j = false)
    {
      localObject = (String)paramam.g.get("B3");
      if (localObject != null) {
        localStrategyBean.x = Long.valueOf((String)localObject).longValue();
      }
      localStrategyBean.p = paramam.i;
      localStrategyBean.w = paramam.i;
      localObject = (String)paramam.g.get("B27");
      if ((localObject != null) && (((String)localObject).length() > 0)) {}
      try
      {
        i = Integer.parseInt((String)localObject);
        if (i > 0) {
          localStrategyBean.v = i;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          byte[] arrayOfByte;
          if (!v.a(localException))
          {
            localException.printStackTrace();
            continue;
            localStrategyBean.l = false;
          }
        }
      }
      paramam = (String)paramam.g.get("B25");
      if ((paramam == null) || (!paramam.equals("1"))) {
        break label654;
      }
      localStrategyBean.l = true;
      v.a("cr:%b,qu:%b,uin:%b,an:%b,bl:%b,ss:%b,ssT:%b,ssOT:%d,cos:%b,lstT:%d", new Object[] { Boolean.valueOf(localStrategyBean.g), Boolean.valueOf(localStrategyBean.i), Boolean.valueOf(localStrategyBean.h), Boolean.valueOf(localStrategyBean.j), Boolean.valueOf(localStrategyBean.k), Boolean.valueOf(localStrategyBean.m), Boolean.valueOf(localStrategyBean.n), Long.valueOf(localStrategyBean.p), Boolean.valueOf(localStrategyBean.l), Long.valueOf(localStrategyBean.o) });
      this.g = localStrategyBean;
      n.a();
      n.b(2);
      paramam = new p();
      paramam.b = 2;
      paramam.a = localStrategyBean.e;
      paramam.e = localStrategyBean.f;
      localObject = Parcel.obtain();
      localStrategyBean.writeToParcel((Parcel)localObject, 0);
      arrayOfByte = ((Parcel)localObject).marshall();
      ((Parcel)localObject).recycle();
      paramam.g = arrayOfByte;
      n.a().a(paramam);
      a(localStrategyBean);
      return;
      i = 1;
      break;
      i = 1;
      break label133;
      i = 1;
      break label195;
    }
  }
  
  /* Error */
  public final boolean b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 35	com/tencent/bugly/crashreport/common/strategy/a:g	Lcom/tencent/bugly/crashreport/common/strategy/StrategyBean;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +9 -> 17
    //   11: iconst_1
    //   12: istore_2
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_2
    //   16: ireturn
    //   17: iconst_0
    //   18: istore_2
    //   19: goto -6 -> 13
    //   22: astore_1
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_1
    //   26: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	27	0	this	a
    //   6	2	1	localStrategyBean	StrategyBean
    //   22	4	1	localObject	Object
    //   12	7	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
  }
  
  public final StrategyBean c()
  {
    if (this.g != null) {
      return this.g;
    }
    return this.f;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\bugly\crashreport\common\strategy\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */