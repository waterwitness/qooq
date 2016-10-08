package msf.registerproxy;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class register_proxy$DiscussList
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56 }, new String[] { "discuss_code", "discuss_seq", "member_seq", "info_seq", "bHotGroup", "redpack_time", "has_msg" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Boolean.valueOf(false), Long.valueOf(0L), Boolean.valueOf(false) }, DiscussList.class);
  public final PBBoolField bHotGroup = PBField.initBool(false);
  public final PBUInt64Field discuss_code = PBField.initUInt64(0L);
  public final PBUInt64Field discuss_seq = PBField.initUInt64(0L);
  public final PBBoolField has_msg = PBField.initBool(false);
  public final PBUInt64Field info_seq = PBField.initUInt64(0L);
  public final PBUInt64Field member_seq = PBField.initUInt64(0L);
  public final PBUInt64Field redpack_time = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\msf\registerproxy\register_proxy$DiscussList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */