package com.tencent.mobileqq.service.message;

import QQService.StreamInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class MessageFactoryReceiver$UploadStreamStruct
{
  public int a;
  public StreamInfo a;
  public String a;
  public short a;
  public int b;
  
  public MessageFactoryReceiver$UploadStreamStruct(String paramString, short paramShort, int paramInt1, StreamInfo paramStreamInfo, int paramInt2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Short = paramShort;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_QQServiceStreamInfo = paramStreamInfo;
    this.b = paramInt2;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\service\message\MessageFactoryReceiver$UploadStreamStruct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */