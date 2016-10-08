package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.facebook.common.references.CloseableReference;

public abstract class DelegatingAnimatedDrawableBackend
  implements AnimatedDrawableBackend
{
  private final AnimatedDrawableBackend mAnimatedDrawableBackend;
  
  public DelegatingAnimatedDrawableBackend(AnimatedDrawableBackend paramAnimatedDrawableBackend)
  {
    this.mAnimatedDrawableBackend = paramAnimatedDrawableBackend;
  }
  
  public void dropCaches()
  {
    this.mAnimatedDrawableBackend.dropCaches();
  }
  
  public AnimatedImageResult getAnimatedImageResult()
  {
    return this.mAnimatedDrawableBackend.getAnimatedImageResult();
  }
  
  protected AnimatedDrawableBackend getDelegate()
  {
    return this.mAnimatedDrawableBackend;
  }
  
  public int getDurationMs()
  {
    return this.mAnimatedDrawableBackend.getDurationMs();
  }
  
  public int getDurationMsForFrame(int paramInt)
  {
    return this.mAnimatedDrawableBackend.getDurationMsForFrame(paramInt);
  }
  
  public int getFrameCount()
  {
    return this.mAnimatedDrawableBackend.getFrameCount();
  }
  
  public int getFrameForPreview()
  {
    return this.mAnimatedDrawableBackend.getFrameForPreview();
  }
  
  public int getFrameForTimestampMs(int paramInt)
  {
    return this.mAnimatedDrawableBackend.getFrameForTimestampMs(paramInt);
  }
  
  public AnimatedDrawableFrameInfo getFrameInfo(int paramInt)
  {
    return this.mAnimatedDrawableBackend.getFrameInfo(paramInt);
  }
  
  public int getHeight()
  {
    return this.mAnimatedDrawableBackend.getHeight();
  }
  
  public int getLoopCount()
  {
    return this.mAnimatedDrawableBackend.getLoopCount();
  }
  
  public int getMemoryUsage()
  {
    return this.mAnimatedDrawableBackend.getMemoryUsage();
  }
  
  public CloseableReference<Bitmap> getPreDecodedFrame(int paramInt)
  {
    return this.mAnimatedDrawableBackend.getPreDecodedFrame(paramInt);
  }
  
  public int getRenderedHeight()
  {
    return this.mAnimatedDrawableBackend.getRenderedHeight();
  }
  
  public int getRenderedWidth()
  {
    return this.mAnimatedDrawableBackend.getRenderedWidth();
  }
  
  public int getTimestampMsForFrame(int paramInt)
  {
    return this.mAnimatedDrawableBackend.getTimestampMsForFrame(paramInt);
  }
  
  public int getWidth()
  {
    return this.mAnimatedDrawableBackend.getWidth();
  }
  
  public boolean hasPreDecodedFrame(int paramInt)
  {
    return this.mAnimatedDrawableBackend.hasPreDecodedFrame(paramInt);
  }
  
  public void renderFrame(int paramInt, Canvas paramCanvas)
  {
    this.mAnimatedDrawableBackend.renderFrame(paramInt, paramCanvas);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\animated\base\DelegatingAnimatedDrawableBackend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */