package com.facebook.react.views.image;

import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import javax.annotation.Nullable;

public class ImageResizeMode
{
  public static ScalingUtils.ScaleType defaultValue()
  {
    return ScalingUtils.ScaleType.CENTER_CROP;
  }
  
  public static ScalingUtils.ScaleType toScaleType(@Nullable String paramString)
  {
    if ("contain".equals(paramString)) {
      return ScalingUtils.ScaleType.FIT_CENTER;
    }
    if ("cover".equals(paramString)) {
      return ScalingUtils.ScaleType.CENTER_CROP;
    }
    if ("stretch".equals(paramString)) {
      return ScalingUtils.ScaleType.FIT_XY;
    }
    if (paramString == null) {
      return defaultValue();
    }
    throw new JSApplicationIllegalArgumentException("Invalid resize mode: '" + paramString + "'");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\views\image\ImageResizeMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */