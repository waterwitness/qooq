package com.tencent.pb.vipfontupdate;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class VipFontUpdate$TFontSsoReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 58 }, new String[] { "u32_cmd", "u64_seq", "i32_implat", "str_osver", "str_mqqver", "st_fresh_req", "st_Md5_Check_req" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), "", "", null, null }, TFontSsoReq.class);
  public final PBInt32Field i32_implat = PBField.initInt32(0);
  public VipFontUpdate.TFontMd5CheckReq st_Md5_Check_req = new VipFontUpdate.TFontMd5CheckReq();
  public VipFontUpdate.TFontFreshReq st_fresh_req = new VipFontUpdate.TFontFreshReq();
  public final PBStringField str_mqqver = PBField.initString("");
  public final PBStringField str_osver = PBField.initString("");
  public final PBUInt32Field u32_cmd = PBField.initUInt32(0);
  public final PBUInt64Field u64_seq = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\vipfontupdate\VipFontUpdate$TFontSsoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */