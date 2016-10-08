package com.tencent.pb.emosm;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class EmosmPb$SubCmd0x5RspBQRecommend
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48, 56, 66, 72, 80, 88 }, new String[] { "st_tab_info", "str_morebq_img_url", "bool_update_flag", "int32_last_recommend_version", "bool_recommend_show_flag", "int32_show_num", "int32_exposure_num", "st_new_tab_info", "int32_red_point_flag", "int32_light_out_interval", "int32_req_frequency" }, new Object[] { null, "", Boolean.valueOf(false), Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, SubCmd0x5RspBQRecommend.class);
  public final PBBoolField bool_recommend_show_flag = PBField.initBool(false);
  public final PBBoolField bool_update_flag = PBField.initBool(false);
  public final PBInt32Field int32_exposure_num = PBField.initInt32(0);
  public final PBInt32Field int32_last_recommend_version = PBField.initInt32(0);
  public final PBInt32Field int32_light_out_interval = PBField.initInt32(0);
  public final PBInt32Field int32_red_point_flag = PBField.initInt32(0);
  public final PBInt32Field int32_req_frequency = PBField.initInt32(0);
  public final PBInt32Field int32_show_num = PBField.initInt32(0);
  public final PBRepeatMessageField st_new_tab_info = PBField.initRepeatMessage(EmosmPb.STRecommendTabInfo.class);
  public final PBRepeatMessageField st_tab_info = PBField.initRepeatMessage(EmosmPb.STRecommendTabInfo.class);
  public final PBStringField str_morebq_img_url = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\emosm\EmosmPb$SubCmd0x5RspBQRecommend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */