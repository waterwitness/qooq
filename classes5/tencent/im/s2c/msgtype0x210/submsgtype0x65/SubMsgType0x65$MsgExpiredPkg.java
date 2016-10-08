package tencent.im.s2c.msgtype0x210.submsgtype0x65;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SubMsgType0x65$MsgExpiredPkg
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_expire_pkg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_predown_pkg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_platform = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_platform", "bytes_expire_pkg", "bytes_predown_pkg" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2 }, MsgExpiredPkg.class);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\s2c\msgtype0x210\submsgtype0x65\SubMsgType0x65$MsgExpiredPkg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */