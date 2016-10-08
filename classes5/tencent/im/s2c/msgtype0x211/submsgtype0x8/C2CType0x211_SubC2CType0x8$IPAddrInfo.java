package tencent.im.s2c.msgtype0x211.submsgtype0x8;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class C2CType0x211_SubC2CType0x8$IPAddrInfo
  extends MessageMicro
{
  public static final int INT32_GATEWAY_FIELD_NUMBER = 3;
  public static final int INT32_IP_FIELD_NUMBER = 1;
  public static final int INT32_MASK_FIELD_NUMBER = 2;
  public static final int INT32_PORT_FIELD_NUMBER = 4;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "int32_ip", "int32_mask", "int32_gateway", "int32_port" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, IPAddrInfo.class);
  public final PBInt32Field int32_gateway = PBField.initInt32(0);
  public final PBInt32Field int32_ip = PBField.initInt32(0);
  public final PBInt32Field int32_mask = PBField.initInt32(0);
  public final PBInt32Field int32_port = PBField.initInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\s2c\msgtype0x211\submsgtype0x8\C2CType0x211_SubC2CType0x8$IPAddrInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */