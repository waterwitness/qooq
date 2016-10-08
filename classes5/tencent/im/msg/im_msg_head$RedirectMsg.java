package tencent.im.msg;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class im_msg_head$RedirectMsg
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 13, 16, 29, 32, 40 }, new String[] { "uint32_last_redirect_ip", "uint32_last_redirect_port", "uint32_redirect_ip", "uint32_redirect_port", "uint32_redirect_count" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, RedirectMsg.class);
  public final PBFixed32Field uint32_last_redirect_ip = PBField.initFixed32(0);
  public final PBUInt32Field uint32_last_redirect_port = PBField.initUInt32(0);
  public final PBUInt32Field uint32_redirect_count = PBField.initUInt32(0);
  public final PBFixed32Field uint32_redirect_ip = PBField.initFixed32(0);
  public final PBUInt32Field uint32_redirect_port = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\msg\im_msg_head$RedirectMsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */