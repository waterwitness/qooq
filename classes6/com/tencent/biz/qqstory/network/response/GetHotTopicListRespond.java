package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.model.item.HotTopicItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetHotTopicPack;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.HotTopicPack;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetHotTopicListRespond
  extends BaseResponse
{
  public ArrayList a;
  public boolean a;
  public String b;
  
  public GetHotTopicListRespond(qqstory_service.RspGetHotTopicPack paramRspGetHotTopicPack)
  {
    super(paramRspGetHotTopicPack.result);
    boolean bool2 = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    if (paramRspGetHotTopicPack.is_end.get() == 1) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool1;
      this.b = paramRspGetHotTopicPack.next_cookie.get().toStringUtf8();
      paramRspGetHotTopicPack = paramRspGetHotTopicPack.topic_list.get().iterator();
      while (paramRspGetHotTopicPack.hasNext())
      {
        qqstory_struct.HotTopicPack localHotTopicPack = (qqstory_struct.HotTopicPack)paramRspGetHotTopicPack.next();
        this.jdField_a_of_type_JavaUtilArrayList.add(new HotTopicItem(localHotTopicPack));
      }
      bool1 = false;
    }
  }
  
  public String toString()
  {
    return "GetHotTopicListRespond{isEnd=" + this.jdField_a_of_type_Boolean + ", nextCookie='" + this.b + '\'' + ", mHotTopicItems=" + this.jdField_a_of_type_JavaUtilArrayList + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\response\GetHotTopicListRespond.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */