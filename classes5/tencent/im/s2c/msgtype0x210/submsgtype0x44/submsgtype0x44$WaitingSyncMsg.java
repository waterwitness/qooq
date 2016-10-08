package tencent.im.s2c.msgtype0x210.submsgtype0x44;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class submsgtype0x44$WaitingSyncMsg
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_time" }, new Object[] { Integer.valueOf(0) }, WaitingSyncMsg.class);
  public final PBUInt32Field uint32_time = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\s2c\msgtype0x210\submsgtype0x44\submsgtype0x44$WaitingSyncMsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */