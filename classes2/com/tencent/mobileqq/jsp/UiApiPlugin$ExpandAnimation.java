package com.tencent.mobileqq.jsp;

import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class UiApiPlugin$ExpandAnimation
  extends Animation
{
  int jdField_a_of_type_Int;
  View jdField_a_of_type_AndroidViewView;
  
  public UiApiPlugin$ExpandAnimation(UiApiPlugin paramUiApiPlugin, View paramView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidViewView = paramView;
    int i = View.MeasureSpec.makeMeasureSpec(0, 0);
    int j = View.MeasureSpec.makeMeasureSpec(0, 0);
    this.jdField_a_of_type_AndroidViewView.measure(i, j);
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
    paramUiApiPlugin = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    paramUiApiPlugin.height = 0;
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramUiApiPlugin);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    paramTransformation = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    paramTransformation.height = ((int)(this.jdField_a_of_type_Int * paramFloat));
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramTransformation);
  }
  
  public boolean willChangeBounds()
  {
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\jsp\UiApiPlugin$ExpandAnimation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */