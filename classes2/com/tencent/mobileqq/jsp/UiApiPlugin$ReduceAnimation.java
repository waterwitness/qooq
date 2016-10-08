package com.tencent.mobileqq.jsp;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class UiApiPlugin$ReduceAnimation
  extends Animation
{
  int jdField_a_of_type_Int;
  View jdField_a_of_type_AndroidViewView;
  
  public UiApiPlugin$ReduceAnimation(UiApiPlugin paramUiApiPlugin, View paramView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    paramTransformation = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    paramTransformation.height = ((int)(this.jdField_a_of_type_Int * (1.0F - paramFloat)));
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramTransformation);
    if (paramFloat == 1.0F)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      paramTransformation.height = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramTransformation);
    }
  }
  
  public boolean willChangeBounds()
  {
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\jsp\UiApiPlugin$ReduceAnimation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */