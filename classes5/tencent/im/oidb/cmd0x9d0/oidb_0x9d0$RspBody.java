package tencent.im.oidb.cmd0x9d0;

import appoint.define.appoint_define.FeedInfo;
import appoint.define.appoint_define.PublisherInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x9d0$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public appoint_define.PublisherInfo msg_user_info = new appoint_define.PublisherInfo();
  public final PBRepeatMessageField rpt_msg_feeds = PBField.initRepeatMessage(appoint_define.FeedInfo.class);
  public final PBStringField str_error_tips = PBField.initString("");
  public final PBUInt32Field uint32_completed = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40 }, new String[] { "str_error_tips", "msg_user_info", "rpt_msg_feeds", "bytes_cookie", "uint32_completed" }, new Object[] { "", null, null, localByteStringMicro, Integer.valueOf(0) }, RspBody.class);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x9d0\oidb_0x9d0$RspBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */