package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import com.facebook.common.internal.Preconditions;
import javax.annotation.Nullable;

public class ArrayDrawable
  extends Drawable
  implements Drawable.Callback, TransformCallback, TransformAwareDrawable
{
  private final Rect mBounds = new Rect();
  private final DrawableProperties mDrawableProperties = new DrawableProperties();
  private boolean mIsMutated = false;
  private boolean mIsStateful = false;
  private boolean mIsStatefulCalculated = false;
  private boolean mIsVisible;
  private final Drawable[] mLayers;
  private int mLevel;
  private int[] mState;
  private final Rect mTmpRect = new Rect();
  private TransformCallback mTransformCallback;
  
  public ArrayDrawable(Drawable[] paramArrayOfDrawable)
  {
    Preconditions.checkNotNull(paramArrayOfDrawable);
    this.mLayers = paramArrayOfDrawable;
    int i = 0;
    for (;;)
    {
      if (i >= this.mLayers.length) {
        return;
      }
      DrawableUtils.setCallbacks(this.mLayers[i], this, this);
      i += 1;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    int i = 0;
    for (;;)
    {
      if (i >= this.mLayers.length) {
        return;
      }
      Drawable localDrawable = this.mLayers[i];
      if (localDrawable != null) {
        localDrawable.draw(paramCanvas);
      }
      i += 1;
    }
  }
  
  @Nullable
  public Drawable getDrawable(int paramInt)
  {
    return this.mLayers[paramInt];
  }
  
  public int getIntrinsicHeight()
  {
    int j = -1;
    int i = 0;
    for (;;)
    {
      if (i >= this.mLayers.length)
      {
        if (j <= 0) {
          break;
        }
        return j;
      }
      Drawable localDrawable = this.mLayers[i];
      int k = j;
      if (localDrawable != null) {
        k = Math.max(j, localDrawable.getIntrinsicHeight());
      }
      i += 1;
      j = k;
    }
    return -1;
  }
  
  public int getIntrinsicWidth()
  {
    int j = -1;
    int i = 0;
    for (;;)
    {
      if (i >= this.mLayers.length)
      {
        if (j <= 0) {
          break;
        }
        return j;
      }
      Drawable localDrawable = this.mLayers[i];
      int k = j;
      if (localDrawable != null) {
        k = Math.max(j, localDrawable.getIntrinsicWidth());
      }
      i += 1;
      j = k;
    }
    return -1;
  }
  
  public int getNumberOfLayers()
  {
    return this.mLayers.length;
  }
  
  public int getOpacity()
  {
    int k;
    if (this.mLayers.length == 0)
    {
      k = -2;
      return k;
    }
    int i = -1;
    int j = 1;
    for (;;)
    {
      k = i;
      if (j >= this.mLayers.length) {
        break;
      }
      Drawable localDrawable = this.mLayers[j];
      k = i;
      if (localDrawable != null) {
        k = Drawable.resolveOpacity(i, localDrawable.getOpacity());
      }
      j += 1;
      i = k;
    }
  }
  
  public boolean getPadding(Rect paramRect)
  {
    paramRect.left = 0;
    paramRect.top = 0;
    paramRect.right = 0;
    paramRect.bottom = 0;
    Rect localRect = this.mTmpRect;
    int i = 0;
    for (;;)
    {
      if (i >= this.mLayers.length) {
        return true;
      }
      Drawable localDrawable = this.mLayers[i];
      if (localDrawable != null)
      {
        localDrawable.getPadding(localRect);
        paramRect.left = Math.max(paramRect.left, localRect.left);
        paramRect.top = Math.max(paramRect.top, localRect.top);
        paramRect.right = Math.max(paramRect.right, localRect.right);
        paramRect.bottom = Math.max(paramRect.bottom, localRect.bottom);
      }
      i += 1;
    }
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
    if (this.mTransformCallback != null)
    {
      this.mTransformCallback.getTransform(paramMatrix);
      return;
    }
    paramMatrix.reset();
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    invalidateSelf();
  }
  
  public boolean isStateful()
  {
    int i;
    if (!this.mIsStatefulCalculated)
    {
      this.mIsStateful = false;
      i = 0;
      if (i >= this.mLayers.length) {
        this.mIsStatefulCalculated = true;
      }
    }
    else
    {
      return this.mIsStateful;
    }
    Drawable localDrawable = this.mLayers[i];
    boolean bool2 = this.mIsStateful;
    if ((localDrawable != null) && (localDrawable.isStateful())) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.mIsStateful = (bool1 | bool2);
      i += 1;
      break;
    }
  }
  
  public Drawable mutate()
  {
    int i = 0;
    for (;;)
    {
      if (i >= this.mLayers.length)
      {
        this.mIsMutated = true;
        return this;
      }
      Drawable localDrawable = this.mLayers[i];
      if (localDrawable != null) {
        localDrawable.mutate();
      }
      i += 1;
    }
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    this.mBounds.set(paramRect);
    int i = 0;
    for (;;)
    {
      if (i >= this.mLayers.length) {
        return;
      }
      Drawable localDrawable = this.mLayers[i];
      if (localDrawable != null) {
        localDrawable.setBounds(paramRect);
      }
      i += 1;
    }
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    this.mLevel = paramInt;
    boolean bool1 = false;
    int i = 0;
    for (;;)
    {
      if (i >= this.mLayers.length) {
        return bool1;
      }
      Drawable localDrawable = this.mLayers[i];
      boolean bool2 = bool1;
      if (localDrawable != null)
      {
        bool2 = bool1;
        if (localDrawable.setLevel(paramInt)) {
          bool2 = true;
        }
      }
      i += 1;
      bool1 = bool2;
    }
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    this.mState = paramArrayOfInt;
    boolean bool1 = false;
    int i = 0;
    for (;;)
    {
      if (i >= this.mLayers.length) {
        return bool1;
      }
      Drawable localDrawable = this.mLayers[i];
      boolean bool2 = bool1;
      if (localDrawable != null)
      {
        bool2 = bool1;
        if (localDrawable.setState(paramArrayOfInt)) {
          bool2 = true;
        }
      }
      i += 1;
      bool1 = bool2;
    }
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    scheduleSelf(paramRunnable, paramLong);
  }
  
  public void setAlpha(int paramInt)
  {
    this.mDrawableProperties.setAlpha(paramInt);
    int i = 0;
    for (;;)
    {
      if (i >= this.mLayers.length) {
        return;
      }
      Drawable localDrawable = this.mLayers[i];
      if (localDrawable != null) {
        localDrawable.setAlpha(paramInt);
      }
      i += 1;
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mDrawableProperties.setColorFilter(paramColorFilter);
    int i = 0;
    for (;;)
    {
      if (i >= this.mLayers.length) {
        return;
      }
      Drawable localDrawable = this.mLayers[i];
      if (localDrawable != null) {
        localDrawable.setColorFilter(paramColorFilter);
      }
      i += 1;
    }
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.mDrawableProperties.setDither(paramBoolean);
    int i = 0;
    for (;;)
    {
      if (i >= this.mLayers.length) {
        return;
      }
      Drawable localDrawable = this.mLayers[i];
      if (localDrawable != null) {
        localDrawable.setDither(paramBoolean);
      }
      i += 1;
    }
  }
  
  public void setDrawable(int paramInt, @Nullable Drawable paramDrawable)
  {
    boolean bool2 = true;
    if (paramInt >= 0)
    {
      bool1 = true;
      Preconditions.checkArgument(bool1);
      if (paramInt >= this.mLayers.length) {
        break label157;
      }
    }
    label157:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Preconditions.checkArgument(bool1);
      if (paramDrawable != this.mLayers[paramInt])
      {
        Drawable localDrawable = paramDrawable;
        if (paramDrawable != null)
        {
          localDrawable = paramDrawable;
          if (this.mIsMutated) {
            localDrawable = paramDrawable.mutate();
          }
        }
        DrawableUtils.setCallbacks(this.mLayers[paramInt], null, null);
        DrawableUtils.setCallbacks(localDrawable, null, null);
        DrawableUtils.setDrawableProperties(localDrawable, this.mDrawableProperties);
        if (localDrawable != null)
        {
          localDrawable.setBounds(this.mBounds);
          localDrawable.setLevel(this.mLevel);
          localDrawable.setState(this.mState);
          localDrawable.setVisible(this.mIsVisible, false);
        }
        DrawableUtils.setCallbacks(localDrawable, this, this);
        this.mIsStatefulCalculated = false;
        this.mLayers[paramInt] = localDrawable;
        invalidateSelf();
      }
      return;
      bool1 = false;
      break;
    }
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    this.mDrawableProperties.setFilterBitmap(paramBoolean);
    int i = 0;
    for (;;)
    {
      if (i >= this.mLayers.length) {
        return;
      }
      Drawable localDrawable = this.mLayers[i];
      if (localDrawable != null) {
        localDrawable.setFilterBitmap(paramBoolean);
      }
      i += 1;
    }
  }
  
  public void setTransformCallback(TransformCallback paramTransformCallback)
  {
    this.mTransformCallback = paramTransformCallback;
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mIsVisible = paramBoolean1;
    boolean bool = super.setVisible(paramBoolean1, paramBoolean2);
    int i = 0;
    for (;;)
    {
      if (i >= this.mLayers.length) {
        return bool;
      }
      Drawable localDrawable = this.mLayers[i];
      if (localDrawable != null) {
        localDrawable.setVisible(paramBoolean1, paramBoolean2);
      }
      i += 1;
    }
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    unscheduleSelf(paramRunnable);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\drawee\drawable\ArrayDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */