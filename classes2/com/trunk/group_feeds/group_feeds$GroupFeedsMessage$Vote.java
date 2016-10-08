package com.trunk.group_feeds;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class group_feeds$GroupFeedsMessage$Vote
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42, 53 }, new String[] { "msg_title", "int32_max_vote_per_uin", "rpt_msg_options", "msg_vote_des", "msg_vote_res", "uint32_vote_deadline" }, new Object[] { null, Integer.valueOf(0), null, null, null, Integer.valueOf(0) }, Vote.class);
  public final PBInt32Field int32_max_vote_per_uin = PBField.initInt32(0);
  public group_feeds.GroupFeedsMessage.ContentList msg_title = new group_feeds.GroupFeedsMessage.ContentList();
  public group_feeds.GroupFeedsMessage.ContentList msg_vote_des = new group_feeds.GroupFeedsMessage.ContentList();
  public group_feeds.GroupFeedsMessage.ContentList msg_vote_res = new group_feeds.GroupFeedsMessage.ContentList();
  public final PBRepeatMessageField rpt_msg_options = PBField.initRepeatMessage(group_feeds.GroupFeedsMessage.ContentList.class);
  public final PBFixed32Field uint32_vote_deadline = PBField.initFixed32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\trunk\group_feeds\group_feeds$GroupFeedsMessage$Vote.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */