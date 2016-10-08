package com.tencent.mobileqq.ptt;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class LSRecordAnimations$TrackAlphaAnimation
  extends AlphaAnimation
{
  private float jdField_a_of_type_Float;
  private Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener;
  private LSRecordAnimations.TrackInfo jdField_a_of_type_ComTencentMobileqqPttLSRecordAnimations$TrackInfo;
  private float b;
  
  public LSRecordAnimations$TrackAlphaAnimation(float paramFloat1, float paramFloat2, LSRecordAnimations.TrackInfo paramTrackInfo)
  {
    super(paramFloat1, paramFloat2);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Float = paramFloat1;
    this.b = paramFloat2;
    this.jdField_a_of_type_ComTencentMobileqqPttLSRecordAnimations$TrackInfo = paramTrackInfo;
  }
  
  public void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    super.applyTransformation(paramFloat, paramTransformation);
    if ((this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener != null) && ((this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener instanceof LSRecordAnimations.LSRecordAnimationCallback))) {
      ((LSRecordAnimations.LSRecordAnimationCallback)this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener).a(this, paramFloat);
    }
    float f = 0.0F;
    if (this.jdField_a_of_type_ComTencentMobileqqPttLSRecordAnimations$TrackInfo != null)
    {
      f = this.jdField_a_of_type_Float + (this.b - this.jdField_a_of_type_Float) * paramFloat;
      this.jdField_a_of_type_ComTencentMobileqqPttLSRecordAnimations$TrackInfo.b = f;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS applyTransformation: " + paramFloat + " Alpha: " + f);
    }
  }
  
  public void setAnimationListener(Animation.AnimationListener paramAnimationListener)
  {
    super.setAnimationListener(paramAnimationListener);
    this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = paramAnimationListener;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\ptt\LSRecordAnimations$TrackAlphaAnimation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */