package tencent.im.oidb.cmd0x9d1;

import appoint.define.appoint_define.UserFeed;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x9d1$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "str_error_tips", "msg_feeds", "uint64_tinyid" }, new Object[] { "", null, Long.valueOf(0L) }, RspBody.class);
  public appoint_define.UserFeed msg_feeds = new appoint_define.UserFeed();
  public final PBStringField str_error_tips = PBField.initString("");
  public final PBUInt64Field uint64_tinyid = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x9d1\oidb_0x9d1$RspBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */