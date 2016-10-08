package com.tencent.pb.voiceChange;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class VipVoiceChange$subCmd0x1ReqAuth
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "int32_item_id" }, new Object[] { Integer.valueOf(0) }, subCmd0x1ReqAuth.class);
  public final PBInt32Field int32_item_id = PBField.initInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\voiceChange\VipVoiceChange$subCmd0x1ReqAuth.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */