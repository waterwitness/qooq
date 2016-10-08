package com.tribe.async.objectpool;

import com.tribe.async.utils.MonotonicClock;
import java.util.HashMap;

public class ObjectPoolManager
{
  private final MonotonicClock mClock;
  private final HashMap<Class, ObjectPool> mObjectPools = new HashMap();
  
  public ObjectPoolManager(MonotonicClock paramMonotonicClock)
  {
    this.mClock = paramMonotonicClock;
  }
  
  <T> void addPool(Class<T> paramClass, ObjectPool<T> paramObjectPool)
  {
    this.mObjectPools.put(paramClass, paramObjectPool);
  }
  
  public <T> T allocate(Class<T> paramClass)
  {
    paramClass = getPool(paramClass);
    if (paramClass != null) {
      return (T)paramClass.allocate();
    }
    return null;
  }
  
  public <T> ObjectPoolBuilder<T> createPoolBuilder(Class<T> paramClass)
  {
    return new ObjectPoolBuilder(this, paramClass, this.mClock);
  }
  
  public <T> ObjectPool<T> getPool(Class<T> paramClass)
  {
    return (ObjectPool)this.mObjectPools.get(paramClass);
  }
  
  public <T> void release(Class<T> paramClass, T paramT)
  {
    paramClass = getPool(paramClass);
    if (paramClass != null) {
      paramClass.release(paramT);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tribe\async\objectpool\ObjectPoolManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */