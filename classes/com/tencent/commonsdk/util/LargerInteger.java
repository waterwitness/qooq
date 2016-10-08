package com.tencent.commonsdk.util;

import android.annotation.SuppressLint;

@SuppressLint({"UseValueOf"})
public class LargerInteger
{
  private static final Integer[] LARGER_VALUES = new Integer['ྀ'];
  private static final int MAX = 4096;
  
  static
  {
    int i = 128;
    while (i < 4096)
    {
      LARGER_VALUES[(i - 128)] = new Integer(i);
      i += 1;
    }
  }
  
  public static Integer valueOf(int paramInt)
  {
    if ((paramInt >= 128) && (paramInt < 4096)) {
      return LARGER_VALUES[(paramInt - 128)];
    }
    return Integer.valueOf(paramInt);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\commonsdk\util\LargerInteger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */