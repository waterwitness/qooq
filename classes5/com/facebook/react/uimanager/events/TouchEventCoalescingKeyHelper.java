package com.facebook.react.uimanager.events;

import android.util.SparseIntArray;

public class TouchEventCoalescingKeyHelper
{
  private static final SparseIntArray sDownTimeToCoalescingKey = new SparseIntArray();
  
  public static void addCoalescingKey(long paramLong)
  {
    sDownTimeToCoalescingKey.put((int)paramLong, 0);
  }
  
  public static short getCoalescingKey(long paramLong)
  {
    int i = sDownTimeToCoalescingKey.get((int)paramLong, -1);
    if (i == -1) {
      throw new RuntimeException("Tried to get non-existent cookie");
    }
    return (short)(0xFFFF & i);
  }
  
  public static void incrementCoalescingKey(long paramLong)
  {
    int i = sDownTimeToCoalescingKey.get((int)paramLong, -1);
    if (i == -1) {
      throw new RuntimeException("Tried to increment non-existent cookie");
    }
    sDownTimeToCoalescingKey.put((int)paramLong, i + 1);
  }
  
  public static void removeCoalescingKey(long paramLong)
  {
    sDownTimeToCoalescingKey.delete((int)paramLong);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\uimanager\events\TouchEventCoalescingKeyHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */