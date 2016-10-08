package tencent.mobileim.structmsg;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class structmsg$RspNextSystemMsg
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40 }, new String[] { "head", "msgs", "following_friend_seq", "following_group_seq", "checktype" }, new Object[] { null, null, Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(1) }, RspNextSystemMsg.class);
  public final PBEnumField checktype = PBField.initEnum(1);
  public final PBUInt64Field following_friend_seq = PBField.initUInt64(0L);
  public final PBUInt64Field following_group_seq = PBField.initUInt64(0L);
  public structmsg.RspHead head = new structmsg.RspHead();
  public final PBRepeatMessageField msgs = PBField.initRepeatMessage(structmsg.StructMsg.class);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tencent\mobileim\structmsg\structmsg$RspNextSystemMsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */