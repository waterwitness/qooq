package appoint.define;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class appoint_define$NearbyEvent
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "uint32_eventtype", "msg_rankevent", "uint64_event_uin", "uint64_event_tinyid" }, new Object[] { Integer.valueOf(0), null, Long.valueOf(0L), Long.valueOf(0L) }, NearbyEvent.class);
  public appoint_define.RankEvent msg_rankevent = new appoint_define.RankEvent();
  public final PBUInt32Field uint32_eventtype = PBField.initUInt32(0);
  public final PBUInt64Field uint64_event_tinyid = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_event_uin = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\appoint\define\appoint_define$NearbyEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */