package com.facebook.cache.common;

import com.facebook.common.internal.Preconditions;

public class SimpleCacheKey
  implements CacheKey
{
  final String mKey;
  
  public SimpleCacheKey(String paramString)
  {
    this.mKey = ((String)Preconditions.checkNotNull(paramString));
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof SimpleCacheKey))
    {
      paramObject = (SimpleCacheKey)paramObject;
      return this.mKey.equals(((SimpleCacheKey)paramObject).mKey);
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.mKey.hashCode();
  }
  
  public String toString()
  {
    return this.mKey;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\cache\common\SimpleCacheKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */