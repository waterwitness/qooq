package com.tencent.pb.profilecard;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class SummaryCardUpdate$SUpdateRspBatch
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rsps" }, new Object[] { null }, SUpdateRspBatch.class);
  public final PBRepeatMessageField rsps = PBField.initRepeatMessage(SummaryCardUpdate.SUpdateRsp.class);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\profilecard\SummaryCardUpdate$SUpdateRspBatch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */