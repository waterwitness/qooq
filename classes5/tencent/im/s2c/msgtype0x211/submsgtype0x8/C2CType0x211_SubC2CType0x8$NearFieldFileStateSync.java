package tencent.im.s2c.msgtype0x211.submsgtype0x8;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class C2CType0x211_SubC2CType0x8$NearFieldFileStateSync
  extends MessageMicro
{
  public static final int ETYPE_FIELD_NUMBER = 1;
  public static final int INT32_ERROR_CODE_FIELD_NUMBER = 4;
  public static final int UINT64_FROM_UIN_FIELD_NUMBER = 3;
  public static final int UINT64_SESSION_ID_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "eType", "uint64_session_id", "uint64_from_uin", "int32_error_code" }, new Object[] { Integer.valueOf(1), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0) }, NearFieldFileStateSync.class);
  public final PBEnumField eType = PBField.initEnum(1);
  public final PBInt32Field int32_error_code = PBField.initInt32(0);
  public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_session_id = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\s2c\msgtype0x211\submsgtype0x8\C2CType0x211_SubC2CType0x8$NearFieldFileStateSync.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */