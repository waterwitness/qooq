package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;

public class OrientedDrawable
  extends ForwardingDrawable
{
  private int mRotationAngle;
  @VisibleForTesting
  final Matrix mRotationMatrix;
  private final Matrix mTempMatrix = new Matrix();
  private final RectF mTempRectF = new RectF();
  
  public OrientedDrawable(Drawable paramDrawable, int paramInt)
  {
    super(paramDrawable);
    if (paramInt % 90 == 0) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      this.mRotationMatrix = new Matrix();
      this.mRotationAngle = paramInt;
      return;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.mRotationAngle <= 0)
    {
      super.draw(paramCanvas);
      return;
    }
    int i = paramCanvas.save();
    paramCanvas.concat(this.mRotationMatrix);
    super.draw(paramCanvas);
    paramCanvas.restoreToCount(i);
  }
  
  public int getIntrinsicHeight()
  {
    if (this.mRotationAngle % 180 == 0) {
      return super.getIntrinsicHeight();
    }
    return super.getIntrinsicWidth();
  }
  
  public int getIntrinsicWidth()
  {
    if (this.mRotationAngle % 180 == 0) {
      return super.getIntrinsicWidth();
    }
    return super.getIntrinsicHeight();
  }
  
  public void getTransform(Matrix paramMatrix)
  {
    getParentTransform(paramMatrix);
    if (!this.mRotationMatrix.isIdentity()) {
      paramMatrix.preConcat(this.mRotationMatrix);
    }
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    Drawable localDrawable = getCurrent();
    if (this.mRotationAngle > 0)
    {
      this.mRotationMatrix.setRotate(this.mRotationAngle, paramRect.centerX(), paramRect.centerY());
      this.mTempMatrix.reset();
      this.mRotationMatrix.invert(this.mTempMatrix);
      this.mTempRectF.set(paramRect);
      this.mTempMatrix.mapRect(this.mTempRectF);
      localDrawable.setBounds((int)this.mTempRectF.left, (int)this.mTempRectF.top, (int)this.mTempRectF.right, (int)this.mTempRectF.bottom);
      return;
    }
    localDrawable.setBounds(paramRect);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\drawee\drawable\OrientedDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */