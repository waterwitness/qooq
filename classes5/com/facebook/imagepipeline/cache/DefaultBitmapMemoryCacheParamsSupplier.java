package com.facebook.imagepipeline.cache;

import android.app.ActivityManager;
import android.os.Build.VERSION;
import com.facebook.common.internal.Supplier;

public class DefaultBitmapMemoryCacheParamsSupplier
  implements Supplier<MemoryCacheParams>
{
  private static final int MAX_CACHE_ENTRIES = 256;
  private static final int MAX_CACHE_ENTRY_SIZE = Integer.MAX_VALUE;
  private static final int MAX_EVICTION_QUEUE_ENTRIES = Integer.MAX_VALUE;
  private static final int MAX_EVICTION_QUEUE_SIZE = Integer.MAX_VALUE;
  private final ActivityManager mActivityManager;
  
  public DefaultBitmapMemoryCacheParamsSupplier(ActivityManager paramActivityManager)
  {
    this.mActivityManager = paramActivityManager;
  }
  
  private int getMaxCacheSize()
  {
    int i = Math.min(this.mActivityManager.getMemoryClass() * 1048576, Integer.MAX_VALUE);
    if (i < 33554432) {
      return 4194304;
    }
    if (i < 67108864) {
      return 6291456;
    }
    if (Build.VERSION.SDK_INT < 11) {
      return 8388608;
    }
    return i / 4;
  }
  
  public MemoryCacheParams get()
  {
    return new MemoryCacheParams(getMaxCacheSize(), 256, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\cache\DefaultBitmapMemoryCacheParamsSupplier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */