package tencent.im.longconn.longmsg;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class LongMsg$MsgDownReq
  extends MessageMicro
{
  public static final int BYTES_MSG_RESID_FIELD_NUMBER = 2;
  public static final int UINT32_SRC_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_msg_resid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_src_uin = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_src_uin", "bytes_msg_resid" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, MsgDownReq.class);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tencent\im\longconn\longmsg\LongMsg$MsgDownReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */