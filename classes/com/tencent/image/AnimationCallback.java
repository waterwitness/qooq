package com.tencent.image;

public abstract interface AnimationCallback
{
  public abstract void invalidateSelf();
  
  public abstract void scheduleSelf(Runnable paramRunnable, long paramLong);
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\image\AnimationCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */