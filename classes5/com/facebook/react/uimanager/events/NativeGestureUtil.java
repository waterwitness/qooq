package com.facebook.react.uimanager.events;

import android.view.MotionEvent;
import android.view.View;
import com.facebook.react.uimanager.RootView;
import com.facebook.react.uimanager.RootViewUtil;

public class NativeGestureUtil
{
  public static void notifyNativeGestureStarted(View paramView, MotionEvent paramMotionEvent)
  {
    RootViewUtil.getRootView(paramView).onChildStartedNativeGesture(paramMotionEvent);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\uimanager\events\NativeGestureUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */