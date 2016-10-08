package com.facebook.react.uimanager;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ViewManagerRegistry
{
  private final Map<String, ViewManager> mViewManagers = new HashMap();
  
  public ViewManagerRegistry(List<ViewManager> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ViewManager localViewManager = (ViewManager)paramList.next();
      this.mViewManagers.put(localViewManager.getName(), localViewManager);
    }
  }
  
  public ViewManager get(String paramString)
  {
    ViewManager localViewManager = (ViewManager)this.mViewManagers.get(paramString);
    if (localViewManager != null) {
      return localViewManager;
    }
    throw new IllegalViewOperationException("No ViewManager defined for class " + paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\uimanager\ViewManagerRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */