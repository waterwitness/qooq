package tencent.im.s2c.msgtype0x210.submsgtype0x4e;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class Submsgtype0x4e$GroupBulletin
  extends MessageMicro
{
  public static final int RPT_MSG_CONTENT_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_content" }, new Object[] { null }, GroupBulletin.class);
  public final PBRepeatMessageField rpt_msg_content = PBField.initRepeatMessage(Submsgtype0x4e.GroupBulletin.Content.class);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\s2c\msgtype0x210\submsgtype0x4e\Submsgtype0x4e$GroupBulletin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */