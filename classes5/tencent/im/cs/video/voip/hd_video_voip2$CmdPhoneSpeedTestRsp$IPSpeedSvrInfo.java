package tencent.im.cs.video.voip;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class hd_video_voip2$CmdPhoneSpeedTestRsp$IPSpeedSvrInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 13, 16 }, new String[] { "fixed32_server_ip", "uint32_server_port" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, IPSpeedSvrInfo.class);
  public final PBFixed32Field fixed32_server_ip = PBField.initFixed32(0);
  public final PBUInt32Field uint32_server_port = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\cs\video\voip\hd_video_voip2$CmdPhoneSpeedTestRsp$IPSpeedSvrInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */