package com.tencent.ims;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class bankcode_info$ElemPos
  extends MessageMicro
{
  public static final int END_OFFSET_FIELD_NUMBER = 2;
  public static final int START_OFFSET_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "start_offset", "end_offset" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, ElemPos.class);
  public final PBUInt32Field end_offset = PBField.initUInt32(0);
  public final PBUInt32Field start_offset = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\ims\bankcode_info$ElemPos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */