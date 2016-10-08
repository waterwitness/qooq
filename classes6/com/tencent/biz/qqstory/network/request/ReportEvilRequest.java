package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqReportEvil;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspReportEvil;
import com.tencent.biz.qqstory.network.response.ReportEvilResponse;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;

public class ReportEvilRequest
  extends NetworkRequest
{
  public static final String a = "Q.qqstory:ReportEvilRequest";
  public static final String b = "StorySvc.video_report_evil";
  public final int a;
  public final String c;
  
  public ReportEvilRequest(String paramString, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.c = paramString;
    this.a = paramInt;
  }
  
  public ReportEvilResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspReportEvil localRspReportEvil = new qqstory_service.RspReportEvil();
    try
    {
      localRspReportEvil.mergeFrom(paramArrayOfByte);
      return new ReportEvilResponse(localRspReportEvil);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  public String a()
  {
    return "StorySvc.video_report_evil";
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqReportEvil localReqReportEvil = new qqstory_service.ReqReportEvil();
    localReqReportEvil.vid.set(ByteStringMicro.copyFromUtf8(this.c));
    localReqReportEvil.type.set(this.a);
    return localReqReportEvil.toByteArray();
  }
  
  public String toString()
  {
    return "ReportEvilRequest{impeachType=" + this.a + ", vid='" + this.c + '\'' + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\request\ReportEvilRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */