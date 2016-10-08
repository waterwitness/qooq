package com.facebook.stetho.common.android;

import android.view.View;
import android.view.ViewGroup;

public final class ViewGroupUtil
{
  public static int findChildIndex(ViewGroup paramViewGroup, View paramView)
  {
    int k = paramViewGroup.getChildCount();
    int i = 0;
    for (;;)
    {
      int j;
      if (i >= k) {
        j = -1;
      }
      do
      {
        return j;
        j = i;
      } while (paramViewGroup.getChildAt(i) == paramView);
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\common\android\ViewGroupUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */