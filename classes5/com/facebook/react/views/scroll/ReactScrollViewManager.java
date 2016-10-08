package com.facebook.react.views.scroll;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.common.MapBuilder.Builder;
import com.facebook.react.uimanager.ReactProp;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import java.util.Map;
import javax.annotation.Nullable;

public class ReactScrollViewManager
  extends ViewGroupManager<ReactScrollView>
  implements ReactScrollViewCommandHelper.ScrollCommandHandler<ReactScrollView>
{
  private static final String REACT_CLASS = "RCTScrollView";
  
  public static Map createExportedCustomDirectEventTypeConstants()
  {
    return MapBuilder.builder().put(ScrollEventType.SCROLL.getJSEventName(), MapBuilder.of("registrationName", "onScroll")).put(ScrollEventType.BEGIN_DRAG.getJSEventName(), MapBuilder.of("registrationName", "onScrollBeginDrag")).put(ScrollEventType.END_DRAG.getJSEventName(), MapBuilder.of("registrationName", "onScrollEndDrag")).put(ScrollEventType.ANIMATION_END.getJSEventName(), MapBuilder.of("registrationName", "onScrollAnimationEnd")).put(ScrollEventType.MOMENTUM_BEGIN.getJSEventName(), MapBuilder.of("registrationName", "onMomentumScrollBegin")).put(ScrollEventType.MOMENTUM_END.getJSEventName(), MapBuilder.of("registrationName", "onMomentumScrollEnd")).build();
  }
  
  @Nullable
  public static Map<String, Integer> getStaticCommandsMap()
  {
    return ReactScrollViewCommandHelper.getCommandsMap();
  }
  
  @Nullable
  public static Map getStaticExportedCustomDirectEventTypeConstants()
  {
    return createExportedCustomDirectEventTypeConstants();
  }
  
  public static String getStaticName()
  {
    return "RCTScrollView";
  }
  
  public ReactScrollView createViewInstance(ThemedReactContext paramThemedReactContext)
  {
    return new ReactScrollView(paramThemedReactContext);
  }
  
  @Nullable
  public Map<String, Integer> getCommandsMap()
  {
    return getStaticCommandsMap();
  }
  
  @Nullable
  public Map getExportedCustomDirectEventTypeConstants()
  {
    return getStaticExportedCustomDirectEventTypeConstants();
  }
  
  public String getName()
  {
    return getStaticName();
  }
  
  public void receiveCommand(ReactScrollView paramReactScrollView, int paramInt, @Nullable ReadableArray paramReadableArray)
  {
    ReactScrollViewCommandHelper.receiveCommand(this, paramReactScrollView, paramInt, paramReadableArray);
  }
  
  public void scrollTo(ReactScrollView paramReactScrollView, ReactScrollViewCommandHelper.ScrollToCommandData paramScrollToCommandData)
  {
    paramReactScrollView.smoothScrollTo(paramScrollToCommandData.mDestX, paramScrollToCommandData.mDestY);
  }
  
  public void scrollWithoutAnimationTo(ReactScrollView paramReactScrollView, ReactScrollViewCommandHelper.ScrollToCommandData paramScrollToCommandData)
  {
    paramReactScrollView.scrollTo(paramScrollToCommandData.mDestX, paramScrollToCommandData.mDestY);
  }
  
  @ReactProp(name="removeClippedSubviews")
  public void setRemoveClippedSubviews(ReactScrollView paramReactScrollView, boolean paramBoolean)
  {
    paramReactScrollView.setRemoveClippedSubviews(paramBoolean);
  }
  
  @ReactProp(defaultBoolean=true, name="scrollEnabled")
  public void setScrollEnabled(ReactScrollView paramReactScrollView, boolean paramBoolean)
  {
    paramReactScrollView.setScrollEnabled(paramBoolean);
  }
  
  @ReactProp(name="showsVerticalScrollIndicator")
  public void setShowsVerticalScrollIndicator(ReactScrollView paramReactScrollView, boolean paramBoolean)
  {
    paramReactScrollView.setVerticalScrollBarEnabled(paramBoolean);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\views\scroll\ReactScrollViewManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */