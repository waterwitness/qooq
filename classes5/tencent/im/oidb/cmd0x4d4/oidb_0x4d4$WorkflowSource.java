package tencent.im.oidb.cmd0x4d4;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class oidb_0x4d4$WorkflowSource
  extends MessageMicro
{
  public static final int NEED_APPROVE = 2;
  public static final int NEED_OBSERVE = 1;
  public static final int SELF_CREATE = 3;
  public static final int SHARED = 4;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "enum_source_type" }, new Object[] { Integer.valueOf(1) }, WorkflowSource.class);
  public final PBEnumField enum_source_type = PBField.initEnum(1);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x4d4\oidb_0x4d4$WorkflowSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */