package com.facebook.react.uimanager;

import android.os.Build.VERSION;
import android.view.View;
import com.facebook.react.bridge.ReadableMap;
import java.lang.reflect.Method;

public abstract class BaseViewManager<T extends View, C extends LayoutShadowNode>
  extends ViewManager<T, C>
{
  private static final String PROP_ACCESSIBILITY_COMPONENT_TYPE = "accessibilityComponentType";
  private static final String PROP_ACCESSIBILITY_LABEL = "accessibilityLabel";
  private static final String PROP_ACCESSIBILITY_LIVE_REGION = "accessibilityLiveRegion";
  private static final String PROP_BACKGROUND_COLOR = "backgroundColor";
  private static final String PROP_DECOMPOSED_MATRIX = "decomposedMatrix";
  private static final String PROP_DECOMPOSED_MATRIX_ROTATE = "rotate";
  private static final String PROP_DECOMPOSED_MATRIX_ROTATE_X = "rotateX";
  private static final String PROP_DECOMPOSED_MATRIX_ROTATE_Y = "rotateY";
  private static final String PROP_DECOMPOSED_MATRIX_SCALE_X = "scaleX";
  private static final String PROP_DECOMPOSED_MATRIX_SCALE_Y = "scaleY";
  private static final String PROP_DECOMPOSED_MATRIX_TRANSLATE_X = "translateX";
  private static final String PROP_DECOMPOSED_MATRIX_TRANSLATE_Y = "translateY";
  private static final String PROP_IMPORTANT_FOR_ACCESSIBILITY = "importantForAccessibility";
  private static final String PROP_OPACITY = "opacity";
  private static final String PROP_RENDER_TO_HARDWARE_TEXTURE = "renderToHardwareTextureAndroid";
  private static final String PROP_ROTATION = "rotation";
  private static final String PROP_SCALE_X = "scaleX";
  private static final String PROP_SCALE_Y = "scaleY";
  public static final String PROP_TEST_ID = "testID";
  private static final String PROP_TRANSLATE_X = "translateX";
  private static final String PROP_TRANSLATE_Y = "translateY";
  
  private static void resetTransformMatrix(View paramView)
  {
    paramView.setTranslationX(PixelUtil.toPixelFromDIP(0.0F));
    paramView.setTranslationY(PixelUtil.toPixelFromDIP(0.0F));
    paramView.setRotation(0.0F);
    paramView.setRotationX(0.0F);
    paramView.setRotationY(0.0F);
    paramView.setScaleX(1.0F);
    paramView.setScaleY(1.0F);
  }
  
  private static void setTransformMatrix(View paramView, ReadableMap paramReadableMap)
  {
    paramView.setTranslationX(PixelUtil.toPixelFromDIP((float)paramReadableMap.getDouble("translateX")));
    paramView.setTranslationY(PixelUtil.toPixelFromDIP((float)paramReadableMap.getDouble("translateY")));
    paramView.setRotation((float)paramReadableMap.getDouble("rotate"));
    paramView.setRotationX((float)paramReadableMap.getDouble("rotateX"));
    paramView.setRotationY((float)paramReadableMap.getDouble("rotateY"));
    paramView.setScaleX((float)paramReadableMap.getDouble("scaleX"));
    paramView.setScaleY((float)paramReadableMap.getDouble("scaleY"));
  }
  
  @ReactProp(name="accessibilityComponentType")
  public void setAccessibilityComponentType(T paramT, String paramString)
  {
    AccessibilityHelper.updateAccessibilityComponentType(paramT, paramString);
  }
  
  @ReactProp(name="accessibilityLabel")
  public void setAccessibilityLabel(T paramT, String paramString)
  {
    paramT.setContentDescription(paramString);
  }
  
  @ReactProp(name="accessibilityLiveRegion")
  public void setAccessibilityLiveRegion(T paramT, String paramString)
  {
    int i;
    if (Build.VERSION.SDK_INT >= 19)
    {
      i = 0;
      if ((paramString != null) && (!paramString.equals("none"))) {
        break label61;
      }
      i = 0;
    }
    for (;;)
    {
      label61:
      try
      {
        paramT.getClass().getMethod("setAccessibilityLiveRegion", new Class[] { Integer.TYPE }).invoke(paramT, new Object[] { Integer.valueOf(i) });
        return;
      }
      catch (Exception paramT) {}
      if (paramString.equals("polite")) {
        i = 1;
      } else if (paramString.equals("assertive")) {
        i = 2;
      }
    }
  }
  
  @ReactProp(customType="Color", defaultInt=0, name="backgroundColor")
  public void setBackgroundColor(T paramT, int paramInt)
  {
    paramT.setBackgroundColor(paramInt);
  }
  
  @ReactProp(name="decomposedMatrix")
  public void setDecomposedMatrix(T paramT, ReadableMap paramReadableMap)
  {
    if (paramReadableMap == null)
    {
      resetTransformMatrix(paramT);
      return;
    }
    setTransformMatrix(paramT, paramReadableMap);
  }
  
  @ReactProp(name="importantForAccessibility")
  public void setImportantForAccessibility(T paramT, String paramString)
  {
    if ((paramString == null) || (paramString.equals("auto"))) {
      paramT.setImportantForAccessibility(0);
    }
    do
    {
      return;
      if (paramString.equals("yes"))
      {
        paramT.setImportantForAccessibility(1);
        return;
      }
      if (paramString.equals("no"))
      {
        paramT.setImportantForAccessibility(2);
        return;
      }
    } while (!paramString.equals("no-hide-descendants"));
    paramT.setImportantForAccessibility(4);
  }
  
  @ReactProp(defaultFloat=1.0F, name="opacity")
  public void setOpacity(T paramT, float paramFloat)
  {
    paramT.setAlpha(paramFloat);
  }
  
  @ReactProp(name="renderToHardwareTextureAndroid")
  public void setRenderToHardwareTexture(T paramT, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 2;; i = 0)
    {
      paramT.setLayerType(i, null);
      return;
    }
  }
  
  @ReactProp(name="rotation")
  @Deprecated
  public void setRotation(T paramT, float paramFloat)
  {
    paramT.setRotation(paramFloat);
  }
  
  @ReactProp(defaultFloat=1.0F, name="scaleX")
  @Deprecated
  public void setScaleX(T paramT, float paramFloat)
  {
    paramT.setScaleX(paramFloat);
  }
  
  @ReactProp(defaultFloat=1.0F, name="scaleY")
  @Deprecated
  public void setScaleY(T paramT, float paramFloat)
  {
    paramT.setScaleY(paramFloat);
  }
  
  @ReactProp(name="testID")
  public void setTestId(T paramT, String paramString)
  {
    paramT.setTag(paramString);
  }
  
  @ReactProp(defaultFloat=0.0F, name="translateX")
  @Deprecated
  public void setTranslateX(T paramT, float paramFloat)
  {
    paramT.setTranslationX(PixelUtil.toPixelFromDIP(paramFloat));
  }
  
  @ReactProp(defaultFloat=0.0F, name="translateY")
  @Deprecated
  public void setTranslateY(T paramT, float paramFloat)
  {
    paramT.setTranslationY(PixelUtil.toPixelFromDIP(paramFloat));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\uimanager\BaseViewManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */