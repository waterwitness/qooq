package com.tencent.mobileqq.troop.data.pb;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class TroopAppFlagInfo$ReqBody
  extends MessageMicro
{
  public static final int STR_VERSION_FIELD_NUMBER = 1;
  public static final int UINT32_MOBILE_OSTYPE_FIELD_NUMBER = 3;
  public static final int UINT64_GCODE_FIELD_NUMBER = 2;
  public static final int UINT64_UIN_FIELD_NUMBER = 4;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField str_version = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_mobile_ostype = PBField.initUInt32(0);
  public final PBUInt64Field uint64_gcode = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "str_version", "uint64_gcode", "uint32_mobile_ostype", "uint64_uin" }, new Object[] { localByteStringMicro, Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L) }, ReqBody.class);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\data\pb\TroopAppFlagInfo$ReqBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */