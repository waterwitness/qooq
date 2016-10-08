package tencent.im.reminder;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class im_reminder$Response
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "reminder", "result", "err" }, new Object[] { null, Integer.valueOf(0), "" }, Response.class);
  public final PBStringField err = PBField.initString("");
  public final PBRepeatMessageField reminder = PBField.initRepeatMessage(im_reminder.Reminder.class);
  public final PBUInt32Field result = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tencent\im\reminder\im_reminder$Response.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */