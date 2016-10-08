package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;

public class DefaultByteArrayPoolParams
{
  private static final int DEFAULT_BUCKET_SIZE = 5;
  private static final int DEFAULT_IO_BUFFER_SIZE = 16384;
  private static final int MAX_SIZE_HARD_CAP = 1048576;
  private static final int MAX_SIZE_SOFT_CAP = 81920;
  
  public static PoolParams get()
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    localSparseIntArray.put(16384, 5);
    return new PoolParams(81920, 1048576, localSparseIntArray);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\memory\DefaultByteArrayPoolParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */