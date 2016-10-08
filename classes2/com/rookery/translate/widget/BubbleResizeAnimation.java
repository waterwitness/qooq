package com.rookery.translate.widget;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class BubbleResizeAnimation
  extends Animation
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private RelativeLayout.LayoutParams jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  private int b;
  private int c;
  private int d;
  
  public BubbleResizeAnimation(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    setDuration(paramInt1);
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = ((RelativeLayout.LayoutParams)paramView.getLayoutParams());
    this.b = paramView.getMeasuredHeight();
    this.jdField_a_of_type_Int = paramView.getMeasuredWidth();
    this.d = (this.b + paramInt3);
    this.c = (this.jdField_a_of_type_Int + paramInt2);
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    super.applyTransformation(paramFloat, paramTransformation);
    if (paramFloat < 1.0F)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.height = (this.b + (int)((this.d - this.b) * paramFloat));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.width = (this.jdField_a_of_type_Int + (int)((this.c - this.jdField_a_of_type_Int) * paramFloat));
      this.jdField_a_of_type_AndroidViewView.requestLayout();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\rookery\translate\widget\BubbleResizeAnimation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */