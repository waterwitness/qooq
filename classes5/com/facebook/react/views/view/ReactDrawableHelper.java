package com.facebook.react.views.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.TypedValue;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.SoftAssertions;

class ReactDrawableHelper
{
  private static final TypedValue sResolveOutValue = new TypedValue();
  
  public static Drawable createDrawableFromJSDescription(Context paramContext, ReadableMap paramReadableMap)
  {
    String str = paramReadableMap.getString("type");
    if ("ThemeAttrAndroid".equals(str))
    {
      paramReadableMap = paramReadableMap.getString("attribute");
      SoftAssertions.assertNotNull(paramReadableMap);
      int i = paramContext.getResources().getIdentifier(paramReadableMap, "attr", "android");
      if (i == 0) {
        throw new JSApplicationIllegalArgumentException("Attribute " + paramReadableMap + " couldn't be found in the resource list");
      }
      if (paramContext.getTheme().resolveAttribute(i, sResolveOutValue, true))
      {
        i = Build.VERSION.SDK_INT;
        paramContext = paramContext.getResources().getDrawable(sResolveOutValue.resourceId);
      }
    }
    do
    {
      return paramContext;
      throw new JSApplicationIllegalArgumentException("Attribute " + paramReadableMap + " couldn't be resolved into a drawable");
      if (!"RippleAndroid".equals(str)) {
        break;
      }
      if (Build.VERSION.SDK_INT < 21) {
        throw new JSApplicationIllegalArgumentException("Ripple drawable is not available on android API <21");
      }
      if ((paramReadableMap.hasKey("color")) && (!paramReadableMap.isNull("color"))) {
        paramReadableMap.getInt("color");
      }
      paramContext = null;
    } while ((paramReadableMap.hasKey("borderless")) && (!paramReadableMap.isNull("borderless")) && (paramReadableMap.getBoolean("borderless")));
    return new ColorDrawable(-1);
    throw new JSApplicationIllegalArgumentException("Invalid type for android drawable: " + str);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\views\view\ReactDrawableHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */