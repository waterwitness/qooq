package com.tencent.pb.pendantMarket;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class PendantMarket$SetAddonReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 58, 64 }, new String[] { "cmd", "int_platform", "int_version", "long_addon_id", "str_qq_version", "int_valid_days", "str_open_key", "i_key_type" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), "", Integer.valueOf(0), "", Integer.valueOf(0) }, SetAddonReq.class);
  public final PBUInt32Field cmd = PBField.initUInt32(0);
  public final PBUInt32Field i_key_type = PBField.initUInt32(0);
  public final PBUInt32Field int_platform = PBField.initUInt32(0);
  public final PBUInt32Field int_valid_days = PBField.initUInt32(0);
  public final PBUInt32Field int_version = PBField.initUInt32(0);
  public final PBUInt64Field long_addon_id = PBField.initUInt64(0L);
  public final PBStringField str_open_key = PBField.initString("");
  public final PBStringField str_qq_version = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\pendantMarket\PendantMarket$SetAddonReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */