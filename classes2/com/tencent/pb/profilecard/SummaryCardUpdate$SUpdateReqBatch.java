package com.tencent.pb.profilecard;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class SummaryCardUpdate$SUpdateReqBatch
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "reqs" }, new Object[] { null }, SUpdateReqBatch.class);
  public final PBRepeatMessageField reqs = PBField.initRepeatMessage(SummaryCardUpdate.SUpdateReq.class);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\profilecard\SummaryCardUpdate$SUpdateReqBatch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */