package tencent.im.oidb.cmd0x791;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0x791$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_set_reddot", "msg_get_reddot" }, new Object[] { null, null }, ReqBody.class);
  public oidb_0x791.GetRedDotOpt msg_get_reddot = new oidb_0x791.GetRedDotOpt();
  public oidb_0x791.SetRedDotOpt msg_set_reddot = new oidb_0x791.SetRedDotOpt();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x791\oidb_0x791$ReqBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */