package tencent.mobileim.structmsg;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class structmsg$RspSystemMsgRead
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "head", "type", "checktype" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(1) }, RspSystemMsgRead.class);
  public final PBEnumField checktype = PBField.initEnum(1);
  public structmsg.RspHead head = new structmsg.RspHead();
  public final PBUInt32Field type = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tencent\mobileim\structmsg\structmsg$RspSystemMsgRead.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */