package com.tencent.pb.getnumred;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class NumRedPoint$NumRedBusi
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40 }, new String[] { "uint32_appid", "i_new_flag", "uint32_modify_ts", "rpt_num_red_path", "int32_appset" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0) }, NumRedBusi.class);
  public final PBInt32Field i_new_flag = PBField.initInt32(0);
  public final PBInt32Field int32_appset = PBField.initInt32(0);
  public final PBRepeatMessageField rpt_num_red_path = PBField.initRepeatMessage(NumRedPoint.NumRedPath.class);
  public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_modify_ts = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\getnumred\NumRedPoint$NumRedBusi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */