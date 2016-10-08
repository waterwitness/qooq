package com.trunk.group_feeds;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;

public final class group_feeds$GroupFeedsMessage$VoteRecord
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 21, 29 }, new String[] { "rpt_option_id", "fixed32_vote_uin", "fixed32_vote_time" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, VoteRecord.class);
  public final PBFixed32Field fixed32_vote_time = PBField.initFixed32(0);
  public final PBFixed32Field fixed32_vote_uin = PBField.initFixed32(0);
  public final PBRepeatField rpt_option_id = PBField.initRepeat(PBInt32Field.__repeatHelper__);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\trunk\group_feeds\group_feeds$GroupFeedsMessage$VoteRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */