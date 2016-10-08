package com.tencent.biz.qqstory.takevideo.doodle.util;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.MotionEvent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class GestureHelper
{
  public static final int a = 200;
  private static final String jdField_a_of_type_JavaLangString = "GestureHelper";
  private float jdField_a_of_type_Float;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix;
  private GestureHelper.ZoomItem jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private final int jdField_b_of_type_Int;
  private Matrix jdField_b_of_type_AndroidGraphicsMatrix;
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  private final int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private float jdField_d_of_type_Float;
  private final int jdField_d_of_type_Int;
  private float jdField_e_of_type_Float;
  private int jdField_e_of_type_Int;
  private float f;
  private float g;
  private float h;
  private float i;
  private float j;
  private float k;
  
  public GestureHelper()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 1;
    this.jdField_d_of_type_Int = 2;
    this.jdField_e_of_type_Int = 0;
    this.k = 2.14748365E9F;
    this.jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
    this.jdField_b_of_type_AndroidGraphicsMatrix = new Matrix();
  }
  
  private void b(MotionEvent paramMotionEvent)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_e_of_type_Int = 1;
    float f1 = paramMotionEvent.getX(0);
    float f2 = paramMotionEvent.getY(0);
    this.jdField_a_of_type_Float = f1;
    this.jdField_b_of_type_Float = f2;
    this.g = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem.jdField_c_of_type_Float;
    this.h = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem.jdField_d_of_type_Float;
  }
  
  private void c(MotionEvent paramMotionEvent)
  {
    paramMotionEvent.getX(1);
    paramMotionEvent.getY(1);
    if (this.jdField_e_of_type_Int == 1)
    {
      this.jdField_e_of_type_Int = 2;
      this.i = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem.jdField_a_of_type_Float;
      this.j = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem.jdField_b_of_type_Float;
      this.g = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem.jdField_c_of_type_Float;
      this.h = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem.jdField_d_of_type_Float;
      this.jdField_c_of_type_Float = GestureUtil.a(paramMotionEvent);
      this.jdField_d_of_type_Float = GestureUtil.b(paramMotionEvent);
      paramMotionEvent = GestureUtil.a(paramMotionEvent);
      this.jdField_e_of_type_Float = paramMotionEvent[0];
      this.f = paramMotionEvent[1];
    }
  }
  
  private void d(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      b(paramMotionEvent);
    }
    do
    {
      do
      {
        return;
        if ((paramMotionEvent.getPointerCount() == 1) && (this.jdField_e_of_type_Int == 1))
        {
          if (this.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_Boolean = false;
            this.jdField_a_of_type_Float = paramMotionEvent.getX(0);
            this.jdField_b_of_type_Float = paramMotionEvent.getY(0);
            this.g = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem.jdField_c_of_type_Float;
            this.h = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem.jdField_d_of_type_Float;
            return;
          }
          f1 = paramMotionEvent.getX(0);
          f2 = this.jdField_a_of_type_Float;
          f3 = paramMotionEvent.getY(0);
          f4 = this.jdField_b_of_type_Float;
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem.jdField_c_of_type_Float = (f1 - f2 + this.g);
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem.jdField_d_of_type_Float = (f3 - f4 + this.h);
          return;
        }
      } while ((paramMotionEvent.getPointerCount() != 2) || (this.jdField_e_of_type_Int != 2));
      float f4 = GestureUtil.a(paramMotionEvent);
      float f1 = GestureUtil.b(paramMotionEvent);
      paramMotionEvent = GestureUtil.a(paramMotionEvent);
      float f2 = paramMotionEvent[0];
      float f3 = paramMotionEvent[1];
      paramMotionEvent = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem;
      float f5 = this.i;
      paramMotionEvent.jdField_a_of_type_Float = (f4 / this.jdField_c_of_type_Float * f5);
      paramMotionEvent = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem;
      f4 = this.j;
      paramMotionEvent.jdField_b_of_type_Float = ((f1 - this.jdField_d_of_type_Float + f4) % 360.0F);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem.jdField_c_of_type_Float = (this.g + (f2 - this.jdField_e_of_type_Float));
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem.jdField_d_of_type_Float = (this.h + (f3 - this.f));
      if (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem.jdField_a_of_type_Boolean) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem.jdField_a_of_type_Float > this.k) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem.jdField_a_of_type_Float = this.k;
      }
    } while (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem.jdField_b_of_type_Float >= 0.0F);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem.jdField_b_of_type_Float += 360.0F;
    return;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem.jdField_a_of_type_Float = this.i;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem.jdField_b_of_type_Float = this.j;
  }
  
  private void e(MotionEvent paramMotionEvent)
  {
    if (this.jdField_e_of_type_Int == 2)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_e_of_type_Int = 1;
    }
  }
  
  private void f(MotionEvent paramMotionEvent)
  {
    this.jdField_e_of_type_Int = 0;
    a();
  }
  
  public Matrix a(GestureHelper.ZoomItem paramZoomItem)
  {
    this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
    if (paramZoomItem == null) {
      return this.jdField_a_of_type_AndroidGraphicsMatrix;
    }
    this.jdField_a_of_type_AndroidGraphicsMatrix.postRotate(paramZoomItem.jdField_b_of_type_Float);
    this.jdField_a_of_type_AndroidGraphicsMatrix.postScale(paramZoomItem.jdField_a_of_type_Float, paramZoomItem.jdField_a_of_type_Float);
    this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(paramZoomItem.jdField_c_of_type_AndroidGraphicsPointF.x, paramZoomItem.jdField_c_of_type_AndroidGraphicsPointF.y);
    this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(paramZoomItem.jdField_c_of_type_Float, paramZoomItem.jdField_d_of_type_Float);
    return this.jdField_a_of_type_AndroidGraphicsMatrix;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem = null;
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_b_of_type_Float = 0.0F;
    this.jdField_c_of_type_Float = 0.0F;
    this.jdField_d_of_type_Float = 0.0F;
    this.jdField_e_of_type_Float = 0.0F;
    this.f = 0.0F;
    this.g = 0.0F;
    this.h = 0.0F;
    this.i = 0.0F;
    this.j = 0.0F;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
    this.jdField_b_of_type_AndroidGraphicsMatrix.reset();
  }
  
  public void a(float paramFloat)
  {
    this.k = paramFloat;
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem == null) {
      return;
    }
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    case 3: 
    case 4: 
    default: 
      return;
    case 0: 
      b(paramMotionEvent);
      return;
    case 5: 
      c(paramMotionEvent);
      return;
    case 2: 
      d(paramMotionEvent);
      return;
    case 6: 
      e(paramMotionEvent);
      return;
    }
    f(paramMotionEvent);
  }
  
  public void a(GestureHelper.ZoomItem paramZoomItem)
  {
    a();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem = paramZoomItem;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(GestureHelper.ZoomItem paramZoomItem, float paramFloat1, float paramFloat2)
  {
    if (paramZoomItem == null) {
      return false;
    }
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    b(paramZoomItem).mapPoints(arrayOfFloat);
    float f1 = paramZoomItem.jdField_e_of_type_Float;
    float f2 = paramZoomItem.f;
    paramFloat2 = f1;
    if (this.jdField_c_of_type_Boolean)
    {
      paramFloat1 = f1;
      if (paramZoomItem.jdField_a_of_type_Float * f1 < 200.0F) {
        paramFloat1 = 200.0F / paramZoomItem.jdField_a_of_type_Float;
      }
      paramFloat2 = paramFloat1;
      if (paramZoomItem.jdField_a_of_type_Float * f2 < 200.0F)
      {
        paramFloat2 = 200.0F / paramZoomItem.jdField_a_of_type_Float;
        f1 = paramFloat1;
        paramFloat1 = paramFloat2;
      }
    }
    for (;;)
    {
      paramFloat2 = f1 / 2.0F;
      paramFloat1 /= 2.0F;
      return (arrayOfFloat[0] >= -paramFloat2) && (arrayOfFloat[0] <= paramFloat2) && (arrayOfFloat[1] >= -paramFloat1) && (arrayOfFloat[1] <= paramFloat1);
      paramFloat1 = f2;
      f1 = paramFloat2;
    }
  }
  
  public boolean a(GestureHelper.ZoomItem paramZoomItem, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (paramZoomItem == null) {
      return false;
    }
    float[] arrayOfFloat1 = new float[2];
    arrayOfFloat1[0] = paramFloat1;
    arrayOfFloat1[1] = paramFloat2;
    float[] arrayOfFloat2 = new float[2];
    arrayOfFloat2[0] = paramFloat3;
    arrayOfFloat2[1] = paramFloat4;
    Matrix localMatrix = b(paramZoomItem);
    localMatrix.mapPoints(arrayOfFloat1);
    localMatrix.mapPoints(arrayOfFloat2);
    paramFloat3 = paramZoomItem.jdField_e_of_type_Float;
    paramFloat4 = paramZoomItem.f;
    paramFloat2 = paramFloat3;
    if (this.jdField_c_of_type_Boolean)
    {
      paramFloat1 = paramFloat3;
      if (paramZoomItem.jdField_a_of_type_Float * paramFloat3 < 200.0F) {
        paramFloat1 = 200.0F / paramZoomItem.jdField_a_of_type_Float;
      }
      paramFloat2 = paramFloat1;
      if (paramZoomItem.jdField_a_of_type_Float * paramFloat4 < 200.0F)
      {
        paramFloat2 = 200.0F / paramZoomItem.jdField_a_of_type_Float;
        paramFloat3 = paramFloat1;
        paramFloat1 = paramFloat2;
      }
    }
    for (;;)
    {
      paramFloat2 = paramFloat3 / 2.0F;
      paramFloat1 /= 2.0F;
      paramZoomItem = new RectF(-paramFloat2, -paramFloat1, paramFloat2, paramFloat1);
      return GestureUtil.a(new PointF(arrayOfFloat1[0], arrayOfFloat1[1]), new PointF(arrayOfFloat2[0], arrayOfFloat2[1]), paramZoomItem);
      paramFloat1 = paramFloat4;
      paramFloat3 = paramFloat2;
    }
  }
  
  public Matrix b(GestureHelper.ZoomItem paramZoomItem)
  {
    this.jdField_b_of_type_AndroidGraphicsMatrix.reset();
    if (paramZoomItem == null) {
      return this.jdField_b_of_type_AndroidGraphicsMatrix;
    }
    this.jdField_a_of_type_AndroidGraphicsMatrix = a(paramZoomItem);
    this.jdField_a_of_type_AndroidGraphicsMatrix.invert(this.jdField_b_of_type_AndroidGraphicsMatrix);
    return this.jdField_b_of_type_AndroidGraphicsMatrix;
  }
  
  public void b(GestureHelper.ZoomItem paramZoomItem)
  {
    if (paramZoomItem == null) {
      return;
    }
    paramZoomItem.jdField_a_of_type_Float = 1.0F;
    paramZoomItem.jdField_c_of_type_Float = 0.0F;
    paramZoomItem.jdField_d_of_type_Float = 0.0F;
    paramZoomItem.jdField_b_of_type_Float = 0.0F;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\doodle\util\GestureHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */