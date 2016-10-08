package com.tencent.pb.getnumred;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class NumRedPoint$NumRedRspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42 }, new String[] { "i_retcode", "str_errmsg", "i_inteval", "uint64_uin", "rpt_num_red" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Long.valueOf(0L), null }, NumRedRspBody.class);
  public final PBInt32Field i_inteval = PBField.initInt32(0);
  public final PBInt32Field i_retcode = PBField.initInt32(0);
  public final PBRepeatMessageField rpt_num_red = PBField.initRepeatMessage(NumRedPoint.NumRedBusi.class);
  public final PBStringField str_errmsg = PBField.initString("");
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\getnumred\NumRedPoint$NumRedRspBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */