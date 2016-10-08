package com.facebook.react.views.scroll;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import fb.support.v4.util.Pools.SynchronizedPool;

public class ScrollEvent
  extends Event<ScrollEvent>
{
  private static final Pools.SynchronizedPool<ScrollEvent> EVENTS_POOL = new Pools.SynchronizedPool(3);
  public static final String EVENT_NAME = "topScroll";
  private int mContentHeight;
  private int mContentWidth;
  private int mScrollViewHeight;
  private int mScrollViewWidth;
  private int mScrollX;
  private int mScrollY;
  
  private void init(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    super.init(paramInt1, paramLong);
    this.mScrollX = paramInt2;
    this.mScrollY = paramInt3;
    this.mContentWidth = paramInt4;
    this.mContentHeight = paramInt5;
    this.mScrollViewWidth = paramInt6;
    this.mScrollViewHeight = paramInt7;
  }
  
  public static ScrollEvent obtain(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    ScrollEvent localScrollEvent2 = (ScrollEvent)EVENTS_POOL.acquire();
    ScrollEvent localScrollEvent1 = localScrollEvent2;
    if (localScrollEvent2 == null) {
      localScrollEvent1 = new ScrollEvent();
    }
    localScrollEvent1.init(paramInt1, paramLong, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
    return localScrollEvent1;
  }
  
  private WritableMap serializeEventData()
  {
    WritableMap localWritableMap1 = Arguments.createMap();
    localWritableMap1.putDouble("top", 0.0D);
    localWritableMap1.putDouble("bottom", 0.0D);
    localWritableMap1.putDouble("left", 0.0D);
    localWritableMap1.putDouble("right", 0.0D);
    WritableMap localWritableMap2 = Arguments.createMap();
    localWritableMap2.putDouble("x", PixelUtil.toDIPFromPixel(this.mScrollX));
    localWritableMap2.putDouble("y", PixelUtil.toDIPFromPixel(this.mScrollY));
    WritableMap localWritableMap3 = Arguments.createMap();
    localWritableMap3.putDouble("width", PixelUtil.toDIPFromPixel(this.mContentWidth));
    localWritableMap3.putDouble("height", PixelUtil.toDIPFromPixel(this.mContentHeight));
    WritableMap localWritableMap4 = Arguments.createMap();
    localWritableMap4.putDouble("width", PixelUtil.toDIPFromPixel(this.mScrollViewWidth));
    localWritableMap4.putDouble("height", PixelUtil.toDIPFromPixel(this.mScrollViewHeight));
    WritableMap localWritableMap5 = Arguments.createMap();
    localWritableMap5.putMap("contentInset", localWritableMap1);
    localWritableMap5.putMap("contentOffset", localWritableMap2);
    localWritableMap5.putMap("contentSize", localWritableMap3);
    localWritableMap5.putMap("layoutMeasurement", localWritableMap4);
    localWritableMap5.putInt("target", getViewTag());
    localWritableMap5.putBoolean("responderIgnoreScroll", true);
    return localWritableMap5;
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
    return "topScroll";
  }
  
  public void onDispose()
  {
    EVENTS_POOL.release(this);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\views\scroll\ScrollEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */