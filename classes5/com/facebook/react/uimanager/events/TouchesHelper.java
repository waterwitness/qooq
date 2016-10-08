package com.facebook.react.uimanager.events;

import android.view.MotionEvent;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.PixelUtil;

class TouchesHelper
{
  private static final String LOCATION_X_KEY = "locationX";
  private static final String LOCATION_Y_KEY = "locationY";
  private static final String PAGE_X_KEY = "pageX";
  private static final String PAGE_Y_KEY = "pageY";
  private static final String POINTER_IDENTIFIER_KEY = "identifier";
  private static final String TARGET_KEY = "target";
  private static final String TIMESTAMP_KEY = "timeStamp";
  
  private static WritableArray createsPointersArray(int paramInt, TouchEvent paramTouchEvent)
  {
    WritableArray localWritableArray = Arguments.createArray();
    MotionEvent localMotionEvent = paramTouchEvent.getMotionEvent();
    float f1 = localMotionEvent.getX();
    float f2 = paramTouchEvent.getViewX();
    float f3 = localMotionEvent.getY();
    float f4 = paramTouchEvent.getViewY();
    int i = 0;
    while (i < localMotionEvent.getPointerCount())
    {
      paramTouchEvent = Arguments.createMap();
      paramTouchEvent.putDouble("pageX", PixelUtil.toDIPFromPixel(localMotionEvent.getX(i)));
      paramTouchEvent.putDouble("pageY", PixelUtil.toDIPFromPixel(localMotionEvent.getY(i)));
      float f5 = localMotionEvent.getX(i);
      float f6 = localMotionEvent.getY(i);
      paramTouchEvent.putDouble("locationX", PixelUtil.toDIPFromPixel(f5 - (f1 - f2)));
      paramTouchEvent.putDouble("locationY", PixelUtil.toDIPFromPixel(f6 - (f3 - f4)));
      paramTouchEvent.putInt("target", paramInt);
      paramTouchEvent.putDouble("timeStamp", localMotionEvent.getEventTime());
      paramTouchEvent.putDouble("identifier", localMotionEvent.getPointerId(i));
      localWritableArray.pushMap(paramTouchEvent);
      i += 1;
    }
    return localWritableArray;
  }
  
  public static void sendTouchEvent(RCTEventEmitter paramRCTEventEmitter, TouchEventType paramTouchEventType, int paramInt, TouchEvent paramTouchEvent)
  {
    WritableArray localWritableArray1 = createsPointersArray(paramInt, paramTouchEvent);
    paramTouchEvent = paramTouchEvent.getMotionEvent();
    WritableArray localWritableArray2 = Arguments.createArray();
    if ((paramTouchEventType == TouchEventType.MOVE) || (paramTouchEventType == TouchEventType.CANCEL)) {
      paramInt = 0;
    }
    while (paramInt < paramTouchEvent.getPointerCount())
    {
      localWritableArray2.pushInt(paramInt);
      paramInt += 1;
      continue;
      if ((paramTouchEventType != TouchEventType.START) && (paramTouchEventType != TouchEventType.END)) {
        break label96;
      }
      localWritableArray2.pushInt(paramTouchEvent.getActionIndex());
    }
    paramRCTEventEmitter.receiveTouches(paramTouchEventType.getJSEventName(), localWritableArray1, localWritableArray2);
    return;
    label96:
    throw new RuntimeException("Unknown touch type: " + paramTouchEventType);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\uimanager\events\TouchesHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */