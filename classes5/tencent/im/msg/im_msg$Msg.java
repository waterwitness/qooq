package tencent.im.msg;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class im_msg$Msg
  extends MessageMicro
{
  public static final int BODY_FIELD_NUMBER = 2;
  public static final int HEAD_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "head", "body" }, new Object[] { null, null }, Msg.class);
  public im_msg_body.MsgBody body = new im_msg_body.MsgBody();
  public im_msg.MsgHead head = new im_msg.MsgHead();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\msg\im_msg$Msg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */