package com.tencent.mobileqq.bnr;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class BnrReport$BNReportConfigReq
  extends MessageMicro
{
  public static final int GROUP_INFO_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "group_info" }, new Object[] { null }, BNReportConfigReq.class);
  public final PBRepeatMessageField group_info = PBField.initRepeatMessage(BnrReport.BNReportGroupInfo.class);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\bnr\BnrReport$BNReportConfigReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */