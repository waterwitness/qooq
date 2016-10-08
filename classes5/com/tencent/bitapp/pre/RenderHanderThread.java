package com.tencent.bitapp.pre;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.UiThreadUtil;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public enum RenderHanderThread
{
  INSTANCE;
  
  private static final String TAG = "RenderHanderThread";
  private static final int TIME_DELAY = 16;
  private Set<IRenderListener> list = new HashSet();
  private Handler mHandler;
  private HandlerThread mHandlerThread;
  private final Object mLock = new Object();
  private Runnable mRunnable = null;
  
  private RenderHanderThread() {}
  
  public void addListener(IRenderListener paramIRenderListener)
  {
    if (paramIRenderListener == null)
    {
      if (FLog.isLoggable(4)) {
        FLog.i("RenderHanderThread", "callback must not be null");
      }
      return;
    }
    synchronized (this.mLock)
    {
      this.list.add(paramIRenderListener);
      return;
    }
  }
  
  public void removeListener(IRenderListener paramIRenderListener)
  {
    if (paramIRenderListener == null)
    {
      if (FLog.isLoggable(4)) {
        FLog.i("RenderHanderThread", "callback must not be null");
      }
      return;
    }
    synchronized (this.mLock)
    {
      this.list.remove(paramIRenderListener);
      return;
    }
  }
  
  public void start(int paramInt)
  {
    if (this.mHandlerThread == null)
    {
      this.mHandlerThread = new HandlerThread("RenderHanderThread");
      this.mHandlerThread.start();
      this.mHandler = new Handler(this.mHandlerThread.getLooper());
      this.mRunnable = new Runnable()
      {
        private final RenderHanderThread.RenderTask task = new RenderHanderThread.RenderTask(RenderHanderThread.this);
        
        public void run()
        {
          if (RenderHanderThread.this.mHandler != null) {
            synchronized (RenderHanderThread.this.mLock)
            {
              UiThreadUtil.runOnUiThread(this.task);
              if ((RenderHanderThread.this.mHandler != null) && (RenderHanderThread.this.mRunnable != null)) {
                RenderHanderThread.this.mHandler.postDelayed(RenderHanderThread.this.mRunnable, 16L);
              }
              return;
            }
          }
          Log.e("RenderHanderThread", "mHandler is null");
        }
      };
      this.mHandler.post(this.mRunnable);
    }
  }
  
  public void stop(int paramInt)
  {
    if (this.mHandler != null)
    {
      this.mHandler.removeCallbacks(this.mRunnable);
      this.mHandler = null;
    }
    if (this.mHandlerThread != null)
    {
      this.mHandlerThread.quit();
      this.mHandlerThread = null;
    }
    if (this.mRunnable != null) {
      this.mRunnable = null;
    }
  }
  
  public static abstract interface IRenderListener
  {
    public abstract void doFrame(long paramLong);
  }
  
  private static class RenderTask
    implements Runnable
  {
    private WeakReference<RenderHanderThread> mReference;
    
    public RenderTask(RenderHanderThread paramRenderHanderThread)
    {
      this.mReference = new WeakReference(paramRenderHanderThread);
    }
    
    public void run()
    {
      Object localObject = (RenderHanderThread)this.mReference.get();
      if ((localObject != null) && (((RenderHanderThread)localObject).list != null))
      {
        long l = System.nanoTime();
        localObject = ((RenderHanderThread)localObject).list.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((RenderHanderThread.IRenderListener)((Iterator)localObject).next()).doFrame(l);
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\pre\RenderHanderThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */