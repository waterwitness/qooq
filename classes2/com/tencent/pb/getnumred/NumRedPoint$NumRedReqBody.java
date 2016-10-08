package com.tencent.pb.getnumred;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class NumRedPoint$NumRedReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42 }, new String[] { "i_proto_ver", "uint32_plat_id", "str_client_ver", "uint64_uin", "rpt_num_red" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", Long.valueOf(0L), null }, NumRedReqBody.class);
  public final PBInt32Field i_proto_ver = PBField.initInt32(0);
  public final PBRepeatMessageField rpt_num_red = PBField.initRepeatMessage(NumRedPoint.NumRedBusi.class);
  public final PBStringField str_client_ver = PBField.initString("");
  public final PBUInt32Field uint32_plat_id = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\getnumred\NumRedPoint$NumRedReqBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */