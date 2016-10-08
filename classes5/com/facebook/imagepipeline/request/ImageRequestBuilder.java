package com.facebook.imagepipeline.request;

import android.net.Uri;
import android.net.Uri.Builder;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.ResizeOptions;
import javax.annotation.Nullable;

public class ImageRequestBuilder
{
  private boolean mAutoRotateEnabled = false;
  private ImageDecodeOptions mImageDecodeOptions = ImageDecodeOptions.defaults();
  private ImageRequest.ImageType mImageType = ImageRequest.ImageType.DEFAULT;
  private boolean mLocalThumbnailPreviewsEnabled = false;
  private ImageRequest.RequestLevel mLowestPermittedRequestLevel = ImageRequest.RequestLevel.FULL_FETCH;
  @Nullable
  private Postprocessor mPostprocessor = null;
  private boolean mProgressiveRenderingEnabled = false;
  private Priority mRequestPriority = Priority.HIGH;
  @Nullable
  private ResizeOptions mResizeOptions = null;
  private Uri mSourceUri = null;
  
  public static ImageRequestBuilder fromRequest(ImageRequest paramImageRequest)
  {
    return newBuilderWithSource(paramImageRequest.getSourceUri()).setAutoRotateEnabled(paramImageRequest.getAutoRotateEnabled()).setImageDecodeOptions(paramImageRequest.getImageDecodeOptions()).setImageType(paramImageRequest.getImageType()).setLocalThumbnailPreviewsEnabled(paramImageRequest.getLocalThumbnailPreviewsEnabled()).setLowestPermittedRequestLevel(paramImageRequest.getLowestPermittedRequestLevel()).setPostprocessor(paramImageRequest.getPostprocessor()).setProgressiveRenderingEnabled(paramImageRequest.getProgressiveRenderingEnabled()).setRequestPriority(paramImageRequest.getPriority()).setResizeOptions(paramImageRequest.getResizeOptions());
  }
  
  public static ImageRequestBuilder newBuilderWithResourceId(int paramInt)
  {
    return newBuilderWithSource(new Uri.Builder().scheme("res").path(String.valueOf(paramInt)).build());
  }
  
  public static ImageRequestBuilder newBuilderWithSource(Uri paramUri)
  {
    return new ImageRequestBuilder().setSource(paramUri);
  }
  
  public ImageRequest build()
  {
    validate();
    return new ImageRequest(this);
  }
  
  public ImageDecodeOptions getImageDecodeOptions()
  {
    return this.mImageDecodeOptions;
  }
  
  public ImageRequest.ImageType getImageType()
  {
    return this.mImageType;
  }
  
  public ImageRequest.RequestLevel getLowestPermittedRequestLevel()
  {
    return this.mLowestPermittedRequestLevel;
  }
  
  @Nullable
  public Postprocessor getPostprocessor()
  {
    return this.mPostprocessor;
  }
  
  public Priority getRequestPriority()
  {
    return this.mRequestPriority;
  }
  
  @Nullable
  public ResizeOptions getResizeOptions()
  {
    return this.mResizeOptions;
  }
  
  public Uri getSourceUri()
  {
    return this.mSourceUri;
  }
  
  public boolean isAutoRotateEnabled()
  {
    return this.mAutoRotateEnabled;
  }
  
  public boolean isDiskCacheEnabled()
  {
    return UriUtil.isNetworkUri(this.mSourceUri);
  }
  
  public boolean isLocalThumbnailPreviewsEnabled()
  {
    return this.mLocalThumbnailPreviewsEnabled;
  }
  
  public boolean isProgressiveRenderingEnabled()
  {
    return this.mProgressiveRenderingEnabled;
  }
  
  public ImageRequestBuilder setAutoRotateEnabled(boolean paramBoolean)
  {
    this.mAutoRotateEnabled = paramBoolean;
    return this;
  }
  
  public ImageRequestBuilder setImageDecodeOptions(ImageDecodeOptions paramImageDecodeOptions)
  {
    this.mImageDecodeOptions = paramImageDecodeOptions;
    return this;
  }
  
  public ImageRequestBuilder setImageType(ImageRequest.ImageType paramImageType)
  {
    this.mImageType = paramImageType;
    return this;
  }
  
  public ImageRequestBuilder setLocalThumbnailPreviewsEnabled(boolean paramBoolean)
  {
    this.mLocalThumbnailPreviewsEnabled = paramBoolean;
    return this;
  }
  
  public ImageRequestBuilder setLowestPermittedRequestLevel(ImageRequest.RequestLevel paramRequestLevel)
  {
    this.mLowestPermittedRequestLevel = paramRequestLevel;
    return this;
  }
  
  public ImageRequestBuilder setPostprocessor(Postprocessor paramPostprocessor)
  {
    this.mPostprocessor = paramPostprocessor;
    return this;
  }
  
  public ImageRequestBuilder setProgressiveRenderingEnabled(boolean paramBoolean)
  {
    this.mProgressiveRenderingEnabled = paramBoolean;
    return this;
  }
  
  public ImageRequestBuilder setRequestPriority(Priority paramPriority)
  {
    this.mRequestPriority = paramPriority;
    return this;
  }
  
  public ImageRequestBuilder setResizeOptions(ResizeOptions paramResizeOptions)
  {
    this.mResizeOptions = paramResizeOptions;
    return this;
  }
  
  public ImageRequestBuilder setSource(Uri paramUri)
  {
    Preconditions.checkNotNull(paramUri);
    this.mSourceUri = paramUri;
    return this;
  }
  
  protected void validate()
  {
    if (this.mSourceUri == null) {
      throw new BuilderException("Source must be set!");
    }
    if (UriUtil.isLocalResourceUri(this.mSourceUri))
    {
      if (!this.mSourceUri.isAbsolute()) {
        throw new BuilderException("Resource URI path must be absolute.");
      }
      if (this.mSourceUri.getPath().isEmpty()) {
        throw new BuilderException("Resource URI must not be empty");
      }
    }
    try
    {
      Integer.parseInt(this.mSourceUri.getPath().substring(1));
      if ((UriUtil.isLocalAssetUri(this.mSourceUri)) && (!this.mSourceUri.isAbsolute())) {
        throw new BuilderException("Asset URI path must be absolute.");
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      throw new BuilderException("Resource URI path must be a resource id.");
    }
  }
  
  public static class BuilderException
    extends RuntimeException
  {
    public BuilderException(String paramString)
    {
      super();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\request\ImageRequestBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */