package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.base.VideoServerInfoManager.ServerInfo;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspAuthKey;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class RefreshVideoFileKeyResponse
  extends BaseResponse
{
  public VideoServerInfoManager.ServerInfo a;
  
  public RefreshVideoFileKeyResponse(qqstory_service.RspAuthKey paramRspAuthKey)
  {
    super(paramRspAuthKey.result);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new VideoServerInfoManager.ServerInfo();
    this.a.jdField_a_of_type_JavaLangString = paramRspAuthKey.user_ip.get().toStringUtf8();
    this.a.b = paramRspAuthKey.server_ip1.get().toStringUtf8();
    this.a.c = paramRspAuthKey.server_ip2.get().toStringUtf8();
    this.a.d = paramRspAuthKey.backup_server_ip1.get().toStringUtf8();
    this.a.e = paramRspAuthKey.backup_server_ip2.get().toStringUtf8();
    this.a.jdField_a_of_type_ArrayOfByte = paramRspAuthKey.auth_key.get().toByteArray();
    this.a.jdField_a_of_type_Long = (paramRspAuthKey.expire_time.get() * 1000L);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\response\RefreshVideoFileKeyResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */