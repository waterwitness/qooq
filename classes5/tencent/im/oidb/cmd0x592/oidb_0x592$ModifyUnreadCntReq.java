package tencent.im.oidb.cmd0x592;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x592$ModifyUnreadCntReq
  extends MessageMicro
{
  public static final int CLEAR = 3;
  public static final int DECREASE = 2;
  public static final int INCREASE = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "enum_modify_type", "uint32_notice_var", "uint32_notice_version" }, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0) }, ModifyUnreadCntReq.class);
  public final PBEnumField enum_modify_type = PBField.initEnum(1);
  public final PBUInt32Field uint32_notice_var = PBField.initUInt32(0);
  public final PBUInt32Field uint32_notice_version = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x592\oidb_0x592$ModifyUnreadCntReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */