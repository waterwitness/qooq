package tencent.im.cs.cmd0x345;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x345$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66, 74, 82 }, new String[] { "uint32_sub_cmd", "msg_subcmd_0x1_req_body", "msg_subcmd_0x2_req_body", "msg_subcmd_0x3_req_body", "msg_subcmd_0x4_req_body", "msg_subcmd_0x5_req_body", "msg_subcmd_0x6_req_body", "msg_subcmd_0x7_req_body", "msg_subcmd_0x9_req_body", "msg_subcmd_0xa_req_body" }, new Object[] { Integer.valueOf(0), null, null, null, null, null, null, null, null, null }, ReqBody.class);
  public cmd0x345.ReqBody.SubCmd0x1ReqBody msg_subcmd_0x1_req_body = new cmd0x345.ReqBody.SubCmd0x1ReqBody();
  public cmd0x345.ReqBody.SubCmd0x2ReqBody msg_subcmd_0x2_req_body = new cmd0x345.ReqBody.SubCmd0x2ReqBody();
  public cmd0x345.ReqBody.SubCmd0x3ReqBody msg_subcmd_0x3_req_body = new cmd0x345.ReqBody.SubCmd0x3ReqBody();
  public cmd0x345.ReqBody.SubCmd0x4ReqBody msg_subcmd_0x4_req_body = new cmd0x345.ReqBody.SubCmd0x4ReqBody();
  public cmd0x345.ReqBody.SubCmd0x5ReqBody msg_subcmd_0x5_req_body = new cmd0x345.ReqBody.SubCmd0x5ReqBody();
  public cmd0x345.ReqBody.SubCmd0x6ReqBody msg_subcmd_0x6_req_body = new cmd0x345.ReqBody.SubCmd0x6ReqBody();
  public cmd0x345.ReqBody.SubCmd0x7ReqBody msg_subcmd_0x7_req_body = new cmd0x345.ReqBody.SubCmd0x7ReqBody();
  public cmd0x345.ReqBody.SubCmd0x9ReqBody msg_subcmd_0x9_req_body = new cmd0x345.ReqBody.SubCmd0x9ReqBody();
  public cmd0x345.ReqBody.SubCmd0xaReqBody msg_subcmd_0xa_req_body = new cmd0x345.ReqBody.SubCmd0xaReqBody();
  public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\cs\cmd0x345\cmd0x345$ReqBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */