package com.facebook.react.uimanager;

import com.facebook.react.bridge.ReactApplicationContext;
import java.util.List;

public class UIImplementationProvider
{
  public UIImplementation createUIImplementation(ReactApplicationContext paramReactApplicationContext, List<ViewManager> paramList)
  {
    return new UIImplementation(paramReactApplicationContext, paramList);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\uimanager\UIImplementationProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */