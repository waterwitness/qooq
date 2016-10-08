package msf.msgsvc;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class msg_svc$PbC2CMsgWithDrawResp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "result", "errmsg", "msg_status", "uint32_sub_cmd" }, new Object[] { Integer.valueOf(0), "", null, Integer.valueOf(0) }, PbC2CMsgWithDrawResp.class);
  public final PBStringField errmsg = PBField.initString("");
  public final PBRepeatMessageField msg_status = PBField.initRepeatMessage(msg_svc.PbC2CMsgWithDrawResp.MsgStatus.class);
  public final PBUInt32Field result = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\msf\msgsvc\msg_svc$PbC2CMsgWithDrawResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */