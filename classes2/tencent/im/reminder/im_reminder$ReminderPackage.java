package tencent.im.reminder;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class im_reminder$ReminderPackage
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "head", "request", "response" }, new Object[] { null, null, null }, ReminderPackage.class);
  public im_reminder.PkgHead head = new im_reminder.PkgHead();
  public final PBRepeatMessageField request = PBField.initRepeatMessage(im_reminder.Request.class);
  public final PBRepeatMessageField response = PBField.initRepeatMessage(im_reminder.Response.class);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tencent\im\reminder\im_reminder$ReminderPackage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */