package com.tencent.proto.lbsshare;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class LBSShare$LocationReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 48, 56, 64, 74 }, new String[] { "lat", "lng", "coordinate", "keyword", "category", "page", "count", "requireMyLbs", "imei" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "" }, LocationReq.class);
  public final PBStringField category = PBField.initString("");
  public final PBUInt32Field coordinate = PBField.initUInt32(0);
  public final PBUInt32Field count = PBField.initUInt32(0);
  public final PBStringField imei = PBField.initString("");
  public final PBStringField keyword = PBField.initString("");
  public final PBUInt32Field lat = PBField.initUInt32(0);
  public final PBUInt32Field lng = PBField.initUInt32(0);
  public final PBUInt32Field page = PBField.initUInt32(0);
  public final PBUInt32Field requireMyLbs = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\proto\lbsshare\LBSShare$LocationReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */