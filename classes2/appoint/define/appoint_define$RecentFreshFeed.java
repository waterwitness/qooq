package appoint.define;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class appoint_define$RecentFreshFeed
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "rpt_fresh_feed_info", "uint64_uid" }, new Object[] { null, Long.valueOf(0L) }, RecentFreshFeed.class);
  public final PBRepeatMessageField rpt_fresh_feed_info = PBField.initRepeatMessage(appoint_define.FreshFeedInfo.class);
  public final PBUInt64Field uint64_uid = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\appoint\define\appoint_define$RecentFreshFeed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */