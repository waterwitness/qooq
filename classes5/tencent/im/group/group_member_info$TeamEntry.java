package tencent.im.group;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class group_member_info$TeamEntry
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "rpt_uint64_depid", "rpt_uint64_self_depid" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, TeamEntry.class);
  public final PBRepeatField rpt_uint64_depid = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBRepeatField rpt_uint64_self_depid = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\group\group_member_info$TeamEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */