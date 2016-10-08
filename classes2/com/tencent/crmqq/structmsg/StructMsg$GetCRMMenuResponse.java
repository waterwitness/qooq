package com.tencent.crmqq.structmsg;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class StructMsg$GetCRMMenuResponse
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 40 }, new String[] { "ret_info", "seqno", "uin", "button_info", "update_type" }, new Object[] { null, Integer.valueOf(0), Long.valueOf(0L), null, Integer.valueOf(0) }, GetCRMMenuResponse.class);
  public final PBRepeatMessageField button_info = PBField.initRepeatMessage(StructMsg.ButtonInfo.class);
  public StructMsg.RetInfo ret_info = new StructMsg.RetInfo();
  public final PBUInt32Field seqno = PBField.initUInt32(0);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  public final PBUInt32Field update_type = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\crmqq\structmsg\StructMsg$GetCRMMenuResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */