package com.tencent.filter;

import android.graphics.Rect;

public class MRect
{
  int h;
  int w;
  int x;
  int y;
  
  public MRect() {}
  
  public MRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.x = paramInt1;
    this.y = paramInt2;
    this.w = paramInt3;
    this.h = paramInt4;
  }
  
  public static MRect toMRect(Rect paramRect)
  {
    return new MRect(paramRect.left, paramRect.top, paramRect.width(), paramRect.height());
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\filter\MRect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */