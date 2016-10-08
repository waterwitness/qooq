package com.facebook.imagepipeline.animated.impl;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.base.AnimatedImageFrame;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.animated.util.AnimatedDrawableUtil;
import javax.annotation.concurrent.GuardedBy;

public class AnimatedDrawableBackendImpl
  implements AnimatedDrawableBackend
{
  private final AnimatedDrawableUtil mAnimatedDrawableUtil;
  private final AnimatedImage mAnimatedImage;
  private final AnimatedImageResult mAnimatedImageResult;
  private final int mDurationMs;
  private final int[] mFrameDurationsMs;
  private final AnimatedDrawableFrameInfo[] mFrameInfos;
  private final int[] mFrameTimestampsMs;
  private final Rect mRenderedBounds;
  @GuardedBy("this")
  private Bitmap mTempBitmap;
  
  public AnimatedDrawableBackendImpl(AnimatedDrawableUtil paramAnimatedDrawableUtil, AnimatedImageResult paramAnimatedImageResult, Rect paramRect)
  {
    this.mAnimatedDrawableUtil = paramAnimatedDrawableUtil;
    this.mAnimatedImageResult = paramAnimatedImageResult;
    this.mAnimatedImage = paramAnimatedImageResult.getImage();
    this.mFrameDurationsMs = this.mAnimatedImage.getFrameDurations();
    this.mAnimatedDrawableUtil.fixFrameDurations(this.mFrameDurationsMs);
    this.mDurationMs = this.mAnimatedDrawableUtil.getTotalDurationFromFrameDurations(this.mFrameDurationsMs);
    this.mFrameTimestampsMs = this.mAnimatedDrawableUtil.getFrameTimeStampsFromDurations(this.mFrameDurationsMs);
    this.mRenderedBounds = getBoundsToUse(this.mAnimatedImage, paramRect);
    this.mFrameInfos = new AnimatedDrawableFrameInfo[this.mAnimatedImage.getFrameCount()];
    int i = 0;
    for (;;)
    {
      if (i >= this.mAnimatedImage.getFrameCount()) {
        return;
      }
      this.mFrameInfos[i] = this.mAnimatedImage.getFrameInfo(i);
      i += 1;
    }
  }
  
  private static Rect getBoundsToUse(AnimatedImage paramAnimatedImage, Rect paramRect)
  {
    if (paramRect == null) {
      return new Rect(0, 0, paramAnimatedImage.getWidth(), paramAnimatedImage.getHeight());
    }
    return new Rect(0, 0, Math.min(paramRect.width(), paramAnimatedImage.getWidth()), Math.min(paramRect.height(), paramAnimatedImage.getHeight()));
  }
  
  private void renderImageSupportsScaling(Canvas paramCanvas, AnimatedImageFrame paramAnimatedImageFrame)
  {
    double d1 = this.mRenderedBounds.width() / this.mAnimatedImage.getWidth();
    double d2 = this.mRenderedBounds.height() / this.mAnimatedImage.getHeight();
    int i = (int)Math.round(paramAnimatedImageFrame.getWidth() * d1);
    int j = (int)Math.round(paramAnimatedImageFrame.getHeight() * d2);
    int k = (int)(paramAnimatedImageFrame.getXOffset() * d1);
    int m = (int)(paramAnimatedImageFrame.getYOffset() * d2);
    try
    {
      if (this.mTempBitmap == null) {
        this.mTempBitmap = Bitmap.createBitmap(this.mRenderedBounds.width(), this.mRenderedBounds.height(), Bitmap.Config.ARGB_8888);
      }
      this.mTempBitmap.eraseColor(0);
      paramAnimatedImageFrame.renderFrame(i, j, this.mTempBitmap);
      paramCanvas.drawBitmap(this.mTempBitmap, k, m, null);
      return;
    }
    finally {}
  }
  
  public void dropCaches()
  {
    try
    {
      if (this.mTempBitmap != null)
      {
        this.mTempBitmap.recycle();
        this.mTempBitmap = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public AnimatedDrawableBackend forNewBounds(Rect paramRect)
  {
    if (getBoundsToUse(this.mAnimatedImage, paramRect).equals(this.mRenderedBounds)) {
      return this;
    }
    return new AnimatedDrawableBackendImpl(this.mAnimatedDrawableUtil, this.mAnimatedImageResult, paramRect);
  }
  
  public AnimatedImageResult getAnimatedImageResult()
  {
    return this.mAnimatedImageResult;
  }
  
  public int getDurationMs()
  {
    return this.mDurationMs;
  }
  
  public int getDurationMsForFrame(int paramInt)
  {
    return this.mFrameDurationsMs[paramInt];
  }
  
  public int getFrameCount()
  {
    return this.mAnimatedImage.getFrameCount();
  }
  
  public int getFrameForPreview()
  {
    return this.mAnimatedImageResult.getFrameForPreview();
  }
  
  public int getFrameForTimestampMs(int paramInt)
  {
    return this.mAnimatedDrawableUtil.getFrameForTimestampMs(this.mFrameTimestampsMs, paramInt);
  }
  
  public AnimatedDrawableFrameInfo getFrameInfo(int paramInt)
  {
    return this.mFrameInfos[paramInt];
  }
  
  public int getHeight()
  {
    return this.mAnimatedImage.getHeight();
  }
  
  public int getLoopCount()
  {
    return this.mAnimatedImage.getLoopCount();
  }
  
  public int getMemoryUsage()
  {
    int i = 0;
    try
    {
      if (this.mTempBitmap != null) {
        i = 0 + this.mAnimatedDrawableUtil.getSizeOfBitmap(this.mTempBitmap);
      }
      int j = this.mAnimatedImage.getSizeInBytes();
      return i + j;
    }
    finally {}
  }
  
  public CloseableReference<Bitmap> getPreDecodedFrame(int paramInt)
  {
    return this.mAnimatedImageResult.getDecodedFrame(paramInt);
  }
  
  public int getRenderedHeight()
  {
    return this.mRenderedBounds.height();
  }
  
  public int getRenderedWidth()
  {
    return this.mRenderedBounds.width();
  }
  
  public int getTimestampMsForFrame(int paramInt)
  {
    Preconditions.checkElementIndex(paramInt, this.mFrameTimestampsMs.length);
    return this.mFrameTimestampsMs[paramInt];
  }
  
  public int getWidth()
  {
    return this.mAnimatedImage.getWidth();
  }
  
  public boolean hasPreDecodedFrame(int paramInt)
  {
    return this.mAnimatedImageResult.hasDecodedFrame(paramInt);
  }
  
  /* Error */
  public void renderFrame(int paramInt, Canvas paramCanvas)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 43	com/facebook/imagepipeline/animated/impl/AnimatedDrawableBackendImpl:mAnimatedImage	Lcom/facebook/imagepipeline/animated/base/AnimatedImage;
    //   4: iload_1
    //   5: invokeinterface 215 2 0
    //   10: astore_3
    //   11: aload_0
    //   12: getfield 43	com/facebook/imagepipeline/animated/impl/AnimatedDrawableBackendImpl:mAnimatedImage	Lcom/facebook/imagepipeline/animated/base/AnimatedImage;
    //   15: invokeinterface 219 1 0
    //   20: ifeq +16 -> 36
    //   23: aload_0
    //   24: aload_2
    //   25: aload_3
    //   26: invokespecial 221	com/facebook/imagepipeline/animated/impl/AnimatedDrawableBackendImpl:renderImageSupportsScaling	(Landroid/graphics/Canvas;Lcom/facebook/imagepipeline/animated/base/AnimatedImageFrame;)V
    //   29: aload_3
    //   30: invokeinterface 224 1 0
    //   35: return
    //   36: aload_0
    //   37: aload_2
    //   38: aload_3
    //   39: invokevirtual 227	com/facebook/imagepipeline/animated/impl/AnimatedDrawableBackendImpl:renderImageDoesNotSupportScaling	(Landroid/graphics/Canvas;Lcom/facebook/imagepipeline/animated/base/AnimatedImageFrame;)V
    //   42: goto -13 -> 29
    //   45: astore_2
    //   46: aload_3
    //   47: invokeinterface 224 1 0
    //   52: aload_2
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	AnimatedDrawableBackendImpl
    //   0	54	1	paramInt	int
    //   0	54	2	paramCanvas	Canvas
    //   10	37	3	localAnimatedImageFrame	AnimatedImageFrame
    // Exception table:
    //   from	to	target	type
    //   11	29	45	finally
    //   36	42	45	finally
  }
  
  public void renderImageDoesNotSupportScaling(Canvas paramCanvas, AnimatedImageFrame paramAnimatedImageFrame)
  {
    int i = paramAnimatedImageFrame.getWidth();
    int j = paramAnimatedImageFrame.getHeight();
    int k = paramAnimatedImageFrame.getXOffset();
    int m = paramAnimatedImageFrame.getYOffset();
    try
    {
      if (this.mTempBitmap == null) {
        this.mTempBitmap = Bitmap.createBitmap(this.mAnimatedImage.getWidth(), this.mAnimatedImage.getHeight(), Bitmap.Config.ARGB_8888);
      }
      this.mTempBitmap.eraseColor(0);
      paramAnimatedImageFrame.renderFrame(i, j, this.mTempBitmap);
      float f1 = this.mRenderedBounds.width() / this.mAnimatedImage.getWidth();
      float f2 = this.mRenderedBounds.height() / this.mAnimatedImage.getHeight();
      paramCanvas.save();
      paramCanvas.scale(f1, f2);
      paramCanvas.translate(k, m);
      paramCanvas.drawBitmap(this.mTempBitmap, 0.0F, 0.0F, null);
      paramCanvas.restore();
      return;
    }
    finally {}
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\animated\impl\AnimatedDrawableBackendImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */