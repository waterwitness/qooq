package com.tencent.pb.voiceChange;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class VipVoiceChange$subCmd0x1RspAuth
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "int32_ret", "str_error_msg", "str_active_url" }, new Object[] { Integer.valueOf(0), "", "" }, subCmd0x1RspAuth.class);
  public final PBInt32Field int32_ret = PBField.initInt32(0);
  public final PBStringField str_active_url = PBField.initString("");
  public final PBStringField str_error_msg = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\voiceChange\VipVoiceChange$subCmd0x1RspAuth.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */