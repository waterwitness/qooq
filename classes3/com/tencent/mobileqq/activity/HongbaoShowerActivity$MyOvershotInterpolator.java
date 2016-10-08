package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.animation.OvershootInterpolator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.portal.SanHuaView;

public class HongbaoShowerActivity$MyOvershotInterpolator
  extends OvershootInterpolator
{
  private boolean jdField_a_of_type_Boolean;
  
  public HongbaoShowerActivity$MyOvershotInterpolator(HongbaoShowerActivity paramHongbaoShowerActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public float getInterpolation(float paramFloat)
  {
    if ((!this.jdField_a_of_type_Boolean) && (paramFloat > 0.7D))
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqActivityHongbaoShowerActivity.jdField_a_of_type_AndroidViewView.setBackgroundColor(-16777216);
      this.jdField_a_of_type_ComTencentMobileqqActivityHongbaoShowerActivity.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_ComTencentMobileqqActivityHongbaoShowerActivity.jdField_a_of_type_AndroidViewAnimationAlphaAnimation);
      HongbaoShowerActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityHongbaoShowerActivity).a();
    }
    return (float)(1.0D - Math.pow(2.718281828459045D, 5.0F * -paramFloat) * Math.cos(8.0F * paramFloat));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\HongbaoShowerActivity$MyOvershotInterpolator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */