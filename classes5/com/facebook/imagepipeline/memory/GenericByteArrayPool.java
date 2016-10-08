package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class GenericByteArrayPool
  extends BasePool<byte[]>
  implements ByteArrayPool
{
  private final int[] mBucketSizes;
  
  public GenericByteArrayPool(MemoryTrimmableRegistry paramMemoryTrimmableRegistry, PoolParams paramPoolParams, PoolStatsTracker paramPoolStatsTracker)
  {
    super(paramMemoryTrimmableRegistry, paramPoolParams, paramPoolStatsTracker);
    paramMemoryTrimmableRegistry = paramPoolParams.bucketSizes;
    this.mBucketSizes = new int[paramMemoryTrimmableRegistry.size()];
    int i = 0;
    for (;;)
    {
      if (i >= paramMemoryTrimmableRegistry.size())
      {
        initialize();
        return;
      }
      this.mBucketSizes[i] = paramMemoryTrimmableRegistry.keyAt(i);
      i += 1;
    }
  }
  
  protected byte[] alloc(int paramInt)
  {
    return new byte[paramInt];
  }
  
  protected void free(byte[] paramArrayOfByte)
  {
    Preconditions.checkNotNull(paramArrayOfByte);
  }
  
  protected int getBucketedSize(int paramInt)
  {
    if (paramInt <= 0) {
      throw new BasePool.InvalidSizeException(Integer.valueOf(paramInt));
    }
    int[] arrayOfInt = this.mBucketSizes;
    int m = arrayOfInt.length;
    int i = 0;
    for (;;)
    {
      int j;
      if (i >= m) {
        j = paramInt;
      }
      int k;
      do
      {
        return j;
        k = arrayOfInt[i];
        j = k;
      } while (k >= paramInt);
      i += 1;
    }
  }
  
  protected int getBucketedSizeForValue(byte[] paramArrayOfByte)
  {
    Preconditions.checkNotNull(paramArrayOfByte);
    return paramArrayOfByte.length;
  }
  
  public int getMinBufferSize()
  {
    return this.mBucketSizes[0];
  }
  
  protected int getSizeInBytes(int paramInt)
  {
    return paramInt;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\memory\GenericByteArrayPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */