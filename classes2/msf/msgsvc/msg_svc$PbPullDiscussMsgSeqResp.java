package msf.msgsvc;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class msg_svc$PbPullDiscussMsgSeqResp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "result", "errmsg", "discuss_info_resp" }, new Object[] { Integer.valueOf(0), "", null }, PbPullDiscussMsgSeqResp.class);
  public final PBRepeatMessageField discuss_info_resp = PBField.initRepeatMessage(msg_svc.PbPullDiscussMsgSeqResp.DiscussInfoResp.class);
  public final PBStringField errmsg = PBField.initString("");
  public final PBUInt32Field result = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\msf\msgsvc\msg_svc$PbPullDiscussMsgSeqResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */