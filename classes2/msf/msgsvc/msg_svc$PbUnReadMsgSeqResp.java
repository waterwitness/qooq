package msf.msgsvc;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class msg_svc$PbUnReadMsgSeqResp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "c2c_unread_info", "binduin_unread_info", "group_unread_info", "discuss_unread_info" }, new Object[] { null, null, null, null }, PbUnReadMsgSeqResp.class);
  public final PBRepeatMessageField binduin_unread_info = PBField.initRepeatMessage(msg_svc.PbBindUinUnReadMsgNumResp.class);
  public msg_svc.PbC2CUnReadMsgNumResp c2c_unread_info = new msg_svc.PbC2CUnReadMsgNumResp();
  public msg_svc.PbPullDiscussMsgSeqResp discuss_unread_info = new msg_svc.PbPullDiscussMsgSeqResp();
  public msg_svc.PbPullGroupMsgSeqResp group_unread_info = new msg_svc.PbPullGroupMsgSeqResp();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\msf\msgsvc\msg_svc$PbUnReadMsgSeqResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */