package com.trunk.feeds_inner_define;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class feeds_inner_define$ThemeMsgInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField opt_bytes_feedsid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField opt_bytes_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField opt_bytes_reserve = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field opt_uint32_cmmntid = PBField.initUInt32(0);
  public final PBUInt64Field opt_uint64_fromuin = PBField.initUInt64(0L);
  public final PBUInt64Field opt_uint64_modtime = PBField.initUInt64(0L);
  public final PBUInt64Field opt_uint64_time = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 58 }, new String[] { "opt_uint64_fromuin", "opt_uint64_time", "opt_uint64_modtime", "opt_uint32_cmmntid", "opt_bytes_feedsid", "opt_bytes_reserve", "opt_bytes_msg" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, ThemeMsgInfo.class);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\trunk\feeds_inner_define\feeds_inner_define$ThemeMsgInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */