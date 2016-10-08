package com.tencent.image;

import android.graphics.Bitmap;

public class RoundRectBitmap
{
  public final Bitmap mBitmap;
  public final int mBoardColor;
  public final float mBorderWidth;
  public final float mCornerRadius;
  public int mDisplayHeight;
  public int mDisplayWidth;
  
  public RoundRectBitmap(Bitmap paramBitmap, float paramFloat)
  {
    this(paramBitmap, paramFloat, -16777216, 0.0F);
  }
  
  public RoundRectBitmap(Bitmap paramBitmap, float paramFloat1, int paramInt, float paramFloat2)
  {
    this.mBitmap = paramBitmap;
    this.mCornerRadius = paramFloat1;
    this.mBoardColor = paramInt;
    this.mBorderWidth = paramFloat2;
  }
  
  public int getByteSize()
  {
    return Utils.getBitmapSize(this.mBitmap);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\image\RoundRectBitmap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */