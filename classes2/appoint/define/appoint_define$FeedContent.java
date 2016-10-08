package appoint.define;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class appoint_define$FeedContent
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 42, 50, 56, 160, 168, 178, 184, 194 }, new String[] { "rpt_str_pic_url", "msg_text", "str_href_url", "str_group_name", "str_group_bulletin", "uint32_feed_type", "uint32_effective_time", "uint32_expiation_time", "msg_locale", "uint32_feeds_index", "msg_ad" }, new Object[] { "", null, "", "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), null }, FeedContent.class);
  public appoint_define.ADFeed msg_ad = new appoint_define.ADFeed();
  public appoint_define.LocaleInfo msg_locale = new appoint_define.LocaleInfo();
  public appoint_define.RichText msg_text = new appoint_define.RichText();
  public final PBRepeatField rpt_str_pic_url = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField str_group_bulletin = PBField.initString("");
  public final PBStringField str_group_name = PBField.initString("");
  public final PBStringField str_href_url = PBField.initString("");
  public final PBUInt32Field uint32_effective_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_expiation_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_feed_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_feeds_index = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\appoint\define\appoint_define$FeedContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */