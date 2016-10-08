package tencent.im.s2c.msgtype0x210.submsgtype0x40;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x40$MsgBody
  extends MessageMicro
{
  public static final int BYTES_VUUID_FIELD_NUMBER = 1;
  public static final int STR_FROMPHONENUM_FIELD_NUMBER = 12;
  public static final int UINT32_OPERTYPE_FIELD_NUMBER = 11;
  public static final int UINT32_STATE_FIELD_NUMBER = 4;
  public static final int UINT64_FROMUIN_FIELD_NUMBER = 2;
  public static final int UINT64_TOUIN_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_vUuid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField str_fromphonenum = PBField.initString("");
  public final PBUInt32Field uint32_State = PBField.initUInt32(0);
  public final PBUInt32Field uint32_opertype = PBField.initUInt32(0);
  public final PBUInt64Field uint64_fromUin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_toUin = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 88, 98 }, new String[] { "bytes_vUuid", "uint64_fromUin", "uint64_toUin", "uint32_State", "uint32_opertype", "str_fromphonenum" }, new Object[] { localByteStringMicro, Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), "" }, MsgBody.class);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\s2c\msgtype0x210\submsgtype0x40\SubMsgType0x40$MsgBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */