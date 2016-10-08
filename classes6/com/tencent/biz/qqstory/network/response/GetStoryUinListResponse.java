package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetStoryUinList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.UserInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetStoryUinListResponse
  extends BaseResponse
{
  public static final String b = "GetStoryListRespond";
  public List a;
  public boolean a;
  public List b;
  public String c;
  public List c;
  
  public GetStoryUinListResponse(qqstory_service.RspGetStoryUinList paramRspGetStoryUinList)
  {
    super(paramRspGetStoryUinList.result);
    boolean bool2 = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.b = new ArrayList();
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    if (paramRspGetStoryUinList.is_end.get() == 1) {}
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool1;
      this.jdField_c_of_type_JavaLangString = paramRspGetStoryUinList.next_cookie.get().toStringUtf8();
      this.jdField_a_of_type_JavaUtilList.addAll(paramRspGetStoryUinList.uin_list.get());
      localObject1 = paramRspGetStoryUinList.union_id_list.get();
      if (localObject1 == null) {
        break;
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ByteStringMicro)((Iterator)localObject1).next();
        this.b.add(((ByteStringMicro)localObject2).toStringUtf8());
      }
      bool1 = false;
    }
    if ((paramRspGetStoryUinList.user_info_list != null) && (paramRspGetStoryUinList.user_info_list.get() != null))
    {
      paramRspGetStoryUinList = paramRspGetStoryUinList.user_info_list.get().iterator();
      while (paramRspGetStoryUinList.hasNext())
      {
        localObject1 = (qqstory_struct.UserInfo)paramRspGetStoryUinList.next();
        localObject2 = new QQUserUIItem();
        ((QQUserUIItem)localObject2).convertFrom((qqstory_struct.UserInfo)localObject1);
        this.jdField_c_of_type_JavaUtilList.add(localObject2);
      }
    }
  }
  
  public String toString()
  {
    return "GetStoryListRespond{isEnd=" + this.jdField_a_of_type_Boolean + ", nextCookie='" + this.jdField_c_of_type_JavaLangString + '\'' + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\response\GetStoryUinListResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */