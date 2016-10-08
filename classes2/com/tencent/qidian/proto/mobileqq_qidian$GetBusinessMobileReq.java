package com.tencent.qidian.proto;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mobileqq_qidian$GetBusinessMobileReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_cqquin", "uint64_extuin" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, GetBusinessMobileReq.class);
  public final PBUInt64Field uint64_cqquin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_extuin = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\qidian\proto\mobileqq_qidian$GetBusinessMobileReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */