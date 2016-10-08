package com.tencent.bitapp.utils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractBitAppCache<T>
{
  private static final int DEFAULT_MAP_CAPACITY = 10;
  Map<String, T> mMap = null;
  
  public AbstractBitAppCache()
  {
    this(10);
  }
  
  public AbstractBitAppCache(int paramInt)
  {
    this.mMap = new ConcurrentHashMap(paramInt);
  }
  
  public void clear()
  {
    this.mMap.clear();
  }
  
  protected T create(String paramString, Object... paramVarArgs)
  {
    return null;
  }
  
  public T get(String paramString, int paramInt)
  {
    return (T)get(paramString, new Object[] { Integer.valueOf(paramInt), new Object[0] });
  }
  
  public T get(String paramString, Object... paramVarArgs)
  {
    Object localObject2 = this.mMap.get(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      paramVarArgs = create(paramString, paramVarArgs);
      localObject1 = paramVarArgs;
      if (paramVarArgs != null)
      {
        this.mMap.put(paramString, paramVarArgs);
        localObject1 = paramVarArgs;
      }
    }
    return (T)localObject1;
  }
  
  public boolean isExistInCache(String paramString)
  {
    return this.mMap.get(paramString) != null;
  }
  
  public void put(String paramString, T paramT)
  {
    this.mMap.put(paramString, paramT);
  }
  
  public void remove(String paramString)
  {
    this.mMap.remove(paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\utils\AbstractBitAppCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */