package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspAuthKey;
import com.tencent.biz.qqstory.network.response.RefreshVideoFileKeyResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;

public class RefreshVideoFileKeyRequest
  extends NetworkRequest
{
  public static final String a = "Q.qqstory:RefreshVideoFileKeyRequest";
  
  public RefreshVideoFileKeyRequest()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public RefreshVideoFileKeyResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspAuthKey localRspAuthKey = new qqstory_service.RspAuthKey();
    try
    {
      localRspAuthKey.mergeFrom(paramArrayOfByte);
      return new RefreshVideoFileKeyResponse(localRspAuthKey);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      SLog.d("Q.qqstory:RefreshVideoFileKeyRequest", "" + paramArrayOfByte);
    }
    return null;
  }
  
  public String a()
  {
    return "StorySvc.video_apply_authkey";
  }
  
  protected byte[] a()
  {
    return new byte[0];
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\request\RefreshVideoFileKeyRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */