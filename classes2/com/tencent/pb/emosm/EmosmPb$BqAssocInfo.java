package com.tencent.pb.emosm;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class EmosmPb$BqAssocInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 50, 58, 66, 74, 82 }, new String[] { "u32_tab_id", "str_tab_name", "u32_tab_feetype", "i32_tab_type", "i32_tab_ringtype", "str_item_id", "str_item_name", "str_item_key", "rpt_str_item_keyword", "rpt_support_size" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "", "", null }, BqAssocInfo.class);
  public final PBInt32Field i32_tab_ringtype = PBField.initInt32(0);
  public final PBInt32Field i32_tab_type = PBField.initInt32(0);
  public final PBRepeatField rpt_str_item_keyword = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBRepeatMessageField rpt_support_size = PBField.initRepeatMessage(EmosmPb.SupportSize.class);
  public final PBStringField str_item_id = PBField.initString("");
  public final PBStringField str_item_key = PBField.initString("");
  public final PBStringField str_item_name = PBField.initString("");
  public final PBStringField str_tab_name = PBField.initString("");
  public final PBUInt32Field u32_tab_feetype = PBField.initUInt32(0);
  public final PBUInt32Field u32_tab_id = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\emosm\EmosmPb$BqAssocInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */