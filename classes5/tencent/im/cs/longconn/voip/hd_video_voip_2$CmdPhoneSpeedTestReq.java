package tencent.im.cs.longconn.voip;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class hd_video_voip_2$CmdPhoneSpeedTestReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 21 }, new String[] { "uint64_self_uin", "fixed32_self_client_ip" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, CmdPhoneSpeedTestReq.class);
  public final PBFixed32Field fixed32_self_client_ip = PBField.initFixed32(0);
  public final PBUInt64Field uint64_self_uin = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\cs\longconn\voip\hd_video_voip_2$CmdPhoneSpeedTestReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */