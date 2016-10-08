package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetEmoticonPackList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetEmoticonPackList;
import com.tencent.biz.qqstory.network.response.GetEmojiPackInfoListResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class GetEmojiPackInfoListRequest
  extends NetworkRequest
{
  private static final String b = "GetEmojiPackInfoListRequest";
  public final int a;
  public final String a;
  public final int b;
  public final int c;
  
  public GetEmojiPackInfoListRequest(String paramString, int paramInt)
  {
    this(paramString, paramInt, 0, 0);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public GetEmojiPackInfoListRequest(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("mCookie should not be null");
    }
    if (paramInt1 <= 0) {
      throw new IllegalArgumentException("mCount should not be less than 0 : " + paramInt1);
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
  }
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetEmoticonPackList localRspGetEmoticonPackList = new qqstory_service.RspGetEmoticonPackList();
    try
    {
      localRspGetEmoticonPackList.mergeFrom(paramArrayOfByte);
      return new GetEmojiPackInfoListResponse(localRspGetEmoticonPackList);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      SLog.e("GetEmojiPackInfoListRequest", "GetEmojiPackInfoListRequest error : " + paramArrayOfByte);
    }
    return null;
  }
  
  public String a()
  {
    return "StorySvc.video_emoticon_get";
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqGetEmoticonPackList localReqGetEmoticonPackList = new qqstory_service.ReqGetEmoticonPackList();
    localReqGetEmoticonPackList.start_cookie.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_JavaLangString));
    localReqGetEmoticonPackList.count.set(this.jdField_a_of_type_Int);
    return localReqGetEmoticonPackList.toByteArray();
  }
  
  public String toString()
  {
    return "GetEmojiPackInfoListRequest{mCookie='" + this.jdField_a_of_type_JavaLangString + '\'' + ", mCount=" + this.jdField_a_of_type_Int + ", mLatitude=" + this.b + ", mLongitude=" + this.c + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\request\GetEmojiPackInfoListRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */