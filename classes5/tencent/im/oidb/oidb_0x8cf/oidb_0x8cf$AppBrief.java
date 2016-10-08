package tencent.im.oidb.oidb_0x8cf;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x8cf$AppBrief
  extends MessageMicro
{
  public static final int OPT_UINT32_TIME_STAMP_FIELD_NUMBER = 2;
  public static final int OPT_UINT64_APPID_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "opt_uint64_appid", "opt_uint32_time_stamp" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, AppBrief.class);
  public final PBUInt32Field opt_uint32_time_stamp = PBField.initUInt32(0);
  public final PBUInt64Field opt_uint64_appid = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\oidb_0x8cf\oidb_0x8cf$AppBrief.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */