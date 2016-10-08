package com.tencent.pb.getnumredmsg;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class NumRedMsg$NumMsgRspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "i_retcode", "str_errmsg", "ui64_uin", "rpt_num_red" }, new Object[] { Integer.valueOf(0), "", Long.valueOf(0L), null }, NumMsgRspBody.class);
  public final PBInt32Field i_retcode = PBField.initInt32(0);
  public final PBRepeatMessageField rpt_num_red = PBField.initRepeatMessage(NumRedMsg.NumMsgBusi.class);
  public final PBStringField str_errmsg = PBField.initString("");
  public final PBUInt64Field ui64_uin = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\getnumredmsg\NumRedMsg$NumMsgRspBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */