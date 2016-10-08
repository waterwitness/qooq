package tencent.im.oidb.cmd0x75e;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class oidb_cmd0x75e$ReqPara
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "enum_op_type" }, new Object[] { Integer.valueOf(1) }, ReqPara.class);
  public final PBEnumField enum_op_type = PBField.initEnum(1);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x75e\oidb_cmd0x75e$ReqPara.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */