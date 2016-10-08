package tencent.im.oidb.cmd0x4d4;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x4d4$UpdateApproverListOfState
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_workflow_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField rpt_msg_state_approver_change_list = PBField.initRepeatMessage(oidb_0x4d4.ApproverChangeInState.class);
  public final PBUInt32Field uint32_data_version = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "bytes_workflow_id", "uint32_data_version", "rpt_msg_state_approver_change_list" }, new Object[] { localByteStringMicro, Integer.valueOf(0), null }, UpdateApproverListOfState.class);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x4d4\oidb_0x4d4$UpdateApproverListOfState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */