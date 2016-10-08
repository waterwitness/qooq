package tencent.im.longconn.multimsg;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class MultiMsg$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_subcmd", "rpt_multimsg_applyup_rsp", "rpt_multimsg_applydown_rsp" }, new Object[] { Integer.valueOf(0), null, null }, RspBody.class);
  public final PBRepeatMessageField rpt_multimsg_applydown_rsp = PBField.initRepeatMessage(MultiMsg.MultiMsgApplyDownRsp.class);
  public final PBRepeatMessageField rpt_multimsg_applyup_rsp = PBField.initRepeatMessage(MultiMsg.MultiMsgApplyUpRsp.class);
  public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tencent\im\longconn\multimsg\MultiMsg$RspBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */