package com.facebook.drawee.drawable;

import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

public class DrawableProperties
{
  private static final int UNSET = -1;
  private int mAlpha = -1;
  private ColorFilter mColorFilter = null;
  private int mDither = -1;
  private int mFilterBitmap = -1;
  private boolean mIsSetColorFilter = false;
  
  public void applyTo(Drawable paramDrawable)
  {
    boolean bool2 = true;
    if (paramDrawable == null) {}
    do
    {
      return;
      if (this.mAlpha != -1) {
        paramDrawable.setAlpha(this.mAlpha);
      }
      if (this.mIsSetColorFilter) {
        paramDrawable.setColorFilter(this.mColorFilter);
      }
      if (this.mDither != -1)
      {
        if (this.mDither == 0) {
          break;
        }
        bool1 = true;
        paramDrawable.setDither(bool1);
      }
    } while (this.mFilterBitmap == -1);
    if (this.mFilterBitmap != 0) {}
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramDrawable.setFilterBitmap(bool1);
      return;
      bool1 = false;
      break;
    }
  }
  
  public void setAlpha(int paramInt)
  {
    this.mAlpha = paramInt;
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mColorFilter = paramColorFilter;
    this.mIsSetColorFilter = true;
  }
  
  public void setDither(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.mDither = i;
      return;
    }
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.mFilterBitmap = i;
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\drawee\drawable\DrawableProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */