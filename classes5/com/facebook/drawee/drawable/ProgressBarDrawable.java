package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public class ProgressBarDrawable
  extends Drawable
{
  private int mBackgroundColor = Integer.MIN_VALUE;
  private int mBarWidth = 20;
  private int mColor = -2147450625;
  private boolean mHideWhenZero = false;
  private int mLevel = 0;
  private int mPadding = 10;
  private final Paint mPaint = new Paint(1);
  
  private void drawBar(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    Rect localRect = getBounds();
    paramInt1 = (localRect.width() - this.mPadding * 2) * paramInt1 / 10000;
    int i = localRect.left + this.mPadding;
    int j = localRect.bottom - this.mPadding - this.mBarWidth;
    this.mPaint.setColor(paramInt2);
    paramCanvas.drawRect(i, j, i + paramInt1, this.mBarWidth + j, this.mPaint);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if ((this.mHideWhenZero) && (this.mLevel == 0)) {
      return;
    }
    drawBar(paramCanvas, 10000, this.mBackgroundColor);
    drawBar(paramCanvas, this.mLevel, this.mColor);
  }
  
  public int getBackgroundColor()
  {
    return this.mBackgroundColor;
  }
  
  public int getBarWidth()
  {
    return this.mBarWidth;
  }
  
  public int getColor()
  {
    return this.mColor;
  }
  
  public boolean getHideWhenZero()
  {
    return this.mHideWhenZero;
  }
  
  public int getOpacity()
  {
    return DrawableUtils.getOpacityFromColor(this.mPaint.getColor());
  }
  
  public boolean getPadding(Rect paramRect)
  {
    paramRect.set(this.mPadding, this.mPadding, this.mPadding, this.mPadding);
    return this.mPadding != 0;
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    this.mLevel = paramInt;
    invalidateSelf();
    return true;
  }
  
  public void setAlpha(int paramInt)
  {
    this.mPaint.setAlpha(paramInt);
  }
  
  public void setBackgroundColor(int paramInt)
  {
    if (this.mBackgroundColor != paramInt)
    {
      this.mBackgroundColor = paramInt;
      invalidateSelf();
    }
  }
  
  public void setBarWidth(int paramInt)
  {
    if (this.mBarWidth != paramInt)
    {
      this.mBarWidth = paramInt;
      invalidateSelf();
    }
  }
  
  public void setColor(int paramInt)
  {
    if (this.mColor != paramInt)
    {
      this.mColor = paramInt;
      invalidateSelf();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mPaint.setColorFilter(paramColorFilter);
  }
  
  public void setHideWhenZero(boolean paramBoolean)
  {
    this.mHideWhenZero = paramBoolean;
  }
  
  public void setPadding(int paramInt)
  {
    if (this.mPadding != paramInt)
    {
      this.mPadding = paramInt;
      invalidateSelf();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\drawee\drawable\ProgressBarDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */