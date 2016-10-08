package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;

public class DefaultNativeMemoryChunkPoolParams
{
  private static final int LARGE_BUCKET_LENGTH = 2;
  private static final int SMALL_BUCKET_LENGTH = 5;
  
  public static PoolParams get()
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    localSparseIntArray.put(1024, 5);
    localSparseIntArray.put(2048, 5);
    localSparseIntArray.put(4096, 5);
    localSparseIntArray.put(8192, 5);
    localSparseIntArray.put(16384, 5);
    localSparseIntArray.put(32768, 5);
    localSparseIntArray.put(65536, 5);
    localSparseIntArray.put(131072, 5);
    localSparseIntArray.put(262144, 2);
    localSparseIntArray.put(524288, 2);
    localSparseIntArray.put(1048576, 2);
    return new PoolParams(getMaxSizeSoftCap(), getMaxSizeHardCap(), localSparseIntArray);
  }
  
  private static int getMaxSizeHardCap()
  {
    int i = (int)Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
    if (i < 16777216) {
      return i / 2;
    }
    return i / 4 * 3;
  }
  
  private static int getMaxSizeSoftCap()
  {
    int i = (int)Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
    if (i < 16777216) {
      return 3145728;
    }
    if (i < 33554432) {
      return 6291456;
    }
    return 12582912;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\memory\DefaultNativeMemoryChunkPoolParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */