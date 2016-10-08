package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetConfigFile;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class GetConfigFileResponse
  extends BaseResponse
{
  public final int b;
  public final String b;
  public final String c;
  
  public GetConfigFileResponse(qqstory_service.RspGetConfigFile paramRspGetConfigFile)
  {
    super(paramRspGetConfigFile.result);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_Int = paramRspGetConfigFile.config_file_type.get();
    this.jdField_b_of_type_JavaLangString = paramRspGetConfigFile.config_download_url.get().toStringUtf8();
    this.c = paramRspGetConfigFile.config_download_md5.get().toStringUtf8();
  }
  
  public String toString()
  {
    return "GetConfigFileResponse{mType=" + this.jdField_b_of_type_Int + ", mDownloadZipUrl='" + this.jdField_b_of_type_JavaLangString + '\'' + ", mDownloadFileMd5='" + this.c + '\'' + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\response\GetConfigFileResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */