package com.facebook.react.views.drawer.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public class DrawerClosedEvent
  extends Event<DrawerClosedEvent>
{
  public static final String EVENT_NAME = "topDrawerClosed";
  
  public DrawerClosedEvent(int paramInt, long paramLong)
  {
    super(paramInt, paramLong);
  }
  
  public void dispatch(RCTEventEmitter paramRCTEventEmitter)
  {
    paramRCTEventEmitter.receiveEvent(getViewTag(), getEventName(), Arguments.createMap());
  }
  
  public short getCoalescingKey()
  {
    return 0;
  }
  
  public String getEventName()
  {
    return "topDrawerClosed";
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\views\drawer\events\DrawerClosedEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */