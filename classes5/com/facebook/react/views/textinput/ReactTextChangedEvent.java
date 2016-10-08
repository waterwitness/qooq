package com.facebook.react.views.textinput;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public class ReactTextChangedEvent
  extends Event<ReactTextChangedEvent>
{
  public static final String EVENT_NAME = "topChange";
  private int mContentHeight;
  private int mContentWidth;
  private int mEventCount;
  private String mText;
  
  public ReactTextChangedEvent(int paramInt1, long paramLong, String paramString, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramLong);
    this.mText = paramString;
    this.mContentWidth = paramInt2;
    this.mContentHeight = paramInt3;
    this.mEventCount = paramInt4;
  }
  
  private WritableMap serializeEventData()
  {
    WritableMap localWritableMap1 = Arguments.createMap();
    localWritableMap1.putString("text", this.mText);
    WritableMap localWritableMap2 = Arguments.createMap();
    localWritableMap2.putDouble("width", this.mContentWidth);
    localWritableMap2.putDouble("height", this.mContentHeight);
    localWritableMap1.putMap("contentSize", localWritableMap2);
    localWritableMap1.putInt("eventCount", this.mEventCount);
    localWritableMap1.putInt("target", getViewTag());
    return localWritableMap1;
  }
  
  public void dispatch(RCTEventEmitter paramRCTEventEmitter)
  {
    paramRCTEventEmitter.receiveEvent(getViewTag(), getEventName(), serializeEventData());
  }
  
  public String getEventName()
  {
    return "topChange";
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\views\textinput\ReactTextChangedEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */