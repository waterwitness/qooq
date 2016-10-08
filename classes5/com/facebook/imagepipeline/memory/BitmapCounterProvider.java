package com.facebook.imagepipeline.memory;

public class BitmapCounterProvider
{
  private static final long KB = 1024L;
  public static final int MAX_BITMAP_COUNT = 384;
  public static final int MAX_BITMAP_TOTAL_SIZE = ;
  private static final long MB = 1048576L;
  private static BitmapCounter sBitmapCounter;
  
  public static BitmapCounter get()
  {
    if (sBitmapCounter == null) {
      sBitmapCounter = new BitmapCounter(384, MAX_BITMAP_TOTAL_SIZE);
    }
    return sBitmapCounter;
  }
  
  private static int getMaxSizeHardCap()
  {
    int i = (int)Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
    if (i > 16777216L) {
      return i / 4 * 3;
    }
    return i / 2;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\memory\BitmapCounterProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */