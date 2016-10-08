package tencent.im.oidb.cmd0x6de;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Oidb_0x6de$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_skip_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_vas_result = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField phone_info = PBField.initRepeatMessage(Oidb_0x6de.PhoneInfo.class);
  public final PBStringField str_binding_phone = PBField.initString("");
  public final PBStringField str_country_code = PBField.initString("");
  public final PBUInt32Field uint32_binding_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_need_unify = PBField.initUInt32(0);
  public final PBUInt32Field uint32_phone_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  public final PBUInt32Field uint32_src = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 48, 56, 66, 74, 82 }, new String[] { "uint32_result", "uint32_src", "str_country_code", "str_binding_phone", "uint32_binding_time", "uint32_need_unify", "uint32_phone_type", "phone_info", "bytes_skip_url", "bytes_vas_result" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, localByteStringMicro1, localByteStringMicro2 }, RspBody.class);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x6de\Oidb_0x6de$RspBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */