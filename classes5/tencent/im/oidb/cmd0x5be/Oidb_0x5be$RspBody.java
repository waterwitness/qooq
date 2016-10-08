package tencent.im.oidb.cmd0x5be;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Oidb_0x5be$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField opt_bytes_more_app_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field opt_uint64_groupcode = PBField.initUInt64(0L);
  public final PBRepeatMessageField rpt_appinfo_list = PBField.initRepeatMessage(Oidb_0x5be.AppInfo.class);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "opt_uint64_groupcode", "rpt_appinfo_list", "opt_bytes_more_app_url" }, new Object[] { Long.valueOf(0L), null, localByteStringMicro }, RspBody.class);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x5be\Oidb_0x5be$RspBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */