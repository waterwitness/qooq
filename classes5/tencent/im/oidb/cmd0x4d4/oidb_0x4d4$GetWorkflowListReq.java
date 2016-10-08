package tencent.im.oidb.cmd0x4d4;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.trunk.Qworkflow.Qworkflow.WorkflowBrief;

public final class oidb_0x4d4$GetWorkflowListReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42 }, new String[] { "uint64_end_time", "rpt_msg_workflow_list", "uint32_amount", "msg_filter", "msg_order" }, new Object[] { Long.valueOf(0L), null, Integer.valueOf(0), null, null }, GetWorkflowListReq.class);
  public oidb_0x4d4.WorkflowFilter msg_filter = new oidb_0x4d4.WorkflowFilter();
  public oidb_0x4d4.WorkflowOrder msg_order = new oidb_0x4d4.WorkflowOrder();
  public final PBRepeatMessageField rpt_msg_workflow_list = PBField.initRepeatMessage(Qworkflow.WorkflowBrief.class);
  public final PBUInt32Field uint32_amount = PBField.initUInt32(0);
  public final PBUInt64Field uint64_end_time = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x4d4\oidb_0x4d4$GetWorkflowListReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */