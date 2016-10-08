package com.tencent.pb.clubcontent;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class ClubContentUpdateInfoPb$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "int_result", "rpt_msg_rspappinfo" }, new Object[] { Integer.valueOf(0), null }, RspBody.class);
  public final PBInt32Field int_result = PBField.initInt32(0);
  public final PBRepeatMessageField rpt_msg_rspappinfo = PBField.initRepeatMessage(ClubContentUpdateInfoPb.RspAppInfo.class);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\clubcontent\ClubContentUpdateInfoPb$RspBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */