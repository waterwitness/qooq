package tencent.im.cs.cmd0x3fe;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x3fe$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 80 }, new String[] { "int32_ret", "rpt_msg_level_info", "uint32_subcmd" }, new Object[] { Integer.valueOf(0), null, Integer.valueOf(0) }, RspBody.class);
  public final PBInt32Field int32_ret = PBField.initInt32(0);
  public final PBRepeatMessageField rpt_msg_level_info = PBField.initRepeatMessage(cmd0x3fe.LevelInfo.class);
  public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\cs\cmd0x3fe\cmd0x3fe$RspBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */