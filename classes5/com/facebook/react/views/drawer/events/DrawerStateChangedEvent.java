package com.facebook.react.views.drawer.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public class DrawerStateChangedEvent
  extends Event<DrawerStateChangedEvent>
{
  public static final String EVENT_NAME = "topDrawerStateChanged";
  private final int mDrawerState;
  
  public DrawerStateChangedEvent(int paramInt1, long paramLong, int paramInt2)
  {
    super(paramInt1, paramLong);
    this.mDrawerState = paramInt2;
  }
  
  private WritableMap serializeEventData()
  {
    WritableMap localWritableMap = Arguments.createMap();
    localWritableMap.putDouble("drawerState", getDrawerState());
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
  
  public int getDrawerState()
  {
    return this.mDrawerState;
  }
  
  public String getEventName()
  {
    return "topDrawerStateChanged";
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\views\drawer\events\DrawerStateChangedEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */