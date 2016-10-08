package com.tencent.biz.qqstory.network.request;

import android.os.Bundle;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.response.CommonResponse;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;

public class CommonRequest
  extends NetworkRequest
{
  public final Bundle a;
  public final MessageMicro a;
  public final String a;
  
  public CommonRequest(String paramString, MessageMicro paramMessageMicro, Bundle paramBundle)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqPbMessageMicro = paramMessageMicro;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    return new CommonResponse(paramArrayOfByte);
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  protected byte[] a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqPbMessageMicro.toByteArray();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\request\CommonRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */