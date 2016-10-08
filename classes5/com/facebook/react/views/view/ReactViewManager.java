package com.facebook.react.views.view;

import android.os.Build.VERSION;
import android.view.View;
import com.facebook.csslayout.CSSConstants;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ReactProp;
import com.facebook.react.uimanager.ReactPropGroup;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;

public class ReactViewManager
  extends ViewGroupManager<ReactViewGroup>
{
  private static final int CMD_HOTSPOT_UPDATE = 1;
  private static final int CMD_SET_PRESSED = 2;
  @VisibleForTesting
  public static final String REACT_CLASS = "RCTView";
  private static final int[] SPACING_TYPES = { 8, 0, 2, 1, 3 };
  
  public static Map<String, Integer> getStaticCommandsMap()
  {
    return MapBuilder.of("hotspotUpdate", Integer.valueOf(1), "setPressed", Integer.valueOf(2));
  }
  
  public static String getStaticName()
  {
    return "RCTView";
  }
  
  public void addView(ReactViewGroup paramReactViewGroup, View paramView, int paramInt)
  {
    try
    {
      if (paramReactViewGroup.getRemoveClippedSubviews())
      {
        paramReactViewGroup.addViewWithSubviewClippingEnabled(paramView, paramInt);
        return;
      }
      paramReactViewGroup.addView(paramView, paramInt);
      return;
    }
    catch (Exception paramReactViewGroup)
    {
      paramReactViewGroup.printStackTrace();
    }
  }
  
  public ReactViewGroup createViewInstance(ThemedReactContext paramThemedReactContext)
  {
    return new ReactViewGroup(paramThemedReactContext);
  }
  
  public View getChildAt(ReactViewGroup paramReactViewGroup, int paramInt)
  {
    if (paramReactViewGroup.getRemoveClippedSubviews()) {
      return paramReactViewGroup.getChildAtWithSubviewClippingEnabled(paramInt);
    }
    return paramReactViewGroup.getChildAt(paramInt);
  }
  
  public int getChildCount(ReactViewGroup paramReactViewGroup)
  {
    if (paramReactViewGroup.getRemoveClippedSubviews()) {
      return paramReactViewGroup.getAllChildrenCount();
    }
    return paramReactViewGroup.getChildCount();
  }
  
  public Map<String, Integer> getCommandsMap()
  {
    return getStaticCommandsMap();
  }
  
  public String getName()
  {
    return getStaticName();
  }
  
  public void receiveCommand(ReactViewGroup paramReactViewGroup, int paramInt, @Nullable ReadableArray paramReadableArray)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return;
    }
    if ((paramReadableArray == null) || (paramReadableArray.size() != 1)) {
      throw new JSApplicationIllegalArgumentException("Illegal number of arguments for 'setPressed' command");
    }
    paramReactViewGroup.setPressed(paramReadableArray.getBoolean(0));
  }
  
  public void removeAllViews(ReactViewGroup paramReactViewGroup)
  {
    if (paramReactViewGroup.getRemoveClippedSubviews())
    {
      paramReactViewGroup.removeAllViewsWithSubviewClippingEnabled();
      return;
    }
    paramReactViewGroup.removeAllViews();
  }
  
  public void removeViewAt(ReactViewGroup paramReactViewGroup, int paramInt)
  {
    if (paramReactViewGroup.getRemoveClippedSubviews())
    {
      View localView = getChildAt(paramReactViewGroup, paramInt);
      if (localView.getParent() != null) {
        paramReactViewGroup.removeView(localView);
      }
      paramReactViewGroup.removeViewWithSubviewClippingEnabled(localView);
      return;
    }
    paramReactViewGroup.removeViewAt(paramInt);
  }
  
  @ReactProp(name="accessible")
  public void setAccessible(ReactViewGroup paramReactViewGroup, boolean paramBoolean)
  {
    paramReactViewGroup.setFocusable(paramBoolean);
  }
  
  @ReactPropGroup(customType="Color", names={"borderColor", "borderLeftColor", "borderRightColor", "borderTopColor", "borderBottomColor"})
  public void setBorderColor(ReactViewGroup paramReactViewGroup, int paramInt, Integer paramInteger)
  {
    paramInt = SPACING_TYPES[paramInt];
    if (paramInteger == null) {}
    for (float f = NaN.0F;; f = paramInteger.intValue())
    {
      paramReactViewGroup.setBorderColor(paramInt, f);
      return;
    }
  }
  
  @ReactProp(name="borderRadius")
  public void setBorderRadius(ReactViewGroup paramReactViewGroup, float paramFloat)
  {
    paramReactViewGroup.setBorderRadius(PixelUtil.toPixelFromDIP(paramFloat));
  }
  
  @ReactProp(name="borderStyle")
  public void setBorderStyle(ReactViewGroup paramReactViewGroup, @Nullable String paramString)
  {
    paramReactViewGroup.setBorderStyle(paramString);
  }
  
  @ReactProp(defaultFloat=NaN.0F, name="borderWidth")
  public void setBorderWidth(ReactViewGroup paramReactViewGroup, float paramFloat)
  {
    float f = paramFloat;
    if (!CSSConstants.isUndefined(paramFloat)) {
      f = PixelUtil.toPixelFromDIP(paramFloat);
    }
    paramReactViewGroup.setBorderWidth(8, f);
  }
  
  @ReactPropGroup(defaultFloat=NaN.0F, names={"borderWidth", "borderLeftWidth", "borderRightWidth", "borderTopWidth", "borderBottomWidth"})
  public void setBorderWidth(ReactViewGroup paramReactViewGroup, int paramInt, float paramFloat)
  {
    float f = paramFloat;
    if (!CSSConstants.isUndefined(paramFloat)) {
      f = PixelUtil.toPixelFromDIP(paramFloat);
    }
    paramReactViewGroup.setBorderWidth(SPACING_TYPES[paramInt], f);
  }
  
  @ReactProp(name="collapsable")
  public void setCollapsable(ReactViewGroup paramReactViewGroup, boolean paramBoolean) {}
  
  @ReactProp(name="elevation")
  public void setElevation(ReactViewGroup paramReactViewGroup, float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    try
    {
      paramReactViewGroup.getClass().getMethod("setElevation", new Class[] { Float.TYPE }).invoke(paramReactViewGroup, new Object[] { Float.valueOf(PixelUtil.toPixelFromDIP(paramFloat)) });
      return;
    }
    catch (Exception paramReactViewGroup) {}
  }
  
  @ReactProp(name="nativeBackgroundAndroid")
  public void setNativeBackground(ReactViewGroup paramReactViewGroup, @Nullable ReadableMap paramReadableMap)
  {
    if (paramReadableMap == null) {}
    for (paramReadableMap = null;; paramReadableMap = ReactDrawableHelper.createDrawableFromJSDescription(paramReactViewGroup.getContext(), paramReadableMap))
    {
      paramReactViewGroup.setTranslucentBackgroundDrawable(paramReadableMap);
      return;
    }
  }
  
  @ReactProp(name="needsOffscreenAlphaCompositing")
  public void setNeedsOffscreenAlphaCompositing(ReactViewGroup paramReactViewGroup, boolean paramBoolean)
  {
    paramReactViewGroup.setNeedsOffscreenAlphaCompositing(paramBoolean);
  }
  
  @ReactProp(name="pointerEvents")
  public void setPointerEvents(ReactViewGroup paramReactViewGroup, @Nullable String paramString)
  {
    if (paramString != null) {
      paramReactViewGroup.setPointerEvents(PointerEvents.valueOf(paramString.toUpperCase(Locale.US).replace("-", "_")));
    }
  }
  
  @ReactProp(name="removeClippedSubviews")
  public void setRemoveClippedSubviews(ReactViewGroup paramReactViewGroup, boolean paramBoolean)
  {
    paramReactViewGroup.setRemoveClippedSubviews(paramBoolean);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\views\view\ReactViewManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */