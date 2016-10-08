package com.facebook.react.uimanager;

import android.view.ViewGroup;

public class RootViewManager
  extends ViewGroupManager<ViewGroup>
{
  public static final String REACT_CLASS = "RootView";
  
  protected ViewGroup createViewInstance(ThemedReactContext paramThemedReactContext)
  {
    return new SizeMonitoringFrameLayout(paramThemedReactContext);
  }
  
  public String getName()
  {
    return "RootView";
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\uimanager\RootViewManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */