package tencent.im.msg;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class im_imagent$ImAgentPackage
  extends MessageMicro
{
  public static final int HEAD_FIELD_NUMBER = 1;
  public static final int MSG_SEND_REQ_FIELD_NUMBER = 11;
  public static final int MSG_SEND_RESP_FIELD_NUMBER = 12;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 90, 98 }, new String[] { "head", "msg_send_req", "msg_send_resp" }, new Object[] { null, null, null }, ImAgentPackage.class);
  public im_imagent.ImAgentHead head = new im_imagent.ImAgentHead();
  public im_msg.MsgSendReq msg_send_req = new im_msg.MsgSendReq();
  public im_msg.MsgSendResp msg_send_resp = new im_msg.MsgSendResp();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\msg\im_imagent$ImAgentPackage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */