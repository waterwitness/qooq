package com.tencent.proto.lbsshare;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class LBSShare$DPBiz
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 56, 66, 72, 80 }, new String[] { "id", "name", "logo", "url", "biz_zone", "category", "rate", "avg_price", "has_tuan", "has_quan" }, new Object[] { "", "", "", "", "", "", Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0) }, DPBiz.class);
  public final PBStringField avg_price = PBField.initString("");
  public final PBStringField biz_zone = PBField.initString("");
  public final PBStringField category = PBField.initString("");
  public final PBUInt32Field has_quan = PBField.initUInt32(0);
  public final PBUInt32Field has_tuan = PBField.initUInt32(0);
  public final PBStringField id = PBField.initString("");
  public final PBStringField logo = PBField.initString("");
  public final PBStringField name = PBField.initString("");
  public final PBUInt32Field rate = PBField.initUInt32(0);
  public final PBStringField url = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\proto\lbsshare\LBSShare$DPBiz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */