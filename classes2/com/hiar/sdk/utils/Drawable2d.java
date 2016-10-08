package com.hiar.sdk.utils;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.nio.FloatBuffer;

public class Drawable2d
{
  private static final int jdField_a_of_type_Int = 4;
  private static final FloatBuffer jdField_a_of_type_JavaNioFloatBuffer = GlUtil.a(jdField_a_of_type_ArrayOfFloat);
  public static float[] a;
  private static final FloatBuffer jdField_b_of_type_JavaNioFloatBuffer = GlUtil.a(jdField_b_of_type_ArrayOfFloat);
  private static final float[] jdField_b_of_type_ArrayOfFloat;
  private int jdField_b_of_type_Int = jdField_a_of_type_ArrayOfFloat.length / this.jdField_c_of_type_Int;
  private int jdField_c_of_type_Int = 2;
  private FloatBuffer jdField_c_of_type_JavaNioFloatBuffer = jdField_a_of_type_JavaNioFloatBuffer;
  private int jdField_d_of_type_Int = this.jdField_c_of_type_Int * 4;
  private FloatBuffer jdField_d_of_type_JavaNioFloatBuffer = jdField_b_of_type_JavaNioFloatBuffer;
  private int e = 8;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ArrayOfFloat = new float[] { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
    jdField_b_of_type_ArrayOfFloat = new float[] { 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F };
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public FloatBuffer a()
  {
    return this.jdField_c_of_type_JavaNioFloatBuffer;
  }
  
  public int b()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public FloatBuffer b()
  {
    return this.jdField_d_of_type_JavaNioFloatBuffer;
  }
  
  public int c()
  {
    return this.e;
  }
  
  public int d()
  {
    return this.jdField_c_of_type_Int;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\hiar\sdk\utils\Drawable2d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */