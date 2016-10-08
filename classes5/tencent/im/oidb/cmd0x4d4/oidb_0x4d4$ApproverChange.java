package tencent.im.oidb.cmd0x4d4;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.trunk.Qworkflow.Qworkflow.Approver;

public final class oidb_0x4d4$ApproverChange
  extends MessageMicro
{
  public static final int ADD = 1;
  public static final int DELETE = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "enum_change_type", "msg_approver" }, new Object[] { Integer.valueOf(1), null }, ApproverChange.class);
  public final PBEnumField enum_change_type = PBField.initEnum(1);
  public Qworkflow.Approver msg_approver = new Qworkflow.Approver();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x4d4\oidb_0x4d4$ApproverChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */