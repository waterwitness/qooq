package msf.msgcomm;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class msg_comm$MsgType0x210
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField msg_content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field sub_msg_type = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "sub_msg_type", "msg_content" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, MsgType0x210.class);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\msf\msgcomm\msg_comm$MsgType0x210.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */