package com.tencent.pb.clubcontent;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ClubContentUpdateInfoPb$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42 }, new String[] { "int_protocolver", "uint_clientplatid", "str_clientver", "uint_uin", "rpt_msg_reqappinfo" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", Long.valueOf(0L), null }, ReqBody.class);
  public final PBInt32Field int_protocolver = PBField.initInt32(0);
  public final PBRepeatMessageField rpt_msg_reqappinfo = PBField.initRepeatMessage(ClubContentUpdateInfoPb.ReqAppInfo.class);
  public final PBStringField str_clientver = PBField.initString("");
  public final PBUInt32Field uint_clientplatid = PBField.initUInt32(0);
  public final PBUInt64Field uint_uin = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\clubcontent\ClubContentUpdateInfoPb$ReqBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */