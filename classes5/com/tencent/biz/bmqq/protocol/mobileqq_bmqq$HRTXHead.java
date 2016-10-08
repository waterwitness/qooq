package com.tencent.biz.bmqq.protocol;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mobileqq_bmqq$HRTXHead
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_qquin" }, new Object[] { Long.valueOf(0L) }, HRTXHead.class);
  public final PBUInt64Field uint64_qquin = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\bmqq\protocol\mobileqq_bmqq$HRTXHead.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */