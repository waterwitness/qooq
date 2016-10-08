package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import java.util.List;

public class AnimatedImageResultBuilder
{
  private List<CloseableReference<Bitmap>> mDecodedFrames;
  private int mFrameForPreview;
  private final AnimatedImage mImage;
  private CloseableReference<Bitmap> mPreviewBitmap;
  
  AnimatedImageResultBuilder(AnimatedImage paramAnimatedImage)
  {
    this.mImage = paramAnimatedImage;
  }
  
  public AnimatedImageResult build()
  {
    try
    {
      AnimatedImageResult localAnimatedImageResult = new AnimatedImageResult(this);
      return localAnimatedImageResult;
    }
    finally
    {
      CloseableReference.closeSafely(this.mPreviewBitmap);
      this.mPreviewBitmap = null;
      CloseableReference.closeSafely(this.mDecodedFrames);
      this.mDecodedFrames = null;
    }
  }
  
  public List<CloseableReference<Bitmap>> getDecodedFrames()
  {
    return CloseableReference.cloneOrNull(this.mDecodedFrames);
  }
  
  public int getFrameForPreview()
  {
    return this.mFrameForPreview;
  }
  
  public AnimatedImage getImage()
  {
    return this.mImage;
  }
  
  public CloseableReference<Bitmap> getPreviewBitmap()
  {
    return CloseableReference.cloneOrNull(this.mPreviewBitmap);
  }
  
  public AnimatedImageResultBuilder setDecodedFrames(List<CloseableReference<Bitmap>> paramList)
  {
    this.mDecodedFrames = CloseableReference.cloneOrNull(paramList);
    return this;
  }
  
  public AnimatedImageResultBuilder setFrameForPreview(int paramInt)
  {
    this.mFrameForPreview = paramInt;
    return this;
  }
  
  public AnimatedImageResultBuilder setPreviewBitmap(CloseableReference<Bitmap> paramCloseableReference)
  {
    this.mPreviewBitmap = CloseableReference.cloneOrNull(paramCloseableReference);
    return this;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\animated\base\AnimatedImageResultBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */