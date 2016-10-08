package tencent.im.cs.cmd0x3fe;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x3fe$qun_video_identity_score
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56 }, new String[] { "uint32_identity_score", "uint32_time", "uint32_send_flower_num", "uint32_recv_flower_num", "uint32_send_gift_num", "uint32_recv_gift_num", "uint32_online_time" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, qun_video_identity_score.class);
  public final PBUInt32Field uint32_identity_score = PBField.initUInt32(0);
  public final PBUInt32Field uint32_online_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_recv_flower_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_recv_gift_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_send_flower_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_send_gift_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_time = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\cs\cmd0x3fe\cmd0x3fe$qun_video_identity_score.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */