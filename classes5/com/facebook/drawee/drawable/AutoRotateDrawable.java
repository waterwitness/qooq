package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;

public class AutoRotateDrawable
  extends ForwardingDrawable
  implements Runnable
{
  private static final int DEGREES_IN_FULL_ROTATION = 360;
  private static final int FRAME_INTERVAL_MS = 20;
  private boolean mClockwise;
  private int mInterval;
  private boolean mIsScheduled = false;
  @VisibleForTesting
  float mRotationAngle = 0.0F;
  
  public AutoRotateDrawable(Drawable paramDrawable, int paramInt)
  {
    this(paramDrawable, paramInt, true);
  }
  
  public AutoRotateDrawable(Drawable paramDrawable, int paramInt, boolean paramBoolean)
  {
    super((Drawable)Preconditions.checkNotNull(paramDrawable));
    this.mInterval = paramInt;
    this.mClockwise = paramBoolean;
  }
  
  private int getIncrement()
  {
    return (int)(20.0F / this.mInterval * 360.0F);
  }
  
  private void scheduleNextFrame()
  {
    if (!this.mIsScheduled)
    {
      this.mIsScheduled = true;
      scheduleSelf(this, SystemClock.uptimeMillis() + 20L);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    int i = paramCanvas.save();
    Rect localRect = getBounds();
    int j = localRect.right;
    int k = localRect.left;
    int m = localRect.bottom;
    int n = localRect.top;
    float f = this.mRotationAngle;
    if (!this.mClockwise) {
      f = 360.0F - this.mRotationAngle;
    }
    paramCanvas.rotate(f, localRect.left + (j - k) / 2, localRect.top + (m - n) / 2);
    super.draw(paramCanvas);
    paramCanvas.restoreToCount(i);
    scheduleNextFrame();
  }
  
  public void reset()
  {
    this.mRotationAngle = 0.0F;
    this.mIsScheduled = false;
    unscheduleSelf(this);
    invalidateSelf();
  }
  
  public void run()
  {
    this.mIsScheduled = false;
    this.mRotationAngle += getIncrement();
    invalidateSelf();
  }
  
  public void setClockwise(boolean paramBoolean)
  {
    this.mClockwise = paramBoolean;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\drawee\drawable\AutoRotateDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */