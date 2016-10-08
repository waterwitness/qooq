package msf.msgsvc;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class msg_svc$PbPullDiscussMsgSeqReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "discuss_info_req" }, new Object[] { null }, PbPullDiscussMsgSeqReq.class);
  public final PBRepeatMessageField discuss_info_req = PBField.initRepeatMessage(msg_svc.PbPullDiscussMsgSeqReq.DiscussInfoReq.class);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\msf\msgsvc\msg_svc$PbPullDiscussMsgSeqReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */