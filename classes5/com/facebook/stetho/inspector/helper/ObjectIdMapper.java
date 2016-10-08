package com.facebook.stetho.inspector.helper;

import android.util.SparseArray;
import java.util.IdentityHashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public class ObjectIdMapper
{
  @GuardedBy("mSync")
  private SparseArray<Object> mIdToObjectMap = new SparseArray();
  @GuardedBy("mSync")
  private int mNextId = 1;
  @GuardedBy("mSync")
  private final Map<Object, Integer> mObjectToIdMap = new IdentityHashMap();
  protected final Object mSync = new Object();
  
  public void clear()
  {
    for (;;)
    {
      int i;
      synchronized (this.mSync)
      {
        SparseArray localSparseArray = this.mIdToObjectMap;
        this.mObjectToIdMap.clear();
        this.mIdToObjectMap = new SparseArray();
        int j = localSparseArray.size();
        i = 0;
        if (i >= j) {
          return;
        }
      }
      int k = ((SparseArray)localObject2).keyAt(i);
      onUnmapped(((SparseArray)localObject2).valueAt(i), k);
      i += 1;
    }
  }
  
  public boolean containsId(int paramInt)
  {
    for (;;)
    {
      synchronized (this.mSync)
      {
        if (this.mIdToObjectMap.get(paramInt) != null)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public boolean containsObject(Object paramObject)
  {
    synchronized (this.mSync)
    {
      boolean bool = this.mObjectToIdMap.containsKey(paramObject);
      return bool;
    }
  }
  
  @Nullable
  public Integer getIdForObject(Object paramObject)
  {
    synchronized (this.mSync)
    {
      paramObject = (Integer)this.mObjectToIdMap.get(paramObject);
      return (Integer)paramObject;
    }
  }
  
  @Nullable
  public Object getObjectForId(int paramInt)
  {
    synchronized (this.mSync)
    {
      Object localObject2 = this.mIdToObjectMap.get(paramInt);
      return localObject2;
    }
  }
  
  protected void onMapped(Object paramObject, int paramInt) {}
  
  protected void onUnmapped(Object paramObject, int paramInt) {}
  
  public int putObject(Object paramObject)
  {
    synchronized (this.mSync)
    {
      Integer localInteger = (Integer)this.mObjectToIdMap.get(paramObject);
      if (localInteger != null)
      {
        i = localInteger.intValue();
        return i;
      }
      int i = this.mNextId;
      this.mNextId = (i + 1);
      localInteger = Integer.valueOf(i);
      this.mObjectToIdMap.put(paramObject, localInteger);
      this.mIdToObjectMap.put(localInteger.intValue(), paramObject);
      onMapped(paramObject, localInteger.intValue());
      return localInteger.intValue();
    }
  }
  
  @Nullable
  public Integer removeObject(Object paramObject)
  {
    synchronized (this.mSync)
    {
      Integer localInteger = (Integer)this.mObjectToIdMap.remove(paramObject);
      if (localInteger == null) {
        return null;
      }
      this.mIdToObjectMap.remove(localInteger.intValue());
      onUnmapped(paramObject, localInteger.intValue());
      return localInteger;
    }
  }
  
  @Nullable
  public Object removeObjectById(int paramInt)
  {
    synchronized (this.mSync)
    {
      Object localObject2 = this.mIdToObjectMap.get(paramInt);
      if (localObject2 == null) {
        return null;
      }
      this.mIdToObjectMap.remove(paramInt);
      this.mObjectToIdMap.remove(localObject2);
      onUnmapped(localObject2, paramInt);
      return localObject2;
    }
  }
  
  public int size()
  {
    synchronized (this.mSync)
    {
      int i = this.mObjectToIdMap.size();
      return i;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\inspector\helper\ObjectIdMapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */