package tencent.im.msg;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class im_msg$MsgSendReq
  extends MessageMicro
{
  public static final int BU_MSG_FIELD_NUMBER = 2;
  public static final int BYTES_COOKIE_FIELD_NUMBER = 5;
  public static final int CONN_MSG_FLAG_FIELD_NUMBER = 4;
  public static final int MSG_FIELD_NUMBER = 1;
  public static final int MSG_TAIL_ID_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bu_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field conn_msg_flag = PBField.initUInt32(0);
  public im_msg.Msg msg = new im_msg.Msg();
  public final PBUInt32Field msg_tail_id = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42 }, new String[] { "msg", "bu_msg", "msg_tail_id", "conn_msg_flag", "bytes_cookie" }, new Object[] { null, localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2 }, MsgSendReq.class);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\msg\im_msg$MsgSendReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */