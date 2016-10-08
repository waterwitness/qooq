package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetLabelList;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetLabelListResponse
  extends BaseResponse
{
  public List a;
  public boolean a;
  public String b;
  
  public GetLabelListResponse(qqstory_service.RspGetLabelList paramRspGetLabelList)
  {
    super(paramRspGetLabelList.result);
    boolean bool2 = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.b = paramRspGetLabelList.next_cookie.get().toStringUtf8();
    if (paramRspGetLabelList.is_end.get() == 1) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool1;
      paramRspGetLabelList = paramRspGetLabelList.label_list.get();
      if (paramRspGetLabelList == null) {
        break;
      }
      paramRspGetLabelList = paramRspGetLabelList.iterator();
      while (paramRspGetLabelList.hasNext())
      {
        ByteStringMicro localByteStringMicro = (ByteStringMicro)paramRspGetLabelList.next();
        this.jdField_a_of_type_JavaUtilList.add(localByteStringMicro.toStringUtf8());
      }
      bool1 = false;
    }
  }
  
  public String toString()
  {
    return "GetLabelListResponse{isEnd=" + this.jdField_a_of_type_Boolean + ", labelList=" + this.jdField_a_of_type_JavaUtilList.size() + ", nextCookie='" + this.b + '\'' + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\response\GetLabelListResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */