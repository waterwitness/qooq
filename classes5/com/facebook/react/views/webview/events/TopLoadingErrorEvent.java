package com.facebook.react.views.webview.events;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public class TopLoadingErrorEvent
  extends Event<TopLoadingErrorEvent>
{
  public static final String EVENT_NAME = "topLoadingError";
  private WritableMap mEventData;
  
  public TopLoadingErrorEvent(int paramInt, long paramLong, WritableMap paramWritableMap)
  {
    super(paramInt, paramLong);
    this.mEventData = paramWritableMap;
  }
  
  public boolean canCoalesce()
  {
    return false;
  }
  
  public void dispatch(RCTEventEmitter paramRCTEventEmitter)
  {
    paramRCTEventEmitter.receiveEvent(getViewTag(), getEventName(), this.mEventData);
  }
  
  public short getCoalescingKey()
  {
    return 0;
  }
  
  public String getEventName()
  {
    return "topLoadingError";
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\views\webview\events\TopLoadingErrorEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */