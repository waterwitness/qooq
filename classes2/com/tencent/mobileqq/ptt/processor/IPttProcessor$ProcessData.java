package com.tencent.mobileqq.ptt.processor;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class IPttProcessor$ProcessData
{
  public int a;
  public byte[] a;
  public int b;
  
  public IPttProcessor$ProcessData(byte[] paramArrayOfByte, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.b = 0;
  }
  
  public IPttProcessor$ProcessData(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.b = paramInt1;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\ptt\processor\IPttProcessor$ProcessData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */