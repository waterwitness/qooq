package com.facebook.react.views.image;

import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class ImageLoadEvent
  extends Event<ImageLoadEvent>
{
  public static final int ON_ERROR = 1;
  public static final int ON_LOAD = 2;
  public static final int ON_LOAD_END = 3;
  public static final int ON_LOAD_START = 4;
  public static final int ON_PROGRESS = 5;
  private final int mEventType;
  
  public ImageLoadEvent(int paramInt1, long paramLong, int paramInt2)
  {
    super(paramInt1, paramLong);
    this.mEventType = paramInt2;
  }
  
  public static String eventNameForType(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalStateException("Invalid image event: " + Integer.toString(paramInt));
    case 1: 
      return "topError";
    case 2: 
      return "topLoad";
    case 3: 
      return "topLoadEnd";
    case 4: 
      return "topLoadStart";
    }
    return "topProgress";
  }
  
  public void dispatch(RCTEventEmitter paramRCTEventEmitter)
  {
    paramRCTEventEmitter.receiveEvent(getViewTag(), getEventName(), null);
  }
  
  public short getCoalescingKey()
  {
    return (short)this.mEventType;
  }
  
  public String getEventName()
  {
    return eventNameForType(this.mEventType);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  static @interface ImageEventType {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\views\image\ImageLoadEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */