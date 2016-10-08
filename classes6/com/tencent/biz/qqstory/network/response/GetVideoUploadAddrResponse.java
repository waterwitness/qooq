package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspUploadStoryVideo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class GetVideoUploadAddrResponse
  extends BaseResponse
{
  public static final String b = "GetVideoUploadAddrResponse";
  public boolean a;
  public int b;
  public String c;
  public String d;
  public String e;
  
  public GetVideoUploadAddrResponse(qqstory_service.RspUploadStoryVideo paramRspUploadStoryVideo)
  {
    super(paramRspUploadStoryVideo.result);
    boolean bool2 = NotVerifyClass.DO_VERIFY_CLASS;
    this.c = paramRspUploadStoryVideo.server_ip.get().toStringUtf8();
    this.b = paramRspUploadStoryVideo.server_port.get();
    if (paramRspUploadStoryVideo.exists.get() == 1) {}
    for (;;)
    {
      this.a = bool1;
      this.d = paramRspUploadStoryVideo.check_key.get().toStringUtf8();
      this.e = paramRspUploadStoryVideo.vid.get().toStringUtf8();
      return;
      bool1 = false;
    }
  }
  
  public String toString()
  {
    return "GetStoryVideoUploadAddressRespond{checkKey='" + this.d + '\'' + ", serverIp='" + this.c + '\'' + ", serverPort=" + this.b + ", exist=" + this.a + ", vid='" + this.e + '\'' + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\response\GetVideoUploadAddrResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */