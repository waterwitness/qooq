package com.tencent.IndividPub;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class IndividPub$expTips_Req
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "cmd", "packet_seq", "comm", "reqcmd_0x01" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), null, null }, expTips_Req.class);
  public final PBUInt32Field cmd = PBField.initUInt32(0);
  public IndividPub.Platform_Comm_Req comm = new IndividPub.Platform_Comm_Req();
  public final PBUInt64Field packet_seq = PBField.initUInt64(0L);
  public IndividPub.expTips_Pull_Req reqcmd_0x01 = new IndividPub.expTips_Pull_Req();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\IndividPub\IndividPub$expTips_Req.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */