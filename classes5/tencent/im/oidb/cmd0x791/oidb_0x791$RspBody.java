package tencent.im.oidb.cmd0x791;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x791$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_result", "msg_get_reddot_res", "msg_set_reddot_res" }, new Object[] { Integer.valueOf(0), null, null }, RspBody.class);
  public oidb_0x791.GetRedDotRes msg_get_reddot_res = new oidb_0x791.GetRedDotRes();
  public oidb_0x791.SetRedDotRes msg_set_reddot_res = new oidb_0x791.SetRedDotRes();
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x791\oidb_0x791$RspBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */