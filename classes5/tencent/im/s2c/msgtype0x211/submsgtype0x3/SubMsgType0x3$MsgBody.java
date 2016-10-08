package tencent.im.s2c.msgtype0x211.submsgtype0x3;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class SubMsgType0x3$MsgBody
  extends MessageMicro
{
  public static final int MSG_FAIL_NOTIFY_FIELD_NUMBER = 2;
  public static final int MSG_PROGRESS_NOTIFY_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_progress_notify", "msg_fail_notify" }, new Object[] { null, null }, MsgBody.class);
  public SubMsgType0x3.FailNotify msg_fail_notify = new SubMsgType0x3.FailNotify();
  public SubMsgType0x3.ProgressNotify msg_progress_notify = new SubMsgType0x3.ProgressNotify();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\s2c\msgtype0x211\submsgtype0x3\SubMsgType0x3$MsgBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */