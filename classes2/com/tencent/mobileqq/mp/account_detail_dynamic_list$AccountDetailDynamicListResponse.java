package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class account_detail_dynamic_list$AccountDetailDynamicListResponse
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field last_msg_id = PBField.initUInt64(0L);
  public final PBUInt32Field msg_cnt = PBField.initUInt32(0);
  public final PBRepeatField msg_infos = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBUInt64Field puin = PBField.initUInt64(0L);
  public account_detail_dynamic_list.RetInfo ret_info = new account_detail_dynamic_list.RetInfo();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42 }, new String[] { "ret_info", "puin", "last_msg_id", "msg_cnt", "msg_infos" }, new Object[] { null, Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro }, AccountDetailDynamicListResponse.class);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\mp\account_detail_dynamic_list$AccountDetailDynamicListResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */