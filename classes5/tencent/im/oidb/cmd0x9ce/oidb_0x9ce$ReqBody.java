package tencent.im.oidb.cmd0x9ce;

import appoint.define.appoint_define.FeedContent;
import appoint.define.appoint_define.LBSInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x9ce$ReqBody
  extends MessageMicro
{
  public static final int MSG_FEED_CONTENT_FIELD_NUMBER = 2;
  public static final int MSG_LBS_INFO_FIELD_NUMBER = 1;
  public static final int UINT64_TOPIC_ID_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "msg_lbs_info", "msg_feed_content", "uint64_topic_id" }, new Object[] { null, null, Long.valueOf(0L) }, ReqBody.class);
  public appoint_define.FeedContent msg_feed_content = new appoint_define.FeedContent();
  public appoint_define.LBSInfo msg_lbs_info = new appoint_define.LBSInfo();
  public final PBUInt64Field uint64_topic_id = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x9ce\oidb_0x9ce$ReqBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */