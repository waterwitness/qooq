package com.facebook.imagepipeline.cache;

import com.android.internal.util.facebook.Predicate;
import com.facebook.common.references.CloseableReference;
import javax.annotation.Nullable;

public abstract interface MemoryCache<K, V>
{
  @Nullable
  public abstract CloseableReference<V> cache(K paramK, CloseableReference<V> paramCloseableReference);
  
  public abstract boolean contains(Predicate<K> paramPredicate);
  
  @Nullable
  public abstract CloseableReference<V> get(K paramK);
  
  public abstract int removeAll(Predicate<K> paramPredicate);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\cache\MemoryCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */