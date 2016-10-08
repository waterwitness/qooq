package tencent.im.msg;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class im_msg$C2CRelation
  extends MessageMicro
{
  public static final int C2C_TYPE_FIELD_NUMBER = 1;
  public static final int GROUP_INFO_FIELD_NUMBER = 2;
  public static final int TOKEN_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "c2c_type", "group_info", "token" }, new Object[] { Integer.valueOf(0), null, null }, C2CRelation.class);
  public final PBEnumField c2c_type = PBField.initEnum(0);
  public im_common.GroupInfo group_info = new im_common.GroupInfo();
  public im_common.Token token = new im_common.Token();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\msg\im_msg$C2CRelation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */