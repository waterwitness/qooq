package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import java.lang.ref.WeakReference;
import java.util.Map;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class FlexByteArrayPool
{
  @VisibleForTesting
  final SoftRefByteArrayPool mDelegatePool;
  private final ResourceReleaser<byte[]> mResourceReleaser;
  
  public FlexByteArrayPool(MemoryTrimmableRegistry paramMemoryTrimmableRegistry, PoolParams paramPoolParams)
  {
    if (paramPoolParams.maxNumThreads > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      this.mDelegatePool = new SoftRefByteArrayPool(paramMemoryTrimmableRegistry, paramPoolParams, NoOpPoolStatsTracker.getInstance());
      this.mResourceReleaser = new InnerResourceReleaser(this);
      return;
    }
  }
  
  public CloseableReference<byte[]> get(int paramInt)
  {
    return CloseableReference.of((byte[])this.mDelegatePool.get(paramInt), this.mResourceReleaser);
  }
  
  public int getMinBufferSize()
  {
    return this.mDelegatePool.getMinBufferSize();
  }
  
  public Map<String, Integer> getStats()
  {
    return this.mDelegatePool.getStats();
  }
  
  public void release(byte[] paramArrayOfByte)
  {
    this.mDelegatePool.release(paramArrayOfByte);
  }
  
  private static class InnerResourceReleaser
    implements ResourceReleaser<byte[]>
  {
    private WeakReference<FlexByteArrayPool> mPoolRef;
    
    public InnerResourceReleaser(FlexByteArrayPool paramFlexByteArrayPool)
    {
      this.mPoolRef = new WeakReference(paramFlexByteArrayPool);
    }
    
    public void release(byte[] paramArrayOfByte)
    {
      FlexByteArrayPool localFlexByteArrayPool = (FlexByteArrayPool)this.mPoolRef.get();
      if (localFlexByteArrayPool != null) {
        localFlexByteArrayPool.release(paramArrayOfByte);
      }
    }
  }
  
  @VisibleForTesting
  static class SoftRefByteArrayPool
    extends GenericByteArrayPool
  {
    public SoftRefByteArrayPool(MemoryTrimmableRegistry paramMemoryTrimmableRegistry, PoolParams paramPoolParams, PoolStatsTracker paramPoolStatsTracker)
    {
      super(paramPoolParams, paramPoolStatsTracker);
    }
    
    Bucket<byte[]> newBucket(int paramInt)
    {
      return new OOMSoftReferenceBucket(getSizeInBytes(paramInt), this.mPoolParams.maxNumThreads, 0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\memory\FlexByteArrayPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */