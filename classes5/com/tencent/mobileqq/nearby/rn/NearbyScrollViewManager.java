package com.tencent.mobileqq.nearby.rn;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.views.scroll.ReactScrollViewManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class NearbyScrollViewManager
  extends ReactScrollViewManager
{
  public NearbyScrollViewManager()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public NearbyScrollView createViewInstance(ThemedReactContext paramThemedReactContext)
  {
    return new NearbyScrollView(paramThemedReactContext);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\rn\NearbyScrollViewManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */