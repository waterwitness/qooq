package com.tencent.ims;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class signature$SignatureKickData
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 50, 56, 64 }, new String[] { "u64_uin", "str_packname", "u32_check_result", "str_left_button", "str_right_button", "str_url", "u32_timeout", "u32_protocol_version" }, new Object[] { Long.valueOf(0L), "", Integer.valueOf(0), "", "", "", Integer.valueOf(0), Integer.valueOf(0) }, SignatureKickData.class);
  public final PBStringField str_left_button = PBField.initString("");
  public final PBStringField str_packname = PBField.initString("");
  public final PBStringField str_right_button = PBField.initString("");
  public final PBStringField str_url = PBField.initString("");
  public final PBUInt32Field u32_check_result = PBField.initUInt32(0);
  public final PBUInt32Field u32_protocol_version = PBField.initUInt32(0);
  public final PBUInt32Field u32_timeout = PBField.initUInt32(0);
  public final PBUInt64Field u64_uin = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\ims\signature$SignatureKickData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */