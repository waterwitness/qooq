package com.tencent.pb.theme;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ThemeAuth$SubCmd0x2ReqCheck
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_theme_id", "str_theme_version" }, new Object[] { Integer.valueOf(0), "" }, SubCmd0x2ReqCheck.class);
  public final PBStringField str_theme_version = PBField.initString("");
  public final PBUInt32Field uint32_theme_id = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\theme\ThemeAuth$SubCmd0x2ReqCheck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */