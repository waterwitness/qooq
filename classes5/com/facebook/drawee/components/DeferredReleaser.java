package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.internal.Preconditions;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DeferredReleaser
{
  private static DeferredReleaser sInstance = null;
  private final Set<Releasable> mPendingReleasables = new HashSet();
  private final Handler mUiHandler = new Handler(Looper.getMainLooper());
  private final Runnable releaseRunnable = new Runnable()
  {
    public void run()
    {
      DeferredReleaser.access$0();
      Iterator localIterator = DeferredReleaser.this.mPendingReleasables.iterator();
      for (;;)
      {
        if (!localIterator.hasNext())
        {
          DeferredReleaser.this.mPendingReleasables.clear();
          return;
        }
        ((DeferredReleaser.Releasable)localIterator.next()).release();
      }
    }
  };
  
  private static void ensureOnUiThread()
  {
    if (Looper.getMainLooper().getThread() == Thread.currentThread()) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool);
      return;
    }
  }
  
  public static DeferredReleaser getInstance()
  {
    try
    {
      if (sInstance == null) {
        sInstance = new DeferredReleaser();
      }
      DeferredReleaser localDeferredReleaser = sInstance;
      return localDeferredReleaser;
    }
    finally {}
  }
  
  public void cancelDeferredRelease(Releasable paramReleasable)
  {
    ensureOnUiThread();
    this.mPendingReleasables.remove(paramReleasable);
  }
  
  public void scheduleDeferredRelease(Releasable paramReleasable)
  {
    
    if (!this.mPendingReleasables.add(paramReleasable)) {}
    while (this.mPendingReleasables.size() != 1) {
      return;
    }
    this.mUiHandler.post(this.releaseRunnable);
  }
  
  public static abstract interface Releasable
  {
    public abstract void release();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\drawee\components\DeferredReleaser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */