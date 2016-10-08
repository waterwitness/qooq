package tencent.im.msg;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class im_msg_body$QQWalletMsg
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "aio_body" }, new Object[] { null }, QQWalletMsg.class);
  public im_msg_body.QQWalletAioBody aio_body = new im_msg_body.QQWalletAioBody();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\msg\im_msg_body$QQWalletMsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */