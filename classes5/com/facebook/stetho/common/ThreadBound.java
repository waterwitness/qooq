package com.facebook.stetho.common;

public abstract interface ThreadBound
{
  public abstract boolean checkThreadAccess();
  
  public abstract <V> V postAndWait(UncheckedCallable<V> paramUncheckedCallable);
  
  public abstract void postAndWait(Runnable paramRunnable);
  
  public abstract void postDelayed(Runnable paramRunnable, long paramLong);
  
  public abstract void removeCallbacks(Runnable paramRunnable);
  
  public abstract void verifyThreadAccess();
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\common\ThreadBound.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */