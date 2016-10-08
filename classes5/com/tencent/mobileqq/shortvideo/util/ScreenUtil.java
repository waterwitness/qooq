package com.tencent.mobileqq.shortvideo.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;

public class ScreenUtil
{
  private static float jdField_a_of_type_Float;
  public static int a;
  private static Context jdField_a_of_type_AndroidContentContext;
  public static int b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_AndroidContentContext = VideoEnvironment.a();
    jdField_a_of_type_Int = 320;
    b = 480;
    WindowManager localWindowManager = (WindowManager)jdField_a_of_type_AndroidContentContext.getSystemService("window");
    jdField_a_of_type_Int = localWindowManager.getDefaultDisplay().getWidth();
    b = localWindowManager.getDefaultDisplay().getHeight();
  }
  
  public static int a(float paramFloat)
  {
    if (jdField_a_of_type_Float == 0.0F) {
      jdField_a_of_type_Float = jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ScreenUtil", 2, "[@] ScreenUtil.dip2px DENSITY = " + jdField_a_of_type_Float);
    }
    return (int)(jdField_a_of_type_Float * paramFloat + 0.5F);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\util\ScreenUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */