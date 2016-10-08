package tencent.im.oidb.cmd0x8fc;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Oidb_0x8fc$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 48 }, new String[] { "uint64_group_code", "uint32_show_flag", "rpt_mem_level_info", "rpt_level_name", "uint32_update_time", "uint32_office_mode" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), null, null, Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
  public final PBRepeatMessageField rpt_level_name = PBField.initRepeatMessage(Oidb_0x8fc.LevelName.class);
  public final PBRepeatMessageField rpt_mem_level_info = PBField.initRepeatMessage(Oidb_0x8fc.MemberInfo.class);
  public final PBUInt32Field uint32_office_mode = PBField.initUInt32(0);
  public final PBUInt32Field uint32_show_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_update_time = PBField.initUInt32(0);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x8fc\Oidb_0x8fc$ReqBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */