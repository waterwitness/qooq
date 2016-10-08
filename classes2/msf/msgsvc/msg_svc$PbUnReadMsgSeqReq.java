package msf.msgsvc;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class msg_svc$PbUnReadMsgSeqReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "c2c_unread_info", "binduin_unread_info", "group_unread_info", "discuss_unread_info" }, new Object[] { null, null, null, null }, PbUnReadMsgSeqReq.class);
  public final PBRepeatMessageField binduin_unread_info = PBField.initRepeatMessage(msg_svc.PbBindUinUnReadMsgNumReq.class);
  public msg_svc.PbC2CUnReadMsgNumReq c2c_unread_info = new msg_svc.PbC2CUnReadMsgNumReq();
  public msg_svc.PbPullDiscussMsgSeqReq discuss_unread_info = new msg_svc.PbPullDiscussMsgSeqReq();
  public msg_svc.PbPullGroupMsgSeqReq group_unread_info = new msg_svc.PbPullGroupMsgSeqReq();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\msf\msgsvc\msg_svc$PbUnReadMsgSeqReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */