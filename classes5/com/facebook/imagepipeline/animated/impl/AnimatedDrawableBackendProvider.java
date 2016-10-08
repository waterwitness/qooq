package com.facebook.imagepipeline.animated.impl;

import android.graphics.Rect;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;

public abstract interface AnimatedDrawableBackendProvider
{
  public abstract AnimatedDrawableBackend get(AnimatedImageResult paramAnimatedImageResult, Rect paramRect);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\animated\impl\AnimatedDrawableBackendProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */