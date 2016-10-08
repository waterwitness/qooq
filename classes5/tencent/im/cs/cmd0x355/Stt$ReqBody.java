package tencent.im.cs.cmd0x355;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Stt$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint32_sub_cmd", "msg_group_ptt_req", "msg_c2c_ptt_req", "msg_corret_text_req" }, new Object[] { Integer.valueOf(0), null, null, null }, ReqBody.class);
  public Stt.TransC2CPttReq msg_c2c_ptt_req = new Stt.TransC2CPttReq();
  public Stt.CorretTextReq msg_corret_text_req = new Stt.CorretTextReq();
  public Stt.TransGroupPttReq msg_group_ptt_req = new Stt.TransGroupPttReq();
  public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\cs\cmd0x355\Stt$ReqBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */