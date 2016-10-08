package tencent.im.cs.cmd0x6ff;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class subcmd0x51b$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "int32_cmd", "msg_get_single_roam_msg_req", "msg_get_single_cluster_msg_req", "msg_del_single_cluster_msg_req" }, new Object[] { Integer.valueOf(0), null, null, null }, ReqBody.class);
  public final PBInt32Field int32_cmd = PBField.initInt32(0);
  public subcmd0x51b.DelSingleClusterMsgReq msg_del_single_cluster_msg_req = new subcmd0x51b.DelSingleClusterMsgReq();
  public subcmd0x51b.GetSingleClusterMsgReq msg_get_single_cluster_msg_req = new subcmd0x51b.GetSingleClusterMsgReq();
  public subcmd0x51b.GetSingleRoamMsgReq msg_get_single_roam_msg_req = new subcmd0x51b.GetSingleRoamMsgReq();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\cs\cmd0x6ff\subcmd0x51b$ReqBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */