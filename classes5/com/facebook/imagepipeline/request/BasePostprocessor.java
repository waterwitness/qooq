package com.facebook.imagepipeline.request;

import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.nativecode.Bitmaps;
import javax.annotation.Nullable;

public abstract class BasePostprocessor
  implements Postprocessor
{
  public String getName()
  {
    return "Unknown postprocessor";
  }
  
  @Nullable
  public CacheKey getPostprocessorCacheKey()
  {
    return null;
  }
  
  public CloseableReference<Bitmap> process(Bitmap paramBitmap, PlatformBitmapFactory paramPlatformBitmapFactory)
  {
    paramPlatformBitmapFactory = paramPlatformBitmapFactory.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), paramBitmap.getConfig());
    try
    {
      process((Bitmap)paramPlatformBitmapFactory.get(), paramBitmap);
      paramBitmap = CloseableReference.cloneOrNull(paramPlatformBitmapFactory);
      return paramBitmap;
    }
    finally
    {
      CloseableReference.closeSafely(paramPlatformBitmapFactory);
    }
  }
  
  public void process(Bitmap paramBitmap) {}
  
  public void process(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    Bitmaps.copyBitmap(paramBitmap1, paramBitmap2);
    process(paramBitmap1);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\request\BasePostprocessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */