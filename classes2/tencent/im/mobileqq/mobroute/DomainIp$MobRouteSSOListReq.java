package tencent.im.mobileqq.mobroute;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class DomainIp$MobRouteSSOListReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 50 }, new String[] { "uint32_uintype", "string_uin", "string_imsi", "uint32_nettype", "uint32_appid", "string_imei" }, new Object[] { Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "" }, MobRouteSSOListReq.class);
  public final PBStringField string_imei = PBField.initString("");
  public final PBStringField string_imsi = PBField.initString("");
  public final PBStringField string_uin = PBField.initString("");
  public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_nettype = PBField.initUInt32(0);
  public final PBUInt32Field uint32_uintype = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tencent\im\mobileqq\mobroute\DomainIp$MobRouteSSOListReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */