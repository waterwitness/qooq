package com.facebook.imagepipeline.common;

import javax.annotation.concurrent.Immutable;

@Immutable
public class ImageDecodeOptions
{
  private static final ImageDecodeOptions DEFAULTS = newBuilder().build();
  public final int backgroundColor;
  public final boolean decodeAllFrames;
  public final boolean decodePreviewFrame;
  public final boolean forceOldAnimationCode;
  public final int minDecodeIntervalMs;
  public final boolean useLastFrameForPreview;
  
  ImageDecodeOptions(ImageDecodeOptionsBuilder paramImageDecodeOptionsBuilder)
  {
    this.minDecodeIntervalMs = paramImageDecodeOptionsBuilder.getMinDecodeIntervalMs();
    this.backgroundColor = paramImageDecodeOptionsBuilder.getBackgroundColor();
    this.forceOldAnimationCode = paramImageDecodeOptionsBuilder.getForceOldAnimationCode();
    this.decodePreviewFrame = paramImageDecodeOptionsBuilder.getDecodePreviewFrame();
    this.useLastFrameForPreview = paramImageDecodeOptionsBuilder.getUseLastFrameForPreview();
    this.decodeAllFrames = paramImageDecodeOptionsBuilder.getDecodeAllFrames();
  }
  
  public static ImageDecodeOptions defaults()
  {
    return DEFAULTS;
  }
  
  public static ImageDecodeOptionsBuilder newBuilder()
  {
    return new ImageDecodeOptionsBuilder();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (ImageDecodeOptions)paramObject;
      if (this.backgroundColor != ((ImageDecodeOptions)paramObject).backgroundColor) {
        return false;
      }
      if (this.forceOldAnimationCode != ((ImageDecodeOptions)paramObject).forceOldAnimationCode) {
        return false;
      }
      if (this.decodePreviewFrame != ((ImageDecodeOptions)paramObject).decodePreviewFrame) {
        return false;
      }
      if (this.useLastFrameForPreview != ((ImageDecodeOptions)paramObject).useLastFrameForPreview) {
        return false;
      }
    } while (this.decodeAllFrames == ((ImageDecodeOptions)paramObject).decodeAllFrames);
    return false;
  }
  
  public int hashCode()
  {
    int j = this.backgroundColor;
    if (this.forceOldAnimationCode) {}
    for (int i = 1;; i = 0) {
      return j * 31 + i;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\common\ImageDecodeOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */