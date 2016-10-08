package appoint.define;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class appoint_define$Feed
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "msg_user_info", "msg_feed_info", "uint32_owner_flag" }, new Object[] { null, null, Integer.valueOf(0) }, Feed.class);
  public appoint_define.FeedInfo msg_feed_info = new appoint_define.FeedInfo();
  public appoint_define.PublisherInfo msg_user_info = new appoint_define.PublisherInfo();
  public final PBUInt32Field uint32_owner_flag = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\appoint\define\appoint_define$Feed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */