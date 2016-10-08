package com.facebook.react.uimanager;

import java.util.Arrays;
import java.util.HashSet;

public class ViewProps
{
  public static final String ALIGN_ITEMS = "alignItems";
  public static final String ALIGN_SELF = "alignSelf";
  public static final String BACKGROUND_COLOR = "backgroundColor";
  public static final String BORDER_BOTTOM_WIDTH = "borderBottomWidth";
  public static final String BORDER_LEFT_WIDTH = "borderLeftWidth";
  public static final String BORDER_RIGHT_WIDTH = "borderRightWidth";
  public static final int[] BORDER_SPACING_TYPES = { 8, 0, 2, 1, 3 };
  public static final String BORDER_TOP_WIDTH = "borderTopWidth";
  public static final String BORDER_WIDTH = "borderWidth";
  public static final String BOTTOM = "bottom";
  public static final String COLLAPSABLE = "collapsable";
  public static final String COLOR = "color";
  public static final String ENABLED = "enabled";
  public static final String FLEX = "flex";
  public static final String FLEX_DIRECTION = "flexDirection";
  public static final String FLEX_WRAP = "flexWrap";
  public static final String FONT_FAMILY = "fontFamily";
  public static final String FONT_SIZE = "fontSize";
  public static final String FONT_STYLE = "fontStyle";
  public static final String FONT_WEIGHT = "fontWeight";
  public static final String HEIGHT = "height";
  public static final String JUSTIFY_CONTENT = "justifyContent";
  private static final HashSet<String> LAYOUT_ONLY_PROPS = new HashSet(Arrays.asList(new String[] { "alignSelf", "alignItems", "bottom", "collapsable", "flex", "flexDirection", "flexWrap", "height", "justifyContent", "left", "position", "right", "top", "width", "margin", "marginVertical", "marginHorizontal", "marginLeft", "marginRight", "marginTop", "marginBottom", "padding", "paddingVertical", "paddingHorizontal", "paddingLeft", "paddingRight", "paddingTop", "paddingBottom" }));
  public static final String LEFT = "left";
  public static final String LINE_HEIGHT = "lineHeight";
  public static final String MARGIN = "margin";
  public static final String MARGIN_BOTTOM = "marginBottom";
  public static final String MARGIN_HORIZONTAL = "marginHorizontal";
  public static final String MARGIN_LEFT = "marginLeft";
  public static final String MARGIN_RIGHT = "marginRight";
  public static final String MARGIN_TOP = "marginTop";
  public static final String MARGIN_VERTICAL = "marginVertical";
  public static final String NEEDS_OFFSCREEN_ALPHA_COMPOSITING = "needsOffscreenAlphaCompositing";
  public static final String NUMBER_OF_LINES = "numberOfLines";
  public static final String ON = "on";
  public static final String PADDING = "padding";
  public static final String PADDING_BOTTOM = "paddingBottom";
  public static final String PADDING_HORIZONTAL = "paddingHorizontal";
  public static final String PADDING_LEFT = "paddingLeft";
  public static final int[] PADDING_MARGIN_SPACING_TYPES = { 8, 4, 5, 0, 2, 1, 3 };
  public static final String PADDING_RIGHT = "paddingRight";
  public static final String PADDING_TOP = "paddingTop";
  public static final String PADDING_VERTICAL = "paddingVertical";
  public static final String POSITION = "position";
  public static final String RESIZE_MODE = "resizeMode";
  public static final String RIGHT = "right";
  public static final String TEXT_ALIGN = "textAlign";
  public static final String TOP = "top";
  public static final String VIEW_CLASS_NAME = "RCTView";
  public static final String WIDTH = "width";
  
  public static boolean isLayoutOnly(String paramString)
  {
    return LAYOUT_ONLY_PROPS.contains(paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\uimanager\ViewProps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */