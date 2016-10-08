package tencent.im.group.group_label;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class GroupLabel$Color
  extends MessageMicro
{
  public static final int UINT32_B_FIELD_NUMBER = 3;
  public static final int UINT32_G_FIELD_NUMBER = 2;
  public static final int UINT32_R_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_r", "uint32_g", "uint32_b" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, Color.class);
  public final PBUInt32Field uint32_b = PBField.initUInt32(0);
  public final PBUInt32Field uint32_g = PBField.initUInt32(0);
  public final PBUInt32Field uint32_r = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\group\group_label\GroupLabel$Color.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */