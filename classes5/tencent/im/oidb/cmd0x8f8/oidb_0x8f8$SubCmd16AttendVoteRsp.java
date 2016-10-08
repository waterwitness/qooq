package tencent.im.oidb.cmd0x8f8;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.trunk.group_feeds.group_feeds.GroupFeedsMessage.VoteRecord;
import com.trunk.group_feeds.group_feeds.GroupFeedsMessage.VoteStatistic;

public final class oidb_0x8f8$SubCmd16AttendVoteRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatField rpt_uint32_voteids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBRepeatMessageField rpt_vote_record = PBField.initRepeatMessage(group_feeds.GroupFeedsMessage.VoteRecord.class);
  public final PBRepeatMessageField rpt_vote_statistic = PBField.initRepeatMessage(group_feeds.GroupFeedsMessage.VoteStatistic.class);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 114, 122 }, new String[] { "bytes_feeds_id", "rpt_uint32_voteids", "rpt_vote_statistic", "rpt_vote_record" }, new Object[] { localByteStringMicro, Integer.valueOf(0), null, null }, SubCmd16AttendVoteRsp.class);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x8f8\oidb_0x8f8$SubCmd16AttendVoteRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */