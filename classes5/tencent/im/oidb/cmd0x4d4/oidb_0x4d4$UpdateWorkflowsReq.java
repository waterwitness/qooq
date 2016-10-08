package tencent.im.oidb.cmd0x4d4;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0x4d4$UpdateWorkflowsReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "enum_update_type", "rpt_msg_update_list", "rpt_msg_process_workflows", "msg_hand_over" }, new Object[] { Integer.valueOf(1), null, null, null }, UpdateWorkflowsReq.class);
  public final PBEnumField enum_update_type = PBField.initEnum(1);
  public oidb_0x4d4.UpdateHandOver msg_hand_over = new oidb_0x4d4.UpdateHandOver();
  public final PBRepeatMessageField rpt_msg_process_workflows = PBField.initRepeatMessage(oidb_0x4d4.UpdateApproverProcessState.class);
  public final PBRepeatMessageField rpt_msg_update_list = PBField.initRepeatMessage(oidb_0x4d4.UpdateApproverListOfState.class);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x4d4\oidb_0x4d4$UpdateWorkflowsReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */