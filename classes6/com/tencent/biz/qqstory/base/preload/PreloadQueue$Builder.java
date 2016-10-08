package com.tencent.biz.qqstory.base.preload;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class PreloadQueue$Builder
{
  protected int a;
  protected int b;
  protected int c;
  
  public PreloadQueue$Builder()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = 1;
    this.b = 0;
    this.c = Integer.MAX_VALUE;
  }
  
  public Builder a(int paramInt)
  {
    this.a = paramInt;
    return this;
  }
  
  public PreloadQueue a()
  {
    PreloadQueue localPreloadQueue = new PreloadQueue();
    localPreloadQueue.c = this.a;
    localPreloadQueue.d = this.b;
    localPreloadQueue.e = this.c;
    return localPreloadQueue;
  }
  
  public Builder b(int paramInt)
  {
    this.b = paramInt;
    return this;
  }
  
  public Builder c(int paramInt)
  {
    this.c = paramInt;
    return this;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\preload\PreloadQueue$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */