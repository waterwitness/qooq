package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap.Config;
import com.facebook.common.internal.Closeables;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.GifFormatChecker;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.animated.factory.AnimatedImageFactory;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.platform.PlatformDecoder;
import java.io.InputStream;

public class ImageDecoder
{
  private final AnimatedImageFactory mAnimatedImageFactory;
  private final Bitmap.Config mBitmapConfig;
  private final PlatformDecoder mPlatformDecoder;
  
  public ImageDecoder(AnimatedImageFactory paramAnimatedImageFactory, PlatformDecoder paramPlatformDecoder, Bitmap.Config paramConfig)
  {
    this.mAnimatedImageFactory = paramAnimatedImageFactory;
    this.mBitmapConfig = paramConfig;
    this.mPlatformDecoder = paramPlatformDecoder;
  }
  
  public CloseableImage decodeAnimatedWebp(EncodedImage paramEncodedImage, ImageDecodeOptions paramImageDecodeOptions)
  {
    return this.mAnimatedImageFactory.decodeWebP(paramEncodedImage, paramImageDecodeOptions, this.mBitmapConfig);
  }
  
  public CloseableImage decodeGif(EncodedImage paramEncodedImage, ImageDecodeOptions paramImageDecodeOptions)
  {
    InputStream localInputStream = paramEncodedImage.getInputStream();
    if (localInputStream == null) {
      return null;
    }
    try
    {
      if (GifFormatChecker.isAnimated(localInputStream))
      {
        paramEncodedImage = this.mAnimatedImageFactory.decodeGif(paramEncodedImage, paramImageDecodeOptions, this.mBitmapConfig);
        return paramEncodedImage;
      }
      paramEncodedImage = decodeStaticImage(paramEncodedImage);
      return paramEncodedImage;
    }
    finally
    {
      Closeables.closeQuietly(localInputStream);
    }
  }
  
  public CloseableImage decodeImage(EncodedImage paramEncodedImage, int paramInt, QualityInfo paramQualityInfo, ImageDecodeOptions paramImageDecodeOptions)
  {
    ImageFormat localImageFormat2 = paramEncodedImage.getImageFormat();
    ImageFormat localImageFormat1;
    if (localImageFormat2 != null)
    {
      localImageFormat1 = localImageFormat2;
      if (localImageFormat2 != ImageFormat.UNKNOWN) {}
    }
    else
    {
      localImageFormat1 = ImageFormatChecker.getImageFormat_WrapIOException(paramEncodedImage.getInputStream());
    }
    switch (localImageFormat1)
    {
    case WEBP_EXTENDED: 
    case WEBP_LOSSLESS: 
    default: 
      return decodeStaticImage(paramEncodedImage);
    case WEBP_SIMPLE: 
      throw new IllegalArgumentException("unknown image format");
    case WEBP_ANIMATED: 
      return decodeJpeg(paramEncodedImage, paramInt, paramQualityInfo);
    case WEBP_EXTENDED_WITH_ALPHA: 
      return decodeGif(paramEncodedImage, paramImageDecodeOptions);
    }
    return decodeAnimatedWebp(paramEncodedImage, paramImageDecodeOptions);
  }
  
  public CloseableStaticBitmap decodeJpeg(EncodedImage paramEncodedImage, int paramInt, QualityInfo paramQualityInfo)
  {
    CloseableReference localCloseableReference = this.mPlatformDecoder.decodeJPEGFromEncodedImage(paramEncodedImage, this.mBitmapConfig, paramInt);
    try
    {
      paramEncodedImage = new CloseableStaticBitmap(localCloseableReference, paramQualityInfo, paramEncodedImage.getRotationAngle());
      return paramEncodedImage;
    }
    finally
    {
      localCloseableReference.close();
    }
  }
  
  public CloseableStaticBitmap decodeStaticImage(EncodedImage paramEncodedImage)
  {
    CloseableReference localCloseableReference = this.mPlatformDecoder.decodeFromEncodedImage(paramEncodedImage, this.mBitmapConfig);
    try
    {
      paramEncodedImage = new CloseableStaticBitmap(localCloseableReference, ImmutableQualityInfo.FULL_QUALITY, paramEncodedImage.getRotationAngle());
      return paramEncodedImage;
    }
    finally
    {
      localCloseableReference.close();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\decoder\ImageDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */