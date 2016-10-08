package com.tencent.widget.immersive;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.util.TypedValue;
import android.view.Window;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class SystemBarTintManager$SystemBarConfig
{
  private static final String jdField_a_of_type_JavaLangString = "status_bar_height";
  private final int jdField_a_of_type_Int;
  private final boolean jdField_a_of_type_Boolean;
  private final boolean b;
  
  private SystemBarTintManager$SystemBarConfig(Window paramWindow, boolean paramBoolean)
  {
    boolean bool2 = NotVerifyClass.DO_VERIFY_CLASS;
    if (paramWindow.getContext().getResources().getConfiguration().orientation == 1) {}
    for (;;)
    {
      this.b = bool1;
      this.jdField_a_of_type_Int = ImmersiveUtils.a(paramWindow.getContext());
      this.jdField_a_of_type_Boolean = paramBoolean;
      return;
      bool1 = false;
    }
  }
  
  private int a(Context paramContext)
  {
    int i = 0;
    if (Build.VERSION.SDK_INT >= 14)
    {
      TypedValue localTypedValue = new TypedValue();
      paramContext.getTheme().resolveAttribute(16843499, localTypedValue, true);
      i = TypedValue.complexToDimensionPixelSize(localTypedValue.data, paramContext.getResources().getDisplayMetrics());
    }
    return i;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\widget\immersive\SystemBarTintManager$SystemBarConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */