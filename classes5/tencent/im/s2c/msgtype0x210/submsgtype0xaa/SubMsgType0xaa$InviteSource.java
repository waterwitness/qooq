package tencent.im.s2c.msgtype0x210.submsgtype0xaa;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SubMsgType0xaa$InviteSource
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "type", "src" }, new Object[] { Integer.valueOf(0), "" }, InviteSource.class);
  public final PBStringField src = PBField.initString("");
  public final PBUInt32Field type = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\s2c\msgtype0x210\submsgtype0xaa\SubMsgType0xaa$InviteSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */