package com.facebook.react.uimanager;

import android.util.DisplayMetrics;
import android.widget.ImageView.ScaleType;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.common.MapBuilder.Builder;
import com.facebook.react.uimanager.events.TouchEventType;
import java.util.HashMap;
import java.util.Map;

class UIManagerModuleConstants
{
  public static final String ACTION_DISMISSED = "dismissed";
  public static final String ACTION_ITEM_SELECTED = "itemSelected";
  
  static Map getBubblingEventTypeConstants()
  {
    return MapBuilder.builder().put("topChange", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onChange", "captured", "onChangeCapture"))).put("topSelect", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onSelect", "captured", "onSelectCapture"))).put(TouchEventType.START.getJSEventName(), MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onTouchStart", "captured", "onTouchStartCapture"))).put(TouchEventType.MOVE.getJSEventName(), MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onTouchMove", "captured", "onTouchMoveCapture"))).put(TouchEventType.END.getJSEventName(), MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onTouchEnd", "captured", "onTouchEndCapture"))).build();
  }
  
  public static Map<String, Object> getConstants(DisplayMetrics paramDisplayMetrics)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("UIView", MapBuilder.of("ContentMode", MapBuilder.of("ScaleAspectFit", Integer.valueOf(ImageView.ScaleType.CENTER_INSIDE.ordinal()), "ScaleAspectFill", Integer.valueOf(ImageView.ScaleType.CENTER_CROP.ordinal()))));
    localHashMap.put("UIText", MapBuilder.of("AutocapitalizationType", MapBuilder.of("none", Integer.valueOf(1), "characters", Integer.valueOf(4096), "words", Integer.valueOf(8192), "sentences", Integer.valueOf(16384))));
    localHashMap.put("Dimensions", MapBuilder.of("windowPhysicalPixels", MapBuilder.of("width", Integer.valueOf(paramDisplayMetrics.widthPixels), "height", Integer.valueOf(paramDisplayMetrics.heightPixels), "scale", Float.valueOf(paramDisplayMetrics.density), "fontScale", Float.valueOf(paramDisplayMetrics.scaledDensity), "densityDpi", Integer.valueOf(paramDisplayMetrics.densityDpi))));
    localHashMap.put("StyleConstants", MapBuilder.of("PointerEventsValues", MapBuilder.of("none", Integer.valueOf(PointerEvents.NONE.ordinal()), "boxNone", Integer.valueOf(PointerEvents.BOX_NONE.ordinal()), "boxOnly", Integer.valueOf(PointerEvents.BOX_ONLY.ordinal()), "unspecified", Integer.valueOf(PointerEvents.AUTO.ordinal()))));
    localHashMap.put("PopupMenu", MapBuilder.of("dismissed", "dismissed", "itemSelected", "itemSelected"));
    localHashMap.put("AccessibilityEventTypes", MapBuilder.of("typeWindowStateChanged", Integer.valueOf(32), "typeViewClicked", Integer.valueOf(1)));
    return localHashMap;
  }
  
  static Map getDirectEventTypeConstants()
  {
    return MapBuilder.builder().put("topSelectionChange", MapBuilder.of("registrationName", "onSelectionChange")).put("topLoadingStart", MapBuilder.of("registrationName", "onLoadingStart")).put("topLoadingFinish", MapBuilder.of("registrationName", "onLoadingFinish")).put("topLoadingError", MapBuilder.of("registrationName", "onLoadingError")).put("topLayout", MapBuilder.of("registrationName", "onLayout")).build();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\uimanager\UIManagerModuleConstants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */