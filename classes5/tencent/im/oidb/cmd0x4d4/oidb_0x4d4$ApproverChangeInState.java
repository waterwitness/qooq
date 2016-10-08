package tencent.im.oidb.cmd0x4d4;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.trunk.Qworkflow.Qworkflow.WorkflowState;

public final class oidb_0x4d4$ApproverChangeInState
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_workflow_state", "rpt_msg_approver_change_list" }, new Object[] { null, null }, ApproverChangeInState.class);
  public Qworkflow.WorkflowState msg_workflow_state = new Qworkflow.WorkflowState();
  public final PBRepeatMessageField rpt_msg_approver_change_list = PBField.initRepeatMessage(oidb_0x4d4.ApproverChange.class);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x4d4\oidb_0x4d4$ApproverChangeInState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */