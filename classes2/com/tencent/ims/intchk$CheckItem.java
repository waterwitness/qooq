package com.tencent.ims;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class intchk$CheckItem
  extends MessageMicro
{
  public static final int BYTES_MATCH_PATTERN_FIELD_NUMBER = 6;
  public static final int BYTES_MODULE_NAME_FIELD_NUMBER = 3;
  public static final int UINT32_CHECK_ITEM_ID_FIELD_NUMBER = 1;
  public static final int UINT32_CHECK_TYPE_FIELD_NUMBER = 2;
  public static final int UINT32_END_OFFSET_FIELD_NUMBER = 5;
  public static final int UINT32_START_OFFSET_FIELD_NUMBER = 4;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_match_pattern = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_module_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_check_item_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_check_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_end_offset = PBField.initUInt32(0);
  public final PBUInt32Field uint32_start_offset = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 50 }, new String[] { "uint32_check_item_id", "uint32_check_type", "bytes_module_name", "uint32_start_offset", "uint32_end_offset", "bytes_match_pattern" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2 }, CheckItem.class);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\ims\intchk$CheckItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */