package com.facebook.drawee.drawable;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import javax.annotation.Nullable;

public class DrawableUtils
{
  public static void copyProperties(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    if ((paramDrawable2 == null) || (paramDrawable1 == null) || (paramDrawable1 == paramDrawable2)) {
      return;
    }
    paramDrawable1.setBounds(paramDrawable2.getBounds());
    paramDrawable1.setChangingConfigurations(paramDrawable2.getChangingConfigurations());
    paramDrawable1.setLevel(paramDrawable2.getLevel());
    paramDrawable1.setVisible(paramDrawable2.isVisible(), false);
    paramDrawable1.setState(paramDrawable2.getState());
  }
  
  public static int getOpacityFromColor(int paramInt)
  {
    paramInt >>>= 24;
    if (paramInt == 255) {
      return -1;
    }
    if (paramInt == 0) {
      return -2;
    }
    return -3;
  }
  
  public static int multiplyColorAlpha(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 255) {
      return paramInt1;
    }
    if (paramInt2 == 0) {
      return paramInt1 & 0xFFFFFF;
    }
    return (paramInt1 >>> 24) * (paramInt2 + (paramInt2 >> 7)) >> 8 << 24 | 0xFFFFFF & paramInt1;
  }
  
  public static void setCallbacks(Drawable paramDrawable, @Nullable Drawable.Callback paramCallback, @Nullable TransformCallback paramTransformCallback)
  {
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(paramCallback);
      if ((paramDrawable instanceof TransformAwareDrawable)) {
        ((TransformAwareDrawable)paramDrawable).setTransformCallback(paramTransformCallback);
      }
    }
  }
  
  public static void setDrawableProperties(Drawable paramDrawable, DrawableProperties paramDrawableProperties)
  {
    if ((paramDrawable == null) || (paramDrawableProperties == null)) {
      return;
    }
    paramDrawableProperties.applyTo(paramDrawable);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\drawee\drawable\DrawableUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */