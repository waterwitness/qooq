package com.facebook.react.uimanager.events;

import android.util.LongSparseArray;
import android.view.Choreographer.FrameCallback;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ReactChoreographer;
import com.facebook.react.uimanager.ReactChoreographer.CallbackType;
import com.facebook.systrace.Systrace;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import javax.annotation.Nullable;

public class EventDispatcher
  implements LifecycleEventListener
{
  private static final Comparator<Event> EVENT_COMPARATOR = new Comparator()
  {
    public int compare(Event paramAnonymousEvent1, Event paramAnonymousEvent2)
    {
      if ((paramAnonymousEvent1 == null) && (paramAnonymousEvent2 == null)) {}
      long l;
      do
      {
        return 0;
        if (paramAnonymousEvent1 == null) {
          return -1;
        }
        if (paramAnonymousEvent2 == null) {
          return 1;
        }
        l = paramAnonymousEvent1.getTimestampMs() - paramAnonymousEvent2.getTimestampMs();
      } while (l == 0L);
      if (l < 0L) {
        return -1;
      }
      return 1;
    }
  };
  @Nullable
  private volatile ScheduleDispatchFrameCallback mCurrentFrameCallback;
  private final DispatchEventsRunnable mDispatchEventsRunnable = new DispatchEventsRunnable(null);
  private final LongSparseArray<Integer> mEventCookieToLastEventIdx = new LongSparseArray();
  private final Map<String, Short> mEventNameToEventId = MapBuilder.newHashMap();
  private final ArrayList<Event> mEventStaging = new ArrayList();
  private final Object mEventsStagingLock = new Object();
  private Event[] mEventsToDispatch = new Event[16];
  private final Object mEventsToDispatchLock = new Object();
  private int mEventsToDispatchSize = 0;
  private volatile boolean mHasDispatchScheduled = false;
  private short mNextEventTypeId = 0;
  @Nullable
  private RCTEventEmitter mRCTEventEmitter;
  private final WeakReference<ReactApplicationContext> mReactContext;
  
  public EventDispatcher(ReactApplicationContext paramReactApplicationContext)
  {
    this.mReactContext = new WeakReference(paramReactApplicationContext);
    paramReactApplicationContext.addLifecycleEventListener(this);
  }
  
  private void addEventToEventsToDispatch(Event paramEvent)
  {
    if (this.mEventsToDispatchSize == this.mEventsToDispatch.length) {
      this.mEventsToDispatch = ((Event[])Arrays.copyOf(this.mEventsToDispatch, this.mEventsToDispatch.length * 2));
    }
    Event[] arrayOfEvent = this.mEventsToDispatch;
    int i = this.mEventsToDispatchSize;
    this.mEventsToDispatchSize = (i + 1);
    arrayOfEvent[i] = paramEvent;
  }
  
  private void clearEventsToDispatch()
  {
    Arrays.fill(this.mEventsToDispatch, 0, this.mEventsToDispatchSize, null);
    this.mEventsToDispatchSize = 0;
  }
  
  private void clearFrameCallback()
  {
    
    if (this.mCurrentFrameCallback != null)
    {
      this.mCurrentFrameCallback.stop();
      this.mCurrentFrameCallback = null;
    }
  }
  
  private long getEventCookie(int paramInt, String paramString, short paramShort)
  {
    Short localShort = (Short)this.mEventNameToEventId.get(paramString);
    short s;
    if (localShort != null) {
      s = localShort.shortValue();
    }
    for (;;)
    {
      return getEventCookie(paramInt, s, paramShort);
      s = this.mNextEventTypeId;
      this.mNextEventTypeId = ((short)(s + 1));
      this.mEventNameToEventId.put(paramString, Short.valueOf(s));
    }
  }
  
  private static long getEventCookie(int paramInt, short paramShort1, short paramShort2)
  {
    return paramInt | (paramShort1 & 0xFFFF) << 32 | (paramShort2 & 0xFFFF) << 48;
  }
  
  private void moveStagedEventsToDispatchQueue()
  {
    for (;;)
    {
      Object localObject7;
      int i;
      long l;
      Object localObject5;
      Integer localInteger;
      synchronized (this.mEventsStagingLock)
      {
        localObject7 = this.mEventsToDispatchLock;
        i = 0;
        try
        {
          if (i >= this.mEventStaging.size()) {
            break label207;
          }
          Event localEvent1 = (Event)this.mEventStaging.get(i);
          if (!localEvent1.canCoalesce())
          {
            addEventToEventsToDispatch(localEvent1);
          }
          else
          {
            l = getEventCookie(localEvent1.getViewTag(), localEvent1.getEventName(), localEvent1.getCoalescingKey());
            localObject5 = null;
            localObject4 = null;
            localInteger = (Integer)this.mEventCookieToLastEventIdx.get(l);
            if (localInteger == null)
            {
              this.mEventCookieToLastEventIdx.put(l, Integer.valueOf(this.mEventsToDispatchSize));
              if (localEvent1 != null) {
                addEventToEventsToDispatch(localEvent1);
              }
              if (localObject4 == null) {
                break label221;
              }
              ((Event)localObject4).dispose();
            }
          }
        }
        finally {}
      }
      Object localObject4 = this.mEventsToDispatch[localInteger.intValue()];
      Event localEvent2 = ((Event)localObject2).coalesce((Event)localObject4);
      Object localObject3;
      if (localEvent2 != localObject4)
      {
        localObject3 = localEvent2;
        this.mEventCookieToLastEventIdx.put(l, Integer.valueOf(this.mEventsToDispatchSize));
        this.mEventsToDispatch[localInteger.intValue()] = null;
        continue;
        label207:
        this.mEventStaging.clear();
        return;
        label221:
        i += 1;
      }
      else
      {
        localObject4 = localObject3;
        localObject3 = localObject5;
      }
    }
  }
  
  public void dispatchEvent(Event paramEvent)
  {
    if (!paramEvent.isInitialized())
    {
      if (FLog.isLoggable(6)) {
        FLog.e("Exception", "Dispatched event hasn't been initialized");
      }
      return;
    }
    synchronized (this.mEventsStagingLock)
    {
      this.mEventStaging.add(paramEvent);
      return;
    }
  }
  
  public void onCatalystInstanceDestroyed()
  {
    clearFrameCallback();
  }
  
  public void onHostDestroy()
  {
    clearFrameCallback();
    ReactContext localReactContext = (ReactContext)this.mReactContext.get();
    if (localReactContext != null) {
      localReactContext.removeLifecycleEventListener(this);
    }
  }
  
  public void onHostPause()
  {
    clearFrameCallback();
  }
  
  public void onHostResume()
  {
    
    if (this.mCurrentFrameCallback == null) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.assumeCondition(bool);
      if (this.mRCTEventEmitter == null)
      {
        ReactApplicationContext localReactApplicationContext = (ReactApplicationContext)this.mReactContext.get();
        if (localReactApplicationContext != null) {
          this.mRCTEventEmitter = ((RCTEventEmitter)localReactApplicationContext.getJSModule(RCTEventEmitter.class));
        }
      }
      this.mCurrentFrameCallback = new ScheduleDispatchFrameCallback(this);
      ReactChoreographer.getInstance().postFrameCallback(ReactChoreographer.CallbackType.TIMERS_EVENTS, this.mCurrentFrameCallback);
      return;
    }
  }
  
  private class DispatchEventsRunnable
    implements Runnable
  {
    private DispatchEventsRunnable() {}
    
    public void run()
    {
      Systrace.beginSection(0L, "DispatchEventsRunnable");
      for (;;)
      {
        try
        {
          EventDispatcher.access$202(EventDispatcher.this, false);
          Assertions.assertNotNull(EventDispatcher.this.mRCTEventEmitter);
          synchronized (EventDispatcher.this.mEventsToDispatchLock)
          {
            if (EventDispatcher.this.mEventsToDispatchSize <= 1) {
              break label153;
            }
            Arrays.sort(EventDispatcher.this.mEventsToDispatch, 0, EventDispatcher.this.mEventsToDispatchSize, EventDispatcher.EVENT_COMPARATOR);
            break label153;
            if (i < EventDispatcher.this.mEventsToDispatchSize)
            {
              Event localEvent = EventDispatcher.this.mEventsToDispatch[i];
              if (localEvent == null) {
                break label158;
              }
              localEvent.dispatch(EventDispatcher.this.mRCTEventEmitter);
              localEvent.dispose();
            }
          }
          EventDispatcher.this.clearEventsToDispatch();
        }
        finally
        {
          Systrace.endSection(0L);
        }
        EventDispatcher.this.mEventCookieToLastEventIdx.clear();
        Systrace.endSection(0L);
        return;
        label153:
        int i = 0;
        continue;
        label158:
        i += 1;
      }
    }
  }
  
  private static class ScheduleDispatchFrameCallback
    implements Choreographer.FrameCallback
  {
    private WeakReference<EventDispatcher> mEventReference;
    private boolean mShouldStop = false;
    
    public ScheduleDispatchFrameCallback(EventDispatcher paramEventDispatcher)
    {
      this.mEventReference = new WeakReference(paramEventDispatcher);
    }
    
    public void doFrame(long paramLong)
    {
      
      if (this.mShouldStop) {}
      EventDispatcher localEventDispatcher;
      do
      {
        return;
        localEventDispatcher = (EventDispatcher)this.mEventReference.get();
      } while (localEventDispatcher == null);
      Systrace.beginSection(0L, "ScheduleDispatchFrameCallback");
      try
      {
        localEventDispatcher.moveStagedEventsToDispatchQueue();
        if (!localEventDispatcher.mHasDispatchScheduled)
        {
          EventDispatcher.access$202(localEventDispatcher, true);
          ReactApplicationContext localReactApplicationContext = (ReactApplicationContext)localEventDispatcher.mReactContext.get();
          if (localReactApplicationContext != null) {
            localReactApplicationContext.runOnJSQueueThread(localEventDispatcher.mDispatchEventsRunnable);
          }
        }
        ReactChoreographer.getInstance().postFrameCallback(ReactChoreographer.CallbackType.TIMERS_EVENTS, this);
        return;
      }
      finally
      {
        Systrace.endSection(0L);
      }
    }
    
    public void stop()
    {
      this.mShouldStop = true;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\uimanager\events\EventDispatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */