package tencent.im.cs.cmd0x3bb;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x3bb$AnonyMsg
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 82, 90 }, new String[] { "uint32_cmd", "msg_anony_req", "msg_anony_rsp" }, new Object[] { Integer.valueOf(0), null, null }, AnonyMsg.class);
  public cmd0x3bb.ReqBody msg_anony_req = new cmd0x3bb.ReqBody();
  public cmd0x3bb.RspBody msg_anony_rsp = new cmd0x3bb.RspBody();
  public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\cs\cmd0x3bb\cmd0x3bb$AnonyMsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */