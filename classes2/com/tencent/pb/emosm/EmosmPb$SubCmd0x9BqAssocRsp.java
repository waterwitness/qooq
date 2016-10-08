package com.tencent.pb.emosm;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class EmosmPb$SubCmd0x9BqAssocRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_assoc_bqs" }, new Object[] { null }, SubCmd0x9BqAssocRsp.class);
  public final PBRepeatMessageField rpt_assoc_bqs = PBField.initRepeatMessage(EmosmPb.BqAssocInfo.class);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\emosm\EmosmPb$SubCmd0x9BqAssocRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */