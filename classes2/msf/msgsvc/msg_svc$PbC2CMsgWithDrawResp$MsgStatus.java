package msf.msgsvc;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class msg_svc$PbC2CMsgWithDrawResp$MsgStatus
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "msg_info", "uint32_status" }, new Object[] { null, Integer.valueOf(0) }, MsgStatus.class);
  public msg_svc.PbC2CMsgWithDrawReq.MsgInfo msg_info = new msg_svc.PbC2CMsgWithDrawReq.MsgInfo();
  public final PBUInt32Field uint32_status = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\msf\msgsvc\msg_svc$PbC2CMsgWithDrawResp$MsgStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */