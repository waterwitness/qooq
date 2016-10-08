package msf.msgsvc;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class msg_svc$PbDelRoamMsgReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "c2c_msg", "grp_msg", "dis_msg" }, new Object[] { null, null, null }, PbDelRoamMsgReq.class);
  public msg_svc.PbDelRoamMsgReq.C2CMsg c2c_msg = new msg_svc.PbDelRoamMsgReq.C2CMsg();
  public msg_svc.PbDelRoamMsgReq.DisMsg dis_msg = new msg_svc.PbDelRoamMsgReq.DisMsg();
  public msg_svc.PbDelRoamMsgReq.GrpMsg grp_msg = new msg_svc.PbDelRoamMsgReq.GrpMsg();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\msf\msgsvc\msg_svc$PbDelRoamMsgReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */