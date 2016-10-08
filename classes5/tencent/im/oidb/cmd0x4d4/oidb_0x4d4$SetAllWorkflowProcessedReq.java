package tencent.im.oidb.cmd0x4d4;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.trunk.Qworkflow.Qworkflow.ApproverState;

public final class oidb_0x4d4$SetAllWorkflowProcessedReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_end_time", "msg_approver_state" }, new Object[] { Long.valueOf(0L), null }, SetAllWorkflowProcessedReq.class);
  public Qworkflow.ApproverState msg_approver_state = new Qworkflow.ApproverState();
  public final PBUInt64Field uint64_end_time = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x4d4\oidb_0x4d4$SetAllWorkflowProcessedReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */