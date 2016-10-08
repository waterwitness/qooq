package tencent.im.oidb;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x6cd$RedpointInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 90, 98 }, new String[] { "uint32_taskid", "uint64_cur_seq", "uint64_pull_seq", "uint64_read_seq", "uint32_pull_times", "uint32_last_pull_time", "int32_remained_time", "uint32_last_recv_time", "uint64_from_id", "enum_redpoint_type", "msg_redpoint_extra_info", "str_config_version" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(1), null, "" }, RedpointInfo.class);
  public final PBEnumField enum_redpoint_type = PBField.initEnum(1);
  public final PBInt32Field int32_remained_time = PBField.initInt32(0);
  public cmd0x6cd.RepointExtraInfo msg_redpoint_extra_info = new cmd0x6cd.RepointExtraInfo();
  public final PBStringField str_config_version = PBField.initString("");
  public final PBUInt32Field uint32_last_pull_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_last_recv_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pull_times = PBField.initUInt32(0);
  public final PBUInt32Field uint32_taskid = PBField.initUInt32(0);
  public final PBUInt64Field uint64_cur_seq = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_from_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_pull_seq = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_read_seq = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x6cd$RedpointInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */