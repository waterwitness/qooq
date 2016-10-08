package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;

public abstract interface AnimatedImageFrame
{
  public abstract void dispose();
  
  public abstract int getDurationMs();
  
  public abstract int getHeight();
  
  public abstract int getWidth();
  
  public abstract int getXOffset();
  
  public abstract int getYOffset();
  
  public abstract void renderFrame(int paramInt1, int paramInt2, Bitmap paramBitmap);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\animated\base\AnimatedImageFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */