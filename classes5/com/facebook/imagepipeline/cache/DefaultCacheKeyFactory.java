package com.facebook.imagepipeline.cache;

import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.Postprocessor;

public class DefaultCacheKeyFactory
  implements CacheKeyFactory
{
  private static DefaultCacheKeyFactory sInstance = null;
  
  public static DefaultCacheKeyFactory getInstance()
  {
    try
    {
      if (sInstance == null) {
        sInstance = new DefaultCacheKeyFactory();
      }
      DefaultCacheKeyFactory localDefaultCacheKeyFactory = sInstance;
      return localDefaultCacheKeyFactory;
    }
    finally {}
  }
  
  public CacheKey getBitmapCacheKey(ImageRequest paramImageRequest)
  {
    return new BitmapMemoryCacheKey(getCacheKeySourceUri(paramImageRequest.getSourceUri()).toString(), paramImageRequest.getResizeOptions(), paramImageRequest.getAutoRotateEnabled(), paramImageRequest.getImageDecodeOptions(), null, null);
  }
  
  public Uri getCacheKeySourceUri(Uri paramUri)
  {
    return paramUri;
  }
  
  public CacheKey getEncodedCacheKey(ImageRequest paramImageRequest)
  {
    return new SimpleCacheKey(getCacheKeySourceUri(paramImageRequest.getSourceUri()).toString());
  }
  
  public CacheKey getPostprocessedBitmapCacheKey(ImageRequest paramImageRequest)
  {
    Object localObject = paramImageRequest.getPostprocessor();
    CacheKey localCacheKey;
    if (localObject != null) {
      localCacheKey = ((Postprocessor)localObject).getPostprocessorCacheKey();
    }
    for (localObject = localObject.getClass().getName();; localObject = null)
    {
      return new BitmapMemoryCacheKey(getCacheKeySourceUri(paramImageRequest.getSourceUri()).toString(), paramImageRequest.getResizeOptions(), paramImageRequest.getAutoRotateEnabled(), paramImageRequest.getImageDecodeOptions(), localCacheKey, (String)localObject);
      localCacheKey = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\cache\DefaultCacheKeyFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */