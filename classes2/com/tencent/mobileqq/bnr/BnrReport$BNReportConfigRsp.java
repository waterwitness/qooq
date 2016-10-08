package com.tencent.mobileqq.bnr;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class BnrReport$BNReportConfigRsp
  extends MessageMicro
{
  public static final int CFGLIST_FIELD_NUMBER = 2;
  public static final int RET_INFO_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "ret_info", "cfglist" }, new Object[] { null, null }, BNReportConfigRsp.class);
  public final PBRepeatMessageField cfglist = PBField.initRepeatMessage(BnrReport.BNReportConfig.class);
  public BnrReport.RetInfo ret_info = new BnrReport.RetInfo();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\bnr\BnrReport$BNReportConfigRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */