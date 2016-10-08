package com.facebook.imagepipeline.cache;

import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.request.ImageRequest;

public abstract interface CacheKeyFactory
{
  public abstract CacheKey getBitmapCacheKey(ImageRequest paramImageRequest);
  
  public abstract Uri getCacheKeySourceUri(Uri paramUri);
  
  public abstract CacheKey getEncodedCacheKey(ImageRequest paramImageRequest);
  
  public abstract CacheKey getPostprocessedBitmapCacheKey(ImageRequest paramImageRequest);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\cache\CacheKeyFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */