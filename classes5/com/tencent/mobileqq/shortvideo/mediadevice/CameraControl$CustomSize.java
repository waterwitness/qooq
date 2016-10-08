package com.tencent.mobileqq.shortvideo.mediadevice;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class CameraControl$CustomSize
{
  private double a;
  public int a;
  public int b;
  
  public CameraControl$CustomSize()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public CameraControl$CustomSize(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_Double = (paramInt1 / paramInt2);
  }
  
  public double a()
  {
    if (this.jdField_a_of_type_Double == 0.0D) {
      this.jdField_a_of_type_Double = (this.jdField_a_of_type_Int / this.b);
    }
    return this.jdField_a_of_type_Double;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof CustomSize)) {
        return false;
      }
      paramObject = (CustomSize)paramObject;
    } while ((this.jdField_a_of_type_Int == ((CustomSize)paramObject).jdField_a_of_type_Int) && (this.b == ((CustomSize)paramObject).b));
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\mediadevice\CameraControl$CustomSize.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */