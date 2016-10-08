package tencent.im.oidb.cmd0x58b;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x58b$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "msg_cmd_error_code", "uint32_subcmd", "msg_get_conf_info" }, new Object[] { null, Integer.valueOf(0), null }, RspBody.class);
  public cmd0x58b.CmdErrorCode msg_cmd_error_code = new cmd0x58b.CmdErrorCode();
  public cmd0x58b.GetConfInfoRsp msg_get_conf_info = new cmd0x58b.GetConfInfoRsp();
  public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x58b\cmd0x58b$RspBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */