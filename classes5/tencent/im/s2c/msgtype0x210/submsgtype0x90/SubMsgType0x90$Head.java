package tencent.im.s2c.msgtype0x210.submsgtype0x90;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SubMsgType0x90$Head
  extends MessageMicro
{
  public static final int UINT32_CMD_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_cmd" }, new Object[] { Integer.valueOf(0) }, Head.class);
  public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\s2c\msgtype0x210\submsgtype0x90\SubMsgType0x90$Head.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */