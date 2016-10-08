package tencent.im.cs.cmd0x345;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x345$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 58, 66, 74, 82, 90 }, new String[] { "uint32_sub_cmd", "uint32_return_code", "msg_subcmd_0x1_rsp_body", "msg_subcmd_0x2_rsp_body", "msg_subcmd_0x3_rsp_body", "msg_subcmd_0x4_rsp_body", "msg_subcmd_0x5_rsp_body", "msg_subcmd_0x6_rsp_body", "msg_subcmd_0x7_rsp_body", "msg_subcmd_0x9_rsp_body", "msg_subcmd_0xa_rsp_body" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null, null, null, null, null, null, null, null }, RspBody.class);
  public cmd0x345.RspBody.SubCmd0x1RspBody msg_subcmd_0x1_rsp_body = new cmd0x345.RspBody.SubCmd0x1RspBody();
  public cmd0x345.RspBody.SubCmd0x2RspBody msg_subcmd_0x2_rsp_body = new cmd0x345.RspBody.SubCmd0x2RspBody();
  public cmd0x345.RspBody.SubCmd0x3RspBody msg_subcmd_0x3_rsp_body = new cmd0x345.RspBody.SubCmd0x3RspBody();
  public cmd0x345.RspBody.SubCmd0x4RspBody msg_subcmd_0x4_rsp_body = new cmd0x345.RspBody.SubCmd0x4RspBody();
  public cmd0x345.RspBody.SubCmd0x5RspBody msg_subcmd_0x5_rsp_body = new cmd0x345.RspBody.SubCmd0x5RspBody();
  public cmd0x345.RspBody.SubCmd0x6RspBody msg_subcmd_0x6_rsp_body = new cmd0x345.RspBody.SubCmd0x6RspBody();
  public cmd0x345.RspBody.SubCmd0x7RspBody msg_subcmd_0x7_rsp_body = new cmd0x345.RspBody.SubCmd0x7RspBody();
  public cmd0x345.RspBody.SubCmd0x9RspBody msg_subcmd_0x9_rsp_body = new cmd0x345.RspBody.SubCmd0x9RspBody();
  public cmd0x345.RspBody.SubCmd0xaRspBody msg_subcmd_0xa_rsp_body = new cmd0x345.RspBody.SubCmd0xaRspBody();
  public final PBUInt32Field uint32_return_code = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\cs\cmd0x345\cmd0x345$RspBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */