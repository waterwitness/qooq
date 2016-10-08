package cooperation.qwallet.plugin;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.NetworkUtil;

public class PropertyUtils
{
  private static int jdField_a_of_type_Int;
  private static String jdField_a_of_type_JavaLangString;
  private static int b;
  private static int c = -1;
  private static int d;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a(Activity paramActivity)
  {
    if (jdField_a_of_type_Int > 0) {
      return jdField_a_of_type_Int;
    }
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    jdField_a_of_type_Int = localDisplayMetrics.widthPixels;
    return jdField_a_of_type_Int;
  }
  
  public static int a(Context paramContext)
  {
    if (b > 0) {
      return b;
    }
    b = paramContext.getResources().getDimensionPixelSize(2131492908) - (int)DisplayUtils.a(paramContext, 5.0F);
    return b;
  }
  
  public static String a(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    if (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
      return jdField_a_of_type_JavaLangString;
    }
    int i = NetworkUtil.a(paramContext.getApplicationContext());
    if (i == 1) {
      jdField_a_of_type_JavaLangString = "WIFI";
    }
    for (;;)
    {
      return jdField_a_of_type_JavaLangString;
      if (i == 2) {
        jdField_a_of_type_JavaLangString = "2G";
      } else if (i == 3) {
        jdField_a_of_type_JavaLangString = "3G";
      } else if (i == 4) {
        jdField_a_of_type_JavaLangString = "4G";
      } else {
        jdField_a_of_type_JavaLangString = "unknown";
      }
    }
  }
  
  public static int b(Activity paramActivity)
  {
    if (c >= 0) {
      return c;
    }
    Rect localRect;
    if ((paramActivity != null) && (paramActivity.getWindow() != null) && (paramActivity.getWindow().getDecorView() != null))
    {
      localRect = new Rect();
      paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
    }
    for (c = localRect.top;; c = 0) {
      return c;
    }
  }
  
  public static int c(Activity paramActivity)
  {
    if (d > 0) {
      return d;
    }
    d = paramActivity.getResources().getDimensionPixelSize(2131492908);
    return d;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qwallet\plugin\PropertyUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */