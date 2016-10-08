package tencent.mobileim.structmsg;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class structmsg$SystemMsgAction
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42 }, new String[] { "name", "result", "action", "action_info", "detail_name" }, new Object[] { "", "", Integer.valueOf(0), null, "" }, SystemMsgAction.class);
  public final PBUInt32Field action = PBField.initUInt32(0);
  public structmsg.SystemMsgActionInfo action_info = new structmsg.SystemMsgActionInfo();
  public final PBStringField detail_name = PBField.initString("");
  public final PBStringField name = PBField.initString("");
  public final PBStringField result = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tencent\mobileim\structmsg\structmsg$SystemMsgAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */