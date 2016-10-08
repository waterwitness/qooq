package msf.msgsvc;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import tencent.im.c2c.msgtype0xa6.submsgtype0xc1.SubMsgType0xc1.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x1a.SubMsgType0x1a.MsgBody;

public final class msg_svc$SecretFileHead
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "secret_file_msg", "secret_file_status" }, new Object[] { null, null }, SecretFileHead.class);
  public SubMsgType0xc1.MsgBody secret_file_msg = new SubMsgType0xc1.MsgBody();
  public SubMsgType0x1a.MsgBody secret_file_status = new SubMsgType0x1a.MsgBody();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\msf\msgsvc\msg_svc$SecretFileHead.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */