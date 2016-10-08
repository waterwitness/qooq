package com.tencent.mm.sdk.b;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public final class d<K, V>
{
  private final LinkedHashMap<K, V> l;
  private int m;
  private int n;
  private int o;
  private int p;
  private int q;
  private int size;
  
  private void trimToSize(int paramInt)
  {
    try
    {
      if ((this.size < 0) || ((this.l.isEmpty()) && (this.size != 0))) {
        throw new IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
      }
    }
    finally
    {
      throw ((Throwable)localObject1);
      if ((this.size <= paramInt) || (this.l.isEmpty())) {
        return;
      }
      Map.Entry localEntry = (Map.Entry)this.l.entrySet().iterator().next();
      Object localObject2 = localEntry.getKey();
      localEntry.getValue();
      this.l.remove(localObject2);
      this.size -= 1;
      this.o += 1;
    }
  }
  
  public final boolean a(K paramK)
  {
    try
    {
      boolean bool = this.l.containsKey(paramK);
      return bool;
    }
    finally
    {
      paramK = finally;
      throw paramK;
    }
  }
  
  public final V get(K paramK)
  {
    if (paramK == null) {
      throw new NullPointerException("key == null");
    }
    try
    {
      paramK = this.l.get(paramK);
      if (paramK != null)
      {
        this.p += 1;
        return paramK;
      }
      this.q += 1;
      return null;
    }
    finally {}
  }
  
  public final V put(K paramK, V paramV)
  {
    if ((paramK == null) || (paramV == null)) {
      throw new NullPointerException("key == null || value == null");
    }
    try
    {
      this.n += 1;
      this.size += 1;
      paramK = this.l.put(paramK, paramV);
      if (paramK != null) {
        this.size -= 1;
      }
      trimToSize(this.m);
      return paramK;
    }
    finally {}
  }
  
  public final String toString()
  {
    int i = 0;
    try
    {
      int j = this.p + this.q;
      if (j != 0) {
        i = this.p * 100 / j;
      }
      String str = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[] { Integer.valueOf(this.m), Integer.valueOf(this.p), Integer.valueOf(this.q), Integer.valueOf(i) });
      return str;
    }
    finally {}
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mm\sdk\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */