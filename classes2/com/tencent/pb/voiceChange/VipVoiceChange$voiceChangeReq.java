package com.tencent.pb.voiceChange;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class VipVoiceChange$voiceChangeReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 82 }, new String[] { "int32_sub_cmd", "int32_platform", "str_qq_version", "msg_subcmd0x1_req_auth" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", null }, voiceChangeReq.class);
  public final PBInt32Field int32_platform = PBField.initInt32(0);
  public final PBInt32Field int32_sub_cmd = PBField.initInt32(0);
  public VipVoiceChange.subCmd0x1ReqAuth msg_subcmd0x1_req_auth = new VipVoiceChange.subCmd0x1ReqAuth();
  public final PBStringField str_qq_version = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\voiceChange\VipVoiceChange$voiceChangeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */