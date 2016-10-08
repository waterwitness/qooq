package com.tencent.mobileqq.bubble;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class PathPoint
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public float a;
  public float b;
  public float c;
  public float d;
  public int d;
  public float e;
  public float f;
  public float g;
  public float h;
  
  public PathPoint(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    this.jdField_d_of_type_Float = 1.0F;
    this.e = paramFloat1;
    this.f = paramFloat2;
    this.g = paramFloat3;
    this.h = paramFloat4;
    this.a = paramFloat5;
    this.b = paramFloat6;
    this.jdField_d_of_type_Int = 2;
  }
  
  public PathPoint(int paramInt, float paramFloat1, float paramFloat2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_d_of_type_Float = 1.0F;
    this.jdField_d_of_type_Int = paramInt;
    this.a = paramFloat1;
    this.b = paramFloat2;
  }
  
  public static PathPoint a(float paramFloat1, float paramFloat2)
  {
    return new PathPoint(1, paramFloat1, paramFloat2);
  }
  
  public static PathPoint a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    return new PathPoint(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6);
  }
  
  public static PathPoint b(float paramFloat1, float paramFloat2)
  {
    return new PathPoint(0, paramFloat1, paramFloat2);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\bubble\PathPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */