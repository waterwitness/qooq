package com.facebook.react.views.text;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;

public final class DefaultStyleValuesUtil
{
  private DefaultStyleValuesUtil()
  {
    throw new AssertionError("Never invoke this for an Utility class!");
  }
  
  public static ColorStateList getDefaultTextColor(Context paramContext)
  {
    Object localObject1 = paramContext.getTheme();
    paramContext = null;
    try
    {
      localObject1 = ((Resources.Theme)localObject1).obtainStyledAttributes(new int[] { 16842904 });
      paramContext = (Context)localObject1;
      ColorStateList localColorStateList = ((TypedArray)localObject1).getColorStateList(0);
      if (localObject1 != null) {
        ((TypedArray)localObject1).recycle();
      }
      return localColorStateList;
    }
    finally
    {
      if (paramContext != null) {
        paramContext.recycle();
      }
    }
  }
  
  public static ColorStateList getDefaultTextColorHint(Context paramContext)
  {
    Object localObject1 = paramContext.getTheme();
    paramContext = null;
    try
    {
      localObject1 = ((Resources.Theme)localObject1).obtainStyledAttributes(new int[] { 16842906 });
      paramContext = (Context)localObject1;
      ColorStateList localColorStateList = ((TypedArray)localObject1).getColorStateList(0);
      if (localObject1 != null) {
        ((TypedArray)localObject1).recycle();
      }
      return localColorStateList;
    }
    finally
    {
      if (paramContext != null) {
        paramContext.recycle();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\views\text\DefaultStyleValuesUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */