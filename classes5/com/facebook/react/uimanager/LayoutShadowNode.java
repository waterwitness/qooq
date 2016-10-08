package com.facebook.react.uimanager;

import com.facebook.csslayout.CSSAlign;
import com.facebook.csslayout.CSSConstants;
import com.facebook.csslayout.CSSFlexDirection;
import com.facebook.csslayout.CSSJustify;
import com.facebook.csslayout.CSSPositionType;
import com.facebook.csslayout.CSSWrap;
import java.util.Locale;
import javax.annotation.Nullable;

public class LayoutShadowNode
  extends ReactShadowNode
{
  @ReactProp(name="alignItems")
  public void setAlignItems(@Nullable String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (paramString = CSSAlign.STRETCH;; paramString = CSSAlign.valueOf(paramString.toUpperCase(Locale.US).replace("-", "_")))
    {
      setAlignItems(paramString);
      return;
    }
  }
  
  @ReactProp(name="alignSelf")
  public void setAlignSelf(@Nullable String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (paramString = CSSAlign.AUTO;; paramString = CSSAlign.valueOf(paramString.toUpperCase(Locale.US).replace("-", "_")))
    {
      setAlignSelf(paramString);
      return;
    }
  }
  
  @ReactPropGroup(defaultFloat=NaN.0F, names={"borderWidth", "borderLeftWidth", "borderRightWidth", "borderTopWidth", "borderBottomWidth"})
  public void setBorderWidths(int paramInt, float paramFloat)
  {
    setBorder(ViewProps.BORDER_SPACING_TYPES[paramInt], PixelUtil.toPixelFromDIP(paramFloat));
  }
  
  @ReactProp(defaultFloat=NaN.0F, name="bottom")
  public void setBottom(float paramFloat)
  {
    if (CSSConstants.isUndefined(paramFloat)) {}
    for (;;)
    {
      setPositionBottom(paramFloat);
      return;
      paramFloat = PixelUtil.toPixelFromDIP(paramFloat);
    }
  }
  
  @ReactProp(defaultFloat=0.0F, name="flex")
  public void setFlex(float paramFloat)
  {
    super.setFlex(paramFloat);
  }
  
  @ReactProp(name="flexDirection")
  public void setFlexDirection(@Nullable String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (paramString = CSSFlexDirection.COLUMN;; paramString = CSSFlexDirection.valueOf(paramString.toUpperCase(Locale.US)))
    {
      setFlexDirection(paramString);
      return;
    }
  }
  
  @ReactProp(name="flexWrap")
  public void setFlexWrap(@Nullable String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (paramString = CSSWrap.NOWRAP;; paramString = CSSWrap.valueOf(paramString.toUpperCase(Locale.US)))
    {
      setWrap(paramString);
      return;
    }
  }
  
  @ReactProp(defaultFloat=NaN.0F, name="height")
  public void setHeight(float paramFloat)
  {
    if (CSSConstants.isUndefined(paramFloat)) {}
    for (;;)
    {
      setStyleHeight(paramFloat);
      return;
      paramFloat = PixelUtil.toPixelFromDIP(paramFloat);
    }
  }
  
  @ReactProp(name="justifyContent")
  public void setJustifyContent(@Nullable String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (paramString = CSSJustify.FLEX_START;; paramString = CSSJustify.valueOf(paramString.toUpperCase(Locale.US).replace("-", "_")))
    {
      setJustifyContent(paramString);
      return;
    }
  }
  
  @ReactProp(defaultFloat=NaN.0F, name="left")
  public void setLeft(float paramFloat)
  {
    if (CSSConstants.isUndefined(paramFloat)) {}
    for (;;)
    {
      setPositionLeft(paramFloat);
      return;
      paramFloat = PixelUtil.toPixelFromDIP(paramFloat);
    }
  }
  
  @ReactPropGroup(defaultFloat=NaN.0F, names={"margin", "marginVertical", "marginHorizontal", "marginLeft", "marginRight", "marginTop", "marginBottom"})
  public void setMargins(int paramInt, float paramFloat)
  {
    setMargin(ViewProps.PADDING_MARGIN_SPACING_TYPES[paramInt], PixelUtil.toPixelFromDIP(paramFloat));
  }
  
  @ReactPropGroup(defaultFloat=NaN.0F, names={"padding", "paddingVertical", "paddingHorizontal", "paddingLeft", "paddingRight", "paddingTop", "paddingBottom"})
  public void setPaddings(int paramInt, float paramFloat)
  {
    paramInt = ViewProps.PADDING_MARGIN_SPACING_TYPES[paramInt];
    if (CSSConstants.isUndefined(paramFloat)) {}
    for (;;)
    {
      setPadding(paramInt, paramFloat);
      return;
      paramFloat = PixelUtil.toPixelFromDIP(paramFloat);
    }
  }
  
  @ReactProp(name="position")
  public void setPosition(@Nullable String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (paramString = CSSPositionType.RELATIVE;; paramString = CSSPositionType.valueOf(paramString.toUpperCase(Locale.US)))
    {
      setPositionType(paramString);
      return;
    }
  }
  
  @ReactProp(defaultFloat=NaN.0F, name="right")
  public void setRight(float paramFloat)
  {
    if (CSSConstants.isUndefined(paramFloat)) {}
    for (;;)
    {
      setPositionRight(paramFloat);
      return;
      paramFloat = PixelUtil.toPixelFromDIP(paramFloat);
    }
  }
  
  @ReactProp(name="onLayout")
  public void setShouldNotifyOnLayout(boolean paramBoolean)
  {
    super.setShouldNotifyOnLayout(paramBoolean);
  }
  
  @ReactProp(defaultFloat=NaN.0F, name="top")
  public void setTop(float paramFloat)
  {
    if (CSSConstants.isUndefined(paramFloat)) {}
    for (;;)
    {
      setPositionTop(paramFloat);
      return;
      paramFloat = PixelUtil.toPixelFromDIP(paramFloat);
    }
  }
  
  @ReactProp(defaultFloat=NaN.0F, name="width")
  public void setWidth(float paramFloat)
  {
    if (CSSConstants.isUndefined(paramFloat)) {}
    for (;;)
    {
      setStyleWidth(paramFloat);
      return;
      paramFloat = PixelUtil.toPixelFromDIP(paramFloat);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\uimanager\LayoutShadowNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */