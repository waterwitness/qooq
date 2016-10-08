package tencent.im.profile.forward;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class sysmsg_push$ForwardBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 162 }, new String[] { "uint32_notify_type", "uint32_op_type", "msg_appointment_not" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null }, ForwardBody.class);
  public sysmsg_push.AppointmentNot msg_appointment_not = new sysmsg_push.AppointmentNot();
  public final PBUInt32Field uint32_notify_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_op_type = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tencent\im\profile\forward\sysmsg_push$ForwardBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */