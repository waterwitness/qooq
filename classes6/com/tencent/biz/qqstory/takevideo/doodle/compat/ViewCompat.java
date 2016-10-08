package com.tencent.biz.qqstory.takevideo.doodle.compat;

import android.os.Build.VERSION;
import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ViewCompat
{
  public ViewCompat()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static float a(View paramView)
  {
    if (paramView == null) {}
    while (Build.VERSION.SDK_INT < 11) {
      return 0.0F;
    }
    return paramView.getX();
  }
  
  public static void a(View paramView, float paramFloat)
  {
    if (paramView == null) {}
    while (Build.VERSION.SDK_INT < 11) {
      return;
    }
    paramView.setAlpha(paramFloat);
  }
  
  public static float b(View paramView)
  {
    if (paramView == null) {}
    while (Build.VERSION.SDK_INT < 11) {
      return 0.0F;
    }
    return paramView.getY();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\doodle\compat\ViewCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */