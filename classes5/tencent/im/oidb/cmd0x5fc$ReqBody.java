package tencent.im.oidb;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x5fc$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72 }, new String[] { "uint64_last_event_id", "uint64_read_event_id", "uint32_fetch_count", "uint64_last_nearby_event_id", "uint64_read_nearby_event_id", "uint32_fetch_nearby_event_count", "uint64_last_feed_event_id", "uint64_read_feed_event_id", "uint32_fetch_feed_event_count" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0) }, ReqBody.class);
  public final PBUInt32Field uint32_fetch_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_fetch_feed_event_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_fetch_nearby_event_count = PBField.initUInt32(0);
  public final PBUInt64Field uint64_last_event_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_last_feed_event_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_last_nearby_event_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_read_event_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_read_feed_event_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_read_nearby_event_id = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x5fc$ReqBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */