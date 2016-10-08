package com.tencent.pb.theme;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ThemeAuth$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint32_sub_cmd", "msg_subcmd0x1_rsp_auth", "msg_subcmd0x2_rsp_check", "msg_subcmd0x3_rsp_set" }, new Object[] { Integer.valueOf(0), null, null, null }, RspBody.class);
  public ThemeAuth.SubCmd0x1RspAuth msg_subcmd0x1_rsp_auth = new ThemeAuth.SubCmd0x1RspAuth();
  public ThemeAuth.SubCmd0x2RspCheck msg_subcmd0x2_rsp_check = new ThemeAuth.SubCmd0x2RspCheck();
  public ThemeAuth.SubCmd0x3RspSet msg_subcmd0x3_rsp_set = new ThemeAuth.SubCmd0x3RspSet();
  public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\theme\ThemeAuth$RspBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */