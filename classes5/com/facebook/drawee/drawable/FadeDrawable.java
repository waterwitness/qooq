package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import java.util.Arrays;

public class FadeDrawable
  extends ArrayDrawable
{
  @VisibleForTesting
  public static final int TRANSITION_NONE = 2;
  @VisibleForTesting
  public static final int TRANSITION_RUNNING = 1;
  @VisibleForTesting
  public static final int TRANSITION_STARTING = 0;
  @VisibleForTesting
  int mAlpha;
  @VisibleForTesting
  int[] mAlphas;
  @VisibleForTesting
  int mDurationMs;
  @VisibleForTesting
  boolean[] mIsLayerOn;
  private final Drawable[] mLayers;
  @VisibleForTesting
  int mPreventInvalidateCount;
  @VisibleForTesting
  int[] mStartAlphas;
  @VisibleForTesting
  long mStartTimeMs;
  @VisibleForTesting
  int mTransitionState;
  
  public FadeDrawable(Drawable[] paramArrayOfDrawable)
  {
    super(paramArrayOfDrawable);
    if (paramArrayOfDrawable.length >= 1) {}
    for (;;)
    {
      Preconditions.checkState(bool, "At least one layer required!");
      this.mLayers = paramArrayOfDrawable;
      this.mStartAlphas = new int[paramArrayOfDrawable.length];
      this.mAlphas = new int[paramArrayOfDrawable.length];
      this.mAlpha = 255;
      this.mIsLayerOn = new boolean[paramArrayOfDrawable.length];
      this.mPreventInvalidateCount = 0;
      resetInternal();
      return;
      bool = false;
    }
  }
  
  private void drawDrawableWithAlpha(Canvas paramCanvas, Drawable paramDrawable, int paramInt)
  {
    if ((paramDrawable != null) && (paramInt > 0))
    {
      this.mPreventInvalidateCount += 1;
      paramDrawable.mutate().setAlpha(paramInt);
      this.mPreventInvalidateCount -= 1;
      paramDrawable.draw(paramCanvas);
    }
  }
  
  private void resetInternal()
  {
    this.mTransitionState = 2;
    Arrays.fill(this.mStartAlphas, 0);
    this.mStartAlphas[0] = 255;
    Arrays.fill(this.mAlphas, 0);
    this.mAlphas[0] = 255;
    Arrays.fill(this.mIsLayerOn, false);
    this.mIsLayerOn[0] = true;
  }
  
  private boolean updateAlphas(float paramFloat)
  {
    boolean bool2 = true;
    int i = 0;
    if (i >= this.mLayers.length) {
      return bool2;
    }
    if (this.mIsLayerOn[i] != 0) {}
    for (int j = 1;; j = -1)
    {
      this.mAlphas[i] = ((int)(this.mStartAlphas[i] + j * 255 * paramFloat));
      if (this.mAlphas[i] < 0) {
        this.mAlphas[i] = 0;
      }
      if (this.mAlphas[i] > 255) {
        this.mAlphas[i] = 255;
      }
      boolean bool1 = bool2;
      if (this.mIsLayerOn[i] != 0)
      {
        bool1 = bool2;
        if (this.mAlphas[i] < 255) {
          bool1 = false;
        }
      }
      bool2 = bool1;
      if (this.mIsLayerOn[i] == 0)
      {
        bool2 = bool1;
        if (this.mAlphas[i] > 0) {
          bool2 = false;
        }
      }
      i += 1;
      break;
    }
  }
  
  public void beginBatchMode()
  {
    this.mPreventInvalidateCount += 1;
  }
  
  public void draw(Canvas paramCanvas)
  {
    int i = 2;
    boolean bool1 = false;
    boolean bool2 = true;
    switch (this.mTransitionState)
    {
    default: 
      bool1 = bool2;
      i = 0;
    }
    for (;;)
    {
      if (i >= this.mLayers.length)
      {
        if (!bool1) {
          invalidateSelf();
        }
        return;
        System.arraycopy(this.mAlphas, 0, this.mStartAlphas, 0, this.mLayers.length);
        this.mStartTimeMs = getCurrentTimeMs();
        float f;
        if (this.mDurationMs == 0)
        {
          f = 1.0F;
          label100:
          bool1 = updateAlphas(f);
          if (!bool1) {
            break label125;
          }
        }
        for (;;)
        {
          this.mTransitionState = i;
          break;
          f = 0.0F;
          break label100;
          label125:
          i = 1;
        }
        if (this.mDurationMs > 0) {
          bool1 = true;
        }
        Preconditions.checkState(bool1);
        bool1 = updateAlphas((float)(getCurrentTimeMs() - this.mStartTimeMs) / this.mDurationMs);
        if (bool1) {}
        for (;;)
        {
          this.mTransitionState = i;
          break;
          i = 1;
        }
        bool1 = true;
        break;
      }
      drawDrawableWithAlpha(paramCanvas, this.mLayers[i], this.mAlphas[i] * this.mAlpha / 255);
      i += 1;
    }
  }
  
  public void endBatchMode()
  {
    this.mPreventInvalidateCount -= 1;
    invalidateSelf();
  }
  
  public void fadeInAllLayers()
  {
    this.mTransitionState = 0;
    Arrays.fill(this.mIsLayerOn, true);
    invalidateSelf();
  }
  
  public void fadeInLayer(int paramInt)
  {
    this.mTransitionState = 0;
    this.mIsLayerOn[paramInt] = true;
    invalidateSelf();
  }
  
  public void fadeOutAllLayers()
  {
    this.mTransitionState = 0;
    Arrays.fill(this.mIsLayerOn, false);
    invalidateSelf();
  }
  
  public void fadeOutLayer(int paramInt)
  {
    this.mTransitionState = 0;
    this.mIsLayerOn[paramInt] = false;
    invalidateSelf();
  }
  
  public void fadeToLayer(int paramInt)
  {
    this.mTransitionState = 0;
    Arrays.fill(this.mIsLayerOn, false);
    this.mIsLayerOn[paramInt] = true;
    invalidateSelf();
  }
  
  public void fadeUpToLayer(int paramInt)
  {
    this.mTransitionState = 0;
    Arrays.fill(this.mIsLayerOn, 0, paramInt + 1, true);
    Arrays.fill(this.mIsLayerOn, paramInt + 1, this.mLayers.length, false);
    invalidateSelf();
  }
  
  public void finishTransitionImmediately()
  {
    this.mTransitionState = 2;
    int i = 0;
    if (i >= this.mLayers.length)
    {
      invalidateSelf();
      return;
    }
    int[] arrayOfInt = this.mAlphas;
    if (this.mIsLayerOn[i] != 0) {}
    for (int j = 255;; j = 0)
    {
      arrayOfInt[i] = j;
      i += 1;
      break;
    }
  }
  
  public int getAlpha()
  {
    return this.mAlpha;
  }
  
  protected long getCurrentTimeMs()
  {
    return SystemClock.uptimeMillis();
  }
  
  public int getTransitionDuration()
  {
    return this.mDurationMs;
  }
  
  @VisibleForTesting
  public int getTransitionState()
  {
    return this.mTransitionState;
  }
  
  public void invalidateSelf()
  {
    if (this.mPreventInvalidateCount == 0) {
      super.invalidateSelf();
    }
  }
  
  public boolean isLayerOn(int paramInt)
  {
    return this.mIsLayerOn[paramInt];
  }
  
  public void reset()
  {
    resetInternal();
    invalidateSelf();
  }
  
  public void setAlpha(int paramInt)
  {
    if (this.mAlpha != paramInt)
    {
      this.mAlpha = paramInt;
      invalidateSelf();
    }
  }
  
  public void setTransitionDuration(int paramInt)
  {
    this.mDurationMs = paramInt;
    if (this.mTransitionState == 1) {
      this.mTransitionState = 0;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\drawee\drawable\FadeDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */