package tencent.im.oidb.cmd0x6de;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Oidb_0x6de$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42 }, new String[] { "uint32_src", "uint32_phone_type", "str_country_code", "str_phone", "dev_info" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", null }, ReqBody.class);
  public Oidb_0x6de.DevInfo dev_info = new Oidb_0x6de.DevInfo();
  public final PBStringField str_country_code = PBField.initString("");
  public final PBStringField str_phone = PBField.initString("");
  public final PBUInt32Field uint32_phone_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_src = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x6de\Oidb_0x6de$ReqBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */