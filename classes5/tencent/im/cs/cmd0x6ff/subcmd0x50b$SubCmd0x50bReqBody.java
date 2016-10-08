package tencent.im.cs.cmd0x6ff;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class subcmd0x50b$SubCmd0x50bReqBody
  extends MessageMicro
{
  public static final int BYTES_MSG_RESID_FIELD_NUMBER = 1;
  public static final int BYTES_MSG_UKEY_FIELD_NUMBER = 2;
  public static final int BYTES_OBJ_MSG_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_msg_resid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_msg_ukey = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_obj_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "bytes_msg_resid", "bytes_msg_ukey", "bytes_obj_msg" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, SubCmd0x50bReqBody.class);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\cs\cmd0x6ff\subcmd0x50b$SubCmd0x50bReqBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */