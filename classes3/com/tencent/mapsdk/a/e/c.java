package com.tencent.mapsdk.a.e;

import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class c
{
  private static final int a = Runtime.getRuntime().availableProcessors();
  private com.tencent.mapsdk.a.d.e b;
  private Map<String, List<b>> c = new ConcurrentHashMap();
  private Map<String, List<b>> d = new ConcurrentHashMap();
  private final BlockingQueue<Runnable> e = new LinkedBlockingQueue();
  private final BlockingQueue<Runnable> f = new LinkedBlockingQueue();
  private ThreadPoolExecutor g;
  private ThreadPoolExecutor h;
  
  public c(com.tencent.mapsdk.a.d.e parame)
  {
    this.b = parame;
    int i = a;
    i = a;
    if (a < 4) {}
    for (i = 3;; i = 4)
    {
      this.g = new ThreadPoolExecutor(i, j, 30L, TimeUnit.SECONDS, this.e);
      this.h = new ThreadPoolExecutor(1, 2, 30L, TimeUnit.SECONDS, this.f);
      return;
      j = 4;
    }
  }
  
  public final void a()
  {
    if (this.f != null) {
      this.f.clear();
    }
    if (this.h != null) {
      this.h.shutdownNow();
    }
    if (this.e != null) {
      this.e.clear();
    }
    if (this.g != null) {
      this.g.shutdownNow();
    }
  }
  
  public final void a(e arg1)
  {
    if (??? != null)
    {
      Object localObject2 = ???.b.toString();
      Bitmap localBitmap = ???.a;
      synchronized (this.c)
      {
        Object localObject3 = (List)this.d.remove(localObject2);
        this.c.remove(localObject2);
        if ((localObject3 != null) && (localBitmap != null) && (!localBitmap.isRecycled()))
        {
          localObject2 = ((List)localObject3).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (b)((Iterator)localObject2).next();
            if (!((b)localObject3).g) {
              ((b)localObject3).f = localBitmap.copy(localBitmap.getConfig(), false);
            }
          }
        }
      }
    }
    this.b.c().postInvalidate();
  }
  
  public final void a(final ArrayList<b> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    for (;;)
    {
      return;
      this.f.clear();
      paramArrayList = new Runnable()
      {
        public final void run()
        {
          c.a(c.this).clear();
          b localb;
          String str;
          List localList;
          Object localObject3;
          synchronized (c.b(c.this))
          {
            c.b(c.this).clear();
            Iterator localIterator = paramArrayList.iterator();
            for (;;)
            {
              if (localIterator.hasNext())
              {
                localb = (b)localIterator.next();
                if (!localb.g)
                {
                  ??? = a.a().a(localb);
                  if (??? != null) {
                    localb.f = ((Bitmap)???);
                  }
                }
              }
            }
          }
        }
      };
      try
      {
        if (!this.h.isShutdown())
        {
          this.h.execute(paramArrayList);
          return;
        }
      }
      catch (Exception paramArrayList)
      {
        new StringBuilder("Local runnable get error:").append(paramArrayList.getMessage());
      }
    }
  }
  
  public final void b(e arg1)
  {
    if (??? == null) {
      return;
    }
    String str = ???.b.toString();
    synchronized (this.c)
    {
      List localList = (List)this.c.remove(str);
      this.d.put(str, localList);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mapsdk\a\e\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */