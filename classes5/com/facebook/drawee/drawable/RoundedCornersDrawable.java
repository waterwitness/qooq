package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import java.util.Arrays;

public class RoundedCornersDrawable
  extends ForwardingDrawable
  implements Rounded
{
  @VisibleForTesting
  int mBorderColor = 0;
  @VisibleForTesting
  float mBorderWidth = 0.0F;
  @VisibleForTesting
  boolean mIsCircle = false;
  @VisibleForTesting
  int mOverlayColor = 0;
  @VisibleForTesting
  final Paint mPaint = new Paint(1);
  private final Path mPath = new Path();
  @VisibleForTesting
  final float[] mRadii = new float[8];
  private final RectF mTempRectangle = new RectF();
  @VisibleForTesting
  Type mType = Type.OVERLAY_COLOR;
  
  public RoundedCornersDrawable(Drawable paramDrawable)
  {
    super((Drawable)Preconditions.checkNotNull(paramDrawable));
  }
  
  private void updatePath()
  {
    this.mPath.reset();
    this.mTempRectangle.set(getBounds());
    this.mTempRectangle.inset(this.mBorderWidth / 2.0F, this.mBorderWidth / 2.0F);
    if (this.mIsCircle) {
      this.mPath.addCircle(this.mTempRectangle.centerX(), this.mTempRectangle.centerY(), Math.min(this.mTempRectangle.width(), this.mTempRectangle.height()) / 2.0F, Path.Direction.CW);
    }
    for (;;)
    {
      this.mTempRectangle.inset(-this.mBorderWidth / 2.0F, -this.mBorderWidth / 2.0F);
      return;
      this.mPath.addRoundRect(this.mTempRectangle, this.mRadii, Path.Direction.CW);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    switch (this.mType)
    {
    }
    for (;;)
    {
      if (this.mBorderColor != 0)
      {
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(this.mBorderColor);
        this.mPaint.setStrokeWidth(this.mBorderWidth);
        this.mPath.setFillType(Path.FillType.EVEN_ODD);
        paramCanvas.drawPath(this.mPath, this.mPaint);
      }
      return;
      int i = paramCanvas.save();
      this.mPath.setFillType(Path.FillType.EVEN_ODD);
      paramCanvas.clipPath(this.mPath);
      super.draw(paramCanvas);
      paramCanvas.restoreToCount(i);
      continue;
      super.draw(paramCanvas);
      this.mPaint.setColor(this.mOverlayColor);
      this.mPaint.setStyle(Paint.Style.FILL);
      this.mPath.setFillType(Path.FillType.INVERSE_EVEN_ODD);
      paramCanvas.drawPath(this.mPath, this.mPaint);
      if (this.mIsCircle)
      {
        float f1 = (localRect.width() - localRect.height() + this.mBorderWidth) / 2.0F;
        float f2 = (localRect.height() - localRect.width() + this.mBorderWidth) / 2.0F;
        if (f1 > 0.0F)
        {
          paramCanvas.drawRect(localRect.left, localRect.top, localRect.left + f1, localRect.bottom, this.mPaint);
          paramCanvas.drawRect(localRect.right - f1, localRect.top, localRect.right, localRect.bottom, this.mPaint);
        }
        if (f2 > 0.0F)
        {
          paramCanvas.drawRect(localRect.left, localRect.top, localRect.right, localRect.top + f2, this.mPaint);
          paramCanvas.drawRect(localRect.left, localRect.bottom - f2, localRect.right, localRect.bottom, this.mPaint);
        }
      }
    }
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    updatePath();
  }
  
  public void setBorder(int paramInt, float paramFloat)
  {
    this.mBorderColor = paramInt;
    this.mBorderWidth = paramFloat;
    updatePath();
    invalidateSelf();
  }
  
  public void setCircle(boolean paramBoolean)
  {
    this.mIsCircle = paramBoolean;
    updatePath();
    invalidateSelf();
  }
  
  public void setOverlayColor(int paramInt)
  {
    this.mOverlayColor = paramInt;
    invalidateSelf();
  }
  
  public void setRadii(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat == null)
    {
      Arrays.fill(this.mRadii, 0.0F);
      updatePath();
      invalidateSelf();
      return;
    }
    if (paramArrayOfFloat.length == 8) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "radii should have exactly 8 values");
      System.arraycopy(paramArrayOfFloat, 0, this.mRadii, 0, 8);
      break;
    }
  }
  
  public void setRadius(float paramFloat)
  {
    Arrays.fill(this.mRadii, paramFloat);
    updatePath();
    invalidateSelf();
  }
  
  public void setType(Type paramType)
  {
    this.mType = paramType;
    invalidateSelf();
  }
  
  public static enum Type
  {
    OVERLAY_COLOR,  CLIPPING;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\drawee\drawable\RoundedCornersDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */