package com.tencent.biz.qrcode;

import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class QRActionEntity$QRActionTLV
{
  int jdField_a_of_type_Int;
  short jdField_a_of_type_Short;
  byte[] jdField_a_of_type_ArrayOfByte;
  
  public QRActionEntity$QRActionTLV()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Short = 0;
    this.jdField_a_of_type_ArrayOfByte = null;
  }
  
  public QRActionEntity$QRActionTLV(int paramInt, short paramShort, byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Short = 0;
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_Short = paramShort;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ArrayOfByte.length + 4;
  }
  
  public long a()
  {
    return QRUtils.a(this.jdField_a_of_type_ArrayOfByte);
  }
  
  public String a()
  {
    return new String(this.jdField_a_of_type_ArrayOfByte);
  }
  
  public String toString()
  {
    return String.format("{t: %s, l: %s, v: %s}", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Short.valueOf(this.jdField_a_of_type_Short), this.jdField_a_of_type_ArrayOfByte });
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\biz\qrcode\QRActionEntity$QRActionTLV.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */