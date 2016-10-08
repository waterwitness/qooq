package tencent.im.msgrevoke;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class msgrevoke_userdef$UinTypeUserDef
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_from_uin_type", "uint64_from_group_code", "str_file_uuid" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), "" }, UinTypeUserDef.class);
  public final PBRepeatField str_file_uuid = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBUInt32Field uint32_from_uin_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_from_group_code = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tencent\im\msgrevoke\msgrevoke_userdef$UinTypeUserDef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */