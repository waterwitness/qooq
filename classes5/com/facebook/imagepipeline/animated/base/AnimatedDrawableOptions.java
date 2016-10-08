package com.facebook.imagepipeline.animated.base;

import javax.annotation.concurrent.Immutable;

@Immutable
public class AnimatedDrawableOptions
{
  public static AnimatedDrawableOptions DEFAULTS = newBuilder().build();
  public final boolean allowPrefetching;
  public final boolean enableDebugging;
  public final boolean forceKeepAllFramesInMemory;
  public final int maximumBytes;
  
  public AnimatedDrawableOptions(AnimatedDrawableOptionsBuilder paramAnimatedDrawableOptionsBuilder)
  {
    this.forceKeepAllFramesInMemory = paramAnimatedDrawableOptionsBuilder.getForceKeepAllFramesInMemory();
    this.allowPrefetching = paramAnimatedDrawableOptionsBuilder.getAllowPrefetching();
    this.maximumBytes = paramAnimatedDrawableOptionsBuilder.getMaximumBytes();
    this.enableDebugging = paramAnimatedDrawableOptionsBuilder.getEnableDebugging();
  }
  
  public static AnimatedDrawableOptionsBuilder newBuilder()
  {
    return new AnimatedDrawableOptionsBuilder();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\animated\base\AnimatedDrawableOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */