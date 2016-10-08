package com.facebook.react.views.scroll;

import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.EventDispatcher;

public class ReactScrollViewHelper
{
  public static final long MOMENTUM_DELAY = 20L;
  
  public static void emitScrollBeginDragEvent(ViewGroup paramViewGroup)
  {
    emitScrollEvent(paramViewGroup, ScrollEventType.BEGIN_DRAG);
  }
  
  public static void emitScrollEndDragEvent(ViewGroup paramViewGroup)
  {
    emitScrollEvent(paramViewGroup, ScrollEventType.END_DRAG);
  }
  
  public static void emitScrollEvent(ViewGroup paramViewGroup)
  {
    emitScrollEvent(paramViewGroup, ScrollEventType.SCROLL);
  }
  
  public static void emitScrollEvent(ViewGroup paramViewGroup, ScrollEventType paramScrollEventType)
  {
    paramScrollEventType = paramViewGroup.getChildAt(0);
    ((UIManagerModule)((ReactContext)paramViewGroup.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(ScrollEvent.obtain(paramViewGroup.getId(), SystemClock.uptimeMillis(), paramViewGroup.getScrollX(), paramViewGroup.getScrollY(), paramScrollEventType.getWidth(), paramScrollEventType.getHeight(), paramViewGroup.getWidth(), paramViewGroup.getHeight()));
  }
  
  public static void emitScrollMomentumBeginEvent(ViewGroup paramViewGroup)
  {
    emitScrollEvent(paramViewGroup, ScrollEventType.MOMENTUM_BEGIN);
  }
  
  public static void emitScrollMomentumEndEvent(ViewGroup paramViewGroup)
  {
    emitScrollEvent(paramViewGroup, ScrollEventType.MOMENTUM_END);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\views\scroll\ReactScrollViewHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */