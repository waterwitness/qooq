package com.facebook.react.uimanager;

import java.util.Comparator;

class ViewAtIndex
{
  public static Comparator<ViewAtIndex> COMPARATOR = new Comparator()
  {
    public int compare(ViewAtIndex paramAnonymousViewAtIndex1, ViewAtIndex paramAnonymousViewAtIndex2)
    {
      return paramAnonymousViewAtIndex1.mIndex - paramAnonymousViewAtIndex2.mIndex;
    }
  };
  public final int mIndex;
  public final int mTag;
  
  public ViewAtIndex(int paramInt1, int paramInt2)
  {
    this.mTag = paramInt1;
    this.mIndex = paramInt2;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\uimanager\ViewAtIndex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */