package com.tencent.mobileqq.nearby.rn;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.views.scroll.ReactScrollViewManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.rn.BDHttpManager;
import com.tencent.mobileqq.rn.LBSManager;
import com.tencent.mobileqq.rn.QQBaseModule;
import com.tencent.mobileqq.rn.RCTAvatarViewManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NearbyReactPackage
  extends MainReactPackage
{
  public NearbyReactPackage()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public List createNativeModules(ReactApplicationContext paramReactApplicationContext)
  {
    List localList = super.createNativeModules(paramReactApplicationContext);
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(localList);
    localArrayList.add(new QQBaseModule(paramReactApplicationContext));
    localArrayList.add(new LBSManager(paramReactApplicationContext));
    localArrayList.add(new BDHttpManager(paramReactApplicationContext));
    return localArrayList;
  }
  
  public List createViewManagers(ReactApplicationContext paramReactApplicationContext)
  {
    Object localObject = super.createViewManagers(paramReactApplicationContext);
    paramReactApplicationContext = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ViewManager localViewManager = (ViewManager)((Iterator)localObject).next();
      if (localViewManager != null) {
        if (localViewManager.getClass() == ReactScrollViewManager.class) {
          paramReactApplicationContext.add(new NearbyScrollViewManager());
        } else {
          paramReactApplicationContext.add(localViewManager);
        }
      }
    }
    paramReactApplicationContext.add(new RCTAvatarViewManager());
    return paramReactApplicationContext;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\rn\NearbyReactPackage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */