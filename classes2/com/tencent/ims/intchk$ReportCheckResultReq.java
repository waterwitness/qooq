package com.tencent.ims;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class intchk$ReportCheckResultReq
  extends MessageMicro
{
  public static final int RPT_MSG_CHECK_RESULT_FIELD_NUMBER = 2;
  public static final int UINT32_INTCHK_ID_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_intchk_id", "rpt_msg_check_result" }, new Object[] { Integer.valueOf(0), null }, ReportCheckResultReq.class);
  public final PBRepeatMessageField rpt_msg_check_result = PBField.initRepeatMessage(intchk.CheckResult.class);
  public final PBUInt32Field uint32_intchk_id = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\ims\intchk$ReportCheckResultReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */