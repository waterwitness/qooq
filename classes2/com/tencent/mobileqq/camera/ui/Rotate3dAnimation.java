package com.tencent.mobileqq.camera.ui;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class Rotate3dAnimation
  extends Animation
{
  public static final int a = 1;
  private static final String jdField_a_of_type_JavaLangString = "Q.camera.Rotate3d";
  public static final int b = 2;
  private final float jdField_a_of_type_Float;
  private Camera jdField_a_of_type_AndroidGraphicsCamera;
  private Rotate3dAnimation.InterpolatedTimeListener jdField_a_of_type_ComTencentMobileqqCameraUiRotate3dAnimation$InterpolatedTimeListener;
  private final float b;
  private final float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private final float d;
  private final float e;
  
  public Rotate3dAnimation(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Float = paramFloat1;
    this.b = paramFloat2;
    this.jdField_c_of_type_Float = paramFloat3;
    this.d = paramFloat4;
    this.e = paramFloat5;
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void a(Rotate3dAnimation.InterpolatedTimeListener paramInterpolatedTimeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqCameraUiRotate3dAnimation$InterpolatedTimeListener = paramInterpolatedTimeListener;
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    int i = 1;
    if (this.jdField_a_of_type_ComTencentMobileqqCameraUiRotate3dAnimation$InterpolatedTimeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqCameraUiRotate3dAnimation$InterpolatedTimeListener.a(paramFloat);
    }
    float f1;
    float f2;
    if (this.jdField_c_of_type_Int == 1)
    {
      f1 = 180.0F;
      f2 = 0.0F;
    }
    for (;;)
    {
      f2 = (f1 - f2) * paramFloat + f2;
      if (paramFloat > 0.5F) {}
      for (;;)
      {
        f1 = f2;
        if (i != 0) {
          f1 = f2 - 180.0F;
        }
        paramFloat = Math.abs(paramFloat - 0.5F);
        f2 = this.e;
        paramTransformation = paramTransformation.getMatrix();
        this.jdField_a_of_type_AndroidGraphicsCamera.save();
        this.jdField_a_of_type_AndroidGraphicsCamera.translate(0.0F, 0.0F, (0.5F - paramFloat) * f2);
        this.jdField_a_of_type_AndroidGraphicsCamera.rotateY(f1);
        this.jdField_a_of_type_AndroidGraphicsCamera.getMatrix(paramTransformation);
        this.jdField_a_of_type_AndroidGraphicsCamera.restore();
        paramTransformation.preTranslate(-this.jdField_c_of_type_Float, -this.d);
        paramTransformation.postTranslate(this.jdField_c_of_type_Float, this.d);
        return;
        if (this.jdField_c_of_type_Int != 2) {
          break label184;
        }
        f2 = 360.0F;
        f1 = 180.0F;
        break;
        i = 0;
      }
      label184:
      f1 = 0.0F;
      f2 = 0.0F;
    }
  }
  
  public void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_AndroidGraphicsCamera = new Camera();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\camera\ui\Rotate3dAnimation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */