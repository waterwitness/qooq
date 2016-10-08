package com.tencent.pb.bubbleupdate;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class BubbleUpdatePB$ReqUpdateTable
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_item_id", "uint32_version" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, ReqUpdateTable.class);
  public final PBUInt32Field uint32_item_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_version = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\bubbleupdate\BubbleUpdatePB$ReqUpdateTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */