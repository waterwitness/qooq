package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class qqstory_service$ReqGetStoryDes
  extends MessageMicro
{
  public static final int REQ_INFO_LIST_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "req_info_list" }, new Object[] { null }, ReqGetStoryDes.class);
  public final PBRepeatMessageField req_info_list = PBField.initRepeatMessage(qqstory_struct.StoryReqInfo.class);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\pb\qqstory_service$ReqGetStoryDes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */