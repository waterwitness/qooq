package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

public abstract class ForwardingDrawable
  extends Drawable
  implements Drawable.Callback, TransformCallback, TransformAwareDrawable
{
  private static final Matrix sTempTransform = new Matrix();
  private Drawable mCurrentDelegate;
  private final DrawableProperties mDrawableProperties = new DrawableProperties();
  protected TransformCallback mTransformCallback;
  
  public ForwardingDrawable(Drawable paramDrawable)
  {
    this.mCurrentDelegate = paramDrawable;
    DrawableUtils.setCallbacks(this.mCurrentDelegate, this, this);
  }
  
  public void draw(Canvas paramCanvas)
  {
    this.mCurrentDelegate.draw(paramCanvas);
  }
  
  public Drawable getCurrent()
  {
    return this.mCurrentDelegate;
  }
  
  public int getIntrinsicHeight()
  {
    return this.mCurrentDelegate.getIntrinsicHeight();
  }
  
  public int getIntrinsicWidth()
  {
    return this.mCurrentDelegate.getIntrinsicWidth();
  }
  
  public int getOpacity()
  {
    return this.mCurrentDelegate.getOpacity();
  }
  
  public boolean getPadding(Rect paramRect)
  {
    return this.mCurrentDelegate.getPadding(paramRect);
  }
  
  protected void getParentTransform(Matrix paramMatrix)
  {
    if (this.mTransformCallback != null)
    {
      this.mTransformCallback.getTransform(paramMatrix);
      return;
    }
    paramMatrix.reset();
  }
  
  public void getRootBounds(RectF paramRectF)
  {
    if (this.mTransformCallback != null)
    {
      this.mTransformCallback.getRootBounds(paramRectF);
      return;
    }
    paramRectF.set(getBounds());
  }
  
  public void getTransform(Matrix paramMatrix)
  {
    getParentTransform(paramMatrix);
  }
  
  public void getTransformedBounds(RectF paramRectF)
  {
    getParentTransform(sTempTransform);
    paramRectF.set(getBounds());
    sTempTransform.mapRect(paramRectF);
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    invalidateSelf();
  }
  
  public boolean isStateful()
  {
    return this.mCurrentDelegate.isStateful();
  }
  
  public Drawable mutate()
  {
    this.mCurrentDelegate.mutate();
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    this.mCurrentDelegate.setBounds(paramRect);
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    return this.mCurrentDelegate.setLevel(paramInt);
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    return this.mCurrentDelegate.setState(paramArrayOfInt);
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    scheduleSelf(paramRunnable, paramLong);
  }
  
  public void setAlpha(int paramInt)
  {
    this.mDrawableProperties.setAlpha(paramInt);
    this.mCurrentDelegate.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mDrawableProperties.setColorFilter(paramColorFilter);
    this.mCurrentDelegate.setColorFilter(paramColorFilter);
  }
  
  public Drawable setCurrent(Drawable paramDrawable)
  {
    paramDrawable = setCurrentWithoutInvalidate(paramDrawable);
    invalidateSelf();
    return paramDrawable;
  }
  
  protected Drawable setCurrentWithoutInvalidate(Drawable paramDrawable)
  {
    Drawable localDrawable = this.mCurrentDelegate;
    DrawableUtils.setCallbacks(localDrawable, null, null);
    DrawableUtils.setCallbacks(paramDrawable, null, null);
    DrawableUtils.setDrawableProperties(paramDrawable, this.mDrawableProperties);
    DrawableUtils.copyProperties(paramDrawable, localDrawable);
    DrawableUtils.setCallbacks(paramDrawable, this, this);
    this.mCurrentDelegate = paramDrawable;
    return localDrawable;
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.mDrawableProperties.setDither(paramBoolean);
    this.mCurrentDelegate.setDither(paramBoolean);
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    this.mDrawableProperties.setFilterBitmap(paramBoolean);
    this.mCurrentDelegate.setFilterBitmap(paramBoolean);
  }
  
  public void setTransformCallback(TransformCallback paramTransformCallback)
  {
    this.mTransformCallback = paramTransformCallback;
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    super.setVisible(paramBoolean1, paramBoolean2);
    return this.mCurrentDelegate.setVisible(paramBoolean1, paramBoolean2);
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    unscheduleSelf(paramRunnable);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\drawee\drawable\ForwardingDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */