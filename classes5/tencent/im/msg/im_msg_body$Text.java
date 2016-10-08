package tencent.im.msg;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class im_msg_body$Text
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField attr_6_buf = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField attr_7_buf = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField buf = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField link = PBField.initString("");
  public final PBBytesField str = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 90 }, new String[] { "str", "link", "attr_6_buf", "attr_7_buf", "buf" }, new Object[] { localByteStringMicro1, "", localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, Text.class);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\msg\im_msg_body$Text.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */