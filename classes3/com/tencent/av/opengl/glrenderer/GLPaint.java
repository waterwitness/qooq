package com.tencent.av.opengl.glrenderer;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import junit.framework.Assert;

public class GLPaint
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  
  public GLPaint()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Float = 1.0F;
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a(float paramFloat)
  {
    if (paramFloat >= 0.0F) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.jdField_a_of_type_Float = paramFloat;
      return;
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\opengl\glrenderer\GLPaint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */