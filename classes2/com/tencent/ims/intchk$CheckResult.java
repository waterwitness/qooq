package com.tencent.ims;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class intchk$CheckResult
  extends MessageMicro
{
  public static final int BYTES_MEMREPORT_RESULT_FIELD_NUMBER = 4;
  public static final int UINT32_CHECK_ITEM_ID_FIELD_NUMBER = 1;
  public static final int UINT32_CHECK_TYPE_FIELD_NUMBER = 2;
  public static final int UINT32_MEMCHK_RESULT_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_memreport_result = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_check_item_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_check_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_memchk_result = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uint32_check_item_id", "uint32_check_type", "uint32_memchk_result", "bytes_memreport_result" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, CheckResult.class);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\ims\intchk$CheckResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */