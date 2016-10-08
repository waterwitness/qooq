package com.tencent.qidian.proto;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mobileqq_qidian$PubAccItem
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 50, 56, 64, 72, 82, 90, 98 }, new String[] { "uint32_type", "str_uin", "uint32_verity", "str_name", "str_desc", "str_verify_data", "uint64_state", "uint32_grade", "uint64_display", "str_extra", "str_face_url", "str_qr_url" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), "", "", "", Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), "", "", "" }, PubAccItem.class);
  public final PBStringField str_desc = PBField.initString("");
  public final PBStringField str_extra = PBField.initString("");
  public final PBStringField str_face_url = PBField.initString("");
  public final PBStringField str_name = PBField.initString("");
  public final PBStringField str_qr_url = PBField.initString("");
  public final PBStringField str_uin = PBField.initString("");
  public final PBStringField str_verify_data = PBField.initString("");
  public final PBUInt32Field uint32_grade = PBField.initUInt32(0);
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_verity = PBField.initUInt32(0);
  public final PBUInt64Field uint64_display = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_state = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\qidian\proto\mobileqq_qidian$PubAccItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */