package com.tencent.ims;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class devlock_mobile_phone$status
  extends MessageMicro
{
  public static final int STR_BAK_COUNTRY_CODE_FIELD_NUMBER = 5;
  public static final int STR_BAK_MOBILE_FIELD_NUMBER = 4;
  public static final int U32_AUDIT_TIME_FIELD_NUMBER = 2;
  public static final int U32_BAK_MOBILE_STATE_FIELD_NUMBER = 3;
  public static final int U32_MB_MOBILE_STATE_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42 }, new String[] { "u32_mb_mobile_state", "u32_audit_time", "u32_bak_mobile_state", "str_bak_mobile", "str_bak_country_code" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "" }, status.class);
  public final PBStringField str_bak_country_code = PBField.initString("");
  public final PBStringField str_bak_mobile = PBField.initString("");
  public final PBUInt32Field u32_audit_time = PBField.initUInt32(0);
  public final PBUInt32Field u32_bak_mobile_state = PBField.initUInt32(0);
  public final PBUInt32Field u32_mb_mobile_state = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\ims\devlock_mobile_phone$status.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */