package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.util.HashCodeUtil;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ResizeOptions;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
public class BitmapMemoryCacheKey
  implements CacheKey
{
  private final boolean mAutoRotated;
  private final int mHash;
  private final ImageDecodeOptions mImageDecodeOptions;
  @Nullable
  private final CacheKey mPostprocessorCacheKey;
  @Nullable
  private final String mPostprocessorName;
  @Nullable
  private final ResizeOptions mResizeOptions;
  private final String mSourceString;
  
  public BitmapMemoryCacheKey(String paramString1, @Nullable ResizeOptions paramResizeOptions, boolean paramBoolean, ImageDecodeOptions paramImageDecodeOptions, @Nullable CacheKey paramCacheKey, @Nullable String paramString2)
  {
    this.mSourceString = ((String)Preconditions.checkNotNull(paramString1));
    this.mResizeOptions = paramResizeOptions;
    this.mAutoRotated = paramBoolean;
    this.mImageDecodeOptions = paramImageDecodeOptions;
    this.mPostprocessorCacheKey = paramCacheKey;
    this.mPostprocessorName = paramString2;
    int k = paramString1.hashCode();
    int i;
    if (paramResizeOptions != null)
    {
      i = paramResizeOptions.hashCode();
      if (!paramBoolean) {
        break label110;
      }
    }
    label110:
    for (int j = Boolean.TRUE.hashCode();; j = Boolean.FALSE.hashCode())
    {
      this.mHash = HashCodeUtil.hashCode(Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j), this.mImageDecodeOptions, this.mPostprocessorCacheKey, paramString2);
      return;
      i = 0;
      break;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof BitmapMemoryCacheKey)) {}
    do
    {
      return false;
      paramObject = (BitmapMemoryCacheKey)paramObject;
    } while ((this.mHash != ((BitmapMemoryCacheKey)paramObject).mHash) || (!this.mSourceString.equals(((BitmapMemoryCacheKey)paramObject).mSourceString)) || (!Objects.equal(this.mResizeOptions, ((BitmapMemoryCacheKey)paramObject).mResizeOptions)) || (this.mAutoRotated != ((BitmapMemoryCacheKey)paramObject).mAutoRotated) || (!Objects.equal(this.mImageDecodeOptions, ((BitmapMemoryCacheKey)paramObject).mImageDecodeOptions)) || (!Objects.equal(this.mPostprocessorCacheKey, ((BitmapMemoryCacheKey)paramObject).mPostprocessorCacheKey)) || (!Objects.equal(this.mPostprocessorName, ((BitmapMemoryCacheKey)paramObject).mPostprocessorName)));
    return true;
  }
  
  @Nullable
  public String getPostprocessorName()
  {
    return this.mPostprocessorName;
  }
  
  public String getSourceUriString()
  {
    return this.mSourceString;
  }
  
  public int hashCode()
  {
    return this.mHash;
  }
  
  public String toString()
  {
    return String.format(null, "%s_%s_%s_%s_%s_%s_%d", new Object[] { this.mSourceString, this.mResizeOptions, Boolean.toString(this.mAutoRotated), this.mImageDecodeOptions, this.mPostprocessorCacheKey, this.mPostprocessorName, Integer.valueOf(this.mHash) });
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\cache\BitmapMemoryCacheKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */