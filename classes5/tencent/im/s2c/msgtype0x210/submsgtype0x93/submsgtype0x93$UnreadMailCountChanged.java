package tencent.im.s2c.msgtype0x210.submsgtype0x93;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class submsgtype0x93$UnreadMailCountChanged
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_umc" }, new Object[] { null }, UnreadMailCountChanged.class);
  public submsgtype0x93.UnreadMailCountInfo msg_umc = new submsgtype0x93.UnreadMailCountInfo();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\s2c\msgtype0x210\submsgtype0x93\submsgtype0x93$UnreadMailCountChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */