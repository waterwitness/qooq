package tencent.im.s2c.msgtype0x210.submsgtype0x3f;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x3f$PubUniKey
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_fromPubUin", "uint64_qwMsgId" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, PubUniKey.class);
  public final PBUInt64Field uint64_fromPubUin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_qwMsgId = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\s2c\msgtype0x210\submsgtype0x3f\SubMsgType0x3f$PubUniKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */