package com.tencent.pb.bubbleupdate;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class BubbleUpdatePB$RspUpdate
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "int32_ret", "uint64_uin", "uint32_used_item_id", "msg_rsp_data" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), null }, RspUpdate.class);
  public final PBInt32Field int32_ret = PBField.initInt32(0);
  public BubbleUpdatePB.RspUpdateData msg_rsp_data = new BubbleUpdatePB.RspUpdateData();
  public final PBUInt32Field uint32_used_item_id = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\bubbleupdate\BubbleUpdatePB$RspUpdate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */