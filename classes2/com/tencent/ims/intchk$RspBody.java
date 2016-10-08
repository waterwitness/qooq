package com.tencent.ims;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class intchk$RspBody
  extends MessageMicro
{
  public static final int MSG_CHECK_CONFIG_RSP_FIELD_NUMBER = 3;
  public static final int MSG_REPORT_CHECK_RESULT_RSP_FIELD_NUMBER = 4;
  public static final int UINT32_RESULT_FIELD_NUMBER = 2;
  public static final int UINT32_SUBCMD_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "uint32_subcmd", "uint32_result", "msg_check_config_rsp", "msg_report_check_result_rsp" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null }, RspBody.class);
  public intchk.FetchCheckConfigRsp msg_check_config_rsp = new intchk.FetchCheckConfigRsp();
  public intchk.ReportCheckResultRsp msg_report_check_result_rsp = new intchk.ReportCheckResultRsp();
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\ims\intchk$RspBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */