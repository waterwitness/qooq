package com.tencent.pb.voiceChange;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class VipVoiceChange$voiceChangeRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 42 }, new String[] { "int32_sub_cmd", "msg_subcmd0x1_rsp_auth" }, new Object[] { Integer.valueOf(0), null }, voiceChangeRsp.class);
  public final PBInt32Field int32_sub_cmd = PBField.initInt32(0);
  public VipVoiceChange.subCmd0x1RspAuth msg_subcmd0x1_rsp_auth = new VipVoiceChange.subCmd0x1RspAuth();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\voiceChange\VipVoiceChange$voiceChangeRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */