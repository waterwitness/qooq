package appoint.define;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class appoint_define$ADFeedContent
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48, 58 }, new String[] { "msg_user_info", "rpt_str_pic_url", "msg_text", "str_attend_info", "str_action_url", "uint32_publish_time", "msg_hot_topic_list" }, new Object[] { null, "", null, "", "", Integer.valueOf(0), null }, ADFeedContent.class);
  public appoint_define.HotTopicList msg_hot_topic_list = new appoint_define.HotTopicList();
  public appoint_define.RichText msg_text = new appoint_define.RichText();
  public appoint_define.UserInfo msg_user_info = new appoint_define.UserInfo();
  public final PBRepeatField rpt_str_pic_url = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField str_action_url = PBField.initString("");
  public final PBStringField str_attend_info = PBField.initString("");
  public final PBUInt32Field uint32_publish_time = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\appoint\define\appoint_define$ADFeedContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */