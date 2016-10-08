package com.tencent.mobileqq.activity.aio.anim;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class PathDemo
  implements AnimationPath
{
  double jdField_a_of_type_Double;
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  
  public PathDemo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(long paramLong, AnimationPath.Values paramValues)
  {
    paramValues.jdField_c_of_type_Int = ((int)(this.jdField_a_of_type_Int + this.jdField_a_of_type_Float * (float)paramLong));
    paramValues.d = ((int)(this.b + 0.8D * paramLong));
    paramValues.f = ((float)((Math.sin((float)paramLong / 500.0F) + 1.0D) / 2.0D));
    float f1 = (float)paramLong / 2.0F;
    paramValues.b = ((float)(f1 * Math.sin(this.jdField_a_of_type_Double)));
    paramValues.jdField_c_of_type_Float = ((float)(f1 * Math.cos(this.jdField_a_of_type_Double)));
    if ((paramValues.jdField_c_of_type_Int < -this.jdField_c_of_type_Int) || (paramValues.d < -this.d) || (paramValues.jdField_c_of_type_Int > this.e + this.jdField_c_of_type_Int) || (paramValues.d > this.f + this.d)) {
      return -1;
    }
    return 16;
  }
  
  public int a(AnimationPath.Values paramValues, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_Int = (paramInt3 / 2);
    this.b = 0;
    this.jdField_a_of_type_Float = ((float)(Math.random() - 0.5D));
    this.jdField_c_of_type_Int = (paramInt1 / 2);
    this.d = (paramInt2 / 2);
    this.e = paramInt3;
    this.f = paramInt4;
    paramValues.jdField_c_of_type_Int = this.jdField_a_of_type_Int;
    paramValues.d = this.b;
    this.jdField_a_of_type_Double = (Math.random() * 2.0D * 3.141592653589793D);
    return 1;
  }
  
  public PathDemo a()
  {
    return new PathDemo();
  }
  
  public boolean a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\anim\PathDemo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */