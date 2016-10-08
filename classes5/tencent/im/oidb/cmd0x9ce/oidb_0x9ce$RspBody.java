package tencent.im.oidb.cmd0x9ce;

import appoint.define.appoint_define.FeedInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_0x9ce$RspBody
  extends MessageMicro
{
  public static final int MSG_FEED_INFO_FIELD_NUMBER = 2;
  public static final int STR_ERROR_TIPS_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "str_error_tips", "msg_feed_info" }, new Object[] { "", null }, RspBody.class);
  public appoint_define.FeedInfo msg_feed_info = new appoint_define.FeedInfo();
  public final PBStringField str_error_tips = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x9ce\oidb_0x9ce$RspBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */