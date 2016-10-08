package tencent.im.oidb.cmd0xa88;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.hotchat.Common.SeatsInfo;

public final class oidb_0xa88$NoticeBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48 }, new String[] { "uint32_service_type", "uint32_seat_op", "uint64_guest_uin", "rpt_msg_seats_info", "uint64_white_uin", "uint32_seat_id" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), null, Long.valueOf(0L), Integer.valueOf(0) }, NoticeBody.class);
  public final PBRepeatMessageField rpt_msg_seats_info = PBField.initRepeatMessage(Common.SeatsInfo.class);
  public final PBUInt32Field uint32_seat_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_seat_op = PBField.initUInt32(0);
  public final PBUInt32Field uint32_service_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_guest_uin = PBField.initUInt64(0L);
  public final PBRepeatField uint64_white_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0xa88\oidb_0xa88$NoticeBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */