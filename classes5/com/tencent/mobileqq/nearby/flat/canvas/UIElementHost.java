package com.tencent.mobileqq.nearby.flat.canvas;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public abstract interface UIElementHost
{
  public abstract Context getContext();
  
  public abstract int[] getDrawableState();
  
  public abstract Resources getResources();
  
  public abstract void invalidate();
  
  public abstract void invalidate(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void invalidateDrawable(Drawable paramDrawable);
  
  public abstract void requestLayout();
  
  public abstract void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong);
  
  public abstract void unscheduleDrawable(Drawable paramDrawable);
  
  public abstract void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\flat\canvas\UIElementHost.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */