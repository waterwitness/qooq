package com.tencent.mobileqq.troop.activity;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.widget.AutoLocationMapView;

public class TroopCreateMapViewSupportActivity$TroopCreateMapViewAnimation
  extends Animation
{
  private final int jdField_a_of_type_Int;
  private final int b;
  
  public TroopCreateMapViewSupportActivity$TroopCreateMapViewAnimation(TroopCreateMapViewSupportActivity paramTroopCreateMapViewSupportActivity, int paramInt1, int paramInt2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = (paramInt2 - paramInt1);
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    paramTransformation = this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopCreateMapViewSupportActivity.a.getLayoutParams();
    paramTransformation.height = ((int)(this.jdField_a_of_type_Int + this.b * paramFloat));
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopCreateMapViewSupportActivity.a.setLayoutParams(paramTransformation);
  }
  
  public boolean willChangeBounds()
  {
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\activity\TroopCreateMapViewSupportActivity$TroopCreateMapViewAnimation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */