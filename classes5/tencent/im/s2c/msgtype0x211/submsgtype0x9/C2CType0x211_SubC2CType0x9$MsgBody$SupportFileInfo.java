package tencent.im.s2c.msgtype0x211.submsgtype0x9;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class C2CType0x211_SubC2CType0x9$MsgBody$SupportFileInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "str_file_suffix", "uint32_copies", "uint32_duplex" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0) }, SupportFileInfo.class);
  public final PBStringField str_file_suffix = PBField.initString("");
  public final PBUInt32Field uint32_copies = PBField.initUInt32(0);
  public final PBUInt32Field uint32_duplex = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\s2c\msgtype0x211\submsgtype0x9\C2CType0x211_SubC2CType0x9$MsgBody$SupportFileInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */