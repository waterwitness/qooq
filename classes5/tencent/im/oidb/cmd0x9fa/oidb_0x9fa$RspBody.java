package tencent.im.oidb.cmd0x9fa;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x9fa$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_errMsg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField msg_channel = PBField.initRepeatMessage(oidb_0x9fa.ChannelInfo.class);
  public oidb_0x9fa.FeedbackData msg_feed_data = new oidb_0x9fa.FeedbackData();
  public final PBUInt32Field uint32_cmdid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  public oidb_0x9fa.SimilarGroupWebInfo web_info = new oidb_0x9fa.SimilarGroupWebInfo();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50 }, new String[] { "uint32_cmdid", "uint32_result", "bytes_errMsg", "msg_feed_data", "msg_channel", "web_info" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, null, null, null }, RspBody.class);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x9fa\oidb_0x9fa$RspBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */