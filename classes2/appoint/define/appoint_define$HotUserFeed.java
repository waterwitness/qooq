package appoint.define;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class appoint_define$HotUserFeed
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "str_feed_id", "uint32_praise_count", "uint64_publish_uid", "uint32_publish_time" }, new Object[] { "", Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, HotUserFeed.class);
  public final PBStringField str_feed_id = PBField.initString("");
  public final PBUInt32Field uint32_praise_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_publish_time = PBField.initUInt32(0);
  public final PBUInt64Field uint64_publish_uid = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\appoint\define\appoint_define$HotUserFeed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */