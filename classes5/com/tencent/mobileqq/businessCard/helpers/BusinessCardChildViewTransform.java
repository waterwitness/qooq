package com.tencent.mobileqq.businessCard.helpers;

import android.graphics.Rect;
import android.view.View;
import android.view.animation.Interpolator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class BusinessCardChildViewTransform
{
  public float a;
  public int a;
  public Rect a;
  public boolean a;
  public float b;
  public int b;
  public float c;
  
  public BusinessCardChildViewTransform()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_b_of_type_Float = 1.0F;
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
  }
  
  public BusinessCardChildViewTransform(BusinessCardChildViewTransform paramBusinessCardChildViewTransform)
  {
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_b_of_type_Float = 1.0F;
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_Int = paramBusinessCardChildViewTransform.jdField_a_of_type_Int;
    this.jdField_b_of_type_Int = paramBusinessCardChildViewTransform.jdField_b_of_type_Int;
    this.jdField_a_of_type_Float = paramBusinessCardChildViewTransform.jdField_a_of_type_Float;
    this.jdField_b_of_type_Float = paramBusinessCardChildViewTransform.jdField_b_of_type_Float;
    this.jdField_a_of_type_Boolean = paramBusinessCardChildViewTransform.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_AndroidGraphicsRect.set(paramBusinessCardChildViewTransform.jdField_a_of_type_AndroidGraphicsRect);
    this.c = paramBusinessCardChildViewTransform.c;
  }
  
  public static void a(View paramView)
  {
    ViewHelper.f(paramView, 0.0F);
    ViewHelper.g(paramView, 0.0F);
    ViewHelper.b(paramView, 1.0F);
    ViewHelper.c(paramView, 1.0F);
    ViewHelper.a(paramView, 1.0F);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_b_of_type_Float = 1.0F;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidGraphicsRect.setEmpty();
    this.c = 0.0F;
  }
  
  public void a(View paramView, int paramInt, Interpolator paramInterpolator, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (b(ViewHelper.i(paramView))) {
      ViewHelper.g(paramView, this.jdField_b_of_type_Int);
    }
    if (a(ViewHelper.b(paramView)))
    {
      ViewHelper.b(paramView, this.jdField_a_of_type_Float);
      ViewHelper.c(paramView, this.jdField_a_of_type_Float);
    }
  }
  
  public boolean a(float paramFloat)
  {
    return Float.compare(this.jdField_a_of_type_Float, paramFloat) != 0;
  }
  
  public boolean b(float paramFloat)
  {
    return Float.compare(this.jdField_b_of_type_Int, paramFloat) != 0;
  }
  
  public String toString()
  {
    return "TaskViewTransform delay: " + this.jdField_a_of_type_Int + " y: " + this.jdField_b_of_type_Int + " scale: " + this.jdField_a_of_type_Float + " alpha: " + this.jdField_b_of_type_Float + " visible: " + this.jdField_a_of_type_Boolean + " rect: " + this.jdField_a_of_type_AndroidGraphicsRect + " p: " + this.c;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\businessCard\helpers\BusinessCardChildViewTransform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */