package tencent.im.s2c.msgtype0x210.submsgtype0xae;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;

public final class SubMsgType0xae$PushPeopleMayKnow
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_wording_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBFixed32Field fixed32_timestamp = PBField.initFixed32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 13, 18 }, new String[] { "fixed32_timestamp", "bytes_wording_msg" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, PushPeopleMayKnow.class);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\s2c\msgtype0x210\submsgtype0xae\SubMsgType0xae$PushPeopleMayKnow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */