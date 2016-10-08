package tencent.im.msg;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class im_msg$MsgHead
  extends MessageMicro
{
  public static final int CONTENT_HEAD_FIELD_NUMBER = 2;
  public static final int GBK_TMP_MSG_BODY_FIELD_NUMBER = 3;
  public static final int ROUTING_HEAD_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public im_msg.ContentHead content_head = new im_msg.ContentHead();
  public final PBBytesField gbk_tmp_msg_body = PBField.initBytes(ByteStringMicro.EMPTY);
  public im_msg.RoutingHead routing_head = new im_msg.RoutingHead();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "routing_head", "content_head", "gbk_tmp_msg_body" }, new Object[] { null, null, localByteStringMicro }, MsgHead.class);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\msg\im_msg$MsgHead.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */