package com.facebook.imagepipeline.common;

public class ImageDecodeOptionsBuilder
{
  private int mBackgroundColor = 16777215;
  private boolean mDecodeAllFrames;
  private boolean mDecodePreviewFrame;
  private boolean mForceOldAnimationCode;
  private int mMinDecodeIntervalMs = 100;
  private boolean mUseLastFrameForPreview;
  
  public ImageDecodeOptions build()
  {
    return new ImageDecodeOptions(this);
  }
  
  public int getBackgroundColor()
  {
    return this.mBackgroundColor;
  }
  
  public boolean getDecodeAllFrames()
  {
    return this.mDecodeAllFrames;
  }
  
  public boolean getDecodePreviewFrame()
  {
    return this.mDecodePreviewFrame;
  }
  
  public boolean getForceOldAnimationCode()
  {
    return this.mForceOldAnimationCode;
  }
  
  public int getMinDecodeIntervalMs()
  {
    return this.mMinDecodeIntervalMs;
  }
  
  public boolean getUseLastFrameForPreview()
  {
    return this.mUseLastFrameForPreview;
  }
  
  public ImageDecodeOptionsBuilder setBackgroundColor(int paramInt)
  {
    this.mBackgroundColor = paramInt;
    return this;
  }
  
  public ImageDecodeOptionsBuilder setDecodeAllFrames(boolean paramBoolean)
  {
    this.mDecodeAllFrames = paramBoolean;
    return this;
  }
  
  public ImageDecodeOptionsBuilder setDecodePreviewFrame(boolean paramBoolean)
  {
    this.mDecodePreviewFrame = paramBoolean;
    return this;
  }
  
  public ImageDecodeOptionsBuilder setForceOldAnimationCode(boolean paramBoolean)
  {
    this.mForceOldAnimationCode = paramBoolean;
    return this;
  }
  
  public ImageDecodeOptionsBuilder setFrom(ImageDecodeOptions paramImageDecodeOptions)
  {
    this.mBackgroundColor = paramImageDecodeOptions.backgroundColor;
    this.mForceOldAnimationCode = paramImageDecodeOptions.forceOldAnimationCode;
    this.mDecodePreviewFrame = paramImageDecodeOptions.decodePreviewFrame;
    this.mUseLastFrameForPreview = paramImageDecodeOptions.useLastFrameForPreview;
    this.mDecodeAllFrames = paramImageDecodeOptions.decodeAllFrames;
    return this;
  }
  
  public ImageDecodeOptionsBuilder setMinDecodeIntervalMs(int paramInt)
  {
    this.mMinDecodeIntervalMs = paramInt;
    return this;
  }
  
  public ImageDecodeOptionsBuilder setUseLastFrameForPreview(boolean paramBoolean)
  {
    this.mUseLastFrameForPreview = paramBoolean;
    return this;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\common\ImageDecodeOptionsBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */