package fb.support.v4.util;

class ContainerHelpers
{
  static final int[] EMPTY_INTS = new int[0];
  static final long[] EMPTY_LONGS = new long[0];
  static final Object[] EMPTY_OBJECTS = new Object[0];
  
  static int binarySearch(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int i = 0;
    int j = paramInt1 - 1;
    paramInt1 = i;
    i = j;
    for (;;)
    {
      if (paramInt1 > i) {
        i = paramInt1 ^ 0xFFFFFFFF;
      }
      int k;
      do
      {
        return i;
        j = paramInt1 + i >>> 1;
        k = paramArrayOfInt[j];
        if (k < paramInt2)
        {
          paramInt1 = j + 1;
          break;
        }
        i = j;
      } while (k <= paramInt2);
      i = j - 1;
    }
  }
  
  static int binarySearch(long[] paramArrayOfLong, int paramInt, long paramLong)
  {
    int i = 0;
    int j = paramInt - 1;
    paramInt = i;
    i = j;
    for (;;)
    {
      if (paramInt > i) {
        i = paramInt ^ 0xFFFFFFFF;
      }
      long l;
      do
      {
        return i;
        j = paramInt + i >>> 1;
        l = paramArrayOfLong[j];
        if (l < paramLong)
        {
          paramInt = j + 1;
          break;
        }
        i = j;
      } while (l <= paramLong);
      i = j - 1;
    }
  }
  
  public static boolean equal(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  public static int idealByteArraySize(int paramInt)
  {
    int i = 4;
    for (;;)
    {
      if (i >= 32) {
        return paramInt;
      }
      if (paramInt <= (1 << i) - 12) {
        return (1 << i) - 12;
      }
      i += 1;
    }
  }
  
  public static int idealIntArraySize(int paramInt)
  {
    return idealByteArraySize(paramInt * 4) / 4;
  }
  
  public static int idealLongArraySize(int paramInt)
  {
    return idealByteArraySize(paramInt * 8) / 8;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\fb\support\v4\util\ContainerHelpers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */