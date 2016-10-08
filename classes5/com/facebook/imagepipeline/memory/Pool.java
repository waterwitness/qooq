package com.facebook.imagepipeline.memory;

import com.facebook.common.memory.MemoryTrimmable;
import com.facebook.common.references.ResourceReleaser;

public abstract interface Pool<V>
  extends ResourceReleaser<V>, MemoryTrimmable
{
  public abstract V get(int paramInt);
  
  public abstract void release(V paramV);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\memory\Pool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */