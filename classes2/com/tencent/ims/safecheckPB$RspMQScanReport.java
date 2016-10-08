package com.tencent.ims;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class safecheckPB$RspMQScanReport
  extends MessageMicro
{
  public static final int RPT_CHECK_ITEM_FIELD_NUMBER = 3;
  public static final int UINT32_CHECK_COUNT_FIELD_NUMBER = 2;
  public static final int UINT32_CHECK_UID_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_check_uid", "uint32_check_count", "rpt_check_item" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null }, RspMQScanReport.class);
  public final PBRepeatMessageField rpt_check_item = PBField.initRepeatMessage(safecheckPB.ReportItem.class);
  public final PBUInt32Field uint32_check_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_check_uid = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\ims\safecheckPB$RspMQScanReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */