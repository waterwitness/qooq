package com.tencent.qidian.proto;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mobileqq_qidian$GetAccountTypeRspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "int32_result", "uint64_kfext_uin" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, GetAccountTypeRspBody.class);
  public final PBInt32Field int32_result = PBField.initInt32(0);
  public final PBUInt64Field uint64_kfext_uin = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\qidian\proto\mobileqq_qidian$GetAccountTypeRspBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */