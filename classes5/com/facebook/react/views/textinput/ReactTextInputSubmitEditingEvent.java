package com.facebook.react.views.textinput;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

class ReactTextInputSubmitEditingEvent
  extends Event<ReactTextInputSubmitEditingEvent>
{
  private static final String EVENT_NAME = "topSubmitEditing";
  private String mText;
  
  public ReactTextInputSubmitEditingEvent(int paramInt, long paramLong, String paramString)
  {
    super(paramInt, paramLong);
    this.mText = paramString;
  }
  
  private WritableMap serializeEventData()
  {
    WritableMap localWritableMap = Arguments.createMap();
    localWritableMap.putInt("target", getViewTag());
    localWritableMap.putString("text", this.mText);
    return localWritableMap;
  }
  
  public boolean canCoalesce()
  {
    return false;
  }
  
  public void dispatch(RCTEventEmitter paramRCTEventEmitter)
  {
    paramRCTEventEmitter.receiveEvent(getViewTag(), getEventName(), serializeEventData());
  }
  
  public String getEventName()
  {
    return "topSubmitEditing";
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\views\textinput\ReactTextInputSubmitEditingEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */