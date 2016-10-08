package com.tencent.pb.clubcontent;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ClubContentUpdateInfoPb$RspAppInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint_appid", "rpt_msg_rspiteminfo" }, new Object[] { Integer.valueOf(0), null }, RspAppInfo.class);
  public final PBRepeatMessageField rpt_msg_rspiteminfo = PBField.initRepeatMessage(ClubContentUpdateInfoPb.RspItemInfo.class);
  public final PBUInt32Field uint_appid = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\clubcontent\ClubContentUpdateInfoPb$RspAppInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */