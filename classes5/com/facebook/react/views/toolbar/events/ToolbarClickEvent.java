package com.facebook.react.views.toolbar.events;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.tencent.bitapp.pre.binder.server.proxy.jni.WritableNativeMap;

public class ToolbarClickEvent
  extends Event<ToolbarClickEvent>
{
  private static final String EVENT_NAME = "topSelect";
  private final int position;
  
  public ToolbarClickEvent(int paramInt1, long paramLong, int paramInt2)
  {
    super(paramInt1, paramLong);
    this.position = paramInt2;
  }
  
  public boolean canCoalesce()
  {
    return false;
  }
  
  public void dispatch(RCTEventEmitter paramRCTEventEmitter)
  {
    WritableNativeMap localWritableNativeMap = new WritableNativeMap();
    localWritableNativeMap.putInt("position", getPosition());
    paramRCTEventEmitter.receiveEvent(getViewTag(), getEventName(), localWritableNativeMap);
  }
  
  public String getEventName()
  {
    return "topSelect";
  }
  
  public int getPosition()
  {
    return this.position;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\views\toolbar\events\ToolbarClickEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */