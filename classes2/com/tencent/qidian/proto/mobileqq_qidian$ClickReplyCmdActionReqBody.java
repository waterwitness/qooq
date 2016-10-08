package com.tencent.qidian.proto;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class mobileqq_qidian$ClickReplyCmdActionReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 33, 41 }, new String[] { "str_key", "uint32_type", "bool_is_need_lbs", "double_latitude", "double_longitude" }, new Object[] { "", Integer.valueOf(0), Boolean.valueOf(false), Double.valueOf(0.0D), Double.valueOf(0.0D) }, ClickReplyCmdActionReqBody.class);
  public final PBBoolField bool_is_need_lbs = PBField.initBool(false);
  public final PBDoubleField double_latitude = PBField.initDouble(0.0D);
  public final PBDoubleField double_longitude = PBField.initDouble(0.0D);
  public final PBStringField str_key = PBField.initString("");
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\qidian\proto\mobileqq_qidian$ClickReplyCmdActionReqBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */