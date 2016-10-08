package tencent.im.reminder;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class im_reminder$Request$Update
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "from", "to" }, new Object[] { null, null }, Update.class);
  public im_reminder.Reminder from = new im_reminder.Reminder();
  public im_reminder.Reminder to = new im_reminder.Reminder();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tencent\im\reminder\im_reminder$Request$Update.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */