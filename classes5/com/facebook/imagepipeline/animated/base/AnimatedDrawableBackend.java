package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.facebook.common.references.CloseableReference;
import javax.annotation.Nullable;

public abstract interface AnimatedDrawableBackend
{
  public abstract void dropCaches();
  
  public abstract AnimatedDrawableBackend forNewBounds(Rect paramRect);
  
  public abstract AnimatedImageResult getAnimatedImageResult();
  
  public abstract int getDurationMs();
  
  public abstract int getDurationMsForFrame(int paramInt);
  
  public abstract int getFrameCount();
  
  public abstract int getFrameForPreview();
  
  public abstract int getFrameForTimestampMs(int paramInt);
  
  public abstract AnimatedDrawableFrameInfo getFrameInfo(int paramInt);
  
  public abstract int getHeight();
  
  public abstract int getLoopCount();
  
  public abstract int getMemoryUsage();
  
  @Nullable
  public abstract CloseableReference<Bitmap> getPreDecodedFrame(int paramInt);
  
  public abstract int getRenderedHeight();
  
  public abstract int getRenderedWidth();
  
  public abstract int getTimestampMsForFrame(int paramInt);
  
  public abstract int getWidth();
  
  public abstract boolean hasPreDecodedFrame(int paramInt);
  
  public abstract void renderFrame(int paramInt, Canvas paramCanvas);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\animated\base\AnimatedDrawableBackend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */