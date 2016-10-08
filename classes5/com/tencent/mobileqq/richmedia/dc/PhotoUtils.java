package com.tencent.mobileqq.richmedia.dc;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class PhotoUtils
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  
  public PhotoUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a(long paramLong1, long paramLong2)
  {
    if ((paramLong1 <= 0L) || (paramLong2 <= 0L)) {
      return -1;
    }
    long l = Math.max(paramLong1, paramLong2);
    if ((l > 500L) && (l <= 960L)) {
      return 3;
    }
    if ((l > 200L) && (l <= 500L)) {
      return 2;
    }
    if (l <= 200L) {
      return 1;
    }
    if (a(paramLong1, paramLong2)) {
      return 0;
    }
    return 4;
  }
  
  public static boolean a(long paramLong1, long paramLong2)
  {
    return (paramLong1 >= 3L * paramLong2) || (paramLong2 >= 3L * paramLong1);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\richmedia\dc\PhotoUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */