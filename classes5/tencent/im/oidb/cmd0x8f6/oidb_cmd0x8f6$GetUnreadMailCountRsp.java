package tencent.im.oidb.cmd0x8f6;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_cmd0x8f6$GetUnreadMailCountRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_unread" }, new Object[] { null }, GetUnreadMailCountRsp.class);
  public oidb_cmd0x8f6.UnreadMailCountInfo msg_unread = new oidb_cmd0x8f6.UnreadMailCountInfo();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x8f6\oidb_cmd0x8f6$GetUnreadMailCountRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */