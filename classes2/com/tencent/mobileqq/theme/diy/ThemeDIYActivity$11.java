package com.tencent.mobileqq.theme.diy;

import android.view.animation.Transformation;
import android.widget.LinearLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.utils.ValueAnimation.AnimationUpdateListener;

class ThemeDIYActivity$11
  implements ValueAnimation.AnimationUpdateListener
{
  ThemeDIYActivity$11(ThemeDIYActivity paramThemeDIYActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationUpdate(ValueAnimation paramValueAnimation, float paramFloat, Integer paramInteger, Transformation paramTransformation)
  {
    this.this$0.stylePanel.getLayoutParams().height = paramInteger.intValue();
    this.this$0.stylePanel.requestLayout();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\theme\diy\ThemeDIYActivity$11.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */