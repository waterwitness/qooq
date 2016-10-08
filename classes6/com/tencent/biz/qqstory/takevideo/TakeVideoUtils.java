package com.tencent.biz.qqstory.takevideo;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class TakeVideoUtils
{
  private static float jdField_a_of_type_Float;
  private static int jdField_a_of_type_Int;
  private static int b;
  
  public TakeVideoUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static float a(Resources paramResources)
  {
    if ((b == 0) || (jdField_a_of_type_Int == 0))
    {
      paramResources = paramResources.getDisplayMetrics();
      jdField_a_of_type_Int = paramResources.widthPixels;
      b = paramResources.heightPixels;
      jdField_a_of_type_Float = b * 1.0F / jdField_a_of_type_Int;
    }
    return jdField_a_of_type_Float;
  }
  
  public static float a(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getPointerCount() == 2)
    {
      float f1 = paramMotionEvent.getX(0) - paramMotionEvent.getX(1);
      float f2 = paramMotionEvent.getY(0) - paramMotionEvent.getY(1);
      return (float)Math.sqrt(f1 * f1 + f2 * f2);
    }
    return 0.0F;
  }
  
  public static int a(Resources paramResources)
  {
    if (jdField_a_of_type_Int == 0)
    {
      paramResources = paramResources.getDisplayMetrics();
      jdField_a_of_type_Int = paramResources.widthPixels;
      b = paramResources.heightPixels;
      jdField_a_of_type_Float = b * 1.0F / jdField_a_of_type_Int;
    }
    return jdField_a_of_type_Int;
  }
  
  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder("DeviceInfo:");
    localStringBuilder.append("PRODUCT=").append(Build.PRODUCT).append("|");
    localStringBuilder.append("MODEL=").append(Build.MODEL).append("|");
    localStringBuilder.append("BOARD=").append(Build.BOARD).append("|");
    localStringBuilder.append("BOOTLOADER=").append(Build.BOOTLOADER).append("|");
    localStringBuilder.append("CPU_ABI=").append(Build.CPU_ABI).append("|");
    localStringBuilder.append("CPU_ABI2=").append(Build.CPU_ABI2).append("|");
    localStringBuilder.append("DEVICE=").append(Build.DEVICE).append("|");
    localStringBuilder.append("DISPLAY=").append(Build.DISPLAY).append("|");
    localStringBuilder.append("FLNGERPRINT=").append(Build.FINGERPRINT).append("|");
    localStringBuilder.append("HARDWARE=").append(Build.HARDWARE).append("|");
    localStringBuilder.append("ID=").append(Build.ID).append("|");
    localStringBuilder.append("SERIAL=").append(Build.SERIAL).append("|");
    localStringBuilder.append("MANUFACTURER=").append(Build.MANUFACTURER).append("|");
    localStringBuilder.append("SDK_INT=").append(Build.VERSION.SDK_INT).append("|");
    return localStringBuilder.toString();
  }
  
  public static boolean a(View paramView, int paramInt1, int paramInt2)
  {
    Rect localRect = new Rect();
    int[] arrayOfInt = new int[2];
    paramView.getDrawingRect(localRect);
    paramView.getLocationOnScreen(arrayOfInt);
    localRect.offset(arrayOfInt[0], arrayOfInt[1]);
    return localRect.contains(paramInt1, paramInt2);
  }
  
  public static int b(Resources paramResources)
  {
    if (b == 0)
    {
      paramResources = paramResources.getDisplayMetrics();
      jdField_a_of_type_Int = paramResources.widthPixels;
      b = paramResources.heightPixels;
      jdField_a_of_type_Float = b * 1.0F / jdField_a_of_type_Int;
    }
    return b;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\TakeVideoUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */