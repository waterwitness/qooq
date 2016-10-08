package com.facebook.react.views.drawer.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public class DrawerSlideEvent
  extends Event<DrawerSlideEvent>
{
  public static final String EVENT_NAME = "topDrawerSlide";
  private final float mOffset;
  
  public DrawerSlideEvent(int paramInt, long paramLong, float paramFloat)
  {
    super(paramInt, paramLong);
    this.mOffset = paramFloat;
  }
  
  private WritableMap serializeEventData()
  {
    WritableMap localWritableMap = Arguments.createMap();
    localWritableMap.putDouble("offset", getOffset());
    return localWritableMap;
  }
  
  public void dispatch(RCTEventEmitter paramRCTEventEmitter)
  {
    paramRCTEventEmitter.receiveEvent(getViewTag(), getEventName(), serializeEventData());
  }
  
  public short getCoalescingKey()
  {
    return 0;
  }
  
  public String getEventName()
  {
    return "topDrawerSlide";
  }
  
  public float getOffset()
  {
    return this.mOffset;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\views\drawer\events\DrawerSlideEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */