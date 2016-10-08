package com.tencent.mobileqq.shortvideo.hwcodec;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class SVHwVideoFpsSmooth
{
  private float jdField_a_of_type_Float;
  private long jdField_a_of_type_Long;
  private float jdField_b_of_type_Float;
  private long jdField_b_of_type_Long;
  private float jdField_c_of_type_Float;
  private long jdField_c_of_type_Long;
  
  public SVHwVideoFpsSmooth()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public long a(float paramFloat)
  {
    this.jdField_b_of_type_Long += (1000.0F * paramFloat);
    return this.jdField_b_of_type_Long;
  }
  
  public long a(long paramLong)
  {
    int i = 1;
    if (this.jdField_a_of_type_Long == 0L)
    {
      this.jdField_a_of_type_Long = (paramLong * 1000L);
      this.jdField_b_of_type_Long = (paramLong * 1000L);
      this.jdField_c_of_type_Long = paramLong;
      i = 0;
    }
    float f1 = (float)(paramLong - this.jdField_c_of_type_Long);
    if (i != 0) {
      if (f1 > this.jdField_b_of_type_Float)
      {
        f1 = this.jdField_b_of_type_Float;
        f2 = f1;
        if (f1 >= this.jdField_c_of_type_Float) {}
      }
    }
    for (float f2 = this.jdField_c_of_type_Float;; f2 = f1)
    {
      this.jdField_c_of_type_Long = paramLong;
      this.jdField_a_of_type_Long += (f2 * 1000.0F);
      return this.jdField_a_of_type_Long;
      break;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_b_of_type_Float = 0.0F;
    this.jdField_c_of_type_Float = 0.0F;
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = ((float)(1000.0D / paramFloat));
    this.jdField_b_of_type_Float = (this.jdField_a_of_type_Float + 0.3F);
    this.jdField_c_of_type_Float = (this.jdField_a_of_type_Float - 0.7F);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\hwcodec\SVHwVideoFpsSmooth.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */