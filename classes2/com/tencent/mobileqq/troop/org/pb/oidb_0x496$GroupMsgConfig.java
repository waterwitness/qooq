package com.tencent.mobileqq.troop.org.pb;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x496$GroupMsgConfig
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "bool_uin_enable", "uint32_max_aio_msg", "uint32_enable_helper", "uint32_group_max_number" }, new Object[] { Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GroupMsgConfig.class);
  public final PBBoolField bool_uin_enable = PBField.initBool(false);
  public final PBUInt32Field uint32_enable_helper = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_max_number = PBField.initUInt32(0);
  public final PBUInt32Field uint32_max_aio_msg = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\org\pb\oidb_0x496$GroupMsgConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */