package com.tencent.IndividPub;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class IndividPub$expTips_Pull_Req
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "from" }, new Object[] { Integer.valueOf(0) }, expTips_Pull_Req.class);
  public final PBUInt32Field from = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\IndividPub\IndividPub$expTips_Pull_Req.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */