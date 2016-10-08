package com.facebook.react.uimanager.events;

import android.view.MotionEvent;
import com.facebook.infer.annotation.Assertions;
import fb.support.v4.util.Pools.SynchronizedPool;
import javax.annotation.Nullable;

public class TouchEvent
  extends Event<TouchEvent>
{
  private static final Pools.SynchronizedPool<TouchEvent> EVENTS_POOL = new Pools.SynchronizedPool(3);
  private static final int TOUCH_EVENTS_POOL_SIZE = 3;
  private short mCoalescingKey;
  @Nullable
  private MotionEvent mMotionEvent;
  @Nullable
  private TouchEventType mTouchEventType;
  private float mViewX;
  private float mViewY;
  
  private void init(int paramInt, long paramLong, TouchEventType paramTouchEventType, MotionEvent paramMotionEvent, float paramFloat1, float paramFloat2)
  {
    super.init(paramInt, paramLong);
    short s = 0;
    paramInt = paramMotionEvent.getAction() & 0xFF;
    switch (paramInt)
    {
    case 4: 
    default: 
      throw new RuntimeException("Unhandled MotionEvent action: " + paramInt);
    case 0: 
      TouchEventCoalescingKeyHelper.addCoalescingKey(paramMotionEvent.getDownTime());
    }
    for (;;)
    {
      this.mTouchEventType = paramTouchEventType;
      this.mMotionEvent = MotionEvent.obtain(paramMotionEvent);
      this.mCoalescingKey = s;
      this.mViewX = paramFloat1;
      this.mViewY = paramFloat2;
      return;
      TouchEventCoalescingKeyHelper.removeCoalescingKey(paramMotionEvent.getDownTime());
      continue;
      TouchEventCoalescingKeyHelper.incrementCoalescingKey(paramMotionEvent.getDownTime());
      continue;
      s = TouchEventCoalescingKeyHelper.getCoalescingKey(paramMotionEvent.getDownTime());
      continue;
      TouchEventCoalescingKeyHelper.removeCoalescingKey(paramMotionEvent.getDownTime());
    }
  }
  
  public static TouchEvent obtain(int paramInt, long paramLong, TouchEventType paramTouchEventType, MotionEvent paramMotionEvent, float paramFloat1, float paramFloat2)
  {
    TouchEvent localTouchEvent2 = (TouchEvent)EVENTS_POOL.acquire();
    TouchEvent localTouchEvent1 = localTouchEvent2;
    if (localTouchEvent2 == null) {
      localTouchEvent1 = new TouchEvent();
    }
    localTouchEvent1.init(paramInt, paramLong, paramTouchEventType, paramMotionEvent, paramFloat1, paramFloat2);
    return localTouchEvent1;
  }
  
  public boolean canCoalesce()
  {
    switch ((TouchEventType)Assertions.assertNotNull(this.mTouchEventType))
    {
    default: 
      throw new RuntimeException("Unknown touch event type: " + this.mTouchEventType);
    case ???: 
    case ???: 
    case ???: 
      return false;
    }
    return true;
  }
  
  public void dispatch(RCTEventEmitter paramRCTEventEmitter)
  {
    TouchesHelper.sendTouchEvent(paramRCTEventEmitter, (TouchEventType)Assertions.assertNotNull(this.mTouchEventType), getViewTag(), this);
  }
  
  public short getCoalescingKey()
  {
    return this.mCoalescingKey;
  }
  
  public String getEventName()
  {
    return ((TouchEventType)Assertions.assertNotNull(this.mTouchEventType)).getJSEventName();
  }
  
  public MotionEvent getMotionEvent()
  {
    Assertions.assertNotNull(this.mMotionEvent);
    return this.mMotionEvent;
  }
  
  public float getViewX()
  {
    return this.mViewX;
  }
  
  public float getViewY()
  {
    return this.mViewY;
  }
  
  public void onDispose()
  {
    ((MotionEvent)Assertions.assertNotNull(this.mMotionEvent)).recycle();
    this.mMotionEvent = null;
    EVENTS_POOL.release(this);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\uimanager\events\TouchEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */