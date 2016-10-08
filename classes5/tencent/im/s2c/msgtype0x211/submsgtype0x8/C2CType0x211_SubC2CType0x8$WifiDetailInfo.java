package tencent.im.s2c.msgtype0x211.submsgtype0x8;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class C2CType0x211_SubC2CType0x8$WifiDetailInfo
  extends MessageMicro
{
  public static final int BOOL_SELF_ESTABLISH_FIELD_NUMBER = 1;
  public static final int STR_MAC_FIELD_NUMBER = 3;
  public static final int STR_SSID_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "bool_self_establish", "str_ssid", "str_mac" }, new Object[] { Boolean.valueOf(false), "", "" }, WifiDetailInfo.class);
  public final PBBoolField bool_self_establish = PBField.initBool(false);
  public final PBStringField str_mac = PBField.initString("");
  public final PBStringField str_ssid = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\s2c\msgtype0x211\submsgtype0x8\C2CType0x211_SubC2CType0x8$WifiDetailInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */