package com.facebook.react;

import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CompositeReactPackage
  implements ReactPackage
{
  private final List<ReactPackage> mChildReactPackages = new ArrayList();
  
  public CompositeReactPackage(ReactPackage paramReactPackage1, ReactPackage paramReactPackage2, ReactPackage... paramVarArgs)
  {
    this.mChildReactPackages.add(paramReactPackage1);
    this.mChildReactPackages.add(paramReactPackage2);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      paramReactPackage1 = paramVarArgs[i];
      this.mChildReactPackages.add(paramReactPackage1);
      i += 1;
    }
  }
  
  public List<Class<? extends JavaScriptModule>> createJSModules()
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator1 = this.mChildReactPackages.iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((ReactPackage)localIterator1.next()).createJSModules().iterator();
      while (localIterator2.hasNext()) {
        localHashSet.add((Class)localIterator2.next());
      }
    }
    return new ArrayList(localHashSet);
  }
  
  public List<NativeModule> createNativeModules(ReactApplicationContext paramReactApplicationContext)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator1 = this.mChildReactPackages.iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((ReactPackage)localIterator1.next()).createNativeModules(paramReactApplicationContext).iterator();
      while (localIterator2.hasNext())
      {
        NativeModule localNativeModule = (NativeModule)localIterator2.next();
        localHashMap.put(localNativeModule.getName(), localNativeModule);
      }
    }
    return new ArrayList(localHashMap.values());
  }
  
  public List<ViewManager> createViewManagers(ReactApplicationContext paramReactApplicationContext)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator1 = this.mChildReactPackages.iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((ReactPackage)localIterator1.next()).createViewManagers(paramReactApplicationContext).iterator();
      while (localIterator2.hasNext())
      {
        ViewManager localViewManager = (ViewManager)localIterator2.next();
        localHashMap.put(localViewManager.getName(), localViewManager);
      }
    }
    return new ArrayList(localHashMap.values());
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\CompositeReactPackage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */