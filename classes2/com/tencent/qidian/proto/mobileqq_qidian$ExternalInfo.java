package com.tencent.qidian.proto;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mobileqq_qidian$ExternalInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 48, 56, 64, 72, 82, 90, 98, 106, 114, 122, 128, 136, 144 }, new String[] { "uint64_uin", "str_external_nick", "str_external_icon", "str_external_sign", "uint32_external_gender", "uint64_external_country", "uint64_external_province", "uint64_external_city", "uint64_external_district", "str_external_job", "str_external_tel", "str_external_mobile", "str_external_mail", "rpt_msg_pubacc_item", "rpt_msg_group_item", "uint64_master_uin", "uint32_verity", "uint32_entcallshow" }, new Object[] { Long.valueOf(0L), "", "", "", Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), "", "", "", "", null, null, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, ExternalInfo.class);
  public final PBRepeatMessageField rpt_msg_group_item = PBField.initRepeatMessage(mobileqq_qidian.GroupItem.class);
  public final PBRepeatMessageField rpt_msg_pubacc_item = PBField.initRepeatMessage(mobileqq_qidian.PubAccItem.class);
  public final PBStringField str_external_icon = PBField.initString("");
  public final PBStringField str_external_job = PBField.initString("");
  public final PBStringField str_external_mail = PBField.initString("");
  public final PBStringField str_external_mobile = PBField.initString("");
  public final PBStringField str_external_nick = PBField.initString("");
  public final PBStringField str_external_sign = PBField.initString("");
  public final PBStringField str_external_tel = PBField.initString("");
  public final PBUInt32Field uint32_entcallshow = PBField.initUInt32(0);
  public final PBUInt32Field uint32_external_gender = PBField.initUInt32(0);
  public final PBUInt32Field uint32_verity = PBField.initUInt32(0);
  public final PBUInt64Field uint64_external_city = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_external_country = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_external_district = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_external_province = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_master_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\qidian\proto\mobileqq_qidian$ExternalInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */