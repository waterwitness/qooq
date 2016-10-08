package tencent.im.cs.video.voip;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class hd_video_voip2$CmdPhoneMultiChatCreateReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "msg_from_tel", "msg_to_tel", "uint64_balance" }, new Object[] { null, null, Long.valueOf(0L) }, CmdPhoneMultiChatCreateReqBody.class);
  public hd_video_voip2.TelInfo msg_from_tel = new hd_video_voip2.TelInfo();
  public final PBRepeatMessageField msg_to_tel = PBField.initRepeatMessage(hd_video_voip2.TelInfo.class);
  public final PBUInt64Field uint64_balance = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\cs\video\voip\hd_video_voip2$CmdPhoneMultiChatCreateReqBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */