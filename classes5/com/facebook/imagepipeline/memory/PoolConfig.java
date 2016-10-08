package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.memory.NoOpMemoryTrimmableRegistry;
import javax.annotation.concurrent.Immutable;

@Immutable
public class PoolConfig
{
  private final PoolParams mBitmapPoolParams;
  private final PoolStatsTracker mBitmapPoolStatsTracker;
  private final PoolParams mFlexByteArrayPoolParams;
  private final MemoryTrimmableRegistry mMemoryTrimmableRegistry;
  private final PoolParams mNativeMemoryChunkPoolParams;
  private final PoolStatsTracker mNativeMemoryChunkPoolStatsTracker;
  private final PoolParams mSmallByteArrayPoolParams;
  private final PoolStatsTracker mSmallByteArrayPoolStatsTracker;
  
  private PoolConfig(Builder paramBuilder)
  {
    Object localObject;
    if (paramBuilder.mBitmapPoolParams == null)
    {
      localObject = DefaultBitmapPoolParams.get();
      this.mBitmapPoolParams = ((PoolParams)localObject);
      if (paramBuilder.mBitmapPoolStatsTracker != null) {
        break label141;
      }
      localObject = NoOpPoolStatsTracker.getInstance();
      label31:
      this.mBitmapPoolStatsTracker = ((PoolStatsTracker)localObject);
      if (paramBuilder.mFlexByteArrayPoolParams != null) {
        break label149;
      }
      localObject = DefaultFlexByteArrayPoolParams.get();
      label47:
      this.mFlexByteArrayPoolParams = ((PoolParams)localObject);
      if (paramBuilder.mMemoryTrimmableRegistry != null) {
        break label157;
      }
      localObject = NoOpMemoryTrimmableRegistry.getInstance();
      label63:
      this.mMemoryTrimmableRegistry = ((MemoryTrimmableRegistry)localObject);
      if (paramBuilder.mNativeMemoryChunkPoolParams != null) {
        break label165;
      }
      localObject = DefaultNativeMemoryChunkPoolParams.get();
      label79:
      this.mNativeMemoryChunkPoolParams = ((PoolParams)localObject);
      if (paramBuilder.mNativeMemoryChunkPoolStatsTracker != null) {
        break label173;
      }
      localObject = NoOpPoolStatsTracker.getInstance();
      label95:
      this.mNativeMemoryChunkPoolStatsTracker = ((PoolStatsTracker)localObject);
      if (paramBuilder.mSmallByteArrayPoolParams != null) {
        break label181;
      }
      localObject = DefaultByteArrayPoolParams.get();
      label111:
      this.mSmallByteArrayPoolParams = ((PoolParams)localObject);
      if (paramBuilder.mSmallByteArrayPoolStatsTracker != null) {
        break label189;
      }
    }
    label141:
    label149:
    label157:
    label165:
    label173:
    label181:
    label189:
    for (paramBuilder = NoOpPoolStatsTracker.getInstance();; paramBuilder = paramBuilder.mSmallByteArrayPoolStatsTracker)
    {
      this.mSmallByteArrayPoolStatsTracker = paramBuilder;
      return;
      localObject = paramBuilder.mBitmapPoolParams;
      break;
      localObject = paramBuilder.mBitmapPoolStatsTracker;
      break label31;
      localObject = paramBuilder.mFlexByteArrayPoolParams;
      break label47;
      localObject = paramBuilder.mMemoryTrimmableRegistry;
      break label63;
      localObject = paramBuilder.mNativeMemoryChunkPoolParams;
      break label79;
      localObject = paramBuilder.mNativeMemoryChunkPoolStatsTracker;
      break label95;
      localObject = paramBuilder.mSmallByteArrayPoolParams;
      break label111;
    }
  }
  
  public static Builder newBuilder()
  {
    return new Builder(null);
  }
  
  public PoolParams getBitmapPoolParams()
  {
    return this.mBitmapPoolParams;
  }
  
  public PoolStatsTracker getBitmapPoolStatsTracker()
  {
    return this.mBitmapPoolStatsTracker;
  }
  
  public PoolParams getFlexByteArrayPoolParams()
  {
    return this.mFlexByteArrayPoolParams;
  }
  
  public MemoryTrimmableRegistry getMemoryTrimmableRegistry()
  {
    return this.mMemoryTrimmableRegistry;
  }
  
  public PoolParams getNativeMemoryChunkPoolParams()
  {
    return this.mNativeMemoryChunkPoolParams;
  }
  
  public PoolStatsTracker getNativeMemoryChunkPoolStatsTracker()
  {
    return this.mNativeMemoryChunkPoolStatsTracker;
  }
  
  public PoolParams getSmallByteArrayPoolParams()
  {
    return this.mSmallByteArrayPoolParams;
  }
  
  public PoolStatsTracker getSmallByteArrayPoolStatsTracker()
  {
    return this.mSmallByteArrayPoolStatsTracker;
  }
  
  public static class Builder
  {
    private PoolParams mBitmapPoolParams;
    private PoolStatsTracker mBitmapPoolStatsTracker;
    private PoolParams mFlexByteArrayPoolParams;
    private MemoryTrimmableRegistry mMemoryTrimmableRegistry;
    private PoolParams mNativeMemoryChunkPoolParams;
    private PoolStatsTracker mNativeMemoryChunkPoolStatsTracker;
    private PoolParams mSmallByteArrayPoolParams;
    private PoolStatsTracker mSmallByteArrayPoolStatsTracker;
    
    public PoolConfig build()
    {
      return new PoolConfig(this, null);
    }
    
    public Builder setBitmapPoolParams(PoolParams paramPoolParams)
    {
      this.mBitmapPoolParams = ((PoolParams)Preconditions.checkNotNull(paramPoolParams));
      return this;
    }
    
    public Builder setBitmapPoolStatsTracker(PoolStatsTracker paramPoolStatsTracker)
    {
      this.mBitmapPoolStatsTracker = ((PoolStatsTracker)Preconditions.checkNotNull(paramPoolStatsTracker));
      return this;
    }
    
    public Builder setFlexByteArrayPoolParams(PoolParams paramPoolParams)
    {
      this.mFlexByteArrayPoolParams = paramPoolParams;
      return this;
    }
    
    public Builder setMemoryTrimmableRegistry(MemoryTrimmableRegistry paramMemoryTrimmableRegistry)
    {
      this.mMemoryTrimmableRegistry = paramMemoryTrimmableRegistry;
      return this;
    }
    
    public Builder setNativeMemoryChunkPoolParams(PoolParams paramPoolParams)
    {
      this.mNativeMemoryChunkPoolParams = ((PoolParams)Preconditions.checkNotNull(paramPoolParams));
      return this;
    }
    
    public Builder setNativeMemoryChunkPoolStatsTracker(PoolStatsTracker paramPoolStatsTracker)
    {
      this.mNativeMemoryChunkPoolStatsTracker = ((PoolStatsTracker)Preconditions.checkNotNull(paramPoolStatsTracker));
      return this;
    }
    
    public Builder setSmallByteArrayPoolParams(PoolParams paramPoolParams)
    {
      this.mSmallByteArrayPoolParams = ((PoolParams)Preconditions.checkNotNull(paramPoolParams));
      return this;
    }
    
    public Builder setSmallByteArrayPoolStatsTracker(PoolStatsTracker paramPoolStatsTracker)
    {
      this.mSmallByteArrayPoolStatsTracker = ((PoolStatsTracker)Preconditions.checkNotNull(paramPoolStatsTracker));
      return this;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\memory\PoolConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */