package com.trunk.group_feeds;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class group_feeds$GroupFeedsMessage$VoteStatistic
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "int32_option_id", "int32_vote_count" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, VoteStatistic.class);
  public final PBInt32Field int32_option_id = PBField.initInt32(0);
  public final PBInt32Field int32_vote_count = PBField.initInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\trunk\group_feeds\group_feeds$GroupFeedsMessage$VoteStatistic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */