package msf.msgsvc;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import msf.msgcomm.msg_comm.AppShareInfo;
import msf.msgcomm.msg_comm.ContentHead;
import tencent.im.msg.im_msg_body.MsgBody;

public final class msg_svc$PbSendMsgReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public msg_comm.AppShareInfo app_share = new msg_comm.AppShareInfo();
  public msg_comm.ContentHead content_head = new msg_comm.ContentHead();
  public final PBUInt32Field data_statist = PBField.initUInt32(0);
  public im_msg_body.MsgBody msg_body = new im_msg_body.MsgBody();
  public final PBUInt32Field msg_rand = PBField.initUInt32(0);
  public final PBUInt32Field msg_seq = PBField.initUInt32(0);
  public final PBUInt32Field msg_via = PBField.initUInt32(0);
  public msg_svc.MultiMsgAssist multi_msg_assist = new msg_svc.MultiMsgAssist();
  public msg_svc.RoutingHead routing_head = new msg_svc.RoutingHead();
  public final PBBytesField sync_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 50, 58, 64, 72, 82 }, new String[] { "routing_head", "content_head", "msg_body", "msg_seq", "msg_rand", "sync_cookie", "app_share", "msg_via", "data_statist", "multi_msg_assist" }, new Object[] { null, null, null, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, null, Integer.valueOf(0), Integer.valueOf(0), null }, PbSendMsgReq.class);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\msf\msgsvc\msg_svc$PbSendMsgReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */