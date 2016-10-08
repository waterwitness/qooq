package com.tencent.biz.qqstory.support.report;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqMonitorValue;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspMonitorValue;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class MonitorValueRequest
  extends NetworkRequest
{
  private int a;
  private int b;
  
  public MonitorValueRequest()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspMonitorValue localRspMonitorValue = new qqstory_service.RspMonitorValue();
    try
    {
      localRspMonitorValue.mergeFrom(paramArrayOfByte);
      return new MonitorValueResponse(localRspMonitorValue);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte) {}
    return null;
  }
  
  public String a()
  {
    return "StorySvc.client_monitor_report";
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqMonitorValue localReqMonitorValue = new qqstory_service.ReqMonitorValue();
    localReqMonitorValue.ID.set(this.a);
    if (this.b > 0) {
      localReqMonitorValue.Value.set(this.b);
    }
    for (;;)
    {
      return localReqMonitorValue.toByteArray();
      localReqMonitorValue.Value.set(1);
    }
  }
  
  public String toString()
  {
    return "MonitorValueRequest{ID=" + this.a + ", value=" + this.b + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\support\report\MonitorValueRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */