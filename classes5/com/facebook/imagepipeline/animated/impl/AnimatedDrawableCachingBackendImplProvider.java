package com.facebook.imagepipeline.animated.impl;

import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableOptions;

public abstract interface AnimatedDrawableCachingBackendImplProvider
{
  public abstract AnimatedDrawableCachingBackendImpl get(AnimatedDrawableBackend paramAnimatedDrawableBackend, AnimatedDrawableOptions paramAnimatedDrawableOptions);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\animated\impl\AnimatedDrawableCachingBackendImplProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */