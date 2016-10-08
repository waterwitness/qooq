package com.tencent.av;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class hd_video_2$CmdS2CInviteReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 136 }, new String[] { "uint32_new_business_flag" }, new Object[] { Integer.valueOf(0) }, CmdS2CInviteReqBody.class);
  public final PBUInt32Field uint32_new_business_flag = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\hd_video_2$CmdS2CInviteReqBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */