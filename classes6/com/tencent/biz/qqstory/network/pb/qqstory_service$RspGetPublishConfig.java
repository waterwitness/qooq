package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_service$RspGetPublishConfig
  extends MessageMicro
{
  public static final int CAN_TAKE_PICTURE_FIELD_NUMBER = 3;
  public static final int IS_FIRSTTIME_SHOW_TAKE_PIC_FIELD_NUMBER = 4;
  public static final int RESULT_FIELD_NUMBER = 1;
  public static final int SHOW_NOW_ENTRY_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "result", "show_now_entry", "can_take_picture", "is_firsttime_show_take_pic" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, RspGetPublishConfig.class);
  public final PBUInt32Field can_take_picture = PBField.initUInt32(0);
  public final PBUInt32Field is_firsttime_show_take_pic = PBField.initUInt32(0);
  public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  public final PBUInt32Field show_now_entry = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\pb\qqstory_service$RspGetPublishConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */