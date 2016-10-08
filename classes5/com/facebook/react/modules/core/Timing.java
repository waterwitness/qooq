package com.facebook.react.modules.core;

import android.util.SparseArray;
import android.view.Choreographer.FrameCallback;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.common.SystemClock;
import com.facebook.react.uimanager.ReactChoreographer;
import com.facebook.react.uimanager.ReactChoreographer.CallbackType;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;

public final class Timing
  extends ReactContextBaseJavaModule
  implements LifecycleEventListener
{
  private final AtomicBoolean isPaused = new AtomicBoolean(true);
  private final FrameCallback mFrameCallback = new FrameCallback(null);
  private boolean mFrameCallbackPosted = false;
  @Nullable
  private JSTimersExecution mJSTimersModule;
  @Nullable
  private ReactChoreographer mReactChoreographer;
  private final Object mTimerGuard = new Object();
  private final SparseArray<Timer> mTimerIdsToTimers = new SparseArray();
  private final PriorityQueue<Timer> mTimers = new PriorityQueue(11, new Comparator()
  {
    public int compare(Timing.Timer paramAnonymousTimer1, Timing.Timer paramAnonymousTimer2)
    {
      long l = Timing.Timer.access$300(paramAnonymousTimer1) - Timing.Timer.access$300(paramAnonymousTimer2);
      if (l == 0L) {
        return 0;
      }
      if (l < 0L) {
        return -1;
      }
      return 1;
    }
  });
  
  public Timing(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
  }
  
  private void clearChoreographerCallback()
  {
    if (this.mFrameCallbackPosted)
    {
      ((ReactChoreographer)Assertions.assertNotNull(this.mReactChoreographer)).removeFrameCallback(ReactChoreographer.CallbackType.TIMERS_EVENTS, this.mFrameCallback);
      this.mFrameCallbackPosted = false;
    }
  }
  
  private void setChoreographerCallback()
  {
    if (!this.mFrameCallbackPosted)
    {
      ((ReactChoreographer)Assertions.assertNotNull(this.mReactChoreographer)).postFrameCallback(ReactChoreographer.CallbackType.TIMERS_EVENTS, this.mFrameCallback);
      this.mFrameCallbackPosted = true;
    }
  }
  
  @ReactMethod
  public void createTimer(int paramInt1, int paramInt2, double paramDouble, boolean paramBoolean)
  {
    long l = Math.max(0.0D, paramDouble - SystemClock.currentTimeMillis() + paramInt2);
    Timer localTimer = new Timer(paramInt1, SystemClock.nanoTime() / 1000000L + l, paramInt2, paramBoolean, null);
    synchronized (this.mTimerGuard)
    {
      this.mTimers.add(localTimer);
      this.mTimerIdsToTimers.put(paramInt1, localTimer);
      return;
    }
  }
  
  @ReactMethod
  public void deleteTimer(int paramInt)
  {
    synchronized (this.mTimerGuard)
    {
      Timer localTimer = (Timer)this.mTimerIdsToTimers.get(paramInt);
      if (localTimer != null)
      {
        this.mTimerIdsToTimers.remove(paramInt);
        this.mTimers.remove(localTimer);
      }
      return;
    }
  }
  
  public String getName()
  {
    return "RKTiming";
  }
  
  public void initialize()
  {
    this.mReactChoreographer = ReactChoreographer.getInstance();
    this.mJSTimersModule = ((JSTimersExecution)getReactApplicationContext().getCatalystInstance().getJSModule(JSTimersExecution.class));
    getReactApplicationContext().addLifecycleEventListener(this);
    setChoreographerCallback();
  }
  
  public void onCatalystInstanceDestroy()
  {
    clearChoreographerCallback();
  }
  
  public void onHostDestroy()
  {
    clearChoreographerCallback();
    getReactApplicationContext().removeLifecycleEventListener(this);
  }
  
  public void onHostPause()
  {
    this.isPaused.set(true);
    clearChoreographerCallback();
  }
  
  public void onHostResume()
  {
    this.isPaused.set(false);
    setChoreographerCallback();
  }
  
  private class FrameCallback
    implements Choreographer.FrameCallback
  {
    private FrameCallback() {}
    
    public void doFrame(long paramLong)
    {
      if (Timing.this.isPaused.get()) {
        return;
      }
      paramLong /= 1000000L;
      Object localObject4;
      Object localObject3;
      for (Object localObject1 = null;; localObject3 = localObject4)
      {
        Timing.Timer localTimer;
        synchronized (Timing.this.mTimerGuard)
        {
          if ((Timing.this.mTimers.isEmpty()) || (Timing.Timer.access$300((Timing.Timer)Timing.this.mTimers.peek()) >= paramLong)) {
            break;
          }
          localTimer = (Timing.Timer)Timing.this.mTimers.poll();
          localObject4 = localObject1;
          if (localObject1 == null) {
            localObject4 = Arguments.createArray();
          }
          ((WritableArray)localObject4).pushInt(Timing.Timer.access$400(localTimer));
          if (Timing.Timer.access$500(localTimer))
          {
            Timing.Timer.access$302(localTimer, Timing.Timer.access$600(localTimer) + paramLong);
            Timing.this.mTimers.add(localTimer);
            localObject1 = localObject4;
          }
        }
        Timing.this.mTimerIdsToTimers.remove(Timing.Timer.access$400(localTimer));
      }
      if (localObject3 != null) {
        ((JSTimersExecution)Assertions.assertNotNull(Timing.this.mJSTimersModule)).callTimers((WritableArray)localObject3);
      }
      ((ReactChoreographer)Assertions.assertNotNull(Timing.this.mReactChoreographer)).postFrameCallback(ReactChoreographer.CallbackType.TIMERS_EVENTS, this);
    }
  }
  
  private static class Timer
  {
    private final int mCallbackID;
    private final int mInterval;
    private final boolean mRepeat;
    private long mTargetTime;
    
    private Timer(int paramInt1, long paramLong, int paramInt2, boolean paramBoolean)
    {
      this.mCallbackID = paramInt1;
      this.mTargetTime = paramLong;
      this.mInterval = paramInt2;
      this.mRepeat = paramBoolean;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\modules\core\Timing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */