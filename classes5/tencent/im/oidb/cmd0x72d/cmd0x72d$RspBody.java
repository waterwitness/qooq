package tencent.im.oidb.cmd0x72d;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x72d$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "opt_uint32_ret_code", "rpt_uint64_groupcode", "opt_uint64_timestamp" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L) }, RspBody.class);
  public final PBUInt32Field opt_uint32_ret_code = PBField.initUInt32(0);
  public final PBUInt64Field opt_uint64_timestamp = PBField.initUInt64(0L);
  public final PBRepeatField rpt_uint64_groupcode = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x72d\cmd0x72d$RspBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */