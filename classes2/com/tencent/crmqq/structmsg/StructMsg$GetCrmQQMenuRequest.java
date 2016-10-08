package com.tencent.crmqq.structmsg;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class StructMsg$GetCrmQQMenuRequest
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "seqno", "uin" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, GetCrmQQMenuRequest.class);
  public final PBUInt32Field seqno = PBField.initUInt32(0);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\crmqq\structmsg\StructMsg$GetCrmQQMenuRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */