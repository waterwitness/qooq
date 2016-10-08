package com.facebook.react.bridge;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public abstract interface ReadableMapKeySetIterator
{
  public abstract boolean hasNextKey();
  
  public abstract String nextKey();
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\bridge\ReadableMapKeySetIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */