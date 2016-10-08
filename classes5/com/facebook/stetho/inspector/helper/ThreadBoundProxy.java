package com.facebook.stetho.inspector.helper;

import com.facebook.stetho.common.ThreadBound;
import com.facebook.stetho.common.UncheckedCallable;
import com.facebook.stetho.common.Util;

public abstract class ThreadBoundProxy
  implements ThreadBound
{
  private final ThreadBound mEnforcer;
  
  public ThreadBoundProxy(ThreadBound paramThreadBound)
  {
    this.mEnforcer = ((ThreadBound)Util.throwIfNull(paramThreadBound));
  }
  
  public final boolean checkThreadAccess()
  {
    return this.mEnforcer.checkThreadAccess();
  }
  
  public final <V> V postAndWait(UncheckedCallable<V> paramUncheckedCallable)
  {
    return (V)this.mEnforcer.postAndWait(paramUncheckedCallable);
  }
  
  public final void postAndWait(Runnable paramRunnable)
  {
    this.mEnforcer.postAndWait(paramRunnable);
  }
  
  public final void postDelayed(Runnable paramRunnable, long paramLong)
  {
    this.mEnforcer.postDelayed(paramRunnable, paramLong);
  }
  
  public final void removeCallbacks(Runnable paramRunnable)
  {
    this.mEnforcer.removeCallbacks(paramRunnable);
  }
  
  public final void verifyThreadAccess()
  {
    this.mEnforcer.verifyThreadAccess();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\inspector\helper\ThreadBoundProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */