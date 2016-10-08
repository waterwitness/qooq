package tencent.im.oidb.cmd0x6c3;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0x6c3$ExtParam
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_login_sig" }, new Object[] { null }, ExtParam.class);
  public oidb_0x6c3.LoginSig msg_login_sig = new oidb_0x6c3.LoginSig();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x6c3\oidb_0x6c3$ExtParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */