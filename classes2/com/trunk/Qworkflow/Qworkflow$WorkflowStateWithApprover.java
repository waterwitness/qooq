package com.trunk.Qworkflow;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class Qworkflow$WorkflowStateWithApprover
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_workflow_state", "rpt_msg_approver_list" }, new Object[] { null, null }, WorkflowStateWithApprover.class);
  public Qworkflow.WorkflowState msg_workflow_state = new Qworkflow.WorkflowState();
  public final PBRepeatMessageField rpt_msg_approver_list = PBField.initRepeatMessage(Qworkflow.Approver.class);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\trunk\Qworkflow\Qworkflow$WorkflowStateWithApprover.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */