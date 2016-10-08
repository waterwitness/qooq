package com.tencent.qidian.proto;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mobileqq_qidian$CheckMpqqRefuseFlagReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uin64_mpqq_uin", "uint64_qq_uin" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, CheckMpqqRefuseFlagReq.class);
  public final PBUInt64Field uin64_mpqq_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_qq_uin = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\qidian\proto\mobileqq_qidian$CheckMpqqRefuseFlagReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */