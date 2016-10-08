package com.facebook.drawee.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import javax.annotation.Nullable;

public class RoundedBitmapDrawable
  extends BitmapDrawable
  implements TransformAwareDrawable, Rounded
{
  @VisibleForTesting
  int mBorderColor = 0;
  private final Paint mBorderPaint = new Paint(1);
  @VisibleForTesting
  float mBorderWidth = 0.0F;
  @VisibleForTesting
  float[] mCornerRadii = new float[8];
  @VisibleForTesting
  final Matrix mInverseTransform = new Matrix();
  @VisibleForTesting
  boolean mIsCircle = false;
  @VisibleForTesting
  boolean mIsNonzero = true;
  private boolean mIsPathDirty = true;
  private boolean mIsShaderTransformDirty = true;
  private WeakReference<Bitmap> mLastBitmap;
  @VisibleForTesting
  final RectF mLastRootBounds = new RectF();
  @VisibleForTesting
  final Matrix mLastTransform = new Matrix();
  private final Paint mPaint = new Paint(1);
  private final Path mPath = new Path();
  @VisibleForTesting
  RectF mRootBounds = new RectF();
  @VisibleForTesting
  final Matrix mTransform = new Matrix();
  @Nullable
  private TransformCallback mTransformCallback;
  
  public RoundedBitmapDrawable(Resources paramResources, Bitmap paramBitmap)
  {
    super(paramResources, paramBitmap);
    this.mBorderPaint.setStyle(Paint.Style.STROKE);
  }
  
  public static RoundedBitmapDrawable fromBitmapDrawable(Resources paramResources, BitmapDrawable paramBitmapDrawable)
  {
    return new RoundedBitmapDrawable(paramResources, paramBitmapDrawable.getBitmap());
  }
  
  private void updateNonzero()
  {
    int i;
    if (this.mIsPathDirty)
    {
      this.mIsNonzero = false;
      if ((this.mIsCircle) || (this.mBorderWidth > 0.0F)) {
        this.mIsNonzero = true;
      }
      i = 0;
    }
    for (;;)
    {
      if (i >= this.mCornerRadii.length) {
        return;
      }
      if (this.mCornerRadii[i] > 0.0F) {
        this.mIsNonzero = true;
      }
      i += 1;
    }
  }
  
  private void updatePaint()
  {
    Bitmap localBitmap = getBitmap();
    if ((this.mLastBitmap == null) || (this.mLastBitmap.get() != localBitmap))
    {
      this.mLastBitmap = new WeakReference(localBitmap);
      this.mPaint.setShader(new BitmapShader(localBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
      this.mIsShaderTransformDirty = true;
    }
    if (this.mIsShaderTransformDirty)
    {
      this.mPaint.getShader().setLocalMatrix(this.mTransform);
      this.mIsShaderTransformDirty = false;
    }
  }
  
  private void updatePath()
  {
    if (this.mIsPathDirty)
    {
      this.mPath.reset();
      this.mRootBounds.inset(this.mBorderWidth / 2.0F, this.mBorderWidth / 2.0F);
      if (!this.mIsCircle) {
        break label120;
      }
      this.mPath.addCircle(this.mRootBounds.centerX(), this.mRootBounds.centerY(), Math.min(this.mRootBounds.width(), this.mRootBounds.height()) / 2.0F, Path.Direction.CW);
    }
    for (;;)
    {
      this.mRootBounds.inset(-(this.mBorderWidth / 2.0F), -(this.mBorderWidth / 2.0F));
      this.mPath.setFillType(Path.FillType.WINDING);
      this.mIsPathDirty = false;
      return;
      label120:
      this.mPath.addRoundRect(this.mRootBounds, this.mCornerRadii, Path.Direction.CW);
    }
  }
  
  private void updateTransform()
  {
    if (this.mTransformCallback != null)
    {
      this.mTransformCallback.getTransform(this.mTransform);
      this.mTransformCallback.getRootBounds(this.mRootBounds);
    }
    for (;;)
    {
      if (!this.mTransform.equals(this.mLastTransform))
      {
        this.mIsShaderTransformDirty = true;
        if (!this.mTransform.invert(this.mInverseTransform))
        {
          this.mInverseTransform.reset();
          this.mTransform.reset();
        }
        this.mLastTransform.set(this.mTransform);
      }
      if (!this.mRootBounds.equals(this.mLastRootBounds))
      {
        this.mIsPathDirty = true;
        this.mLastRootBounds.set(this.mRootBounds);
      }
      return;
      this.mTransform.reset();
      this.mRootBounds.set(getBounds());
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    updateTransform();
    updateNonzero();
    if (!this.mIsNonzero)
    {
      super.draw(paramCanvas);
      return;
    }
    updatePath();
    updatePaint();
    int i = paramCanvas.save();
    paramCanvas.concat(this.mInverseTransform);
    paramCanvas.drawPath(this.mPath, this.mPaint);
    if (this.mBorderWidth != 0.0F)
    {
      this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
      this.mBorderPaint.setColor(DrawableUtils.multiplyColorAlpha(this.mBorderColor, this.mPaint.getAlpha()));
      paramCanvas.drawPath(this.mPath, this.mBorderPaint);
    }
    paramCanvas.restoreToCount(i);
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.mPaint.getAlpha())
    {
      this.mPaint.setAlpha(paramInt);
      invalidateSelf();
    }
  }
  
  public void setBorder(int paramInt, float paramFloat)
  {
    if ((this.mBorderColor != paramInt) || (this.mBorderWidth != paramFloat))
    {
      this.mBorderColor = paramInt;
      this.mBorderWidth = paramFloat;
      this.mIsPathDirty = true;
      invalidateSelf();
    }
  }
  
  public void setCircle(boolean paramBoolean)
  {
    this.mIsCircle = paramBoolean;
    this.mIsPathDirty = true;
    invalidateSelf();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mPaint.setColorFilter(paramColorFilter);
    super.setColorFilter(paramColorFilter);
  }
  
  public void setRadii(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat == null)
    {
      Arrays.fill(this.mCornerRadii, 0.0F);
      this.mIsPathDirty = true;
      invalidateSelf();
      return;
    }
    if (paramArrayOfFloat.length == 8) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "radii should have exactly 8 values");
      System.arraycopy(paramArrayOfFloat, 0, this.mCornerRadii, 0, 8);
      break;
    }
  }
  
  public void setRadius(float paramFloat)
  {
    if (paramFloat >= 0.0F) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool);
      Arrays.fill(this.mCornerRadii, paramFloat);
      this.mIsPathDirty = true;
      invalidateSelf();
      return;
    }
  }
  
  public void setTransformCallback(@Nullable TransformCallback paramTransformCallback)
  {
    this.mTransformCallback = paramTransformCallback;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\drawee\drawable\RoundedBitmapDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */