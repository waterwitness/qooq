package tencent.im.oidb.cmd0x5e0;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Oidb_0x5e0$ProfileInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_uin", "rpt_msg_profile_info" }, new Object[] { Long.valueOf(0L), null }, ProfileInfo.class);
  public final PBRepeatMessageField rpt_msg_profile_info = PBField.initRepeatMessage(Oidb_0x5e0.ProfileTvInfo.class);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x5e0\Oidb_0x5e0$ProfileInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */