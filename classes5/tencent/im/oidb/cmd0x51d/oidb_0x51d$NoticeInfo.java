package tencent.im.oidb.cmd0x51d;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x51d$NoticeInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "opt_uint32_notice_count", "opt_uint32_notice_version" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, NoticeInfo.class);
  public final PBUInt32Field opt_uint32_notice_count = PBField.initUInt32(0);
  public final PBUInt32Field opt_uint32_notice_version = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x51d\oidb_0x51d$NoticeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */