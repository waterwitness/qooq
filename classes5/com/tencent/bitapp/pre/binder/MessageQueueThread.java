package com.tencent.bitapp.pre.binder;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public abstract interface MessageQueueThread
{
  public abstract void assertIsOnThread();
  
  public abstract boolean isOnThread();
  
  @DoNotStrip
  public abstract void runOnQueue(Runnable paramRunnable);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\pre\binder\MessageQueueThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */