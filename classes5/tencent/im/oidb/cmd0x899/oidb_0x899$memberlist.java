package tencent.im.oidb.cmd0x899;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x899$memberlist
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96 }, new String[] { "uint64_member_uin", "uint32_uin_flag", "uint32_uin_flagex", "uint32_uin_mobile_flag", "uint32_uin_arch_flag", "uint32_join_time", "uint32_old_msg_seq", "uint32_new_msg_seq", "uint32_last_speak_time", "uint32_level", "uint32_point", "uint32_shutup_timestap" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, memberlist.class);
  public final PBUInt32Field uint32_join_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_last_speak_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_new_msg_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_old_msg_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_point = PBField.initUInt32(0);
  public final PBUInt32Field uint32_shutup_timestap = PBField.initUInt32(0);
  public final PBUInt32Field uint32_uin_arch_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_uin_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_uin_flagex = PBField.initUInt32(0);
  public final PBUInt32Field uint32_uin_mobile_flag = PBField.initUInt32(0);
  public final PBUInt64Field uint64_member_uin = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x899\oidb_0x899$memberlist.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */