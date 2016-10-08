package com.facebook.react.common;

public class LongArray
{
  private static final double INNER_ARRAY_GROWTH_FACTOR = 1.8D;
  private long[] mArray;
  private int mLength;
  
  private LongArray(int paramInt)
  {
    this.mArray = new long[paramInt];
    this.mLength = 0;
  }
  
  public static LongArray createWithInitialCapacity(int paramInt)
  {
    return new LongArray(paramInt);
  }
  
  private void growArrayIfNeeded()
  {
    if (this.mLength == this.mArray.length)
    {
      long[] arrayOfLong = new long[Math.max(this.mLength + 1, (int)(this.mLength * 1.8D))];
      System.arraycopy(this.mArray, 0, arrayOfLong, 0, this.mLength);
      this.mArray = arrayOfLong;
    }
  }
  
  public void add(long paramLong)
  {
    growArrayIfNeeded();
    long[] arrayOfLong = this.mArray;
    int i = this.mLength;
    this.mLength = (i + 1);
    arrayOfLong[i] = paramLong;
  }
  
  public void dropTail(int paramInt)
  {
    if (paramInt > this.mLength) {
      throw new IndexOutOfBoundsException("Trying to drop " + paramInt + " items from array of length " + this.mLength);
    }
    this.mLength -= paramInt;
  }
  
  public long get(int paramInt)
  {
    if (paramInt >= this.mLength) {
      throw new IndexOutOfBoundsException("" + paramInt + " >= " + this.mLength);
    }
    return this.mArray[paramInt];
  }
  
  public boolean isEmpty()
  {
    return this.mLength == 0;
  }
  
  public void set(int paramInt, long paramLong)
  {
    if (paramInt >= this.mLength) {
      throw new IndexOutOfBoundsException("" + paramInt + " >= " + this.mLength);
    }
    this.mArray[paramInt] = paramLong;
  }
  
  public int size()
  {
    return this.mLength;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\common\LongArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */