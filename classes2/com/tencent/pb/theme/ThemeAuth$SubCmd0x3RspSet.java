package com.tencent.pb.theme;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class ThemeAuth$SubCmd0x3RspSet
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "int32_result", "uint32_theme_id", "uint32_suit_id" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, SubCmd0x3RspSet.class);
  public final PBInt32Field int32_result = PBField.initInt32(0);
  public final PBInt32Field uint32_suit_id = PBField.initInt32(0);
  public final PBInt32Field uint32_theme_id = PBField.initInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\theme\ThemeAuth$SubCmd0x3RspSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */