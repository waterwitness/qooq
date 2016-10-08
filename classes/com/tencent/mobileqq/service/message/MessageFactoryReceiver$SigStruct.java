package com.tencent.mobileqq.service.message;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class MessageFactoryReceiver$SigStruct
{
  public byte[] a;
  public byte[] b;
  
  public MessageFactoryReceiver$SigStruct(MessageFactoryReceiver paramMessageFactoryReceiver, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte1;
    this.b = paramArrayOfByte2;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\service\message\MessageFactoryReceiver$SigStruct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */