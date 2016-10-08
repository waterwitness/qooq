package msf.msgsvc;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class msg_svc$PbPullGroupMsgSeqReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "group_info_req" }, new Object[] { null }, PbPullGroupMsgSeqReq.class);
  public final PBRepeatMessageField group_info_req = PBField.initRepeatMessage(msg_svc.PbPullGroupMsgSeqReq.GroupInfoReq.class);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\msf\msgsvc\msg_svc$PbPullGroupMsgSeqReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */