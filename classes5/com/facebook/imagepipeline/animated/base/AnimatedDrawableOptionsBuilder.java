package com.facebook.imagepipeline.animated.base;

public class AnimatedDrawableOptionsBuilder
{
  private boolean mAllowPrefetching = true;
  private boolean mEnableDebugging;
  private boolean mForceKeepAllFramesInMemory;
  private int mMaximumBytes = -1;
  
  public AnimatedDrawableOptions build()
  {
    return new AnimatedDrawableOptions(this);
  }
  
  public boolean getAllowPrefetching()
  {
    return this.mAllowPrefetching;
  }
  
  public boolean getEnableDebugging()
  {
    return this.mEnableDebugging;
  }
  
  public boolean getForceKeepAllFramesInMemory()
  {
    return this.mForceKeepAllFramesInMemory;
  }
  
  public int getMaximumBytes()
  {
    return this.mMaximumBytes;
  }
  
  public AnimatedDrawableOptionsBuilder setAllowPrefetching(boolean paramBoolean)
  {
    this.mAllowPrefetching = paramBoolean;
    return this;
  }
  
  public AnimatedDrawableOptionsBuilder setEnableDebugging(boolean paramBoolean)
  {
    this.mEnableDebugging = paramBoolean;
    return this;
  }
  
  public AnimatedDrawableOptionsBuilder setForceKeepAllFramesInMemory(boolean paramBoolean)
  {
    this.mForceKeepAllFramesInMemory = paramBoolean;
    return this;
  }
  
  public AnimatedDrawableOptionsBuilder setMaximumBytes(int paramInt)
  {
    this.mMaximumBytes = paramInt;
    return this;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\animated\base\AnimatedDrawableOptionsBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */