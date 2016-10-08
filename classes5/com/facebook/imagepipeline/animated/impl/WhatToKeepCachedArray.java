package com.facebook.imagepipeline.animated.impl;

import com.facebook.imagepipeline.animated.util.AnimatedDrawableUtil;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
class WhatToKeepCachedArray
{
  private final boolean[] mData;
  
  WhatToKeepCachedArray(int paramInt)
  {
    this.mData = new boolean[paramInt];
  }
  
  boolean get(int paramInt)
  {
    return this.mData[paramInt];
  }
  
  void removeOutsideRange(int paramInt1, int paramInt2)
  {
    int i = 0;
    for (;;)
    {
      if (i >= this.mData.length) {
        return;
      }
      if (AnimatedDrawableUtil.isOutsideRange(paramInt1, paramInt2, i)) {
        this.mData[i] = false;
      }
      i += 1;
    }
  }
  
  void set(int paramInt, boolean paramBoolean)
  {
    this.mData[paramInt] = paramBoolean;
  }
  
  void setAll(boolean paramBoolean)
  {
    int i = 0;
    for (;;)
    {
      if (i >= this.mData.length) {
        return;
      }
      this.mData[i] = paramBoolean;
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\animated\impl\WhatToKeepCachedArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */