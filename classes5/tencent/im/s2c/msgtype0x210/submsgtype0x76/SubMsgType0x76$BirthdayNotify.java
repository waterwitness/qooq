package tencent.im.s2c.msgtype0x210.submsgtype0x76;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class SubMsgType0x76$BirthdayNotify
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_one_friend" }, new Object[] { null }, BirthdayNotify.class);
  public final PBRepeatMessageField rpt_msg_one_friend = PBField.initRepeatMessage(SubMsgType0x76.OneBirthdayFriend.class);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\s2c\msgtype0x210\submsgtype0x76\SubMsgType0x76$BirthdayNotify.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */