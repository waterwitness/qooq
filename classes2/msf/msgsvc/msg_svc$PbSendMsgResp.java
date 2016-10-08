package msf.msgsvc;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class msg_svc$PbSendMsgResp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42 }, new String[] { "result", "errmsg", "send_time", "uint32_svrbusy_wait_time", "msg_send_info" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), null }, PbSendMsgResp.class);
  public final PBStringField errmsg = PBField.initString("");
  public msg_svc.MsgSendInfo msg_send_info = new msg_svc.MsgSendInfo();
  public final PBUInt32Field result = PBField.initUInt32(0);
  public final PBUInt32Field send_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_svrbusy_wait_time = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\msf\msgsvc\msg_svc$PbSendMsgResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */