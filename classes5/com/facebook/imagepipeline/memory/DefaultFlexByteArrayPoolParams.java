package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;

public class DefaultFlexByteArrayPoolParams
{
  public static final int DEFAULT_MAX_BYTE_ARRAY_SIZE = 4194304;
  public static final int DEFAULT_MAX_NUM_THREADS = Runtime.getRuntime().availableProcessors();
  private static final int DEFAULT_MIN_BYTE_ARRAY_SIZE = 131072;
  
  public static SparseIntArray generateBuckets(int paramInt1, int paramInt2, int paramInt3)
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    for (;;)
    {
      if (paramInt1 > paramInt2) {
        return localSparseIntArray;
      }
      localSparseIntArray.put(paramInt1, paramInt3);
      paramInt1 *= 2;
    }
  }
  
  public static PoolParams get()
  {
    return new PoolParams(4194304, DEFAULT_MAX_NUM_THREADS * 4194304, generateBuckets(131072, 4194304, DEFAULT_MAX_NUM_THREADS), 131072, 4194304, DEFAULT_MAX_NUM_THREADS);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\memory\DefaultFlexByteArrayPoolParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */