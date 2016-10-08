package com.tencent.component.network.module.common.a;

import com.tencent.component.network.NetworkManager;
import com.tencent.component.network.downloader.common.a;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class e
{
  private static e b = null;
  private a<String, b> a = new a();
  
  public static e a()
  {
    try
    {
      if (b == null) {
        b = new e();
      }
      e locale = b;
      return locale;
    }
    finally {}
  }
  
  public final void a(String paramString)
  {
    if (a.a()) {
      a.a("dnstest", "$$$addCache[" + paramString + "]");
    }
    b localb = new b((byte)0);
    if (NetworkManager.isMobile()) {
      NetworkManager.getApnValue();
    }
    for (;;)
    {
      if (this.a.containsKey(paramString)) {
        this.a.remove(paramString);
      }
      this.a.put(paramString, localb);
      return;
      NetworkManager.getBSSID();
    }
  }
  
  final class a<K, V>
    extends LinkedHashMap<K, V>
  {
    private int a = 5;
    private Object b = new Object();
    
    public a()
    {
      super(0.75F, true);
    }
    
    public final void clear()
    {
      synchronized (this.b)
      {
        super.clear();
        return;
      }
    }
    
    public final boolean containsKey(Object paramObject)
    {
      synchronized (this.b)
      {
        boolean bool = super.containsKey(paramObject);
        return bool;
      }
    }
    
    public final V get(Object paramObject)
    {
      synchronized (this.b)
      {
        paramObject = super.get(paramObject);
        return (V)paramObject;
      }
    }
    
    public final V put(K paramK, V paramV)
    {
      synchronized (this.b)
      {
        paramK = super.put(paramK, paramV);
        return paramK;
      }
    }
    
    public final void putAll(Map<? extends K, ? extends V> paramMap)
    {
      synchronized (this.b)
      {
        super.putAll(paramMap);
        return;
      }
    }
    
    public final V remove(Object paramObject)
    {
      synchronized (this.b)
      {
        paramObject = super.remove(paramObject);
        return (V)paramObject;
      }
    }
    
    protected final boolean removeEldestEntry(Map.Entry<K, V> paramEntry)
    {
      return size() > this.a;
    }
    
    public final int size()
    {
      synchronized (this.b)
      {
        int i = super.size();
        return i;
      }
    }
  }
  
  final class b {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\component\network\module\common\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */