package com.tencent.pb.theme;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ThemeAuth$SubCmd0x1RspAuth
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 48, 56 }, new String[] { "int32_result", "uint32_theme_id", "str_download_url", "str_version", "uint32_size", "int32_is_sound_theme", "int32_suit_id" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, SubCmd0x1RspAuth.class);
  public final PBInt32Field int32_is_sound_theme = PBField.initInt32(0);
  public final PBInt32Field int32_result = PBField.initInt32(0);
  public final PBInt32Field int32_suit_id = PBField.initInt32(0);
  public final PBStringField str_download_url = PBField.initString("");
  public final PBStringField str_version = PBField.initString("");
  public final PBUInt32Field uint32_size = PBField.initUInt32(0);
  public final PBUInt32Field uint32_theme_id = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\theme\ThemeAuth$SubCmd0x1RspAuth.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */