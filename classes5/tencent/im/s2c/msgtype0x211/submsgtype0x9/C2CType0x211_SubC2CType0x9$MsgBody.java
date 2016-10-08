package tencent.im.s2c.msgtype0x211.submsgtype0x9;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class C2CType0x211_SubC2CType0x9$MsgBody
  extends MessageMicro
{
  public static final int CMD_Enum_Printer = 1;
  public static final int CMD_Enum_Printer_Result = 2;
  public static final int CMD_None = 0;
  public static final int CMD_Print_Result = 3;
  public static final int CMD_RESTRY = 4;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "str_service", "uint32_CMD", "msg_printer" }, new Object[] { "", Integer.valueOf(0), null }, MsgBody.class);
  public C2CType0x211_SubC2CType0x9.MsgBody.MsgPrinter msg_printer = new C2CType0x211_SubC2CType0x9.MsgBody.MsgPrinter();
  public final PBStringField str_service = PBField.initString("");
  public final PBUInt32Field uint32_CMD = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\s2c\msgtype0x211\submsgtype0x9\C2CType0x211_SubC2CType0x9$MsgBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */