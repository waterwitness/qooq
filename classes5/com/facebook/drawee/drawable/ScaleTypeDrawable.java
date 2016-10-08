package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;

public class ScaleTypeDrawable
  extends ForwardingDrawable
{
  @VisibleForTesting
  Matrix mDrawMatrix;
  @VisibleForTesting
  PointF mFocusPoint = null;
  @VisibleForTesting
  ScalingUtils.ScaleType mScaleType;
  private Matrix mTempMatrix = new Matrix();
  @VisibleForTesting
  int mUnderlyingHeight = 0;
  @VisibleForTesting
  int mUnderlyingWidth = 0;
  
  public ScaleTypeDrawable(Drawable paramDrawable, ScalingUtils.ScaleType paramScaleType)
  {
    super((Drawable)Preconditions.checkNotNull(paramDrawable));
    this.mScaleType = paramScaleType;
  }
  
  private void configureBoundsIfUnderlyingChanged()
  {
    if ((this.mUnderlyingWidth != getCurrent().getIntrinsicWidth()) || (this.mUnderlyingHeight != getCurrent().getIntrinsicHeight())) {
      configureBounds();
    }
  }
  
  @VisibleForTesting
  void configureBounds()
  {
    float f2 = 0.5F;
    Object localObject = getCurrent();
    Rect localRect = getBounds();
    int i = localRect.width();
    int j = localRect.height();
    int k = ((Drawable)localObject).getIntrinsicWidth();
    this.mUnderlyingWidth = k;
    int m = ((Drawable)localObject).getIntrinsicHeight();
    this.mUnderlyingHeight = m;
    if ((k <= 0) || (m <= 0))
    {
      ((Drawable)localObject).setBounds(localRect);
      this.mDrawMatrix = null;
      return;
    }
    if ((k == i) && (m == j))
    {
      ((Drawable)localObject).setBounds(localRect);
      this.mDrawMatrix = null;
      return;
    }
    if (this.mScaleType == ScalingUtils.ScaleType.FIT_XY)
    {
      ((Drawable)localObject).setBounds(localRect);
      this.mDrawMatrix = null;
      return;
    }
    ((Drawable)localObject).setBounds(0, 0, k, m);
    localObject = this.mTempMatrix;
    if (this.mFocusPoint != null) {}
    for (float f1 = this.mFocusPoint.x;; f1 = 0.5F)
    {
      if (this.mFocusPoint != null) {
        f2 = this.mFocusPoint.y;
      }
      ScalingUtils.getTransform((Matrix)localObject, localRect, k, m, f1, f2, this.mScaleType);
      this.mDrawMatrix = this.mTempMatrix;
      return;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    configureBoundsIfUnderlyingChanged();
    if (this.mDrawMatrix != null)
    {
      int i = paramCanvas.save();
      paramCanvas.clipRect(getBounds());
      paramCanvas.concat(this.mDrawMatrix);
      super.draw(paramCanvas);
      paramCanvas.restoreToCount(i);
      return;
    }
    super.draw(paramCanvas);
  }
  
  public PointF getFocusPoint()
  {
    return this.mFocusPoint;
  }
  
  public ScalingUtils.ScaleType getScaleType()
  {
    return this.mScaleType;
  }
  
  public void getTransform(Matrix paramMatrix)
  {
    getParentTransform(paramMatrix);
    configureBoundsIfUnderlyingChanged();
    if (this.mDrawMatrix != null) {
      paramMatrix.preConcat(this.mDrawMatrix);
    }
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    configureBounds();
  }
  
  public void setFocusPoint(PointF paramPointF)
  {
    if (this.mFocusPoint == null) {
      this.mFocusPoint = new PointF();
    }
    this.mFocusPoint.set(paramPointF);
    configureBounds();
    invalidateSelf();
  }
  
  public void setScaleType(ScalingUtils.ScaleType paramScaleType)
  {
    this.mScaleType = paramScaleType;
    configureBounds();
    invalidateSelf();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\drawee\drawable\ScaleTypeDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */