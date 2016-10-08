package tencent.im.oidb.cmd0x4d4;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.trunk.Qworkflow.Qworkflow.Workflow;

public final class oidb_0x4d4$AddWorkflowReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_workflow" }, new Object[] { null }, AddWorkflowReq.class);
  public Qworkflow.Workflow msg_workflow = new Qworkflow.Workflow();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x4d4\oidb_0x4d4$AddWorkflowReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */