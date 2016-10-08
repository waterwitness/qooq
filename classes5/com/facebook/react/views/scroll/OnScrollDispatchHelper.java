package com.facebook.react.views.scroll;

import android.os.SystemClock;

public class OnScrollDispatchHelper
{
  private static final int MIN_EVENT_SEPARATION_MS = 10;
  private long mLastScrollEventTimeMs = -11L;
  private int mPrevX = Integer.MIN_VALUE;
  private int mPrevY = Integer.MIN_VALUE;
  
  public boolean onScrollChanged(int paramInt1, int paramInt2)
  {
    long l = SystemClock.uptimeMillis();
    if ((l - this.mLastScrollEventTimeMs > 10L) || (this.mPrevX != paramInt1) || (this.mPrevY != paramInt2)) {}
    for (boolean bool = true;; bool = false)
    {
      this.mLastScrollEventTimeMs = l;
      this.mPrevX = paramInt1;
      this.mPrevY = paramInt2;
      return bool;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\views\scroll\OnScrollDispatchHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */