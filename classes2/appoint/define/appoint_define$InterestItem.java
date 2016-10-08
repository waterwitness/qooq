package appoint.define;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class appoint_define$InterestItem
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 64, 72, 82, 90 }, new String[] { "uint64_tag_id", "str_tag_name", "str_tag_icon_url", "str_tag_href", "str_tag_back_color", "str_tag_font_color", "str_tag_vid", "uint32_tag_type", "uint32_add_time", "str_tag_category", "str_tag_other_url" }, new Object[] { Long.valueOf(0L), "", "", "", "", "", "", Integer.valueOf(0), Integer.valueOf(0), "", "" }, InterestItem.class);
  public final PBStringField str_tag_back_color = PBField.initString("");
  public final PBStringField str_tag_category = PBField.initString("");
  public final PBStringField str_tag_font_color = PBField.initString("");
  public final PBStringField str_tag_href = PBField.initString("");
  public final PBStringField str_tag_icon_url = PBField.initString("");
  public final PBStringField str_tag_name = PBField.initString("");
  public final PBStringField str_tag_other_url = PBField.initString("");
  public final PBStringField str_tag_vid = PBField.initString("");
  public final PBUInt32Field uint32_add_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_tag_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_tag_id = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\appoint\define\appoint_define$InterestItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */