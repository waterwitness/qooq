package tencent.im.reminder;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class im_reminder$Request$Add
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "reminder" }, new Object[] { null }, Add.class);
  public im_reminder.Reminder reminder = new im_reminder.Reminder();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tencent\im\reminder\im_reminder$Request$Add.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */