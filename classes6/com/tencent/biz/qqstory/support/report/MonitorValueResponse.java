package com.tencent.biz.qqstory.support.report;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspMonitorValue;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class MonitorValueResponse
  extends BaseResponse
{
  public MonitorValueResponse(qqstory_service.RspMonitorValue paramRspMonitorValue)
  {
    super(paramRspMonitorValue.result);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String toString()
  {
    return "MonitorValueResponse{errorCode=" + this.jdField_a_of_type_Int + ", errorMsg='" + this.jdField_a_of_type_JavaLangString + '\'' + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\support\report\MonitorValueResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */