package com.facebook.react.uimanager;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.touch.CatalystInterceptingViewGroup;
import com.facebook.react.touch.JSResponderHandler;
import java.util.Map;
import javax.annotation.Nullable;

public abstract class ViewManager<T extends View, C extends ReactShadowNode>
{
  protected void addEventEmitters(ThemedReactContext paramThemedReactContext, T paramT) {}
  
  public void clearViewToMgr() {}
  
  public abstract C createShadowNodeInstance();
  
  public final T createView(ThemedReactContext paramThemedReactContext, JSResponderHandler paramJSResponderHandler)
  {
    View localView = createViewInstance(paramThemedReactContext);
    addEventEmitters(paramThemedReactContext, localView);
    if ((localView instanceof CatalystInterceptingViewGroup)) {
      ((CatalystInterceptingViewGroup)localView).setOnInterceptTouchEventListener(paramJSResponderHandler);
    }
    return localView;
  }
  
  protected abstract T createViewInstance(ThemedReactContext paramThemedReactContext);
  
  @Nullable
  public Map<String, Integer> getCommandsMap()
  {
    return null;
  }
  
  @Nullable
  public Map<String, Object> getExportedCustomBubblingEventTypeConstants()
  {
    return null;
  }
  
  @Nullable
  public Map<String, Object> getExportedCustomDirectEventTypeConstants()
  {
    return null;
  }
  
  @Nullable
  public Map<String, Object> getExportedViewConstants()
  {
    return null;
  }
  
  public abstract String getName();
  
  public Map<String, String> getNativeProps()
  {
    return ViewManagersPropertyCache.getNativePropsForView(getClass(), getShadowNodeClass());
  }
  
  public abstract Class<? extends C> getShadowNodeClass();
  
  protected void onAfterUpdateTransaction(T paramT) {}
  
  public void onDropViewInstance(ThemedReactContext paramThemedReactContext, T paramT) {}
  
  public void receiveCommand(T paramT, int paramInt, @Nullable ReadableArray paramReadableArray) {}
  
  public abstract void updateExtraData(T paramT, Object paramObject);
  
  public final void updateProperties(T paramT, CatalystStylesDiffMap paramCatalystStylesDiffMap)
  {
    Map localMap = ViewManagersPropertyCache.getNativePropSettersForViewManagerClass(getClass());
    ReadableMapKeySetIterator localReadableMapKeySetIterator = paramCatalystStylesDiffMap.mBackingMap.keySetIterator();
    while (localReadableMapKeySetIterator.hasNextKey())
    {
      ViewManagersPropertyCache.PropSetter localPropSetter = (ViewManagersPropertyCache.PropSetter)localMap.get(localReadableMapKeySetIterator.nextKey());
      if (localPropSetter != null) {
        localPropSetter.updateViewProp(this, paramT, paramCatalystStylesDiffMap);
      }
    }
    onAfterUpdateTransaction(paramT);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\uimanager\ViewManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */