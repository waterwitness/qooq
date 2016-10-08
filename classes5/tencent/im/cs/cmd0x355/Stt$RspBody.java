package tencent.im.cs.cmd0x355;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Stt$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint32_sub_cmd", "msg_group_ptt_resp", "msg_c2c_ptt_resp", "msg_corret_text_Resp" }, new Object[] { Integer.valueOf(0), null, null, null }, RspBody.class);
  public Stt.TransC2CPttResp msg_c2c_ptt_resp = new Stt.TransC2CPttResp();
  public Stt.CorretTextResp msg_corret_text_Resp = new Stt.CorretTextResp();
  public Stt.TransGroupPttResp msg_group_ptt_resp = new Stt.TransGroupPttResp();
  public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\cs\cmd0x355\Stt$RspBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */