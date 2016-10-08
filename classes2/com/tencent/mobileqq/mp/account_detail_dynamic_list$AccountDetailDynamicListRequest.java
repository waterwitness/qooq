package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class account_detail_dynamic_list$AccountDetailDynamicListRequest
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "versionInfo", "puin", "last_msg_id", "msg_cnt" }, new Object[] { "", Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0) }, AccountDetailDynamicListRequest.class);
  public final PBUInt64Field last_msg_id = PBField.initUInt64(0L);
  public final PBUInt32Field msg_cnt = PBField.initUInt32(0);
  public final PBUInt64Field puin = PBField.initUInt64(0L);
  public final PBStringField versionInfo = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\mp\account_detail_dynamic_list$AccountDetailDynamicListRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */