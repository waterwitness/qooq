package com.facebook.stetho.inspector.elements;

import com.facebook.stetho.common.Util;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

public final class DescriptorMap
{
  private Descriptor.Host mHost;
  private boolean mIsInitializing;
  private final Map<Class<?>, Descriptor> mMap = new IdentityHashMap();
  
  @Nullable
  private Descriptor getImpl(Class<?> paramClass)
  {
    for (;;)
    {
      Object localObject;
      if (paramClass == null) {
        localObject = null;
      }
      Descriptor localDescriptor;
      do
      {
        return (Descriptor)localObject;
        localDescriptor = (Descriptor)this.mMap.get(paramClass);
        localObject = localDescriptor;
      } while (localDescriptor != null);
      paramClass = paramClass.getSuperclass();
    }
  }
  
  public DescriptorMap beginInit()
  {
    Util.throwIf(this.mIsInitializing);
    this.mIsInitializing = true;
    return this;
  }
  
  public DescriptorMap endInit()
  {
    Util.throwIfNot(this.mIsInitializing);
    Util.throwIfNull(this.mHost);
    this.mIsInitializing = false;
    Iterator localIterator = this.mMap.keySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return this;
      }
      Class localClass = (Class)localIterator.next();
      Descriptor localDescriptor = (Descriptor)this.mMap.get(localClass);
      if ((localDescriptor instanceof ChainedDescriptor)) {
        ((ChainedDescriptor)localDescriptor).setSuper(getImpl(localClass.getSuperclass()));
      }
      localDescriptor.initialize(this.mHost);
    }
  }
  
  @Nullable
  public Descriptor get(Class<?> paramClass)
  {
    Util.throwIfNull(paramClass);
    Util.throwIf(this.mIsInitializing);
    return getImpl(paramClass);
  }
  
  public DescriptorMap register(Class<?> paramClass, Descriptor paramDescriptor)
  {
    Util.throwIfNull(paramClass);
    Util.throwIfNull(paramDescriptor);
    Util.throwIf(paramDescriptor.isInitialized());
    Util.throwIfNot(this.mIsInitializing);
    if (this.mMap.containsKey(paramClass)) {
      throw new UnsupportedOperationException();
    }
    if (this.mMap.containsValue(paramDescriptor)) {
      throw new UnsupportedOperationException();
    }
    this.mMap.put(paramClass, paramDescriptor);
    return this;
  }
  
  public DescriptorMap setHost(Descriptor.Host paramHost)
  {
    Util.throwIfNull(paramHost);
    Util.throwIfNot(this.mIsInitializing);
    Util.throwIfNotNull(this.mHost);
    this.mHost = paramHost;
    return this;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\inspector\elements\DescriptorMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */