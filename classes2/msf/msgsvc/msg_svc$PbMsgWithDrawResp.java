package msf.msgsvc;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class msg_svc$PbMsgWithDrawResp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "c2c_with_draw", "group_with_draw" }, new Object[] { null, null }, PbMsgWithDrawResp.class);
  public final PBRepeatMessageField c2c_with_draw = PBField.initRepeatMessage(msg_svc.PbC2CMsgWithDrawResp.class);
  public final PBRepeatMessageField group_with_draw = PBField.initRepeatMessage(msg_svc.PbGroupMsgWithDrawResp.class);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\msf\msgsvc\msg_svc$PbMsgWithDrawResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */