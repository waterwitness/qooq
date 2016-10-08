package com.facebook.react.views.scroll;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.ReactProp;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import javax.annotation.Nullable;

public class ReactHorizontalScrollViewManager
  extends ViewGroupManager<ReactHorizontalScrollView>
  implements ReactScrollViewCommandHelper.ScrollCommandHandler<ReactHorizontalScrollView>
{
  private static final String REACT_CLASS = "AndroidHorizontalScrollView";
  
  public static String getStaticName()
  {
    return "AndroidHorizontalScrollView";
  }
  
  public ReactHorizontalScrollView createViewInstance(ThemedReactContext paramThemedReactContext)
  {
    return new ReactHorizontalScrollView(paramThemedReactContext);
  }
  
  public String getName()
  {
    return getStaticName();
  }
  
  public void receiveCommand(ReactHorizontalScrollView paramReactHorizontalScrollView, int paramInt, @Nullable ReadableArray paramReadableArray)
  {
    ReactScrollViewCommandHelper.receiveCommand(this, paramReactHorizontalScrollView, paramInt, paramReadableArray);
  }
  
  public void scrollTo(ReactHorizontalScrollView paramReactHorizontalScrollView, ReactScrollViewCommandHelper.ScrollToCommandData paramScrollToCommandData)
  {
    paramReactHorizontalScrollView.smoothScrollTo(paramScrollToCommandData.mDestX, paramScrollToCommandData.mDestY);
  }
  
  public void scrollWithoutAnimationTo(ReactHorizontalScrollView paramReactHorizontalScrollView, ReactScrollViewCommandHelper.ScrollToCommandData paramScrollToCommandData)
  {
    paramReactHorizontalScrollView.scrollTo(paramScrollToCommandData.mDestX, paramScrollToCommandData.mDestY);
  }
  
  @ReactProp(name="removeClippedSubviews")
  public void setRemoveClippedSubviews(ReactHorizontalScrollView paramReactHorizontalScrollView, boolean paramBoolean)
  {
    paramReactHorizontalScrollView.setRemoveClippedSubviews(paramBoolean);
  }
  
  @ReactProp(defaultBoolean=true, name="scrollEnabled")
  public void setScrollEnabled(ReactHorizontalScrollView paramReactHorizontalScrollView, boolean paramBoolean)
  {
    paramReactHorizontalScrollView.setScrollEnabled(paramBoolean);
  }
  
  @ReactProp(name="sendMomentumEvents")
  public void setSendMomentumEvents(ReactHorizontalScrollView paramReactHorizontalScrollView, boolean paramBoolean)
  {
    paramReactHorizontalScrollView.setSendMomentumEvents(paramBoolean);
  }
  
  @ReactProp(name="showsHorizontalScrollIndicator")
  public void setShowsHorizontalScrollIndicator(ReactHorizontalScrollView paramReactHorizontalScrollView, boolean paramBoolean)
  {
    paramReactHorizontalScrollView.setHorizontalScrollBarEnabled(paramBoolean);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\views\scroll\ReactHorizontalScrollViewManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */